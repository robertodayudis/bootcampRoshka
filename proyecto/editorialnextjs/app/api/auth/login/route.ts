import { NextResponse } from "next/server";

export async function POST(req: Request) {
  try {
    const { username, password } = await req.json();

    const backendUrl = process.env.BACKEND_URL;
    if (!backendUrl) {
      return NextResponse.json(
        { message: "BACKEND_URL is not configured" },
        { status: 500 }
      );
    }

    const r = await fetch(`${backendUrl}/api/auth/login`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ username, password }),
    });

    if (r.status === 401) {
      return NextResponse.json(
        { message: "Credenciales inválidas" },
        { status: 401 }
      );
    }

    if (!r.ok) {
      const text = await r.text().catch(() => "");
      return NextResponse.json(
        { message: "Error al autenticar", details: text },
        { status: 502 }
      );
    }

    const data = (await r.json()) as { accessToken: string };

    const res = NextResponse.json({ ok: true });

    // httpOnly cookie: no JS access (más seguro)
    res.cookies.set("accessToken", data.accessToken, {
      httpOnly: true,
      sameSite: "lax",
      secure: false, // en prod: true (https)
      path: "/",
      maxAge: 60 * 60, // 1 hora (ajustá si tu JWT dura menos)
    });

    return res;
  } catch {
    return NextResponse.json({ message: "Bad request" }, { status: 400 });
  }
}

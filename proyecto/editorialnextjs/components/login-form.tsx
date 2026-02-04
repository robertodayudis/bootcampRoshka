"use client";

import axios from "axios";
import * as React from "react";
import { useRouter } from "next/navigation";
import { login } from "@/services/services";
import { setToken } from "@/lib/auth/storage";


import { cn } from "@/lib/utils";
import { Button } from "@/components/ui/button";
import { Card, CardContent } from "@/components/ui/card";
import {
  Field,
  FieldDescription,
  FieldGroup,
  FieldLabel,
} from "@/components/ui/field";
import { Input } from "@/components/ui/input";

export function LoginForm({
  className,
  ...props
}: React.ComponentProps<"div">) {
  const router = useRouter();

  const [username, setUsername] = React.useState("");
  const [password, setPassword] = React.useState("");
  const [loading, setLoading] = React.useState(false);
  const [error, setError] = React.useState<string | null>(null);

  async function onSubmit(e: React.FormEvent) {
    e.preventDefault();
    setError(null);
    setLoading(true);
  
    try {
      const data = await login({ username, password });
  
      // Guardar token en localStorage
      setToken(data.accessToken);
  
      // Ir al dashboard (o "/")
      router.push("/dashboard");
      router.refresh();
    } catch {
      setError("No se pudo iniciar sesión.");
    }
     finally {
      setLoading(false);
    }
  }
  

  return (
    <div className={cn("flex flex-col gap-6", className)} {...props}>
      <Card className="overflow-hidden p-0">
        <CardContent className="grid p-0 md:grid-cols-2">
          <form className="p-6 md:p-8" onSubmit={onSubmit}>
            <FieldGroup>
              <div className="flex flex-col items-center gap-2 text-center">
                <h1 className="text-2xl font-bold">Bienvenido</h1>
                <p className="text-muted-foreground text-balance">
                  Ingrese a su cuenta para continuar
                </p>
              </div>

              <Field>
                <FieldLabel htmlFor="username">Nombre de usuario</FieldLabel>
                <Input
                  id="username"
                  type="text"
                  placeholder="Ingrese su nombre"
                  value={username}
                  onChange={(e) => setUsername(e.target.value)}
                  autoComplete="username"
                  required
                />
              </Field>

              <Field>
                <div className="flex items-center">
                  <FieldLabel htmlFor="password">Contraseña</FieldLabel>
                  <a
                    href="#"
                    className="ml-auto text-sm underline-offset-2 hover:underline"
                  >
                    Olvidó su contraseña?
                  </a>
                </div>
                <Input
                  id="password"
                  type="password"
                  placeholder="Ingrese contraseña"
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                  autoComplete="current-password"
                  required
                />
              </Field>

              {error ? (
                <FieldDescription className="text-center text-destructive">
                  {error}
                </FieldDescription>
              ) : null}

              <Field>
                <Button type="submit" className="w-full" disabled={loading}>
                  {loading ? "Ingresando..." : "Ingresar"}
                </Button>
              </Field>

              <FieldDescription className="text-center">
                No tiene cuenta? <a href="#">Regístrese</a>
              </FieldDescription>
            </FieldGroup>
          </form>

          <div className="bg-muted relative hidden md:block">
            <img
              src="/login.svg"
              alt="Image"
              className="absolute inset-0 h-full w-full object-cover dark:brightness-[0.2] dark:grayscale"
            />
          </div>
        </CardContent>
      </Card>

      <FieldDescription className="px-6 text-center">
        Si lees esto, surge tu pendejaaaa 🤪{" "}
        <a
          href="https://youtu.be/dQw4w9WgXcQ?si=a5fkJUz8wYn3whvT"
          target="_blank"
          rel="noopener noreferrer"
          className="underline underline-offset-2"
        >
          Ver más
        </a>
        .
      </FieldDescription>
    </div>
  );
}

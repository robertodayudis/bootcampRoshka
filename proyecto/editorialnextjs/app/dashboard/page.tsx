"use client";

import * as React from "react";
import { useRouter } from "next/navigation";
import axios from "axios";


import { getToken, removeToken } from "@/lib/auth/storage";
import { getPrestamos, type Prestamo } from "@/services/prestamosServices";

import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";
import { Button } from "@/components/ui/button";

export default function DashboardPage() {
  const router = useRouter();

  const [ready, setReady] = React.useState(false);
  const [loading, setLoading] = React.useState(true);
  const [error, setError] = React.useState<string | null>(null);
  const [prestamos, setPrestamos] = React.useState<Prestamo[]>([]);

  React.useEffect(() => {
    const token = getToken();
    if (!token) {
      router.replace("/login");
      return;
    }

    setReady(true);

    (async () => {
      try {
        const data = await getPrestamos();
        setPrestamos(data);
      } catch (err: unknown) {
        // Si el backend devuelve 401, normalmente es token expirado o inválido
        if (axios.isAxiosError(err) && err.response?.status === 401) {
          removeToken();
          router.replace("/login");
          return;
        }

        // Error genérico
        setError("No se pudieron cargar los préstamos.");
      } finally {
        setLoading(false);
      }
    })();
  }, [router]);

  if (!ready) return null;

  return (
    <div className="p-6 space-y-4">
      <Card>
        <CardHeader className="flex flex-row items-center justify-between">
          <CardTitle>Préstamos de Libros</CardTitle>

          <Button
            variant="outline"
            onClick={() => {
              removeToken();
              router.replace("/login");
            }}
          >
            Logout
          </Button>
        </CardHeader>

        <CardContent>
          {loading ? <p>Cargando...</p> : null}

          {error ? <p className="text-destructive">{error}</p> : null}

          {!loading && !error && prestamos.length === 0 ? (
            <p>No hay préstamos registrados.</p>
          ) : null}

          {!loading && !error && prestamos.length > 0 ? (
            <Table>
              <TableHeader>
                <TableRow>
                  <TableHead>Fecha</TableHead>
                  <TableHead>Colegio</TableHead>
                  <TableHead>Profesor</TableHead>
                  <TableHead>Curso</TableHead>
                  <TableHead>Aula</TableHead>
                  <TableHead>Asignatura</TableHead>
                  <TableHead>Libros</TableHead>
                </TableRow>
              </TableHeader>

              <TableBody>
                {prestamos.map((p) => (
                  <TableRow key={p.id}>
                    <TableCell>{p.fechaPrestamo}</TableCell>
                    <TableCell>{p.colegioNombre}</TableCell>
                    <TableCell>{p.profesorNombre}</TableCell>
                    <TableCell>{p.cursoNombre}</TableCell>
                    <TableCell>{p.aulaNombre}</TableCell>
                    <TableCell>{p.asignaturaNombre}</TableCell>
                    <TableCell>
                      <ul className="list-disc pl-4">
                        {p.libros.map((l) => (
                          <li key={l.libroId}>
                            {l.libroNombre} — {l.editorialNombre}
                          </li>
                        ))}
                      </ul>
                    </TableCell>
                  </TableRow>
                ))}
              </TableBody>
            </Table>
          ) : null}
        </CardContent>
      </Card>
    </div>
  );
}

import axios from "axios";
import { getToken } from "@/lib/auth/storage";

export type PrestamoLibro = {
  libroId: number;
  libroNombre: string;
  editorialId: number;
  editorialNombre: string;
};

export type Prestamo = {
  id: number;
  fechaPrestamo: string;
  colProfeId: number;
  colegioNombre: string;
  profesorNombre: string;
  asignaturaId: number;
  asignaturaNombre: string;
  aulaId: number;
  aulaNombre: string;
  cursoId: number;
  cursoNombre: string;
  libros: PrestamoLibro[];
};

const BASE_URL = "http://localhost:8080";

export async function getPrestamos(): Promise<Prestamo[]> {
  const token = getToken();

  // Si no hay token, ni intentamos pegar al backend
  if (!token) {
    throw new Error("NO_TOKEN");
  }

  const res = await axios.get<Prestamo[]>(`${BASE_URL}/api/prestamos`, {
    headers: {
      Authorization: `Bearer ${token}`,
    },
  });

  return res.data;
}

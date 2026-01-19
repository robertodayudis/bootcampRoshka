import dao.*;
import models.*;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String url  = System.getenv().getOrDefault("DB_URL",  "jdbc:postgresql://localhost:5432/normalizacionroshka");
        String user = System.getenv().getOrDefault("DB_USER", "postgres");
        String pass = System.getenv().getOrDefault("DB_PASS", "postgres");

        try {
            ColegioDao colegioDao = new ColegioDao(url, user, pass);
            ProfesorDao profesorDao = new ProfesorDao(url, user, pass);
            ColprofeDao colprofeDao = new ColprofeDao(url, user, pass);

            AsignaturaDao asignaturaDao = new AsignaturaDao(url, user, pass);
            AulaDao aulaDao = new AulaDao(url, user, pass);
            CursoDao cursoDao = new CursoDao(url, user, pass);

            PrestamolibroDao prestamoDao = new PrestamolibroDao(url, user, pass);

            // Creamos datos de ejemplo
            Colegio col = new Colegio("Colegio Nacional Asuncion");
            colegioDao.create(col);

            Profesor prof = new Profesor("Prof. Juan Perez");
            profesorDao.create(prof);

            Asignatura asig = new Asignatura("Matematica");
            asignaturaDao.create(asig);

            Aula aula = new Aula("Aula A1");
            aulaDao.create(aula);

            Curso curso = new Curso("1er Grado");
            cursoDao.create(curso);

            Colprofe cp = new Colprofe(col.getId(), prof.getId());
            colprofeDao.create(cp);

            // Creamos un prestamo
            PrestamoLibro pl = new PrestamoLibro(
                    cp.getId(),
                    asig.getId(),
                    aula.getId(),
                    curso.getId(),
                    LocalDate.now()
            );
            prestamoDao.create(pl);

            Colprofe cpDb = colprofeDao.findById(pl.getColprofeId());
            Colegio colDb = colegioDao.findById(cpDb.getColegioId());
            Profesor profDb = profesorDao.findById(cpDb.getProfesorId());

            Asignatura asigDb = asignaturaDao.findById(pl.getAsignaturaId());
            Aula aulaDb = aulaDao.findById(pl.getAulaId());
            Curso cursoDb = cursoDao.findById(pl.getCursoId());

            System.out.println();
            System.out.println("PRESTAMO_LIBRO #" + pl.getId());
            System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.println("| Colegio            | Profesor           | Asignatura             | Aula     | Curso      | Fecha      |");
            System.out.println("--------------------------------------------------------------------------------------------------------");

            System.out.printf("| %-18.18s | %-18.18s | %-22.22s | %-8.8s | %-10.10s | %-10s |%n",
                    colDb.getNombre(),
                    profDb.getNombre(),
                    asigDb.getNombre(),
                    aulaDb.getNombre(),
                    cursoDb.getNombre(),
                    pl.getFechaPrestamo()
            );

            System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.println();

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

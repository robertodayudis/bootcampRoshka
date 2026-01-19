package dao;

import models.PrestamoLibro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrestamolibroDao {
    private static final String TABLE = " prestamolibros.prestamo_libro";
    private final String url;
    private final String user;
    private final String pass;

    public PrestamolibroDao(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    // CREATE
    public PrestamoLibro create(PrestamoLibro prestamolibro) throws SQLException {
        String sql =
                "INSERT INTO " + TABLE + " ( id_colprofe, id_asignatura, id_aula, id_curso, fecha_prestamo) " + "VALUES (?, ?, ?, ?, ?) RETURNING id";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, prestamolibro.getColprofeId());
            ps.setInt(2, prestamolibro.getAsignaturaId());
            ps.setInt(3, prestamolibro.getAulaId());
            ps.setInt(4, prestamolibro.getCursoId());
            ps.setDate(5, java.sql.Date.valueOf(prestamolibro.getFechaPrestamo()));

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) prestamolibro.setId(rs.getInt("id"));
            }
        }
        return prestamolibro;
    }

    // READ
    public PrestamoLibro findById(int id) throws SQLException {
        String sql = "SELECT id, id_colprofe, id_asignatura, id_aula, id_curso, fecha_prestamo " +
                "FROM " + TABLE + " WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new PrestamoLibro(
                            rs.getInt("id"),
                            rs.getInt("id_colprofe"),
                            rs.getInt("id_asignatura"),
                            rs.getInt("id_aula"),
                            rs.getInt("id_curso"),
                            rs.getDate("fecha_prestamo").toLocalDate()
                    );
                }
                return null;
            }
        }
    }

    // READ ALL
    public List<PrestamoLibro> findAll() throws SQLException {
        String sql = "SELECT id, id_colprofe, id_asignatura, id_aula, id_curso, fecha_prestamo " +
                "FROM " + TABLE + " ORDER BY id ";

        List<PrestamoLibro> out = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                out.add(new PrestamoLibro(
                        rs.getInt("id"),
                        rs.getInt("id_colprofe"),
                        rs.getInt("id_asignatura"),
                        rs.getInt("id_aula"),
                        rs.getInt("id_curso"),
                        rs.getDate("fecha_prestamo").toLocalDate()
                ));
            }
        }
        return out;
    }

    // UPDATE
    public int update(PrestamoLibro prestamolibro) throws SQLException {
        if (prestamolibro.getId() == null) throw new IllegalArgumentException("Se necesita el id para update");

        String sql = "UPDATE " + TABLE +
                " SET id_colprofe = ?, id_asignatura = ?, id_aula = ?, id_curso = ?, fecha_prestamo = ? " +
                " WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, prestamolibro.getColprofeId());
            ps.setInt(2, prestamolibro.getAsignaturaId());
            ps.setInt(3, prestamolibro.getAulaId());
            ps.setInt(4, prestamolibro.getCursoId());
            ps.setDate(5, java.sql.Date.valueOf(prestamolibro.getFechaPrestamo()));
            ps.setInt(6, prestamolibro.getId());

            return ps.executeUpdate();
        }
    }

}

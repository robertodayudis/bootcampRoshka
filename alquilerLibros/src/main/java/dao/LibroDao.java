package dao;

import models.Libro;
import models.PrestamoLibro;

import java.sql.*;
import java.time.LocalDate;

public class LibroDao {
    private static final String TABLE = "ejercicio4.prestamo_libro";
    private final String url;
    private final String user;
    private final String pass;

    public LibroDao(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

//    CREATE
    public Libro Create(Libro libro) throws SQLException {
        String sql = "INSERT INTO " + TABLE + " (nombre, id_editorial, id) VALUES (?, ?) RETURNING id_editorial";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, libro.getEditorialId());
            ps.setString(2, libro.getNombre());

            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) libro.setId(rs.getInt("id"));
            }
        }
        return libro;
    }

//    READ
    public Libro findById(int id) throws SQLException {
        String sql = "SELECT id, id_editorial, nombre FROM " + TABLE + " WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()){

                if (rs.next()) {

                    return new Libro(
                            rs.getInt("id"),
                            rs.getInt("id_editorial"),
                            rs.getString("nombre")
                    );
                }
                return null;
            }
        }
    }
}

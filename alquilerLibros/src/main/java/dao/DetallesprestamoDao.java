package dao;

import models.Detallesprestamo;
import models.Detallesprestamo;
import models.Detallesprestamo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetallesprestamoDao {
    private static final String TABLE = "prestamolibros.Detallesprestamo";
    private final String url;
    private final String user;
    private final String pass;

    public DetallesprestamoDao(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    public Detallesprestamo create(Detallesprestamo dp) throws SQLException {
        String sql = "INSERT INTO " + TABLE + " (id_libro, id_editorial) VALUES (?, ?) RETURNING id";


        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, dp.getLibroId());
            ps.setInt(2, dp.getPrestamoId());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) dp.setId(rs.getInt("id"));
            }
        }
        return dp;
    }


    // READ
    public Detallesprestamo findById(int id) throws SQLException {
        String sql = "SELECT id, id_libro, id_prestamo FROM " + TABLE + " WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Detallesprestamo(
                            rs.getInt("id"),
                            rs.getInt("id_libro"),
                            rs.getInt("id_prestamo")
                    );
                }
                return null;
            }
        }
    }

    // READ ALL
    public List<Detallesprestamo> findAll() throws SQLException {
        String sql = "SELECT id, id_libro, id_prestamo FROM " + TABLE + " ORDER BY id";
        List<Detallesprestamo> out = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                out.add(new Detallesprestamo(
                        rs.getInt("id"),
                        rs.getInt("id_libro"),
                        rs.getInt("id_prestamo")
                ));
            }
        }
        return out;
    }



    // UPDATE
    public int update(Detallesprestamo dep) throws SQLException {
        if (dep.getId() == null) throw new IllegalArgumentException("Se necesita el id para update");

        String sql = "UPDATE " + TABLE + " SET id_colegio = ?, id_profesor = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, dep.getLibroId());
            ps.setInt(2, dep.getPrestamoId());
            ps.setInt(3, dep.getId());

            return ps.executeUpdate();
        }
    }
}

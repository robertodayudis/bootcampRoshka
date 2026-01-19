package dao;

import models.Colegio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ColegioDao {
    private static final String TABLE = "prestamolibros.Colegio";
    private final String url;
    private final String user;
    private final String pass;

    public ColegioDao(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    //    CREATE
    public Colegio create(Colegio Colegio) throws SQLException {
        String sql = "INSERT INTO " + TABLE + " (nombre) VALUES (?) RETURNING id";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, Colegio.getNombre());

            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) Colegio.setId(rs.getInt("id"));
            }
        }
        return Colegio;
    }

    //    READ
    public Colegio findById (int id) throws SQLException {
        String sql = "SELECT id, nombre FROM " + TABLE + " WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql))   {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    return new Colegio(rs.getInt("id"), rs.getString("nombre"));
                }
                return null;
            }
        }
    }

    //    READ ALL
    public List<Colegio> findAll() throws SQLException{
        String sql = "SELECT id, nombre FROM " + TABLE + "ORDER BY id";
        List<Colegio> out = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                out.add(new Colegio(rs.getInt("id"), rs.getString( "nombre")));
            }
        }
        return out;
    }

    //    UPDATE
    public int update(Colegio colegio) throws SQLException {
        if (colegio.getId() == null) throw new IllegalArgumentException("Se necesita el id para update");

        String sql = "UPDATE " + TABLE + " SET nombre = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, colegio.getNombre());
            ps.setInt(2, colegio.getId());

            return ps.executeUpdate();
        }
    }
}



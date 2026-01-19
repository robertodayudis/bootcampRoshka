package dao;

import models.Asignatura;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AsignaturaDao {
    private static final String TABLE = "prestamolibros.Asignatura";
    private final String url;
    private final String user;
    private final String pass;

    public AsignaturaDao(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    //    CREATE
    public Asignatura create(Asignatura Asignatura) throws SQLException {
        String sql = "INSERT INTO " + TABLE + " (nombre) VALUES (?) RETURNING id";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, Asignatura.getNombre());

            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) Asignatura.setId(rs.getInt("id"));
            }
        }
        return Asignatura;
    }

    //    READ
    public Asignatura findById (int id) throws SQLException {
        String sql = "SELECT id, nombre FROM " + TABLE + " WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql))   {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    return new Asignatura(rs.getInt("id"), rs.getString("nombre"));
                }
                return null;
            }
        }
    }

    //    READ ALL
    public List<Asignatura> findAll() throws SQLException{
        String sql = "SELECT id, nombre FROM " + TABLE + "ORDER BY id";
        List<Asignatura> out = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                out.add(new Asignatura(rs.getInt("id"), rs.getString( "nombre")));
            }
        }
        return out;
    }

    //    UPDATE
    public int update(Asignatura asignatura) throws SQLException {
        if (asignatura.getId() == null) throw new IllegalArgumentException("Se necesita el id para update");

        String sql = "UPDATE " + TABLE + " SET nombre = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, asignatura.getNombre());
            ps.setInt(2, asignatura.getId());

            return ps.executeUpdate();
        }
    }
}



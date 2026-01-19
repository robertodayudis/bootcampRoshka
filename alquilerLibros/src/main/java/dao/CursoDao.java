package dao;

import models.Curso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDao {
    private static final String TABLE = "prestamolibros.Curso";
    private final String url;
    private final String user;
    private final String pass;

    public CursoDao(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    //    CREATE
    public Curso create(Curso Curso) throws SQLException {
        String sql = "INSERT INTO " + TABLE + " (nombre) VALUES (?) RETURNING id";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, Curso.getNombre());

            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) Curso.setId(rs.getInt("id"));
            }
        }
        return Curso;
    }

    //    READ
    public Curso findById (int id) throws SQLException {
        String sql = "SELECT id, nombre FROM " + TABLE + " WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql))   {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    return new Curso(rs.getInt("id"), rs.getString("nombre"));
                }
                return null;
            }
        }
    }

    //    READ ALL
    public List<Curso> findAll() throws SQLException{
        String sql = "SELECT id, nombre FROM " + TABLE + "ORDER BY id";
        List<Curso> out = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                out.add(new Curso(rs.getInt("id"), rs.getString( "nombre")));
            }
        }
        return out;
    }

    //    UPDATE
    public int update(Curso curso) throws SQLException {
        if (curso.getId() == null) throw new IllegalArgumentException("Se necesita el id para update");

        String sql = "UPDATE " + TABLE + " SET nombre = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, curso.getNombre());
            ps.setInt(2, curso.getId());

            return ps.executeUpdate();
        }
    }
}



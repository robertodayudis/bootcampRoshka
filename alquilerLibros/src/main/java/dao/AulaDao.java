package dao;

import models.Aula;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AulaDao {
    private static final String TABLE = "prestamolibros.Aula";
    private final String url;
    private final String user;
    private final String pass;

    public AulaDao(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    //    CREATE
    public Aula create(Aula Aula) throws SQLException {
        String sql = "INSERT INTO " + TABLE + " (nombre) VALUES (?) RETURNING id";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, Aula.getNombre());

            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) Aula.setId(rs.getInt("id"));
            }
        }
        return Aula;
    }

    //    READ
    public Aula findById (int id) throws SQLException {
        String sql = "SELECT id, nombre FROM " + TABLE + " WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql))   {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    return new Aula(rs.getInt("id"), rs.getString("nombre"));
                }
                return null;
            }
        }
    }

    //    READ ALL
    public List<Aula> findAll() throws SQLException{
        String sql = "SELECT id, nombre FROM " + TABLE + "ORDER BY id";
        List<Aula> out = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                out.add(new Aula(rs.getInt("id"), rs.getString( "nombre")));
            }
        }
        return out;
    }

    //    UPDATE
    public int update(Aula aula) throws SQLException {
        if (aula.getId() == null) throw new IllegalArgumentException("Se necesita el id para update");

        String sql = "UPDATE " + TABLE + " SET nombre = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, aula.getNombre());
            ps.setInt(2, aula.getId());

            return ps.executeUpdate();
        }
    }
}



package dao;

import models.Profesor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfesorDao {
    private static final String TABLE = "prestamolibros.profesor";
    private final String url;
    private final String user;
    private final String pass;

    public ProfesorDao(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

//    CREATE
    public Profesor create(Profesor profesor) throws SQLException {
        String sql = "INSERT INTO " + TABLE + " (nombre) VALUES (?) RETURNING id";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, profesor.getNombre());

            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) profesor.setId(rs.getInt("id"));
            }
        }
        return profesor;
    }

//    READ
    public Profesor findById (int id) throws SQLException {
        String sql = "SELECT id, nombre FROM " + TABLE + " WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps = conn.prepareStatement(sql))   {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    return new Profesor(rs.getInt("id"), rs.getString("nombre"));
                }
                return null;
            }
        }
    }

//    READ ALL
    public List<Profesor> findAll() throws SQLException{
        String sql = "SELECT id, nombre FROM " + TABLE + "ORDER BY id";
        List<Profesor> out = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                out.add(new Profesor(rs.getInt("id"), rs.getString( "nombre")));
            }
        }
        return out;
    }

//    UPDATE
    public int update(Profesor profesor) throws SQLException {
        if (profesor.getId() == null) throw new IllegalArgumentException("Se necesita el id para update");

        String sql = "UPDATE " + TABLE + " SET nombre = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, profesor.getNombre());
            ps.setInt(2, profesor.getId());

            return ps.executeUpdate();
        }
    }

}



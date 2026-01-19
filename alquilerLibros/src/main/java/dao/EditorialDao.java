package dao;

import models.Editorial;
import models.Profesor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EditorialDao {
    private static final String TABLE = "ejercicio4.editorial";
    private final String url;
    private final String user;
    private final String pass;

    public EditorialDao(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

//    CREATE
    public Editorial create(Editorial editorial) throws SQLException{
        String sql = "INSERT INTO" + TABLE + " (nombre) VALUES (?) RETURNING id";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(url)) {

            ps.setString(1, editorial.getNombre());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) editorial.setId(rs.getInt("id"));
            }
        }
        return editorial;
    }

//    READ
    public Editorial findById (int id) throws SQLException {
        String sql = "SELECT id, nombre FROM " + TABLE + " WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql))   {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    return new Editorial(rs.getInt("id"), rs.getString("nombre"));
                }
                return null;
            }
        }
    }

// READ ALL
    public List<Editorial> findAll() throws SQLException{
        String sql = "SELECT id, nombre FROM " + TABLE + "ORDER BY id";
        List<Editorial> out = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                out.add(new Editorial(rs.getInt("id"), rs.getString( "nombre")));
            }
        }
        return out;
    }

//    UPDATE

    public int update(Editorial editorial) throws SQLException {
        if (editorial.getId() == null) throw new IllegalArgumentException("Se necesita el id para update");

        String sql = "UPDATE " + TABLE + " SET nombre = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, editorial.getNombre());
            ps.setInt(2, editorial.getId());

            return ps.executeUpdate();
        }
    }
}



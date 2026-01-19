package dao;

import models.Colprofe;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ColprofeDao {
    private static final String TABLE = "prestamolibros.\"colProfe\"";
    private final String url;
    private final String user;
    private final String pass;

    public ColprofeDao(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    // CREATE
    public Colprofe create(Colprofe colprofe) throws SQLException {
        String sql = "INSERT INTO " + TABLE + " (id_colegio, id_profesor) VALUES (?, ?) RETURNING id";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, colprofe.getColegioId());
            ps.setInt(2, colprofe.getProfesorId());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) colprofe.setId(rs.getInt("id"));
            }
        }
        return colprofe;
    }

    // READ
    public Colprofe findById(int id) throws SQLException {
        String sql = "SELECT id, id_colegio, id_profesor FROM " + TABLE + " WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Colprofe(
                            rs.getInt("id"),
                            rs.getInt("id_colegio"),
                            rs.getInt("id_profesor")
                    );
                }
                return null;
            }
        }
    }

    // READ ALL
    public List<Colprofe> findAll() throws SQLException {
        String sql = "SELECT id, id_colegio, id_profesor FROM " + TABLE + " ORDER BY id";
        List<Colprofe> out = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                out.add(new Colprofe(
                        rs.getInt("id"),
                        rs.getInt("id_colegio"),
                        rs.getInt("id_profesor")
                ));
            }
        }
        return out;
    }

    // UPDATE
    public int update(Colprofe colprofe) throws SQLException {
        if (colprofe.getId() == null) throw new IllegalArgumentException("Se necesita el id para update");

        String sql = "UPDATE " + TABLE + " SET id_colegio = ?, id_profesor = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, colprofe.getColegioId());
            ps.setInt(2, colprofe.getProfesorId());
            ps.setInt(3, colprofe.getId());

            return ps.executeUpdate();
        }
    }
}

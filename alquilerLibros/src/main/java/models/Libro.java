package models;

public class Libro {
    private Integer id;
    private Integer editorialId;
    private String nombre;

    public Libro(Integer id, Integer editorialId, String nombre) {
        this.id = id;
        this.editorialId = editorialId;
        this.nombre = nombre;
    }

    public Libro(Integer editorialId, String nombre) {
        this.editorialId = editorialId;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEditorialId() {
        return editorialId;
    }

    public void setEditorialId(Integer editorialId) {
        this.editorialId = editorialId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

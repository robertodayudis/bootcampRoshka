package py.com.acosta.editorial.controllers.dto;

public class LibroResponse {
    private Integer id;
    private String nombre;
    private Integer editorialId;
    private String editorialNombre;

    public LibroResponse() {}

    public LibroResponse(Integer id, String nombre, Integer editorialId, String editorialNombre) {
        this.id = id;
        this.nombre = nombre;
        this.editorialId = editorialId;
        this.editorialNombre = editorialNombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEditorialId() {
        return editorialId;
    }

    public void setEditorialId(Integer editorialId) {
        this.editorialId = editorialId;
    }

    public String getEditorialNombre() {
        return editorialNombre;
    }

    public void setEditorialNombre(String editorialNombre) {
        this.editorialNombre = editorialNombre;
    }
}

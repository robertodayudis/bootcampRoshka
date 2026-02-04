package py.com.acosta.editorial.controllers.dto;

public class LibroUpdateRequest {
    private String nombre;
    private Integer editorialId;

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
}

package py.com.acosta.editorial.controllers.dto;

public class PrestamoLibroItemResponse {
    private Integer libroId;
    private String libroNombre;
    private Integer editorialId;
    private String editorialNombre;

    public PrestamoLibroItemResponse() {}

    public PrestamoLibroItemResponse(Integer libroId, String libroNombre, Integer editorialId, String editorialNombre) {
        this.libroId = libroId;
        this.libroNombre = libroNombre;
        this.editorialId = editorialId;
        this.editorialNombre = editorialNombre;
    }

    public Integer getLibroId() { return libroId; }
    public void setLibroId(Integer libroId) { this.libroId = libroId; }

    public String getLibroNombre() { return libroNombre; }
    public void setLibroNombre(String libroNombre) { this.libroNombre = libroNombre; }

    public Integer getEditorialId() { return editorialId; }
    public void setEditorialId(Integer editorialId) { this.editorialId = editorialId; }

    public String getEditorialNombre() { return editorialNombre; }
    public void setEditorialNombre(String editorialNombre) { this.editorialNombre = editorialNombre; }
}

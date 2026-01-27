package py.com.acosta.editorial.controllers.dto;

public class ColProfeResponse {
    private Integer id;
    private Integer profesorId;
    private String profesorNombre;
    private Integer colegioId;
    private String colegioNombre;

    public ColProfeResponse() {}

    public ColProfeResponse(Integer id, Integer profesorId, String profesorNombre, Integer colegioId, String colegioNombre) {
        this.id = id;
        this.profesorId = profesorId;
        this.profesorNombre = profesorNombre;
        this.colegioId = colegioId;
        this.colegioNombre = colegioNombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Integer profesorId) {
        this.profesorId = profesorId;
    }

    public String getProfesorNombre() {
        return profesorNombre;
    }

    public void setProfesorNombre(String profesorNombre) {
        this.profesorNombre = profesorNombre;
    }

    public Integer getColegioId() {
        return colegioId;
    }

    public void setColegioId(Integer colegioId) {
        this.colegioId = colegioId;
    }

    public String getColegioNombre() {
        return colegioNombre;
    }

    public void setColegioNombre(String colegioNombre) {
        this.colegioNombre = colegioNombre;
    }
}

package py.com.acosta.editorial.controllers.dto;

public class ColProfeCreateRequest {
    private Integer profesorId;
    private Integer colegioId;

    public Integer getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Integer profesorId) {
        this.profesorId = profesorId;
    }

    public Integer getColegioId() {
        return colegioId;
    }

    public void setColegioId(Integer colegioId) {
        this.colegioId = colegioId;
    }
}

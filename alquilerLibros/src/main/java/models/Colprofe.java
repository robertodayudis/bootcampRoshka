package models;

public class Colprofe {
    private Integer id;
    private Integer colegioId;
    private Integer profesorId;

    public Colprofe(Integer id, Integer colegioId, Integer profesorId) {
        this.id = id;
        this.colegioId = colegioId;
        this.profesorId = profesorId;
    }

    public Colprofe(Integer colegioId, Integer profesorId) {
        this.colegioId = colegioId;
        this.profesorId = profesorId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getColegioId() {
        return colegioId;
    }

    public void setColegioId(Integer colegioId) {
        this.colegioId = colegioId;
    }

    public Integer getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Integer profesorId) {
        this.profesorId = profesorId;
    }
}

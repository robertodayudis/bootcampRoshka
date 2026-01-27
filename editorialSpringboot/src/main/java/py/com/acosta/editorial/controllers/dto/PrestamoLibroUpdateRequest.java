package py.com.acosta.editorial.controllers.dto;

import java.util.List;

public class PrestamoLibroUpdateRequest {

    private Integer colProfeId;
    private Integer asignaturaId;
    private Integer aulaId;
    private Integer cursoId;

    // YYYY-MM-DD
    private String fechaPrestamo;

    private List<Integer> librosIds;

    public Integer getColProfeId() { return colProfeId; }
    public void setColProfeId(Integer colProfeId) { this.colProfeId = colProfeId; }

    public Integer getAsignaturaId() { return asignaturaId; }
    public void setAsignaturaId(Integer asignaturaId) { this.asignaturaId = asignaturaId; }

    public Integer getAulaId() { return aulaId; }
    public void setAulaId(Integer aulaId) { this.aulaId = aulaId; }

    public Integer getCursoId() { return cursoId; }
    public void setCursoId(Integer cursoId) { this.cursoId = cursoId; }

    public String getFechaPrestamo() { return fechaPrestamo; }
    public void setFechaPrestamo(String fechaPrestamo) { this.fechaPrestamo = fechaPrestamo; }

    public List<Integer> getLibrosIds() { return librosIds; }
    public void setLibrosIds(List<Integer> librosIds) { this.librosIds = librosIds; }
}

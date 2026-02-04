package py.com.acosta.editorial.controllers.dto;

import java.util.List;

public class PrestamoLibroResponse {

    private Integer id;
    private String fechaPrestamo;
    private Integer colProfeId;
    private String colegioNombre;
    private String profesorNombre;
    private Integer asignaturaId;
    private String asignaturaNombre;
    private Integer aulaId;
    private String aulaNombre;
    private Integer cursoId;
    private String cursoNombre;
    private List<PrestamoLibroItemResponse> libros;

    public PrestamoLibroResponse() {
    }

    public PrestamoLibroResponse(Integer id, String fechaPrestamo, Integer colProfeId, String colegioNombre, String profesorNombre, Integer asignaturaId, String asignaturaNombre, Integer aulaId, String aulaNombre, Integer cursoId, String cursoNombre, List<PrestamoLibroItemResponse> libros) {
        this.id = id;
        this.fechaPrestamo = fechaPrestamo;
        this.colProfeId = colProfeId;
        this.colegioNombre = colegioNombre;
        this.profesorNombre = profesorNombre;
        this.asignaturaId = asignaturaId;
        this.asignaturaNombre = asignaturaNombre;
        this.aulaId = aulaId;
        this.aulaNombre = aulaNombre;
        this.cursoId = cursoId;
        this.cursoNombre = cursoNombre;
        this.libros = libros;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Integer getColProfeId() {
        return colProfeId;
    }

    public void setColProfeId(Integer colProfeId) {
        this.colProfeId = colProfeId;
    }

    public String getColegioNombre() {
        return colegioNombre;
    }

    public void setColegioNombre(String colegioNombre) {
        this.colegioNombre = colegioNombre;
    }

    public String getProfesorNombre() {
        return profesorNombre;
    }

    public void setProfesorNombre(String profesorNombre) {
        this.profesorNombre = profesorNombre;
    }

    public Integer getAsignaturaId() {
        return asignaturaId;
    }

    public void setAsignaturaId(Integer asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

    public String getAsignaturaNombre() {
        return asignaturaNombre;
    }

    public void setAsignaturaNombre(String asignaturaNombre) {
        this.asignaturaNombre = asignaturaNombre;
    }

    public Integer getAulaId() {
        return aulaId;
    }

    public void setAulaId(Integer aulaId) {
        this.aulaId = aulaId;
    }

    public String getAulaNombre() {
        return aulaNombre;
    }

    public void setAulaNombre(String aulaNombre) {
        this.aulaNombre = aulaNombre;
    }

    public Integer getCursoId() {
        return cursoId;
    }

    public void setCursoId(Integer cursoId) {
        this.cursoId = cursoId;
    }

    public String getCursoNombre() {
        return cursoNombre;
    }

    public void setCursoNombre(String cursoNombre) {
        this.cursoNombre = cursoNombre;
    }

    public List<PrestamoLibroItemResponse> getLibros() {
        return libros;
    }

    public void setLibros(List<PrestamoLibroItemResponse> libros) {
        this.libros = libros;
    }
}

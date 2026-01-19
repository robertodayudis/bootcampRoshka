package models;

import java.time.LocalDate;

public class PrestamoLibro {
    private Integer id;
    private Integer colprofeId;
    private Integer asignaturaId;
    private Integer aulaId;
    private Integer cursoId;
    private LocalDate fechaPrestamo;

    public PrestamoLibro(Integer id, Integer colprofeId, Integer asignaturaId, Integer aulaId, Integer cursoId, LocalDate fechaPrestamo) {
        this.id = id;
        this.colprofeId = colprofeId;
        this.asignaturaId = asignaturaId;
        this.aulaId = aulaId;
        this.cursoId = cursoId;
        this.fechaPrestamo = fechaPrestamo;
    }

    public PrestamoLibro(Integer colprofeId, Integer asignaturaId, Integer aulaId, Integer cursoId, LocalDate fechaPrestamo) {
        this.colprofeId = colprofeId;
        this.asignaturaId = asignaturaId;
        this.aulaId = aulaId;
        this.cursoId = cursoId;
        this.fechaPrestamo = fechaPrestamo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getColprofeId() {
        return colprofeId;
    }

    public void setColprofeId(Integer colprofeId) {
        this.colprofeId = colprofeId;
    }

    public Integer getAsignaturaId() {
        return asignaturaId;
    }

    public void setAsignaturaId(Integer asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

    public Integer getAulaId() {
        return aulaId;
    }

    public void setAulaId(Integer aulaId) {
        this.aulaId = aulaId;
    }

    public Integer getCursoId() {
        return cursoId;
    }

    public void setCursoId(Integer cursoId) {
        this.cursoId = cursoId;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
}

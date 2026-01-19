package models;

public class Detallesprestamo {
    private Integer id;
    private Integer libroId;
    private Integer prestamoId;

    public Detallesprestamo(Integer id, Integer libroId, Integer prestamoId) {
        this.id = id;
        this.libroId = libroId;
        this.prestamoId = prestamoId;
    }

    public Detallesprestamo(Integer libroId, Integer prestamoId) {
        this.libroId = libroId;
        this.prestamoId = prestamoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLibroId() {
        return libroId;
    }

    public void setLibroId(Integer libroId) {
        this.libroId = libroId;
    }

    public Integer getPrestamoId() {
        return prestamoId;
    }

    public void setPrestamoId(Integer prestamoId) {
        this.prestamoId = prestamoId;
    }
}

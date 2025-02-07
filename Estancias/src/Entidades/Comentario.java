package Entidades;

public class Comentario {

    private int idComentario;
    private int idCasa;
    private String comentario;

    public Comentario() {
    }

    public Comentario(int idComentarios, int idCasa, String comentario) {
        this.idComentario = idComentarios;
        this.idCasa = idCasa;
        this.comentario = comentario;
    }

    public Comentario(int idCasa, String comentario) {
        this.idCasa = idCasa;
        this.comentario = comentario;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentarios) {
        this.idComentario = idComentarios;
    }

    public int getIdCasa() {
        return idCasa;
    }

    public void setIdCasa(int idCasa) {
        this.idCasa = idCasa;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Comentario [idComentarios=" + idComentario + ", idCasa=" + idCasa + ", comentario=" + comentario + "]";
    }

       
}

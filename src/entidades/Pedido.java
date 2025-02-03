package entidades;

import java.sql.Date;

public class Pedido {

    private int idePedido;
    private int codigoPedido;
    private Date fechaPedido;
    private Date fechaEspera;
    private Date fechaEntrega;

    public Pedido(int idePedido, int codigoPedido, Date fechaPedido, Date fechaEspera, Date fechaEntrega) {
        this.idePedido = idePedido;
        this.codigoPedido = codigoPedido;
        this.fechaPedido = fechaPedido;
        this.fechaEspera = fechaEspera;
        this.fechaEntrega = fechaEntrega;
    }

    public Pedido(int codigoPedido, Date fechaPedido, Date fechaEspera, Date fechaEntrega) {
        this.codigoPedido = codigoPedido;
        this.fechaPedido = fechaPedido;
        this.fechaEspera = fechaEspera;
        this.fechaEntrega = fechaEntrega;
    }

    public Pedido() {
    }

    public int getIdePedido() {
        return idePedido;
    }

    public void setIdePedido(int idePedido) {
        this.idePedido = idePedido;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Date getFechaEspera() {
        return fechaEspera;
    }

    public void setFechaEspera(Date fechaEspera) {
        this.fechaEspera = fechaEspera;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    @Override
    public String toString() {
        return "Pedido [idePedido=" + idePedido + ", codigoPedido=" + codigoPedido + ", fechaPedido=" + fechaPedido
                + ", fechaEspera=" + fechaEspera + ", fechaEntrega=" + fechaEntrega + "]";
    }

    
    
    
}

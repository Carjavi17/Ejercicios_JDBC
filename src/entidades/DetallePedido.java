package entidades;

public class DetallePedido {

    private int idDetallePedido;
    private int idPedido;
    private int idProducto;
    private Double precioUnitario;
    private int cantidad;
    private short numeroLinea;

    public DetallePedido(int idDetallePedido, int idePedido, int idProducto, Double precioUnitario, int cantidad,
            short numeroLinea) {
        this.idDetallePedido = idDetallePedido;
        this.idPedido = idePedido;
        this.idProducto = idProducto;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.numeroLinea = numeroLinea;
    }

    public DetallePedido(int idePedido, int idProducto, Double precioUnitario, int cantidad, short numeroLinea) {
        this.idPedido = idePedido;
        this.idProducto = idProducto;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.numeroLinea = numeroLinea;
    }

    public DetallePedido() {
    }

    public int getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(int idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public int getIdePedido() {
        return idPedido;
    }

    public void setIdePedido(int idePedido) {
        this.idPedido = idePedido;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public short getNumeroLinea() {
        return numeroLinea;
    }

    public void setNumeroLinea(short numeroLinea) {
        this.numeroLinea = numeroLinea;
    }

    @Override
    public String toString() {
        return "DetallePedido [idDetallePedido=" + idDetallePedido + ", idePedido=" + idPedido + ", idProducto="
                + idProducto + ", precioUnitario=" + precioUnitario + ", cantidad=" + cantidad + ", numeroLinea="
                + numeroLinea + "]";
    }

       
}
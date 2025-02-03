package entidades;

public class Oficina {

    private int idOficina;
    private int codigoOficina;
    private String ciudad;
    private String pais;
    private String region;
    private String codigoPostal;
    private String telefono;
    public Oficina(int idOficina, int codigoOficina, String ciudad, String pais, String region, String codigoPostal,
            String telefono) {
        this.idOficina = idOficina;
        this.codigoOficina = codigoOficina;
        this.ciudad = ciudad;
        this.pais = pais;
        this.region = region;
        this.codigoPostal = codigoPostal;
        this.telefono = telefono;
    }
    public Oficina(int codigoOficina, String ciudad, String pais, String region, String codigoPostal, String telefono) {
        this.codigoOficina = codigoOficina;
        this.ciudad = ciudad;
        this.pais = pais;
        this.region = region;
        this.codigoPostal = codigoPostal;
        this.telefono = telefono;
    }
    public Oficina() {
    }
    public int getIdOficina() {
        return idOficina;
    }
    public void setIdOficina(int idOficina) {
        this.idOficina = idOficina;
    }
    public int getCodigoOficina() {
        return codigoOficina;
    }
    public void setCodigoOficina(int codigoOficina) {
        this.codigoOficina = codigoOficina;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public String getCodigoPostal() {
        return codigoPostal;
    }
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    @Override
    public String toString() {
        return "Oficina [idOficina=" + idOficina + ", codigoOficina=" + codigoOficina + ", ciudad=" + ciudad + ", pais="
                + pais + ", region=" + region + ", codigoPostal=" + codigoPostal + ", telefono=" + telefono + "]";
    }


    
    
}

package Servicios;

import java.util.List;

import Entidades.Familia;
import Persistencia.FamiliaDAO;

public class FamiliaServicio {

    private FamiliaDAO fd;
    
   public FamiliaServicio(){
        this.fd = new FamiliaDAO();
    }

    public void listarFamilias(int numHijos, int edadMaxima) throws Exception{


        List<Familia> listaFamilias = fd.listarTodasLasFamilias(numHijos,edadMaxima);
        int contador = 1;

        for (Familia familia : listaFamilias) {
            System.out.println("Familia #"+ contador++ + " Id Familia: " + familia.getIdFamilia() + ", Nombre: " + familia.getNombre() + 
            " Numero de Hijos: " + familia.getNumHijos());
        }

    }

    public void listarFamilias(String email) throws Exception{


        List<Familia> listaFamilias = fd.listarTodasLasFamilias(email);
        int contador = 1;

        for (Familia familia : listaFamilias) {
            System.out.println("Familia #"+ contador++ + " Id Familia: " + familia.getIdFamilia() + ", Nombre: " + familia.getNombre() + 
            " Numero de Hijos: " + familia.getNumHijos());
        }

    }
    
}

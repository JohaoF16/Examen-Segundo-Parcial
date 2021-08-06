
package dominio;

public class Jubilado {
    private String cedula; 
    private String nombres; 
    private int nroAniosAporte;
    

    public Jubilado(String cedula, String nombres, int nroAniosAporte) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.nroAniosAporte = nroAniosAporte;
        
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public int getNroAniosAporte() {
        return nroAniosAporte;
    }

    
    @Override
    public String toString(){
        return this.cedula+"\t"+this.nombres+"\t"+this.nroAniosAporte;
    }
}

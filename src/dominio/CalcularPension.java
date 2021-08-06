package dominio;

public interface CalcularPension {

    int BASICO = 400;
    double INFLACION = 0.18;
    void mensaje();

    default void calcularPensionV(double pi) {
        double total;
        total = pi + (BASICO * 0.15);
        System.out.println(total);
    }
    
    default void calcularPensionD(double pi, double discapacidad) {
        double total;
        total = pi + ((discapacidad / 100) * BASICO);
        System.out.println(total);
    }    
    
    default void calcularPensionP(double pi, String tEmpresa) {
        double stotal, total, adicional;
        if (tEmpresa.equals("publica")) {
            stotal = (pi+(INFLACION*BASICO));
            adicional = stotal*0.05;
            total = stotal+adicional;
            System.out.println(total);
        }
        else{
            stotal = (pi+(INFLACION*BASICO));
            adicional = stotal*0.1;
            total = stotal+adicional;
            System.out.println(total);
        }
    }    
}

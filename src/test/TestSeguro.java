package test;

import dominio.CalcularPension;
import dominio.JubilacionDiscapacidad;
import dominio.JubilacionPatronal;
import dominio.JubilacionVejez;
import dominio.Jubilado;
import java.util.Scanner;

public class TestSeguro {

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        int n;
        System.out.println("***Sistema de Pensiones***");
        System.out.println("Salario Base : 400$");
        System.out.print("Ingrese el número de Jubilados: ");
        n = entrada.nextInt();
        Jubilado[] jubilados = new Jubilado[n];
        Datos(jubilados);
    }

    public static void men(CalcularPension p) {
        p.mensaje();
    }

    public static void Datos(Jubilado j[]) {
        String cedula, nombre,tJubilacion, tEmpresa;
        int anios,pdiscapacidad=0;
        double salario;
        double sueldoBase = 400;
        double pi = 0;
        double pension;
        entrada.nextLine();
        for (int i = 0; i < j.length; i++) {
            System.out.print("Ingrese su número de cédula: ");
            cedula = entrada.nextLine();
            System.out.print("Ingrese su nombres: ");
            nombre = entrada.nextLine();
            System.out.print("Ingrese sus años de aporte al seguro: ");
            anios = entrada.nextInt();
            if(anios<=10){
                pi = sueldoBase*0.5;
            }else{
                if(anios>10 || anios<=20){
                    pi = sueldoBase*0.6;
                }else{
                    if(anios>20 || anios<=30){
                        pi = sueldoBase*0.7;
                    }else{
                        if(anios>30 || anios<=35){
                            pi = sueldoBase*0.8;
                        }else{
                            if(anios>35 || anios<=39){
                                pi = sueldoBase*0.9;
                            }else{
                                if(anios>40){
                                    pi = sueldoBase*1;
                                }
                            }
                        }
                    }
                }
            }
            entrada.nextLine();
            System.out.print("Ingrese su tipo de Jubilación: "
                    + "\n1. vejez"
                    + "\n2. discapacidad"
                    + "\n3. patronal\n");
            tJubilacion = entrada.nextLine();
            if(tJubilacion.equals("vejez")){
                System.out.println("\t");
                System.out.println("Datos");
                CalcularPension jubv = new JubilacionVejez();
                j[i] = new Jubilado(cedula, nombre, anios);
                System.out.println("Cédula\tNombre\tAños de Aporte");
                System.out.println(j[i]);
                men(jubv);
                jubv.calcularPensionV(pi);
                
            }else{
                if(tJubilacion.equals("discapacidad")){
                    System.out.println("\t");
                    System.out.print("Ingrese su porcetaje de discapacidad: ");
                    pdiscapacidad = entrada.nextInt();
                    System.out.println("Datos");
                    CalcularPension jubd = new JubilacionDiscapacidad();
                    j[i] = new Jubilado(cedula, nombre, anios);
                    System.out.println("Cédula\tNombre\tAños de Aporte");
                    System.out.println(j[i]);
                    men(jubd);
                    jubd.calcularPensionD(pi,pdiscapacidad );
                }else{
                    if(tJubilacion.equals("patronal")){
                        System.out.println("\t");
                        System.out.println("Ingrese si el tipo de empresa:"
                                + "\n1. publica"
                                + "\n2. privada");
                        tEmpresa = entrada.nextLine();
                        System.out.println("Datos");
                        CalcularPension jubp = new JubilacionPatronal();
                        j[i] = new Jubilado(cedula, nombre, anios);
                         System.out.println("Cédula\tNombre\tAños de Aporte");
                        System.out.println(j[i]);
                         men(jubp);
                        jubp.calcularPensionP(pi,tEmpresa);
                    }
                }
            }
            
        }
    }
}

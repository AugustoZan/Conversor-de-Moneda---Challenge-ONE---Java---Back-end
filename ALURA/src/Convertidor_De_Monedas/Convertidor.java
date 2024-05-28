package Convertidor_De_Monedas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Convertidor {

    private double dolar = ConvertidorRequest.obtenerValorDolar();
    private double pesoArg = ConvertidorRequest.obtenerValorPesoArgentino();
    private double realBr = ConvertidorRequest.obtenerValorRealBrasilenio();
    private double pesoCol = ConvertidorRequest.obtenerValorPesoColombiano();
    private double pesoMex = ConvertidorRequest.obtenerValorPesoMexicano();
    private double cantidad;
    ConvertidorRequest convertidorRequest = new ConvertidorRequest();

    public Convertidor() {
    }

    public Convertidor(double dolar, double pesoArg, double realBr, double pesoCol, double pesoMex, double cantidad) {
        this.dolar = dolar;
        this.pesoArg = pesoArg;
        this.realBr = realBr;
        this.pesoCol = pesoCol;
        this.pesoMex = pesoMex;
        this.cantidad = cantidad;
    }

    public void menu() {
        int opcion = 0;
        do {
            System.out.println("------------------------------------------\n");
            System.out.println("¡Convertidor de monedas!");
            System.out.println("1. Pasar Dólar a Peso Argentino");
            System.out.println("2. Pasar Dólar a Real Brasileño");
            System.out.println("3. Pasar Dólar a Peso Colombiano");
            System.out.println("4. Pasar Dólar a Peso Mexicano");
            System.out.println("5. Pasar Peso Argentino a Dólar");
            System.out.println("6. Pasar Real Brasileño a Dólar");
            System.out.println("7. Pasar Peso Colombiano a Dólar");
            System.out.println("8. Pasar Peso Mexicano a Dólar");
            System.out.println("9. Salir");
            System.out.println("\n------------------------------------------");
            Scanner leer = new Scanner(System.in);
            try {
                opcion = leer.nextInt();
                switch (opcion) {
                    case 1:
                        dolarAPesoArg();
                        break;
                    case 2:
                        dolarARealBr();
                        break;
                    case 3:
                        dolarAPesoCol();
                        break;
                    case 4:
                        dolarAPesoMex();
                        break;
                    case 5:
                        pesoArgADolar();
                        break;
                    case 6:
                        realBrADolar();
                        break;
                    case 7:
                        pesoColADolar();
                        break;
                    case 8:
                        pesoMexADolar();
                        break;
                    case 9:
                        System.out.println("El programa ha finalizado");
                        break;
                    default:
                        System.out.println("Ingrese un número que esté en el menú");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número que esté en el menú");
                leer.next();
            }
        } while (opcion != 9);
    }

    public void dolarAPesoArg() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de dólares");
        try {
            this.cantidad = leer.nextDouble();
            System.out.println(this.cantidad + ((this.cantidad == 1)? " dólar " : " dólares ") + " son " + ((this.cantidad * this.dolar) * this.pesoArg) + ((((this.cantidad * this.dolar) * this.pesoArg) == 1)? " peso argentino" : " pesos argentinos"));
        } catch (InputMismatchException e) {
            System.out.println("Error: debe ingresar un número decimal");
            leer.next();
        }
    }

    public void dolarARealBr() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de dólares");
        try {
            this.cantidad = leer.nextDouble();
            System.out.println(this.cantidad + ((this.cantidad == 1)? " dólar " : " dólares ") + " son " + ((this.cantidad * this.dolar) * this.realBr) + ((((this.cantidad * this.dolar) * this.realBr) == 1)? " real brasileño" : " reales brasileños"));
        } catch (InputMismatchException e) {
            System.out.println("Error: debe ingresar un número decimal");
            leer.next();
        }
    }

    public void dolarAPesoCol() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de dólares");
        try {
            this.cantidad = leer.nextDouble();
            System.out.println(this.cantidad + ((this.cantidad == 1)? " dólar " : " dólares ")+ " son " + ((this.cantidad * this.dolar) * this.pesoCol) + ((((this.cantidad * this.dolar) * this.pesoCol) == 1)? " peso colombiano" : " pesos colombianos"));
        } catch (InputMismatchException e) {
            System.out.println("Error: debe ingresar un número decimal");
            leer.next();
        }
    }

    public void dolarAPesoMex() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de dólares");
        try {
            this.cantidad = leer.nextDouble();
            System.out.println(this.cantidad + ((this.cantidad == 1)? " dólar " : " dólares ")+ " son " + ((this.cantidad * this.dolar) * this.pesoMex) + ((((this.cantidad * this.dolar) * this.pesoMex) == 1)? " peso mexicano" : " pesos mexicanos"));
        } catch (InputMismatchException e) {
            System.out.println("Error: debe ingresar un número decimal");
            leer.next();
        }
    }

    public void pesoArgADolar() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de pesos argentinos");
        try {
            this.cantidad = leer.nextDouble();
            System.out.println(this.cantidad + ((this.cantidad == 1)? " peso argentino " : " pesos argentinos ") + " son " + ((this.cantidad / this.pesoArg) * this.dolar) + " dólar" + (((this.cantidad / this.pesoArg) * this.dolar == 1)? "" : "es"));
        } catch (InputMismatchException e) {
            System.out.println("Error: debe ingresar un número decimal");
            leer.next();
        }
    }

    public void realBrADolar() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de reales brasileños");
        try {
            this.cantidad = leer.nextDouble();
            System.out.println(this.cantidad + ((this.cantidad == 1)? " real brasileño " : " reales brasileños " ) + " son " + ((this.cantidad / this.realBr) * this.dolar) + " dólar" + (((this.cantidad / this.realBr) * this.dolar == 1)? "" : "es"));
        } catch (InputMismatchException e) {
            System.out.println("Error: debe ingresar un número decimal");
            leer.next();
        }
    }

    public void pesoColADolar() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de pesos colombianos");
        try {
            this.cantidad = leer.nextDouble();
            System.out.println(this.cantidad + ((this.cantidad == 1)? " peso colombiano " : " pesos colombianos " )+ " son " + ((this.cantidad / this.pesoCol) * this.dolar) +" dólar" + (((this.cantidad / this.pesoCol) * this.dolar == 1)? "" : "es"));
        } catch (InputMismatchException e) {
            System.out.println("Error: debe ingresar un número decimal");
            leer.next();
        }
    }

    public void pesoMexADolar() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de pesos mexicanos");
        try {
            this.cantidad = leer.nextDouble();
            System.out.println(this.cantidad + ((this.cantidad == 1)? " peso mexicano " : " pesos mexicanos " ) + " son " + ((this.cantidad / this.pesoMex) * this.dolar) + " dólar" + (((this.cantidad / this.pesoMex) * this.dolar == 1)? "" : "es"));
        } catch (InputMismatchException e) {
            System.out.println("Error: debe ingresar un número decimal");
            leer.next();
        }
    }
}

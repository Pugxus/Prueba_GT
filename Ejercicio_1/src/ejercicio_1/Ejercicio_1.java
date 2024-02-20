package ejercicio_1;

import java.util.*;

public class Ejercicio_1 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("\nIngrese un numero entero: ");
        int numero = Integer.parseInt(sc.nextLine());
        
        System.out.print("\nIngrese la cantidad de terminos: ");
        int terminos = Integer.parseInt(sc.nextLine());
        
        System.out.println(sumarSerie(numero, terminos));
    }

    private static int sumarSerie(int numero, int terminos) {
        int sum = 0;
        int numRe = numero;

        for (int i = 0; i < terminos; i++) {
            sum += numRe;
            numRe = numRe * 10 + numero;
        }
        return sum;
    }

}

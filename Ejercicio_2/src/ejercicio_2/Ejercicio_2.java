package ejercicio_2;

import java.util.*;

public class Ejercicio_2 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>();

        System.out.println("Ingrese los numeros separados por espacios (Si no desea finalizar ingrese una letra): ");
        while (sc.hasNextInt()) {
            nums.add(sc.nextInt());
        }
        System.out.println(listarNumeros(nums));
    }

    public static List<Integer> listarNumeros(List<Integer> nums) {
        List<Integer> lista = new ArrayList<>();

        for (int num : nums) {
            if (num % 5 == 0 && num <= 1000) {
                if (num <= 600) {
                    lista.add(num);
                }
            }
            if (num > 1000) {
                break;
            }
        }
        return lista;
    }
}

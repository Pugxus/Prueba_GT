package ejercicio_3;

import java.util.*;

public class Ejercicio_3 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();

        System.out.println("Ingrese los numeros separados por espacios (Si no desea finalizar ingrese una letra): ");
        while (sc.hasNextInt()) {
            nums.add(sc.nextInt());
        }        
        System.out.println(agruparNumeros(nums));
    }

    public static List<List<Integer>> agruparNumeros(List<Integer> nums) {
        Map<Integer, List<Integer>> mapa = new HashMap<>();
        List<List<Integer>> lista = new ArrayList<>();

        for (int num : nums) {
            if (!mapa.containsKey(num)) {
                mapa.put(num, new ArrayList<>());
            }
            mapa.get(num).add(num);
        }        
        lista.addAll(mapa.values());
        return lista;
    }

}

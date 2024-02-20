package ejercicio_4;

import java.util.*;

public class Ejercicio_4 {

    static Scanner sc = new Scanner(System.in);
    static List<String> dairyProducts = new ArrayList<>();
    static List<Integer> dairyStock = new ArrayList<>();
    static List<String> cleaningProducts = new ArrayList<>();
    static List<Integer> cleaningStock = new ArrayList<>();
    static List<String> grainProducts = new ArrayList<>();
    static List<Integer> grainStock = new ArrayList<>();
    static Map<String, List<String>> productosPorGrupo = new HashMap<>();
    static Map<String, List<Integer>> existenciasPorGrupo = new HashMap<>();

    public static void main(String[] args) {

        productosPorGrupo.put("dairy", dairyProducts);
        productosPorGrupo.put("cleaning", cleaningProducts);
        productosPorGrupo.put("grain", grainProducts);

        existenciasPorGrupo.put("dairy", dairyStock);
        existenciasPorGrupo.put("cleaning", cleaningStock);
        existenciasPorGrupo.put("grain", grainStock);

        menu();
    }

    private static void menu() {
        int opcion = 0;
        while (opcion != 3) {
            String cadenaMenu = "\n---Sistema de Inventario---";
            cadenaMenu += "\n1. Agregar Producto.";
            cadenaMenu += "\n2. Ver Estado del Inventario.";
            cadenaMenu += "\n3. Salir.";

            System.out.println(cadenaMenu);
            System.out.print("\nIngrese una opcion: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    agregarProducto(productosPorGrupo, existenciasPorGrupo);
                    break;
                case 2:
                    verEstadoInventario(productosPorGrupo, existenciasPorGrupo);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nOpcion no valida, intente nuevamente.");
            }
        }
    }

    public static void agregarProducto(Map<String, List<String>> productosPorGrupo, Map<String, List<Integer>> existenciasPorGrupo) {
        System.out.print("Ingrese el nombre del producto: ");
        String nombreProducto = sc.nextLine();

        System.out.print("Ingrese la cantidad del producto: ");
        int cantidad = Integer.parseInt(sc.nextLine());

        System.out.print("Ingrese el grupo del producto, debe ser dairy, cleaning o grain: ");
        String grupo = sc.nextLine().toLowerCase();

        if (productosPorGrupo.containsKey(grupo)) {
            List<String> productos = productosPorGrupo.get(grupo);
            List<Integer> existencias = existenciasPorGrupo.get(grupo);

            if (productos.contains(nombreProducto)) {
                int index = productos.indexOf(nombreProducto);
                existencias.set(index, existencias.get(index) + cantidad);
            } else {
                productos.add(nombreProducto);
                existencias.add(cantidad);
            }
            System.out.println("Producto agregado.");
        } else {
            System.out.println("Grupo no valido.");
        }
    }

    public static void verEstadoInventario(Map<String, List<String>> productosPorGrupo, Map<String, List<Integer>> existenciasPorGrupo) {
        System.out.println("\nEstado de Inventario:");
        for (Map.Entry<String, List<String>> entry : productosPorGrupo.entrySet()) {
            String grupo = entry.getKey();
            List<String> productos = entry.getValue();
            List<Integer> existencias = existenciasPorGrupo.get(grupo);

            System.out.println("\nGrupo: " + grupo);
            for (int i = 0; i < productos.size(); i++) {
                System.out.println("Nombre: " + productos.get(i) + ", Existencias: " + existencias.get(i));
            }
        }
    }

}

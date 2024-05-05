/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views;

import Models.Categoria;
import java.util.List;

/**
 *
 * @author kalic
 */
public class CategoriaView {
    
    public static void mostrarCategorias(List<Categoria> categorias) {
        if (categorias.isEmpty()) {
            System.out.println("No hay categorías disponibles.");
        } else {
            System.out.println("\n--- Lista de Categorías ---");
            for (Categoria categoria : categorias) {
                System.out.println(categoria.getCategoriaID()+ ". " + categoria.getNombre());
            }
        }
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    
}

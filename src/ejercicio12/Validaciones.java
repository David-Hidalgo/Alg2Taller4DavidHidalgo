package ejercicio12;

import java.util.Scanner;

public class Validaciones {
    /**función que devuelve verdadero o falso si un String es un número entero o no
     * @param cambiar
     * @return
     */
    public static boolean validarNumero(String cambiar) {
        try {
            Integer.parseInt(cambiar);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }    
}

package ejercicio12;

import java.util.Scanner;

public class Validaciones {
    //función que devuelve verdadero o falso si un String es un número entero o no
    public static boolean validarNumero(String cambiar) {
        try {
            Integer.parseInt(cambiar);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
    //función que elimina las "," de un String
    public static String eliminarComas(String entrada) {
        String salida = "";
        for (int i = 0; i < entrada.length(); i++) {
            if (entrada.charAt(i) != ',') {
                salida += entrada.charAt(i);
            }
        }
        return salida;
    }
    
    
}

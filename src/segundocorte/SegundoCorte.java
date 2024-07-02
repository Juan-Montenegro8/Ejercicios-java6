package segundocorte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SegundoCorte {

    public static void main(String[] args) {
        
        try (Scanner textoScanner=new Scanner(System.in);) {
            ArrayList<String> array = new ArrayList <>();  
            System.out.println("numero minimo");
            int minimo = textoScanner.nextInt();
            System.out.println("numero maximo");
            int maximo = textoScanner.nextInt();
            System.out.println("cantidad ");
            int cantidad = textoScanner.nextInt();
                       
            for (int i = minimo; i <= maximo; i++) {
                array.add(""+i);
            }
            Collections.shuffle(array);
        
            String [] numeros = new String[cantidad];
            for(int i = 0; i < numeros.length; i++){                                                                  
                numeros[i]=array.get(i);
            }
            DdivideYVenceras(numeros, 0, numeros.length - 1);
        } catch (Exception e) {
            System.out.println("Ocurrio un error: " + e.getMessage());
            
        }
        
    }
    
    public static int particion(String arreglo[], int izquierda, int derecha) {
    // Elegimos el pivote, es el primero
    String pivote = arreglo[izquierda];
    // Ciclo infinito
    while (true) {
        // Mientras cada elemento desde la izquierda esté en orden (sea menor que el
        // pivote) continúa avanzando el índice
        while (arreglo[izquierda].compareTo(pivote) < 0) {
            izquierda++;
        }
        // Mientras cada elemento desde la derecha esté en orden (sea mayor que el
        // pivote) continúa disminuyendo el índice
        while (arreglo[derecha].compareTo(pivote) > 0) {
            derecha--;
        }
/*
Si la izquierda es mayor o igual que la derecha significa que no
necesitamos hacer ningún intercambio
de variables, pues los elementos ya están en orden (al menos en esta
iteración)
*/
        if (izquierda >= derecha) {
            // Indicar "en dónde nos quedamos" para poder dividir el arreglo de nuevo
            // y ordenar los demás elementos
            return derecha;
        } else {//Nota: yo sé que el else no hace falta por el return de arriba, pero así el algoritmo es más claro
  /*
  Si las variables quedaron "lejos" (es decir, la izquierda no superó ni
  alcanzó a la derecha)
  significa que se detuvieron porque encontraron un valor que no estaba
  en orden, así que lo intercambiamos
  */
            String temporal = arreglo[izquierda];
            arreglo[izquierda] = arreglo[derecha];
            arreglo[derecha] = temporal;
  /*
  Ya intercambiamos, pero seguimos avanzando los índices una vez más
  */
            izquierda++;
            derecha--;
        }
        // El while se repite hasta que izquierda >= derecha
    }
}

// Divide y vencerás
private static void DdivideYVenceras(String arreglo[], int izquierda, int derecha) {
    if (izquierda < derecha) {
        int indiceParticion = particion(arreglo, izquierda, derecha);
        DdivideYVenceras(arreglo, izquierda, indiceParticion);
        DdivideYVenceras(arreglo, indiceParticion + 1, derecha);
    }
}

}
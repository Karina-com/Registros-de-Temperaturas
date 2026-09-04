package ejercicio6;

import java.util.Scanner;
public class registroTemperatura {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double temperatura, suma = 0, mayor = 0, menor = 0, promedio;
        int cantidad = 0, frias = 0, templadas = 0, calidas = 0, muyCalidas = 0;
        System.out.print("Ingrese una temperatura (-50 a 60) o 999 para finalizar: ");
        temperatura = entrada.nextDouble();
        while (temperatura != 999) {
            // Se rechazan los datos que estén fuera del rango permitido.
            if (temperatura < -50 || temperatura > 60) {
                System.out.println("Temperatura inválida. Debe estar entre -50 y 60.");
            } else {
                // El primer dato válido inicializa el valor mayor y el menor.
                if (cantidad == 0) {
                    mayor = temperatura;
                    menor = temperatura;
                } else {
                    if (temperatura > mayor) mayor = temperatura;
                    if (temperatura < menor) menor = temperatura;
                }
                suma += temperatura;
                cantidad++;
                if (temperatura < 10) {
                    frias++;
                    System.out.println("Clasificación: Frío");
                } else if (temperatura <= 24) {
                    templadas++;
                    System.out.println("Clasificación: Templado");
                } else if (temperatura <= 34) {
                    calidas++;
                    System.out.println("Clasificación: Cálido");
                } else {
                    muyCalidas++;
                    System.out.println("Clasificación: Muy cálido");
                }
            }
            System.out.print("Ingrese otra temperatura o 999 para finalizar: ");
            temperatura = entrada.nextDouble();
        }
        if (cantidad > 0) {
            promedio = suma / cantidad;
            System.out.println("Cantidad de datos válidos: " + cantidad);
            System.out.println("Temperatura mayor: " + mayor);
            System.out.println("Temperatura menor: " + menor);
            System.out.printf("Promedio: %.2f%n", promedio);
            System.out.println("Frío: " + frias);
            System.out.println("Templado: " + templadas);
            System.out.println("Cálido: " + calidas);
            System.out.println("Muy cálido: " + muyCalidas);
        } else {
            System.out.println("No se ingresaron temperaturas válidas.");
        }
        entrada.close();
    }
}


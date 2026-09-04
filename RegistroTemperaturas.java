import java.util.Scanner;

public class RegistroTemperaturas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cantidad = 0;
        double suma = 0;
        Double mayor = null;
        Double menor = null;
        int frio = 0, templado = 0, calido = 0, muyCalido = 0;

        while (true) {
            System.out.print("Ingrese temperatura (999 para terminar): ");
            double temp = sc.nextDouble();

            if (temp == 999) {
                break;
            }

            if (temp < -50 || temp > 60) {
                System.out.println("Dato inválido. Ingrese un valor entre -50 y 60.");
                continue;
            }

            String categoria;
            if (temp < 10) {
                categoria = "Frío";
                frio++;
            } else if (temp < 25) {
                categoria = "Templado";
                templado++;
            } else if (temp < 35) {
                categoria = "Cálido";
                calido++;
            } else {
                categoria = "Muy cálido";
                muyCalido++;
            }

            System.out.println("Temperatura " + temp + "°C clasificada como: " + categoria);

            cantidad++;
            suma += temp;
            if (mayor == null || temp > mayor) mayor = temp;
            if (menor == null || temp < menor) menor = temp;
        }

        if (cantidad > 0) {
            double promedio = suma / cantidad;
            System.out.println("\n--- Resumen ---");
            System.out.println("Cantidad de datos válidos: " + cantidad);
            System.out.println("Temperatura mayor: " + mayor);
            System.out.println("Temperatura menor: " + menor);
            System.out.printf("Promedio: %.2f%n", promedio);
            System.out.println("Frío: " + frio);
            System.out.println("Templado: " + templado);
            System.out.println("Cálido: " + calido);
            System.out.println("Muy cálido: " + muyCalido);
        } else {
            System.out.println("No se ingresaron datos válidos.");
        }

        sc.close();
    }
}
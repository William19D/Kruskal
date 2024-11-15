import java.util.Arrays;
import java.util.List;

public class KruskalAplicacionUQ {

    public static void main(String[] args) {
        Vertice<String> facultadIngenieria = new Vertice<>("Ingenieria");
        Vertice<String> facultadEconomicas = new Vertice<>("Ciencias Economicas");
        Vertice<String> facultadHumanas = new Vertice<>("Ciencias Humanas");
        Vertice<String> facultadBasicas = new Vertice<>("Ciencias Basicas");
        Vertice<String> facultadEducacion = new Vertice<>("Educacion");
        Vertice<String> facultadSalud = new Vertice<>("Salud");

        Arista<String> e1 = new Arista<>(facultadIngenieria, facultadEconomicas, 1);
        Arista<String> e2 = new Arista<>(facultadEconomicas, facultadHumanas, 2);
        Arista<String> e3 = new Arista<>(facultadHumanas, facultadBasicas, 3);
        Arista<String> e4 = new Arista<>(facultadBasicas, facultadEducacion, 4);
        Arista<String> e5 = new Arista<>(facultadEducacion, facultadSalud, 5);
        Arista<String> e6 = new Arista<>(facultadSalud, facultadIngenieria, 6);
        Arista<String> e7 = new Arista<>(facultadIngenieria, facultadHumanas, 7);

        List<Arista<String>> aristas = Arrays.asList(e1, e2, e3, e4, e5, e6, e7);
        Kruskal<String> kruskal = new Kruskal<>(aristas);

        System.out.println("Procesando Árbol de Cobertura Mínima:");
        kruskal.procesarMinimo();

        System.out.println("\nProcesando Árbol de Cobertura Máxima:");
        kruskal.procesarMaximo();
    }
}
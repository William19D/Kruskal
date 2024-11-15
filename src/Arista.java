import java.util.Objects;

public class Arista<T> implements Comparable<Arista<T>> {

    // Vértice de origen de la arista
    private final Vertice<T> origen;

    // Vértice de destino de la arista

    private final Vertice<T> destino;
    // Peso de la arista

    private final int peso;

    // Constructor que inicializa los vértices de origen y destino, y el peso
    public Arista(Vertice<T> origen, Vertice<T> destino, int peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    // Devuelve el vértice de origen
    public Vertice<T> getOrigen() {
        return origen;
    }

    // Devuelve el vértice de destino
    public Vertice<T> getDestino() {
        return destino;
    }

    // Devuelve el peso de la arista
    public int getPeso() {
        return peso;
    }

    // Compara esta arista con otra para ordenarlas por peso
    @Override
    public int compareTo(Arista<T> otra) {
        return Integer.compare(this.peso, otra.peso);
    }

    // Genera un código hash para la arista basado en los vértices y el peso
    @Override
    public int hashCode() {
        return Objects.hash(origen, destino, peso);
    }

    // Compara esta arista con otra para verificar igualdad
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Arista<?> arista = (Arista<?>) obj;
        return peso == arista.peso &&
                Objects.equals(origen, arista.origen) &&
                Objects.equals(destino, arista.destino);
    }

    // Devuelve una representación en cadena de la arista
    @Override
    public String toString() {
        return "Arista{" +
                "origen=" + origen +
                ", destino=" + destino +
                ", peso=" + peso +
                '}';
    }
}
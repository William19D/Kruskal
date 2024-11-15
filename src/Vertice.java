import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Vertice<T> {

    // Dato almacenado en el vértice
    private final T dato;

    // Conjunto de vértices adyacentes (vecinos)
    private final Set<Vertice<T>> adyacencia;

    // Indica si el vértice ha sido visitado
    private boolean visitado;

    // Indica si el vértice está siendo explorado
    private boolean explorado;

    // constructor que inicializa el dato y crea el conjunto de adyacencia
    public Vertice(T dato) {
        this.dato = dato;
        this.adyacencia = new HashSet<>();
        this.visitado = false;
        this.explorado = false;
    }

    // Devuelve el dato almacenado en el vértice
    public T getDato() {
        return dato;
    }

    // Devuelve el conjunto de vértices adyacentes
    public Set<Vertice<T>> getAdyacencia() {
        return adyacencia;
    }

    // Devuelve si el vértice ha sido visitado
    public boolean isVisitado() {
        return visitado;
    }

    // Establece si el vértice ha sido visitado
    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    // Devuelve si el vértice está siendo explorado
    public boolean isExplorado() {
        return explorado;
    }

    // Establece si el vértice está siendo explorado
    public void setExplorado(boolean explorado) {
        this.explorado = explorado;
    }

    // Agrega un vértice vecino al conjunto de adyacencia
    public void agregarVecino(Vertice<T> vecino) {
        adyacencia.add(vecino);
    }

    // Genera un código hash para el vértice basado en el dato
    @Override
    public int hashCode() {
        return Objects.hash(dato);
    }
    // Compara este vértice con otro para verificar igualdad
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vertice<?> vertice = (Vertice<?>) obj;
        return Objects.equals(dato, vertice.dato);
    }

    // Devuelve una representación en cadena del vértice
    @Override
    public String toString() {
        return "Vertice{" +
                "dato=" + dato +
                ", visitado=" + visitado +
                ", explorado=" + explorado +
                '}';
    }
}
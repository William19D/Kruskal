import java.util.*;

public class Kruskal<T> {

    // Lista de aristas del grafo
    private final List<Arista<T>> aristas;

    // Constructor que inicializa la lista de aristas
    public Kruskal(List<Arista<T>> aristas) {
        this.aristas = aristas;
    }

    // Procesa e imprime el árbol de cobertura mínima
    public void procesarMinimo() {
        PriorityQueue<Arista<T>> queue = new PriorityQueue<>(aristas);
        Set<Arista<T>> mst = kruskal(queue);
        imprimirArbol(mst, "Árbol de Cobertura Mínima");
    }

    // Procesa e imprime el árbol de cobertura máxima
    public void procesarMaximo() {
        PriorityQueue<Arista<T>> queue = new PriorityQueue<>(aristas.size(), Collections.reverseOrder());
        queue.addAll(aristas);
        Set<Arista<T>> mst = kruskal(queue);
        imprimirArbol(mst, "Árbol de Cobertura Máxima");
    }

    // Implementa el algoritmo de Kruskal para encontrar el árbol de cobertura
    private Set<Arista<T>> kruskal(PriorityQueue<Arista<T>> queue) {
        // Conjunto para almacenar las aristas del árbol de cobertura mínima
        Set<Arista<T>> mst = new HashSet<>();
        // Mapa para rastrear los padres de cada vértice
        Map<Vertice<T>, Vertice<T>> parent = new HashMap<>();

        // Inicializa el mapa de padres con cada vértice apuntando a sí mismo
        for (Arista<T> arista : aristas) {
            parent.putIfAbsent(arista.getOrigen(), arista.getOrigen());
            parent.putIfAbsent(arista.getDestino(), arista.getDestino());
        }

        // Mientras la cola no esté vacía y el tamaño del MST sea menor que el número de vértices - 1
        while (!queue.isEmpty() && mst.size() < parent.size() - 1) {
            // Obtiene y elimina la arista con el menor peso de la cola
            Arista<T> arista = queue.poll();
            // Encuentra los padres de los vértices de origen y destino de la arista
            Vertice<T> v1 = encontrar(parent, arista.getOrigen());
            Vertice<T> v2 = encontrar(parent, arista.getDestino());

            // Si los vértices no están en el mismo conjunto, añade la arista al MST y une los conjuntos
            if (v1 != v2) {
                mst.add(arista);
                unir(parent, v1, v2);
            }
        }

        // Devuelve el conjunto de aristas del árbol de cobertura mínima
        return mst;
    }

    // encuentra la raíz del vértice
    private Vertice<T> encontrar(Map<Vertice<T>, Vertice<T>> parent, Vertice<T> vertice) {
        if (parent.get(vertice) != vertice) {
            parent.put(vertice, encontrar(parent, parent.get(vertice)));
        }
        return parent.get(vertice);
    }

    // Une dos conjuntos de vértices
    private void unir(Map<Vertice<T>, Vertice<T>> parent, Vertice<T> root1, Vertice<T> root2) {
        parent.put(root1, root2);
    }

    // Imprime el árbol de cobertura
    private void imprimirArbol(Set<Arista<T>> arbol, String titulo) {
        System.out.println(titulo + ":");
        for (Arista<T> arista : arbol) {
            System.out.println(arista);
        }
    }
}
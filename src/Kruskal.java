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
        Set<Arista<T>> mst = new HashSet<>();
        Map<Vertice<T>, Vertice<T>> parent = new HashMap<>();

        for (Arista<T> arista : aristas) {
            parent.putIfAbsent(arista.getOrigen(), arista.getOrigen());
            parent.putIfAbsent(arista.getDestino(), arista.getDestino());
        }

        while (!queue.isEmpty() && mst.size() < parent.size() - 1) {
            Arista<T> arista = queue.poll();
            Vertice<T> v1 = find(parent, arista.getOrigen());
            Vertice<T> v2 = find(parent, arista.getDestino());

            if (v1 != v2) {
                mst.add(arista);
                union(parent, v1, v2);
            }
        }

        return mst;
    }

    // encuentra la raíz del vértice
    private Vertice<T> find(Map<Vertice<T>, Vertice<T>> parent, Vertice<T> vertice) {
        if (parent.get(vertice) != vertice) {
            parent.put(vertice, find(parent, parent.get(vertice)));
        }
        return parent.get(vertice);
    }

    // Une dos conjuntos de vértices
    private void union(Map<Vertice<T>, Vertice<T>> parent, Vertice<T> root1, Vertice<T> root2) {
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
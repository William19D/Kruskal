
# Implementación del Algoritmo de Kruskal

## Resumen

Este repositorio contiene una implementación del algoritmo de Kruskal en Java. El algoritmo de Kruskal se utiliza para encontrar el Árbol de Cobertura Mínima (MST) y el Árbol de Cobertura Máxima (MaxST) de un grafo. La implementación incluye clases para vértices (`Vertice`), aristas (`Arista`) y el propio algoritmo de Kruskal (`Kruskal`).

## Clases

### `Vertice<T>`
Representa un vértice en el grafo.
- **Atributos**: `dato`, `adyacencia`, `visitado`, `explorado`
- **Métodos**: `getDato()`, `getAdyacencia()`, `isVisitado()`, `setVisitado()`, `isExplorado()`, `setExplorado()`, `agregarVecino()`, `hashCode()`, `equals()`, `toString()`

### `Arista<T>`
Representa una arista en el grafo.
- **Atributos**: `origen`, `destino`, `peso`
- **Métodos**: `getOrigen()`, `getDestino()`, `getPeso()`, `compareTo()`, `hashCode()`, `equals()`, `toString()`

### `Kruskal<T>`
Implementa el algoritmo de Kruskal para encontrar el MST y el MaxST.
- **Atributos**: `aristas`
- **Métodos**: `procesarMinimo()`, `procesarMaximo()`, `kruskal()`, `encontrar()`, `unir()`, `imprimirArbol()`

## Pruebas JUnit

Se incluyen tres pruebas JUnit para verificar la funcionalidad de los algoritmos:

1. **`probarCicloGrafoDirigido`**: Prueba la detección de ciclos en un grafo dirigido.
2. **`probarCicloGrafoNoDirigido`**: Prueba la detección de ciclos en un grafo no dirigido.
3. **`probarKruskal`**: Prueba el algoritmo de Kruskal para encontrar el MST y el MaxST.

## Uso

Para ejecutar la aplicación y las pruebas, usa un IDE como IntelliJ IDEA. La clase principal de la aplicación es `KruskalAplicacionUQ`, que demuestra el uso del algoritmo de Kruskal con las facultades de la Universidad del Quindío.

## Ejecución de las Pruebas

Para ejecutar las pruebas JUnit, ejecuta los métodos de prueba en la clase `TestAlgoritmo`. Las pruebas imprimirán los resultados de las operaciones sobre el grafo en la consola.

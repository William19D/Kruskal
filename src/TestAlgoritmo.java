import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class TestAlgoritmo {

    @Test
    public void probarCicloGrafoDirigido() {

        Vertice<String> laureles = new Vertice<>("Laureles");
        Vertice<String> sanJulian = new Vertice<>("sanJulian");
        Vertice<String> coinca = new Vertice<>("Coinca");
        Vertice<String> portalDelQuindio = new Vertice<>("Portal del Quindio");
        Vertice<String> netania = new Vertice<>("Netania");
        Vertice<String> niteroi = new Vertice<>("Niteroi");

        laureles.agregarVecino(sanJulian);
        laureles.agregarVecino(coinca);

        sanJulian.agregarVecino(coinca);
        sanJulian.agregarVecino(portalDelQuindio);
        sanJulian.agregarVecino(netania);

        netania.agregarVecino(niteroi);

        niteroi.agregarVecino(portalDelQuindio);

        List<Vertice<String>> grafo = Arrays.asList(laureles, sanJulian, coinca, portalDelQuindio, netania, niteroi);

        for (Vertice<String> vertice : grafo) {
            System.out.print(vertice.getDato() + " -> ");
            for (Vertice<String> vecino : vertice.getAdyacencia()) {
                System.out.print(vecino.getDato() + " ");
            }
            System.out.println();
        }

    }

    @Test
    public void probarCicloGrafoNoDirigido() {
        Vertice<String> laureles = new Vertice<>("Laureles");
        Vertice<String> sanJulian = new Vertice<>("sanJulian");
        Vertice<String> coinca = new Vertice<>("Coinca");
        Vertice<String> portalDelQuindio = new Vertice<>("Portal del Quindio");
        Vertice<String> netania = new Vertice<>("Netania");
        Vertice<String> niteroi = new Vertice<>("Niteroi");

        laureles.agregarVecino(sanJulian); sanJulian.agregarVecino(laureles);
        laureles.agregarVecino(coinca); coinca.agregarVecino(laureles);
        sanJulian.agregarVecino(netania); netania.agregarVecino(sanJulian);
        coinca.agregarVecino(portalDelQuindio); portalDelQuindio.agregarVecino(coinca);
        portalDelQuindio.agregarVecino(netania); netania.agregarVecino(portalDelQuindio);
        netania.agregarVecino(niteroi); niteroi.agregarVecino(netania);

        List<Vertice<String>> grafo = Arrays.asList(laureles, sanJulian, coinca, portalDelQuindio, netania, niteroi);

        for (Vertice<String> vertice : grafo) {
            System.out.print(vertice.getDato() + " -> ");
            for (Vertice<String> vecino : vertice.getAdyacencia()) {
                System.out.print(vecino.getDato() + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void probarKruskal() {
        Vertice<String> laureles = new Vertice<>("Laureles");
        Vertice<String> sanJulian = new Vertice<>("sanJulian");
        Vertice<String> coinca = new Vertice<>("Coinca");
        Vertice<String> portalDelQuindio = new Vertice<>("Portal del Quindio");
        Vertice<String> netania = new Vertice<>("Netania");
        Vertice<String> niteroi = new Vertice<>("Niteroi");

        List<Arista<String>> grafo = Arrays.asList(
            new Arista<>(laureles, sanJulian, 5),
            new Arista<>(laureles, coinca, 2),
            new Arista<>(sanJulian, coinca, 3),
            new Arista<>(sanJulian, portalDelQuindio, 8),
            new Arista<>(sanJulian, netania, 7),
            new Arista<>(portalDelQuindio, netania, 6),
            new Arista<>(coinca, netania, 3)
        );

        new Kruskal<>(grafo).procesarMaximo();
        new Kruskal<>(grafo).procesarMinimo();
    }
}
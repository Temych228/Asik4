public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>(false);

        Vertex<String> astana = new Vertex<>("Astana");
        Vertex<String> karaganda = new Vertex<>("Karaganda");
        Vertex<String> balkash = new Vertex<>("Balkash");
        Vertex<String> almaty = new Vertex<>("Almaty");
        Vertex<String> pavlodar = new Vertex<>("Pavlodar");
        Vertex<String> semey = new Vertex<>("Semey");
        Vertex<String> taldykorgan = new Vertex<>("Taldykorgan");
        Vertex<String> kokshetau = new Vertex<>("Kokshetau");
        Vertex<String> taraz = new Vertex<>("Taraz");

        graph.addEdge(astana, karaganda, 2);
        graph.addEdge(karaganda, balkash, 3);
        graph.addEdge(balkash, almaty, 4);
        graph.addEdge(balkash, taraz, 6);
        graph.addEdge(almaty, taraz, 2);
        graph.addEdge(almaty, taldykorgan, 3);
        graph.addEdge(taldykorgan, semey, 5);
        graph.addEdge(astana, pavlodar, 4);
        graph.addEdge(pavlodar, semey, 2);
        graph.addEdge(astana, kokshetau, 3);

        graph.printGraph();

        System.out.println("\n--- BFS ---");
        new BreadthFirstSearch<String>().bfs(graph, astana);

        System.out.println("\n--- Dijkstra ---");
        var distances = new DijkstraSearch<String>().dijkstra(graph, astana);
        for (var entry : distances.entrySet()) {
            System.out.println("Distance to " + entry.getKey() + ": " + entry.getValue());
        }
    }
}

import java.util.*;

public class WeightedGraph<T> {
    private Map<Vertex<T>, Map<Vertex<T>, Double>> adjList = new HashMap<>();
    private boolean directed;

    public WeightedGraph(boolean directed) {
        this.directed = directed;
    }

    public void addVertex(Vertex<T> vertex) {
        adjList.putIfAbsent(vertex, new HashMap<>());
    }

    public void addEdge(Vertex<T> from, Vertex<T> to, double weight) {
        addVertex(from);
        addVertex(to);
        adjList.get(from).put(to, weight);
        if (!directed) {
            adjList.get(to).put(from, weight);
        }
    }

    public Map<Vertex<T>, Map<Vertex<T>, Double>> getAdjList() {
        return adjList;
    }

    public Set<Vertex<T>> getVertices() {
        return adjList.keySet();
    }

    public Map<Vertex<T>, Double> getNeighbors(Vertex<T> vertex) {
        return adjList.getOrDefault(vertex, new HashMap<>());
    }

    public void printGraph() {
        for (var entry : adjList.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (var neighbor : entry.getValue().entrySet()) {
                System.out.print(neighbor.getKey() + "(" + neighbor.getValue() + ") ");
            }
            System.out.println();
        }
    }
}

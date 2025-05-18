import java.util.*;

public class BreadthFirstSearch<T> {
    private Set<Vertex<T>> visited = new HashSet<>();

    public void bfs(WeightedGraph<T> graph, Vertex<T> start) {
        Queue<Vertex<T>> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex<T> current = queue.poll();
            System.out.println("Visited: " + current);

            for (Vertex<T> neighbor : graph.getNeighbors(current).keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
}

import java.util.*;

public class DijkstraSearch<T> {
    public Map<Vertex<T>, Double> dijkstra(WeightedGraph<T> graph, Vertex<T> source) {
        Map<Vertex<T>, Double> distances = new HashMap<>();
        PriorityQueue<Vertex<T>> pq = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        Set<Vertex<T>> visited = new HashSet<>();

        for (Vertex<T> v : graph.getVertices()) {
            distances.put(v, Double.POSITIVE_INFINITY);
        }
        distances.put(source, 0.0);
        pq.add(source);

        while (!pq.isEmpty()) {
            Vertex<T> current = pq.poll();
            if (visited.contains(current)) continue;
            visited.add(current);

            for (Map.Entry<Vertex<T>, Double> neighborEntry : graph.getNeighbors(current).entrySet()) {
                Vertex<T> neighbor = neighborEntry.getKey();
                double weight = neighborEntry.getValue();
                double newDist = distances.get(current) + weight;

                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    pq.add(neighbor);
                }
            }
        }

        return distances;
    }
}

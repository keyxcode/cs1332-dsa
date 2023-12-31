package xiii_graphtraversals;

import java.util.LinkedList;
import java.util.List;

/**
 * Your implementation of various graph traversal algorithms.
 */
public class GraphAlgorithms {

    /**
     * Performs a breadth first search (bfs) on the input graph, starting at
     * the parameterized starting vertex.
     *
     * When exploring a vertex, explore in the order of neighbors returned by
     * the adjacency list. Failure to do so may cause you to lose points.
     *
     * You may import/use java.util.Set, java.util.List, java.util.Queue, and
     * any classes that implement the aforementioned interfaces, as long as they
     * are efficient.
     *
     * The only instance of java.util.Map that you should use is the adjacency
     * list from graph. DO NOT create new instances of Map for BFS
     * (storing the adjacency list in a variable is fine).
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * You may assume that the passed in start vertex and graph will not be null.
     * You may assume that the start vertex exists in the graph.
     *
     * @param <T>   The generic typing of the data.
     * @param start The vertex to begin the bfs on.
     * @param graph The graph to search through.
     * @return List of vertices in visited order.
     */
    public static <T> List<Vertex<T>> bfs(Vertex<T> start, Graph<T> graph) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        LinkedList<Vertex<T>> frontier = new LinkedList<>();
        LinkedList<Vertex<T>> visited = new LinkedList<>();
        frontier.add(start);

        while (!frontier.isEmpty()) {
            Vertex<T> current = frontier.remove();
            visited.add(current);

            List<VertexDistance<T>> adjList = graph.getAdjList().get(current);
            
            for (VertexDistance<T> distance : adjList) {
                Vertex<T> adjVertex = distance.getVertex();

                if (!visited.contains(adjVertex) && !frontier.contains(adjVertex)) {
                    frontier.add(adjVertex);
                }
            }
        }

        return visited;
    }

    /**
     * Performs a depth first search (dfs) on the input graph, starting at
     * the parameterized starting vertex.
     *
     * When exploring a vertex, explore in the order of neighbors returned by
     * the adjacency list. Failure to do so may cause you to lose points.
     *
     * NOTE: This method should be implemented recursively. You may need to
     * create a helper method.
     *
     * You may import/use java.util.Set, java.util.List, and any classes that
     * implement the aforementioned interfaces, as long as they are efficient.
     *
     * The only instance of java.util.Map that you may use is the adjacency list
     * from graph. DO NOT create new instances of Map for DFS
     * (storing the adjacency list in a variable is fine).
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * You may assume that the passed in start vertex and graph will not be null.
     * You may assume that the start vertex exists in the graph.
     *
     * @param <T>   The generic typing of the data.
     * @param start The vertex to begin the dfs on.
     * @param graph The graph to search through.
     * @return List of vertices in visited order.
     */
    private static <T> void dfsHelper(Vertex<T> current, Graph<T> graph, List<Vertex<T>> visited) {
        if (visited.contains(current)) {
            return;
        }

        visited.add(current);
        List<VertexDistance<T>> adjList = graph.getAdjList().get(current);
        
        for (VertexDistance<T> distance : adjList) {
            Vertex<T> adjVertex = distance.getVertex();
            dfsHelper(adjVertex, graph, visited);
        }
    }

    public static <T> List<Vertex<T>> dfs(Vertex<T> start, Graph<T> graph) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        LinkedList<Vertex<T>> visited = new LinkedList<>();
        dfsHelper(start, graph, visited);

        return visited;
    }
}

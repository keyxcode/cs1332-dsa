package xiv_mst;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.List;
import java.util.Map;

/**
 * Your implementation of Prim's algorithm.
 */
public class GraphAlgorithms {

    /**
     * Runs Prim's algorithm on the given graph and returns the Minimum
     * Spanning Tree (MST) in the form of a set of Edges. If the graph is
     * disconnected and therefore no valid MST exists, return null.
     *
     * You may assume that the passed in graph is undirected. In this framework,
     * this means that if (u, v, 3) is in the graph, then the opposite edge
     * (v, u, 3) will also be in the graph, though as a separate Edge object.
     *
     * The returned set of edges should form an undirected graph. This means
     * that every time you add an edge to your return set, you should add the
     * reverse edge to the set as well. This is for testing purposes. This
     * reverse edge does not need to be the one from the graph itself; you can
     * just make a new edge object representing the reverse edge.
     *
     * You may assume that there will only be one valid MST that can be formed.
     *
     * You should NOT allow self-loops or parallel edges in the MST.
     *
     * You may import/use java.util.PriorityQueue, java.util.Set, and any
     * class that implements the aforementioned interface.
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * The only instance of java.util.Map that you may use is the adjacency
     * list from graph. DO NOT create new instances of Map for this method
     * (storing the adjacency list in a variable is fine).
     *
     * You may assume that the passed in start vertex and graph will not be null.
     * You may assume that the start vertex exists in the graph.
     *
     * @param <T>   The generic typing of the data.
     * @param start The vertex to begin Prims on.
     * @param graph The graph we are applying Prims to.
     * @return The MST of the graph or null if there is no valid MST.
     */
    public static <T> Set<Edge<T>> prims(Vertex<T> start, Graph<T> graph) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!

        PriorityQueue<Edge<T>> frontier = new PriorityQueue<>();
        Set<Vertex<T>> visited = new HashSet<>();
        Set<Edge<T>> mstEdges = new HashSet<>();

        // valid mst condition
        int numVertices = graph.getVertices().size();
        int numFullMstEdges = 2 * (numVertices - 1);

        // add edges that start from the passed in start vertex to the frontier
        Map<Vertex<T>, List<VertexDistance<T>>> adjList = graph.getAdjList();
        List<VertexDistance<T>> vdFromStart = adjList.get(start);
        for (VertexDistance<T> vd : vdFromStart) {
            frontier.add(new Edge<>(start, vd.getVertex(), vd.getDistance()));
        }

        // proceed kruskal's
        while (mstEdges.size() < numFullMstEdges && !frontier.isEmpty()) {
            Edge<T> minEdge = frontier.remove();
            
            if (!visited.contains(minEdge.getV())) {
                // add the min edge to the mst (both directions)
                mstEdges.add(minEdge);
                mstEdges.add(new Edge<>(minEdge.getV(), minEdge.getU(), minEdge.getWeight()));

                // add the destination vertex of the min edge
                Vertex<T> v = minEdge.getV();
                visited.add(v);
                
                // enqueue edges that start from the destination vertex of the min edge
                List<VertexDistance<T>> vdFromV = adjList.get(v);
                for (VertexDistance<T> vd : vdFromV) {
                    if (!visited.contains(vd.getVertex())) {
                        frontier.add(new Edge<>(v, vd.getVertex(), vd.getDistance()));
                    }
                }
            }             
        }

        if (mstEdges.size() < numFullMstEdges) {
            return null;
        }

        return mstEdges;
    }
}

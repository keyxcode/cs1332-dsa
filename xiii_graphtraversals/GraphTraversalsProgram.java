package xiii_graphtraversals;
import java.util.HashSet;

public class GraphTraversalsProgram {
    public static void main(String[] args) {
        Vertex<String> a = new Vertex<String>("A");
        Vertex<String> b = new Vertex<String>("B");
        Vertex<String> c = new Vertex<String>("C");
        Vertex<String> d = new Vertex<String>("D");
        Vertex<String> e = new Vertex<String>("E");
        Vertex<String> f = new Vertex<String>("F");
        Vertex<String> g = new Vertex<String>("G");
        Vertex<String> h = new Vertex<String>("H");

        HashSet<Vertex<String>> vertices = new HashSet<>();
        vertices.add(a);
        vertices.add(b);
        vertices.add(c);
        vertices.add(d);
        vertices.add(e);
        vertices.add(f);
        vertices.add(g);
        vertices.add(h);

        Edge<String> ab = new Edge<>(a, b, 1);
        Edge<String> ac = new Edge<>(a, c, 1);
        Edge<String> ad = new Edge<>(a, d, 1);
        Edge<String> ae = new Edge<>(a, e, 1);

        Edge<String> ba = new Edge<>(b, a, 1);
        Edge<String> bg = new Edge<>(b, g, 1);

        Edge<String> ca = new Edge<>(c, a, 1);

        Edge<String> da = new Edge<>(d, a, 1);
        Edge<String> df = new Edge<>(d, f, 1);

        Edge<String> ea = new Edge<>(e, a, 1);
        Edge<String> eg = new Edge<>(e, g, 1);

        Edge<String> fd = new Edge<>(f, d, 1);
        Edge<String> fg = new Edge<>(f, g, 1);

        Edge<String> gb = new Edge<>(g, b, 1);
        Edge<String> ge = new Edge<>(g, e, 1);
        Edge<String> gf = new Edge<>(g, f, 1);
        Edge<String> gh = new Edge<>(g, h, 1);

        Edge<String> hg = new Edge<>(h, g, 1);

        HashSet<Edge<String>> edges = new HashSet<>();
        edges.add(ab);
        edges.add(ac);
        edges.add(ad);
        edges.add(ae);

        edges.add(ba);
        edges.add(bg);

        edges.add(ca);

        edges.add(da);
        edges.add(df);

        edges.add(ea);
        edges.add(eg);

        edges.add(fd);
        edges.add(fg);

        edges.add(gb);
        edges.add(ge);
        edges.add(gf);
        edges.add(gh);

        edges.add(hg);

        Graph<String> graph = new Graph<>(vertices, edges);

        // System.out.println(GraphAlgorithms.bfs(h, graph));
        System.out.println(GraphAlgorithms.dfs(h, graph));
    }
}
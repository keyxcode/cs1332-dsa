package xiv_mst;

import java.util.HashSet;

public class PrimsProgram {
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
        Edge<String> ac = new Edge<>(a, c, 5);

        Edge<String> ba = new Edge<>(b, a, 1);
        Edge<String> bc = new Edge<>(b, c, 7);
        Edge<String> bg = new Edge<>(b, g, 1);
        Edge<String> bd = new Edge<>(b, d, 9);

        Edge<String> ca = new Edge<>(c, a, 5);
        Edge<String> cb = new Edge<>(c, b, 7);
        Edge<String> cg = new Edge<>(c, g, 13);

        Edge<String> db = new Edge<>(d, b, 9);
        Edge<String> df = new Edge<>(d, f, 4);

        Edge<String> eg = new Edge<>(e, g, 10);

        Edge<String> fd = new Edge<>(f, d, 4);
        Edge<String> fg = new Edge<>(f, g, 2);
        Edge<String> fh = new Edge<>(f, h, 0);

        Edge<String> ge = new Edge<>(g, e, 10);
        Edge<String> gc = new Edge<>(g, c, 13);
        Edge<String> gb = new Edge<>(g, b, 1);
        Edge<String> gf = new Edge<>(g, f, 2);
        Edge<String> gh = new Edge<>(g, h, 3);

        Edge<String> hf = new Edge<>(h, f, 0);
        Edge<String> hg = new Edge<>(h, g, 3);

        HashSet<Edge<String>> edges = new HashSet<>();
        edges.add(ab);
        edges.add(ac);

        edges.add(ba);
        edges.add(bc);
        edges.add(bg);
        edges.add(bd);

        edges.add(ca);
        edges.add(cb);
        edges.add(cg);

        edges.add(db);
        edges.add(df);

        edges.add(eg);

        edges.add(fd);
        edges.add(fg);
        edges.add(fh);

        edges.add(ge);
        edges.add(gc);
        edges.add(gb);
        edges.add(gf);
        edges.add(gh);

        edges.add(hf);
        edges.add(hg);

        Graph<String> graph = new Graph<>(vertices, edges);

        System.out.println(GraphAlgorithms.prims(a, graph));
    }
}

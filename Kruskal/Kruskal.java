import java.util.Arrays;
import java.util.List;

public class Kruskal {

    private Edge[] edges;
    private List<Edge> mst;
    public double weight;

    /**
    * @post Compute a minimum spanning tree of edge-weighted graph G.
    */
    public Kruskal(EdgeWeightedIntGraph G) {
        edges = new Edge[G.V()];
        int j = 0;
        for (Edge e : G.edges()) {
            edges[j] = e;
            j++;
        }
        Arrays.sort(edges);

        UF uf = new UF(G.V());
        for(int i = 0; i < G.E() && mst.size() < G.V() - 1; i++) {
            Edge e = edges[i];
            int v = e.from;
            int w = e.other(v);

            if(uf.find(v) != uf.find(w)) {
                uf.union(v, w);
                mst.add(e);
                weight += e.weight;
            }
        }
    }

   /**
    * @post Returns the edges in a minimum
    * spanning tree.
    */
    public List<Edge> edges() {
        return mst;
    }

    /**
    * @post Returns the sum of the edge weights
    * in a minimum spanning tree.
    */
    public double weight() {
        return weight;
    }
}

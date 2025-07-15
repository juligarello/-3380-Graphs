import java.util.LinkedList;
import java.util.List;

public class Prim {

    private double[] distTo;
    private Edge[] edgeTo;
    private boolean[] marked;
    private IndexMinPQ<Double> pq;

    public Prim(EdgeWeightedIntGraph G, int s) {
        if(s < 0 || s >= G.V())
            throw new IllegalArgumentException();

        distTo = new double[G.V()];
        edgeTo = new Edge[G.V()];
        marked = new boolean[G.V()];
        pq = new IndexMinPQ<>(G.V());
        for(int v = 0; v < G.V(); v++) {
            if(v != s) {
                distTo[v] = Double.POSITIVE_INFINITY;
                pq.insert(v, distTo[v]);
            }
        }

        distTo[s] = 0.0;
        pq.insert(s, distTo[s]);
        while(!pq.isEmpty()) {
            int v = pq.delMin();
            marked[v] = true;

            for(Edge e : G.adj(v)) {
                int w = e.other(v);
                if(marked[w])
                    continue;
                if(e.weight < distTo[w]) {
                    distTo[w] = e.weight;
                    edgeTo[w] = e;
                    pq.decreaseKey(w, distTo[w]);
                }
            }
        }
    }

    /**
    * @pre prim must be called before this method to
    * compute a minimum spanning tree.
    * @post Returns the sum of the edge weights in a
    * minimum spanning tree.
    */
    public double weight() {
        double weight = 0.0;
        for(Edge e : edges()) {
            weight += e.weight;
        }

        return weight;
    }

    /**
    * @pre prim must be called before this method to
    * compute a minimum spanning tree.
    * @post Returns the edges in a minimum spanning tree.
    */
    public List<Edge> edges() {
        List<Edge> mst = new LinkedList<>();

        for(int v = 0; v < edgeTo.length; v++) {
            Edge e = edgeTo[v];
            if(e != null)
                mst.add(e);
        }

        return mst;
    }
}

public class Dijkstra {

    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private IndexMinPQ<Double> pq;

    /**
    * @pre 0=<s<V && G has no edges with negative weight
    * @post Computes the shortest paths from the source vertex s to every other
    * vertex in the edge-weighted digraph G.
    */
    public Dijkstra(EdgeWeightedIntDigraph G, int s) {
        if(s < 0 || s >= G.V())
            throw new IllegalArgumentException();

        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        pq = new IndexMinPQ<>(G.V());
        for(int v = 0; v < G.V(); v++) {
            if(v != s) {
                distTo[v] = Double.POSITIVE_INFINITY;
                pq.insert(v, distTo[v]);
            }
        }

        distTo[s] = 0;
        pq.insert(s, distTo[s]);

        while(!pq.isEmpty()) {
            int v = pq.delMin();
            for(DirectedEdge e : G.adj(v)) {
                relax(e);
            }
        }
    }

    private void relax(DirectedEdge e) {
        int v = e.from;
        int w = e.to;
        if (distTo[w] > distTo[v] + e.weight) {
            distTo[w] = distTo[v] + e.weight;
            edgeTo[w] = e;

            pq.decreaseKey(w, distTo[w]);
        }
    }
}

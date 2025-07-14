public class FloydWarshall {

    private double[][] distTo;
    private DirectedEdge[][] edgeTo;

    /** Warshall: Java
    * @post Computes shortest paths from each vertex to every other
    * vertex in the edge-weighted digraph G.
    */
    public FloydWarshall(EdgeWeightedIntDigraph G) {
        int V = G.V();
        distTo = new double[V][V];
        edgeTo = new DirectedEdge[V][V];

        // initialize distances to infinity
        for(int v = 0; v < V; v++) {
            distTo[v][v] = 0.0;

            for(int w = 0; w < V; w++) {
                if(v != w)
                    distTo[v][w] = Double.POSITIVE_INFINITY;
            }
        }

        // initialize distances using edge-weighted digraph's
        for(int v = 0; v < G.V(); v++) {
            for(DirectedEdge e : G.adj(v)) {    
                distTo[e.from][e.to] = e.weight;
                edgeTo[e.from][e.to] = e;
            }
        }

        // Floyd-Warshall updates
        for(int k = 0; k < V; k++) {

            // compute shortest paths using only 0, 1, ..., k as
            // intermediate vertices
            for(int i = 0; i < V; i++) {
                for(int j = 0; j < V; j++) {
                    if(distTo[i][j] > distTo[i][k] + distTo[k][j]) {
                        distTo[i][j] = distTo[i][k] + distTo[k][j];
                        edgeTo[i][j] = edgeTo[k][j];
                    }
                }
            }
        }
    }
}

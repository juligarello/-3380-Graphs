import java.util.LinkedList;
import java.util.List;

/**
* EdgeWeightedDigraphs represents an edge-weighted
* digraph of vertices named 0 through V - 1, where each
* directed edge is of type DirectedEdge and has a real-valued weight.
*/
public class EdgeWeightedIntDigraph {
 
    private final int V;
    private int E;
    private List<DirectedEdge>[] adj;

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    /**
    * @pre V >= 0
    * @post Initializes an edge-weighted digraph with V vertices and 0 edges.
    */
    public EdgeWeightedIntDigraph(int V) {
        if (V < 0)
            throw new IllegalArgumentException();

        this.V = V;
        this.E = 0;
        adj = new LinkedList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<DirectedEdge>();
        }
    }

    /**
    * @pre 0 <= e.from < V && 0 <= e.to < V
    * @post Adds the directed edge e (e.from->e.weight->e.to)
    * to this edge-weighted digraph.
    */
    public void addEdge(DirectedEdge e) {
        if (e.from < 0 || e.from >= V)
            throw new IllegalArgumentException();
        if (e.to < 0 || e.to >= V)
            throw new IllegalArgumentException();
    
        adj[e.from].add(e);
        E++;
    }

    /**
    * @pre 0 <= v < V
    * @post Returns the list of edges going out from vertex v.
    */
    public List<DirectedEdge> adj(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException();

        return adj[v];
    }
}

import java.util.LinkedList;
import java.util.List;

public class AdjacencyListIntDigraph implements IntDigraph {

    // Number of vertices in the graph
    private final int V;
    // Number of edges in the graph
    private int E;
    // Adjacency lists
    private List<Integer>[] adjacency;

    public AdjacencyListIntDigraph(int v) {
        if (v < 0)
            throw new IllegalArgumentException();

        V = v;
        E = 0;
        adjacency = new LinkedList[V];
        for(int i = 0; i < V; i++) {
            adjacency[i] = new LinkedList<Integer>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        if(v < 0 || v >= V)
            throw new IllegalArgumentException();
        if(w < 0 || w >= V)
            throw new IllegalArgumentException();
        
        E++;
        adjacency[v].add(w);
    }

    public List<Integer> adj(int v) {
        if(v < 0 || v >= V)
            throw new IllegalArgumentException();
        
        return adjacency[v];
    }
}

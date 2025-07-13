import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class AdjacencyListGraph<T extends Comparable<? super T>> implements Graph<T> {

    // Number of vertices in the graph
    private int V;
    // Number of edges in the graph
    private int E;
    // T -> index
    private TreeMap<T, Integer> map;
    // index -> T
    private T[] keys;
    // Adjacency lists
    private List<Integer>[] adj;

    public AdjacencyListGraph(int v) {
        if(V < 0)
            throw new IllegalArgumentException();

        this.V = 0;
        this.E = 0;
        map = new TreeMap<>();
        keys = (T[]) new Comparable[V];
        adj = new LinkedList[V];
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    /**
    * @pre 0<=v<V
    * @post Returns the name of the vertex associated with the integer v.
    */
    public T nameOf(int v) {
        return keys[v];
    }

    /**
    * @pre containsVertex(v).
    * @post Returns the integer associated with the vertex named v.
    */
    public int indexOf(T v) {
        return map.get(v);
    }

    /**
    * @pre !containsVertex(v).
    * @post Adds the vertex with label v to this graph.
    */
    public void addVertex(T v) {
        if(containsVertex(v)) {
            throw new IllegalArgumentException();
        }

        int vid = V++;
        map.put(v, vid);
        adj[vid] = new LinkedList<>();
        keys[vid] = v;
    }

    /**
    * @post Returns true iff there is no vertex with label v
    * in this graph.
    */
    public boolean containsVertex(T v) {
        return map.containsKey(v);
    }

    /**
    * @pre 0 <= v < V && 0 <= w < V
    * @post Adds the undirected edge v-w to this graph.
    */
    public void addEdge(T v, T w) {
        if(!containsVertex(v))
            throw new IllegalArgumentException();
        if(!containsVertex(w))
            throw new IllegalArgumentException();

        E++;
        int vid = indexOf(v);
        int wid = indexOf(w);
        adj[vid].add(wid);
        adj[wid].add(vid);
    }

    public String toString() {
        String s = "";
        for(int v = 0; v < V; v++) {
            s += nameOf(v) + ": ";
            for(int w : adj[v]) {
                s += nameOf(w) + " ";
            }

            s += '\n';
        }
        return s;
    }
}

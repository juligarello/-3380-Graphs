public interface Graph<T extends Comparable<? super T>> {

    /**
    * @post Returns the number of vertices in this graph.
    */
    public int V();

    /**
    * @post Returns the number of edges in this graph.
    */
    public int E();

    /**
    * @pre !containsVertex(v).
    * @post Adds the vertex with label v to this graph.
    */
    public void addVertex(T v);

    /**
    * @post Returns true iff there is a vertex with label v
    * in this graph.
    */
    public boolean containsVertex(T v);

    /**
    * @pre v and w are vertices of the graph
    * @post Adds the undirected edge v-w to this graph.
    */
    public void addEdge(T v, T w);
}


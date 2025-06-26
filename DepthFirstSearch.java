public class DepthFirstSearch {
    
    /**
    * @pre 0 <= s < G.V().
    * @post Computes the vertices in graph G that are
    * connected to the source vertex s.
    */
    public DepthFirstSearch(AdjacencyListIntGraph G, int s) {   
        boolean[] marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(AdjacencyListIntGraph G, int v) {

    }
}

public class BreadthFirstSearch {
    
    /**
    * @pre 0 <= s < G.V().
    * @post Computes the vertices in graph G that are
    * connected to the source vertex s.
    */
    public BreadthFirstSearch(AdjacencyListIntGraph G, int s) {
        boolean[] marked = new boolean[G.V()];
        int count = 0;
        bfs(G, s);
    }

    private void bfs(AdjacencyListIntGraph G, int s) {

    }
}

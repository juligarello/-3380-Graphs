import java.util.LinkedList;
import java.util.List;

public class DepthFirstSearch {
    
    private int s;
    private AdjacencyListIntGraph G;
    private boolean[] marked;
    private int[] edgeTo;
//  private int count;

    /**
    * @pre 0 <= s < G.V().
    * @post Computes the vertices in graph G that are
    * connected to the source vertex s.
    */
    public DepthFirstSearch(AdjacencyListIntGraph G, int s) {
        this.s = s;
        this.G = G;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
    //  count = 0;

        dfs(G, s);
    }

    public void dfs(AdjacencyListIntGraph G, int v) {
        marked[v] = true;
        for(int w : G.adj(v)) {
            if(!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        isValidVertex(v);

        return marked[v];
    }

    public List<Integer> pathTo(int v) {
        isValidVertex(v);
        if(!hasPathTo(v))
            return null;

        LinkedList<Integer> path = new LinkedList<>();
        for(int x = v; x != s; x = edgeTo[x]) {
            path.addFirst(x);
        }
        path.addFirst(s);

        return path;
    }

    public boolean isValidVertex(int v) {
        return v >= 0 && v < G.V();
    }

/* 
*   private void related(AdjacencyListIntGraph G, int v) {
*       count++;
*       marked[v] = true;
*       for(int w : G.adj(v)) {
*           if(!marked[w]) {
*               dfs(G, w);
*           }
*       }
*   }
*/
}

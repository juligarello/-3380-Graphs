import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BreadthFirstSearch {
    
    private boolean[] marked;
    private int[] edgeTo;
    private Queue<Integer> q;

    /**
    * @pre 0 <= s < G.V().
    * @post Computes the vertices in graph G that are
    * connected to the source vertex s.
    */
    public BreadthFirstSearch(AdjacencyListIntGraph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        q = new LinkedBlockingQueue<>();
        bfs(G, s);
    }

    public void bfs(AdjacencyListIntGraph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];

        marked[s] = true;
        q.offer(s);
        while(!q.isEmpty()) {
            int v = q.poll();
            for(int w : G.adj(v)) {
                if(!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = v;
                    q.offer(w);
                }
            }
        }
    }
}

public class UF {

    private int[] parent;
    private int[] size;

    public UF(int n) {
        if(n < 0)
            throw new IllegalArgumentException();

        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int p) {
        while(p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }

        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ)
            return;

        if(size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }   else    {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
    }
}

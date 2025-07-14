import java.util.NoSuchElementException;
import java.util.Arrays;

public class IndexMinPQ<Key extends Comparable<Key>> {
    private int maxN;
    private int n;
    private int[] pq;
    private int[] qp;
    private Key[] keys;

    public IndexMinPQ(int maxN) {
        if(maxN < 0)
            throw new IllegalArgumentException();

        this.maxN = maxN;
        n = 0;
        keys = (Key[]) new Comparable[maxN + 1];
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        Arrays.fill(qp, -1);
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean contains(int i) {
        if (i < 0 || i >= maxN)
            throw new IllegalArgumentException();

        return qp[i] != -1;
    }

    public void insert(int i, Key key) {
        if(i < 0 || i >= maxN)
            throw new IllegalArgumentException();
        if(contains(i))
            throw new IllegalArgumentException();

        n++;
        qp[i] = n;
        pq[n] = i;
        keys[i] = key;
        swim(n);
    }

    public int delMin() {
        if(n == 0)
            throw new NoSuchElementException();

        int min = pq[1];
        exch(1, n--);
        sink(1);
        qp[min] = -1;
        keys[min] = null;
        pq[n+1] = -1;
        return min;
    }

    public void decreaseKey(int i, Key key) {
        if(i < 0 || i >= maxN)
            throw new IllegalArgumentException();
        if(!contains(i))
            throw new NoSuchElementException();
        if(keys[i].compareTo(key) <= 0)
            throw new IllegalArgumentException();

        keys[i] = key;
        swim(qp[i]);
    }

    private boolean greater(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }

    private void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    private void swim(int k) {
        while(k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while(2*k <= n) {
            int j = 2*k;
            if(j < n && greater(j, j+1))
                j++;
            if(!greater(k, j))
                break;

            exch(k, j);
            k = j;
        }
    }
}

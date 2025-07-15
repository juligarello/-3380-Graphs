/**
* Edge class represents a weighted
* edge in an EdgeWeightedGraph.
*/
public class Edge {
    final int from;
    final int to;
    final double weight;

    /**
    * @post Initializes a no-directed edge with the given weight.
    */
    public Edge(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int either() {
        return from;
    }

    public int other(int vertex) {
        if(vertex == from) {
            return to;
        } else if(vertex == to) {
            return from;
        }   else    {
            throw new IllegalArgumentException();
        }
    }
}

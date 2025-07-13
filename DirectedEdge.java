/**
* DirectedEdge class represents a
* weighted edge in an EdgeWeightedDigraph.
*/
public class DirectedEdge {
    final int from;
    final int to;
    final double weight;

    /**
    * @post Initializes a directed edge from vertex from
    * to vertex to with the given weight.
    */
    public DirectedEdge(int from, int to, double weight) {
    this.from = from;
    this.to = to;
    this.weight = weight;
    }
}

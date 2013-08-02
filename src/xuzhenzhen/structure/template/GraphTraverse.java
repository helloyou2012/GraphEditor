package xuzhenzhen.structure.template;

import xuzhenzhen.structure.model.Edge;
import xuzhenzhen.structure.model.Graph;
import xuzhenzhen.structure.model.Vertex;

public abstract class GraphTraverse {
	public final static int UNDISCOVERED=0;
	public final static int DISCOVERED=1;
	public final static int VISITED=2;
	public final static int UNKNOWN=0;
	public final static int TREE=1;
	public final static int CROSS=2;
	public final static int FORWARD=3;
	public final static int BACKWARD=4;
	protected Graph graph;
	public GraphTraverse(Graph graph) {
		this.graph = graph;
	}
	public void reset(){
		for(Vertex v:graph.vertices()){
			v.setStatus(UNDISCOVERED);
			v.setDistance(Integer.MAX_VALUE);
		}
		for(Edge e:graph.edges()){
			e.setType(UNKNOWN);
		}
	}
	public abstract Object visit(Vertex v);
	public abstract Object traverse(Vertex v);
	public abstract Object algorithm(Vertex v);
}

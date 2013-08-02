package xuzhenzhen.structure.control;

import xuzhenzhen.structure.model.Edge;
import xuzhenzhen.structure.model.Graph;

public class SelectEdgeOperate implements Operation{
	private Graph graph;
	private int edgeIndex;
	public SelectEdgeOperate(Graph graph, int edgeIndex) {
		this.graph = graph;
		this.edgeIndex = edgeIndex;
	}
	@Override
	public void operate() {
		// TODO Auto-generated method stub
		int i=0;
		for(Edge e:graph.edges()){
			if(i==edgeIndex)
				e.setSelect(true);
			else
				e.setSelect(false);
			i++;
		}
		graph.selectedRefresh();
	}

}

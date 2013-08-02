package xuzhenzhen.structure.control;

import xuzhenzhen.structure.model.DataInfo;
import xuzhenzhen.structure.model.Edge;
import xuzhenzhen.structure.model.EdgeInfo;
import xuzhenzhen.structure.model.Graph;

public class RefreshEdgeOperate implements Operation{
	private Graph graph;
	private int index;
	private String name;
	private int weight;
	public RefreshEdgeOperate(Graph graph, int index, String name, int weight) {
		this.graph = graph;
		this.index = index;
		this.name = name;
		this.weight = weight;
	}
	@Override
	public void operate() {
		// TODO Auto-generated method stub
		Edge e=graph.edges().get(index);
		DataInfo info=new EdgeInfo(name, weight);
		e.setInfo(info);
		graph.structureRefresh();
	}

}

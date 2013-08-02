package xuzhenzhen.structure.control;

import xuzhenzhen.structure.model.DataInfo;
import xuzhenzhen.structure.model.Graph;
import xuzhenzhen.structure.model.Vertex;
import xuzhenzhen.structure.model.VertexInfo;

public class RefreshVertexOperate implements Operation{
	private Graph graph;
	private int index;
	private String name;
	private int weight;
	public RefreshVertexOperate(Graph graph, int index, String name, int weight) {
		this.graph = graph;
		this.index = index;
		this.name = name;
		this.weight = weight;
	}
	@Override
	public void operate() {
		// TODO Auto-generated method stub
		Vertex v=graph.vertices().get(index);
		DataInfo info=new VertexInfo(name, weight);
		v.setInfo(info);
		graph.structureRefresh();
	}

}

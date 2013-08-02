package xuzhenzhen.structure.control;

import xuzhenzhen.structure.model.DataInfo;
import xuzhenzhen.structure.model.Graph;
import xuzhenzhen.structure.model.Vertex;
import xuzhenzhen.structure.model.VertexInfo;
import xuzhenzhen.structure.model.VertexNode;

public class AddVertexOperate implements Operation{
	private Graph graph;
	private String name;
	private int weight;
	public AddVertexOperate(Graph graph, String name, int weight) {
		this.graph = graph;
		this.name = name;
		this.weight = weight;
	}
	public AddVertexOperate(Graph graph) {
		this.graph = graph;
		this.name = null;
		this.weight = 0;
	}
	@Override
	public void operate() {
		// TODO Auto-generated method stub
		if(graph!=null){
			Vertex v=null;
			if(name!=null){
				DataInfo info=new VertexInfo(name, weight);
				v=new VertexNode(info);
			}
			else{
				String n=""+graph.vertices().size();
				DataInfo info=new VertexInfo(n);
				v=new VertexNode(info);
			}
			graph.insert(v);
			graph.structureRefresh();
		}
	}
}

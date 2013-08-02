package xuzhenzhen.structure.control;

import xuzhenzhen.structure.model.DataInfo;
import xuzhenzhen.structure.model.Edge;
import xuzhenzhen.structure.model.EdgeInfo;
import xuzhenzhen.structure.model.EdgeNode;
import xuzhenzhen.structure.model.Graph;
import xuzhenzhen.structure.model.Vertex;

public class AddEdgeOperate implements Operation{
	private Graph graph;
	private int from;
	private int to;
	private String name;
	private int weight;
	public AddEdgeOperate(Graph graph, int from, int to, String name, int weight) {
		this.graph = graph;
		this.from = from;
		this.to = to;
		this.name = name;
		this.weight = weight;
	}
	@Override
	public void operate() {
		// TODO Auto-generated method stub
		if(graph!=null){
			Vertex f=graph.vertices().get(from);
			Vertex t=graph.vertices().get(to);
			Edge edge=graph.edgeFromTo(f, t);
			DataInfo data=new EdgeInfo(name, weight);
			if(edge==null){
				Edge e=new EdgeNode(data, f, t);
				graph.insert(e);
			}
			else{
				if(name.length()>0)
					edge.setInfo(data);
				else
					((DataInfo)edge.getInfo()).setWeight(weight);	
			}
			graph.structureRefresh();
		}
	}

}

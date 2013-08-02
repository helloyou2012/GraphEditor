package xuzhenzhen.structure.control;

import xuzhenzhen.structure.model.DataInfo;
import xuzhenzhen.structure.model.Edge;
import xuzhenzhen.structure.model.EdgeInfo;
import xuzhenzhen.structure.model.EdgeNode;
import xuzhenzhen.structure.model.Graph;
import xuzhenzhen.structure.model.Vertex;

public class RefreshEdgeWeightOperate implements Operation{
	private Graph graph;
	private int from;
	private int to;
	private int weight;
	public RefreshEdgeWeightOperate(Graph graph, int from, int to, int weight) {
		this.graph = graph;
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	@Override
	public void operate() {
		// TODO Auto-generated method stub
		if(graph!=null){
			Vertex f=graph.vertices().get(from);
			Vertex t=graph.vertices().get(to);
			Edge edge=graph.edgeFromTo(f, t);
			if(edge!=null){
				if(weight!=0)
					((DataInfo)edge.getInfo()).setWeight(weight);
				else
					graph.remove(edge);
			}
			else if(weight!=0){
				DataInfo info=new EdgeInfo("unname", weight);
				Edge e=new EdgeNode(info, f, t);
				graph.insert(e);
			}
			graph.structureRefresh();
		}
	}

}

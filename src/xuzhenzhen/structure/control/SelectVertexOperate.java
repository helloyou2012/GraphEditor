package xuzhenzhen.structure.control;

import xuzhenzhen.structure.model.Graph;
import xuzhenzhen.structure.model.Vertex;

public class SelectVertexOperate implements Operation{
	private Graph graph;
	private int vertexIndex;
	public SelectVertexOperate(Graph graph, int vertexIndex) {
		this.graph = graph;
		this.vertexIndex = vertexIndex;
	}
	@Override
	public void operate() {
		// TODO Auto-generated method stub
		int i=0;
		for(Vertex v:graph.vertices()){
			if(i==vertexIndex)
				v.setSelect(true);
			else
				v.setSelect(false);
			i++;
		}
		graph.selectedRefresh();
	}

}
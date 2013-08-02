package xuzhenzhen.structure.template;

import xuzhenzhen.structure.model.Edge;
import xuzhenzhen.structure.model.Graph;
import xuzhenzhen.structure.model.Vertex;

public abstract class DFS extends GraphTraverse{
	protected int clock=0;
	public DFS(Graph graph) {
		super(graph);
	}

	@Override
	public Object visit(Vertex v) {
		// TODO Auto-generated method stub
		System.out.print("访问节点:");
		System.out.println(v.getInfo());
		return null;
	}

	@Override
	public Object traverse(Vertex v) {
		// TODO Auto-generated method stub
		if(v.getStatus()!=UNDISCOVERED)return null;
		v.setdStamp(clock++);
		v.setStatus(DISCOVERED);visit(v);
		for(Edge e:v.outEdges()){
			Vertex u=e.getEndV();
			switch (u.getStatus()) {
			case UNDISCOVERED:
				e.setType(TREE);
				traverse(u);
				break;
			case DISCOVERED:
				e.setType(BACKWARD);
				break;
			default:
				if(u.getdStamp()<v.getdStamp())
					e.setType(CROSS);
				else
					e.setType(FORWARD);
				break;
			}
		}
		v.setfStamp(clock++);v.setStatus(VISITED);
		return null;
	}

	@Override
	public Object algorithm(Vertex v) {
		// TODO Auto-generated method stub
		return null;
	}
}

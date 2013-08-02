package xuzhenzhen.structure.control;

import java.awt.Point;

import xuzhenzhen.structure.model.Graph;
import xuzhenzhen.structure.model.Vertex;

public class DragOperate implements Operation{
	private Graph graph;
	private int dx;
	private int dy;
	private boolean isMulti;
	public DragOperate(Graph graph, int dx, int dy, boolean isMulti) {
		this.graph = graph;
		this.dx = dx;
		this.dy = dy;
		this.isMulti = isMulti;
	}
	@Override
	public void operate() {
		// TODO Auto-generated method stub
		if(isMulti){
			for(Vertex v:graph.vertices()){
				Point p=v.getPosition();
				p.x=p.x+dx;
				p.y=p.y+dy;
				v.setPosition(p);
			}
		}
		else{
			for(Vertex v:graph.vertices()){
				if(v.getSelect()){
					Point p=v.getPosition();
					p.x=p.x+dx;
					p.y=p.y+dy;
					v.setPosition(p);
				}
			}
		}
		graph.positionRefresh();
	}

}

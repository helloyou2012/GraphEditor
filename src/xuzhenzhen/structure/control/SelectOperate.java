package xuzhenzhen.structure.control;

import java.awt.Point;
import xuzhenzhen.structure.global.Global;
import xuzhenzhen.structure.model.Edge;
import xuzhenzhen.structure.model.Graph;
import xuzhenzhen.structure.model.Vertex;

public class SelectOperate implements Operation{
	private Graph graph;
	private int x;
	private int y;
	private boolean isMulti;
	public SelectOperate(Graph graph, int x, int y, boolean isMulti) {
		this.graph = graph;
		this.x = x;
		this.y = y;
		this.isMulti = isMulti;
	}
	@Override
	public void operate() {
		// TODO Auto-generated method stub
		selectVertex();
		selectEdge();
		graph.selectedRefresh();
	}
	public void selectVertex(){
		int r=Global.getVertexImage(false).getHeight()/2;
		if(isMulti){
			for(Vertex v:graph.vertices()){
				Point p=v.getPosition();
				if(x>p.x-r&&x<p.x+r&&y>p.y-r&&y<p.y+r){
					v.setSelect(v.getSelect()?false:true);
				}
			}
		}
		else{
			boolean flag=true;
			for(Vertex v:graph.vertices()){
				Point p=v.getPosition();
				v.setSelect(false);
				if(x>p.x-r&&x<p.x+r&&y>p.y-r&&y<p.y+r&&flag){
					v.setSelect(true);flag=false;
				}
			}
		}
	}
	public void selectEdge(){
		if(isMulti){
			for(Edge e:graph.edges()){
				Point sp=e.getStartV().getPosition();
				Point ep=e.getEndV().getPosition();
				int x0=(sp.x+ep.x)/2;
				int y0=(sp.y+ep.y)/2;
				if(x>x0-30&&x<x0+30&&y>y0-7&&y<y0+7){
					e.setSelect(e.getSelect()?false:true);
				}
			}
		}
		else{
			boolean flag=true;
			for(Edge e:graph.edges()){
				Point sp=e.getStartV().getPosition();
				Point ep=e.getEndV().getPosition();
				int x0=(sp.x+ep.x)/2;
				int y0=(sp.y+ep.y)/2;
				if(x>x0-30&&x<x0+30&&y>y0-7&&y<y0+7&&flag){
					if(!e.getSelect()){
						e.setSelect(true);flag=false;
					}
					else e.setSelect(false);
				}
				else e.setSelect(false);
			}
		}
	}

}

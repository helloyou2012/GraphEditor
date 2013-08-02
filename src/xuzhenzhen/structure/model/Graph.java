package xuzhenzhen.structure.model;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;
import xuzhenzhen.structure.control.GraphListener;

public interface Graph extends Serializable{
	public int vNumber();//顶点数目
	public int eNumber();//边的数目
	public ArrayList<Edge> edges();//返回所有的边
	public ArrayList<Vertex> vertices();//返回所有的顶点
	public boolean hasEdge(Vertex from,Vertex to);
	public Edge edgeFromTo(Vertex from,Vertex to);
	public void insert(Vertex v);
	public void insert(Edge e);
	public void remove(Vertex v);
	public void remove(Edge e);
	public void show(Graphics g);
	public void addListener(GraphListener l);
	public void deleteSelected();
	public void positionRefresh();
	public void structureRefresh();
	public void selectedRefresh();
	public Vertex getFirstSelectedVertex();
	public Edge getFirstSelectedEdge();
	public Object[][] toArray();
}

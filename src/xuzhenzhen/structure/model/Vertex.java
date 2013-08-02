package xuzhenzhen.structure.model;

import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;


public interface Vertex extends Position,Serializable{
	public final static int UNDISCOVERED=0;
	public final static int DISCOVERED=1;
	public final static int VISITED=2;
	public int outDegree();//返回当前顶点的出度
	public int inDegree();//返回当前顶点的入度
	public ArrayList<Edge> inEdges();//返回所有入边的迭代器
	public ArrayList<Edge> outEdges();//返回所有出边的迭代器
	public void addInEdges(Edge e);
	public void addOutEdges(Edge e);
	public void removeInEdges(Edge e);
	public void removeOutEdges(Edge e);
	public void setSelect(boolean s);
	public boolean getSelect();
	public Point getPosition();
	public void setPosition(Point p);
	public int getStatus();
	public int setStatus(int s);
	public int getDistance();
	public int setDistance(int dis);
	public int getdStamp();
	public void setdStamp(int dStamp);
	public int getfStamp();
	public void setfStamp(int fStamp);
	public void show(Graphics g,int index);
}

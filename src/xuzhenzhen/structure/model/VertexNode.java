package xuzhenzhen.structure.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import xuzhenzhen.structure.global.Global;

public class VertexNode implements Vertex{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4820653812791695555L;
	protected Object info;
	protected ArrayList<Edge> outEdges;
	protected ArrayList<Edge> inEdges;
	protected Point position;//顶点位置
	protected boolean isSelect;
	protected int status;//顶点状态
	protected int distance;//到指定起点的距离
	protected int dStamp;//时间标签：DFS过程中该顶点被发现的时刻
	protected int fStamp;//时间标签：DFS过程中该顶点被访问结束时刻
	protected Vertex bfsParent;

	public VertexNode(Object info) {
		this.info = info;
		outEdges=new ArrayList<Edge>();
		inEdges=new ArrayList<Edge>();
		position=new Point(Global.getRandom(),Global.getRandom());
		status=UNDISCOVERED;
		dStamp=fStamp=Integer.MAX_VALUE;
		bfsParent=null;
		isSelect=false;
	}
	public VertexNode(Object info,Point pos){
		this.info = info;
		outEdges=new ArrayList<Edge>();
		inEdges=new ArrayList<Edge>();
		position=pos;
		status=UNDISCOVERED;
		dStamp=fStamp=Integer.MAX_VALUE;
		bfsParent=null;
	}
	public int getdStamp() {
		return dStamp;
	}

	public void setdStamp(int dStamp) {
		this.dStamp = dStamp;
	}

	public int getfStamp() {
		return fStamp;
	}

	public void setfStamp(int fStamp) {
		this.fStamp = fStamp;
	}
	@Override
	public Object getInfo() {
		// TODO Auto-generated method stub
		return info;
	}

	@Override
	public void setInfo(Object obj) {
		// TODO Auto-generated method stub
		this.info=obj;
	}

	@Override
	public int outDegree() {
		// TODO Auto-generated method stub
		return outEdges.size();
	}

	@Override
	public int inDegree() {
		// TODO Auto-generated method stub
		return inEdges.size();
	}

	@Override
	public ArrayList<Edge> inEdges() {
		// TODO Auto-generated method stub
		return inEdges;
	}

	@Override
	public ArrayList<Edge> outEdges() {
		// TODO Auto-generated method stub
		return outEdges;
	}

	@Override
	public int getStatus() {
		// TODO Auto-generated method stub
		return status;
	}

	@Override
	public int setStatus(int s) {
		// TODO Auto-generated method stub
		int temp=this.status;
		this.status=s;
		return temp;
	}

	@Override
	public int getDistance() {
		// TODO Auto-generated method stub
		return distance;
	}

	@Override
	public int setDistance(int dis) {
		// TODO Auto-generated method stub
		int temp=this.distance;
		this.distance=dis;
		return temp;
	}
	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return position;
	}
	@Override
	public void setPosition(Point p) {
		// TODO Auto-generated method stub
		this.position=p;
	}
	@Override
	public void show(Graphics g,int index) {
		// TODO Auto-generated method stub
		//System.out.println("显示节点"+position);
		Graphics2D g0=(Graphics2D)g;
		DataInfo data=(DataInfo)info;
		//画节点图像
		BufferedImage image=Global.getVertexImage(isSelect);
		int iWidth=image.getWidth();
		int iHeight=image.getHeight();
		g0.drawImage(image, position.x-iWidth/2,position.y-iHeight/2, iWidth, iHeight,null);
		//画节点名字
		Color color=isSelect?Color.red:Color.blue;
		Global.drawText(g, position.x, position.y+iHeight/2, data.getName(), color);
		Global.drawCenterText(g, position.x, position.y,index+"", Color.yellow);
	}
	@Override
	public void addInEdges(Edge e) {
		// TODO Auto-generated method stub
		inEdges.add(e);
	}
	@Override
	public void addOutEdges(Edge e) {
		// TODO Auto-generated method stub
		outEdges.add(e);
	}
	@Override
	public void removeInEdges(Edge e) {
		// TODO Auto-generated method stub
		inEdges.remove(e);
	}
	@Override
	public void removeOutEdges(Edge e) {
		// TODO Auto-generated method stub
		outEdges.remove(e);
	}
	@Override
	public void setSelect(boolean s) {
		// TODO Auto-generated method stub
		this.isSelect=s;
	}
	@Override
	public boolean getSelect() {
		// TODO Auto-generated method stub
		return isSelect;
	}
}

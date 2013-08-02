package xuzhenzhen.structure.model;

import java.awt.Graphics;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import xuzhenzhen.structure.control.GraphListener;

public class GraphList implements Graph{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4578408825163263685L;
	protected ArrayList<Edge>edges;
	protected ArrayList<Vertex>vertices;
	private transient ArrayList<GraphListener>listeners;

	public GraphList() {
		this.edges =new ArrayList<Edge>();
		this.vertices =new ArrayList<Vertex>();
		this.listeners=new ArrayList<GraphListener>();
	}
	public void addListener(GraphListener l){
		if(listeners!=null)
		this.listeners.add(l);
	}
	@Override
	public int vNumber() {
		// TODO Auto-generated method stub
		return vertices.size();
	}

	@Override
	public int eNumber() {
		// TODO Auto-generated method stub
		return edges.size();
	}

	@Override
	public ArrayList<Edge> edges() {
		// TODO Auto-generated method stub
		return edges;
	}

	@Override
	public ArrayList<Vertex> vertices() {
		// TODO Auto-generated method stub
		return vertices;
	}

	@Override
	public boolean hasEdge(Vertex from, Vertex to) {
		// TODO Auto-generated method stub
		return edgeFromTo(from, to)!=null;
	}

	@Override
	public void insert(Vertex v) {
		// TODO Auto-generated method stub
		vertices.add(v);
	}

	@Override
	public void insert(Edge e) {
		// TODO Auto-generated method stub
		edges.add(e);
	}

	@Override
	public void remove(Vertex v) {
		// TODO Auto-generated method stub
		while(v.outEdges().size()>0){
			remove(v.outEdges().get(0));
		}
		while(v.inEdges().size()>0){
			remove(v.inEdges().get(0));
		}
		vertices.remove(v);
	}

	@Override
	public void remove(Edge e) {
		// TODO Auto-generated method stub
		e.getStartV().removeOutEdges(e);
		e.getEndV().removeInEdges(e);
		edges.remove(e);
	}

	@Override
	public Edge edgeFromTo(Vertex from, Vertex to) {
		// TODO Auto-generated method stub
		for(Edge e:from.outEdges()){
			if(e.getEndV()==to){
				return e;
			}
		}
		return null;
	}

	@Override
	public void show(Graphics g) {
		// TODO Auto-generated method stub
		int index=0;
		for(Vertex v:vertices){
			if(!v.getSelect())v.show(g,index);
			index++;
		}
		index=0;
		for(Vertex v:vertices){
			if(v.getSelect())v.show(g,index);
			index++;
		}
		for(Edge e:edges){
			if(!e.getSelect())e.show(g);
		}
		for(Edge e:edges){
			if(e.getSelect())e.show(g);
		}
	}
	@Override
	public void deleteSelected() {
		// TODO Auto-generated method stub
		int i=0;
		while(i<vertices.size()){
			if(vertices.get(i).getSelect()){
				remove(vertices.get(i));
			}
			else i++;
		}
		i=0;
		while(i<edges.size()){
			if(edges.get(i).getSelect()){
				remove(edges.get(i));
			}
			else i++;
		}
	}
	@Override
	public void positionRefresh() {
		// TODO Auto-generated method stub
		for(GraphListener l:listeners){
			l.graphPositionChange(this);
		}
	}
	@Override
	public void structureRefresh() {
		// TODO Auto-generated method stub
		for(GraphListener l:listeners){
			l.graphStructureChange(this);
		}
	}
	@Override
	public void selectedRefresh() {
		// TODO Auto-generated method stub
		for(GraphListener l:listeners){
			l.graphSelectedChange(this);
		}
	}
	@Override
	public Vertex getFirstSelectedVertex() {
		// TODO Auto-generated method stub
		for(Vertex v:vertices){
			if(v.getSelect())return v;
		}
		return null;
	}
	@Override
	public Edge getFirstSelectedEdge() {
		// TODO Auto-generated method stub
		for(Edge e:edges){
			if(e.getSelect())return e;
		}
		return null;
	}
	@Override
	public Object[][] toArray() {
		// TODO Auto-generated method stub
		if(vNumber()>0){
			Object[][] graphMatrix=new Object[vNumber()][vNumber()];
			for(int i=0;i<vNumber();i++){
				for(Edge e:vertices.get(i).outEdges()){
					int j=vertices.indexOf(e.getEndV());
					DataInfo info=(DataInfo)e.getInfo();
					graphMatrix[i][j]=info.getWeight();
				}
			}
			return graphMatrix;
		}
		return null;
	}
	private void readObject(ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		// 类型必须为private，而且名称和自变量格式都不能改
		in.defaultReadObject();
		listeners=new ArrayList<GraphListener>();
		System.out.println("在文件中加载对象");
	}
	private void writeObject(ObjectOutputStream out) throws IOException {
		// 类型必须为private，而且名称和自变量格式都不能改
		out.defaultWriteObject();
		System.out.println("已向文件中写入对象");
	}
}

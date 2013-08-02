package xuzhenzhen.structure.dealer;

import java.util.LinkedList;

import xuzhenzhen.structure.model.DataInfo;
import xuzhenzhen.structure.model.Graph;

public class PathList {
	private Object[][] path;
	private Graph graph;
	private int from;
	private int to;
	public PathList(Object[][] path,Graph graph,int from, int to) {
		this.path = path;
		this.graph=graph;
		this.from = from;
		this.to = to;
	}
	public LinkedList<String> getPath(){
		LinkedList<String> list=new LinkedList<String>();
		DataInfo info=(DataInfo)graph.vertices().get(to).getInfo();
		list.addFirst("("+to+"—"+info.getName()+")");
		Object elem=path[from][to];
		if(elem==null)return null;
		int index=(Integer)elem;
		if(index==to)return null;
		while(index!=from){
			info=(DataInfo)graph.vertices().get(index).getInfo();
			list.addFirst("("+index+"—"+info.getName()+")");
			elem=path[from][index];
			index=(Integer)elem;
		}
		info=(DataInfo)graph.vertices().get(from).getInfo();
		list.addFirst("("+from+"—"+info.getName()+")");
		return list;
	}
}

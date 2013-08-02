package xuzhenzhen.structure.template;

import xuzhenzhen.structure.model.Graph;

public class DijkstraAlgorithm implements GraphAlgorithm{
	private Object[][] distanceMatrix;
	private Object[][] pathMatrix;
	private int sourse;
	private boolean isSingle;
	public DijkstraAlgorithm(Graph graph){
		this.isSingle=false;
		this.distanceMatrix=graph.toArray();
		init();
	}
	public DijkstraAlgorithm(Graph graph,int sourse){
		this.sourse=sourse;
		this.distanceMatrix=graph.toArray();
		this.isSingle=true;
		init();
	}
	@Override
	public Object[][] getDistanceMatrix() {
		// TODO Auto-generated method stub
		return distanceMatrix;
	}

	@Override
	public Object[][] getPathMatrix() {
		// TODO Auto-generated method stub
		return pathMatrix;
	}
	public void init(){
		if(distanceMatrix!=null&&distanceMatrix.length>1){
			int len=distanceMatrix.length;
			pathMatrix=new Object[len][len];
		}
	}
	public void shortestPath(int index){
		if(distanceMatrix!=null&&distanceMatrix.length>1){
			int len=distanceMatrix.length;
			boolean[] isfinal=new boolean[len];
			for(int i=0;i<len;i++){
				isfinal[i]=false;
				if(distanceMatrix[index][i]!=null){
					pathMatrix[index][i]=index;
				}
			}
			distanceMatrix[index][index]=0;
			pathMatrix[index][index]=index;
			isfinal[index]=true;
			int v=0;
			for(int i=1;i<len;i++){
				Integer min=null;
				for(int j=0;j<len;j++){
					if(!isfinal[j]&&isBiger(min, distanceMatrix[index][j])){
						v=j;min=(Integer)distanceMatrix[index][j];
					}
				}
				isfinal[v]=true;//选中一个最近的顶点
				for(int j=0;j<len;j++){//更新最短距离和路径
					if(!isfinal[j]&&!isBiger(min, distanceMatrix[v][j], distanceMatrix[index][j])){
						distanceMatrix[index][j]=min+(Integer)distanceMatrix[v][j];
						pathMatrix[index][j]=v;
					}
				}
			}
		}
	}
	public boolean isBiger(Object a,Object b){//a>b
		if(b==null)return false;
		if(a==null)return true;
		int a0=(Integer)a;
		int b0=(Integer)b;
		return a0>b0;
	}
	public boolean isBiger(Object a,Object b,Object c){//a+b>c
		if(a==null||b==null)return true;
		if(c==null)return false;
		int a0=(Integer)a;
		int b0=(Integer)b;
		int c0=(Integer)c;
		return a0+b0>=c0;
	}
	@Override
	public void algorithm() {
		// TODO Auto-generated method stub
		if(isSingle)shortestPath(sourse);
		else{
			for(int i=0;i<distanceMatrix.length;i++){
				shortestPath(i);
			}
		}
	}

}

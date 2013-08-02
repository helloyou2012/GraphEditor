package xuzhenzhen.structure.template;

import xuzhenzhen.structure.global.Global;
import xuzhenzhen.structure.model.Graph;

public class FloydAlgorithm implements GraphAlgorithm{
	private Object[][] distanceMatrix;
	private Object[][] pathMatrix;
	public FloydAlgorithm(Graph graph) {
		distanceMatrix=graph.toArray();
		init();
	}
	public void init(){
		if(distanceMatrix!=null&&distanceMatrix.length>1){
			int len=distanceMatrix.length;
			pathMatrix=new Object[len][len];
			for(int i=0;i<len;i++){
				distanceMatrix[i][i]=0;
				for(int j=0;j<len;j++){
					if(distanceMatrix[i][j]!=null)
						pathMatrix[i][j]=i;//初始化路径
				}
			}
		}
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

	@Override
	public void algorithm() {//改！！！！
		// TODO Auto-generated method stub
		if(distanceMatrix!=null&&distanceMatrix.length>1){
			int len=distanceMatrix.length;
			for(int k=0;k<len;k++){
				for(int i=0;i<len;i++)
					for(int j=0;j<len;j++){
						if(!Global.isBigger(distanceMatrix[i][k],distanceMatrix[k][j],distanceMatrix[i][j])){
							distanceMatrix[i][j]=(Integer)distanceMatrix[i][k]+(Integer)distanceMatrix[k][j];
							pathMatrix[i][j]=pathMatrix[i][k];
						}
					}
			}
		}
	}

}

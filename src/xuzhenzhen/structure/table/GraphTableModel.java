package xuzhenzhen.structure.table;

import javax.swing.table.AbstractTableModel;

import xuzhenzhen.structure.model.DataInfo;
import xuzhenzhen.structure.model.Edge;
import xuzhenzhen.structure.model.Graph;

public class GraphTableModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7898698446534815290L;
	private Graph graph;
	private Object[][] elements;
	private String[] headName;
	@Override
	public String getColumnName(int col) {
		// TODO Auto-generated method stub
		if(col==0)return "";
		return headName[col-1];
	}
	public GraphTableModel(Graph graph) {
		this.graph = graph;
		loadElements();
	}
	public void reLoad(Graph g){
		this.graph = g;
		loadElements();
	}
	public void loadElements(){
		if(graph!=null){
			int n=graph.vNumber();
			if(n>0){
				elements=new Object[n][n];
				headName=new String[n];
				for(int i=0;i<n;i++){
					elements[i][i]="—";
					headName[i]=i+"";
					for(Edge e:graph.vertices().get(i).outEdges()){
						int j=graph.vertices().indexOf(e.getEndV());
						DataInfo info=(DataInfo)e.getInfo();
						elements[i][j]=info.getWeight();
					}
				}
			}
			else elements=null;
		}
		else elements=null;
	}
	@Override
	public boolean isCellEditable(int row, int col) {
		// TODO Auto-generated method stub
		if(col==0||col-1==row)return false;
		else return true;
	}

	@Override
	public void setValueAt(Object elem, int row, int col) {
		// TODO Auto-generated method stub
		if(col>0)
			elements[row][col-1]=elem;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		if(headName!=null)
			return headName.length+1;
		return 0;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		if(headName!=null)
			return headName.length;
		return 0;
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		if(col==0)return headName[row];
		if(elements!=null)
			return elements[row][col-1];
		return null;
	}
}
package xuzhenzhen.structure.view;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import xuzhenzhen.structure.control.GraphListener;
import xuzhenzhen.structure.dealer.PathList;
import xuzhenzhen.structure.global.Global;
import xuzhenzhen.structure.model.Graph;
import xuzhenzhen.structure.table.MatrixModel;
import xuzhenzhen.structure.table.RowHeaderRenderer;
import xuzhenzhen.structure.template.DijkstraAlgorithm;
import xuzhenzhen.structure.template.FloydAlgorithm;
import xuzhenzhen.structure.template.GraphAlgorithm;

public class ShortestPathPanel extends JPanel implements GraphListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8593506566026429843L;
	public static final int DIJKSTRA=0;
	public static final int FLOYD=1;
	private JTable table;
	private JLabel label;
	private Graph graph;
	private JScrollPane scrollPane;
	private Object[][] pathMatrix;
	private boolean isChange;
	public ShortestPathPanel(Graph graph) {
		this.graph = graph;
		isChange=true;
	}
	public void runSPTAlgorithm(int mode){
		if(graph!=null){
			GraphAlgorithm fun=null;
			if(mode==DIJKSTRA)fun=new DijkstraAlgorithm(graph);
			else fun=new FloydAlgorithm(graph);
			fun.algorithm();
			Object[][] disMat=fun.getDistanceMatrix();
			pathMatrix=fun.getPathMatrix();
			Global.showMatrix(disMat);
			Global.showMatrix(pathMatrix);
			if(disMat!=null){
				MatrixModel model=new MatrixModel(disMat);
				table=new JTable(model);
				table.setCellSelectionEnabled(true);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table.getColumnModel().getColumn(0).setCellRenderer(new RowHeaderRenderer());
				table.getTableHeader().setReorderingAllowed(false);
				table.addMouseListener(new MouseClickListener());
				graph.addListener(this);
				scrollPane=new JScrollPane(table);
				label=new JLabel("路线：");
				removeAll();//移除所有组件
				setLayout(new BorderLayout());
				add(scrollPane,BorderLayout.CENTER);
				add(label,BorderLayout.SOUTH);
				validate();
				isChange=false;
			}
		}
	}
	@Override
	public void graphPositionChange(Graph g) {
		//DoNothing
	}
	@Override
	public void graphStructureChange(Graph g) {
		// TODO Auto-generated method stub
		this.graph=g;
		this.isChange=true;
	}
	public boolean isChange() {
		return isChange;
	}
	public void setChange(boolean isChange) {
		this.isChange = isChange;
	}
	@Override
	public void graphSelectedChange(Graph g) {
		//DoNothing
	}
	public class MouseClickListener extends MouseAdapter{//内部类
		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("路径改变");
			if(table!=null){
				int from=table.getSelectedRow();
				int to=table.getSelectedColumn()-1;
				if(from>=0&&to>=0){
					PathList pathList=new PathList(pathMatrix, graph, from, to);
					LinkedList<String> path=pathList.getPath();
					String pathStr;
					if(path==null)pathStr="没有路径！";
					else{
						pathStr="最短路径为：";
						for(int i=0;i<path.size()-1;i++){
							pathStr=pathStr+path.get(i)+"—>";
						}
						pathStr=pathStr+path.getLast();
					}
					label.setText(pathStr);
					validate();
				}			
			}
		}
	}
}

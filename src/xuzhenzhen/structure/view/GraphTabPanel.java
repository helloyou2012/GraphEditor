package xuzhenzhen.structure.view;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import xuzhenzhen.structure.control.MatrixController;
import xuzhenzhen.structure.control.ViewController;
import xuzhenzhen.structure.model.Graph;

public class GraphTabPanel extends JTabbedPane implements ChangeListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1231285780035700598L;
	private Graph graph;
	private JPanel viewAndListPanel;
	private VEMatrixPanel matrixPanel;
	private ShortestPathPanel pathPanel;
	private int shortPathType=0;

	public GraphTabPanel(Graph g) {
		this.graph = g;
		initViewAndListPanel();
		initMatrixPanel();
		initPathPanel();
		addChangeListener(this);
	}
	public void initViewAndListPanel(){//装配View和List面板（包括控制器）
		viewAndListPanel=new JPanel(new BorderLayout());
		ViewPanel viewPanel=new ViewPanel(graph);
		VEListPanel listPanel=new VEListPanel(graph);
		ViewController c=new ViewController(graph, viewPanel);
		viewPanel.addMouseListener(c);
		viewPanel.addMouseMotionListener(c);
		graph.addListener(c);
		viewAndListPanel.add(viewPanel,BorderLayout.CENTER);
		viewAndListPanel.add(listPanel,BorderLayout.EAST);
		addTab("显示图", viewAndListPanel);
	}
	public void initMatrixPanel(){//装配Matrix(邻接矩阵)面板（包括控制器）
		matrixPanel=new VEMatrixPanel(graph);
		MatrixController c=new MatrixController(matrixPanel);
		graph.addListener(c);
		matrixPanel.addSaveListener(c);
		addTab("邻接矩阵表", matrixPanel);
	}
	public void initPathPanel(){
		pathPanel=new ShortestPathPanel(graph);
		addTab("最短路径表", pathPanel);
	}
	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("tab已经更改");
		int index=this.getSelectedIndex();
		String tab=this.getTitleAt(index);
		if(tab.equals("邻接矩阵表")){
			if(matrixPanel.getChange())
				matrixPanel.reLoad();
		}
		if(tab.equals("最短路径表")){
			if(pathPanel.isChange()){
				int result=JOptionPane.showConfirmDialog(null, "图已更新，是否重新运行最短路径算法？", "提示",
						JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if(result==JOptionPane.YES_OPTION){
					pathPanel.runSPTAlgorithm(shortPathType);
				}
			}
		}
	}
	public void runSPT(){
		if(pathPanel!=null){
			pathPanel.runSPTAlgorithm(shortPathType);
		}
	}
	public int getShortPathType(){
		return shortPathType;
	}
	public void setShortPathType(int type){
		this.shortPathType=type;
	}
}

package xuzhenzhen.structure.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import xuzhenzhen.structure.model.Graph;
import xuzhenzhen.structure.table.GraphTableModel;
import xuzhenzhen.structure.table.RowHeaderRenderer;
import xuzhenzhen.structure.table.TableSaveGraph;

public class VEMatrixPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7547454623196073196L;
	private Graph graph;
	private JTable table;
	private JButton saveBtn;
	private boolean isChange;
	public VEMatrixPanel(Graph g){
		this.graph = g;
		init();
		isChange=false;
	}
	public void init(){
		saveBtn=new JButton("保存");
		setLayout(new BorderLayout());
		table=new JTable(new GraphTableModel(graph));
		table.setCellSelectionEnabled(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		if(graph!=null&&graph.vNumber()>0){
			table.getColumnModel().getColumn(0).setCellRenderer(new RowHeaderRenderer());
			table.getTableHeader().setReorderingAllowed(false);
		}		
        JScrollPane scrollPanel = new JScrollPane(table);
        add(scrollPanel,BorderLayout.CENTER);
        JPanel panel=new JPanel();
        panel.add(saveBtn);
        add(panel,BorderLayout.SOUTH);
	}
	public void addSaveListener(ActionListener l){
		saveBtn.addActionListener(l);
	}
	public void dealSave(){
		TableSaveGraph save=new TableSaveGraph(table, graph);
		Thread thread=new Thread(save);
		thread.start();
	}
	public void reLoad(){
		System.out.println("重新更新……");
		if(graph!=null&&graph.vNumber()>0){
			table.setModel(new GraphTableModel(graph));
			table.getColumnModel().getColumn(0).setCellRenderer(new RowHeaderRenderer());
			table.revalidate();//重新自动布局
			isChange=false;
		}
	}
	public void setChange(Graph g){
		this.graph=g;
		this.isChange=true;
	}
	public boolean getChange(){
		return this.isChange;
	}
}

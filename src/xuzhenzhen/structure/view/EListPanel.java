package xuzhenzhen.structure.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.FocusListener;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import xuzhenzhen.structure.model.DataInfo;
import xuzhenzhen.structure.model.Edge;
import xuzhenzhen.structure.model.Graph;

public class EListPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 380647190678599909L;
	private JComboBox eBox;
	private JTextField eName;
	private JTextField eWeight;
	private JTextField eFrom;
	private JTextField eTo;
	private Graph graph;
	public boolean enableChange;
	public EListPanel(Graph graph) {
		enableChange=true;
		this.graph = graph;
		init();
		loadGraph(graph);
		refresh(graph);
	}
	public void init(){
		setBackground(Color.lightGray);
		setPreferredSize(new Dimension(200, 170));
		setLayout(new GridLayout(5, 2,0,5));
		setBorder(BorderFactory.createTitledBorder("边的信息"));
		eBox=new JComboBox();
		eFrom=new JTextField();
		eTo=new JTextField();
		eName=new JTextField();
		eWeight=new JTextField();
		add(new JLabel("边："));
		add(eBox);
		add(new JLabel("名称："));
		add(eName);
		add(new JLabel("权值："));
		add(eWeight);
		add(new JLabel("起点："));
		add(eFrom);
		add(new JLabel("终点："));
		add(eTo);
		eFrom.setEditable(false);
		eTo.setEditable(false);
	}
	public void addItemListener(ItemListener l){
		eBox.addItemListener(l);
	}
	public void addFocusListeners(FocusListener l){
		eName.addFocusListener(l);
		eWeight.addFocusListener(l);
	}
	public void loadGraph(Graph g){
		if(g!=null){
			this.graph=g;
			if(eBox.getItemCount()>0)eBox.removeAllItems();
			int n=graph.eNumber();
			for(int i=0;i<n;i++){
				DataInfo info=(DataInfo)graph.edges().get(i).getInfo();
				eBox.addItem(i+"—"+info.getName());
			}
		}
	}
	public void refresh(Graph g){
		this.graph=g;
		if(graph!=null){
			Edge e=graph.getFirstSelectedEdge();
			if(e!=null){
				enableChange=false;
				eBox.setSelectedIndex(graph.edges().indexOf(e));
				enableChange=true;
				DataInfo data=(DataInfo)e.getInfo();
				eName.setText(data.getName());
				eWeight.setText(data.getWeight()+"");
				eFrom.setText(graph.vertices().indexOf(e.getStartV())+"");
				eTo.setText(graph.vertices().indexOf(e.getEndV())+"");
			}
		}
	}
	public int getSelectedIndex(){
		return eBox.getSelectedIndex();
	}
	public String getName(){
		return eName.getText();
	}
	public String getWeight(){
		return eWeight.getText();
	}
}

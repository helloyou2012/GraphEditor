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
import xuzhenzhen.structure.model.Graph;
import xuzhenzhen.structure.model.Vertex;

public class VListPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6870701213160353731L;
	private JComboBox vBox;
	private JTextField vName;
	private JTextField vWeight;
	private Graph graph;
	public boolean enableChange;
	public VListPanel(Graph graph) {
		enableChange=true;
		this.graph = graph;
		init();
		loadGraph(graph);
		refresh(graph);
	}
	public void init(){
		setBackground(Color.lightGray);
		setPreferredSize(new Dimension(200, 110));
		setLayout(new GridLayout(3, 2,0,5));
		setBorder(BorderFactory.createTitledBorder("结点信息"));
		vBox=new JComboBox();
		vName=new JTextField();
		vWeight=new JTextField();
		add(new JLabel("结点："));
		add(vBox);
		add(new JLabel("名称："));
		add(vName);
		add(new JLabel("权值："));
		add(vWeight);
	}
	public void addItemListener(ItemListener l){
		vBox.addItemListener(l);
	}
	public void addFocusListeners(FocusListener l){
		vName.addFocusListener(l);
		vWeight.addFocusListener(l);
	}
	public void loadGraph(Graph g){
		if(g!=null){
			this.graph=g;
			if(vBox.getItemCount()>0)vBox.removeAllItems();
			int n=graph.vNumber();
			for(int i=0;i<n;i++){
				DataInfo info=(DataInfo)graph.vertices().get(i).getInfo();
				vBox.addItem(i+"—"+info.getName());
			}
		}
	}
	public void refresh(Graph g){
		this.graph=g;
		if(graph!=null){
			Vertex v=graph.getFirstSelectedVertex();
			if(v!=null){
				enableChange=false;
				vBox.setSelectedIndex(graph.vertices().indexOf(v));
				enableChange=true;
				DataInfo data=(DataInfo)v.getInfo();
				vName.setText(data.getName());
				vWeight.setText(data.getWeight()+"");
			}
		}
	}
	public int getSelectedIndex(){
		return vBox.getSelectedIndex();
	}
	public String getName(){
		return vName.getText();
	}
	public String getWeight(){
		return vWeight.getText();
	}
}

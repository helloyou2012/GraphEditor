package xuzhenzhen.structure.dialog;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import xuzhenzhen.structure.control.AddEdgeOperate;
import xuzhenzhen.structure.model.DataInfo;
import xuzhenzhen.structure.model.Graph;
import xuzhenzhen.structure.model.Vertex;

public class AddEdgeDialog implements ActionListener{
	private JDialog dialog;
	private JComboBox fromBox;
	private JComboBox toBox;
	private JTextField nameText;
	private JTextField weightText;
	private JButton addBtn;
	private Graph graph;
	public AddEdgeDialog(Graph g) {
		this.graph = g;
		init();
		loadBox(graph);
	}
	public void init(){
		dialog = new JDialog(new JDialog(),"添加边",true);
		fromBox=new JComboBox();
		toBox=new JComboBox();
		nameText=new JTextField();
		weightText=new JTextField();
		addBtn=new JButton("添加");
		addBtn.addActionListener(this);
		dialog.setLayout(new BorderLayout());
		JPanel panel=new JPanel(new GridLayout(4, 2,1,2));
		panel.add(new JLabel("起点：",JLabel.CENTER));
		panel.add(fromBox);
		panel.add(new JLabel("终点：",JLabel.CENTER));
		panel.add(toBox);
		panel.add(new JLabel("名称：",JLabel.CENTER));
		panel.add(nameText);
		panel.add(new JLabel("权值：",JLabel.CENTER));
		panel.add(weightText);
		JPanel btnPanel=new JPanel(new GridLayout(1, 3));
		btnPanel.add(new JLabel());
		btnPanel.add(addBtn);
		btnPanel.add(new JLabel());
		dialog.add(panel,BorderLayout.CENTER);
		dialog.add(btnPanel,BorderLayout.SOUTH);
        dialog.setSize(200, 150);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
	}
	public void show(){
		dialog.setVisible(true);
	}
	public void loadBox(Graph g){
		this.graph=g;
		if(graph!=null){
			if(fromBox.getItemCount()>0)fromBox.removeAllItems();
			if(toBox.getItemCount()>0)toBox.removeAllItems();
			int i=0;
			for(Vertex v:graph.vertices()){
				DataInfo info=(DataInfo)v.getInfo();
				String item=i+"—"+info.getName();
				fromBox.addItem(item);
				toBox.addItem(item);
				i++;
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("添加")){
			int from=fromBox.getSelectedIndex();
			int to=toBox.getSelectedIndex();
			if(from!=to){
				String name=nameText.getText();
				int weight;
				try {
					weight=new Integer(weightText.getText());
					if(name.length()>0){
						AddEdgeOperate op=new AddEdgeOperate(graph, from, to, name, weight);
						op.operate();
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "输入数据错误！","警告", JOptionPane.ERROR_MESSAGE);
				}
			}
			else
				JOptionPane.showMessageDialog(null, "起点和终点不能重合！","警告", JOptionPane.ERROR_MESSAGE);
		}
	}
}

package xuzhenzhen.structure.dialog;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import xuzhenzhen.structure.control.AddVertexOperate;
import xuzhenzhen.structure.model.Graph;

public class AddVertexDialog implements ActionListener{
	private JDialog dialog;
	private JTextField nameText;
	private JTextField weightText;
	private JButton addBtn;
	private Graph graph;
	public AddVertexDialog(Graph graph) {
		this.graph = graph;
		init();
	}
	public void init(){
		nameText=new JTextField();
		weightText=new JTextField();
		addBtn=new JButton("添加");
		dialog = new JDialog(new JDialog(),"添加结点",true);
		addBtn.addActionListener(this);
		GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c;
        dialog.setLayout(gridbag);
        Insets insets=new Insets(2, 2, 2, 2);
        int anchor = GridBagConstraints.CENTER;
        int fill = GridBagConstraints.BOTH;   
        c=new GridBagConstraints(0, 0, 1, 1, 0, 0, anchor, fill, insets, 0, 0);
        JLabel label=new JLabel("结点名称：");//标签
        gridbag.setConstraints(label, c);
        dialog.add(label);
        c=new GridBagConstraints(1, 0, 3, 1, 2, 0, anchor, fill, insets, 0, 0);
        gridbag.setConstraints(nameText, c);//文本框
        dialog.add(nameText);
        c=new GridBagConstraints(0, 1, 1, 1, 0, 0, anchor, fill, insets, 0, 0);
        label=new JLabel("结点权值：");//标签
        gridbag.setConstraints(label, c);
        dialog.add(label);
        c=new GridBagConstraints(1, 1, 3, 1, 2, 0, anchor, fill, insets, 0, 0);
        gridbag.setConstraints(weightText, c);//文本框
        dialog.add(weightText);
        c=new GridBagConstraints(0, 2, 1, 1, 0, 0, anchor, fill, insets, 0, 0);
        label=new JLabel();//标签
        gridbag.setConstraints(label, c);
        dialog.add(label);
        c=new GridBagConstraints(1, 2, 1, 1, 0, 0, anchor, fill, insets, 0, 0);
        gridbag.setConstraints(addBtn, c);//按钮
        dialog.add(addBtn);
        c=new GridBagConstraints(2, 2, 1, 1, 0, 0, anchor, fill, insets, 0, 0);
        label=new JLabel();//标签
        gridbag.setConstraints(label, c);
        dialog.add(label);
        dialog.setSize(200, 120);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);        
	}
	public void show(){
		dialog.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("添加")){
			String name=nameText.getText();
			int weight;
			try {
				weight=new Integer(weightText.getText());
				if(name.length()>0){
					AddVertexOperate op=new AddVertexOperate(graph, name, weight);
					op.operate();
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "输入数据错误！","警告", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}

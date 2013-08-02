package xuzhenzhen.structure.dialog;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SetSptDialog extends JDialog implements ItemListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5423036163712483007L;
	private int pathType;
	private JRadioButton radio1;
	private JRadioButton radio2;
	public SetSptDialog(int type){
		super(new JDialog(),"设置最短路径算法",true);
		this.pathType=type;
		init();
	}
	public void init(){
		JPanel panel=new JPanel(new GridLayout(2,1));
		panel.setBorder(BorderFactory.createTitledBorder("请选择最短路径算法"));
		ButtonGroup group=new ButtonGroup();
		radio1=new JRadioButton("Dijkstra算法");
		radio2=new JRadioButton("Floyd算法");
		radio1.addItemListener(this);
		radio2.addItemListener(this);
		group.add(radio1);
		group.add(radio2);
		panel.add(radio1);
		panel.add(radio2);
		if(pathType==0)group.setSelected(radio1.getModel(), true);
		else group.setSelected(radio2.getModel(), true);
		add(panel);
		setSize(200, 120);
        setResizable(false);
        //setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);//设置按键close可以使用
        setLocationRelativeTo(null);//居中显示
        setVisible(true);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==radio1)
			pathType=0;
		if(e.getSource()==radio2)
			pathType=1;
	}
	public int getPathType() {
		return pathType;
	}
}

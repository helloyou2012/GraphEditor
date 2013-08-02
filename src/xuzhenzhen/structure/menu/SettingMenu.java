package xuzhenzhen.structure.menu;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class SettingMenu extends JMenu{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7050620073635710388L;
	private JMenuItem setSptItem;//设置最短路径菜单
	public SettingMenu(){
		super("设置");
		init();
	}
	public void init(){
		setSptItem=new JMenuItem("设置最短路径算法");
		setSptItem.setAccelerator(KeyStroke.getKeyStroke('P', java.awt.Event.CTRL_MASK, false));
		add(setSptItem);
		addSeparator();
	}
	public void addListener(ActionListener l){
		setSptItem.addActionListener(l);
	}
}

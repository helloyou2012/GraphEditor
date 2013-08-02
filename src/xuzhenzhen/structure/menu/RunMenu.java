package xuzhenzhen.structure.menu;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class RunMenu extends JMenu{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3722963943121200042L;
	private JMenuItem runSptItem;//运行最短路径菜单
	public RunMenu(){
		super("运行");
		init();
	}
	public void init(){
		runSptItem=new JMenuItem("运行最短路径算法");
		runSptItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F11, java.awt.Event.CTRL_MASK, false));
		add(runSptItem);
		addSeparator();
	}
	public void addListener(ActionListener l){
		runSptItem.addActionListener(l);
	}
}

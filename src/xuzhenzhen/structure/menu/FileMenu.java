package xuzhenzhen.structure.menu;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class FileMenu extends JMenu{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1947037514719958995L;
	private JMenuItem openItem;
	private JMenuItem newItem;
	private JMenuItem saveItem;
	private JMenuItem exportItem;
	private JMenuItem importItem;
	private JMenuItem exitItem;
	public FileMenu(){
		super("文件");
		setMnemonic('F');
		init();
	}
	public void init(){
		openItem=new JMenuItem("打开",new ImageIcon("icons/open.gif"));
		newItem=new JMenuItem("新建",new ImageIcon("icons/new.gif"));
		saveItem=new JMenuItem("保存",new ImageIcon("icons/save.gif"));
		exportItem=new JMenuItem("导出",new ImageIcon("icons/export.gif"));
		importItem=new JMenuItem("导入",new ImageIcon("icons/import.gif"));
		exitItem=new JMenuItem("退出");
		openItem.setAccelerator(KeyStroke.getKeyStroke('O', java.awt.Event.CTRL_MASK, false));
		saveItem.setAccelerator(KeyStroke.getKeyStroke('S', java.awt.Event.CTRL_MASK, false));
		exportItem.setAccelerator(KeyStroke.getKeyStroke('E', java.awt.Event.CTRL_MASK, false));
		importItem.setAccelerator(KeyStroke.getKeyStroke('I', java.awt.Event.CTRL_MASK, false));
		exitItem.setAccelerator(KeyStroke.getKeyStroke('X', java.awt.Event.CTRL_MASK, false));
		add(openItem);
		add(newItem);
		add(saveItem);
		addSeparator();
		add(exportItem);
		add(importItem);
		addSeparator();
		add(exitItem);
	}
	public void addListener(ActionListener l){
		openItem.addActionListener(l);
		newItem.addActionListener(l);
		saveItem.addActionListener(l);
		exportItem.addActionListener(l);
		importItem.addActionListener(l);
		exitItem.addActionListener(l);
	}
}

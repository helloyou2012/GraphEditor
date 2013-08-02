package xuzhenzhen.structure.menu;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class EditMenu extends JMenu{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6831807134046720240L;
	private JMenuItem deleteItem;
	private JMenuItem addVertexItem;
	private JMenuItem addEdgeItem;
	private JMenuItem addDefaultVertexItem;
	public EditMenu(){
		super("编辑");
		setMnemonic('E');
		init();
	}
	public void init(){
		deleteItem=new JMenuItem("删除选中内容",new ImageIcon("icons/delete.gif"));
		addVertexItem=new JMenuItem("添加结点",new ImageIcon("icons/addv.gif"));
		addEdgeItem=new JMenuItem("添加边",new ImageIcon("icons/adde.gif"));
		addDefaultVertexItem=new JMenuItem("默认添加结点");
		deleteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,0));
		addVertexItem.setAccelerator(KeyStroke.getKeyStroke('V', java.awt.Event.SHIFT_MASK, false));
		addEdgeItem.setAccelerator(KeyStroke.getKeyStroke('E', java.awt.Event.SHIFT_MASK, false));
		addDefaultVertexItem.setAccelerator(KeyStroke.getKeyStroke('D', java.awt.Event.SHIFT_MASK, false));
		add(deleteItem);
		addSeparator();
		add(addVertexItem);
		add(addEdgeItem);
		addSeparator();
		add(addDefaultVertexItem);
		addMenuListener(new MenuChangeListener());
	}
	public void addListener(ActionListener l){
		removeListener();
		deleteItem.addActionListener(l);
		addVertexItem.addActionListener(l);
		addEdgeItem.addActionListener(l);
		addDefaultVertexItem.addActionListener(l);
	}
	public void removeListener(){
		ActionListener[] listener=deleteItem.getActionListeners();
		for(int i=0;i<listener.length;i++)deleteItem.removeActionListener(listener[i]);
		listener=addVertexItem.getActionListeners();
		for(int i=0;i<listener.length;i++)addVertexItem.removeActionListener(listener[i]);
		listener=addEdgeItem.getActionListeners();
		for(int i=0;i<listener.length;i++)addEdgeItem.removeActionListener(listener[i]);
		listener=addDefaultVertexItem.getActionListeners();
		for(int i=0;i<listener.length;i++)addDefaultVertexItem.removeActionListener(listener[i]);
	}
	public class MenuChangeListener implements MenuListener{
		@Override
		public void menuCanceled(MenuEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void menuDeselected(MenuEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void menuSelected(MenuEvent arg0) {
			// TODO Auto-generated method stub
			if(deleteItem.getActionListeners().length>0)deleteItem.setEnabled(true);
			else deleteItem.setEnabled(false);//////
			if(addVertexItem.getActionListeners().length>0)addVertexItem.setEnabled(true);
			else addVertexItem.setEnabled(false);/////
			if(addEdgeItem.getActionListeners().length>0)addEdgeItem.setEnabled(true);
			else addEdgeItem.setEnabled(false);//////
			if(addDefaultVertexItem.getActionListeners().length>0)addDefaultVertexItem.setEnabled(true);
			else addDefaultVertexItem.setEnabled(false);
		}		
	}
}

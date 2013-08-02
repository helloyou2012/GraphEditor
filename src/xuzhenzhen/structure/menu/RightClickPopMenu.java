package xuzhenzhen.structure.menu;

import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class RightClickPopMenu extends JPopupMenu{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8725383064187092610L;
	private JMenuItem deleteItem;
	private JMenuItem addVertexItem;
	private JMenuItem addEdgeItem;
	private JMenuItem addDefaultVertexItem;
	public RightClickPopMenu(){
		init();
	}
	public void init(){
		deleteItem=new JMenuItem("删除选中内容");
		addVertexItem=new JMenuItem("添加结点");
		addEdgeItem=new JMenuItem("添加边");
		addDefaultVertexItem=new JMenuItem("默认添加结点");
		add(deleteItem);
		addSeparator();
		add(addVertexItem);
		add(addEdgeItem);
		add(addDefaultVertexItem);
	}
	public void addListener(ActionListener l){		
		deleteItem.addActionListener(l);
		addVertexItem.addActionListener(l);
		addEdgeItem.addActionListener(l);
		addDefaultVertexItem.addActionListener(l);
	}
}
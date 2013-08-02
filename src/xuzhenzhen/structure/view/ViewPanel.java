package xuzhenzhen.structure.view;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import xuzhenzhen.structure.menu.PopMenuListener;
import xuzhenzhen.structure.menu.RightClickPopMenu;
import xuzhenzhen.structure.model.Graph;

public class ViewPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3442684836586971879L;
	private Graph graph;
	private RightClickPopMenu popMenu;
	public ViewPanel(Graph g){
		this.graph=g;
		popMenu=new RightClickPopMenu();
		popMenu.addListener(new PopMenuListener(graph));
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g0=(Graphics2D)g;
		g0.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
		g0.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(graph!=null){
			graph.show(g);
		}
	}
	public void display(Graph g){
		this.graph=g;
		repaint();
	}
	@Override
	public synchronized void addMouseListener(MouseListener l) {
		// TODO Auto-generated method stub
		super.addMouseListener(l);
		popMenu.addMouseListener(l);
	}
	public void dealPopup(MouseEvent e){
		popMenu.show(e.getComponent(), e.getX(), e.getY());
	}
}

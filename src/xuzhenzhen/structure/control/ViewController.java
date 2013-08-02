package xuzhenzhen.structure.control;

import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import xuzhenzhen.structure.model.Graph;
import xuzhenzhen.structure.view.ViewPanel;

public class ViewController extends MouseAdapter implements GraphListener{
	private Graph graph;
	private ViewPanel panel;
	private int dx;
	private int dy;
	public ViewController(Graph graph, ViewPanel panel) {
		this.graph = graph;
		this.panel = panel;
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		dx=e.getX();dy=e.getY();
		int onmask=InputEvent.CTRL_DOWN_MASK | InputEvent.BUTTON1_DOWN_MASK;
		if(e.getModifiersEx()==onmask){
			System.out.println("按了Ctrl和左鼠标键");
			if(graph!=null){
				SelectOperate op=new SelectOperate(graph, e.getX(), e.getY(), true);
				op.operate();
			}
		}
		if(e.getModifiers()==InputEvent.BUTTON1_MASK){
			System.out.println("按了左鼠标键");
			if(graph!=null){
				SelectOperate op=new SelectOperate(graph, e.getX(), e.getY(), false);
				op.operate();
			}
		}
		if(e.getModifiers()==InputEvent.BUTTON3_MASK){
			if(panel!=null)
				panel.dealPopup(e);
		}
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		int onmask=InputEvent.SHIFT_DOWN_MASK | InputEvent.BUTTON1_DOWN_MASK;
		if(e.getModifiersEx()==onmask&&graph!=null){
			DragOperate op=new DragOperate(graph, e.getX()-dx, e.getY()-dy, true);
			op.operate();
		}
		if(e.getModifiers()==InputEvent.BUTTON1_MASK&&graph!=null){
			DragOperate op=new DragOperate(graph, e.getX()-dx, e.getY()-dy, false);
			op.operate();
		}
		dx=e.getX();
		dy=e.getY();
	}
	@Override
	public void graphPositionChange(Graph g) {
		// TODO Auto-generated method stub
		panel.display(g);
	}
	@Override
	public void graphStructureChange(Graph g) {
		// TODO Auto-generated method stub
		panel.display(g);
	}
	@Override
	public void graphSelectedChange(Graph g) {
		// TODO Auto-generated method stub
		panel.display(g);
	}
}

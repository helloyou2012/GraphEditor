package xuzhenzhen.structure.control;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import xuzhenzhen.structure.model.Graph;
import xuzhenzhen.structure.view.VListPanel;

public class VListController implements GraphListener,ItemListener,FocusListener{
	private VListPanel panel;
	private Graph graph;
	public VListController(VListPanel panel, Graph graph) {
		this.panel = panel;
		this.graph = graph;
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getStateChange()==ItemEvent.SELECTED&&panel.enableChange){
			int i=panel.getSelectedIndex();
			SelectVertexOperate op=new SelectVertexOperate(graph, i);
			op.operate();
		}
	}

	@Override
	public void graphPositionChange(Graph g) {
		// TODO Auto-generated method stub
		//doNothiong
	}

	@Override
	public void graphStructureChange(Graph g) {
		// TODO Auto-generated method stub
		if(panel!=null)
			panel.loadGraph(g);
	}

	@Override
	public void graphSelectedChange(Graph g) {
		// TODO Auto-generated method stub
		if(panel!=null)
			panel.refresh(g);
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		int index=panel.getSelectedIndex();
		String name=panel.getName();
		int weight=0;
		try {
			weight=new Integer(panel.getWeight());
			if(name.length()>0){
				RefreshVertexOperate op=new RefreshVertexOperate(graph, index, name, weight);
				op.operate();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

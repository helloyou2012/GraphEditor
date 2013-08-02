package xuzhenzhen.structure.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import xuzhenzhen.structure.control.AddVertexOperate;
import xuzhenzhen.structure.control.DeleteOperate;
import xuzhenzhen.structure.dialog.AddEdgeDialog;
import xuzhenzhen.structure.dialog.AddVertexDialog;
import xuzhenzhen.structure.model.Graph;

public class PopMenuListener implements ActionListener{
	private Graph graph;
	public PopMenuListener(Graph graph) {
		this.graph = graph;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String action=e.getActionCommand();
		if(action.equals("删除选中内容")){
			dealDelete();return;
		}
		if(action.equals("添加结点")){
			dealAddVertex();return;
		}
		if(action.equals("添加边")){
			dealAddEdge();return;
		}
		if(action.equals("默认添加结点")){
			dealDefaultAddVertex();return;
		}
	}
	public void dealDelete(){
		DeleteOperate op=new DeleteOperate(graph);
		op.operate();
	}
	public void dealAddVertex(){
		AddVertexDialog dialog=new AddVertexDialog(graph);
		dialog.show();
	}
	public void dealAddEdge(){
		AddEdgeDialog dialog=new AddEdgeDialog(graph);
		dialog.show();
	}
	public void dealDefaultAddVertex(){
		AddVertexOperate op=new AddVertexOperate(graph);
		op.operate();
	}
}

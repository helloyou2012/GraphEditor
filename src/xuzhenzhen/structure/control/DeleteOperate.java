package xuzhenzhen.structure.control;

import javax.swing.JOptionPane;

import xuzhenzhen.structure.model.Graph;

public class DeleteOperate implements Operation{
	private Graph graph;
	public DeleteOperate(Graph graph) {
		this.graph = graph;
	}
	@Override
	public void operate() {
		// TODO Auto-generated method stub
		if(graph!=null){
			int result=JOptionPane.showConfirmDialog(null, "是否删除选中的边和节点？", "提示",
					JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if(result==JOptionPane.YES_OPTION){
				graph.deleteSelected();
				graph.structureRefresh();
			}
		}
	}

}

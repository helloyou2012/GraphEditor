package xuzhenzhen.structure.table;

import javax.swing.JTable;
import xuzhenzhen.structure.control.RefreshEdgeWeightOperate;
import xuzhenzhen.structure.dialog.ProgressDialog;
import xuzhenzhen.structure.model.Graph;

public class TableSaveGraph implements Runnable{
	private JTable table;
	private Graph graph;
	public TableSaveGraph(JTable table, Graph graph) {
		this.table = table;
		this.graph = graph;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(table!=null&&graph!=null&&table.getRowCount()>0){
			int rowNum=table.getRowCount();
			int colNum=table.getColumnCount();
			ProgressDialog dialog=new ProgressDialog(0, rowNum*colNum);
			for(int i=0;i<rowNum;i++){
				for(int j=1;j<colNum;j++){
					dialog.setProgressValue(i*rowNum+j);
					if(j-1!=i){
						int weight=0;
						try {
							Object data=table.getValueAt(i, j);
							if(data!=null)weight=new Integer(data.toString());
						} catch (Exception e) {
							// TODO: handle exception
						}
						RefreshEdgeWeightOperate op=new RefreshEdgeWeightOperate(graph, i, j-1, weight);
						op.operate();
					}
				}
			}
			dialog.dispose();
		}
	}

}

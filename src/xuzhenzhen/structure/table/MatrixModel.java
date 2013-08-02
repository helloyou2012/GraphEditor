package xuzhenzhen.structure.table;

import javax.swing.table.AbstractTableModel;

public class MatrixModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3070261445243540222L;
	private Object[][] matrix;
	private String[] headName;
	public MatrixModel(Object[][] matrix) {
		this.matrix = matrix;
		headName=new String[matrix.length];
		for(int i=0;i<headName.length;i++){
			headName[i]=i+"";
		}
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return headName.length+1;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return headName.length;
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		if(col==0)return headName[row];
		return matrix[row][col-1];
	}

	@Override
	public String getColumnName(int col) {
		// TODO Auto-generated method stub
		if(col==0)return "";
		return headName[col-1];
	}

}

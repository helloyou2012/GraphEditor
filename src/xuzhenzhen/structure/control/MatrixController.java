package xuzhenzhen.structure.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import xuzhenzhen.structure.model.Graph;
import xuzhenzhen.structure.view.VEMatrixPanel;

public class MatrixController implements ActionListener,GraphListener{
	private VEMatrixPanel panel;
	public MatrixController(VEMatrixPanel panel) {
		this.panel = panel;
	}

	@Override
	public void graphPositionChange(Graph g) {
		// DoNothing
	}

	@Override
	public void graphStructureChange(Graph g) {
		// TODO Auto-generated method stub
		panel.setChange(g);
	}

	@Override
	public void graphSelectedChange(Graph g) {
		// DoNothing
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		panel.dealSave();
	}
}

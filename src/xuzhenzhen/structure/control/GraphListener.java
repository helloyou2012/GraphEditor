package xuzhenzhen.structure.control;

import xuzhenzhen.structure.model.Graph;

public interface GraphListener{
	public void graphPositionChange(Graph g);
	public void graphStructureChange(Graph g);
	public void graphSelectedChange(Graph g);
}

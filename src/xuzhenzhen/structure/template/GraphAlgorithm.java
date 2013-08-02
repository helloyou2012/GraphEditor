package xuzhenzhen.structure.template;

public interface GraphAlgorithm{
	public final static int UNDISCOVERED=0;
	public final static int DISCOVERED=1;
	public final static int VISITED=2;
	public final static int UNKNOWN=0;
	public final static int TREE=1;
	public final static int CROSS=2;
	public final static int FORWARD=3;
	public final static int BACKWARD=4;
	public Object[][] getDistanceMatrix();
	public Object[][] getPathMatrix();
	public void algorithm();
}

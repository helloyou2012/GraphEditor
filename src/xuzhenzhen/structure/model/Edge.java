package xuzhenzhen.structure.model;

import java.awt.Graphics;
import java.io.Serializable;

public interface Edge extends Position,Serializable{
	public final static int UNKNOWN=0;
	public final static int TREE=1;
	public final static int CROSS=2;
	public final static int FORWARD=3;
	public final static int BACKWARD=4;
	public Vertex getStartV();
	public Vertex getEndV();
	public int getType();
	public int setType(int type);
	public void setSelect(boolean b);
	public boolean getSelect();
	public void show(Graphics g);
}

package xuzhenzhen.structure.model;

import java.awt.Color;

import java.awt.Graphics;

import xuzhenzhen.structure.global.Global;

public class EdgeNode implements Edge{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5760488667587604500L;
	protected Object info;
	protected Vertex from;
	protected Vertex to;
	protected boolean isSelect;
	protected int type;

	public EdgeNode(Object info, Vertex from, Vertex to) {
		this.info = info;
		this.from = from;
		this.to = to;
		from.addOutEdges(this);
		to.addInEdges(this);
	}

	@Override
	public Object getInfo() {
		// TODO Auto-generated method stub
		return info;
	}

	@Override
	public void setInfo(Object obj) {
		// TODO Auto-generated method stub
		this.info=obj;
	}

	@Override
	public Vertex getStartV() {
		// TODO Auto-generated method stub
		return from;
	}

	@Override
	public Vertex getEndV() {
		// TODO Auto-generated method stub
		return to;
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	public int setType(int type) {
		// TODO Auto-generated method stub
		int temp=this.type;
		this.type=type;
		return temp;
	}

	@Override
	public void show(Graphics g) {
		// TODO Auto-generated method stub
		//System.out.println("显示边");
		DataInfo data=(DataInfo)info;
		Color color=isSelect?Color.red:Color.blue;
		boolean isDraw=Global.drawArrowLine(g, from.getPosition(), to.getPosition(), color);
		int x=(from.getPosition().x+to.getPosition().x)/2;
		int y=(from.getPosition().y+to.getPosition().y)/2;
		if(isDraw)
			Global.drawRenderText(g, x, y, data.getName()+"—"+data.getWeight(), color);
	}
	@Override
	public void setSelect(boolean b) {
		// TODO Auto-generated method stub
		this.isSelect=b;
	}

	@Override
	public boolean getSelect() {
		// TODO Auto-generated method stub
		return isSelect;
	}
}

package xuzhenzhen.structure.model;


public class VertexInfo implements DataInfo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2308860751995757916L;
	private String name;
	private int weight;
	public VertexInfo(String name) {
		this.name = name;
		this.weight =0;
	}
	public VertexInfo(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
}

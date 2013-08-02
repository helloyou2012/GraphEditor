package xuzhenzhen.structure.model;

public class EdgeInfo implements DataInfo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6359852505471590648L;
	private String name;
	private int weight;
	public EdgeInfo(String name){
		this.name=name;
		weight=Integer.MAX_VALUE;
	}
	public EdgeInfo(String name, int weight) {
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

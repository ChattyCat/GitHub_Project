package dal_package;

public class Student {
	private String sID;
	private String sName;
	private Integer points;
	public Student(){
		setPoints(0);
	}
	public Student(String sID, String sName){
		this.setsID(sID);
		this.setsName(sName);
		setPoints(0);
	}
	public Student(String sID, String sName, Integer points){
		this.setsID(sID);
		this.setsName(sName);
		this.setPoints(points);
	}
	public String getsID() {
		return sID;
	}
	public void setsID(String sID) {
		this.sID = sID;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
}

package dal_package;

public class Course {
	private String cID;
	private String cName;
	
	public Course(){
	}
	public Course(String cID){
		this.setcID(cID);
	}
	public Course(String cID, String cName){
		this.setcID(cID);
		this.setcName(cName);
	}
	public String getcID() {
		return cID;
	}
	public void setcID(String cID) {
		this.cID = cID;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
}

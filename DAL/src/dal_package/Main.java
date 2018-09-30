package dal_package;

public class Main {

	public static void main(String[] args) {
		DAL dal = new DAL();
		System.out.println(dal.retrieve("'S1'").getsID());
	}

}

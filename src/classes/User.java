package classes;

interface User_Operations{
	
	
	public void login();
	public void register();
	public void senddata();
	public void receivedata();
	public void complaints_issues();
	
}



public abstract class User implements User_Operations {
	
	private static String type;
	protected String usr_name;
	protected int usr_ID;
	protected String usr_password;
	
	
	
	public abstract void login();
	public abstract void register();
	public abstract void senddata();
	public abstract void recievedata();
	public abstract void complaint_issues();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static String getType() {
		return type;
	}

	public static void setType(String type) {
		User.type = type;
	}
	public void receivedata1() {
		// TODO Auto-generated method stub
		
	}
	
}

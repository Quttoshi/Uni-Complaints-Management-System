package classes;

import java.sql.*;

public class LostnFound {
	
	private int ID;
	private String Item_name;
	private String Item_description;
	private boolean found_status;
	
	public LostnFound() {
		// Constructor
	}

	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getItem_name() {
		return Item_name;
	}


	public void setItem_name(String item_name) {
		Item_name = item_name;
	}


	public String getItem_description() {
		return Item_description;
	}


	public void setItem_description(String item_description) {
		Item_description = item_description;
	}


	public boolean isFound_status() {
		return found_status;
	}


	public void setFound_status(boolean found_status) {
		this.found_status = found_status;
	}

	
	
	public void enterindb(int id, String desc, String name, boolean stat) {
		

		    String mysql_url = "jdbc:mysql://localhost:3306/sda";
		    String mysql_username = "root";
		    String mysql_password = "123456";

	        Connection con = null;
	        
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection(mysql_url, mysql_username, mysql_password);

	            if (con != null) {
	                System.out.println("Database connected successfully");

	                String query = "INSERT INTO LostFound (ObjectID, descriptionn, namee , Statuss) VALUES (?,?,?,?)";

	                try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
	                	preparedStatement.setInt(1, id);
	                    preparedStatement.setString(2, desc);
	                    preparedStatement.setString(3, name);
	                    preparedStatement.setBoolean(4, stat);
	                    
	                    
	                    int rowsAffected = preparedStatement.executeUpdate();
	                    System.out.printf("Rows Affected = %d\n", rowsAffected);
	                } catch (SQLException e) {
	                    System.out.println(e);
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}
	
	
	public LostnFound getdata() {
		
		LostnFound obj = new LostnFound();
		
        System.out.println("Reading SDA DB");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sda", "root", "123456");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select ObjectID, descriptionn, Statuss from LostFound;")) {

            while (resultSet.next()) {
            	
            	obj.setID(resultSet.getInt("ObjectID"));
            	obj.setItem_description(resultSet.getString("descriptionn"));
            	obj.setFound_status(resultSet.getBoolean("Statuss"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
				
		return obj;
	}
}

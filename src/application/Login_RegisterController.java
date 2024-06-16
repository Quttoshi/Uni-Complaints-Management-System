package application;


import java.util.ResourceBundle;

import classes.Admin;
import classes.Employee;
import classes.Student;
import classes.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.Node;


import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;




public class Login_RegisterController implements Initializable{
	
	private Stage stg;
	private Scene scn;
	Boolean flag;
	String type_of_user;
	
	
	@FXML
	private Button lr_forgotpass;
	
	@FXML
	private TextField lr_loginid;
	
	@FXML
	private TextField lr_loginpass;
	
	@FXML
	private TextField lr_regid;
	
	@FXML
	private TextField lr_regpass;
	
	@FXML
	private TextField lr_regname;
	
	@FXML
	private TextField lr_batch;
	
	@FXML
	private TextField lr_dob;
	
	@FXML
	private Button lr_student;

	@FXML
	private Button lr_admin;
	
	@FXML
	private Button lr_employee;
	
	@FXML
	private Button lr_regstudent;
	
	@FXML
	private Button lr_regemployee;
	
	@FXML
	private Button lr_regadmin;
	
	@FXML
	private Label lr_labelcred;
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		

		lr_student.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {

				Parent root = null;
				flag = check_student_credentials();
				
				if(flag) {
						
					User.setType("Student");
					
					try {
						FXMLLoader loader = new FXMLLoader(getClass().getResource("LostFound.fxml"));
						root = loader.load();
						
					} catch (IOException e) {
						
						e.printStackTrace();
					}
					
					stg = (Stage)((Node)arg0.getSource()).getScene().getWindow();
					scn = new Scene(root);
					stg.setScene(scn);
					stg.show();
				}
				else {
					lr_labelcred.setText("*IncorrectCredentials, Enter Again");
				}
			}
		});	

		lr_employee.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {

				Parent root = null;
				flag = check_Employee_credentials();
				
				if(flag) {
					User.setType("Employee");
					try {
						FXMLLoader loader = new FXMLLoader(getClass().getResource("LostFound.fxml"));
						root = loader.load();
						
					} catch (IOException e) {
						
						e.printStackTrace();
					}
					
					stg = (Stage)((Node)arg0.getSource()).getScene().getWindow();
					scn = new Scene(root);
					stg.setScene(scn);
					stg.show();
				}
				else {
					lr_labelcred.setText("*IncorrectCredentials, Enter Again");
				}
			}
		});	
		
		

		lr_admin.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {

				Parent root = null;
				flag = check_Admin_credentials();
				
				if(flag) {
					User.setType("Admin");

					try {
						FXMLLoader loader = new FXMLLoader(getClass().getResource("LostFound_Admin.fxml"));
						root = loader.load();
						
					} catch (IOException e) {
						
						e.printStackTrace();
					}
					
					stg = (Stage)((Node)arg0.getSource()).getScene().getWindow();
					scn = new Scene(root);
					stg.setScene(scn);
					stg.show();
				}
				else {
					lr_labelcred.setText("*IncorrectCredentials, Enter Again");
				}
			}
		});	
		
		lr_regstudent.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {

				Parent root = null;
				User.setType("Student");

				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("LostFound.fxml"));
					root = loader.load();
					setStudentInfo();
					
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
				stg = (Stage)((Node)arg0.getSource()).getScene().getWindow();
				scn = new Scene(root);
				stg.setScene(scn);
				stg.show();
			}
		});	
		
		
	lr_regemployee.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {

				Parent root = null;
				User.setType("Employee");

				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("LostFound.fxml"));
					root = loader.load();
					setEmployeeInfo();
					
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
				stg = (Stage)((Node)arg0.getSource()).getScene().getWindow();
				scn = new Scene(root);
				stg.setScene(scn);
				stg.show();
			}
		});	
	
	
	lr_regadmin.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {

				Parent root = null;
				User.setType("Admin");

				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("LostFound_Admin.fxml"));
					root = loader.load();
					setAdminInfo();
					
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
				stg = (Stage)((Node)arg0.getSource()).getScene().getWindow();
				scn = new Scene(root);
				stg.setScene(scn);
				stg.show();
			}
		});	

		
		
	}
	
	
	public boolean check_student_credentials() {
		
		int temp = Integer.parseInt(lr_loginid.getText());
		
		
		if(Student.retrieve_data(temp, lr_loginpass.getText())) {
			
			return true;
		}
		
		return false;
	}
	
	
	public boolean check_Employee_credentials() {
			
			int temp = Integer.parseInt(lr_loginid.getText());
			
			
			if(Employee.retrieve_data(temp, lr_loginpass.getText())) {
				
				return true;
			}
			
			return false;
		}
		


	public boolean check_Admin_credentials() {
		
		int temp = Integer.parseInt(lr_loginid.getText());
		
		
		if(Admin.retrieve_data(temp, lr_loginpass.getText())) {
			
			return true;
		}
		
		return false;
	}

	
	
	public void setAdminInfo() {
		
		Admin a1 = new Admin();
		a1.setName(lr_regname.getText());
		a1.setPassword(lr_regpass.getText());
		int temp = Integer.parseInt(lr_regid.getText());
		a1.setAdmin_ID(temp);
		a1.setDOB(lr_dob.getText());
		
		a1.register_admin(a1.getAdmin_ID(), a1.getPassword(), a1.getName(), a1.getDOB());
		
	}
	
	
	
	public void setEmployeeInfo() {
		
		Employee e1 = new Employee();
		e1.setName(lr_regname.getText());
		e1.setPassword(lr_regpass.getText());
		int temp = Integer.parseInt(lr_regid.getText());
		e1.setEmployee_ID(temp);
		e1.setYear_of_Hiring(lr_batch.getText());
		e1.setDOB(lr_dob.getText());
		
		e1.register_employee(e1.getEmployee_ID(), e1.getPassword(), e1.getName(), e1.getDOB(), e1.getYear_of_Hiring());
		
	}
		
		public void setStudentInfo() {
			
			Student s1 = new Student();
			s1.setName(lr_regname.getText());
			s1.setPassword(lr_regpass.getText());
			int temp = Integer.parseInt(lr_regid.getText());
			s1.setStudent_ID(temp);
			s1.setBatch(lr_batch.getText());
			s1.setDOB(lr_dob.getText());
			
			s1.register_student(s1.getStudent_ID(), s1.getPassword(), s1.getName(), s1.getDOB(), s1.getBatch());
			
		}
}		
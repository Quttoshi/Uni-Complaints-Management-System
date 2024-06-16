package application;

import java.net.URL;
import java.util.ResourceBundle;

import classes.AcademicIssues;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AcademicIssuesController2 implements Initializable {

    @FXML
    private Button a_return;

    @FXML
    private Button a_harassment;

    @FXML
    private Button a_lostfound;

    @FXML
    private Button a_library;

    @FXML
    private Button a_cafeteria;

    @FXML
    private Button a_signout;

    @FXML
    private Button a_submit;

    @FXML
    private TextArea a_detail;

    @FXML
    private TextField a_name;

    @FXML
    private TextField a_course;

    @FXML
    private Label a_status;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        a_submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                a_status.setText("*Case Lodged. Admins will take decision timely");
                saveinfo();
            }
        });

        // Other event handlers for buttons like a_harassment, a_lostfound, etc.
    }

    public void saveinfo() {
        AcademicIssues obj = new AcademicIssues();
        obj.setAgainstcourse(a_course.getText());
        obj.setAgainstteacher(a_name.getText());
        obj.setComplaintID(1);
        obj.setDetails(a_detail.getText());
        obj.savetodb(obj.getAgainstcourse(), obj.getAgainstteacher(), obj.getComplaintID(), obj.getDetails());
    }
}

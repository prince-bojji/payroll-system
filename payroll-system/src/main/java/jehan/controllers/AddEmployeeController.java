package jehan.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import jehan.components.SwitchSceneActionEvent;
import jehan.database.ConnectDatabase;

/**
 * Controller class for adding a new employee.
 */
public class AddEmployeeController {
    @FXML
    private TextField txtName, txtNo, txtAdd;

    private ConnectDatabase connect = new ConnectDatabase();
    private String sql;
    public String username;
    public String password;

    private SwitchSceneActionEvent switchTo = new SwitchSceneActionEvent();

    /**
     * Inserts a new employee into the database.
     */
    public void insert() {
        connect.createConnection();

        String name = txtName.getText();
        String num = txtNo.getText();
        String address = txtAdd.getText();

        try {
            Statement statement = connect.connection.createStatement();
            sql = "INSERT INTO employee(emp_name, emp_no, emp_add) VALUES ('" + name + "', " + num + ", '" + address + "')";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Switches the scene to the Compute Salary section.
     *
     * @param event The ActionEvent that triggered the scene switch.
     * @throws IOException If the FXML file cannot be loaded.
     */
    public void switchToComputeSalary(ActionEvent event) throws IOException {
        switchTo.switchScene(event, "/fxml/ComputeSalary.fxml", "Compute Salary");
    }

    /**
     * Switches the scene to the Payment section.
     *
     * @param event The ActionEvent that triggered the scene switch.
     * @throws IOException If the FXML file cannot be loaded.
     */
    public void switchToPayment(ActionEvent event) throws IOException {
        switchTo.switchScene(event, "/fxml/Payment.fxml", "Payment");
    }

    /**
     * Switches the scene to the Salary Report section.
     *
     * @param event The ActionEvent that triggered the scene switch.
     * @throws IOException If the FXML file cannot be loaded.
     */
    public void switchToSalaryReport(ActionEvent event) throws IOException {
        switchTo.switchScene(event, "/fxml/SalaryReport.fxml", "Salary Report");
    }

    /**
     * Exits the application.
     *
     * @param event The ActionEvent that triggered the exit.
     * @throws IOException If an I/O error occurs.
     */
    public void exit(ActionEvent event) throws IOException {
        System.exit(0);
    }
}

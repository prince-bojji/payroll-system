package jehan.controllers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import jehan.components.SwitchSceneActionEvent;
import jehan.database.ConnectDatabase;

/**
 * Controller class for handling salary report operations.
 */
public class SalaryReportController {
    private ConnectDatabase connect = new ConnectDatabase();
    private String sql;
    public String username;
    public String password;

    private SwitchSceneActionEvent switchTo = new SwitchSceneActionEvent();

    @FXML
    TextField txtEmpID, txtPayID, txtStatus;

    /**
     * Searches for salary and payment information based on the provided employee ID and payment ID.
     */
    public void search() {
        connect.createConnection();

        int empID = Integer.parseInt(txtEmpID.getText());
        int payID = Integer.parseInt(txtPayID.getText());
        float payAmt = 0;
        float salAmt = 0;
        String status = " ";

        try {
            sql = "SELECT * FROM payment WHERE pay_ID = " + payID;
            Statement statement = connect.connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                payAmt = result.getFloat("pay_amt");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            sql = "SELECT * FROM salary WHERE sal_ID = " + empID;
            Statement statement = connect.connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                salAmt = result.getFloat("sal_amt");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (payAmt == salAmt) {
            txtStatus.setText("Completed");
            status = "Completed";
        } else {
            txtStatus.setText("Pending");
            status = "Pending";
        }
    }

    /**
     * Switches the scene to the Add Employee section.
     *
     * @param event The ActionEvent that triggered the scene switch.
     * @throws IOException If the FXML file cannot be loaded.
     */
    public void switchToAddEmployee(ActionEvent event) throws IOException {
        switchTo.switchScene(event, "/fxml/AddEmployee.fxml", "Add Employee");
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
     * Exits the application.
     *
     * @param event The ActionEvent that triggered the exit.
     * @throws IOException If an I/O error occurs.
     */
    public void exit(ActionEvent event) throws IOException {
        System.exit(0);
    }
}

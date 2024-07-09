package jehan.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import jehan.components.SwitchSceneActionEvent;
import jehan.database.ConnectDatabase;

/**
 * Controller class for handling payment operations.
 */
public class PaymentController {
    private ConnectDatabase connect = new ConnectDatabase();
    private String sql;
    public String username;
    public String password;

    private SwitchSceneActionEvent switchTo = new SwitchSceneActionEvent();

    @FXML
    TextField txtSalID, txtPyrlID, txtAmount;

    /**
     * Confirms and processes the payment.
     * Retrieves the input values from the text fields, creates a connection to the database,
     * and inserts a new payment record.
     */
    public void confirm() {
        connect.createConnection();

        int salID = Integer.parseInt(txtSalID.getText());
        int pyrlID = Integer.parseInt(txtPyrlID.getText());
        float amount = Float.parseFloat(txtAmount.getText());

        try {
            Statement statement = connect.connection.createStatement();
            sql = "insert into payment(pay_amt,sal_ID,pyrl_ID)"
                + "values(" + amount + "," + salID + "," + pyrlID + ")";
            statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Payment Success.");
        } catch (SQLException e) {
            e.printStackTrace();
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

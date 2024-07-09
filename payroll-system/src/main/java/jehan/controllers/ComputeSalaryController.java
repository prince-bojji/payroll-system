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
 * Controller class for computing employee salary.
 */
public class ComputeSalaryController {
    @FXML
    private TextField txtEmpID, txtHourlyRate, txtAbsent, txtOvertime, txtLate, txtPayrollType, txtPayrollDate, txtAmount;

    private ConnectDatabase connect = new ConnectDatabase();
    private String sql;
    public String username;
    public String password;

    private SwitchSceneActionEvent switchTo = new SwitchSceneActionEvent();

    /**
     * Calculates and inserts the employee's salary details into the database.
     */
    public void ok() {
        connect.createConnection();

        int emp_ID = Integer.parseInt(txtEmpID.getText());
        int hourlyRate = Integer.parseInt(txtHourlyRate.getText());
        int absent = Integer.parseInt(txtAbsent.getText());
        int overtime = Integer.parseInt(txtOvertime.getText());
        int late = Integer.parseInt(txtLate.getText());
        String payrollType = txtPayrollType.getText();
        String payrollDate = txtPayrollDate.getText();
        int days = 0;

        if (payrollType.equalsIgnoreCase("weekly"))
            days = 7;
        if (payrollType.equalsIgnoreCase("monthly"))
            days = 31;

        // Salary Formula
        float salary = (hourlyRate * 8 * days) + (overtime * 1.25f) - (late * hourlyRate) - (absent * 8);
        txtAmount.setText(String.format("%.2f", salary));

        try {
            Statement statement = connect.connection.createStatement();
            sql = "INSERT INTO salary(hrly_rate, t_days_absent, t_hrs_over, t_hrs_late, sal_amt, emp_ID) " +
                  "VALUES (" + hourlyRate + ", " + absent + ", " + overtime + ", " + late + ", " + salary + ", " + emp_ID + ")";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            Statement statement = connect.connection.createStatement();
            sql = "INSERT INTO payroll(pyrl_date, pyrl_type, emp_ID) " +
                  "VALUES ('" + payrollDate + "', '" + payrollType + "', " + emp_ID + ")";
            statement.executeUpdate(sql);
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

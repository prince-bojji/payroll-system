package jehan.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import jehan.components.SwitchSceneActionEvent;

/**
 * Controller class for the main application interface.
 */
public class MainController {
    private SwitchSceneActionEvent switchTo = new SwitchSceneActionEvent();

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

package edu.umg.java.ui.controller;

import edu.umg.java.calculator.Calculator;
import edu.umg.java.calculator.operation.OperationType;
import edu.umg.java.ui.helper.NumericInputHelper;
import io.vavr.control.Try;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class MainController implements Initializable {

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private TextField edFirstNumber;

    @FXML
    private TextField edSecondNumber;

    @FXML
    private Button btnPerformOperation;

    @FXML
    private Button btnReset;

    @FXML
    private Label lbResult;

    @FXML
    private Label lbError;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        fillComboBox();
        lbResult.setText("0.00");
        lbError.setText("");
    }

    @FXML
    public void closeApplication(ActionEvent event) {

        Platform.exit();
    }

    @FXML
    public void reset(ActionEvent event) {

        lbError.setText("");
        lbResult.setText("0.00");
        edFirstNumber.setText("0");
        edSecondNumber.setText("0");
        comboBox.getSelectionModel().selectFirst();
    }

    @FXML
    public void performOperation(ActionEvent event) {

        lbError.setText("");

        var selected = comboBox.getSelectionModel().getSelectedItem();
        if (StringUtils.isBlank(selected)) {

            displayError("Operation Type", "Select a valid operation");
            return;
        }

        var operationType = mapOperationType(selected);

        var result = NumericInputHelper.convertNumber(edFirstNumber.getText());

        if (result.isLeft()) {

            displayError("First Number", result.getLeft());
            return;
        }

        var fistNumber = result.get();

        result = NumericInputHelper.convertNumber(edSecondNumber.getText());

        if (result.isLeft()) {

            displayError("Second Number", result.getLeft());
            return;
        }

        var secondNumber = result.get();

        var calculator = new Calculator(fistNumber, secondNumber);

        var answerResult = Try.of(() -> calculator.performOperation(operationType))
                .onFailure(ex -> displayError("Operation", "Invalid Operation"))
                .toEither();

        if (answerResult.isRight()) {
            lbResult.setText(Double.toString(answerResult.get()));
        }
    }

    // ----------------------------------------------------------------------------

    private OperationType mapOperationType(final String selected) {

        switch (selected) {
            case "+":
                return OperationType.ADDITION;
            case "-":
                return OperationType.SUBTRACTION;
            case "*":
                return OperationType.MULTIPLICATION;
            case "/":
                return OperationType.DIVISION;
            default:
                return OperationType.ADDITION;
        }
    }

    private void displayError(String inputName, String error) {

        lbError.setText(String.format("[%s] has error: [%s]", inputName, error));
    }

    private void fillComboBox() {

        var items = comboBox.getItems();
        items.clear();
        items.addAll("+", "-", "*", "/");

        comboBox.getSelectionModel().selectFirst();
    }
}

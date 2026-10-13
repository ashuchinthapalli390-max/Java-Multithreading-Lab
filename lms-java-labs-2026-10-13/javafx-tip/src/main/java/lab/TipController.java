package lab;

import java.math.BigDecimal;
import java.math.RoundingMode;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TipController {
    @FXML private TextField billAmount;
    @FXML private TextField tipPercentage;
    @FXML private Label tipAmount;
    @FXML private Label totalAmount;
    @FXML private Label errorMessage;

    @FXML
    private void calculateTip() {
        try {
            BigDecimal bill = new BigDecimal(billAmount.getText().trim());
            BigDecimal percent = new BigDecimal(tipPercentage.getText().trim());
            if (bill.signum() < 0 || percent.signum() < 0) {
                throw new IllegalArgumentException("Amounts cannot be negative.");
            }
            BigDecimal tip = bill.multiply(percent).divide(new BigDecimal("100"))
                    .setScale(2, RoundingMode.HALF_UP);
            BigDecimal total = bill.add(tip).setScale(2, RoundingMode.HALF_UP);
            tipAmount.setText("Tip Amount: " + tip.toPlainString());
            totalAmount.setText("Total Amount: " + total.toPlainString());
            errorMessage.setText("");
        } catch (NumberFormatException e) {
            tipAmount.setText("Tip Amount: 0.00");
            totalAmount.setText("Total Amount: 0.00");
            errorMessage.setText("Enter valid numbers in both fields.");
        } catch (IllegalArgumentException e) {
            tipAmount.setText("Tip Amount: 0.00");
            totalAmount.setText("Total Amount: 0.00");
            errorMessage.setText(e.getMessage());
        }
    }

    @FXML
    private void resetFields() {
        billAmount.clear();
        tipPercentage.clear();
        tipAmount.setText("Tip Amount: 0.00");
        totalAmount.setText("Total Amount: 0.00");
        errorMessage.setText("");
        billAmount.requestFocus();
    }
}

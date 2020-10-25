package number_converter;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class Controller {
    @FXML public javafx.scene.control.Label lblOutput;
    @FXML public JFXTextField txtInput;
    @FXML public JFXTextField txtOutput;
    @FXML public JFXComboBox cmbBxInputType;
    @FXML public JFXComboBox cmbBxOutputType;

    @FXML
    public void initialize(){
        cmbBxInputType.getItems().removeAll(cmbBxInputType.getItems());
        cmbBxInputType.getItems().addAll("Binary","Decimal","Octal","Hexa-decimal");
        cmbBxInputType.getSelectionModel().select(0);

        cmbBxOutputType.getItems().removeAll(cmbBxInputType.getItems());
        cmbBxOutputType.getItems().addAll("Binary","Decimal","Octal","Hexa-decimal");
        cmbBxOutputType.getSelectionModel().select(1);
    }

    @FXML
    public void btnConvertOnAction(ActionEvent actionEvent) {
        String inputType=cmbBxInputType.getSelectionModel().getSelectedItem().toString();
        String outputType=cmbBxOutputType.getSelectionModel().getSelectedItem().toString();
        if(inputType=="Binary") {
            if (outputType == "Decimal") {
                if (txtInput.getText().matches("[0-1]+")) convertBin2Dec();
                else {
                    txtOutput.setText("");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Binary value invalid. Please try again.");
                    alert.show();
                }
            }
        }else if(inputType=="Decimal"){
            if(outputType == "Binary"){
                if (txtInput.getText().matches("[0-9]+")) convertDec2Bin();
            }else {
                txtOutput.setText("");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Decimal value invalid. Please try again.");
                alert.show();
            }
        }
    }

    private void convertDec2Bin() {
        int input=Integer.parseInt(txtInput.getText());
        String result="";
        while(input>0){
            result+=input%2;
            input/=2;
        }
        txtOutput.setText(new StringBuilder(result).reverse().toString());
    }

    private void convertBin2Dec() {
        int result=0;
        String inputText=txtInput.getText();
        for(int i=0;i<inputText.length();i++){
            if(inputText.charAt(i)=='1'){
                result+=(Math.pow(2,inputText.length()-1-i));
            }
        }
        txtOutput.setText(String.valueOf(result));

    }
    @FXML
    public void cmbBxInputTypeOnAction(ActionEvent actionEvent) {
        txtInput.setPromptText(cmbBxInputType.getSelectionModel().getSelectedItem().toString());
        txtOutput.clear();

    }
    @FXML
    public void cmbBxOutputTypeOnAction(ActionEvent actionEvent) {
        txtOutput.setPromptText(cmbBxOutputType.getSelectionModel().getSelectedItem().toString());
        txtOutput.clear();
    }

}

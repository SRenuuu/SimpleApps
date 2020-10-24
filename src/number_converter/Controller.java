package number_converter;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;

import java.awt.*;

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
        check: if(inputType=="Binary"){
            if(outputType=="Decimal"){
                for(char digit: txtInput.getText().toCharArray()){
                    if (digit!='0' && digit!='1'){
                        txtOutput.setText("");
                        Alert alert=new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Binary value invalid. Please try again.");
                        alert.show();
                        break check;
                    }
                }
                covertBin2Dec();
            }
        }

    }

    private void covertBin2Dec() {
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

    }
    @FXML
    public void cmbBxOutputTypeOnAction(ActionEvent actionEvent) {
        txtOutput.setPromptText(cmbBxOutputType.getSelectionModel().getSelectedItem().toString());
    }

//
//    public void txtInputKeyReleased(KeyEvent keyEvent) {
//        covertBin2Dec();
//    }
}

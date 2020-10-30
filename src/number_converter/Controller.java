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

    String outType="Binary";
    String inType="Decimal";

    @FXML
    public void initialize(){
        cmbBxInputType.getItems().removeAll(cmbBxInputType.getItems());
        cmbBxInputType.getItems().addAll("Binary","Decimal","Octal","Hexa-decimal");
        cmbBxInputType.getSelectionModel().select(0);
        cmbBxInputType.getItems().remove(inType);

        cmbBxOutputType.getItems().removeAll(cmbBxInputType.getItems());
        cmbBxOutputType.getItems().addAll("Binary","Decimal","Octal","Hexa-decimal");
        cmbBxOutputType.getItems().remove(outType);
        //cmbBxOutputType.getSelectionModel().select(0);
    }

    @FXML
    public void btnConvertOnAction(ActionEvent actionEvent) {
        String inputType=cmbBxInputType.getSelectionModel().getSelectedItem().toString();
        String outputType=cmbBxOutputType.getSelectionModel().getSelectedItem().toString();
        if(inputType == "Binary"  && (txtInput.getText().matches("[0-1]+"))) {
            if (outputType == "Decimal") convertBin2Dec();
            if (outputType == "Octal") convertBin2Oct();
            if (outputType == "Hexa-decimal") convertBin2Hex();

        }else if (inputType == "Decimal"  && (txtInput.getText().matches("[0-9]+"))) {
            if (outputType == "Binary") convertDec2Bin();
            if (outputType == "Octal") convertDec2Oct();
            if (outputType == "Hexa-decimal") convertDec2Hex();

        }else if (inputType == "Octal"  && (txtInput.getText().matches("[0-7]+"))) {
            if (outputType == "Binary") convertOct2Bin();
            if (outputType == "Decimal") convertOct2Dec();
            if (outputType == "Hexa-decimal") convertOct2Hex();


        }else if (inputType == "Hexa-decimal"  && (txtInput.getText().matches("[0-7,A-F]+"))) {
            if (outputType == "Binary") convertHex2Bin();
            if (outputType == "Decimal") convertHex2Dec();
            if (outputType == "Octal") convertHex2Oct();

        }else {
            txtOutput.setText("");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Input value invalid. Please try again.");
            alert.show();
        }
    }

    private void convertDec2Hex() {
        System.out.println("Dec 2 Hex");
    }

    private void convertDec2Oct() {
        System.out.println("Dec 2 Oct");
    }

    private void convertHex2Oct() {
    }

    private void convertHex2Dec() {
    }

    private void convertHex2Bin() {
    }

    private void convertOct2Hex() {
    }

    private void convertOct2Dec() {
    }

    private void convertOct2Bin() {
    }

    private void convertBin2Hex() {
    }

    private void convertBin2Oct() {
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
        String type=cmbBxInputType.getSelectionModel().getSelectedItem().toString();
        if(type!=outType) {
            removeFrom(cmbBxOutputType,cmbBxInputType,type);

            txtInput.setPromptText(cmbBxInputType.getSelectionModel().getSelectedItem().toString());
            txtOutput.clear();
        }
    }
    @FXML
    public void cmbBxOutputTypeOnAction(ActionEvent actionEvent) {

        String type=cmbBxOutputType.getSelectionModel().getSelectedItem().toString();
        if(type!=inType) {
            removeFrom(cmbBxInputType,cmbBxOutputType,type);

            txtOutput.setPromptText(cmbBxOutputType.getSelectionModel().getSelectedItem().toString());
            txtOutput.clear();
        }
    }

    private void removeFrom(JFXComboBox cmbBx1, JFXComboBox cmbBx2, String inOutType) {
        cmbBx1.getItems().add(inOutType);
        inOutType = cmbBx2.getSelectionModel().getSelectedItem().toString();
        cmbBx1.getItems().remove(inOutType);
    }
}

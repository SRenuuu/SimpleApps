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
        cmbBxOutputType.getSelectionModel().select(0);
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
    private void convertDec2Bin() {
        int input=Integer.parseInt(txtInput.getText());
        String result="";
        while(input>0){
            result+=input%2;
            input/=2;
        }
        txtOutput.setText(new StringBuilder(result).reverse().toString());
    }

    private void convertDec2Hex() {
        int input=Integer.parseInt(txtInput.getText());
        String result="";
        while(input>0){
            int temp=input%16;
            switch (temp){
                case 10:
                    result+='A';
                    break;
                case 11:
                    result+='B';
                    break;
                case 12:
                    result+='C';
                    break;
                case 13:
                    result+='D';
                    break;
                case 14:
                    result+='E';
                    break;
                case 15:
                    result+='F';
                    break;
                default:
                    result+=temp;
                    break;
            }
            input/=16;
        }
        txtOutput.setText(new StringBuilder(result).reverse().toString());
    }

    private void convertDec2Oct() {
        int input=Integer.parseInt(txtInput.getText());
        String result="";
        while(input>0){
            result+=input%8;
            input/=8;
        }
        txtOutput.setText(new StringBuilder(result).reverse().toString());
    }

    //=================================

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

    //=================================

    private void convertBin2Hex() {
        int temp=0;
        String inputText=txtInput.getText();
        for(int i=0;i<inputText.length();i++){
            if(inputText.charAt(i)=='1'){
                temp+=(Math.pow(2,inputText.length()-1-i));
            }
        }

        int input=temp;
        String result="";
        while(input>0){
            int temp2=input%16;
            switch (temp2){
                case 10:
                    result+='A';
                    break;
                case 11:
                    result+='B';
                    break;
                case 12:
                    result+='C';
                    break;
                case 13:
                    result+='D';
                    break;
                case 14:
                    result+='E';
                    break;
                case 15:
                    result+='F';
                    break;
                default:
                    result+=temp2;
                    break;
            }
            input/=16;
        }
        txtOutput.setText(new StringBuilder(result).reverse().toString());

    }

    private void convertBin2Oct() {
        int temp=0;
        String inputText=txtInput.getText();
        for(int i=0;i<inputText.length();i++){
            if(inputText.charAt(i)=='1'){
                temp+=(Math.pow(2,inputText.length()-1-i));
            }
        }

        int input=temp;
        String result="";
        while(input>0){
            result+=input%8;
            input/=8;
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
            cmbBxOutputType.getItems().add(outType);
            outType = cmbBxInputType.getSelectionModel().getSelectedItem().toString();
            cmbBxOutputType.getItems().remove(outType);

            txtInput.setPromptText(cmbBxInputType.getSelectionModel().getSelectedItem().toString());
            txtOutput.clear();
        }
    }
    @FXML
    public void cmbBxOutputTypeOnAction(ActionEvent actionEvent) {
        String type=cmbBxOutputType.getSelectionModel().getSelectedItem().toString();
        if(type!=inType) {
            cmbBxInputType.getItems().add(inType);
            inType = cmbBxOutputType.getSelectionModel().getSelectedItem().toString();
            cmbBxInputType.getItems().remove(inType);

            txtOutput.setPromptText(cmbBxOutputType.getSelectionModel().getSelectedItem().toString());
            txtOutput.clear();
        }
    }
}

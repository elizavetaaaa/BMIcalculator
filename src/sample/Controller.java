package sample;

import com.sun.jdi.IntegerValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.NumberFormat;

public class Controller {
    private static final NumberFormat currency =
            NumberFormat.getCurrencyInstance();


    @FXML
    private javafx.scene.layout.VBox VBox;

    @FXML
    private Font x1;

    @FXML
    private Color x2;

    @FXML
    private Button CalculateButton;

    @FXML
    private Label WidthLabel;

    @FXML
    private Label HeightLabel;

    @FXML
    private TextField WidthEntry;

    @FXML
    private TextField GeightEntry;

    @FXML
    private ImageView ImageView;

    @FXML
    private Label TextArea;

    @FXML
    private TextArea InfoTable;

    @FXML
    private Font x3;

    @FXML
    private Color x4;


    //FileInputStream input1 = new FileInputStream("/sample/bmi1.jpg");
    Image image1 = new Image("/sample/bmi1.jpg");

  // FileInputStream input2 = new FileInputStream("/sample/bmi2.png");
    Image image2 = new Image("/sample/bmi2.png");

    //FileInputStream input3 = new FileInputStream("/sample/bmi3.png");
    Image image3 = new Image("/sample/bmi3.png");

   // FileInputStream input4 = new FileInputStream("/sample/bmi4.png");
    Image image4 = new Image("/sample/bmi4.png");

    public Controller() throws FileNotFoundException {
    }



   /* CalculateButton.setOnAction(new EventHandler() {
        @Override
        public void handle(ActionEvent event) {
            // instructions executed when the button is clicked
            System.out.println("Hi there! You clicked me!");
        }
    });
*/

    @FXML
    void display(ActionEvent event) {
            try{
                double weight = Double.parseDouble(WidthEntry.getText());

            double height = Double.parseDouble(GeightEntry.getText());
            double bmi = (weight / ((height/100.0) *( height/100.0)));
            double roundOff = Math.round(bmi * 100.0) / 100.0;
            if (roundOff <= 18.5 && weight>0 && height>0) {
                TextArea.setText("BMI is \n " + Double.toString(roundOff) + ".   Underweight!" );
               ImageView.setImage(image1);
                InfoTable.setText("UnderWeight bmi<18.5\n\n" +
                        "Normal 18.5<bmi<24.9\n\n" +"OverWeight 25<bmi<29.9\n\n"+"Obese bmi>30");
            } else if (18.6 <= roundOff && roundOff <= 24.9 && weight>0 && height>0 ) {
                TextArea.setText("BMI is \n "+ Double.toString(roundOff)+ ".  Healthy Weight!");
                ImageView.setImage(image2);
                InfoTable.setText("UnderWeight bmi<18.5\n\n" +
                        "Normal 18.5<bmi<24.9\n\n" +"OverWeight 25<bmi<29.9\n\n"+"Obese bmi>30");
            } else if (25 <=roundOff && roundOff <= 29.9 && weight>0 && height>0) {
                TextArea.setText("BMI is  \n"+ Double.toString(roundOff)+ ".  Overweight!");
                ImageView.setImage(image3);
                InfoTable.setText("UnderWeight bmi<18.5\n\n" +
                        "Normal 18.5<bmi<24.9\n\n" +"OverWeight 25<bmi<29.9\n\n"+"Obese bmi>30");
            } else if(roundOff>30 && weight>0 && height>0){
                TextArea.setText("BMI is \n " + Double.toString(roundOff)+ ".  Obese!");
                ImageView.setImage(image4);
                InfoTable.setText("UnderWeight bmi<18.5\n\n" +
                        "Normal 18.5<bmi<24.9\n\n" +"OverWeight 25<bmi<29.9\n\n"+"Obese bmi>30");
            }
            else if (weight<=0 && height<=0){
                    WidthEntry.clear();
                    WidthEntry.setText("Invalid value!");
                    GeightEntry.clear();
                    GeightEntry.setText("Invalid value!");

                }
            }
          catch (NumberFormatException e) {
                WidthEntry.clear();
              WidthEntry.setText("Invalid value!");
              GeightEntry.clear();
              GeightEntry.setText("Invalid value!");

          }

        }


    }

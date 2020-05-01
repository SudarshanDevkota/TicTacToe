package sample;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;


import javafx.geometry.Pos;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.util.List;


public class Controller {
    @FXML
    public Button btn1;
    @FXML
    public Button btn2;
    @FXML
    public Button btn3;
    @FXML
    public Button btn4;
    @FXML
    public Button btn5;
    @FXML
    public Button btn6;
    @FXML
    public Button btn7;
    @FXML
    public Button btn8;
    @FXML
    public Button btn9;
    @FXML
    public Button playerX;
    private int playerXscore=0;
    @FXML
    public Button playerO;
    private int playerOscore=0;
    @FXML
    public GridPane playWindow;
    @FXML
    public Button btnPlay;
    @FXML
    public Button btnReset;
    @FXML
    public Label turnLabel;
    @FXML
    public Label overLabel;
    private boolean isOver=false;
    private int turns=0;


    private String currentPlayer = "X";
    private List<Button> row1;


public void initialize(){
        playWindow.setVisible(false);
        turnLabel.setText(currentPlayer);
        overLabel.setAlignment(Pos.CENTER);
}

    @FXML
    public void playorReset(ActionEvent e) {

        if (e.getSource().equals(btnPlay)) {
            playWindow.setVisible(true);
            removeSymbols();
            turns=0;
            isOver=false;
            overLabel.setText("");



        } else if (e.getSource().equals(btnReset)) {
            playerOscore=0;
            playerXscore=0;
            playerO.setText(String.valueOf(0));
            playerX.setText(String.valueOf(0));
            removeSymbols();
            turns=0;
            isOver=false;
            overLabel.setText("");

            }

        }

    public void fillBoard(Button btn, String symbol) {
        if(!isOver){
            if (symbol.equals("X")){
                btn.setTextFill(Color.BLUE);
                btn.setText("X");
                currentPlayer = "O";

            } else {
                btn.setTextFill(Color.RED);
                btn.setText("O");
                currentPlayer = "X";
            }
            turnLabel.setText(currentPlayer);
        }
    }

    @FXML
    public void playControl(ActionEvent e) {

        try {
            Button b = (Button) e.getSource();
            if (b.getText().isEmpty()) {
                fillBoard(b,currentPlayer);
                turns++;

            }

        } catch (Exception ex) {
            System.out.println("found exception");
        }
        checkWinner();
        checkDraw();

    }
    private void removeSymbols(){

        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");



    }
    private void checkWinner(){
      if(!isOver) {
          String cr = checkRow();
          String cc = checkColumn();
          String cd=checkDiagonal();
          if (cr.equals("X") || cr.equals("O")) {

              isOver = true;
          } else if (cc.equals("X") || cc.equals("O")) {

              isOver = true;
          }else if(cd.equals("X")|| cd.equals("O")){
              isOver=true;
          }
          if (isOver) {
              if (cr.equals("X") || cc.equals("X") || cd.equals("X")) {
                  playerXscore++;
                  playerX.setText(String.valueOf(playerXscore));
                  turnLabel.setText("");
                  overLabel.setText("Game Over Player X won");


              } else {
                  playerOscore++;
                  playerO.setText(String.valueOf(playerOscore));
                  turnLabel.setText("");
                  overLabel.setText("Game Over Player O won ");
              }

          }

      }


    }

    private String checkRow(){
        if((btn1.getText().equals((btn2.getText()))) && (btn1.getText().equals((btn3.getText())))){
            return btn1.getText();
        }else if((btn4.getText().equals((btn5.getText()))) && (btn4.getText().equals((btn6.getText())))){
            return btn4.getText();
        }else if((btn7.getText().equals((btn8.getText()))) && (btn7.getText().equals((btn9.getText())))){
            return btn7.getText();
        }
        return "";
    }

    private String checkColumn(){
        if((btn1.getText().equals((btn4.getText()))) && (btn1.getText().equals((btn7.getText())))){
            return btn1.getText();
        }else if((btn2.getText().equals((btn5.getText()))) && (btn2.getText().equals((btn8.getText())))){
            return btn2.getText();
        }else if((btn3.getText().equals((btn6.getText()))) && (btn3.getText().equals((btn9.getText())))){
            return btn3.getText();
        }
        return "";
    }

    private void  checkDraw(){
        if(turns==9 && isOver==false){
           overLabel.setText("Draw");
            isOver=true;

        }
}
    private String checkDiagonal(){
        if((btn1.getText().equals((btn5.getText()))) && (btn1.getText().equals((btn9.getText())))){
            return btn1.getText();
        }else if((btn3.getText().equals((btn5.getText()))) && (btn3.getText().equals((btn7.getText())))) {
            return btn3.getText();
        }
        return "";
        }
}
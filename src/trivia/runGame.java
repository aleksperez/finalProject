package trivia;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class runGame implements Runnable{
    Label o1,o2,c,choice1,choice2,choice3,choice4,end,points,question;
    Button b1,b2,b3,b4,r;
    Text time;
    TextField player;


    public runGame(Label object1, Label object2, Label clock, Label choice1, Label choice2, Label choice3, Label choice4, Button A, Button B, Button C, Button D, Button report, Text t, Label endGame, Label point, TextField player,Label q){
        o1 = object1;
        o2 = object2;
        this.choice1=choice1;
        this.choice2=choice2;
        this.choice3=choice3;
        this.choice4=choice4;
        b1 = A;
        b2 = B;
        b3 = C;
        b4 = D;
        c = clock;
        r = report;
        time = t;
        end = endGame;
        points = point;
        this.player = player;
        this.question = q;
    }

    @Override
    public void run(){
        try{
            for(int i =0;i<10;i++){
                int fi=i;
                Platform.runLater(() -> {
                    question.setText((fi+1)+" /10");
                    b1.setDisable(false);
                    b2.setDisable(false);
                    b3.setDisable(false);
                    b4.setDisable(false);
                    o1.setText(readFile.objects1().get(fi));
                    o2.setText(readFile.objects2().get(fi));

                    choice1.setText(readFile.choices1().get(fi));
                    choice2.setText(readFile.choices2().get(fi));
                    choice3.setText(readFile.choices3().get(fi));
                    choice4.setText(readFile.choices4().get(fi));
                });
                Platform.runLater(()-> c.setText("5"));
                Thread.sleep(1000);
                Platform.runLater(() -> c.setText("4"));
                Thread.sleep(1000);
                Platform.runLater(() -> c.setText("3"));
                Thread.sleep(1000);
                Platform.runLater(() -> c.setText("2"));
                Thread.sleep(1000);
                Platform.runLater(() -> c.setText("1"));
                Thread.sleep(1000);

                Platform.runLater(() -> {
                    c.setText("0");
                    b1.setDisable(true);
                    b2.setDisable(true);
                    b3.setDisable(true);
                    b4.setDisable(true);
                });
            }
            Platform.runLater(() -> end.setVisible(true));
            database.addPlayer(player.getText(),Integer.parseInt(points.getText()));
            Platform.runLater(() -> {r.setVisible(true); r.setDisable(false);});
        }
        catch (NumberFormatException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        Platform.runLater(() -> {
            String current = "";
            while(!gameBoard.timeStack.isEmpty()){
                current += gameBoard.timeStack.pop() + "\n";
        }
        time.setText(current);});
    }
    
}

package trivia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.*;
import java.sql.Timestamp;

public class gameBoard implements Initializable {
    static Timestamp timestamp;
    static Date date;
    static ObservableList<player> playerList;
    static ObservableList<player> playerListSorted;
    static Stack<String> timeStack = new Stack<>();
    static int j = 0;
    static int k = 1;

    @FXML
    TableView<player> playerTable;
    @FXML
    TableColumn<player, String> column1;
    @FXML
    TableColumn<player, Integer> column2;
    @FXML
    GridPane gr;
    @FXML
    Label object1, object2, choice1,choice2,choice3,choice4,clock, nameArea, point, end, plus, table, question;
    @FXML
    Text timestamps;
    @FXML
    TextField player;
    @FXML
    Button A, B, C, D, generateReport;
    @FXML

    public void startGame() {
        nameArea.setText(player.getText());
        player.setDisable(true);
        player.setVisible(false);
        runGame th = new runGame(object1, object2, clock, choice1, choice2, choice3, choice4, A, B, C, D, generateReport,
                timestamps, end, point, player, question);
        Thread t1 = new Thread(th);
        t1.start();
    }

    public static boolean isAnswer(String val, ArrayList<String> list) {
        boolean answer = false;
        for (String a : list) {
            if (val.equals(a)) {
                answer = true;
                break;
            }
        }
        return answer;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        end.setVisible(false);
        generateReport.setDisable(true);
        generateReport.setVisible(false);
        timestamps.setText("");
        player.setEditable(true);
        player.requestFocus();
        playerTable.setVisible(false);
    }

    @FXML
    public void checkResult1() {
        setAnswer(choice1);
    }

    @FXML
    public void checkResult2() {
        setAnswer(choice2);
    }

    @FXML
    public void checkResult3() {
        setAnswer(choice3);
    }

    @FXML
    public void checkResult4() {
        setAnswer(choice4);
    }

    @FXML
    public void showResults() throws FileNotFoundException {
        playerTable.setVisible(true);
        object1.setVisible(false);
        object2.setVisible(false);
        plus.setVisible(false);
        question.setVisible(false);
        end.setVisible(false);
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
        A.setVisible(false);
        B.setVisible(false);
        C.setVisible(false);
        D.setVisible(false);
        gr.setVisible(false);
        column1.setCellValueFactory(new PropertyValueFactory<>("name"));
        column2.setCellValueFactory(new PropertyValueFactory<>("point"));
        playerList = database.findAllPlayers();
        playerList.sort(new comparePlayers());
        playerListSorted = FXCollections.observableArrayList();
        if (playerList.size() >= 10) {
            for (int j = 0; j < 10; j++) {
                playerListSorted.add(playerList.get(j));
            }
        } else {
            playerListSorted.addAll(playerList);
        }
        playerTable.setItems(playerListSorted);

        try {
            File newFile = new File("output.txt");
            newFile.setWritable(true);
            if (newFile.createNewFile()) {
                PrintWriter pw = new PrintWriter(newFile);
                pw.println(playerListSorted);
                pw.close();
            } else {
                FileOutputStream fs = new FileOutputStream("output.txt");
                PrintWriter pw = new PrintWriter(fs);
                pw.println(playerListSorted);
                pw.close();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    private void setAnswer(Label l) {
        if (isAnswer(l.getText(), readFile.getAnswers())) {
            j++;
            point.setText("" + j);
            A.setDisable(true);
            B.setDisable(true);
            C.setDisable(true);
            D.setDisable(true);
            date = new Date();
            timestamp = new Timestamp(date.getTime());
            String temp = timestamp + "\nQuestion " + k + " | " + 1 + " point";
            timeStack.push(temp);
        } else {
            A.setDisable(true);
            B.setDisable(true);
            C.setDisable(true);
            D.setDisable(true);
            date = new Date();
            timestamp = new Timestamp(date.getTime());
            String temp = timestamp + "\nQuestion " + k + " | " + 0 + " points";
            timeStack.push(temp);
        }
        k++;

    }

}

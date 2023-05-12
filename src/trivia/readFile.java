package trivia;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner; 


public class readFile {
    
    static ArrayList<String> objects1 = new ArrayList<>();
    static ArrayList<String> objects2 = new ArrayList<>();
    static ArrayList<String> choices1 = new ArrayList<>();
    static ArrayList<String> choices2 = new ArrayList<>();
    static ArrayList<String> choices3 = new ArrayList<>();
    static ArrayList<String> choices4 = new ArrayList<>();

    static String object1,object2,choice1,choice2,choice3,choice4;


    public static ArrayList<String> objects1() {
        try {
            File file = new File("C:\\input.txt");
            Scanner scan = new Scanner(file);
            for(int i = 0; i < 10; i++) {
                object1 = scan.next();
                objects1.add(object1);
                scan.next();
                scan.nextLine();
                scan.nextLine();
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return objects1;
    }

    public static ArrayList<String> objects2() {
        try {
            File file = new File("C:\\input.txt");
            Scanner scan = new Scanner(file);
            for(int i = 0; i < 10; i++) {
                scan.next();
                object2 = scan.next();
                objects2.add(object2);
                scan.next();
                scan.nextLine();

            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return objects2;
    }
    public static ArrayList<String> choices1() {
        try {
            File file = new File("C:\\input.txt");
            Scanner scan = new Scanner(file);
            for(int i = 0; i < 10; i++) {
                scan.nextLine();
                choice1 = scan.next();
                choices1.add(choice1);
                scan.nextLine();
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return choices1;
    }
    public static ArrayList<String> choices2() {
        try {
            File file = new File("C:\\input.txt");
            Scanner scan = new Scanner(file);
            for(int i = 0; i < 10; i++) {
                scan.nextLine();
                scan.next();
                choice2 = scan.next();
                choices2.add(choice2);
                scan.nextLine();
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return choices2;
    }
    public static ArrayList<String> choices3() {
        try {
            File file = new File("C:\\input.txt");
            Scanner scan = new Scanner(file);
            for(int i = 0; i < 10; i++) {
                scan.nextLine();
                scan.next();
                scan.next();
                choice3 = scan.next();
                choices3.add(choice3);
                scan.nextLine();
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return choices3;
    }
    public static ArrayList<String> choices4() {
        try {
            File file = new File("C:\\input.txt");
            Scanner scan = new Scanner(file);
            for(int i = 0; i < 10; i++) {
                scan.nextLine();
                scan.next();
                scan.next();
                scan.next();
                choice4 = scan.next();
                choices4.add(choice4);
                scan.nextLine();
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return choices4;
    }


public static ArrayList<String> getAnswers(){
     ArrayList<String> answers = new ArrayList<>();
     answers.add("9.0");
     answers.add("9.0");
     answers.add("MickeyMouse");
     answers.add("ca");
     answers.add("16");
     answers.add("8.1f");
     answers.add("JavaProgram");
     answers.add("6.3f");
     answers.add("MaryLamb");
     answers.add("11");
     return answers;
}

}

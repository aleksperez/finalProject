package trivia;

public class player {
    String name;
    int point;

    public player(String name, int point){
        this.name = name;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String toString(){
        return name + " " + point;
    }
}

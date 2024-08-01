package ru.andreisesiunin;

public class Quiz1 {
    private final String level;


    public Quiz1(String level) {
        this.level = level;
    }

    public static void main(String[] args) {
        var q1 = new Quiz1("Easy");
        System.out.println(q1.getLevel());
    }

    public String getLevel() {
        return level;
    }
}

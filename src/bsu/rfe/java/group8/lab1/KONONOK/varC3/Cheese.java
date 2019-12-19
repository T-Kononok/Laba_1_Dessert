package bsu.rfe.java.group8.lab1.KONONOK.varC3;

public class Cheese extends Food
{
    public Cheese() {
        super("Сыр");
    }
    public void consume() {
        System.out.println(this + " съеден");
    }

    public int calculateCalories() {
            return 2;
    }
}


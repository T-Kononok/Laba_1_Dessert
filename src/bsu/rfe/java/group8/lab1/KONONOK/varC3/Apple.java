package bsu.rfe.java.group8.lab1.KONONOK.varC3;

import javax.management.openmbean.KeyAlreadyExistsException;

public class Apple extends Food
{
    private String size;

    public Apple(String size) {
        super("Яблоко");
        this.size = size;
    }

    public void consume() {
        System.out.println(this + " съедено");
    }

    public String getSize() {
        return size;
    }

    public int calculateCalories() {
        if (size.equals("малое"))
            return 1;
        else
            return 2;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean equals(Object arg0) {
        if (!(super.equals(arg0))) return false;
        if (!(arg0 instanceof Apple)) return false;
        return size.equals(((Apple)arg0).size);
    }

    public String toString() {
        return super.toString() + " размера '" + size.toUpperCase() + "'";
    }
}
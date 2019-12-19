package bsu.rfe.java.group8.lab1.KONONOK.varC3;

public class Dessert extends Food
{
    private String component1;
    private String component2;

    public Dessert(String component1, String component2) {
        super("Десерт");
        this.component1 = component1;
        this.component2 = component2;
    }

    public void consume() {
        System.out.println(this + " съеден");
    }

    public int calculateCalories() {
        int cal = 0;
        if (component1.equals("йогурт") || component2.equals("йогурт"))
            cal++;
        if (component1.equals("мороженное") || component2.equals("мороженное"))
            cal += 2;
        if (component1.equals("блин") || component2.equals("блин"))
            cal += 3;
        if (component1.equals("клубника") || component2.equals("клубника"))
            cal++;
        if (component1.equals("варенье") || component2.equals("варенье"))
            cal += 2;
        if (component1.equals("карамель") || component2.equals("карамель"))
            cal += 3;
        return cal;
    }
    public String getComponent1() {
        return component1;
    }

    public String getComponent2() {
        return component2;
    }

    public void setComponent1(String component1) {
        this.component1 = component1;
    }

    public void setComponent2(String component2) {
        this.component2 = component2;
    }

    public boolean equals(Object arg0) {
        if (!(super.equals(arg0))) return false;
        if (!(arg0 instanceof Dessert)) return false;
        if (component1.equals(((Dessert)arg0).component1)) {
            return component2.equals(((Dessert) arg0).component2);
        }
        else {
            if (!(component1.equals(((Dessert) arg0).component2))) return false;
            else
                return component2.equals(((Dessert) arg0).component1);
        }
    }

    public String toString() {
        return super.toString() + " с компанентами: '" + component1.toUpperCase() + "' и '" + component2.toUpperCase() + "'";
    }
}
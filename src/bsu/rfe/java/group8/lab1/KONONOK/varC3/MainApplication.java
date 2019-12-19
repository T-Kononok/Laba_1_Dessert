package bsu.rfe.java.group8.lab1.KONONOK.varC3;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MainApplication
{
    public static void main(String[] args) throws Exception {

        Food[] breakfast = new Food[20];

        int itemsSoFar = 0;

        boolean sortbool = false, caloriesbool = false;
        for (String arg: args) {
            String[] parts = arg.split("/");
            if (parts[0].toString().charAt(0) == '-')
            {
                if (parts[0].equals("-calories"))
                    caloriesbool = true;
                else
                    sortbool = true;
            }
            else
                if (parts[0].equals("Apple") || parts[0].equals("Cheese") || parts[0].equals("Dessert")) {
                    Class myClass = Class.forName("bsu.rfe.java.group8.lab1.KONONOK.varC3." + parts[0]);
                    if (parts.length==1) {
                        Constructor constructor = myClass.getConstructor();
                        breakfast[itemsSoFar] = (Food)constructor.newInstance();
                    } else
                    if (parts.length==2) {
                        Constructor constructor = myClass.getConstructor(String.class);
                        breakfast[itemsSoFar] = (Food)constructor.newInstance(parts[1]);
                    } else
                    if (parts.length==3) {
                        Constructor constructor = myClass.getConstructor(String.class, String.class);
                        breakfast[itemsSoFar] = (Food)constructor.newInstance(parts[1], parts[2]);
                    }
                    itemsSoFar++;
                }
                else
                {
                    System.out.println("Не знаю такого продукта : " + arg);
                }
        }

        if (sortbool)
        {
            Arrays.sort(breakfast, new Comparator<Food>() {
                public int compare(Food f1, Food f2) {
                    if (f1 == null) return 1;
                    if (f2 == null) return -1;
                    int f1k = 0, f2k = 0;
                    f1k = f1.toString().length() - f1.toString().replaceAll(" ", "").length();
                    f2k = f2.toString().length() - f2.toString().replaceAll(" ", "").length();
                    return Integer.compare(f1k, f2k);
                }
            });
        }

        Food[] prov = new Food[1];
        Scanner in = new Scanner(System.in);
        System.out.println("Какой продукт считать: ");
        String prod = in.nextLine();
        //String prod = "Apple/малое";
        in.close();

        String[] partsprov = prod.split("/");
        Class myClass = Class.forName("bsu.rfe.java.group8.lab1.KONONOK.varC3." + partsprov[0]);
        if (partsprov.length==1) {
            Constructor constructor = myClass.getConstructor();
            prov[0] = (Food)constructor.newInstance();
        } else
        if (partsprov.length==2) {
            Constructor constructor = myClass.getConstructor(String.class);
            prov[0] = (Food)constructor.newInstance(partsprov[1]);
        } else
        if (partsprov.length==3) {
            Constructor constructor = myClass.getConstructor(String.class, String.class);
            prov[0] = (Food)constructor.newInstance(partsprov[1], partsprov[2]);
        }

        int kol = 0, col = 0;
        for (Food item: breakfast)
            if (item!=null) {
                if (item.equals(prov[0]))
                    kol++;
                item.consume();
                if (caloriesbool)
                    col += item.calculateCalories();
            }
            else
                break;

        System.out.println("Все сьели, экземпляров заданного продукта - " + kol);
        if (caloriesbool)
            System.out.println("Каллории - " + col);
    }
}
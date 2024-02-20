import java.util.ArrayList;

import People.*;
import People.Character;
import Value.Coordinates;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<Character> list = new ArrayList();
        list.add(new Magician("Vasya1", new Coordinates(1, 0)));
        list.add(new Crossbowman("Vasya2", new Coordinates(4, 9)));
        list.add(new Monk("Vasya3", new Coordinates(3, 0)));
        list.add(new Peasant("Vasya4", new Coordinates(7, 9)));
        list.add(new Robber("Vasya5", new Coordinates(2, 0)));
        list.add(new Sniper("Vasya6", new Coordinates(7, 9)));
        list.add(new Spearman("Vasya7", new Coordinates(2, 0)));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // вычисление ближайшего противника для стрелка
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Sniper) {
                Sniper sniper = ((Sniper) list.get(i));
                System.out.println("Ближайший противник для снайпера " + sniper.name + ": " + sniper.getClosetEnemy(list));
            }
        }
    }
}
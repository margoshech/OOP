import java.util.ArrayList;

import People.*;
import People.Character;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<Character> list = new ArrayList();
        list.add(new Magician());
        list.add(new Crossbowman());
        list.add(new Monk());
        list.add(new Peasant());
        list.add(new Robber());
        list.add(new Sniper());
        list.add(new Spearman());

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
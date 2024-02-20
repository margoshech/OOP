package People;

import java.util.ArrayList;

import Value.Coordinates;

abstract public class Character {
    public int id;
    public String name;
    public String lastname;
    public int hp = 100;
    public int damage;
    public int level = 1;
    public double money;
    
    public Coordinates coordinates;

    public void attack()
    {
        System.out.println("attack");
    }

    public void step()
    {
        System.out.println("step");
    }

    public void run()
    {
        System.out.println("run");
    }

    public void treatment()
    {
        System.out.println("treatment"); //лечение
    }
}

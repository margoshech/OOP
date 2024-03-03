package People;

import java.util.ArrayList;

import Action.Step;
import Value.Coordinates;

abstract public class Character implements Step {
    public int id;
    public String name;
    public String lastname;
    public int hp = 100;
    public int damage = 1;
    public int level = 1;
    public double money;
    public int initiative;
    public ArrayList<Character> enemies;
    
    public Coordinates coordinates;

    public void setEnemies(ArrayList<Character> enemies)
    {
        this.enemies = enemies;
    }

    public void attack(Character enemy)
    {
        enemy.hp -= damage;
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

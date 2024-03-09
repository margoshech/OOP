package People;

import Action.GoToEnemy;
import Value.Coordinates;

// разбойник
public class Robber extends Character {
    int cunning; // хитрость
    int initiative = 2;
    public String type = "Разбойник";

    public Robber(String name, Coordinates coordinates)
    {
        this.name = name;
        this.coordinates = coordinates;
    }

    @Override
    public void step()
    {
        if (isDead()) {
            return;
        }

        GoToEnemy.goToClosestEnemy(this);
    }

    public String toString()
    {
        return "Разбойник "+name+". Координаты: " + coordinates + ". HP: " + hp;
    }
}

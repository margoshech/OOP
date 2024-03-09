package People;

import Action.GoTo;
import Value.Coordinates;

// разбойник
public class Robber extends Character {
    int cunning; // хитрость
    int initiative = 2;

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

        if (GoTo.goToClosestEnemy(this) == 1) {
            attack(getClosestEnemy());
        }
    }

    public String toString()
    {
        return "Разбойник "+name+". Координаты: " + coordinates + ". HP: " + hp;
    }

    @Override
    public String getType() {
        return "Разбойник";
    }
}

package People;

import Action.GoTo;
import Value.Coordinates;

//арбалетчик
public class Crossbowman extends Character{
    int bolts = 10; //болты
    int initiative = 3;

    public Crossbowman(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    public String toString()
    {
        return "Арбалетчик "+ name +". Координаты: " + coordinates + ". HP: " + hp;
    }

    @Override
    public String getType() {
        return "Арбалетчик";
    }

    public void step()
    {
        if (isDead()) {
            return;
        }

        Character enemy = getClosestEnemy();
        if (bolts >= 1) {
            if (GoTo.goToClosestEnemy(this) <= 5) { // стреляет из 5 клетов
                attack(enemy);
                bolts--;
            }
        } else {
            if (GoTo.goToClosestEnemy(this) == 1) { // бьёт в рукопашную
                attack(enemy);
            }
        }
    }
}

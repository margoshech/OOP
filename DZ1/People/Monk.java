package People;

import Action.GoTo;
import Value.Coordinates;

//монах
public class Monk extends Character{
    int books;
    int initiative = 1;
    public String type = "Монах";

    public Monk(String name, Coordinates coordinates)
    {
        this.name = name;
        this.coordinates = coordinates;
    }

    @Override
    public String getType() {
        return "Монах";
    }

    @Override
    public void step()
    {
        if (isDead()) {
            return;
        }

        if (!prayer()) {
            if (GoTo.goToClosestEnemy(this) == 1) {
                attack(getClosestEnemy());
            }
        }
    }

    // Молитва
    public boolean prayer()
    {
        // Ищем копейщика, если нет, то любого союзника
        Character friend = (Spearman) this.getClosestFriedByType("Копейщик");
        if (null == friend) {
            friend = this.getClosestFried();
        }

        if (null == friend) {
            return false;
        }

        friend.isBuf = true;
        System.out.println(name + " даёт благославление для " + friend.getType() + " "+ friend.name);
        return true;
    }

    public String toString()
    {
        return "Монах "+name+". Координаты: " + coordinates + ". HP: " + hp;
    }
}

package People;

import Action.GoTo;
import Value.Coordinates;

// крестьянин
public class Peasant extends Character {
    int amountOfLand; // количество земли
    int initiative = 0;

    public Peasant(String name, Coordinates coordinates)
    {
        this.name = name;
        this.coordinates = coordinates;
    }

    public String toString()
    {
        return "Крестьянин "+name+". Координаты: " + coordinates + ". HP: " + hp;
    }

    @Override
    public String getType() {
        return "Крестьянин";
    }

    @Override
    public void step()
    {
        if (isDead()) {
            return;
        }

        Double res = GoTo.goToClosestFriend(this, "Снайпер");
        if (res == 1) {
            Sniper friend = (Sniper) this.getClosestFriedByType("Снайпер");
            friend.arrows +=1; // даём стрелу
            System.out.println("Крестьянин " + name + " даёт стрелу " + friend.name);
        }
    }
}

package People;

import Value.Coordinates;

// крестьянин
public class Peasant extends Character {
    int amountOfLand; // количество земли
    int initiative = 0;
    public String type = "Крестьянин";

    public Peasant(String name, Coordinates coordinates)
    {
        this.name = name;
        this.coordinates = coordinates;
    }

    public String toString()
    {
        return "Крестьянин "+name+". Координаты: " + coordinates + ". HP: " + hp;
    }
}

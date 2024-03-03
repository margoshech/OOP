package People;

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

    public String toString()
    {
        return "Разбойник "+name+". Координаты: " + coordinates;
    }
}

package People;

import Value.Coordinates;

// маг
public class Magician extends Character
{
    int mana = 100;

    public Magician(String name, Coordinates coordinates)
    {
        this.name = name;
        this.coordinates = coordinates;
    }

    public String toString()
    {
        return "Маг "+name+". Координаты: " + coordinates;
    }
}

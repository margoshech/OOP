package People;

import java.util.ArrayList;

import Value.Coordinates;

//арбалетчик
public class Crossbowman extends Character{
    int crossbow = 1; //абралеты
    int initiative = 3;

    public Crossbowman(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    public String toString()
    {
        return "Арбалетчик "+ name +". Координаты: " + coordinates;
    }
}

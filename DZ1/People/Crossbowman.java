package People;

import Value.Coordinates;

//арбалетчик
public class Crossbowman extends Character{
    int crossbow = 1; //абралеты

    public Crossbowman(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    public String toString()
    {
        return "Арбалетчик "+ name +". Координаты: " + coordinates;
    }
}

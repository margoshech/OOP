package People;

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

    public String toString()
    {
        return "Монах "+name+". Координаты: " + coordinates + ". HP: " + hp;
    }
}

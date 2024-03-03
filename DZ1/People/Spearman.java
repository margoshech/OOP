package People;

import Value.Coordinates;

// копейщик
public class Spearman extends Character {
    int spearCount = 1; // количество копьев
    int initiative = 2;

    public Spearman(String name, Coordinates coordinates)
    {
        this.name = name;
        this.coordinates = coordinates;
    }

    public String toString()
    {
        return "Копейщик "+name+". Координаты: " + coordinates;
    }
}

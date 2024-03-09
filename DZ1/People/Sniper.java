package People;

import Value.Coordinates;

//снайпер
public class Sniper extends Character {
    int arrows = 100; // стрелы
    int initiative = 3;

    public Sniper(String name, Coordinates coordinates)
    {
        this.name = name;
        this.coordinates = coordinates;
    }

    @Override
    public String getType() {
        return "Снайпер";
    }

    public String toString()
    {
        return "Снайпер "+name+". Координаты: " + coordinates + ". HP: " + hp + " Стрел: " + arrows;
    }

    @Override
    public void attack(Character enemy)
    {
        if (arrows < 0) {
            System.out.println("У " + name + " не хватает стрел");
            return;
        }

        arrows -= 1;
        enemy.hp -= damage;
        System.out.println("Снайпер " + name + " атаковал " + enemy.name + " на " + damage + " урон");
    }

    @Override
    public void step()
    {
        if (hp > 0) {
            if (arrows > 0) {
                Character enemy = getClosestEnemy();
                attack(enemy);
            } else {
                System.out.println("Стрелы отсутствуют");
            }
        } else {
            System.out.println("Мёртв");
        }
    }
}

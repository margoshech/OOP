package People;

import java.util.ArrayList;

import Value.Coordinates;

//снайпер
public class Sniper extends Character {
    int bullets; //пули

    public Sniper(String name, Coordinates coordinates)
    {
        this.name = name;
        this.coordinates = coordinates;
    }

    public String toString()
    {
        return "Снайпер "+name+". Координаты: " + coordinates;
    }

    public Character getClosetEnemy(ArrayList<Character> enemies)
    {
          Character closestEnemy = enemies.get(0);

          for (int i = 0; i < enemies.size(); i++) {
               if (enemies.get(i) == this) {
                   continue;
               }

               Coordinates enemyCoordinates = enemies.get(i).coordinates;
               double currentDistance = coordinates.getDistance(enemyCoordinates);
               double closestDistance = coordinates.getDistance(closestEnemy.coordinates);

               if (closestDistance > currentDistance) {
                    closestEnemy = enemies.get(i);
               }
          }
          return closestEnemy;
   }
}

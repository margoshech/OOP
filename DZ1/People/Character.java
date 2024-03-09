package People;

import java.util.ArrayList;

import Action.Step;
import Value.Coordinates;

abstract public class Character implements Step {
    public int id;
    public String name;
    public String lastname;
    public int hp = 100;
    public int damage = 1;
    public int level = 1;
    public double money;
    public int initiative;
    public ArrayList<Character> enemies;
    public String type;
    
    public Coordinates coordinates;

    public void setEnemies(ArrayList<Character> enemies)
    {
        this.enemies = enemies;
    }

    public boolean isDead()
    {
        return hp <= 0;
    }

    public void attack(Character enemy)
    {
        if (isDead()) {
            return;
        }

        System.out.println(name + " атакует " + enemy.name + " на " + damage + " урона");
        enemy.hp -= damage;
    }

    public void step()
    {
        if (isDead()) {
            return;
        }
    }

    public void go(Coordinates coordinates)
    {
        if (isDead()) {
            return;
        }

        this.coordinates = coordinates;
        System.out.println(name + " переместился на позицию x:" + coordinates.x + " y: " + coordinates.y + ". Ближайший для него враг: " + getClosestEnemy());
    }

    public void treatment()
    {
        if (isDead()) {
            return;
        }

        System.out.println("treatment"); //лечение
    }

    public Coordinates getCoords()
    {
        return coordinates;
    }

    public String getInfo()
    {
        return type + " ("+ name +")";
    }

    public Character getClosestEnemy()
    {
          Character closestEnemy = enemies.get(0);
          for (Character enemy: enemies) {
            if (enemy != this && !enemy.isDead()) {
                closestEnemy = enemy;
                break;
            }
          }

          for (int i = 0; i < enemies.size(); i++) {
               if (enemies.get(i) == this || enemies.get(i).isDead()) {
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

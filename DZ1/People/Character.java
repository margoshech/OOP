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
    public boolean isBuf = false;
    public ArrayList<Character> enemies = new ArrayList<>();
    public ArrayList<Character> friends = new ArrayList<>();
    
    public Coordinates coordinates;

    public void setEnemies(ArrayList<Character> enemies)
    {
        this.enemies = enemies;
    }

    public void setFriends(ArrayList<Character> friends)
    {
        this.friends = friends;
    }

    public void addFriend(Character friend)
    {
        this.friends.add(friend);
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

        int additionalDamage = 0;
        if (isBuf) {
            additionalDamage += 1;
        }

        System.out.println(name + " атакует " + enemy.name + " на " + (damage + additionalDamage) + " урона");
        enemy.hp -= damage + additionalDamage;
        isBuf = false;
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

    public Coordinates getCoords()
    {
        return coordinates;
    }

    public abstract String getType();

    public String getInfo()
    {
        return getType() + " ("+ name +")";
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

   public Character getClosestFried()
   {
        Character closestFried = friends.get(0);
        for (Character friend: friends) {
        if (friend != this && !friend.isDead() && friend.getType() != this.getType()) {
            closestFried = friend;
            break;
        }
        }

        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i) == this || friends.get(i).isDead() || this.getType() == friends.get(i).getType()) {
                continue;
            }

            Coordinates friendCoordinates = friends.get(i).coordinates;
            double currentDistance = coordinates.getDistance(friendCoordinates);
            double closestDistance = coordinates.getDistance(closestFried.coordinates);

            if (closestDistance > currentDistance) {
                closestFried = friends.get(i);
            }
        }
        return closestFried;
   }

   public Character getClosestFriedByType(String type)
    {
        Character closestFriend = null;
        for (Character friend: friends) {
            if (this != friend && !friend.isDead() && friend.getType() == type) {
                closestFriend = friend;
                break;
            }
        }

        if (null == closestFriend) {
            return null;
        }

        for (Character friend: friends) {
            if (this == friend || friend.isDead() || friend.getType() != type) {
                continue;
            }

            Coordinates friendCoordinates = friend.coordinates;
            double currentDistance = coordinates.getDistance(friendCoordinates);
            double closestDistance = coordinates.getDistance(closestFriend.coordinates);

            if (closestDistance > currentDistance) {
                closestFriend = friend;
           }
        }

        return closestFriend;
    }
}

package Action;

import People.Character;
import Value.Coordinates;

public class GoTo {
    public static Double goToClosestEnemy(Character currentCharacter)
    {
        Coordinates coordinates = currentCharacter.coordinates;
        Character enemy = currentCharacter.getClosestEnemy();
        Coordinates enemyCoordinates = enemy.coordinates;
        Double distance = currentCharacter.coordinates.getDistance(enemyCoordinates);

        if (distance == 1) {
            // currentCharacter.attack(enemy);
            return 1.0;
        } else {
            int targetX = enemyCoordinates.x;
            int targetY = enemyCoordinates.y;

            if (coordinates.x < targetX) {
                coordinates.x++;
            } else if (coordinates.x > targetX) {
                coordinates.x--;
            }

            if (coordinates.y < targetY) {
                coordinates.y++;
            } else if (coordinates.y > targetY) {
                coordinates.y--;
            }
        }

        return distance;
    }

    public static Double goToClosestFriend(Character currentCharacter, String type)
    {
        Coordinates coordinates = currentCharacter.coordinates;
        Character friend = currentCharacter.getClosestFriedByType(type);

        if (null == friend) {
            return -1.0; // нет друга с таким типом
        }

        Coordinates friendCoordinates = friend.coordinates;
        Double distance = currentCharacter.coordinates.getDistance(friendCoordinates);

        if (distance == 1) {
            return distance;
        }

        int targetX = friendCoordinates.x;
        int targetY = friendCoordinates.y;

        if (coordinates.x < targetX) {
            coordinates.x++;
        } else if (coordinates.x > targetX) {
            coordinates.x--;
        }

        if (coordinates.y < targetY) {
            coordinates.y++;
        } else if (coordinates.y > targetY) {
            coordinates.y--;
        }


        return 1.0;
    }
}

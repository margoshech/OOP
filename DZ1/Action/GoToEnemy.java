package Action;

import People.Character;
import Value.Coordinates;

public class GoToEnemy {
    public static void goToClosestEnemy(Character currentCharacter)
    {
        Coordinates coordinates = currentCharacter.coordinates;
        Character enemy = currentCharacter.getClosestEnemy();
        Coordinates enemyCoordinates = enemy.coordinates;

        if (Math.abs(coordinates.x - enemyCoordinates.x) <= 1 && Math.abs(coordinates.y - enemyCoordinates.y) <= 1) {
            currentCharacter.attack(enemy);
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
            /*if (Math.abs(coordinates.x - enemyCoordinates.x) < Math.abs(coordinates.y - enemyCoordinates.y)) {
                int targetX = coordinates.x - enemyCoordinates.x < 0 ? coordinates.x + 1 : coordinates.x - 1;
                Coordinates targetWay = new Coordinates(targetX, coordinates.y);

                currentCharacter.go(targetWay);
            } else {
                int targetY = coordinates.y - enemyCoordinates.y < 0 ? coordinates.y + 1 : coordinates.y - 1;
                Coordinates targetWay = new Coordinates(coordinates.x, targetY);

                currentCharacter.go(targetWay);
            }*/
        }
    }
}

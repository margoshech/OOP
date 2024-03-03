package Team;

import java.util.ArrayList;

import People.Character;
import People.Crossbowman;
import People.Magician;
import People.Monk;
import People.Peasant;
import People.Robber;
import People.Sniper;
import People.Spearman;
import Value.Coordinates;

public class TeamCreator
{
    public static void fillTeams(ArrayList<Character> team1, ArrayList<Character> team2)
    {
        team1.add(new Magician("Vasya1", new Coordinates(1, 0)));
        team1.add(new Crossbowman("Vasya2", new Coordinates(4, 9)));
        team1.add(new Monk("Vasya3", new Coordinates(3, 0)));
        team1.add(new Monk("Monk 1", new Coordinates(4, 0)));
        team1.add(new Peasant("Vasya4", new Coordinates(7, 9)));
        team1.add(new Robber("Vasya5", new Coordinates(2, 0)));
        team1.add(new Robber("Robber1", new Coordinates(2, 0)));
        team1.add(new Sniper("Vasya6", new Coordinates(7, 9)));
        team1.add(new Spearman("Vasya7", new Coordinates(2, 0)));
        team1.add(new Spearman("Spearman 1", new Coordinates(3, 0)));
        team1.add(new Spearman("Spearman 2", new Coordinates(4, 0)));

        team2.add(new Magician("Mag 1", new Coordinates(1, 1)));
        team2.add(new Magician("Mag 2", new Coordinates(1, 2)));
        team2.add(new Magician("Mag 3", new Coordinates(1, 3)));
        team2.add(new Monk("Vasya3", new Coordinates(3, 4)));
        team2.add(new Monk("Monk 1", new Coordinates(4, 2)));
        team2.add(new Peasant("Vasya4", new Coordinates(0, 10)));
        team2.add(new Robber("Vasya5", new Coordinates(1, 4)));
        team2.add(new Robber("Robber1", new Coordinates(2, 11)));
        team2.add(new Sniper("Sniper 1", new Coordinates(1, 1)));
        team2.add(new Sniper("Sniper 2", new Coordinates(7, 5)));
        team2.add(new Spearman("Vasya7", new Coordinates(2, 4)));

        setEnemies(team1, team2);
        setEnemies(team2, team1);
    }

    public static void setEnemies(ArrayList<Character> team, ArrayList<Character> enemies)
    {
        for (int i = 0; i < team.size(); i++) {
            team.get(i).setEnemies(enemies);
        }
    }
}

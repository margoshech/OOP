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
        team1.add(new Magician("Mag1Team1", new Coordinates(1, 0)));
        team1.add(new Crossbowman("Cross1Team1", new Coordinates(4, 9)));
        team1.add(new Monk("Monk1Team1", new Coordinates(3, 0)));
        team1.add(new Monk("Monk2Team1", new Coordinates(4, 0)));
        team1.add(new Peasant("Peasant1Team1", new Coordinates(7, 9)));
        team1.add(new Robber("Robber1Team1", new Coordinates(15, 0)));
        team1.add(new Robber("Robber2Team1", new Coordinates(4, 15)));
        team1.add(new Sniper("Sniper1Team1", new Coordinates(7, 9)));
        team1.add(new Spearman("Spearman1Team1", new Coordinates(2, 0)));
        team1.add(new Spearman("Spearman2Team1", new Coordinates(3, 0)));
        team1.add(new Spearman("Spearman3Team1", new Coordinates(4, 0)));

        team2.add(new Magician("Mag1Team2", new Coordinates(1, 1)));
        team2.add(new Magician("Mag2Team2", new Coordinates(1, 2)));
        team2.add(new Magician("Mag3Team2", new Coordinates(1, 3)));
        team2.add(new Monk("Monk1Team2", new Coordinates(3, 4)));
        team2.add(new Monk("Monk2Team2", new Coordinates(4, 2)));
        team2.add(new Peasant("Peasan1Team2", new Coordinates(0, 10)));
        team2.add(new Robber("Robber1Team2", new Coordinates(5, 11)));
        team2.add(new Robber("Robber2Team2", new Coordinates(11, 11)));
        team2.add(new Sniper("Sniper1Team2", new Coordinates(1, 1)));
        team2.add(new Sniper("Sniper2Team2", new Coordinates(7, 5)));
        team2.add(new Spearman("Spearma1Team2", new Coordinates(2, 4)));

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

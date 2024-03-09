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
        team1.add(new Magician("Mag1Team1", new Coordinates(1, 1)));
        team1.add(new Crossbowman("Cross1Team1", new Coordinates(2, 1)));
        team1.add(new Monk("Monk1Team1", new Coordinates(3, 1)));
        team1.add(new Monk("Monk2Team1", new Coordinates(4, 1)));
        team1.add(new Peasant("Peasant1Team1", new Coordinates(5, 1)));
        team1.add(new Robber("Robber1Team1", new Coordinates(6, 1)));
        team1.add(new Robber("Robber2Team1", new Coordinates(7, 1)));
        team1.add(new Sniper("Sniper1Team1", new Coordinates(8, 1)));
        team1.add(new Spearman("Spearman1Team1", new Coordinates(9, 1)));
        team1.add(new Spearman("Spearman2Team1", new Coordinates(10, 1)));

        team2.add(new Magician("Mag1Team2", new Coordinates(1, 10)));
        team2.add(new Magician("Mag2Team2", new Coordinates(2, 10)));
        team2.add(new Magician("Mag3Team2", new Coordinates(3, 10)));
        team2.add(new Monk("Monk1Team2", new Coordinates(4, 10)));
        team2.add(new Monk("Monk2Team2", new Coordinates(5, 10)));
        team2.add(new Peasant("Peasan1Team2", new Coordinates(6, 10)));
        team2.add(new Robber("Robber1Team2", new Coordinates(7, 10)));
        team2.add(new Robber("Robber2Team2", new Coordinates(8, 10)));
        team2.add(new Sniper("Sniper1Team2", new Coordinates(9, 10)));
        team2.add(new Sniper("Sniper2Team2", new Coordinates(10, 10)));

        setEnemies(team1, team2);
        setFriends(team1, team1);
        setEnemies(team2, team1);
        setFriends(team2, team2);
    }

    public static void setEnemies(ArrayList<Character> team, ArrayList<Character> enemies)
    {
        for (int i = 0; i < team.size(); i++) {
            team.get(i).setEnemies(enemies);
        }
    }

    public static void setFriends(ArrayList<Character> team, ArrayList<Character> friends)
    {
        for (int i = 0; i < team.size(); i++) {
            for (Character friend: friends) {
                if (friend == team.get(i)) {
                    continue;
                }

                team.get(i).addFriend(friend);
            }
        }
    }
}

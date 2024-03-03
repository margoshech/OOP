import java.util.ArrayList;
import java.util.Comparator;

import People.*;
import People.Character;
import Team.TeamCreator;
import Value.Coordinates;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<Character> team1 = new ArrayList<>();
        ArrayList<Character> team2 = new ArrayList<>();
        TeamCreator.fillTeams(team1, team2);

        ArrayList<Character> all = new ArrayList<>();
        all.addAll(team1);
        all.addAll(team2);

        all.sort(new Comparator<Character>() {
            public int compare(Character o1, Character o2) {
                return o1.initiative - o1.initiative;
            }
        });

        for (int j = 0; j < 100; j++) {
            for (int i = 0; i < all.size(); i++) {
                Character currentCharacter = all.get(i);
                System.out.println(currentCharacter);
                currentCharacter.step();
            }
        }
    }
}
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import People.Character;
import Team.TeamCreator;

public class Main
{
    static ArrayList<Character> holyTeam = new ArrayList<>();
    static ArrayList<Character> darkTeam = new ArrayList<>();
    static ArrayList<Character> allTeam = new ArrayList<>();
    
    public static void main(String[] args)
    {
        TeamCreator.fillTeams(holyTeam, darkTeam);
        allTeam.addAll(holyTeam);
        allTeam.addAll(darkTeam);

        allTeam.sort(new Comparator<Character>() {
            public int compare(Character o1, Character o2) {
                return o1.initiative - o1.initiative;
            }
        });

        Scanner input = new Scanner(System.in);
        while (true) {
            View.view();
            input.nextLine();
            boolean isHolyDead = false;
            boolean isDarkDead = false;

            for (Character character: allTeam) {
                character.step();

                Integer deadCount = 0;
                for (Character holyCharacter: holyTeam) {
                    if (holyCharacter.isDead()) {
                        deadCount++;
                    }
                }
                if (deadCount == holyTeam.size()) {
                    isHolyDead = true;
                    break;
                }

                deadCount = 0;
                for (Character darkCharacter: darkTeam) {
                    if (darkCharacter.isDead()) {
                        deadCount++;
                    }
                }
                if (deadCount == darkTeam.size()) {
                    isDarkDead = true;
                    break;
                }
            }

            if (isHolyDead || isDarkDead) {
                if (isHolyDead) {
                    System.out.println("Команда holy победила");
                } else {
                    System.out.println("Команда dark победила");
                }
                break;
            }
        }
    }
}
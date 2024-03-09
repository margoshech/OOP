package People;

import Value.Coordinates;

// маг
public class Magician extends Character
{
    int mana = 10;
    int initiative = 1;

    public Magician(String name, Coordinates coordinates)
    {
        this.name = name;
        this.coordinates = coordinates;
    }

    public String toString()
    {
        return "Маг "+name+". Координаты: " + coordinates + ". HP: " + hp;
    }

    @Override
    public String getType() {
        return "Маг";
    }

    @Override
    public void step()
    {
        if (isDead()) {
            return;
        }

        Integer deadCount = 0;
        for (Character friend: friends) {
            if (isDead()) {
                deadCount++;
            }
        }

        if (10 >= mana && deadCount >= 3) { // восстановление
            friendRise();
        } else {
            if (mana >= 2) {
                treatment();
            } else {
                mana++;
            }
        }
    }

    public void friendRise()
    {
        if (isDead()) {
            return;
        }

        for (Character friend: friends) {
            if (isDead()) {
                friend.hp = 50; // восстановили с половиной хп
                mana = 0;

                System.out.println("Маг" + name + " восстановил " + friend.name + " c 50 хп");

                break;
            }
        }
    }

    public void treatment()
    {
        if (isDead()) {
            return;
        }

        Character friendWithMinHp = friends.get(0);
        for (Character friend: friends) {
            if (friend.isDead()) {
                continue;
            }
            friendWithMinHp = friend;
            break;
        }

        for (Character friend: friends) {
            if (friend.isDead()) {
                continue;
            }
            
            if (friend.hp < friendWithMinHp.hp) {
                friendWithMinHp = friend;
            }
        }

        friendWithMinHp.hp++; // прибаляем хп на 1
        mana -= 2;

        System.out.println("Маг" + name + " вылечил " + friendWithMinHp.name + " на +1 хп");
    }
}

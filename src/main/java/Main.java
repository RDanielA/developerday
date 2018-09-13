import life.Friend;
import life.Human;
import life.states.FriendState;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();

        Human human1 = new Human("Даниил");
        Human human2 = new Human("Заур");
        Human human3 = new Human("Дима");

        human1.addFriend(human2, FriendState.DEVELOPER);
        human1.addFriend(human3, FriendState.DEVELOPER);

        List<Friend> friends = human1.getAllFriends();

        while (true) {
            if (gregorianCalendar.get(Calendar.DAY_OF_YEAR) == 256) {
                for (Friend friend : friends) {
                    switch (friend.getState()) {
                        case DEVELOPER: {
                            human1.congratulate(friend, "поздравляю с днём программиста!");

                            human1.drinkBeer();
                            friend.drinkBeer();
                        }
                        break;
                        case NORMAL: {
                            System.out.println(String.format("%s %s", friend.getName(), "не твой день, пей лучше чай!!!"));
                        }
                        break;
                    }
                }
                try {
                    TimeUnit.HOURS.sleep(6);
                } catch (InterruptedException e) {
                    System.out.println("Ну может ещё по бокалу...");
                }
                break;
            }

            try {
                TimeUnit.SECONDS.sleep(10);

                System.out.println("Ну когда там уже наш праздник?");
            } catch (InterruptedException e) {
                System.out.println("Не надо так...");

                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

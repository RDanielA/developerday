package life;

import life.states.FriendState;

import java.util.LinkedList;
import java.util.List;

public class Human {
    private List<Friend> friends;
    private String name;

    public Human(String name) {
        this.name = name;
        this.friends = new LinkedList<Friend>();
    }

    public void congratulate(Human human, String text) {
        System.out.println(String.format("%s %s", human.getName(), text));
    }

    public void addFriend(Human human, FriendState state) {
        Friend friend = new Friend(state, human);

        friends.add(friend);
    }

    public List<Friend> getAllFriends() {
        return friends;
    }

    public void drinkBeer() {
        System.out.println(String.format("%s %s", getName(), "пьёт пиво"));
    }

    public String getName() {
        return name;
    }
}

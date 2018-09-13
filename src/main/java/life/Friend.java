package life;

import life.states.FriendState;

public class Friend extends Human {
    private FriendState state = FriendState.NORMAL;

    public Friend(FriendState state, Human human) {
        super(human.getName());
        this.state = state;
    }

    public void changeState(FriendState state) {
        this.state = state;
    }

    public FriendState getState() {
        return state;
    }
}

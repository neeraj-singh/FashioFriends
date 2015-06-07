package styleroom.com.styleroom.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by neeraj.singh on 25/04/15.
 */
public class Room  implements Serializable{
    String name;
    List<User> users;
    State state;

    public Room(String name, List<User> users, State state) {
        this.name = name;
        this.users = users;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}

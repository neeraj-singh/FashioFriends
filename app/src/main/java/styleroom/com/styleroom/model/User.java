package styleroom.com.styleroom.model;

import java.io.Serializable;

/**
 * Created by neeraj.singh on 25/04/15.
 */
public class User implements Serializable {
    String name;
    boolean isOnline;

    public User(String name, boolean isOnline) {
        this.name = name;
        this.isOnline = isOnline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setIsOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }
}

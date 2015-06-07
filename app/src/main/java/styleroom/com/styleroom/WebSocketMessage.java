package styleroom.com.styleroom;

import java.io.Serializable;

import styleroom.com.styleroom.model.State;

/**
 * Created by neeraj.singh on 26/04/15.
 */
public class WebSocketMessage implements Serializable{
    String type;
    String message;
    State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

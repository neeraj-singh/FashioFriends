package styleroom.com.styleroom;

import com.google.gson.Gson;

/**
 * Created by neeraj.singh on 26/04/15.
 */
public class GsonRequestWrapper {
    private static Gson gson ;

    public static Gson getInstance() {
        if(gson!=null){
            return gson;
        }else{
            gson = new Gson();
            return gson;
        }
    }
}

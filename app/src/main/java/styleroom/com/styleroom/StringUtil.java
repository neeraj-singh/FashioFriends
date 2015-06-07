package styleroom.com.styleroom;

/**
 * Created by neeraj.singh on 26/04/15.
 */
public class StringUtil {
    public static boolean isNullOrEmpty(String str){
        return str==null || str.equalsIgnoreCase("") || str.length()==0;
    }

    public static int getImageId(String ima){
        if(ima.equalsIgnoreCase("fkimage1"))
            return R.drawable.fkimage1;
        if(ima.equalsIgnoreCase("fkimage2"))
            return R.drawable.fkimage2;
        if(ima.equalsIgnoreCase("fkimage3"))
            return R.drawable.fkimage3;
        if(ima.equalsIgnoreCase("fkimage4"))
            return R.drawable.fkimage4;
        if(ima.equalsIgnoreCase("fkimage5"))
            return R.drawable.fkimage5;
        if(ima.equalsIgnoreCase("fkimage6"))
            return R.drawable.fkimage6;
        if(ima.equalsIgnoreCase("fkimage7"))
            return R.drawable.fkimage7;
        if(ima.equalsIgnoreCase("fkimage8"))
            return R.drawable.fkimage8;
        if(ima.equalsIgnoreCase("fkimage9"))
            return R.drawable.fkimage9;
        if(ima.equalsIgnoreCase("fkimage10"))
            return R.drawable.fkimage10;
        if(ima.equalsIgnoreCase("fkimage11"))
            return R.drawable.fkimage11;
        if(ima.equalsIgnoreCase("fkimage12"))
            return R.drawable.fkimage12;
        if(ima.equalsIgnoreCase("fkimage13"))
            return R.drawable.fkimage13;
        if(ima.equalsIgnoreCase("fkimage14"))
            return R.drawable.fkimage14;
        if(ima.equalsIgnoreCase("fkimage15"))
            return R.drawable.fkimage15;
        if(ima.equalsIgnoreCase("fkimage16"))
            return R.drawable.fkimage16;


        if(ima.equalsIgnoreCase("mnimage1"))
            return R.drawable.mnimage1;
        if(ima.equalsIgnoreCase("mnimage2"))
            return R.drawable.mnimage12;
        if(ima.equalsIgnoreCase("mnimage3"))
            return R.drawable.mnimage3;
        if(ima.equalsIgnoreCase("mnimage4"))
            return R.drawable.mnimage4;
        if(ima.equalsIgnoreCase("mnimage5"))
            return R.drawable.mnimage5;
        if(ima.equalsIgnoreCase("mnimage6"))
            return R.drawable.mnimage6;
        if(ima.equalsIgnoreCase("mnimage7"))
            return R.drawable.mnimage7;
        if(ima.equalsIgnoreCase("mnimage8"))
            return R.drawable.mnimage8;
        if(ima.equalsIgnoreCase("mnimage9"))
            return R.drawable.mnimage9;
        if(ima.equalsIgnoreCase("mnimage10"))
            return R.drawable.mnimage10;
        if(ima.equalsIgnoreCase("mnimage11"))
            return R.drawable.mnimage11;
        if(ima.equalsIgnoreCase("mnimage12"))
            return R.drawable.mnimage12;
        if(ima.equalsIgnoreCase("fkimage13"))
            return R.drawable.mnimage13;
        if(ima.equalsIgnoreCase("mnimage14"))
            return R.drawable.mnimage14;
        if(ima.equalsIgnoreCase("mnimage15"))
            return R.drawable.mnimage15;
        if(ima.equalsIgnoreCase("mnimage16"))
            return R.drawable.mnimage16;
        return R.drawable.fkimage1;
    }
}

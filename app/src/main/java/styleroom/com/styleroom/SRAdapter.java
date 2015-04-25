package styleroom.com.styleroom;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.ContentHandlerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by neeraj.singh on 25/04/15.
 */
public class SRAdapter extends BaseAdapter {

    ArrayList<ScreenState> objectList;
    FragmentChangeListner listener;
    Context mContext;

    public SRAdapter(Context context,List<ScreenState> objects,FragmentChangeListner listener)
    {
        this.objectList = (ArrayList<ScreenState>)objects;
        this.listener = listener;
        this.mContext = context;
    }
    @Override
    public int getCount() {
        return objectList.size();
    }

    @Override
    public Object getItem(int position) {
        return objectList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View retval = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewitem, null);
        TextView site = (TextView) retval.findViewById(R.id.site);
        TextView from = (TextView) retval.findViewById(R.id.from);
        ImageView image = (ImageView) retval.findViewById(R.id.image);
        from.setText(objectList.get(position).getFrom());
        site.setText(objectList.get(position).getSite());
        Drawable draw = null;
        switch (objectList.get(position).getImageNumber()){
            case 0:
                draw = mContext.getDrawable(R.drawable.fkimage1);
                break;
            case 1:
                draw = mContext.getDrawable(R.drawable.fkimage2);
                break;
            case 2:
                draw = mContext.getDrawable(R.drawable.fkimage3);
                break;
            case 3:
                draw = mContext.getDrawable(R.drawable.fkimage4);
                break;
            default:
                draw = mContext.getDrawable(R.drawable.fkimage5);
        }
        image.setImageDrawable(draw);
        return retval;
    }
}

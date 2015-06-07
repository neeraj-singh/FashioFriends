package styleroom.com.styleroom;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import styleroom.com.styleroom.model.Product;
import styleroom.com.styleroom.model.ScreenState;

/**
 * Created by neeraj.singh on 25/04/15.
 */
public class SRAdapter extends BaseAdapter {

    ArrayList<Product> objectList;
    FragmentChangeListner listener;
    Context mContext;

    public SRAdapter(Context context,List<Product> objects,FragmentChangeListner listener)
    {
        this.objectList = (ArrayList<Product>)objects;
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
        from.setText(objectList.get(position).getSuggestedBy().getName());
        site.setText(objectList.get(position).getProvider());
        Drawable draw = null;
        draw = mContext.getResources().getDrawable(StringUtil.getImageId(objectList.get(position).getImageId()));
        image.setImageDrawable(draw);
        return retval;
    }
}

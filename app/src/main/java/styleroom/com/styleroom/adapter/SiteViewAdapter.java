package styleroom.com.styleroom.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import styleroom.com.styleroom.Constants.Constants;
import styleroom.com.styleroom.GsonRequestWrapper;
import styleroom.com.styleroom.MainActivity;
import styleroom.com.styleroom.R;
import styleroom.com.styleroom.SiteActivity;
import styleroom.com.styleroom.StringUtil;
import styleroom.com.styleroom.model.Product;

/**
 * Created by neeraj.singh on 25/04/15.
 */
public class SiteViewAdapter extends BaseAdapter {

    List<Product> products = new ArrayList<Product>();
//     btnAsk;
    Context mContext;
    public SiteViewAdapter(Context context, List<Product> list){
        this.mContext = context;
        this.products = list;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View retval = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_layout, null);
        ImageView image = (ImageView)retval.findViewById(R.id.image);
        image.setImageDrawable(mContext.getResources().getDrawable(StringUtil.getImageId(products.get(position).getImageId())));


        Button btnDetail = (Button)retval.findViewById(R.id.btnDetails);
        final Button btnAsk = (Button)retval.findViewById(R.id.btnShare);
        btnAsk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent parent = ((SiteActivity) mContext).getIntent();
                if(parent.getExtras()!=null && parent.getExtras().containsKey("backcall")){
                        Intent newIntent = new Intent();
                        products.get(position).setSuggestedBy(Constants.user);
                        Constants.state.getProducts().add(products.get(position));
                        Constants.state.setActiveProduct(products.get(position));
                        newIntent.putExtra("SelectedItem", (Serializable) (Constants.state));
                        ((SiteActivity)mContext).setResult(Activity.RESULT_OK, newIntent);
                        ((Activity)mContext).finish();
                }else {
                    Intent intent = new Intent(mContext, MainActivity.class);
                    products.get(position).setSuggestedBy(Constants.user);
                    Constants.state.getProducts().add(products.get(position));
                    Constants.state.setActiveProduct(products.get(position));
                    intent.putExtra("SelectedItem", (Serializable) (Constants.state));
                    mContext.startActivity(intent);
                }
//                mContext.finish();
//                ((Activity)mContext).finish();
            }
        });

        image.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                btnAsk.performClick();
                return false;
            }
        });
        return retval;
    }
}

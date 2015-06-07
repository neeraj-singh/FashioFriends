package styleroom.com.styleroom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.List;

import styleroom.com.styleroom.Constants.Constants;
import styleroom.com.styleroom.adapter.SiteViewAdapter;
import styleroom.com.styleroom.model.Product;

/**
 * Created by neeraj.singh on 25/04/15.
 */
public class SiteActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(Constants.appType);
        if(Constants.appType.equalsIgnoreCase("myntra")){
            getActionBar().setIcon(R.drawable.myntra);
        }else if(Constants.appType.equalsIgnoreCase("flipkart")) {
            getActionBar().setIcon(R.drawable.flipkart);
        }
        if (Constants.flag ) {
            Constants.instance.init();
            Constants.flag = false;
        }
        List<Product> productList = Constants.productMap.get(Constants.appType);

        if(Constants.appType.equalsIgnoreCase("Flipkart"))
            setContentView(R.layout.flipkart);

        if(Constants.appType.equalsIgnoreCase("Myntra"))
            setContentView(R.layout.myntra);

        SiteViewAdapter adapter = new SiteViewAdapter(this,productList);
        GridView view = (GridView)findViewById(R.id.gridview);
        view.setAdapter(adapter);
    }
}

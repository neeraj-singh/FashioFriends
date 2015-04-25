package styleroom.com.styleroom;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0;i<10;i++){
            ScreenState sr = new ScreenState();
            int cas = i%4;
            switch (cas){
                case 0 :
                    sr.setFrom("Neeraj");
                    sr.setSite("Fliplart");
                    sr.setImageNumber(i % 5);
                    sr.setProductinfo(new Product());
                    break;
                case 1:
                    sr.setFrom("Nikhil");
                    sr.setSite("Parcell");
                    sr.setImageNumber(i % 5);
                    sr.setProductinfo(new Product());
                    break;
                case 2:
                    sr.setFrom("Shivam");
                    sr.setSite("Vizury");
                    sr.setImageNumber(i % 5);
                    sr.setProductinfo(new Product());
                    break;
                case 3:
                    sr.setFrom("Anurag");
                    sr.setSite("MarketShare");
                    sr.setImageNumber(i % 5);
                    sr.setProductinfo(new Product());
                    break;
            }
            objectList.add(sr);

        }

        FragmentManager fm = getFragmentManager();
        final MainActivityFragment fragment = MainActivityFragment.getInstance(objectList.get(0));

        HorizontialListView listView = (HorizontialListView)findViewById(R.id.suggestionView);
        SRAdapter adapter = new SRAdapter(this,objectList,fragment);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                fragment.updateFragment(objectList.get(position));
            }
        });

        listView.setAdapter(adapter);

        fm.beginTransaction().replace(R.id.fragment,fragment).commit();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    List<ScreenState> objectList = new ArrayList<ScreenState>();



}

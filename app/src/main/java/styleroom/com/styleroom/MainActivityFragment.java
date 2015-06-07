package styleroom.com.styleroom;

import android.app.Dialog;
import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;

import styleroom.com.styleroom.Constants.Constants;
import styleroom.com.styleroom.model.Product;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements FragmentChangeListner  {

    private TextView from;
    private TextView site;
    private ImageView image;
    private Button btnLike;
    private Button btnChat;
    private Button btnBuy;
    private Product product;

    public static MainActivityFragment getInstance(Product product){
        MainActivityFragment frag = new MainActivityFragment();
        Bundle bnd = new Bundle();
        bnd.putSerializable("product", (Serializable) product);
        frag.setArguments(bnd);
        return frag;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        product = (Product)(getArguments().getSerializable("product"));
        from = (TextView)view.findViewById(R.id.from);
        site = (TextView)view.findViewById(R.id.site);
        image = (ImageView)view.findViewById(R.id.image);
        btnChat = (Button)view.findViewById(R.id.btnDislike);
        btnBuy = (Button)view.findViewById(R.id.btnBuy);
        btnLike = (Button)view.findViewById(R.id.btnLike);

        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int likes = product.getLikes();
                product.setLikes(likes + 1);
//                btnLike.setText("Like "+product.getLikes());
                WebSocketMessage msg = new WebSocketMessage();
                msg.setType("update");
                msg.setMessage("");
                Constants.state.setActiveProduct(product);
                msg.setState(Constants.state);
                String sendmsg = GsonRequestWrapper.getInstance().toJson(msg);
                ((MainActivity)getActivity()).sendMessage(sendmsg);
//                notify();
            }
        });
//
        btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).openchat();
            }
        });

//        WebSocketClass.connectToChat();

        buildview(product);
        return view;
    }

    private void buildview(final Product product) {
//        View view = getView();
        this.product = product;
        System.out.println("coming to update state");
        from.setText(product.getProvider() + "");
        site.setText(product.getSuggestedBy().getName() + "");
        Drawable draw = getActivity().getResources().getDrawable(StringUtil.getImageId(product.getImageId()));
        image.setImageDrawable(draw);
        btnLike.setText("Like " + product.getLikes());
//

    }

    @Override
    public void updateFragment(Product state) {
        buildview(state);
    }







}

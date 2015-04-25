package styleroom.com.styleroom;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements FragmentChangeListner  {

    private TextView from;
    private TextView site;
    private ImageView image;
    private Button btnLike;
    private Button btnDislike;
    private Button btnBuy;
    private ScreenState state;

    public static MainActivityFragment getInstance(ScreenState state){
        MainActivityFragment frag = new MainActivityFragment();
        Bundle bnd = new Bundle();
        bnd.putSerializable("ScreenState", (Serializable) state);
        frag.setArguments(bnd);
        return frag;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        state = (ScreenState)(getArguments().getSerializable("ScreenState"));
        from = (TextView)view.findViewById(R.id.from);
        site = (TextView)view.findViewById(R.id.site);
        image = (ImageView)view.findViewById(R.id.image);
        btnDislike = (Button)view.findViewById(R.id.btnDislike);
        btnBuy = (Button)view.findViewById(R.id.btnBuy);
        btnLike = (Button)view.findViewById(R.id.btnLike);

        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int likes = state.getProductinfo().getLikes();
                state.getProductinfo().setLikes(likes + 1);
                btnLike.setText("Like "+likes);
//                notify();
            }
        });

        btnDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int disLikes = state.getProductinfo().getDisLiks();
                state.getProductinfo().setLikes(disLikes + 1);
                btnDislike.setText("Dislike "+disLikes);
//                notify();
            }
        });


        buildview(state);
        return view;
    }

    private void buildview(final ScreenState state) {
//        View view = getView();
        System.out.println("coming to update state");
        from.setText(state.getFrom());
        site.setText(state.getSite());
        Drawable draw = null;
        switch (state.getImageNumber()){
            case 0:
                draw = getActivity().getDrawable(R.drawable.fkimage1);
                break;
            case 1:
                draw = getActivity().getDrawable(R.drawable.fkimage2);
                break;
            case 2:
                draw = getActivity().getDrawable(R.drawable.fkimage3);
                break;
            case 3:
                draw = getActivity().getDrawable(R.drawable.fkimage4);
                break;
            default:
                draw = getActivity().getDrawable(R.drawable.fkimage5);
        }
        image.setImageDrawable(draw);
        btnLike.setText("Like " + state.getProductinfo().getLikes());
        btnDislike.setText("Dislike " + state.getProductinfo().getDisLiks());

    }

    @Override
    public void updateFragment(ScreenState state) {
        buildview(state);
    }

}

package styleroom.com.styleroom;

import android.app.Activity;
import android.app.Dialog;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.w3c.dom.Text;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import styleroom.com.styleroom.Constants.Constants;
import styleroom.com.styleroom.model.Product;
import styleroom.com.styleroom.model.ScreenState;
import styleroom.com.styleroom.model.State;


public class MainActivity extends Activity implements WebSocketInterface{

    List<Product> objectList;
    Product activeProduct;
    State state;
    WebSocketClass webSocket;

    Dialog chatDialog = null;
    TextView chat ;
    Button send ;
    EditText chatBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(Constants.webSocketClass !=null){
            webSocket = Constants.webSocketClass;
        }else{
            webSocket = new WebSocketClass(this);
            Constants.webSocketClass = webSocket;
        }

        Bundle extra = getIntent().getExtras();

        if(extra!=null){
            state = (State)(extra.getSerializable("SelectedItem"));
            activeProduct = state.getActiveProduct();
            objectList = state.getProducts();
            WebSocketMessage msg = new WebSocketMessage();
            msg.setType("update");
            msg.setMessage("");
            msg.setState(Constants.state);
            String sendmsg = GsonRequestWrapper.getInstance().toJson(msg);
            System.out.println("json was ----> "+sendmsg);
            sendMessage(sendmsg);
        }

        showMessage(Constants.messageList);
        updateUi();
        webSocket.connectToChat();

    }

    private void updateUi() {
       try {
           objectList = Constants.state.getProducts();
           activeProduct = Constants.state.getActiveProduct();
           FragmentManager fm = getFragmentManager();
           final MainActivityFragment fragment = MainActivityFragment.getInstance(activeProduct);

           System.out.println(objectList);
           HorizontialListView listView = (HorizontialListView) findViewById(R.id.suggestionView);
           SRAdapter adapter = new SRAdapter(this, objectList, fragment);
           listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
               @Override
               public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                   fragment.updateFragment(objectList.get(position));
               }
           });

           listView.setAdapter(adapter);

           fm.beginTransaction().replace(R.id.fragment, fragment).commit();
       }catch(Exception e){
           System.out.println("broken in fragment "+e.getMessage());

       }

    }

    @Override
    public void showMessage(final String message) {
        if(!StringUtil.isNullOrEmpty(message))
            try {
                WebSocketMessage msg = GsonRequestWrapper.getInstance().fromJson(message, WebSocketMessage.class);
                System.out.println(msg.getType());
                if(msg.getType().equalsIgnoreCase("update")){
                    Constants.state = msg.getState();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            updateUi();
                        }
                    });
                }else if(msg.getType().equalsIgnoreCase("chat")){
                    Constants.chatHistory.append(msg.getMessage());
//                    final String chatmsg = msg.getState().getUser().getName()+" > "+msg.getMessage();
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            openDialog();
                        }
                    });
                }else{
                    System.out.println("kuch nhi ");
                }

            }catch (Exception e){
                System.out.println("gand fat gayi :P");
            }


    }

    void openDialog(){
        try {
            if (chatDialog != null && chatDialog.isShowing()) {
                chat.setText(Constants.chatHistory);
            } else {
                chatDialog = new Dialog(MainActivity.this);
                chatDialog.setTitle("Chat");
//                chatDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
                chatDialog.setContentView(R.layout.chat_head);
                chat = (TextView) chatDialog.findViewById(R.id.chattext);
//                chat.setText(Constants.chatHistory.toString() + "\n" + message);
                                chat.setText(Constants.chatHistory.toString() );
//                send = (Button) chatDialog.findViewById(R.id.btnSend);
//                send.setOnClickListener(sendListener);
                chatBox = (EditText) chatDialog.findViewById(R.id.chatbox);
                chatBox.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        if(actionId== EditorInfo.IME_ACTION_DONE){
                            if(chatBox!=null){
                                System.out.println("mesahe was " + chatBox.getText().toString());
                                WebSocketMessage msg = new WebSocketMessage();
                                msg.setMessage(Constants.user.getName()+" > "+chatBox.getText().toString()+"\n");
                                msg.setType("chat");
                                msg.setState(Constants.state);
                                String sendmsg = GsonRequestWrapper.getInstance().toJson(msg);
                                sendMessage(sendmsg);
                                chatBox.setText("");
//                                chatDialog.dismiss();
                            }
                        }
                        return false;
                    }
                });
                chatDialog.show();
            }
        }catch (Exception e){
            System.out.println("error was "+e.getMessage());
        }
    }
    public void sendMessage(String message) {
        webSocket.sendMessage(message);
    }

//    View.OnClickListener sendListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            if(chatBox!=null){
//                System.out.println("mesahe was " + chatBox.getText().toString());
//                WebSocketMessage msg = new WebSocketMessage();
//                msg.setMessage(chatBox.getText().toString());
//                msg.setType("chat");
//                msg.setState(Constants.state);
//                String sendmsg = GsonRequestWrapper.getInstance().toJson(msg);
//                sendMessage(sendmsg);
//                chatBox.setText("");
//                chatDialog.dismiss();
//            }
//        }
//    };

    public void openchat(){
        openDialog();
    }

    @Override
    public void onBackPressed() {
        if(chatDialog!=null && chatDialog.isShowing())
            chatDialog.dismiss();
        else {
            Intent intent = new Intent(MainActivity.this,SiteActivity.class);
            intent.putExtra("backcall",true);
            startActivityForResult(intent, 1000);
        }
//        super.onBackPressed();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1000){
            if(resultCode==RESULT_OK){
                if(data!=null) {
                    Bundle extra = data.getExtras();
                    if (extra != null && extra.containsKey("SelectedItem")) {
                        System.out.println("null to nahi main ");
                        state = (State) (extra.getSerializable("SelectedItem"));
                        activeProduct = state.getActiveProduct();
                        objectList = state.getProducts();
                        WebSocketMessage msg = new WebSocketMessage();
                        msg.setType("update");
                        msg.setMessage("");
                        msg.setState(Constants.state);
                        String sendmsg = GsonRequestWrapper.getInstance().toJson(msg);
                        System.out.println("json was ----> " + sendmsg);
                        sendMessage(sendmsg);
                    }
                    updateUi();
                }
            }
        }else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}


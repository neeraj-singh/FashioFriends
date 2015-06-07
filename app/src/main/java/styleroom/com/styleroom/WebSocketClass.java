package styleroom.com.styleroom;

import android.util.Log;
import android.widget.Toast;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Observable;

import styleroom.com.styleroom.Constants.Constants;

/**
 * Created by neeraj.singh on 26/04/15.
 */
public class WebSocketClass {
    private  WebSocketClient mWebSocketClient;
    WebSocketInterface callback;
    public WebSocketClass(WebSocketInterface callback){
        this.callback  = callback;
    }

    public  void connectToChat() {
        URI uri = connectWebSocket();
        mWebSocketClient = new WebSocketClient(uri) {
            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                Log.i("Websocket", "Opened");
//                mWebSocketClient.send("Hello from " + Build.MANUFACTURER + " " + Build.MODEL);
            }

            @Override
            public void onMessage(final String s) {
                final String message = s;
                System.out.println("messag in "+s);
                try {
                    if (callback != null) {
                        Constants.messageList = s;
                        callback.showMessage(s);
                    } else {
                        System.out.println("callback was null");
                        Constants.webSocketClass = null;
                    }
                }catch (Exception e){
                    System.out.println("Crashed "+e.getMessage());
                    Constants.messageList = s;
                }
            }

            @Override
            public void onClose(int i, String s, boolean b) {
                Log.i("Websocket", "Closed " + s);
            }

            @Override
            public void onError(Exception e) {
                Log.i("Websocket", "Error " + e.getMessage());
            }
        };
        mWebSocketClient.connect();
    }


    private  URI connectWebSocket() {
        URI uri;
        try {
            uri = new URI("ws://10.0.12.182:8080");
            return uri;
        } catch (URISyntaxException e) {
            e.printStackTrace();
//            Toast.makeText(getActivity(), "Unable to connect", Toast.LENGTH_LONG).show();
            return null;
        }
    }

    public  void sendMessage(String message) {
        try {
            if (!StringUtil.isNullOrEmpty(message))
                if (mWebSocketClient != null)
                    mWebSocketClient.send(message);
        }catch (Exception e){
            System.out.println("Server down!");
//            Toast.makeText((MainActivity.this),"Server down",Toast.LENGTH_LONG).show();
        }
    }

}

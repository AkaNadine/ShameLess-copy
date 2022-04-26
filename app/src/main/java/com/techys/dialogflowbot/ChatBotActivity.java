package com.techys.dialogflowbot;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

<<<<<<< HEAD
import com.techys.dialogflowbot.adapters.ChatAdapter;
import com.techys.dialogflowbot.helpers.SendMessageInBg;
import com.techys.dialogflowbot.interfaces.BotReply;
import com.techys.dialogflowbot.models.Message;
=======
>>>>>>> main
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.dialogflow.v2.DetectIntentResponse;
import com.google.cloud.dialogflow.v2.Intent;
import com.google.cloud.dialogflow.v2.QueryInput;
import com.google.cloud.dialogflow.v2.SessionName;
import com.google.cloud.dialogflow.v2.SessionsClient;
import com.google.cloud.dialogflow.v2.SessionsSettings;
import com.google.cloud.dialogflow.v2.TextInput;
import com.google.common.collect.Lists;
<<<<<<< HEAD
import com.google.protobuf.InvalidProtocolBufferException;
import com.techys.R;
=======
import com.google.gson.Gson;
import com.google.protobuf.InvalidProtocolBufferException;
import com.techys.R;
import com.techys.dialogflowbot.adapters.ChatAdapter;
import com.techys.dialogflowbot.helpers.SendMessageInBg;
import com.techys.dialogflowbot.interfaces.BotReply;
import com.techys.dialogflowbot.models.CustomPayload;
import com.techys.dialogflowbot.models.Message;
>>>>>>> main

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


<<<<<<< HEAD

public class ChatBotActivity extends AppCompatActivity implements BotReply {

=======
public class ChatBotActivity extends AppCompatActivity implements BotReply {

    private final String uuid = UUID.randomUUID().toString();
>>>>>>> main
    RecyclerView chatView;
    ChatAdapter chatAdapter;
    List<Message> messageList = new ArrayList<>();
    EditText editMessage;
    ImageButton btnSend;
<<<<<<< HEAD

    //dialogFlow
    private SessionsClient sessionsClient;
    private SessionName sessionName;
    private final String uuid = UUID.randomUUID().toString();
    private String jsonString;



=======
    //dialogFlow
    private SessionsClient sessionsClient;
    private SessionName sessionName;
    private String jsonString;


>>>>>>> main
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatbot_activity_main);
        chatView = findViewById(R.id.chatView);
        editMessage = findViewById(R.id.editMessage);
        btnSend = findViewById(R.id.btnSend);

        chatAdapter = new ChatAdapter(messageList, this);
        chatView.setAdapter(chatAdapter);

<<<<<<< HEAD
=======
       /* public class WebViewClient extends Object(){
            WebView myWebView = null;
            myWebView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                    view.loadUrl(request.getUrl().toString());
                    return false;
                }
            });
        }*/



      /*  WebView myWebView = new WebView(activityContext);
        setContentView(myWebView);

        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return false;
            }
        });*/

>>>>>>> main
        btnSend.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
                String message = editMessage.getText().toString();
                if (!message.isEmpty()) {
                    messageList.add(new Message(message, false));
                    editMessage.setText("");
                    sendMessageToBot(message);
                    Objects.requireNonNull(chatView.getAdapter()).notifyDataSetChanged();
                    Objects.requireNonNull(chatView.getLayoutManager())
                            .scrollToPosition(messageList.size() - 1);
                } else {
                    Toast.makeText(ChatBotActivity.this, "Please enter text!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        setUpBot();
    }

    private void setUpBot() {
        String TAG = "mainactivity";
        try {
            InputStream stream = this.getResources().openRawResource(R.raw.credential);
            GoogleCredentials credentials = GoogleCredentials.fromStream(stream)
                    .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));
            String projectId = ((ServiceAccountCredentials) credentials).getProjectId();

            SessionsSettings.Builder settingsBuilder = SessionsSettings.newBuilder();
            SessionsSettings sessionsSettings = settingsBuilder.setCredentialsProvider(
                    FixedCredentialsProvider.create(credentials)).build();
            sessionsClient = SessionsClient.create(sessionsSettings);
            sessionName = SessionName.of(projectId, uuid);

            Log.d(TAG, "projectId : " + projectId);
        } catch (Exception e) {
            Log.d(TAG, "setUpBot: " + e.getMessage());
        }
    }

    private void sendMessageToBot(String message) {
        QueryInput input = QueryInput.newBuilder()
                .setText(TextInput.newBuilder().setText(message).setLanguageCode("en-US")).build();
        new SendMessageInBg(this, sessionName, sessionsClient, input).execute();
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void callback(DetectIntentResponse returnResponse) throws InvalidProtocolBufferException {
        if (returnResponse != null) {
            String botReply = returnResponse.getQueryResult().getFulfillmentText();
<<<<<<< HEAD

            List<Intent.Message> payloadList = returnResponse.getQueryResult().getFulfillmentMessagesList();
            if (payloadList.size() > 1) {
                String payload = payloadList.get(1).toString();
            }

            if (!botReply.isEmpty()) {
                Message message = new Message(botReply, true);
=======
/*            String payload = returnResponse.getQueryResult().getFulfillmentMessages(1).getPayload().toString();
            returnResponse.getQueryResult().getFulfillmentMessages(1).getPayload().getFieldsMap();
            JsonFormat.Printer json = JsonFormat.printer().includingDefaultValueFields();
            String str = json.print(returnResponse.getQueryResult().getFulfillmentMessagesOrBuilder(1));*/
            List<Intent.Message> payloadList = returnResponse.getQueryResult().getFulfillmentMessagesList();
            if (payloadList.size() > 1) {
                String payload = payloadList.get(1).toString();
//                System.out.println(payload);
            }
            System.out.println(payloadList);

            CustomPayload customPayload = new CustomPayload();
            try {

//                JSONObject obj = new JSONObject(str);
                Gson gson = new Gson();
                //customPayload = gson.toJson();
                ///String json1 = gson.toJson(obj.get("payload"));
                ///Log.d("My App", json1);
//                customPayload = gson.fromJson(str, CustomPayload.class);

//                Log.d("My App", obj.get("payload").toString());
            } catch (Throwable t) {
//                Log.e("My App", "Could not parse malformed JSON: \"" + json + "\"");
            }
            if (!botReply.isEmpty()) {
                Message message = new Message(botReply, true);
                message.setCustomPayload(customPayload);
>>>>>>> main
                messageList.add(message);
                chatAdapter.notifyDataSetChanged();
                Objects.requireNonNull(chatView.getLayoutManager()).scrollToPosition(messageList.size() - 1);
            } else {
                Toast.makeText(this, "something went wrong", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "failed to connect!", Toast.LENGTH_SHORT).show();
        }
    }
}

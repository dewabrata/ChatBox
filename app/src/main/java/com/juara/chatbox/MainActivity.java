package com.juara.chatbox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView lstChat;
    List<ModelChat> lstModel;
    EditText txtChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstChat = findViewById(R.id.lstChat);
        txtChat = findViewById(R.id.txtChat);
        lstModel = new ArrayList<ModelChat>();

        txtChat.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if(actionId == EditorInfo.IME_ACTION_DONE
                        || keyEvent.getAction() == KeyEvent.ACTION_DOWN
                        || keyEvent.getAction() == KeyEvent.KEYCODE_ENTER) {

                    ModelChat mc = new ModelChat();
                    mc.setText(txtChat.getText().toString());
                    mc.setDate(new Date().toString());
                    mc.setImage("https://www.pinterpolitik.com/wp-content/uploads/2018/11/Titiek-Tuduh-Jokowi-Pembohong-Joko-Widodo.-Foto-VoaIndonesia-768x432.jpg");
                    mc.setType(AdapterListSimple.TYPE_RECEIVER);
                    setListChat(mc);
                    txtChat.setText("");
                    txtChat.setShowSoftInputOnFocus(false);

                    return true;

                }
                return false;
            }
        });






    }

    public void setListChat(ModelChat mc){

        lstModel.add(mc);

        AdapterListSimple adapter = new AdapterListSimple(MainActivity.this,lstModel);

        lstChat.setLayoutManager(new LinearLayoutManager(this));
        lstChat.setItemAnimator(new DefaultItemAnimator());
        lstChat.setAdapter(adapter);

    }


}

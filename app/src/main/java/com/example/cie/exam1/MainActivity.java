package com.example.cie.exam1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText mingwen, miwen, pianyiliang;
    Button jiami, jiemi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jiami = findViewById(R.id.button);
        jiemi = findViewById(R.id.button2);
        mingwen = findViewById(R.id.editText);
        pianyiliang = findViewById(R.id.editText2);
        miwen = findViewById(R.id.editText3);
        jiami.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = mingwen.getText().toString();
                String a = pianyiliang.getText().toString();
                int pianyi = Integer.parseInt(a);
                String m = process(str, pianyi);
//                String m = "woshi";
                miwen.setText(m);
            }
        });

        jiemi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = miwen.getText().toString();
                String a = pianyiliang.getText().toString();
                int pianyi = Integer.parseInt(a);
                String m = process2(str, pianyi);
                mingwen.setText(m);
            }
        });
    }

    private String process(String s, int key){
        String es="";
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c>='a'&& c<='z'){
                c += key%26;
                if(c<'a') c += 26;
                if(c>'z') c -= 26;
            }
            else if(c>='A' && c<='Z'){
                c += key%26;
                if(c<'A') c+= 26;
                if(c>'Z') c-= 26;
            }
            es += c;
        }
        return es;
    }

    private String process2(String s, int key){
        String es="";
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c>='a'&& c<='z'){
                c -= key%26;
                if(c<'a') c += 26;
                if(c>'z') c -= 26;
            }
            else if(c>='A' && c<='Z'){
                c -= key%26;
                if(c<'A') c+= 26;
                if(c>'Z') c-= 26;
            }
            es += c;
        }
        return es;
    }
}

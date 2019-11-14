package com.fc.andriod.newcptdemo3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fc.andriod.newcptdemo3.adapter.MessageAdapter;
import com.fc.andriod.newcptdemo3.entity.Message;

public class ImsgDemoActivity extends AppCompatActivity {
   private RecyclerView messages;
   private MessageAdapter adapter;
   private EditText editInput;
   private Button buttonSend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imsg_demo);

        messages=findViewById(R.id.recycler_view);
        messages.setLayoutManager(new LinearLayoutManager(this));
        adapter=new MessageAdapter(null);
        messages.setAdapter(adapter);
        editInput=findViewById(R.id.edt_input);
        buttonSend=findViewById(R.id.btn_send);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _message=editInput.getText().toString();
                Message message=new Message();
                message.setMessage(_message);
                message.setImgId(R.mipmap.ic_launcher);

                adapter.addData(message);

                Message other=new Message();
                other.setType(Message.OTHERS);
                other.setImgId(R.mipmap.ic_launcher_round);
                other.setMessage("hello，what is the matter");

                adapter.addData(other);

                editInput.setText("");
            }
        });
    }
}

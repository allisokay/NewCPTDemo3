package com.fc.andriod.newcptdemo3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private NewListDemoAdapter adapter;
    private List<ClassManagement> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycler_view);
        //布局管理器
        LinearLayoutManager manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

       //适配器
        adapter=new NewListDemoAdapter(R.layout.item_list_demo,null);
        recyclerView.setAdapter(adapter);
        initData();

    }

    private void initData() {
        data=new ArrayList<>();
        for (int i=1;i<100;i++){
            ClassManagement classManagement=new ClassManagement("软工16级"+i+"班");
            data.add(classManagement);
        }
        adapter.setNewData(data);
    }
}

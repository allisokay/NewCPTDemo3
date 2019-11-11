package com.fc.andriod.newcptdemo3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ListDemoAdapter adapter;
    private List<ClassManagement> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView=findViewById(R.id.recycler_view);

        //设置布局管理器

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //设置适配器
        adapter=new ListDemoAdapter(null);
        recyclerView.setAdapter(adapter);

        initData();
    }

    private void initData() {
        data=new ArrayList<>();
        for(int i=1;i<100;i++){
            ClassManagement classManagement=new ClassManagement("软工16"+i);
            data.add(classManagement);
        }
        adapter.setData(data);
    }
}

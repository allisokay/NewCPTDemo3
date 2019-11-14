package com.fc.andriod.newcptdemo3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.fc.andriod.newcptdemo3.adapter.ListDemoAdapter;
import com.fc.andriod.newcptdemo3.entity.ClassManagement;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ListDemoAdapter adapter;
    private List<ClassManagement> data;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        context=this;
        recyclerView=findViewById(R.id.recycler_view);

        //设置布局管理器
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //设置适配器
        adapter=new ListDemoAdapter(null);
        //自定义点击事件


        OnItemClickListener listener=new OnItemClickListener() {
            @Override
            public void itemClick(int position, View view) {
                Toast.makeText(context,data.get(position).getClass_name(),Toast.LENGTH_SHORT).show();
            }
        };
        adapter.setOnItemClickListener(listener);
        recyclerView.setAdapter(adapter);

        initData();
    }

    private void initData() {
        data=new ArrayList<>();
        for(int i=1;i<100;i++){
            ClassManagement classManagement=new ClassManagement("软工16级"+i+"班");
            data.add(classManagement);
        }
        adapter.setData(data);
    }

    public static interface OnItemClickListener{
        void  itemClick(int position, View view);
    }
}

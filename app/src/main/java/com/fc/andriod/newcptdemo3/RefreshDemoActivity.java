package com.fc.andriod.newcptdemo3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.fc.andriod.newcptdemo3.adapter.ListDemoAdapter;
import com.fc.andriod.newcptdemo3.adapter.NewRefreshLayoutAdapter;
import com.fc.andriod.newcptdemo3.entity.ClassManagement;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

public class RefreshDemoActivity extends AppCompatActivity {
    private SmartRefreshLayout smartRefreshLayout;
    private List<ClassManagement>freshAddData;
    private List<ClassManagement>data;
    private Context context;
    private RecyclerView recyclerView;
    private NewRefreshLayoutAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_demo);
        //变量初始化
        context=this;
        recyclerView=findViewById(R.id.recyclerView);
        smartRefreshLayout=findViewById(R.id.layout_refresh);
        adapter=new NewRefreshLayoutAdapter(null);

        //布局管理器
        LinearLayoutManager manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        //仓库刷新效果
        smartRefreshLayout.setRefreshHeader(new ClassicsHeader(this));//头部下拉刷新
        smartRefreshLayout.setRefreshFooter(new ClassicsFooter(this));//底部刷新效果
        //刷新事件监听
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                loadData();
                smartRefreshLayout.finishRefresh(2000/*,false*/);
            }

        });
         smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                loadData();
                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
            }
        });

        RecyclerViewActivity.OnItemClickListener listener=new RecyclerViewActivity.OnItemClickListener() {
            @Override
            public void itemClick(int position, View view) {
                Toast.makeText(context,data.get(position).getClass_name(),Toast.LENGTH_SHORT).show();
            }
        };
        //监听事件
        adapter.setOnItemClickListener(listener);

        recyclerView.setAdapter(adapter);

        initData();
    }
    private void initData() {
        data=new ArrayList<>();
        for(int i=1;i<10;i++){
            ClassManagement classManagement=new ClassManagement("软工16级"+i+"班");
            data.add(classManagement);
        }
        adapter.setData(data);
    }
    private void loadData() {
        Log.i("tag101",data.size()+"");
        int i=data.size()+1;
        freshAddData=new ArrayList<>();
        for(int j=0;j<2;j++){
            ClassManagement classManagement=new ClassManagement("软工16级"+i+"班");
            //data.add(classManagement);
            freshAddData.add(classManagement);
            i++;
        }
     //  adapter.setData(freshAddData);
        adapter.addData(freshAddData);
    }

}

package com.fc.andriod.newcptdemo3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.fc.andriod.newcptdemo3.adapter.NewListDemoAdapter;
import com.fc.andriod.newcptdemo3.entity.ClassManagement;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SwipeRefreshLayout refreshLayout;
    private NewListDemoAdapter adapter;
    private List<ClassManagement> data;
    private List<ClassManagement>data_for_refresh;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context=this;
        recyclerView=findViewById(R.id.recycler_view);
        refreshLayout=findViewById(R.id.refreshLayout_view);
        //布局管理器
        LinearLayoutManager manager=new LinearLayoutManager(this);

      //  manager.setOrientation(LinearLayoutManager.HORIZONTAL);//水平滚动
        recyclerView.setLayoutManager(manager);

       //适配器
        adapter=new NewListDemoAdapter(R.layout.item_list_demo,null);
        //监听
        recyclerView.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(context,data.get(position).getClass_name()+"has been clicked",Toast.LENGTH_SHORT).show();
            }
        });
        //分界线
        DividerItemDecoration itemDecoration=new DividerItemDecoration(context,DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(getResources().getDrawable(R.drawable.item_divider));
        recyclerView.addItemDecoration(itemDecoration);

        //创新
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadData();;
                        refreshLayout.setRefreshing(false);
                    }
                },3000);
            }
        });

        recyclerView.setAdapter(adapter);
        initData();

    }
    private void initData() {
        data=new ArrayList<>();
        for (int i=1;i<10;i++){
            ClassManagement classManagement=new ClassManagement("软工16级"+i+"班");
            data.add(classManagement);
        }
        adapter.addData(data);
    }
    private void loadData() {
        Log.i("tag101"," "+data.size());
        int i=data.size()+1;
        data_for_refresh=new ArrayList<>();
        for (int j=0;j<2;j++){
            ClassManagement classManagement=new ClassManagement("软工16级"+i+"班");
            data.add(classManagement);
            data_for_refresh.add(classManagement);
            i++;
        }
        adapter.addData(data_for_refresh);
    }


}

package com.fc.andriod.newcptdemo3.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fc.andriod.newcptdemo3.R;
import com.fc.andriod.newcptdemo3.RecyclerViewActivity;
import com.fc.andriod.newcptdemo3.entity.ClassManagement;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewRefreshLayoutAdapter extends RecyclerView.Adapter<NewRefreshLayoutAdapter.ListViewHolder> {
    private List<ClassManagement> data;
    private RecyclerViewActivity.OnItemClickListener listener;
    public NewRefreshLayoutAdapter(List<ClassManagement> data) {
        this.data = data;
    }

    public void setData(List<ClassManagement> data) {
        this.data = data;
        notifyDataSetChanged();

    }
    public void addData(List<ClassManagement> entities)
    {
        if (data == null)
        {
            data = new ArrayList<>();
        }
        this.data.addAll(entities);//两个List的拼接
        notifyDataSetChanged();
    }
    public void setOnItemClickListener(RecyclerViewActivity.OnItemClickListener listener) {
        this.listener=listener;
    }

    /**
     * 创建一个ViewHolder并返回
     * @param parent 相当于Item盛放的容器
     * @param viewType 指定布局文件的类型
     * @return 返回ViewHolder对象
     */
    @NonNull
    @Override
    public NewRefreshLayoutAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 指定对应的布局文件
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_demo,parent,false);
        return new NewRefreshLayoutAdapter.ListViewHolder(view);
    }


    /**
     * 将数据加载到布局文件的控件上
     * @param holder 需要绑定数据的ViewHolder
     * @param position 列表数据的下标
     */
    @Override
    public void onBindViewHolder(@NonNull NewRefreshLayoutAdapter.ListViewHolder holder, final int position) {
        ClassManagement classManagement=data.get(position);
        holder.textView.setText(classManagement.getClass_name());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener !=null){
                    listener.itemClick(position,v);
                }
            }
        });
    }


    /**
     * @return 返回列表数据大小
     */
    @Override
    public int getItemCount() {
        return data==null ? 0 : data.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
       TextView textView;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView=itemView.findViewById(R.id.tv_text);
        }
    }
}

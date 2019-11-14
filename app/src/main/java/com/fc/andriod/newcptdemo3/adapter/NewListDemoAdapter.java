package com.fc.andriod.newcptdemo3.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fc.andriod.newcptdemo3.R;
import com.fc.andriod.newcptdemo3.entity.ClassManagement;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class NewListDemoAdapter extends BaseQuickAdapter<ClassManagement, BaseViewHolder> {
    public NewListDemoAdapter(int layoutResId, @Nullable List<ClassManagement> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(@NonNull BaseViewHolder helper, ClassManagement item) {
        helper.setText(R.id.tv_text,item.getClass_name())
              .addOnClickListener(R.id.tv_text);
    }
}

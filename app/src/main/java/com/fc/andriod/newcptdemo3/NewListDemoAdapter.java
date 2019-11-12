package com.fc.andriod.newcptdemo3;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class NewListDemoAdapter extends BaseQuickAdapter<ClassManagement, BaseViewHolder> {
    public NewListDemoAdapter(int layoutResId, @Nullable List<ClassManagement> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(@NonNull BaseViewHolder helper, ClassManagement item) {
        helper.setText(R.id.tv_text,item.getClass_name());
    }
}

package com.fc.andriod.newcptdemo3.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fc.andriod.newcptdemo3.R;
import com.fc.andriod.newcptdemo3.entity.Message;

import java.util.List;

import androidx.annotation.NonNull;

public class MessageAdapter extends BaseMultiItemQuickAdapter<Message,BaseViewHolder> {
    public MessageAdapter(List<Message> data) {
        super(data);
        addItemType(Message.OTHERS, R.layout.item_others);// addItemType(1, R.layout.item_others)
        addItemType(Message.MINE, R.layout.item_mine);// addItemType(0, R.layout.item_mine);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, Message item) {
        switch (item.getItemType()){
            case Message.MINE:{
                helper.setText(R.id.tv_msg_mine,item.getMessage())
                        .setImageResource(R.id.img_mine,item.getImgId());
            }break;
            case Message.OTHERS:{
                helper.setText(R.id.tv_msg_other,item.getMessage())
                        .setImageResource(R.id.img_other,item.getImgId());
            }break;
            default:;
        }
    }


}

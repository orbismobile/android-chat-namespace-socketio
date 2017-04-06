package com.osp.projects.androidchatsocketioio.util.adapter;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.osp.projects.androidchatsocketioio.R;
import com.osp.projects.androidchatsocketioio.model.entity.MessageMyUserEntity;
import com.osp.projects.androidchatsocketioio.model.entity.MessageOtherUserEntity;
import com.osp.projects.androidchatsocketioio.model.entity.MessageTypeActionEntity;
import com.osp.projects.androidchatsocketioio.util.Constants;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos Vargas on 9/11/16.
 * CarlitosDroid
 */
public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<Object> objectList = new ArrayList<>();


    public MessageAdapter(List<Object> objectList){
        this.objectList = objectList;
    }

    @Override
    public int getItemViewType(int position) {
        if(objectList.get(position) instanceof String){
            return Constants.TYPE_HEADER_VIEW;
        }else if(objectList.get(position) instanceof MessageMyUserEntity){
            return Constants.TYPE_ITEM_MY_USER;
        }else if(objectList.get(position) instanceof MessageTypeActionEntity){
            return Constants.TYPE_TYPE_ACTION_VIEW;
        }else if(objectList.get(position) instanceof MessageOtherUserEntity){
            return Constants.TYPE_ITEM_OTHER_USER;
        } else{
            return -1;
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecyclerView.ViewHolder viewHolder;
        View view;
        switch (viewType){
            case Constants.TYPE_HEADER_VIEW:
                view = inflater.inflate(R.layout.item_message_numusers, parent, false);
                viewHolder = new HeaderViewHolder(view);
                break;
            case Constants.TYPE_ITEM_MY_USER:
                view = inflater.inflate(R.layout.item_message_my_user, parent, false);
                viewHolder = new ItemViewMyUserHolder(view);
                break;
            case Constants.TYPE_TYPE_ACTION_VIEW:
                view = inflater.inflate(R.layout.item_message_type_action, parent, false);
                viewHolder = new ItemViewTypeActionHolder(view);
                break;
            case Constants.TYPE_ITEM_OTHER_USER:
                view = inflater.inflate(R.layout.item_message_other_user, parent, false);
                viewHolder = new ItemViewOtherUserHolder(view);
                break;
            default:
                view = inflater.inflate(R.layout.item_message_type_action, parent, false);
                viewHolder = new ItemViewMyUserHolder(view);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()){
            case Constants.TYPE_HEADER_VIEW:
                ((HeaderViewHolder)holder).lblNumUsers.setText((CharSequence) objectList.get(position));
                break;
            case Constants.TYPE_ITEM_MY_USER:
                ((ItemViewMyUserHolder)holder).lblMessage.setText(
                        ((ItemViewMyUserHolder) holder).lblMessage.getContext().getString(R.string.message_my_user,
                                ((MessageMyUserEntity)objectList.get(position)).getMessage()));
                break;
            case Constants.TYPE_TYPE_ACTION_VIEW:
                ((ItemViewTypeActionHolder)holder).lblTypeAction.setText(
                        ((ItemViewTypeActionHolder) holder).lblTypeAction.getContext().getString(R.string.message_type_action,
                                ((MessageMyUserEntity)objectList.get(position)).getUserName()));
                break;

            case Constants.TYPE_ITEM_OTHER_USER:
                ((ItemViewOtherUserHolder)holder).lblMessage.setText(
                        ((ItemViewOtherUserHolder) holder).lblMessage.getContext().getString(R.string.message_other_user,
                                ((MessageOtherUserEntity)objectList.get(position)).getUserName(),
                                ((MessageOtherUserEntity)objectList.get(position)).getMessage()));
                break;

            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }


    class HeaderViewHolder extends RecyclerView.ViewHolder{

        private AppCompatTextView lblNumUsers;
        public HeaderViewHolder(View itemView) {
            super(itemView);
            lblNumUsers = (AppCompatTextView) itemView.findViewById(R.id.lblNumUsers);
        }
    }

    class ItemViewMyUserHolder extends RecyclerView.ViewHolder{
        private AppCompatTextView lblMessage;
        public ItemViewMyUserHolder(View itemView) {
            super(itemView);
            lblMessage = (AppCompatTextView) itemView.findViewById(R.id.lblMessage);
        }
    }

    class ItemViewOtherUserHolder extends RecyclerView.ViewHolder{
        private AppCompatTextView lblMessage;
        public ItemViewOtherUserHolder(View itemView) {
            super(itemView);
            lblMessage = (AppCompatTextView) itemView.findViewById(R.id.lblMessage);
        }
    }


    class ItemViewTypeActionHolder extends RecyclerView.ViewHolder{
        private AppCompatTextView lblTypeAction;
        public ItemViewTypeActionHolder(View itemView) {
            super(itemView);
            lblTypeAction = (AppCompatTextView) itemView.findViewById(R.id.lblTypeAction);
        }
    }
}

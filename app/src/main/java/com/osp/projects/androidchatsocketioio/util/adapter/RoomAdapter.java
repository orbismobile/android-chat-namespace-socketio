package com.osp.projects.androidchatsocketioio.util.adapter;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.osp.projects.androidchatsocketioio.R;
import com.osp.projects.androidchatsocketioio.model.response.GetFriendsByUserIdResponse;
import com.osp.projects.androidchatsocketioio.model.response.GetGroupsByUserId;
import com.osp.projects.androidchatsocketioio.ui.main.MainView;

import org.w3c.dom.Text;

import java.util.List;


/**
 * Created by Carlos Vargas on 9/12/16.
 * CarlitosDroid
 */
public class RoomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_SUBTITLE = 0;
    private static final int VIEW_TYPE_FRIEND = 2;
    private static final int VIEW_TYPE_GROUP = 3;


    private List<Object> objectList;
    private MainView mainView;

    public RoomAdapter(MainView mainView, List<Object> objectList) {
        this.objectList = objectList;
        this.mainView = mainView;
    }

    @Override
    public int getItemViewType(int position) {
        if(objectList.get(position) instanceof GetFriendsByUserIdResponse.DataBean){
            return VIEW_TYPE_FRIEND;
        }else if(objectList.get(position) instanceof GetGroupsByUserId.DataBean){
            return VIEW_TYPE_GROUP;
        }else{
            return VIEW_TYPE_SUBTITLE;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case VIEW_TYPE_SUBTITLE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_subtitle, parent, false);
                return new SubtitleItemViewHolder(view);
            case VIEW_TYPE_FRIEND:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_friend, parent, false);
                return new FriendItemViewHolder(view);
            case VIEW_TYPE_GROUP:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_group, parent, false);
                return new GroupItemViewHolder(view);
            default:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_subtitle, parent, false);
                return new SubtitleItemViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (holder.getItemViewType()){
            case VIEW_TYPE_SUBTITLE:
                ((SubtitleItemViewHolder)holder).lblGroupName.setText((String)objectList.get(position));
                break;
            case VIEW_TYPE_FRIEND:
                ((FriendItemViewHolder)holder).lblFriendName.setText(((GetFriendsByUserIdResponse.DataBean) objectList.get(position)).getUserName());

                break;
            case VIEW_TYPE_GROUP:
                ((GroupItemViewHolder)holder).lblGroupName.setText(((GetGroupsByUserId.DataBean) objectList.get(position)).getGroupName());

                break;
        }

    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }


    public class SubtitleItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView lblGroupName;

        public SubtitleItemViewHolder(View itemView) {
            super(itemView);
            lblGroupName = (TextView) itemView.findViewById(R.id.lblGroupName);

            lblGroupName.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.container:
                    Log.e("CLICK ","CLICK SB");
                    break;
            }
        }
    }


    public class FriendItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imgFriend;
        TextView lblFriendName;

        public FriendItemViewHolder(View itemView) {
            super(itemView);
            lblFriendName = (TextView) itemView.findViewById(R.id.lblFriendName);
            imgFriend = (ImageView) itemView.findViewById(R.id.imgFriend);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){

            }
        }
    }


    public class GroupItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imgGroup;
        TextView lblGroupName;
        TextView lblGroupDescription;

        public GroupItemViewHolder(View itemView) {
            super(itemView);
            imgGroup = (ImageView) itemView.findViewById(R.id.imgGroup);
            lblGroupName = (TextView) itemView.findViewById(R.id.lblGroupName);
            lblGroupDescription = (TextView) itemView.findViewById(R.id.lblGroupDescription);

        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
            }
        }
    }
}

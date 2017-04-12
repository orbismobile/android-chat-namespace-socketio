package com.osp.projects.androidchatsocketioio.ui.globalfriend;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.osp.projects.androidchatsocketioio.R;
import com.osp.projects.androidchatsocketioio.model.response.GetGlobalFriendsResponse;

import java.util.List;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 4/12/17.
 */

public class GlobalFriendAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<GetGlobalFriendsResponse.DataBean> friendEntityList;
    private GlobalFriendsActivity globalFriendsActivity;

    public GlobalFriendAdapter(GlobalFriendsActivity globalFriendsActivity, List<GetGlobalFriendsResponse.DataBean> friendEntityList) {
        this.friendEntityList = friendEntityList;
        this.globalFriendsActivity = globalFriendsActivity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friend, parent, false);
        return new FriendItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        ((RoomItemViewHolder)holder).lblTitle.setText(roomsList.get(position).getUserName());
//        ((RoomItemViewHolder)holder).lblDescription.setText(roomsList.get(position).getDescription());
//        ((RoomItemViewHolder)holder).imgUser.setImageResource(roomsList.get(position).getImgDrawable());
    }

    @Override
    public int getItemCount() {
        return friendEntityList.size();
    }


    public class FriendItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ConstraintLayout container;
        ImageView imgFriend;
        TextView lblFriendName;

        public FriendItemViewHolder(View itemView) {
            super(itemView);
            imgFriend = (ImageView) itemView.findViewById(R.id.imgFriend);
            container = (ConstraintLayout) itemView.findViewById(R.id.container);
            lblFriendName = (TextView) itemView.findViewById(R.id.lblFriendName);

            container.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.container:
                    globalFriendsActivity.servicePostUser(getAdapterPosition());
                    break;
            }
        }
    }
}

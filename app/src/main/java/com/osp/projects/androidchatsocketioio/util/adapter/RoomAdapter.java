package com.osp.projects.androidchatsocketioio.util.adapter;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.osp.projects.androidchatsocketioio.R;
import com.osp.projects.androidchatsocketioio.model.response.GetFriendsByUserIdResponse;
import com.osp.projects.androidchatsocketioio.ui.main.MainView;

import java.util.List;


/**
 * Created by Carlos Vargas on 9/12/16.
 * CarlitosDroid
 */
public class RoomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<GetFriendsByUserIdResponse.DataBean> roomsList;
    private MainView mainView;

    public RoomAdapter(MainView mainView, List<GetFriendsByUserIdResponse.DataBean> roomsList) {
        this.roomsList = roomsList;
        this.mainView = mainView;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_room, parent, false);
        return new RoomItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((RoomItemViewHolder)holder).lblTitle.setText(roomsList.get(position).getUserName());
        ((RoomItemViewHolder)holder).lblDescription.setText(roomsList.get(position).getUserName());
        //((RoomItemViewHolder)holder).imgUser.setImageResource(roomsList.get(position).get());
    }

    @Override
    public int getItemCount() {
        return roomsList.size();
    }


    public class RoomItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        AppCompatTextView lblTitle;
        AppCompatTextView lblDescription;
        ConstraintLayout container;
        AppCompatImageView imgUser;

        public RoomItemViewHolder(View itemView) {
            super(itemView);
            imgUser = (AppCompatImageView) itemView.findViewById(R.id.imgUser);
            container = (ConstraintLayout) itemView.findViewById(R.id.container);
            lblTitle = (AppCompatTextView) itemView.findViewById(R.id.lblTitle);
            lblDescription = (AppCompatTextView) itemView.findViewById(R.id.lblDescription);

            container.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.container:
                    mainView.navigateToMain(getAdapterPosition());
                    break;
            }
        }
    }
}

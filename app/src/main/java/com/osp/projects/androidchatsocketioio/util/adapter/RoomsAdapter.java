package com.osp.projects.androidchatsocketioio.util.adapter;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.osp.projects.androidchatsocketioio.R;
import com.osp.projects.androidchatsocketioio.model.entity.RoomEntity;
import com.osp.projects.androidchatsocketioio.ui.rooms.RoomsActivity;

import java.util.List;


/**
 * Created by Carlos Vargas on 9/12/16.
 * CarlitosDroid
 */
public class RoomsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<RoomEntity> roomsList;
    private RoomsActivity roomsActivity;

    public RoomsAdapter(RoomsActivity roomsActivity, List<RoomEntity> roomsList) {
        this.roomsList = roomsList;
        this.roomsActivity = roomsActivity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_room, parent, false);
        return new RoomItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((RoomItemViewHolder)holder).lblTitle.setText(roomsList.get(position).getUserName());
        ((RoomItemViewHolder)holder).lblDescription.setText(roomsList.get(position).getDescription());
        ((RoomItemViewHolder)holder).imgUser.setImageResource(roomsList.get(position).getImgDrawable());
    }

    @Override
    public int getItemCount() {
        return roomsList.size();
    }


    public class RoomItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        AppCompatTextView lblTitle;
        AppCompatTextView lblDescription;
        LinearLayout container;
        AppCompatImageView imgUser;

        public RoomItemViewHolder(View itemView) {
            super(itemView);
            imgUser = (AppCompatImageView) itemView.findViewById(R.id.imgUser);
            container = (LinearLayout) itemView.findViewById(R.id.container);
            lblTitle = (AppCompatTextView) itemView.findViewById(R.id.lblTitle);
            lblDescription = (AppCompatTextView) itemView.findViewById(R.id.lblDescription);

            container.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.container:
                    //roomsActivity.goToMainActivity(getAdapterPosition());
                    break;
            }
        }
    }
}

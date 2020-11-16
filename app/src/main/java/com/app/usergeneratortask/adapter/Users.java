package com.app.usergeneratortask.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.usergeneratortask.R;
import com.app.usergeneratortask.models.Result;
import com.app.usergeneratortask.network.RouteData;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Users extends RecyclerView.Adapter<Users.UsersHolder> {

    private final OnItemClickListener listener;

    private List<Result> user;

    public interface OnItemClickListener {
        void onItemClick(Result item);
    }

    public Users(RouteData user, OnItemClickListener listener) {
        this.user = user.getResults();
        this.listener = listener;
    }

    @NonNull
    @Override
    public UsersHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);

        return new UsersHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersHolder holder, int position) {
        String name = generateName(position);
        String img = user.get(position).getPicture().getMedium();

        holder.userName.setText(name);

        Picasso.get()
                .load(img)
                .resize(240, 240)
                .into(holder.userImage);

        holder.bind(user.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return user.size();
    }

    static class UsersHolder extends RecyclerView.ViewHolder {
        private CircleImageView userImage;
        private TextView userName;

        public UsersHolder(View itemHolder) {
            super(itemHolder);

            userImage = itemHolder.findViewById(R.id.imageview_userdetail_avatar);
            userName  = itemHolder.findViewById(R.id.user_name);
        }

        public void bind(final Result item, final OnItemClickListener listener) {
            itemView.setOnClickListener(v -> listener.onItemClick(item));
        }
    }

    private String generateName(int position) {
        return user.get(position).getName().getFirst()
                + " " + user.get(position).getName().getLast();
    }
}

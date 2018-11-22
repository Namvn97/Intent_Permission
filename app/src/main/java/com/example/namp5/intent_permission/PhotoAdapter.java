package com.example.namp5.intent_permission;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import java.util.List;

/**
 * Created by namp5 on 11/22/2018.
 */

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolde>  {
    private List<Photo> mPhotos;
    public static final int INDEX_UNIT = 1;

    public PhotoAdapter(List<Photo> mPhotos) {
        this.mPhotos = mPhotos;
    }

    @Override
    public PhotoViewHolde onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view  = inflater
                .inflate(R.layout.item_photo,parent,false);
        return new PhotoViewHolde(view);    }

    @Override
    public void onBindViewHolder(PhotoViewHolde holder, int position) {
        holder.loadImage(mPhotos.get(position));
    }

    @Override
    public int getItemCount() {
        return mPhotos.size();
    }

    public void addPhoto(Photo photo) {
        mPhotos.add(photo);
        notifyItemInserted(mPhotos.size() - INDEX_UNIT);
    }

    public class PhotoViewHolde extends RecyclerView.ViewHolder {
        private ImageView mImageView;

        public PhotoViewHolde(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageview_photo);
        }
        private void loadImage (Photo photo) {
            Glide.with(itemView.getContext())
                    .load(photo.getmUrl())
                    .into(mImageView);
        }
    }
}

package com.anudeepsamaiya.urbancarnival;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.anudeepsamaiya.urbancarnival.databinding.ItemPhotoLibraryBinding;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anudeepsamaiya on 4/1/17.
 */

public class PhotoLibraryAdapter extends RecyclerView.Adapter<PhotoLibraryAdapter.ViewHolder> {
    List<PhotoItem> libraryDataset;

    public PhotoLibraryAdapter(){
        libraryDataset = new ArrayList<>();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemPhotoLibraryBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_photo_library, parent, false);
        return new ViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(holder.imgPhotoItem.getContext()).load(libraryDataset.get(position).data).into(holder.imgPhotoItem);
    }

    @Override
    public int getItemCount() {
        return libraryDataset.size();
    }

    public void updateDataset(List<PhotoItem> libraryDataset) {
        this.libraryDataset = libraryDataset;
        this.notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemPhotoLibraryBinding binding;
        ImageView imgPhotoItem;

        ViewHolder(View view) {
            super(view);
            binding = DataBindingUtil.getBinding(view);
            imgPhotoItem = binding.imgPhotoItem;
        }
    }
}

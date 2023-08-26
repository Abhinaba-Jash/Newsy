package com.example.newsy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

//public class customAdapter extends RecyclerView.Adapter<myadapter.ViewHolder>> {
//ArrayList<TutorialList> tutorial;
//Context mCtx;
//public customAdapter(Context mctx,ArrayList<TutorialList> tutorial) {
//        this.mctx=mCtx;
//        this.tutorial=tutorial;
//    }
//
//public class ViewHolder extends RecyclerView.ViewHolder {
//    TextView titleTextView;
//    TextView desTextView;
//    ImageView imageView;
//
//    public ViewHolder(View view) {
//        super(view);
//        // Define click listener for the ViewHolder's View
//
//        titleTextView = (TextView) view.findViewById(R.id.titleTextView);
//        desTextView=(TextView) view.findViewById(R.id.desTextView);
//        imageView=(ImageView) view.findViewById(R.id.imageView);
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        //getting the layoutinflater
//        ViewHolder holder;
//        LayoutInflater inflater = LayoutInflater.from(mCtx);
//        convertView = inflater.inflate(R.layout.activity_custom_adapter, null, true);
//        holder = new ViewHolder();
//        //getting text views
//        holder.textViewName = convertView.findViewById(R.id.textViewName);
//        holder.textDescription = convertView.findViewById(R.id.textViewImageUrl);
//        holder.imageView = convertView.findViewById(R.id.imageView);
//
//        convertView.setTag(holder);
//        //Getting the tutorial for the specified position
//        TutorialList tutorial1 = tutorial.get(position);
//        String imageUrl = tutorial.getImageUrl();
//        String tutorialDescription = tutorial.getDescription();
//        String tutorialTitle = tutorial.getName();
//
//        holder.textViewName.setText(tutorialTitle);
//        holder.textDescription.setText(tutorialDescription);
//
//        if (holder.imageView != null) {
//            /*-------------fetching image------------*/;
//            new ImageDownloaderTask(holder.imageView).execute(imageUrl);
//        }
//        holder.imageView.setImageBitmap(bitmap);
//        return convertView;
//    }
//}
public class customAdapter extends ArrayAdapter<TutorialList> {
    //the tutorial list that will be displayed
    private final List<TutorialList> tutorialList;
    private final Context mCtx;
    //here we are getting the tutoriallist and context
    //so while creating the object of this adapter class we need to give tutoriallist and context
    public customAdapter(List<TutorialList> tutorialList, Context mCtx) {
        super(mCtx, R.layout.activity_custom_adapter, tutorialList);
        this.tutorialList = tutorialList;
        this.mCtx = mCtx;
    }

    //this method will return the list item
    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //getting the layoutinflater
        ViewHolder holder;
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        convertView = inflater.inflate(R.layout.activity_custom_adapter, null, true);
        holder = new ViewHolder();
        //getting text views
        holder.titleTextView = convertView.findViewById(R.id.titleTextView);
        holder.desTextView = convertView.findViewById(R.id.desTextView);
        holder.imageView = convertView.findViewById(R.id.imageView);

        convertView.setTag(holder);
        //Getting the tutorial for the specified position
        TutorialList tutorial = tutorialList.get(position);
        String imageUrl = tutorial.getUrlToImage();
        String tutorialDescription = tutorial.getDescription();
        String tutorialTitle = tutorial.getTitle();

        holder.titleTextView.setText(tutorialTitle);
        holder.desTextView.setText(tutorialDescription);

        if (holder.imageView != null) {
            /*-------------fetching image------------*/;
            Glide.with(this.getContext()).load(imageUrl).into(holder.imageView);
        }
        return convertView;
    }
    static class ViewHolder {
        TextView titleTextView;
        TextView desTextView;
        ImageView imageView;
    }
}
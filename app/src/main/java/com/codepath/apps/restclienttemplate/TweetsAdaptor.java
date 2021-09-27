package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.w3c.dom.Text;

import java.util.List;

public class TweetsAdaptor extends RecyclerView.Adapter<TweetsAdaptor.ViewHolder>{
    Context context;
    List<Tweet> tweets;
    //Pass in the context and list of tweets
    public TweetsAdaptor (Context context, List<Tweet> tweets){
        this.context = context;
        this.tweets = tweets;
    }

    //For each row, inflate the layout
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tweet,parent, false);
        return new ViewHolder(view);
    }
    //Bind values based on the position of the element - Given a *position* and a *data* bind the View data to it
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Get the data at position
        Tweet tweet = tweets.get(position);
        //Bind the tweet with view holder
        holder.bind(tweet);
    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }


    //Define a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        //Define elements
        ImageView iv_Profile;
        TextView tv_Body;
        TextView tv_ScreenName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_Profile = itemView.findViewById(R.id.iv_Profile);
            tv_Body = itemView.findViewById(R.id.tv_Body);
            tv_ScreenName = itemView.findViewById(R.id.tv_ScreenName);
        }

        public void bind(Tweet tweet) {
            //Take out the different attributes of the Tweet and use it to fill in the view that we have on screen
            tv_Body.setText(tweet.body);
            tv_ScreenName.setText(tweet.user.screenName);
            //Use *Glide* to load in the image of the user
            Glide.with(context).load(tweet.user.profileImageUrl).into(iv_Profile);
        }
    }
}

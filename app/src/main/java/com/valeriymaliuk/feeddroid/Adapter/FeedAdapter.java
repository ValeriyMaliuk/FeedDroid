package com.valeriymaliuk.feeddroid.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.valeriymaliuk.feeddroid.Model.News;
import com.valeriymaliuk.feeddroid.R;

import java.util.List;

/**
 * Created by valeriymaliuk on 9/14/16.
 */
public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder>{

    private Context mContext;
    private List<News> mNewsList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mDate;
        public TextView mCaption;
        public TextView mHeadLine;
        public ImageView mImage;

        public ViewHolder(View v) {
            super(v);
            mDate     = (TextView) v.findViewById(R.id.tv_date);
            mCaption  = (TextView) v.findViewById(R.id.tv_caption);
            mHeadLine = (TextView) v.findViewById(R.id.tv_headline);
            mImage    = (ImageView) v.findViewById(R.id.iv_poster);
        }
    }

    public FeedAdapter(List<News> newsList, Context context) {
        mNewsList = newsList;
        mContext  = context;
    }

    @Override
    public FeedAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final News news = mNewsList.get(position);
        holder.mHeadLine.setText(news.getHeadLine());
        holder.mCaption .setText(news.getCaption());
        holder.mDate    .setText(news.getFormattedDate());

        // TODO: add photo placeHolder
        Picasso.with(mContext)
                .load(news.getNewsImage().getPhotoURL())
                .into(holder.mImage);
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }
}

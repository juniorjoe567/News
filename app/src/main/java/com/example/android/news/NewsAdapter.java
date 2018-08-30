package com.example.android.news;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jusutech on 8/8/18.
 */

public class NewsAdapter extends ArrayAdapter<News> {

    private List<News> mNewsList;

    private static class ViewHolder {
        TextView title;
        TextView datePublished;
        TextView section;

    }

    public NewsAdapter(Context context, List<News> newsList) {
        super(context, 0, newsList);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        News news = getItem(position);

        ViewHolder viewHolder;

        if( convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.news_list, parent, false);

            viewHolder.title = (TextView) convertView.findViewById(R.id.news_title);
            viewHolder.datePublished = (TextView) convertView.findViewById(R.id.date_published);
            viewHolder.section = (TextView) convertView.findViewById(R.id.section);


            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.title.setText(news.getWebTitle());
        viewHolder.datePublished.setText(news.getPublicationDate());
        viewHolder.section.setText(news.getSection());


        return convertView;
    }
}

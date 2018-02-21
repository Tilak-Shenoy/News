package com.example.tilak.headlines;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.preference.PreferenceActivity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tilak on 10/8/17.
 */

public class ArticleAdapter extends ArrayAdapter<Article> {

    public String contentUrl;
    ImageView imageView;
    List<Article> articleList;
    public Context context = getContext();

    public ArticleAdapter(@NonNull Context context, @NonNull List<Article> objects) {
        super(context, 0, objects);
        articleList = objects;
    }


    /**
     * Returns a list item view that displays information about the earthquake at the given position
     * in the list of earthquakes.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        ArticleAdapter.ViewHolder holder;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_headline_content, parent, false);
            holder = new ArticleAdapter.ViewHolder();
            holder.textView = listItemView.findViewById(R.id.HeadlineText);
            holder.imageView = listItemView.findViewById(R.id.HeadlineImage);
            listItemView.setTag(holder);


        } else {
            holder = (ViewHolder) listItemView.getTag();
        }


        if (articleList.get(position) != null) {


            Article currentArticle = getItem(position);
            imageView = listItemView.findViewById(R.id.HeadlineImage);
            holder.imageUrl = currentArticle.getmImageUrl();

            /*TextView textView = listItemView.findViewById(R.id.HeadlineText);

            textView.setText(currentArticle.getHeadline());
*/
            holder.textView.setText(currentArticle.getHeadline());

            String imageUrl = currentArticle.getmImageUrl();


            contentUrl = currentArticle.getmContentUrl();

            if (holder.imageUrl != null && !holder.imageUrl.equals("null")) {
//                String thumbUrl = holder.imageUrl.substring(0, holder.imageUrl.lastIndexOf('.')) + "-260x145" + holder.imageUrl.substring(holder.imageUrl.lastIndexOf('.'), holder.imageUrl.length());
//                holder.setImage(thumbUrl);
                Picasso.with(getContext()).load(imageUrl).into(imageView);
            }
        }

        return listItemView;
    }


    private class ViewHolder {
        TextView textView;
        ImageView imageView;
        String imageUrl;

        public void setImage(String imageUrl) {

/*
            DownloadImageTask task = new DownloadImageTask(imageView);
            task.execute(imageUrl);
*/






        }

    }

    private static class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        private final WeakReference<ImageView> imageViewReference;

        public DownloadImageTask(ImageView imageView) {
            imageViewReference = new WeakReference<ImageView>(imageView);
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            return downloadBitmap(params[0]);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (isCancelled()) {
                bitmap = null;
            }

            if (imageViewReference != null) {
                ImageView imageView = imageViewReference.get();
                if (imageView != null) {
                    if (bitmap != null) {
                        imageView.setImageBitmap(bitmap);
                    } else {
                        Drawable placeholder = null;
                        imageView.setImageDrawable(placeholder);
                    }
                }
            }
        }

        private Bitmap downloadBitmap(String url) {
            HttpURLConnection urlConnection = null;
            try {
                URL uri = new URL(url);
                urlConnection = (HttpURLConnection) uri.openConnection();

                final int responseCode = urlConnection.getResponseCode();
                if (responseCode != HttpURLConnection.HTTP_OK) {
                    return null;
                }

                InputStream inputStream = urlConnection.getInputStream();
                if (inputStream != null) {
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    return bitmap;
                }
            } catch (Exception e) {
                urlConnection.disconnect();
                Log.w("ImageDownloader", "Errore durante il download da " + url);
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
            return null;
        }

    }
}



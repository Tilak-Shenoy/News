package com.example.tilak.headlines;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by tilak on 10/8/17.
 */

public class ArticleLoader extends AsyncTaskLoader<List<Article>> {


    /**
     * Query URL
     */
    private String mUrl;

    /**
     * Constructs a new {@link ArticleLoader}.
     *
     * @param context of the activity
     * @param url     to load data from
     */
    public ArticleLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<Article> loadInBackground() {
        if (mUrl == null) {
            return null;
        }


        List<Article> articles = QueryUtils.fetchHeadlineData(mUrl);
        return articles;
    }


}

package com.mandriklab.Debtor.Presenter;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.mandriklab.Debtor.View.MainActivity;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class MainPresenter {
    private MainActivity view;
    //private SiteModel model;
    //private NewsModel newsModel;
    private GroupSitesModel groupSitesModel;
    //ArrayList<Site> listSites;
    //ArrayList<GroupSites> groupSites;
    private SharedPreferences sPref;

    String isNotify = "isNotify";
    String isLoadImage ="isLoadImage";
    public static int SELECT_OPML_DIALOG=999;


    public MainPresenter(SiteModel model, NewsModel newsModel,GroupSitesModel groupSitesModel ){
        this.model = model;
        this.newsModel = newsModel;
        this.groupSitesModel = groupSitesModel;
    }

    public void attachView(MainActivity mainActivity) {
        view = mainActivity;
    }

    public void detachView() {
        view = null;
    }

    public void viewIsReady() {
        listSites = new ArrayList<>();
        groupSites = new ArrayList<>();
        loadSettings();
        loadGroupSitesList();
        loadNews(0,0);
        loadNewsIsBookMark();

    }



    public void saveSettings(String tag,int value) {
        sPref = view.getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putInt(tag, value);
        ed.commit();
    }

    public void loadSettings() {
        sPref = view.getPreferences(MODE_PRIVATE);
        Boolean _isLoadImage = sPref.getBoolean(isLoadImage, false);
        Boolean _isNotify = sPref.getBoolean(isNotify, false);
        view.loadSettings(_isNotify,_isLoadImage);
    }



    public void updateNews(RssItem news) {
        newsModel.updateNews(news,new NewsModel.CompleteCallback() {
            @Override
            public void onComplete() {

            }
        });
    }
}

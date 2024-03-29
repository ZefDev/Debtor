package com.mandriklab.Debtor.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.mandriklab.Debtor.Model.OperationModel;
import com.mandriklab.Debtor.Model.OperationWithDebtors;
import com.mandriklab.Debtor.PagerAdapters;
import com.mandriklab.Debtor.AdapterCard;
import com.mandriklab.Debtor.ModelCard;
import com.mandriklab.Debtor.Presenter.MainPresenter;
import com.mandriklab.Debtor.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ViewPager viewPager, viewPagerCard;
    PagerAdapters pagerAdapters;
    AdapterCard adapterCard;
    List<ModelCard> models;
    RecyclerView listView;
    MainPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
    }

    public void Init(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AddOperationActivity.class));
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        viewPager = findViewById(R.id.viewPager);
        viewPagerCard = findViewById(R.id.viewPagerCard);



        OperationModel model = new OperationModel(this);
        presenter = new MainPresenter(model);
        presenter.attachView(this);
        presenter.viewIsReady();

    }

    public void loadCardView(List<OperationWithDebtors> list){
        double minus = 0;
        double plus = 0;
        // Подсчёт долгов и должников
        for (int i=0;i<list.size();i++){
            if(list.get(i).operation.getSumma()>0){
                plus += list.get(i).operation.getSumma();
            }
            else {
                minus += list.get(i).operation.getSumma();
            }
        }
        models = new ArrayList<>();
        models.add(new ModelCard(R.drawable.left_pointing_arrow,"Мне должны",plus+""));
        models.add(new ModelCard(R.drawable.red_arrow,"Я должен",minus+""));
        pagerAdapters = new PagerAdapters(models,this,list);
        viewPager.setAdapter(pagerAdapters);
        adapterCard = new AdapterCard(models,this);
        viewPagerCard.setAdapter(adapterCard);

        viewPagerCard.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }
            @Override
            public void onPageSelected(int i) {
                viewPager.setCurrentItem(i,true);
            }

            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                viewPagerCard.setCurrentItem(i,true);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        viewPagerCard.setCurrentItem(0);
    }

    public void showList(List<OperationWithDebtors> list){
        loadCardView(list);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

      /*  if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

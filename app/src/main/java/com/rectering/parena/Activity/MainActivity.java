package com.rectering.parena.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.rectering.parena.Adapter.TrendsAdapter;
import com.rectering.parena.Domain.TrendSDomain;
import com.rectering.parena.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapterTrendsList;
    private RecyclerView recyclerViewTrends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
        ButtomNavigation();
    }

    private void ButtomNavigation() {
        LinearLayout profileBtn = findViewById(R.id.profileBtn);
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            }
        });
    }

    private void initRecyclerView() {
        ArrayList<TrendSDomain> items = new ArrayList<>();

        items.add(new TrendSDomain("Future in AI, What will tomorrow be like? ", "The National", "trends"));
        items.add(new TrendSDomain("Important points in concluding a work contract", "Reuters", "trends2"));
        items.add(new TrendSDomain("Important points in concluding a work contract", "Reuters", "trends"));

        recyclerViewTrends = findViewById(R.id.view1);
        recyclerViewTrends.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));

        adapterTrendsList = new TrendsAdapter(items);
        recyclerViewTrends.setAdapter(adapterTrendsList);
    }
}
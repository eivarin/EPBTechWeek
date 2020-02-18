package com.epb.techtech.ui.dashboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.epb.techtech.R;
import com.epb.techtech.RecyclerViewAdapter;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private static final String TAG = "DashboardFragment";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImagesUrls = new ArrayList<>();

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });

        final RecyclerView Rec = root.findViewById(R.id.recyclerv_view);

        initImageBitmaps();
        initRecyclerView(root);
        return root;
    }


    private void initImageBitmaps() {

        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImagesUrls.add("https://www.epb.pt/img/logo@2x.png");
        mNames.add("Segunda-Feira");

        mImagesUrls.add("https://www.epb.pt/img/logo@2x.png");
        mNames.add("Terça-Feira");

        mImagesUrls.add("https://www.epb.pt/img/logo@2x.png");
        mNames.add("Quarta-Feira");

        mImagesUrls.add("https://www.epb.pt/img/logo@2x.png");
        mNames.add("Quinta-Feira");

        mImagesUrls.add("https://www.epb.pt/img/logo@2x.png");
        mNames.add("Sexta-Feira");


    }

    private RecyclerView initRecyclerView(View vista) {

        Log.d(TAG, "initRecyclerView: int recyclerview.");
        RecyclerView recyclerView = vista.findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity(), mNames, mImagesUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return recyclerView;
    }
}
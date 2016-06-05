package com.drunkpiano.allaboutthejune;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final RecyclerView mRecyclerView;
        MainAdapter mMainAdapter;

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.rv_main);
        MainAdapter guideAdapter = new MainAdapter(getContext());
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);
        mRecyclerView.setAdapter(guideAdapter);
        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fab);


        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        //        mRecyclerView.setHasFixedSize(true);
        mMainAdapter = new MainAdapter(getContext());
        mRecyclerView.setAdapter(mMainAdapter);
        mMainAdapter.setOuterItemOnClickListener(new ItemOnClickListener() {
            @Override
            public void onMainItemClick(int position) {
                if (null != getView())
                    Snackbar.make(getView(), "position " + position + " clicked", Snackbar.LENGTH_SHORT).show();
            }
        });

        if (null != fab)
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mRecyclerView.smoothScrollToPosition(0);
                    if (getView() != null)
                        Snackbar.make(getView(), "let's go to top", Snackbar.LENGTH_SHORT).show();
                }
            });
        return v;
    }
}

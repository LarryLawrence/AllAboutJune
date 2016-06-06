/*
 * The fragment to holder the recyclerView.
 * @author DrunkPiano
 * @version 1.0
 * Modifying History:
 * Modifier: DrunkPiano, June 5th 2016, fixed to accord it with the standard coding disciplines.
 */

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
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv_main);
        MainAdapter guideAdapter = new MainAdapter(getContext());
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);

        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);
        mRecyclerView.setAdapter(guideAdapter);

        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        //        mRecyclerView.setHasFixedSize(true);
        mMainAdapter = new MainAdapter(getContext());
        mRecyclerView.setAdapter(mMainAdapter);
        mMainAdapter.setOuterItemOnClickListener(new ItemOnClickListener() {
            @Override
            public void onMainItemClick(int position) {
                if (null != getView())
                    getFragmentManager().beginTransaction()
                            .replace(R.id.container_main, new NewPageFragment())
                            .addToBackStack(null).commit();
                if (null != getView())
                    Snackbar.make(getView(), "position " + position
                            + " clicked", Snackbar.LENGTH_SHORT).show();
            }
        });

        if (null != fab)
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mRecyclerView.smoothScrollToPosition(0);
                    if (getView() != null)
                        Snackbar.make(getView(), "let's get to top", Snackbar.LENGTH_SHORT).show();
                }
            });
        return rootView;
    }
}

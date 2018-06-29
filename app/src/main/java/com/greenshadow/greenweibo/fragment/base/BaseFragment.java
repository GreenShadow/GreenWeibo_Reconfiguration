package com.greenshadow.greenweibo.fragment.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.greenshadow.greenweibo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.refresh) SwipeRefreshLayout mRefreshLayout;
    @BindView(R.id.list) RecyclerView mList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_refreshable_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(view);
        initInternal();
    }

    private void initInternal() {
        mRefreshLayout.setOnRefreshListener(this);
        mList.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        mList.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onRefresh() {
    }

    protected abstract void onListRefresh();

    protected abstract void onLoadMore();
}

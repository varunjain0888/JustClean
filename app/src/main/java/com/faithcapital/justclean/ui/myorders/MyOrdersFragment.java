package com.faithcapital.justclean.ui.myorders;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.faithcapital.justclean.R;
import com.faithcapital.justclean.data.network.model.Items;
import com.faithcapital.justclean.data.network.model.MyOrdersList;
import com.faithcapital.justclean.ui.base.BaseFragment;
import com.faithcapital.justclean.ui.myorders.adapters.MyOrdersListAdapter;
import com.faithcapital.justclean.util.NetworkUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Varun on 2/22/17.
 */

public class MyOrdersFragment extends BaseFragment implements MyOrdersMvpView {

    public static final String TAG = "MyOrdersFragment";

    @Inject
    MyOrdersMvpPresenter<MyOrdersMvpView> mPresenter;

    @BindView(R.id.rvList)
    RecyclerView rvList;

    public static MyOrdersFragment newInstance() {
        Bundle args = new Bundle();
        MyOrdersFragment fragment = new MyOrdersFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_orders, container, false);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this, view));

        mPresenter.onAttach(this);

        setUp(view);

        if(NetworkUtils.isNetworkConnected(getContext())){
            mPresenter.getServerData();
        }else{
            mPresenter.getLocalData();
        }

        return view;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        getBaseActivity().onFragmentAttached();
    }

    @Override
    protected void setUp(View view) {

        LinearLayoutManager manager = new LinearLayoutManager(getBaseActivity());

        rvList.setLayoutManager(manager);

    }

    @Override
    public void setAdapter(List<MyOrdersList> myOrdersLists, ArrayList<Items>itemsArrayList) {

        rvList.setAdapter(new MyOrdersListAdapter(getBaseActivity(), myOrdersLists,itemsArrayList));

    }


    @Override
    public void onDestroyView() {

        mPresenter.onDetach();

        super.onDestroyView();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getBaseActivity().onFragmentDetached("MyOrdersFragment");
    }

}

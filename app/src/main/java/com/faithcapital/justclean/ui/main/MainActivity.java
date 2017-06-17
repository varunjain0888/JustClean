package com.faithcapital.justclean.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.faithcapital.justclean.BuildConfig;
import com.faithcapital.justclean.R;
import com.faithcapital.justclean.R2;
import com.faithcapital.justclean.custom.RoundedImageView;
import com.faithcapital.justclean.data.network.model.Items;
import com.faithcapital.justclean.data.network.model.MyOrdersList;
import com.faithcapital.justclean.ui.base.BaseActivity;
import com.faithcapital.justclean.ui.myorders.MyOrdersDetailFragment;
import com.faithcapital.justclean.ui.myorders.MyOrdersFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Varun on 2/12/17.
 */

public class MainActivity extends BaseActivity implements MainMvpView{

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.drawer_view)
    DrawerLayout mDrawer;

    @BindView(R2.id.navigation_view)
    NavigationView mNavigationView;

    @BindView(R2.id.tv_app_version)
    TextView mAppVersionTextView;

    @BindView(R.id.tvScreenTittle)
    TextView tvScreenTittle;

    @BindView(R.id.container)
    FrameLayout container;

    @Inject
    public MainMvpPresenter<MainMvpView> mPresenter;

    private ActionBarDrawerToggle mDrawerToggle;

    private TextView mNameTextView;

    private TextView mEmailTextView;

    private ImageView mProfileImageView;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        setUp();

    }

    @Override
    protected void setUp() {
        setSupportActionBar(mToolbar);

        tvScreenTittle.setText("My Orders");

        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawer,
                mToolbar,
                R.string.open_drawer,
                R.string.close_drawer) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                hideKeyboard();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawer.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        setupNavMenu();

        mPresenter.OpenMyOrdersFragment();
    }

    void setupNavMenu() {
        View headerLayout = mNavigationView.getHeaderView(0);
        mProfileImageView = (ImageView) headerLayout.findViewById(R.id.iv_profile_pic);
        mNameTextView = (TextView) headerLayout.findViewById(R.id.tv_name);
        mEmailTextView = (TextView) headerLayout.findViewById(R.id.tv_email);

        String version = "version " + BuildConfig.VERSION_NAME;
        mAppVersionTextView.setText(version);

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawer.closeDrawer(GravityCompat.START);
                switch (item.getItemId()) {
                    case R.id.nav_item_about:
                        return true;
                    case R.id.nav_item_logout:
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }

    @Override
    public void loadDataInAdapter(List<MyOrdersList> myOrdersList) {

    }

    @Override
    public void showMyOrdersFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                .add(R.id.container, MyOrdersFragment.newInstance(), MyOrdersFragment.TAG)
                .commit();
    }

    @Override
    public void showMyOrderDetailFragment(ArrayList<Items> feedList,String status) {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                .add(R.id.container, MyOrdersDetailFragment.newInstance(feedList,status), MyOrdersDetailFragment.TAG)
                .addToBackStack(MyOrdersDetailFragment.TAG)
                .commit();
    }

    @Override
    public void setUserDetails(String userName , String userId) {
        mNameTextView.setText(userName);
        mEmailTextView.setText(userId);
    }
}

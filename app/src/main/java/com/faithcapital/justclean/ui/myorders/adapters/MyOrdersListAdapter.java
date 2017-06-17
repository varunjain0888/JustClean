package com.faithcapital.justclean.ui.myorders.adapters;

import android.content.Context;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.faithcapital.justclean.R;
import com.faithcapital.justclean.data.db.model.MyOrders;
import com.faithcapital.justclean.data.network.model.Items;
import com.faithcapital.justclean.data.network.model.MyOrdersList;
import com.faithcapital.justclean.data.network.model.OrderDetails;
import com.faithcapital.justclean.ui.main.MainActivity;
import com.faithcapital.justclean.ui.myorders.MyOrdersFragment;


import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Varun on 2/11/17.
 */

public class MyOrdersListAdapter extends RecyclerView.Adapter {

    private List<MyOrdersList> feedList;

    private Context context;

    private int page = 0;

    private Timer timer;

    private TimerTask timerTask;

    private ArrayList<Items>itemsArrayList;

    public MyOrdersListAdapter(Context context, List<MyOrdersList> feedList, ArrayList<Items> itemsArrayList) {
        this.feedList = feedList;
        this.context = context;
        this.itemsArrayList=itemsArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = null;
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        v = inflater.inflate(R.layout.completed_orders, parent, false);
        viewHolder = new CompletedOrdersHolder(v);

        /*
            IN CASE WE WANT TO ADD DIFFERENT KINDS
            OF VIEWS WE CAN USE THIS APPORACH
        */

        /*switch (viewType) {
            case 0:
                v = inflater.inflate(R.layout.completed_orders, parent, false);
                viewHolder = new CompletedOrdersHolder(v);
                break;
            case 1:
                v = inflater.inflate(R.layout.pending_orders, parent, false);
                viewHolder = new PendingOrdersHolder(v);
                break;
            case 2:
                v = inflater.inflate(R.layout.cancelled_orders, parent, false);
                viewHolder = new CancelledOrdersHolder(v);
                break;
        }*/
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

          setCompletedOrdersView((CompletedOrdersHolder) holder,position);

         /*
            IN CASE WE WANT TO ADD DIFFERENT KINDS
            OF VIEWS WE CAN USE THIS APPORACH
        */

        /*switch (holder.getItemViewType()) {

            case 0:
                setCompletedOrdersView((CompletedOrdersHolder) holder,position);
                break;

            case 1:
                setPendingOrdersView((PendingOrdersHolder) holder,position);
                break;

            case 2:
                setCancelledOrdersView((CancelledOrdersHolder) holder,position);
                break;
        }*/
    }

    private void setCompletedOrdersView(CompletedOrdersHolder videoholder, final int pos) {
        OrderDetails orderDetails = null;
        if(feedList!=null && feedList.size()>0){
            orderDetails = feedList.get(pos).getOrderDetails();
        }
        if(orderDetails!=null){
            if(!TextUtils.isEmpty(orderDetails.getOrderDeliveryDate())){
                videoholder.tvDeliveryDate.setText(orderDetails.getOrderDeliveryDate());
            }
            if(!TextUtils.isEmpty(orderDetails.getOrderAcceptedBy())){
                videoholder.tvLaundaryName.setText(orderDetails.getOrderAcceptedBy());
            }
            if(!TextUtils.isEmpty(orderDetails.getOrderDateAdded())){
                videoholder.tvOrderDate.setText(orderDetails.getOrderDateAdded());
            }
            if(!TextUtils.isEmpty(orderDetails.getOrderPickUpDate())){
                videoholder.tvPickupDate.setText(orderDetails.getOrderPickUpDate());
            }
            if(!TextUtils.isEmpty(orderDetails.getPaymentStatus())){
                videoholder.tvPaymentMode.setText(orderDetails.getPaymentStatus());
            }
            if(!TextUtils.isEmpty(feedList.get(pos).getOrderId())){
                videoholder.tvOrderId.setText(feedList.get(pos).getOrderId());
            }
            if(!TextUtils.isEmpty(orderDetails.getStatus())){
                videoholder.tvOrderStatus.setText(orderDetails.getStatus());
            }
        }
        final OrderDetails finalOrderDetails = orderDetails;
        videoholder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itemsArrayList!=null && itemsArrayList.size()>0){
                    ArrayList<Items> itemses = new ArrayList<Items>();
                    for (int i = 0; i < itemsArrayList.size(); i++) {
                        if(itemsArrayList.get(i).orderid.equalsIgnoreCase(feedList.get(pos).getOrderId())){
                            Items items = new Items();
                            items.orderid = itemsArrayList.get(i).orderid;
                            items.setItemQty(itemsArrayList.get(i).getItemQty());
                            items.setItemTask(itemsArrayList.get(i).getItemTask());
                            items.setItemPrice(itemsArrayList.get(i).getItemPrice());
                            items.setItemId(itemsArrayList.get(i).getItemId());
                            items.setItemName(itemsArrayList.get(i).getItemName());
                            itemses.add(items);
                        }
                    }
                    ((MainActivity)context).mPresenter.openMyOrderDetailFragment(itemses, finalOrderDetails.getStatus());
                }else{
                    ((MainActivity)context).mPresenter.openMyOrderDetailFragment(feedList.get(pos).getOrderDetails().getItems(),finalOrderDetails.getStatus());
                }

            }
        });
    }

    private void setPendingOrdersView(PendingOrdersHolder audioHolder,int pos) {
    }

    private void setCancelledOrdersView(final CancelledOrdersHolder photoHolder,int pos) {
    }

    @Override
    public int getItemCount() {
        return feedList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return 0;
        } else if (position % 3 == 0) {
            return 1;
        } else {
            return 2;
        }
    }

    public class CompletedOrdersHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvOrderId)
        TextView tvOrderId;

        @BindView(R.id.tvOrderDate)
        TextView tvOrderDate;

        @BindView(R.id.tvLaundaryName)
        TextView tvLaundaryName;

        @BindView(R.id.tvPickupDate)
        TextView tvPickupDate;

        @BindView(R.id.tvDeliveryDate)
        TextView tvDeliveryDate;

        @BindView(R.id.tvPaymentMode)
        TextView tvPaymentMode;

        @BindView(R.id.tvOrderStatus)
        TextView tvOrderStatus;

        @BindView(R.id.cardview)
        CardView cardview;

        public CompletedOrdersHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }



    public class PendingOrdersHolder extends RecyclerView.ViewHolder {
        public PendingOrdersHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class CancelledOrdersHolder extends RecyclerView.ViewHolder {
        public CancelledOrdersHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

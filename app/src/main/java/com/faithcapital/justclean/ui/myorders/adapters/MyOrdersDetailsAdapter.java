package com.faithcapital.justclean.ui.myorders.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.faithcapital.justclean.R;
import com.faithcapital.justclean.data.network.model.Items;
import com.faithcapital.justclean.data.network.model.MyOrdersList;
import com.faithcapital.justclean.data.network.model.OrderDetails;
import com.faithcapital.justclean.ui.main.MainActivity;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Varun on 2/11/17.
 */

public class MyOrdersDetailsAdapter extends RecyclerView.Adapter {

    private List<Items> feedList;

    private Context context;

    private int page = 0;

    private Timer timer;

    private TimerTask timerTask;

    public MyOrdersDetailsAdapter(Context context, List<Items> feedList) {
        this.feedList = feedList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = null;
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        v = inflater.inflate(R.layout.order_items, parent, false);
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
        Items itemDetails = null;
        if(feedList!=null && feedList.size()>0){
            itemDetails = feedList.get(pos);
        }
        if(itemDetails!=null){
            if(!TextUtils.isEmpty(itemDetails.getItemId())){
                videoholder.tvItemId.setText(itemDetails.getItemId());
            }
            if(!TextUtils.isEmpty(itemDetails.getItemName())){
                videoholder.tvItemName.setText(itemDetails.getItemName());
            }
            if(!TextUtils.isEmpty(itemDetails.getItemTask())){
                videoholder.tvItemTask.setText(itemDetails.getItemTask());
            }
            if(itemDetails.getItemPrice()!=0){
                videoholder.tvItemPrice.setText(""+itemDetails.getItemPrice());
            }
            if(itemDetails.getItemQty()!=0){
                videoholder.tvItemQty.setText(""+itemDetails.getItemQty());
            }
        }

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

        @BindView(R.id.tvItemId)
        TextView tvItemId;

        @BindView(R.id.tvItemQty)
        TextView tvItemQty;

        @BindView(R.id.tvItemPrice)
        TextView tvItemPrice;

        @BindView(R.id.tvItemTask)
        TextView tvItemTask;

        @BindView(R.id.tvItemName)
        TextView tvItemName;

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

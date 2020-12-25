
package com.example.proximityserviceapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proximityserviceapp.R;
import com.example.proximityserviceapp.model.ServiceCard;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ServiceRecyclerAdapter extends RecyclerView.Adapter<ServiceRecyclerAdapter._ViewHolder> {

    Context mContext;
    private List<ServiceCard> mData;
    private ServicesItemClickListener servicesItemClickListener;

    public ServiceRecyclerAdapter(Context mContext, List<ServiceCard> mData, ServicesItemClickListener listener) {
        this.mContext = mContext;
        this.mData = mData;
        this.servicesItemClickListener = listener;
    }

    @NonNull
    @Override
    public _ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_card,viewGroup,false);
        return new _ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final _ViewHolder viewHolder, final int i) {
        viewHolder.mItem = mData.get(i);
        final int pos = viewHolder.getAdapterPosition();
        viewHolder.itemView.setTag(pos);

        viewHolder.setPostImage(mData.get(i));
        viewHolder.service.setText(mData.get(i).getserviceTitle());
        viewHolder.quantity_services.setText(mData.get(i).getQuantityservices());

        if (i%2==1){

            int dimenTopPixeles = getDimensionValuePixels(21);
            int dimenleftPixeles = getDimensionValuePixels(8);
            ViewGroup.MarginLayoutParams cardViewMarginParams = (ViewGroup.MarginLayoutParams) viewHolder.card_item.getLayoutParams();
            cardViewMarginParams.setMargins(dimenleftPixeles, dimenTopPixeles, 0, 0);
            viewHolder.card_item.requestLayout();
        }

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                servicesItemClickListener.onDashboardserviceClick(mData.get(i), viewHolder.imageView);
            }
        });
    }

    public int getDimensionValuePixels(int dimension)
    {
        return (int) mContext.getResources().getDimension(dimension);
    }


    public int dpToPx(int dp)
    {
        float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }


    @Override
    public long getItemId(int position) {
        ServiceCard serviceCard = mData.get(position);
        return serviceCard.getId();
    }
    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class _ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView service;
        TextView quantity_services;
        CardView card_item;
        public ServiceCard mItem;
        public _ViewHolder(@NonNull View itemView) {
            super(itemView);
            card_item = itemView.findViewById(R.id.card_item);
            imageView = itemView.findViewById(R.id.card_view_image);
            service = itemView.findViewById(R.id.stag_item_service);
            quantity_services = itemView.findViewById(R.id.stag_item_quantity_service);
        }

        void setPostImage(ServiceCard serviceCard){
            imageView.setImageResource(serviceCard.getImageservice());
        }
    }
}


package com.example.proximityserviceapp.adapter;

import android.widget.ImageView;

import com.example.proximityserviceapp.model.ServiceCard;

public interface ServicesItemClickListener {

    void onDashboardserviceClick(ServiceCard serviceCard, ImageView imageView); // Shoud use imageview to make the shared animation between the two activity

}

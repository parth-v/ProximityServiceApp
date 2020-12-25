package com.example.proximityserviceapp;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proximityserviceapp.adapter.ServiceRecyclerAdapter;
import com.example.proximityserviceapp.adapter.ServicesItemClickListener;
import com.example.proximityserviceapp.model.ServiceCard;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class ServiceList extends AppCompatActivity implements ServicesItemClickListener {
    private ServiceRecyclerAdapter adapter;
    private RecyclerView recyclerView;
    private List<ServiceCard> serviceCards;
    private EditText edt_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_service_list);

        edt_search = findViewById(R.id.edt_search);
        edt_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    performSearch();

                    Toast.makeText(ServiceList.this,
                            "You Searched: " + edt_search.getText().toString().trim(),
                            Toast.LENGTH_SHORT).show();

                    return true;
                }
                return false;
            }
        });

        recyclerView = findViewById(R.id.rv_courses);

        recyclerView.setLayoutManager(
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        );
        recyclerView.setClipToPadding(false);
        recyclerView.setHasFixedSize(true);

        serviceCards = new ArrayList<>();

        serviceCards.add(new ServiceCard(1,R.drawable.course_design_thinking, "Plumber", "9 options"));
        serviceCards.add(new ServiceCard(2,R.drawable.course_design_thinking, "Home Salon", "10 options"));
        serviceCards.add(new ServiceCard(3,R.drawable.course_design_thinking, "Electrician", "6 options"));
        serviceCards.add(new ServiceCard(4,R.drawable.course_design_thinking, "Carpenter", "7 options"));
        serviceCards.add(new ServiceCard(5,R.drawable.course_design_thinking, "Painter", "8 options"));
        serviceCards.add(new ServiceCard(6,R.drawable.course_design_thinking, "Haircut at home", "10 options"));

        adapter = new ServiceRecyclerAdapter(this, serviceCards, this);
        recyclerView.setAdapter(adapter);
    }

    private void performSearch() {
        edt_search.clearFocus();
        InputMethodManager in = (InputMethodManager) ServiceList.this.getSystemService(Context.INPUT_METHOD_SERVICE);
        in.hideSoftInputFromWindow(edt_search.getWindowToken(), 0);
    }

    @Override
    public void onDashboardserviceClick(ServiceCard serviceCard, ImageView imageView) {

        Toast.makeText(this, serviceCard.getserviceTitle(), Toast.LENGTH_LONG).show();

    }

    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private int space;

        public SpacesItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view,
                                   RecyclerView parent, RecyclerView.State state) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;

            if (parent.getChildLayoutPosition(view) == 0) {
                outRect.top = space;
            } else {
                outRect.top = 0;
            }
        }
    }
}

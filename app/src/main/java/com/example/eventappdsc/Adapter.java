package com.example.eventappdsc;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class Adapter extends PagerAdapter {

    private List<Model> models;
    private LayoutInflater layoutInflater;
    private Context context;

    public Adapter(List<Model> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = layoutInflater.from(context);
        final View view  = layoutInflater.inflate(R.layout.item,container,false);

        ImageView imageView;
        final TextView eventTitle, eventDesc;
        Button eventBtn;



        imageView = view.findViewById(R.id.image);
        eventTitle = view.findViewById(R.id.title);
        eventDesc = view.findViewById(R.id.desc);
       /* eventBtn = view.findViewById(R.id.Eventbtn);*/

        imageView.setImageResource(models.get(position).getImage());
        eventTitle.setText(models.get(position).getTitle());
        eventDesc.setText(models.get(position).getDesc());

   /*     eventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.this, EventActivity.class);
                context.startActivity(intent);
            }
        });*/

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("TAG", "This page was clicked :"+position);
                    Intent intent = new Intent(context, EventActivity.class);
                    intent.putExtra("position", position);
                    /*intent.putExtra("eventTitle", (CharSequence) eventTitle);
                    intent.putExtra("eventDesc", (Parcelable) eventDesc);*/
                    context.startActivity(intent);
                }
            });

        container.addView(view,0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
      container.removeView((View)object);
    }
}

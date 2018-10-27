package com.qamber.carpiker.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qamber.carpiker.Model.Modelcountry;
import com.qamber.carpiker.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MAHAR on 30-Dec-17.
 */

public class AdapterCountry extends RecyclerView.Adapter<AdapterCountry.MyViewHolder> implements View.OnClickListener{

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_flage,iv_check;

        public TextView tv_country;
        RelativeLayout re_select;

        public MyViewHolder(View view) {
            super(view);



            iv_flage = (ImageView)view.findViewById(R.id.iv_flag);
            iv_check = (ImageView)view.findViewById(R.id.iv_check);
            tv_country  = (TextView) view.findViewById(R.id.tv_country);
            re_select = (RelativeLayout) view.findViewById(R.id.rl_check);
          /*  tv_user_notifiations  = (TextView) view.findViewById(R.id.tv_user_notifiations);
            tv_user_name = (TextView) view.findViewById(R.id.tv_user_name);
            tv_user_status = (TextView) view.findViewById(R.id.tv_user_status);
            iv_Image = (ImageView)view.findViewById(R.id.iv_image);*/
        }
    }
    private Context mContext;
    private ArrayList<Modelcountry> arrayList;

    public AdapterCountry(Context mContext, ArrayList<Modelcountry> arrayList) {
        this.mContext = mContext;
        this.arrayList = arrayList;

    }

    @Override
    public AdapterCountry.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_layout_country, parent, false);
        return new AdapterCountry.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final AdapterCountry.MyViewHolder holder, final int position) {

String fgdh=arrayList.get(position).getCountryname();
        holder.tv_country.setText(arrayList.get(position).getCountryname());
        holder.re_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               holder. iv_check.setVisibility(View.VISIBLE);
            }
        });
        //  holder.tv_user_status.setText(arrayList.get(position).getDate());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public void onClick(View v) {
        //tv_count.setText(count);


    }

    void songcall(){

        // intent.putExtra(AppConstants.KEY_INTENT_CAT_NAME, getStringFromIntent(getIntent().getExtras(),KEY_INTENT_CAT_NAME));


    }

}

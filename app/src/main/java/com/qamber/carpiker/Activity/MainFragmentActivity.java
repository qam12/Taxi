package com.qamber.carpiker.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qamber.carpiker.R;
import com.qamber.carpiker.Utilities.MyAppCompatActivity;
import com.qamber.carpiker.Utilities.RecyclerTouchListener;
import com.qamber.carpiker.fragment.EditCarInfo;
import com.qamber.carpiker.fragment.Notifications;
import com.qamber.carpiker.fragment.Settings;
import com.qamber.carpiker.fragment.TermsandConditions;
import com.qamber.carpiker.fragment.Transactions;

import java.util.ArrayList;
import java.util.List;

public class MainFragmentActivity extends MyAppCompatActivity {
    DrawerLayout drawer;
    ArrayList<ModelDrawe> arrayList=new ArrayList<>();
    RecyclerView lv;
    int[] img={R.drawable.ride,R.drawable.ride,R.drawable.ride,
            R.drawable.ride,R.drawable.ride,R.drawable.ride,
            R.drawable.ride};
    TextView tvMainFragment,iv_save;

    ImageView iv_search,iv_filter, iv_close,iv_drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment);

        drawer=(DrawerLayout)findViewById(R.id.drw) ;
        tvMainFragment=(TextView)findViewById(R.id.tv_title) ;

      /*  iv_search=(ImageView)findViewById(R.id.iv_search);
        iv_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //drawer.closeDrawer(GravityCompat.START);
            }
        });*/

        iv_filter=(ImageView)findViewById(R.id.iv_filter);

       /* iv_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainFragmentActivity.this,FilterScreen.class);
                startActivity(intent);
                //drawer.closeDrawer(GravityCompat.START);
            }
        });*/
        iv_save=(TextView)findViewById(R.id.iv_save);
        iv_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // drawer.closeDrawer(GravityCompat.START);
            }
        });

        iv_close=(ImageView)findViewById(R.id.img_close_r);
        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.closeDrawer(GravityCompat.START);
            }
        });

        iv_drawer=(ImageView)findViewById(R.id.iv_drawer);
        iv_drawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.START);
            }
        });
        //selectitme(0);
        Fragment fragment=null;

        fragment =new Notifications();

        FragmentManager frgManager = getSupportFragmentManager();

        // frgManager.beginTransaction().addToBackStack(null).replace(R.id.content_frame, fragment)
        //         .commit();
        frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                .commitAllowingStateLoss();
        tvMainFragment.setVisibility(View.VISIBLE);
        //  spn.setVisibility(View.VISIBLE);
        //  tbMainFragment.setVisibility(View.VISIBLE);
        tvMainFragment.setText("Your rides");

        iv_filter.setVisibility(View.VISIBLE);
        iv_save.setVisibility(View.GONE);
        lv = (RecyclerView) findViewById(R.id.menuList);

        arrayList.add(new ModelDrawe(this,"Notifications",""));
        arrayList.add(new ModelDrawe(this,"Transactions",""));
        arrayList.add(new ModelDrawe(this,"Edit Car Info",""));
        arrayList.add(new ModelDrawe(this,"Terms and Conditions",""));
        arrayList.add(new ModelDrawe(this,"Pivacy Policy",""));
        arrayList.add(new ModelDrawe(this,"Settings",""));
        arrayList.add(new ModelDrawe(this,"Logout",""));





        DrawerAdapter adapter = new DrawerAdapter(this,arrayList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this,1);
        lv.setLayoutManager(mLayoutManager);
        lv.setItemAnimator(new DefaultItemAnimator());

        // lv.setFooterDividersEnabled(false);
        lv.setAdapter(adapter);
        lv.addOnItemTouchListener(new RecyclerTouchListener(MainFragmentActivity.this,lv,new RecyclerTouchListener.OnItemClickListener(){

            @Override
            public void onItemClick(View view, int position) {

                selectitme(position);
            }

            @Override
            public void onLongItemClick(View view, int position) {



            }
        }));





        drawer.closeDrawer(GravityCompat.START);




    }
    public  void selectitme(int position){

        Fragment fragment = null;
        switch (position){

            case 0:
       /*     tvMainFragment.setVisibility(View.VISIBLE);
            //  spn.setVisibility(View.VISIBLE);
            //  tbMainFragment.setVisibility(View.VISIBLE);
            tvMainFragment.setText(getResources().getString(R.string.mainfragment_drawer_home));

            iv_filter.setVisibility(View.VISIBLE);
            iv_save.setVisibility(View.GONE);
            fragment=new Home();*/
                tvMainFragment.setText("Notifications");
                Intent intent=new Intent(MainFragmentActivity.this,MainFragmentActivity.class);
                startActivity(intent);
                finish();
                // tbMainFragment.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorRed)));
                // iv_search.setVisibility(View.VISIBLE);



                break;
            case 1:

                tvMainFragment.setText("Transactions");
                iv_filter.setVisibility(View.GONE);
                iv_save.setVisibility(View.GONE);
                fragment=new Transactions();

                break;
            case 2:
                tvMainFragment.setText("Edit Car Info");

                iv_filter.setVisibility(View.GONE);
                iv_save.setVisibility(View.GONE);
                fragment=new EditCarInfo();
                break;
            case 3:
                //  SelectItem(3);
                      /*  SessionManager sessionManager=new SessionManager(MainFragmentActivity.this,"","",false,"","","");
                        Intent intent=new Intent(MainFragmentActivity.this,Login.class);
                        startActivity(intent);
                        finish();
                        tbMainFragment.setVisibility(View.VISIBLE);*/
                tvMainFragment.setText("Terms and Conditions");

                iv_filter.setVisibility(View.GONE);
                iv_save.setVisibility(View.GONE);
                fragment=new TermsandConditions();

                break;
            case 4:
                //  SelectItem(3);
                      /*  SessionManager sessionManager=new SessionManager(MainFragmentActivity.this,"","",false,"","","");
                        Intent intent=new Intent(MainFragmentActivity.this,Login.class);
                        startActivity(intent);
                        finish();
                        tbMainFragment.setVisibility(View.VISIBLE);*/

                tvMainFragment.setText("Pivacy Policy");
                iv_filter.setVisibility(View.GONE);
                iv_save.setVisibility(View.VISIBLE);
                fragment=new Settings();

                break;
            case 5:

                tvMainFragment.setText("Settings");
                fragment=new Settings();
                break;
            case 6:
                tvMainFragment.setText("Logout");

                break;
            case 7:



                break;

        }


        if (fragment != null &&position<=7) {
            // fragment.setArguments(args);
            FragmentManager frgManager = getSupportFragmentManager();
            // frgManager.beginTransaction().addToBackStack(null).replace(R.id.content_frame, fragment)
            //         .commit();
            frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                    .commitAllowingStateLoss();

//            mDrawerList.setItemChecked(lastActiveFragment, true);
            // setTitle(dataList.get(possition).getItemName());

            drawer.closeDrawer(GravityCompat.START);
        }

    }

    class ModelDrawe{
        Context context;
        String tittle,count;

        public String getTittle() {
            return tittle;
        }

        public void setTittle(String tittle) {
            this.tittle = tittle;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public ModelDrawe(Context context, String tittle, String count) {
            this.context = context;
            this.tittle = tittle;
            this.count = count;
        }
    }



    public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.MyViewHolder> implements View.OnClickListener{
        public Typeface standardRoman;
        public Typeface standardRomanMedium;
        public Typeface standardRomanMediumCn;


        @Override
        public void onClick(View v) {

        }




        public class MyViewHolder extends RecyclerView.ViewHolder {

            public TextView tv_tittle,tv_count;
            public  ImageView iv_icon;

            public MyViewHolder(View view) {
                super(view);
                tv_tittle = (TextView) view.findViewById(R.id.tv_tittle);
                tv_count = (TextView) view.findViewById(R.id.tv_count);
                iv_icon = (ImageView) view.findViewById(R.id.iv_drawer_icon);


            }
        }
        private Context mContext;
        private ArrayList<ModelDrawe> arrayList=new ArrayList<>();
        int size = 0;
        List<String> list = new ArrayList<String>();
        int i=0;
        ArrayAdapter<String> adapter ;

        int[] img={R.drawable.ride,R.drawable.ride,R.drawable.ride,
                R.drawable.ride,R.drawable.ride,R.drawable.ride,
                R.drawable.ride};
        public DrawerAdapter(Context mContext, ArrayList<ModelDrawe> arrayList) {
            this.mContext = mContext;
            this.arrayList = arrayList;

        }


        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.right_navi_list, parent, false);




            return new DrawerAdapter.MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            //  for(int i=0;i<=arrayList.size()-1;i++) {
//            standardRoman           = Typeface.createFromAsset(mContext.getAssets(), "fonts/HelveticaNeueLTStd-Roman.otf");
//            standardRomanMedium     = Typeface.createFromAsset(mContext.getAssets(), "fonts/HelveticaNeueLTStd-Md.otf");
//            //      standardRomanMediumCn   = Typeface.createFromAsset(mContext.getAssets(), "fonts/HelveticaNeueLTStd-MdCn.otf");
            //   holder.tv_orderno.setTypeface(standardRomanMedium);;
            //   holder.tv_orderplaced.setTypeface(standardRoman);;

            holder.tv_tittle.setText(arrayList.get(position).getTittle());

            if(arrayList.get(position).getCount().equals("")){
                holder.tv_count.setVisibility(View.GONE);
                holder.tv_count.setText(arrayList.get(i).getCount());
            }

            else {

                holder.tv_count.setVisibility(View.VISIBLE);
            }
            holder.iv_icon.setImageResource(img[position]);

            //   i++;
            // Picasso.with(mContext).load(arrayList.get(position).getImage()).into(holder.ivType);
        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }


    }
}




package com.qamber.carpiker.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.qamber.carpiker.R;
import com.qamber.carpiker.Utilities.MyFragment;

/**
 * Created by MAHAR on 31-Dec-17.
 */

public class PivacyPolicy extends MyFragment {
    Context c;

    ImageView imageView;
    @Nullable
    @Override
    public void onBackPressed() {

    }

    @Override
    public void onAttach(Context context) {
        c=context;
        super.onAttach(context);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_privacy,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {


        super.onViewCreated(view, savedInstanceState);
    }
}




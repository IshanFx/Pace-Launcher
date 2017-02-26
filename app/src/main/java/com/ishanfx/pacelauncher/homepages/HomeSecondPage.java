package com.ishanfx.pacelauncher.homepages;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ishanfx.pacelauncher.R;

/**
 * Created by IshanFx on 2/26/2017.
 */

public class HomeSecondPage extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.layout_home_second_page, container, false);
        return rootView;
    }
}

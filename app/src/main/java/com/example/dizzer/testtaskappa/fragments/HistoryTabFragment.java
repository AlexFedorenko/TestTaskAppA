package com.example.dizzer.testtaskappa.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dizzer.testtaskappa.R;

/**
 * Created by Dizzer on 2/23/2018.
 */

public class HistoryTabFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.history_tab_fragment_layout,container,false);
        return view;
    }
}

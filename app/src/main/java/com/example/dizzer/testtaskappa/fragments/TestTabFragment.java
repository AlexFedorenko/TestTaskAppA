package com.example.dizzer.testtaskappa.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.dizzer.testtaskappa.R;
import com.example.dizzer.testtaskappa.constant.CustomConstant;

/**
 * Created by Dizzer on 2/23/2018.
 */

public class TestTabFragment extends Fragment implements View.OnClickListener {

    private Button buttonOk;
    private EditText edLink;

    private String linkAdress;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_tab_fragment_layout, container, false);
        buttonOk = view.findViewById(R.id.btn_ok_test_tab);
        edLink = view.findViewById(R.id.et_link_test_tab);
        buttonOk.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        linkAdress = edLink.getText().toString();
        Intent intent = new Intent("com.example.dizzer.testtaskprojectb.intent.filter.for.appA");
        intent.putExtra(CustomConstant.INTENT_CODE,CustomConstant.TEST_FRAGMENT);
        intent.putExtra(CustomConstant.INTENT_LINK,linkAdress);
        startActivity(intent);
    }
}

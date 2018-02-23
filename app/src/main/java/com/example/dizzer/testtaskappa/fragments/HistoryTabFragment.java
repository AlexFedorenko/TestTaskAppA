package com.example.dizzer.testtaskappa.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dizzer.testtaskappa.R;
import com.example.dizzer.testtaskappa.adapter.CustomRecyclerViewAdapter;
import com.example.dizzer.testtaskappa.model.LinkModel;

import java.util.ArrayList;
import java.util.List;

import static com.example.dizzer.testtaskappa.provider.CustomProvider.CONTENT_URI_IMAGES;

/**
 * Created by Dizzer on 2/23/2018.
 */

public class HistoryTabFragment extends Fragment {

    private CustomRecyclerViewAdapter mCustomRecyclerViewAdapter;
    private RecyclerView recyclerView;

    private List<LinkModel> linkModels;
    private Cursor cursor;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.history_tab_fragment_layout, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_history_tab);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        setRecyclerViewAdapter();
        return view;
    }

    private void setRecyclerViewAdapter() {
        mCustomRecyclerViewAdapter = new CustomRecyclerViewAdapter(getList());
        recyclerView.setAdapter(mCustomRecyclerViewAdapter);
    }

    public List<LinkModel> getList() {
        linkModels = new ArrayList<>();
        cursor = getActivity().getContentResolver().query(CONTENT_URI_IMAGES, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {

            do {
                long id = cursor.getLong(cursor.getColumnIndex("time"));
                String link = cursor.getString(cursor.getColumnIndex("link"));
                int status = cursor.getInt(cursor.getColumnIndex("status"));
                long time = cursor.getLong(cursor.getColumnIndex("time"));

                LinkModel linkModel = new LinkModel(id, link, status, time);
                linkModels.add(linkModel);

            } while (cursor.moveToNext());
            cursor.close();
        }

        return linkModels;
    }
}

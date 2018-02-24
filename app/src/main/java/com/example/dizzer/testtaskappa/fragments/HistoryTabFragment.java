package com.example.dizzer.testtaskappa.fragments;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dizzer.testtaskappa.R;
import com.example.dizzer.testtaskappa.adapter.CustomRecyclerViewAdapter;
import com.example.dizzer.testtaskappa.constant.CustomConstant;
import com.example.dizzer.testtaskappa.model.LinkModel;

import java.util.ArrayList;
import java.util.List;

import static com.example.dizzer.testtaskappa.provider.CustomProvider.CONTENT_URI_IMAGES;

/**
 * Created by Dizzer on 2/23/2018.
 */

public class HistoryTabFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>, CustomRecyclerViewAdapter.OnItemClickListener{

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

        getLoaderManager().initLoader(1, null, this);

        setRecyclerViewAdapter();
        return view;
    }

    private void setRecyclerViewAdapter() {
        mCustomRecyclerViewAdapter = new CustomRecyclerViewAdapter(getList(), this);
        recyclerView.setAdapter(mCustomRecyclerViewAdapter);
    }

    public List<LinkModel> getList() {
        linkModels = new ArrayList<>();
        cursor = getActivity().getContentResolver().query(CONTENT_URI_IMAGES, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {

            do {
                long id = cursor.getLong(cursor.getColumnIndex("_id"));
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

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getActivity(), CONTENT_URI_IMAGES, null, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        setRecyclerViewAdapter();
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    @Override
    public void onItemClick(int position) {
        String linkAddress = linkModels.get(position).getLink();
        int linkStatus = linkModels.get(position).getStatus();
        long id = linkModels.get(position).getLinkID();
        Intent intent = new Intent("com.example.dizzer.testtaskprojectb.intent.filter.for.appA");
        intent.putExtra(CustomConstant.INTENT_CODE,CustomConstant.HISTORY_FRAGMENT);
        intent.putExtra(CustomConstant.INTENT_LINK, linkAddress);
        intent.putExtra(CustomConstant.INTENT_STATUS, linkStatus);
        intent.putExtra(CustomConstant.INTENT_ID, id);
        startActivity(intent);
    }
}

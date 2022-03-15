package com.example.listview_example;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.listview_example.MainActivity;

import java.util.ArrayList;


public class ListFrag extends ListFragment {

    ItemSelected activity;
    public interface ItemSelected{
        void onItemSelected(int position);
    }
    public ListFrag() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (ItemSelected) context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //example without external data
       /* ArrayList<String> data = new ArrayList<>();
        data.add("This is Item 1");
        data.add("This is Item 2");
        data.add("This is Item 3");*/

       String data[];
       data = getResources().getStringArray(R.array.pieces);

        setListAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, data));
       /* activity.onItemSelected(0);*/
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        activity.onItemSelected(position);

    }
}
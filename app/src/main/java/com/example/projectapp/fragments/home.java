package com.example.projectapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectapp.R;
import com.example.projectapp.RecyclerAdapter.pAdapter;

public class home extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.home,container,false);
        RecyclerView recyclerView= view.findViewById(R.id.homerecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        String[] number={"JAVA Notes", "OS Notes","M1 Notes","M2 Notes","M3 Notes","DS Notes","DATA STRUCTURE","SAD Notes","CN-1 Notes","CN-2","JAVA Notes", "OS Notes","M1 Notes","M2 Notes","M3 Notes","DS Notes","DATA STRUCTURE","SAD Notes","CN-1 Notes","CN-2"};
        recyclerView.setAdapter(new pAdapter(number));
        return view;
    }

}

package com.example.e15gestitb;

import android.content.res.Resources;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;

public class MissedAttendanceListFragment extends Fragment {
    RecyclerView recyclerView;
    MissedAttendanceViewModel missedAttendanceViewModel;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        missedAttendanceViewModel = new ViewModelProvider(this).get(MissedAttendanceViewModel.class);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.missed_attendance_list_fragment, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        MissedAttendanceAdapter adapter = new MissedAttendanceAdapter(missedAttendanceViewModel.listOfModels);
        recyclerView.setAdapter(adapter);
         if (getArguments() != null)
            missedAttendanceViewModel = getArguments().getParcelable("missedAttendance");

        return view;
    }
}

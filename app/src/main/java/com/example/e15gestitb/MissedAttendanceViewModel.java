package com.example.e15gestitb;

import android.content.Context;
import android.content.res.Resources;

import androidx.lifecycle.ViewModel;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class MissedAttendanceViewModel extends ViewModel {
    MissedAttendanceListFragment missedAttendanceListFragment;
    List<MissedAttendanceModel> listOfModels = new ArrayList<MissedAttendanceModel>();

    public MissedAttendanceViewModel() {
        if (listOfModels.isEmpty()) {
            String[] modules = MainActivity.modules;
            for (int i = 1; i <= 100; i++) {
                MissedAttendanceModel missedAttendanceModel = new MissedAttendanceModel();
                missedAttendanceModel.setStudentName("Student " + i);
                missedAttendanceModel.moduleName = modules[new Random().nextInt(modules.length)];
                missedAttendanceModel.setDate(Calendar.getInstance().getTime());
                listOfModels.add(missedAttendanceModel);
                missedAttendanceModel.setJustified(i % 3 == 0);
            }

        }
    }
}

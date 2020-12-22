package com.example.e15gestitb;

import android.app.Dialog;
import android.content.DialogInterface;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MissedAttendanceFragment extends Fragment {
    EditText studentName;
    Button time;
    boolean isJustified;
    CheckBox justifiedCheckBox;
    static  Spinner modulesList;
    Button addButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.missed_attendance_fragment, container, false);
        studentName = view.findViewById(R.id.editTextTextPersonName);
        justifiedCheckBox = view.findViewById(R.id.checkBox);
        modulesList = view.findViewById(R.id.spinner);
        modulesList.setSelection(0);
        time = view.findViewById(R.id.button2);
        addButton = view.findViewById(R.id.addButton);
        time.setText(Calendar.getInstance().getTime().toString());
        isJustified = justifiedCheckBox.isActivated();
        justifiedCheckBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                isJustified = justifiedCheckBox.isActivated();
            }
        });


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                MissedAttendanceModel newStudent = new MissedAttendanceModel();
                newStudent.setStudentName(studentName.getText().toString());
                newStudent.setStudentName(modulesList.getSelectedItem().toString());
                newStudent.setJustified(isJustified);
                newStudent.setModuleName(modulesList.getSelectedItem().toString());
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage("Student info: " + newStudent.toString() )
                        .setTitle("Are you sure that you want to add this student?")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                NavDirections directions = MissedAttendanceFragmentDirections.actionMissedAttendanceFragmentToMissedAttendanceListFragment3();
                                Navigation.findNavController(v).navigate(directions);
                                studentName.setText("");
                                justifiedCheckBox.setChecked(false);
                                isJustified = justifiedCheckBox.isActivated();
                                modulesList.setSelection(0);
                                time.setText(Calendar.getInstance().getTime().toString());

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });
                final AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        return view;

    }


}

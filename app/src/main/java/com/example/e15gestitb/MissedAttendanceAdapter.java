package com.example.e15gestitb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public    class MissedAttendanceAdapter extends RecyclerView.Adapter<MissedAttendanceAdapter.MissedAttendanceViewHolder> {
  static    List<MissedAttendanceModel> missedAttendanceModels;

    public MissedAttendanceAdapter(List<MissedAttendanceModel> missedAttendanceModels) {
        this.missedAttendanceModels = missedAttendanceModels;
    }


    @NonNull
    @Override
    public MissedAttendanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View  v = LayoutInflater.from(parent.getContext()).inflate(R.layout.missed_attendance_list_item,parent,false);
        return new MissedAttendanceViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MissedAttendanceViewHolder holder, int position) {
     holder.bindData(missedAttendanceModels.get(position));
    }

    @Override
    public int getItemCount() {
        return missedAttendanceModels.size();
    }

    class MissedAttendanceViewHolder extends RecyclerView.ViewHolder {
        TextView studentNameText;
        TextView studentModuleText;
        TextView studentDateText;
        ImageView studentJustifiedText;

        public MissedAttendanceViewHolder(@NonNull final View itemView) {
            super(itemView);

            studentNameText = itemView.findViewById(R.id.studentName);
            studentModuleText = itemView.findViewById(R.id.module);
            studentDateText = itemView.findViewById(R.id.date);
            studentJustifiedText = itemView.findViewById(R.id.justified);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              NavDirections directions =MissedAttendanceListFragmentDirections.actionListToFragment(missedAttendanceModels.get(getAdapterPosition()));
              Navigation.findNavController(v).navigate(directions);
            }
        });
        }

        public void bindData(MissedAttendanceModel missedAttendanceModel) {
            studentNameText.setText(missedAttendanceModel.getStudentName());
            studentModuleText.setText(missedAttendanceModel.getModuleName());
            studentDateText.setText(missedAttendanceModel.getDate().toString());
            if (missedAttendanceModel.isJustified)
            studentJustifiedText.setImageResource(android.R.drawable.checkbox_on_background);
            else    studentJustifiedText.setImageResource(android.R.drawable.checkbox_off_background);;
        }
}
}

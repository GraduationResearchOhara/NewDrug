//package com.example.newdrug;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.TextView;
//
//import java.util.List;
//
//public class MedicationAdapter extends ArrayAdapter<Medication> {
//
//    private List<Medication> medicationList;
//
//    public MedicationAdapter(Context context, List<Medication> medications) {
//        super(context, 0, medications);
//        this.medicationList = medications;
//
//
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        if (convertView == null) {
//            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_medication, parent, false);
//        }
//
//        Medication medication = getItem(position);
//
//        TextView nameTextView = convertView.findViewById(R.id.medicationName);
//        TextView timeTextView = convertView.findViewById(R.id.medicationTime);
//        TextView noteTextView = convertView.findViewById(R.id.medicationNote);
//
//        if (medication != null) {
//            nameTextView.setText(medication.getName());
//            timeTextView.setText(medication.getTime());
//            noteTextView.setText(medication.getNote());
//        }
//
//        return convertView;
//
//
//    }
//}

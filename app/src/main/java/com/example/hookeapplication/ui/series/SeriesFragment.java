package com.example.hookeapplication.ui.series;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.hookeapplication.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

public class SeriesFragment extends Fragment {

    private TextInputEditText textInputEditTextconst;
    private MaterialTextView materialTextView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SeriesViewModel seriesViewModel = ViewModelProviders.of(this).get(SeriesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_series, container, false);
        final TextView textView = root.findViewById(R.id.title_series);
        textInputEditTextconst = root.findViewById(R.id.edt_constants_series);
        MaterialButton materialButton = root.findViewById(R.id.btn_calculate_series);
        materialTextView = root.findViewById(R.id.tv_hasil_series);
        materialButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (textInputEditTextconst.length() > 0) {
                    Double constants = Double.valueOf(textInputEditTextconst.getText().toString());
                    Double series = constants / 2;
                    String hasil = String.valueOf(series);
                    materialTextView.setText(hasil);
                }
                else {
                    materialTextView.setText("Input Cannot be Empty");
                }
            }
        });
        seriesViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
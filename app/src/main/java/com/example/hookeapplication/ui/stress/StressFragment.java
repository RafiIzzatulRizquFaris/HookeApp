package com.example.hookeapplication.ui.stress;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.hookeapplication.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

public class StressFragment extends Fragment {

    private TextInputEditText textInputEditTextluas, textInputEditTextgaya;
    private MaterialTextView materialTextView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        StressViewModel stressViewModel = ViewModelProviders.of(this).get(StressViewModel.class);
        View root = inflater.inflate(R.layout.fragment_stress, container, false);
        final MaterialTextView textView = root.findViewById(R.id.title_stress);
        textInputEditTextgaya = root.findViewById(R.id.edt_gaya_stress);
        textInputEditTextluas = root.findViewById(R.id.edt_luas_stress);
        MaterialButton materialButton = root.findViewById(R.id.btn_calculate_stress);
        materialTextView = root.findViewById(R.id.tv_hasil_stress);
        materialButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (textInputEditTextgaya.length() > 0 && textInputEditTextluas.length() > 0) {
                    Double gaya = Double.valueOf(textInputEditTextgaya.getText().toString());
                    Double luas = Double.valueOf(textInputEditTextluas.getText().toString());
                    Double stress = gaya / luas;
                    String hasil = String.valueOf(stress);
                    materialTextView.setText(hasil+" N/ m2");
                }
                else {
                    materialTextView.setText("Input Cannot be Empty");
                }
            }
        });


        stressViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
package com.example.hookeapplication.ui.strain;

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

public class StrainFragment extends Fragment {

    private TextInputEditText textInputEditTextpertambahan, textInputEditTextpanjang;
    private MaterialTextView materialTextView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        StrainViewModel strainViewModel = ViewModelProviders.of(this).get(StrainViewModel.class);
        View root = inflater.inflate(R.layout.fragment_strain, container, false);
        final MaterialTextView textView = root.findViewById(R.id.title_strain);
        textInputEditTextpertambahan = root.findViewById(R.id.edt_pertambahan_strain);
        textInputEditTextpanjang = root.findViewById(R.id.edt_panjang_strain);
        MaterialButton materialButton = root.findViewById(R.id.btn_calculate_strain);
        materialTextView = root.findViewById(R.id.tv_hasil_strain);
        materialButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (textInputEditTextpanjang.length() > 0 && textInputEditTextpertambahan.length() > 0) {
                    Double pertambahan = Double.valueOf(textInputEditTextpertambahan.getText().toString());
                    Double panjang = Double.valueOf(textInputEditTextpanjang.getText().toString());
                    Double strain = pertambahan / panjang;
                    String hasil = String.valueOf(strain);
                    materialTextView.setText(hasil);
                }
                else {
                    materialTextView.setText("Input Cannot be Empty");
                }
            }
        });
        strainViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
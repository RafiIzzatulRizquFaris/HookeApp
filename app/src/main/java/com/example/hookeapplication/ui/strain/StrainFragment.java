package com.example.hookeapplication.ui.strain;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
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
            @Override
            public void onClick(View v) {
                int pertambahan = Integer.parseInt(textInputEditTextpertambahan.getText().toString());
                int panjang = Integer.parseInt(textInputEditTextpanjang.getText().toString());
                Double strain = (double) pertambahan / (double) panjang;
                String hasil = String.valueOf(strain);
                materialTextView.setText(hasil);
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
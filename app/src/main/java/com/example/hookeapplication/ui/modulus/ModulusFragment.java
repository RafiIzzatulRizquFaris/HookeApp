package com.example.hookeapplication.ui.modulus;

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

public class ModulusFragment extends Fragment {

    private TextInputEditText textInputEditTextstress, textInputEditTextstrain;
    private MaterialTextView materialTextView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ModulusViewModel modulusViewModel = ViewModelProviders.of(this).get(ModulusViewModel.class);
        View root = inflater.inflate(R.layout.fragment_modulus, container, false);
        final TextView textView = root.findViewById(R.id.title_modulus);
        textInputEditTextstress = root.findViewById(R.id.edt_stress_modulus);
        textInputEditTextstrain = root.findViewById(R.id.edt_strain_modulus);
        MaterialButton materialButton = root.findViewById(R.id.btn_calculate_modulus);
        materialTextView = root.findViewById(R.id.tv_hasil_modulus);
        materialButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (textInputEditTextstress.length() > 0 && textInputEditTextstrain.length() > 0) {
                    Double strain = Double.valueOf(textInputEditTextstrain.getText().toString());
                    Double stress = Double.valueOf(textInputEditTextstress.getText().toString());
                    Double modulus = stress / strain;
                    String hasil = String.valueOf(modulus);
                    materialTextView.setText(hasil);
                }
                else {
                    materialTextView.setText("Input Cannot be Empty");
                }
            }
        });
        modulusViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
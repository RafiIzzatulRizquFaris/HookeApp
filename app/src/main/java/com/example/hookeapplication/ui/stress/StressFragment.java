package com.example.hookeapplication.ui.stress;

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

    private StressViewModel stressViewModel;
    TextInputEditText textInputEditTextluas, textInputEditTextgaya;
    MaterialTextView materialTextView;
    MaterialButton materialButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        stressViewModel =
                ViewModelProviders.of(this).get(StressViewModel.class);
        View root = inflater.inflate(R.layout.fragment_stress, container, false);
        final MaterialTextView textView = root.findViewById(R.id.title_stress);
        textInputEditTextgaya = root.findViewById(R.id.edt_gaya_stress);
        textInputEditTextluas = root.findViewById(R.id.edt_luas_stress);
        materialButton = root.findViewById(R.id.btn_calculate_stress);
        materialTextView = root.findViewById(R.id.tv_hasil_stress);
        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int gaya = Integer.parseInt(textInputEditTextgaya.getText().toString());
                int luas = Integer.parseInt(textInputEditTextluas.getText().toString());
                Double stress = (double) gaya+ (double) luas;
                String hasil = String.valueOf(stress);
                materialTextView.setText(hasil);
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
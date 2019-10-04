package com.example.hookeapplication.ui.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.example.hookeapplication.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

public class HomeFragment extends Fragment {

    private TextInputEditText textInputEditTextconst, textInputEditTextpertambahan;
    private MaterialTextView materialTextView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        textInputEditTextconst = root.findViewById(R.id.edt_constants_hooke);
        textInputEditTextpertambahan = root.findViewById(R.id.edt_pertambahan_hooke);
        MaterialButton materialButton = root.findViewById(R.id.btn_calculate_hooke);
        materialTextView = root.findViewById(R.id.tv_hasil_hooke);
        materialButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (textInputEditTextconst.length() > 0 && textInputEditTextpertambahan.length() > 0) {
                    Double constants = Double.valueOf(textInputEditTextconst.getText().toString());
                    Double pertambahan = Double.valueOf(textInputEditTextpertambahan.getText().toString());
                    Double hooke = constants * pertambahan;
                    String hasil = String.valueOf(hooke);
                    materialTextView.setText(hasil+" N");
                }
                else {
                    materialTextView.setText("Input Cannot be Empty");
                }
            }
        });
        ImageView icHooke = root.findViewById(R.id.ic_hooke);
        Glide.with(this).load(R.drawable.hookegif).into(icHooke);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
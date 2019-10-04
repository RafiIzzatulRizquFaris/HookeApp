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
import com.google.android.material.textview.MaterialTextView;

public class StressFragment extends Fragment {

    private StressViewModel stressViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        stressViewModel =
                ViewModelProviders.of(this).get(StressViewModel.class);
        View root = inflater.inflate(R.layout.fragment_stress, container, false);
        final MaterialTextView textView = root.findViewById(R.id.title_stress);
        stressViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
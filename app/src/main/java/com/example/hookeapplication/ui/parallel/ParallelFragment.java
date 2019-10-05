package com.example.hookeapplication.ui.parallel;

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

public class ParallelFragment extends Fragment {

    private ParallelViewModel parallelViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        parallelViewModel =
                ViewModelProviders.of(this).get(ParallelViewModel.class);
        View root = inflater.inflate(R.layout.fragment_parallel, container, false);
        final TextView textView = root.findViewById(R.id.text_send);
        parallelViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
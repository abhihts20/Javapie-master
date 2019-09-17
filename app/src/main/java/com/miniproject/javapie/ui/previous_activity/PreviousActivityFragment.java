package com.miniproject.javapie.ui.previous_activity;

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

import com.miniproject.javapie.R;

public class PreviousActivityFragment extends Fragment {

    private PreviousActivityViewModel previousActivityViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        previousActivityViewModel =
                ViewModelProviders.of(this).get(PreviousActivityViewModel.class);
        View root = inflater.inflate(R.layout.fragment_previous, container, false);
        final TextView textView = root.findViewById(R.id.text_previous);
        previousActivityViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
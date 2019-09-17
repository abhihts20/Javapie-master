package com.miniproject.javapie.ui.registered_events;

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

public class RegisteredEventsFragment extends Fragment {

    private RegisteredEventsViewModel registeredEventsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        registeredEventsViewModel =
                ViewModelProviders.of(this).get(RegisteredEventsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_registerfor, container, false);
        final TextView textView = root.findViewById(R.id.text_registerfor);
        registeredEventsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
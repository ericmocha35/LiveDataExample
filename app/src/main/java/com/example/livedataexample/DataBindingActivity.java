package com.example.livedataexample;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.livedataexample.databinding.DataBindingActivityBinding;
import com.example.livedataexample.viewmodel.DataViewModel;

public class DataBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

        DataBindingActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.data_binding_activity);

        binding.setLifecycleOwner(this);
        binding.setViewmodel(new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DataViewModel.class));
    }
}

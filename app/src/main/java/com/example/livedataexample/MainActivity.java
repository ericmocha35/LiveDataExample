package com.example.livedataexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.livedataexample.viewmodel.DataViewModel;
import com.example.livedataexample.viewmodel.LoadingState;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        TextView likeCountTW = (TextView) findViewById(R.id.like_count);

        DataViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DataViewModel.class);

        viewModel.getLikeCount().observe(this, likeCount -> {
            likeCountTW.setText(String.valueOf(likeCount));
        });

        // Like button
        Button likeBtn = (Button) findViewById(R.id.like_btn);
        likeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.onLike();
            }
        });

        // Reset button
        Button resetButton = (Button) findViewById(R.id.reset_btn);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.onReset();
            }
        });
    }
}
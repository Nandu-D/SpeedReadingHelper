package com.example.speedreadinghelper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private boolean[] expandedList = new boolean[5];
    private boolean allowExpandAll = false;
    private final int INTRODUCTION = 0;
    private final int STEP1 = 1;
    private final int STEP2 = 2;
    private final int STEP3 = 3;
    private final int THINGS_TO_REMEMBER = 4;


    private ImageButton introductionExpandButton, step1ExpandButton, step2ExpandButton, step3ExpandButton,
            thingsToKeepInMindExpandButton;
    private TextView introductionTextView, step1TextView, step2TextView, step3TextView,
            thingsToKeepInMindTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        introductionTextView = findViewById(R.id.introduction_description_text_view);
        step1TextView = findViewById(R.id.step1_explanation_text_view);
        step2TextView = findViewById(R.id.step2_explanation_text_view);
        step3TextView = findViewById(R.id.step3_explanation_text_view);
        thingsToKeepInMindTextView = findViewById(R.id.things_to_keep_in_mind_description_text_view);

        introductionExpandButton = findViewById(R.id.introduction_expand_button);
        step1ExpandButton = findViewById(R.id.step1_expand_button);
        step2ExpandButton = findViewById(R.id.step2_expand_button);
        step3ExpandButton = findViewById(R.id.step3_expand_button);
        thingsToKeepInMindExpandButton = findViewById(R.id.things_to_keep_in_mind_expand_button);

        introductionExpandButton.setOnClickListener(this);
        step1ExpandButton.setOnClickListener(this);
        step2ExpandButton.setOnClickListener(this);
        step3ExpandButton.setOnClickListener(this);
        thingsToKeepInMindExpandButton.setOnClickListener(this);

        showDescription(introductionTextView, introductionExpandButton, INTRODUCTION);
        hideDescription(step1TextView, step1ExpandButton, STEP1);
        hideDescription(step2TextView, step2ExpandButton, STEP2);
        hideDescription(step3TextView, step3ExpandButton, STEP3);
        hideDescription(thingsToKeepInMindTextView, thingsToKeepInMindExpandButton, THINGS_TO_REMEMBER);
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        allowExpandAll = sharedPreferences.getBoolean(getResources().getString(R.string.switch_key), false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.introduction_expand_button:
                if (!expandedList[INTRODUCTION]) {
                    if (allowExpandAll) {
                        showDescription(introductionTextView, introductionExpandButton, INTRODUCTION);
                    } else {
                        showDescription(introductionTextView, introductionExpandButton, INTRODUCTION);
                        hideDescription(step1TextView, step1ExpandButton, STEP1);
                        hideDescription(step2TextView, step2ExpandButton, STEP2);
                        hideDescription(step3TextView, step3ExpandButton, STEP3);
                        hideDescription(thingsToKeepInMindTextView, thingsToKeepInMindExpandButton, THINGS_TO_REMEMBER);
                    }
                } else {
                    hideDescription(introductionTextView, introductionExpandButton, INTRODUCTION);
                }
                break;
            case R.id.step1_expand_button:
                if (!expandedList[STEP1]) {
                    if (allowExpandAll) {
                        showDescription(step1TextView, step1ExpandButton, STEP1);
                    } else {
                        showDescription(step1TextView, step1ExpandButton, STEP1);
                        hideDescription(introductionTextView, introductionExpandButton, INTRODUCTION);
                        hideDescription(step2TextView, step2ExpandButton, STEP2);
                        hideDescription(step3TextView, step3ExpandButton, STEP3);
                        hideDescription(thingsToKeepInMindTextView, thingsToKeepInMindExpandButton, THINGS_TO_REMEMBER);
                    }
                } else {
                    hideDescription(step1TextView, step1ExpandButton, STEP1);
                }
                break;
            case R.id.step2_expand_button:
                if (!expandedList[STEP2]) {
                    if (allowExpandAll) {
                        showDescription(step2TextView, step2ExpandButton, STEP2);
                    } else {
                        showDescription(step2TextView, step2ExpandButton, STEP2);
                        hideDescription(introductionTextView, introductionExpandButton, INTRODUCTION);
                        hideDescription(step1TextView, step1ExpandButton, STEP1);
                        hideDescription(step3TextView, step3ExpandButton, STEP3);
                        hideDescription(thingsToKeepInMindTextView, thingsToKeepInMindExpandButton, THINGS_TO_REMEMBER);
                    }
                } else {
                    hideDescription(step2TextView, step2ExpandButton, STEP2);
                }
                break;
            case R.id.step3_expand_button:
                if (!expandedList[STEP3]) {
                    if (allowExpandAll) {
                        showDescription(step3TextView, step3ExpandButton, STEP3);
                    } else {
                        showDescription(step3TextView, step3ExpandButton, STEP3);
                        hideDescription(step1TextView, step1ExpandButton, STEP1);
                        hideDescription(introductionTextView, introductionExpandButton, INTRODUCTION);
                        hideDescription(step2TextView, step2ExpandButton, STEP2);
                        hideDescription(thingsToKeepInMindTextView, thingsToKeepInMindExpandButton, THINGS_TO_REMEMBER);
                    }
                } else {
                    hideDescription(step3TextView, step3ExpandButton, STEP3);
                }
                break;
            case R.id.things_to_keep_in_mind_expand_button:
                if (!expandedList[THINGS_TO_REMEMBER]) {
                    if (allowExpandAll) {
                        showDescription(thingsToKeepInMindTextView, thingsToKeepInMindExpandButton, THINGS_TO_REMEMBER);
                    } else {
                        showDescription(thingsToKeepInMindTextView, thingsToKeepInMindExpandButton, THINGS_TO_REMEMBER);
                        hideDescription(step1TextView, step1ExpandButton, STEP1);
                        hideDescription(introductionTextView, introductionExpandButton, INTRODUCTION);
                        hideDescription(step2TextView, step2ExpandButton, STEP2);
                        hideDescription(step3TextView, step3ExpandButton, STEP3);
                    }
                } else {
                    hideDescription(thingsToKeepInMindTextView, thingsToKeepInMindExpandButton, THINGS_TO_REMEMBER);
                }
                break;
        }
    }

    public void showDescription(TextView textView, ImageButton imageButton, int expandedPosition) {
        textView.setVisibility(View.VISIBLE);
        imageButton.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
        expandedList[expandedPosition] = true;

    }

    public void hideDescription(TextView textView, ImageButton imageButton, int hiddenPosition) {
        textView.setVisibility(View.GONE);
        imageButton.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
        expandedList[hiddenPosition] = false;
    }
}

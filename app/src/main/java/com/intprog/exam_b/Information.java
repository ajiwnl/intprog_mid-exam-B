package com.intprog.exam_b;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Information extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        String studName = getIntent().getStringExtra("EXTRA_STUDENT_NAME");
        String nickName = getIntent().getStringExtra("EXTRA_NICKNAME");
        String contactNo = getIntent().getStringExtra("EXTRA_CONTACT_NO");
        String idNo = getIntent().getStringExtra("EXTRA_ID_NO");

        TextView studentNameTextView = findViewById(R.id.studentName);
        studentNameTextView.setText(studName);

        TextView nickNameTextView = findViewById(R.id.nickName);
        nickNameTextView.setText(nickName);

        TextView contactNoTextView = findViewById(R.id.contactNo);
        contactNoTextView.setText(contactNo);

        TextView idNoTextView = findViewById(R.id.idNo);
        idNoTextView.setText(idNo);
    }
}

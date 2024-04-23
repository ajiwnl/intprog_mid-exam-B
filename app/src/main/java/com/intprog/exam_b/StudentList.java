package com.intprog.exam_b;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class StudentList extends AppCompatActivity {

    ListView listView;
    Button addBtn;
    EditText studentName;
   EditText contactNo;
    EditText nickName;
   EditText idNo;
   ArrayList<String> lngList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        listView = findViewById(R.id.listView);
        addBtn = findViewById(R.id.addButton);
        studentName = findViewById(R.id.studentName);
        contactNo = findViewById(R.id.contactNo);
        nickName = findViewById(R.id.nickName);
        idNo = findViewById(R.id.idNo);
        lngList = new ArrayList<>();

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, lngList);
        listView.setAdapter(adapter);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = studentName.getText().toString();
                if (!name.isEmpty()) {
                    lngList.add(name);
                    adapter.notifyDataSetChanged();
                }
            }
        });

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String clickedStudentName = lngList.get(position);
            callActivity(clickedStudentName);
        });
    }

    private void callActivity(String clickedStudentName) {
        String conNum = contactNo.getText().toString();
        String nick = nickName.getText().toString();
        String id = idNo.getText().toString();

        Intent intent = new Intent(this, Information.class);
        intent.putExtra("EXTRA_STUDENT_NAME", clickedStudentName);
        intent.putExtra("EXTRA_NICKNAME", nick);
        intent.putExtra("EXTRA_CONTACT_NO", conNum);
        intent.putExtra("EXTRA_ID_NO", id);
        startActivity(intent);
    }
}

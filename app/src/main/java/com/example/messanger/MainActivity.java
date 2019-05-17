package com.example.messanger;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_next, btn_true, btn_false, btn_restart;
    private TextView txt;
    private int quest_index = 0;
    private int count = 0;

    private TrueFalse[] questions = new TrueFalse[] {
            new TrueFalse(R.string.quest_1, true),
            new TrueFalse(R.string.quest_2, false),
            new TrueFalse(R.string.quest_3, true),
            new TrueFalse(R.string.quest_4, false),
            new TrueFalse(R.string.quest_5, false),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_false = findViewById(R.id.btn_false);
        btn_true = findViewById(R.id.btn_true);
        btn_next = findViewById(R.id.btn_next);
        btn_restart = findViewById(R.id.btn_restart);
        txt = findViewById(R.id.result_txt);

        final int question = questions[quest_index].getQuestion();
        txt.setText(question);

        btn_true.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        btn_false.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quest_index < questions.length - 1) {
                    quest_index++;
                    final int question = questions[quest_index].getQuestion();
                    txt.setText(question);
                    btn_true.setVisibility(View.VISIBLE);
                    btn_false.setVisibility(View.VISIBLE);
                    btn_next.setVisibility(View.INVISIBLE);
                } else {
                    txt.setText("Вы прошли тест! Результат: " + count + "/" + questions.length);
                    txt.setTextColor(Color.GREEN);
                    btn_next.setVisibility(View.INVISIBLE);
                    btn_restart.setVisibility(View.VISIBLE);
                }
            }
        });

        btn_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quest_index = 0;
                final int question = questions[quest_index].getQuestion();
                txt.setText(question);
                txt.setTextColor(Color.BLACK);
                btn_true.setVisibility(View.VISIBLE);
                btn_false.setVisibility(View.VISIBLE);
                btn_restart.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void checkAnswer(boolean answer_user) {
        boolean answer = questions[quest_index].isTrueQuestion();
        if(answer_user == answer) {
            Toast.makeText(MainActivity.this, "Молодец, верно", Toast.LENGTH_LONG).show();
            count++;
        } else
            Toast.makeText(MainActivity.this, "Нет,не верно", Toast.LENGTH_LONG).show();

        btn_true.setVisibility(View.INVISIBLE);
        btn_false.setVisibility(View.INVISIBLE);
        btn_next.setVisibility(View.VISIBLE);
    }
}

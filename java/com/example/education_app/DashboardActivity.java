package com.example.education_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class DashboardActivity extends AppCompatActivity {
    private TextView questionTv,questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<QuizModal> quizModalArrayList;
    Random random;
    int currentScore = 0 , questionAttempted = 1, currentPos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        questionTv = findViewById(R.id.idTVQuestion);
        questionNumberTV = findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizModalArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestion(quizModalArrayList);
        currentPos = random.nextInt(quizModalArrayList.size());
        setDataToViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())) {

                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())) {

                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);

            }
        });
        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())) {

                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);

            }
        });
        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())) {

                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
            }
        });




    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(DashboardActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTVscore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your score is \n"+currentScore+"/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPos=random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
                questionAttempted=1;
                currentScore=0;
                bottomSheetDialog.dismiss();


            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

    }

    private void setDataToViews(int currentPos) {
        questionNumberTV.setText("Question Attempted:"+questionAttempted+"/10");
        if (questionAttempted==10) {
            showBottomSheet();
        }else{
            questionTv.setText(quizModalArrayList.get(currentPos).getQuestion());
            option1Btn.setText(quizModalArrayList.get(currentPos).getOption1());
            option2Btn.setText(quizModalArrayList.get(currentPos).getOption2());
            option3Btn.setText(quizModalArrayList.get(currentPos).getOption3());
            option4Btn.setText(quizModalArrayList.get(currentPos).getOption4());

            }
        }




    private void getQuizQuestion(ArrayList<QuizModal> quizModalArrayList) {
        quizModalArrayList.add(new QuizModal("What is the name of ISRO’s new humanoid robot that will go to space next?","vyomitra","atlas","sophia","mitra","vyomitra" ));
        quizModalArrayList.add(new QuizModal("Who was the author of Ramayana?","vishwamitra","vaishishth","valmiki","vedvyas","valmiki" ));
        quizModalArrayList.add(new QuizModal("Which city is known as the Blue City of India?","jaipur","jodhpur","mumbai","chennai","jodhpur" ));
        quizModalArrayList.add(new QuizModal("Which state is known as ‘Scotland of the East’ in India?","meghalaya","assam","manipur","sikkim","meghalaya" ));
        quizModalArrayList.add(new QuizModal("Who has the highest authority in India?","prime minister","vice-president","president","chief justice","president" ));
        quizModalArrayList.add(new QuizModal("With how many states does maharashtra share its boundary?","5","7","6","2","6" ));
        quizModalArrayList.add(new QuizModal("Which city is known as oxford of east?","mumbai","pune","nashik","nagpur","pune" ));
        quizModalArrayList.add(new QuizModal("Which day is celebrated as the Maharashtra day?","11 april","2 june","30 september","1 may","1 may" ));
        quizModalArrayList.add(new QuizModal("Which country launch first man made sattelite?","usa","soviet union","china","japan","soviet union" ));
        quizModalArrayList.add(new QuizModal("What is the  name of first man made satellite?","sputnik-1","PROBA","KOSMOS","FOTON-M2","sputnik-1" ));

    }
}
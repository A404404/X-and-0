package com.itsmypac.xand0;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static TextView[][] T = new TextView[3][3];
     Dialog myDialog;
     Boolean bool = true;

      int  clicks = 9;

      int  score_P1 = 0;
      int  score_P2 = 0;

      int P1;
      int P2;

      public static Boolean s;

     // Will be used to give scores to the respective players

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDialog = new Dialog(this);

        TextView P1_score = findViewById(R.id.P1_score);
        TextView P2_score = findViewById(R.id.P2_score);

      try {
          P1_score.setText(getIntent().getExtras().getString("1"));
          P2_score.setText(getIntent().getExtras().getString("2"));
      }catch (Exception e){

      }



       Player1();

        T[0][0] = findViewById(R.id.A0);
        T[0][0].setOnClickListener(this);

        T[0][1] = findViewById(R.id.A1);
        T[0][1].setOnClickListener(this);

        T[0][2] = findViewById(R.id.A2);
        T[0][2].setOnClickListener(this);

        T[1][0] = findViewById(R.id.B0);
        T[1][0].setOnClickListener(this);

        T[1][1] = findViewById(R.id.B1);
        T[1][1].setOnClickListener(this);

        T[1][2] = findViewById(R.id.B2);
        T[1][2].setOnClickListener(this);

        T[2][0] = findViewById(R.id.C0);
        T[2][0].setOnClickListener(this);

        T[2][1] = findViewById(R.id.C1);
        T[2][1].setOnClickListener(this);

        T[2][2] = findViewById(R.id.C2);
        T[2][2].setOnClickListener(this);
    }


   public void Player1(){
     // represents the two option X and Y
       TextView chose_X;
       TextView chose_0;

       myDialog.setContentView(R.layout.startgame);

       LinearLayout stop = myDialog.findViewById(R.id.stop);

       chose_X = myDialog.findViewById(R.id.chose_X);
       chose_0 = myDialog.findViewById(R.id.chose_0);
       EditText Player_name_edi = myDialog.findViewById(R.id.Player_name_edi);
       EditText Player1_name = findViewById(R.id.Player1_name);

       Player_name_edi.setText("Player 1");

       myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
       myDialog.show();

//       stop.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View view) {
//               Toast.makeText(MainActivity.this, "Pls provide a input ", Toast.LENGTH_SHORT).show();
//               myDialog.show();
//           }
//       });

       // if clicked on X
       chose_X.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               EditText Player_name_edi = myDialog.findViewById(R.id.Player_name_edi);
               Player1_name.setText(Player_name_edi.getText());

               Player1_name.append("(" +chose_X.getText()+ ")");

               s = true;

               myDialog.dismiss();
               Player2();
           }
       });

       // if clicked on Y
       chose_0.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               EditText Player_name_edi = myDialog.findViewById(R.id.Player_name_edi);

               Player1_name.setText(Player_name_edi.getText());

               Player1_name.append("(" +chose_0.getText()+ ")");

               s = false;

               myDialog.dismiss();
               Player2();
           }
       });


   }

    public void Player2(){
        // represents the two option X and Y
        TextView chose_X;
        TextView chose_0;

        myDialog.setContentView(R.layout.startgame);


        chose_X = myDialog.findViewById(R.id.chose_X);
        chose_0 = myDialog.findViewById(R.id.chose_0);
        EditText Player_name_edi = myDialog.findViewById(R.id.Player_name_edi);
        EditText Player2_name = findViewById(R.id.Player2_name);


        Player_name_edi.setText("Player 2");

        if(s){
            chose_0.setText("0");
            chose_X.setText("0");
        }else{
            chose_X.setText("X");
            chose_0.setText("X");
        }

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();


        // if clicked on X
        chose_X.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText Player_name_edi = myDialog.findViewById(R.id.Player_name_edi);
                Player2_name.setText(Player_name_edi.getText());

                Player2_name.append("(" +chose_X.getText()+ ")");


                myDialog.dismiss();
            }
        });

        // if clicked on Y
        chose_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText Player_name_edi = myDialog.findViewById(R.id.Player_name_edi);

                Player2_name.setText(Player_name_edi.getText());

                Player2_name.append("(" +chose_0.getText()+ ")");

                myDialog.dismiss();
            }
        });
    }


    public void ShowPopup(String T) {

             TextView Winner;
             ConstraintLayout newscreen;

            myDialog.setContentView(R.layout.custompopup);

            Winner = myDialog.findViewById(R.id.Winner);
            newscreen = myDialog.findViewById(R.id.newscreen);

            Winner.setText(T);

           myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
           myDialog.show();
           newscreen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myDialog.dismiss();
//                    Intent intent = getIntent();
//                    finish();
//                    intent.putExtra("1", Integer.toString(P1));
//                    intent.putExtra("2", Integer.toString(P2));

//                    startActivity(intent);

                    TextView[][] T = new TextView[3][3];
                    T[0][0] = findViewById(R.id.A0);

                    T[0][1] = findViewById(R.id.A1);

                    T[0][2] = findViewById(R.id.A2);

                    T[1][0] = findViewById(R.id.B0);

                    T[1][1] = findViewById(R.id.B1);

                    T[1][2] = findViewById(R.id.B2);

                    T[2][0] = findViewById(R.id.C0);

                    T[2][1] = findViewById(R.id.C1);;

                    T[2][2] = findViewById(R.id.C2);

                    T[0][0].setText("");

                    T[0][1].setText("");

                    T[0][2].setText("");

                    T[1][0].setText("");

                    T[1][1].setText("");

                    T[1][2].setText("");

                    T[2][0].setText("");

                    T[2][1].setText("");

                    T[2][2].setText("");

                    clicks = 9;

                    TextView P1_score = findViewById(R.id.P1_score);

                    P1_score.setText(Integer.toString(P1));

                    TextView P2_score = findViewById(R.id.P2_score);

                    P2_score.setText(Integer.toString(P2));

                    bool = true;
                }
            });
    }

    public void Draw() {

        TextView Winner;
        TextView status;
        ConstraintLayout newscreen;

        myDialog.setContentView(R.layout.custompopup);

        Winner = myDialog.findViewById(R.id.Winner);
        status = myDialog.findViewById(R.id.status);

        newscreen = myDialog.findViewById(R.id.newscreen);

        Winner.setText("The Game ");
        status.setText(" is a Draw ");

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
        newscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });
    }

    void checkWinner() {

        String line = null;
        for (int a = 0; a < 8; a++) {

            switch (a) {
                case 0:
                    line = T[0][0].getText().toString() + T[0][1].getText().toString() + T[0][2].getText().toString();

                    break;
                case 1:
                    line = T[1][0].getText().toString() + T[1][1].getText().toString() + T[1][2].getText().toString();

                    break;
                case 2:
                    line = T[2][0].getText().toString() + T[2][1].getText().toString() + T[2][2].getText().toString();

                    break;
                case 3:
                    line = T[0][0].getText().toString() + T[1][0].getText().toString() + T[2][0].getText().toString();

                    break;
                case 4:
                    line = T[0][1].getText().toString() + T[1][1].getText().toString() + T[2][1].getText().toString();

                    break;
                case 5:
                    line = T[0][2].getText().toString() + T[1][2].getText().toString() + T[2][2].getText().toString();

                    break;
                case 6:
                    line = T[0][0].getText().toString() + T[1][1].getText().toString() + T[2][2].getText().toString();

                    break;
                case 7:
                    line = T[0][2].getText().toString() + T[1][1].getText().toString() + T[2][0].getText().toString();

                    break;
            }

            String ans = String.format("%s", line);

            TextView P1_score = findViewById(R.id.P1_score);
            TextView P2_score = findViewById(R.id.P2_score);

            String P1_string = P1_score.getText().toString();
            String P2_string = P2_score.getText().toString();

            P1 = Integer.parseInt(P1_string);
            P2 = Integer.parseInt(P2_string);

            if(ans.equals("XXX")){

                if(s){

                    TextView Player_1 = findViewById(R.id.Player1_name);
                    P1++;
                    Toast.makeText(MainActivity.this, "P1 = "+P1, Toast.LENGTH_SHORT).show();
                    ShowPopup(Player_1.getText().toString());

                }else {

                    TextView Player_2 = findViewById(R.id.Player2_name);
                    P2++;
                    ShowPopup(Player_2.getText().toString());

                }





            }else if(ans.equals("000")){


                if(!s){

                    TextView Player_1 = findViewById(R.id.Player1_name);
                    P1++;
                    ShowPopup(Player_1.getText().toString());
                }else {
                    TextView Player_2 = findViewById(R.id.Player2_name);
                    P2++;
                    ShowPopup(Player_2.getText().toString());
                }
            }

        }

    }

    void XorO(TextView T){


        if(T.getText().toString().isEmpty()) {
            clicks -=  1;
            if (bool) {
                T.setText("X");

                if(clicks == 0){

                    Draw();

                }
                bool = false;
            } else {
                T.setText("0");
                bool = true;
            }
            checkWinner();
        }else{
            Toast.makeText(MainActivity.this, "Try some other place this place is already full ", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.A0:
                XorO(T[0][0]);
                break;
            case R.id.A1:
                XorO(T[0][1]);
                break;
            case R.id.A2:
                XorO(T[0][2]);
                break;
            case R.id.B0:
                XorO(T[1][0]);
                break;
            case R.id.B1:
                XorO(T[1][1]);
                break;
            case R.id.B2:
                XorO(T[1][2]);
                break;
            case R.id.C0:
                XorO(T[2][0]);
                break;
            case R.id.C1:
                XorO(T[2][1]);
                break;
            case R.id.C2:
                XorO(T[2][2]);
                break;
        }

    }
}
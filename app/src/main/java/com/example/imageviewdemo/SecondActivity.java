package com.example.imageviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    int[] manghinhbai = {
            R.drawable.c_a,
            R.drawable.c2,
            R.drawable.c3,
            R.drawable.c4,
            R.drawable.c5,
            R.drawable.c6,
            R.drawable.c7,
            R.drawable.c8,
            R.drawable.c9,
            R.drawable.c10,
            R.drawable.c_j,
            R.drawable.c_q,
            R.drawable.c_k,
            R.drawable.d_a,
            R.drawable.d2,
            R.drawable.d3,
            R.drawable.d4,
            R.drawable.d5,
            R.drawable.d6,
            R.drawable.d7,
            R.drawable.d8,
            R.drawable.d9,
            R.drawable.d10,
            R.drawable.d_j,
            R.drawable.d_q,
            R.drawable.d_k,
            R.drawable.h_a,
            R.drawable.h2,
            R.drawable.h3,
            R.drawable.h4,
            R.drawable.h5,
            R.drawable.h6,
            R.drawable.h7,
            R.drawable.h8,
            R.drawable.h9,
            R.drawable.h10,
            R.drawable.h_j,
            R.drawable.h_q,
            R.drawable.h_k,
            R.drawable.s_a,
            R.drawable.s2,
            R.drawable.s3,
            R.drawable.s4,
            R.drawable.s5,
            R.drawable.s6,
            R.drawable.s7,
            R.drawable.s8,
            R.drawable.s9,
            R.drawable.s10,
            R.drawable.s_j,
            R.drawable.s_q,
            R.drawable.s_k
    };

    public CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button bt_startCountdown = findViewById(R.id.button_startCountdown);
        Button bt_switch = findViewById(R.id.button_switchpvp);
        ImageView iv1 = findViewById(R.id.imageView1);
        ImageView iv2 = findViewById(R.id.imageView2);
        ImageView iv3 = findViewById(R.id.imageView3);
        ImageView iv4 = findViewById(R.id.imageView4);
        ImageView iv5 = findViewById(R.id.imageView5);
        ImageView iv6 = findViewById(R.id.imageView6);
        TextView tv_ketqua = findViewById(R.id.textview_ketqua);
        TextView tv_result = findViewById(R.id.textview_result);
        TextView tv_remaining = findViewById(R.id.textview_remainingTime);
        EditText seconds = findViewById(R.id.edittext_countdownsecond);

        bt_startCountdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String countdownSeconds = seconds.getText().toString();
                Long miliseconds = Long.parseLong(countdownSeconds) * 1000;
                String textCountdown = countdownSeconds;
                countDownTimer = new CountDownTimer(miliseconds, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        int[] value;
                        value = layBaSoNgauNhien(0,51);

                        int[] value1 = new int[3];
                        int[] value2 = new int[3];

                        value1[0] = value[0];
                        value1[1] = value[1];
                        value1[2] = value[2];
                        value2[0] = value[3];
                        value2[1] = value[4];
                        value2[2] = value[5];


                        iv1.setImageResource(manghinhbai[value1[0]]);
                        iv2.setImageResource(manghinhbai[value1[1]]);
                        iv3.setImageResource(manghinhbai[value1[2]]);

                        tv_ketqua.setText(tinhKetQua(value1));

                        iv4.setImageResource(manghinhbai[value2[0]]);
                        iv5.setImageResource(manghinhbai[value2[1]]);
                        iv6.setImageResource(manghinhbai[value2[2]]);

                        tv_result.setText(tinhKetQua(value2));

                        
                    }

                    @Override
                    public void onFinish() {
                        tv_remaining.setText("Done!!!");
                    }
                }.start();
            }
        });

        bt_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private String tinhKetQua(int[] value){
        String ketqua = "";
        if(tinhSoTay(value) == 3){
            ketqua = "K???t qu???: 3 T??y";
        } else {
            int tong = 0;
            for(int i = 0; i < value.length; i++){
                if(value[i] % 13 < 10){
                    tong += value[i] % 13 + 1;
                }
            }
            if(tong % 10 == 0){
                ketqua = "K???t qu??? b??, trong ???? c?? " + tinhSoTay(value) + " t??y.";
            } else {
                ketqua = "K???t qu??? l?? " + (tong % 10) + " n??t, trong ???? c?? " + tinhSoTay(value) + " t??y.";
            }
        }
        return ketqua;
    }

    private int tinhSoTay(int a[]){
        int k = 0;
        for(int i = 0; i < a.length; i++){
            if((a[i] % 13 >= 10) && (a[i] % 13 < 13)){ // chia l???y ph???n d?? n???u n?? l???n h??n 10 nh??? h??n 13 t???c l?? T??y
                k++;
            }
        }
        return k;
    }

    private int[] layBaSoNgauNhien(int min, int max){
        int baso[] = new int[6];
        int i = 0;
        baso[i++] = random(min,max);
        do{
            int k = random(min,max);
            if(!kiemTraTrung(k, baso)) {
                baso[i++] = k;
            }
        } while (i < 6);
        return baso;
    }

    private boolean kiemTraTrung(int k, int a[]){
        for(int i = 0; i < a.length; i++){
            if(a[i] == k){
                return true;
            }
        }
        return false;
    }

    private int random(int min, int max){
        return min + (int)(Math.random()*((max-min) + 1));
    }
}
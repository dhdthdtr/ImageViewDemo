package com.example.imageviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView iv1 = findViewById(R.id.imageView1);
        ImageView iv2 = findViewById(R.id.imageView2);
        ImageView iv3 = findViewById(R.id.imageView3);
        ImageView iv4 = findViewById(R.id.imageView4);
        ImageView iv5 = findViewById(R.id.imageView5);
        ImageView iv6 = findViewById(R.id.imageView6);
        TextView tv_ketqua = findViewById(R.id.textview_ketqua);
        TextView tv_result = findViewById(R.id.textview_result);

        Button bt_chon = findViewById(R.id.button_chon);
        Button bt_reset = findViewById(R.id.button_reset);
        Button bt_switch = findViewById(R.id.button_switchcountdown);
        bt_chon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int[] value1 = new int[6];
//                value1 = layBaSoNgauNhien(0,51);
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

//                int[] value2 = new int[6];
//                value2 = layBaSoNgauNhien(0,51);

                iv4.setImageResource(manghinhbai[value2[0]]);
                iv5.setImageResource(manghinhbai[value2[1]]);
                iv6.setImageResource(manghinhbai[value2[2]]);

                tv_result.setText(tinhKetQua(value2));
            }
        });

        bt_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        bt_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv1.setImageResource(R.drawable.back_card_deck);
                iv2.setImageResource(R.drawable.back_card_deck);
                iv3.setImageResource(R.drawable.back_card_deck);
                iv4.setImageResource(R.drawable.back_card_deck);
                iv5.setImageResource(R.drawable.back_card_deck);
                iv6.setImageResource(R.drawable.back_card_deck);

                tv_ketqua.setText("Kết quả: ");
                tv_result.setText("Kết quả: ");
            }
        });
    }

    private String tinhKetQua(int[] value){
        String ketqua = "";
        if(tinhSoTay(value) == 3){
            ketqua = "Kết quả: 3 Tây";
        } else {
            int tong = 0;
            for(int i = 0; i < value.length; i++){
                if(value[i] % 13 < 10){
                    tong += value[i] % 13 + 1;
                }
            }
            if(tong % 10 == 0){
                ketqua = "Kết quả bù, trong đó có " + tinhSoTay(value) + " tây.";
            } else {
                ketqua = "Kết quả là " + (tong % 10) + " nút, trong đó có " + tinhSoTay(value) + " tây.";
            }
        }
        return ketqua;
    }

    private int tinhSoTay(int a[]){
        int k = 0;
        for(int i = 0; i < a.length; i++){
            if((a[i] % 13 >= 10) && (a[i] % 13 < 13)){ // chia lấy phần dư nếu nó lớn hơn 10 nhỏ hơn 13 tức lá Tây
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
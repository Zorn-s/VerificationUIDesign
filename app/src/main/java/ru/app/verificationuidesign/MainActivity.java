package ru.app.verificationuidesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private PinView pinView;
    private Button next;
    private TextView topText;
    private EditText userName,userPhone;
    private ConstraintLayout first,second;
    private TextView textU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pinView = findViewById(R.id.pinView);
        next = findViewById(R.id.button);
        topText = findViewById(R.id.topText);
        userName = findViewById(R.id.userName);
        userPhone = findViewById(R.id.userPhone);
        textU = findViewById(R.id.noti);

        first = findViewById(R.id.firstStep);
        second = findViewById(R.id.secondStep);

        first.setVisibility(View.VISIBLE);

        next.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {



        if(next.getText().equals("Let's Go!")){

            String user = userName.getText().toString();
            String phone = userPhone.getText().toString();

            if(!TextUtils.isEmpty(user)&&!TextUtils.isEmpty(phone)){
                next.setText("Verify");
                first.setVisibility(View.GONE);
                second.setVisibility(View.VISIBLE);

            }else {
                Toast.makeText(this, "Please enter the details",Toast.LENGTH_SHORT).show();
            }


        }else if(next.getText().equals("Verify")) {
            String OTP = pinView.getText().toString();
            if (OTP.equals("3457")) {
                pinView.setLineColor(Color.GREEN);
                textU.setText("OTP Verified");
                textU.setTextColor(Color.GREEN);

            } else {
                pinView.setLineColor(Color.RED);
                textU.setText("X incorrect OTP");
                textU.setTextColor(Color.RED);
            }

        }


    }
}

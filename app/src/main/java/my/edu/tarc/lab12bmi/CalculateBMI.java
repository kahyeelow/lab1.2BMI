package my.edu.tarc.lab12bmi;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CalculateBMI extends AppCompatActivity {
    private EditText editTextWeight, editTextHeight;
    private TextView textViewResult;
    private ImageView imageViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_bmi);

        editTextWeight = (EditText)findViewById(R.id.editTextWeight);
        editTextHeight = (EditText)findViewById(R.id.editTextHeight);
        textViewResult= (TextView) findViewById(R.id.textViewResult);
        imageViewResult = (ImageView)findViewById(R.id.imageViewResult);

    }

    public void calculateBMI(View view){
        Double weight, height, totalbmi;

        weight = Double.parseDouble(editTextWeight.getText().toString());
        height = Double.parseDouble(editTextHeight.getText().toString());
        height /=100;

        //totalbmi= String.format((weight / (height*height));
        totalbmi= weight / (height*height);
        if(totalbmi <= 18.5)
        {
            textViewResult.setText("Your BMI = " + String.format("%.2f",totalbmi ) + ", you are under weight.");
            imageViewResult.setImageResource(R.drawable.under);
        }
        else if(totalbmi >=25.0)
        {
            textViewResult.setText("Your BMI = " + String.format("%.2f",totalbmi ) + ", you are over weight.");
            imageViewResult.setImageResource(R.drawable.over);
        }
        else
        {
            textViewResult.setText("Your BMI = " + String.format("%.2f",totalbmi ) + ", you are normal weight.");
            imageViewResult.setImageResource(R.drawable.normal);
        }
        }

        public void reset(View view)
        {
            editTextWeight.setText("");
            editTextHeight.setText("");
            textViewResult.setText("");
        }
    }


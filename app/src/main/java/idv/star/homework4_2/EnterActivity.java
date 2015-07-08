package idv.star.homework4_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by STAR on 2015/7/8.
 */
public class EnterActivity extends Activity {
    private EditText edHeight;
    private EditText edWeight;
    private Button btSubmit;
    private Button btClear;
    private Button btBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter);
        findViews();

    }
    private void findViews(){
        edHeight=(EditText)findViewById(R.id.edHeight);
        edWeight=(EditText)findViewById(R.id.edWeight);
        btSubmit=(Button)findViewById(R.id.btSubmit);
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Double height = Double.parseDouble(edHeight.getText().toString());
                    Double weight = Double.parseDouble(edWeight.getText().toString());
                    if (height <= 0 || weight <= 0) {
                        throw new Exception();
                    }
                    else {

                        Intent intent=new Intent();
                        Bundle bundle=new Bundle();
                        double BMI = weight / ((height / 100) * (height / 100));
                        bundle.putDouble("BMI",BMI);
                        intent.putExtras(bundle);
                        setResult(RESULT_OK,intent);
                        finish();

                    }

                }
             catch (Exception e){
                 Toast.makeText(EnterActivity.this,"資料錯誤請重新輸入",Toast.LENGTH_SHORT).show();
             }



            }
        });
        btClear=(Button)findViewById(R.id.btClear);
        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edHeight.setText("");
                edWeight.setText("");
            }
        });
        btBack=(Button)findViewById(R.id.btBack);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              setResult(RESULT_CANCELED);
                EnterActivity.this.finish();


            }
        });



    }
}
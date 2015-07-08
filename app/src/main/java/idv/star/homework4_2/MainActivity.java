package idv.star.homework4_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private final int LOGING_REQUEST=0;
    private Button btStart;
    private Button btEnd;
    private TextView tvValue;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }
    private void findViews(){
        tvValue=(TextView)findViewById(R.id.tvValue);
        tvResult=(TextView)findViewById(R.id.tvResult);
        tvValue.setText("BMI值為:");
        tvResult.setText("結果為:");
        btStart=(Button)findViewById(R.id.btStart);
        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, EnterActivity.class);
                startActivityForResult(intent, LOGING_REQUEST);

            }
        });




        btEnd=(Button)findViewById(R.id.btEnd);
        btEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                android.os.Process.killProcess(android.os.Process.myPid());


            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {



                Bundle bundle = data.getExtras();
                double BMI=bundle.getDouble("BMI");


                tvValue.setText("BMI值為:"+"\n"+BMI);
                if (BMI >= 35) {
                    tvResult.setText("過重,該減肥了!!");
                } else if (BMI >= 30) {
                    tvResult.setText("中度肥胖");
                } else if (BMI >= 27) {
                    tvResult.setText("輕度肥胖");
                } else if (BMI >= 24) {
                    tvResult.setText("過重");
                } else if (BMI >= 18) {
                    tvResult.setText("正常");
                } else if (BMI < 18.5) {
                    tvResult.setText("體重過輕,多吃一點");
                }

        }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

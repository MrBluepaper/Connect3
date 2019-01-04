package e.bluepaper.connect3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void startGame(View v){
        if (v.getId() == R.id.btn_start){
            finish();
            startActivity(new Intent(MainActivity.this, ConnectThree.class));
        }
    }
}

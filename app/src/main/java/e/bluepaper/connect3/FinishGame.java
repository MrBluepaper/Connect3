package e.bluepaper.connect3;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FinishGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_game);
        TextView tv = findViewById(R.id.txtWinner);
        String l = getIntent().getStringExtra("winner");
        tv.setText("Winner : " + l);
        if (l.equals("Red")) tv.setTextColor(Color.rgb(225,20,20));
        if (l.equals("Yellow")) tv.setTextColor(Color.rgb(150,150,20));
        if (l.equals("No Winner")) tv.setTextColor(Color.GRAY);

    }
    public void playAgain(View view){
        finish();
        startActivity(new Intent(FinishGame.this, ConnectThree.class));
    }
}

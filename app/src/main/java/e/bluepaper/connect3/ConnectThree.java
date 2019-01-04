package e.bluepaper.connect3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class ConnectThree extends AppCompatActivity {
    public static final int RED = 0;
    public static final int YELLOW = 1;
    public static final int NOT_PLAYED = 2;
    public static final int NO_WINNER = -1;
    public static int currentPlayer = RED;

    int[] cubes = { NOT_PLAYED, NOT_PLAYED, NOT_PLAYED,
                    NOT_PLAYED, NOT_PLAYED, NOT_PLAYED,
                    NOT_PLAYED, NOT_PLAYED, NOT_PLAYED};

    int[][] winStates = {   {0,1,2}, {3,4,5}, {6,7,8},
                            {0,3,6},{1,4,7},{2,5,8},
                            {0,4,8},{2,4,6}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_three);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
            startActivity(new Intent(ConnectThree.this, MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
    public void clickBoard(View view){
        ImageView img = (ImageView) view;
        int tag = Integer.parseInt(img.getTag().toString());
        if(cubes[tag] != NOT_PLAYED){
            return;
        }
        cubes[tag] = currentPlayer;
        if(currentPlayer == RED){
            img.setImageResource(R.drawable.red);
            currentPlayer = YELLOW;
        }else if (currentPlayer == YELLOW){
            img.setImageResource(R.drawable.yellow);
            currentPlayer = RED;
        }

        int winCode = winner();
        String w = (winCode == RED) ? "Red" : (winCode == YELLOW) ? "Yellow" : "No Winner";

        if (finished() || winCode == RED || winCode == YELLOW){
            Intent intent = new Intent(ConnectThree.this, FinishGame.class);
            intent.putExtra("winner", w);
            finish();
            startActivity(intent);
        }

    }

    private boolean finished() {
        for (int i = 0; i < 9; i++)
            if(cubes[i] == NOT_PLAYED)
                return false;
        return true;
    }

    //Red as winner -> RED
    //Yellow as winner -> YELLOW
    //No winner -> NO_WINNER
    public int winner(){
        for (int[] n : winStates){
            if (cubes[n[0]] == cubes[n[1]] && cubes[n[1]] == cubes[n[2]] && cubes[n[0]] != NOT_PLAYED){
                return cubes[n[0]];
            }
        }
        return NO_WINNER;
    }

}

package kr.ac.hanseo.calculater;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private ScoreProcess scoreProcess;
    private RecyclerViewAdapter adapter;
    private Button btn_result;
    public ArrayList<ScoreModel> scoreModels;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        btn_result=(Button)findViewById(R.id.btn_result);

        //recyclerView.setHasFixedSize(true);
        scoreModels=firstvalue();   //초기값 지정
        adapter=new RecyclerViewAdapter(getApplicationContext(),scoreModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           //     adapter.setScoreProcess();
                System.out.println(scoreModels.get(3).grade+"+"+scoreModels.get(3).score+"+"+scoreModels.get(3).major);
                //Toast.makeText(getApplicationContext(),scoreModels.get(0).score,LENGTH_SHORT).show();
            }
        });
    }

    private ArrayList<ScoreModel> firstvalue(){

        ArrayList<ScoreModel> list = new ArrayList<>();

        ScoreModel scoreModel=new ScoreModel("A+",0,false);
        for(int i = 0; i < 15; i++){
            list.add(scoreModel);
        }

        return list;
    }
}

package kr.ac.hanseo.calculater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ScoreProcess scoreProcess;
    private RecyclerViewAdapter adapter;
    public ArrayList<ScoreModel> scoreModels;

    private Button btn_result,model;
    private TextView avg, total, major_avg, major_total;

    int itemCount=6;
    DecimalFormat form=new DecimalFormat("0.##"); //소수점 지정

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        model=(Button)findViewById(R.id.item_plusBtn);

        avg=(TextView)findViewById(R.id.avg);
        total=(TextView)findViewById(R.id.total);
        major_avg=(TextView)findViewById(R.id.major_avg);
        major_total=(TextView)findViewById(R.id.major_total);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        btn_result=(Button)findViewById(R.id.btn_result);

        scoreModels=firstvalue();   //초기값 지정
        adapter=new RecyclerViewAdapter(getApplicationContext(),scoreModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ItemTouchHelper itemTouchHelper=new ItemTouchHelper(new SwipeController(adapter));
        itemTouchHelper.attachToRecyclerView(recyclerView);

        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreProcess=new ScoreProcess(scoreModels);

                avg.setText("평균학점 :"+form.format(scoreProcess.avg_score));
                total.setText("이수학점 :"+String.valueOf(scoreProcess.total_score)); //setText에 int를 바로 매칭할 경우 오류 발생
                major_avg.setText("전공학점 :"+form.format(scoreProcess.major_avg));
                major_total.setText("전공평점 :"+String.valueOf(scoreProcess.major_total) );

            }
        });
    }

    private ArrayList<ScoreModel> firstvalue(){

        ArrayList<ScoreModel> list = new ArrayList<>();

        for(int i = 0; i < itemCount; i++){
            list.add(new ScoreModel("A+",0,false));
        }
        list.add(new ScoreModel(true));

        return list;
    }
}

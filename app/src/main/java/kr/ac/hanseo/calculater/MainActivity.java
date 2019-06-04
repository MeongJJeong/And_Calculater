package kr.ac.hanseo.calculater;

import android.os.Handler;
import android.support.annotation.NonNull;
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

    boolean isLoading = false;
    private Button btn_result;
    private TextView avg, total, major_avg, major_total;

    int itemCount=6;
    DecimalFormat form=new DecimalFormat("0.##"); //소수점 지정

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        initScrollListener();

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

        return list;
    }

    private void initScrollListener(){
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager linearLayoutManager = (LinearLayoutManager)recyclerView.getLayoutManager();

                if(!isLoading){
                    if (linearLayoutManager!= null && linearLayoutManager.findLastCompletelyVisibleItemPosition()==scoreModels.size()-1){

                        loadMore();
                        isLoading=true;
                    }
                }
            }
        });
    }

    private void loadMore(){
        scoreModels.add(null);
        adapter.notifyItemInserted(scoreModels.size()-1);

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                scoreModels.remove(scoreModels.size()-1);
                int scrollPosition=scoreModels.size();
                adapter.notifyItemRemoved(scrollPosition);
                scoreModels.add(new ScoreModel("A+",0,false));

                adapter.notifyDataSetChanged();
                isLoading=false;

            }
        },800);

    }
}

package kr.ac.hanseo.calculater;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ScoreProcess scoreProcess;
    private RecyclerViewAdapter adapter;
    private Button btn_result;
    public ArrayList<ScoreModel> scoreModels;

    int itemCount=10;
    boolean isLoading = false;

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

//        initScrollListener();

        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //scoreProcess = new ScoreProcess(scoreModels);
           //     adapter.setScoreProcess();
            //    System.out.println(scoreProcess.avg_score);
                System.out.println(scoreModels.get(3).grade+"+"+scoreModels.get(3).score+"+"+scoreModels.get(3).major);
                //Toast.makeText(getApplicationContext(),scoreModels.get(0).score,LENGTH_SHORT).show();
            }
        });
    }

    private ArrayList<ScoreModel> firstvalue(){

        ArrayList<ScoreModel> list = new ArrayList<>();

        ScoreModel scoreModel=new ScoreModel("A+",0,false);
        for(int i = 0; i < itemCount; i++){
            list.add(scoreModel);
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
        },500);

    }
}

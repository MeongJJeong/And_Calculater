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
    private ScoreProcess scoreProcess;
    private Button btn_result;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final RecyclerViewAdapter adapter=new RecyclerViewAdapter();
        recyclerView.setAdapter(adapter);

        btn_result=(Button)findViewById(R.id.btn_result);
        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           //     adapter.setScoreProcess();
//                Toast.makeText(getApplicationContext(),scoreProcess,LENGTH_SHORT).show();

            }
        });
    }

//    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
//
//        int itemCount=6;
//        ScoreProcess scoreProcess=new ScoreProcess();
//
//        ScoreModel[] list=new ScoreModel[itemCount];
//        List<ScoreModel> scoreModels=new ArrayList<>();
//
//        @NonNull
//        @Override
//        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//            View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_score,viewGroup,false);
//
//            // scoreProcess.scoreModels=scoreModels;
//
//            return new CustomViewHolder(view);
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
//
//            final CustomViewHolder cView=(CustomViewHolder)viewHolder;
//
//            cView.textView.setText((i+1)+"번째 과목");
//
//            cView.textView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    //popup창을 통한 과목명 변경 옵션 혹은 bottom menu 이용
//                }
//            });
//            cView.button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    final PopupMenu popupMenu=new PopupMenu(cView.button.getContext(),view);
//                    popupMenu.getMenuInflater().inflate(R.menu.score_menu,popupMenu.getMenu());
//
//                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                        @Override
//                        public boolean onMenuItemClick(MenuItem menuItem) {
//                            cView.button.setText(menuItem.getTitle());
//
//                            return false;
//                        }
//                    });
//                    popupMenu.show();
//                }
//            });
//            cView.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                    if (b==true){
//                        list[i].major=true;
//                    }else {
//                        list[i].major=false;
//                    }
//                }
//            });
//
//            list[i].grade=4.5;
//            list[i].score=12;
////        list[i].grade=scoreProcess.gradeCal(cView.button.getText().toString());
////        list[i].score =Integer.parseInt(cView.editText.getText().toString());
//
//        }
//
//        @Override
//        public int getItemCount() {
//            return itemCount;
//        }
//
//        private class CustomViewHolder extends RecyclerView.ViewHolder{
//
//            TextView textView;
//            Button button;
//            EditText editText;
//            CheckBox checkBox;
//
//
//            public CustomViewHolder(@NonNull final View itemView) {
//                super(itemView);
//                textView=(TextView)itemView.findViewById(R.id.item_subName);
//                button=(Button)itemView.findViewById(R.id.item_scoreBtn);
//                editText=(EditText)itemView.findViewById(R.id.item_scoreEdt);
//                checkBox=(CheckBox)itemView.findViewById(R.id.item_majorCbx);
//
//            }
//        }
//    }

}

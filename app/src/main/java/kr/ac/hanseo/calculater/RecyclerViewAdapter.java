package kr.ac.hanseo.calculater;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.chauthai.overscroll.RecyclerViewBouncy;

import java.util.ArrayList;
import java.util.List;

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private LayoutInflater inflater;
    public ArrayList<ScoreModel> scoreModels;

    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_PLUS_BTN = 1;

    public RecyclerViewAdapter(Context context,ArrayList<ScoreModel> scoreModels){

        inflater = LayoutInflater.from(context);
        this.scoreModels=scoreModels;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {


        if (viewType == VIEW_TYPE_ITEM) {
            View view = inflater.inflate(R.layout.item_score, viewGroup, false);
            return new ScoreitemViewHolder(view);
        } else {
            View view = inflater.inflate(R.layout.item_plus, viewGroup, false);
            return new PlusBtnViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int i) {

        if (viewHolder instanceof ScoreitemViewHolder) {

            final  ScoreitemViewHolder scoreitemViewHolder=(ScoreitemViewHolder)viewHolder;
            scoreitemViewHolder.textView.setText((i+1)+"번째 과목");

            scoreitemViewHolder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final int k= scoreitemViewHolder.getAdapterPosition();
                    final PopupMenu popupMenu=new PopupMenu(scoreitemViewHolder.button.getContext(),view);
                    popupMenu.getMenuInflater().inflate(R.menu.score_menu,popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            scoreitemViewHolder.button.setText(menuItem.getTitle().toString());
                            scoreModels.get(i).setGrade(scoreitemViewHolder.button.getText().toString());
                            return false;
                        }
                    });
                    popupMenu.show();
                }
            });

            scoreitemViewHolder.textView.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    //scoreModels.get(getAdapterPosition()).setSubName(textView.getText().toString());
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

            scoreitemViewHolder.editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (scoreitemViewHolder.editText.length()==0){
                        return;
                    }else {
                        int value = Integer.parseInt(scoreitemViewHolder.editText.getText().toString());
                        scoreModels.get(i).setScore(value);
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

            scoreitemViewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (scoreitemViewHolder.checkBox.isChecked()){
                        // is major subject
                        scoreModels.get(i).setMajor(true);
                    }else {
                        // is not major subject
                        scoreModels.get(i).setMajor(false);
                    }
                }
            });
        } else if (viewHolder instanceof PlusBtnViewHolder) {
            PlusBtnViewHolder plusBtnViewHolder = (PlusBtnViewHolder)viewHolder;
            plusBtnViewHolder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    scoreModels.set(i,new ScoreModel("A+",0,false));
                    scoreModels.get(i).model=false;
                    scoreModels.add(new ScoreModel(true));
                    notifyDataSetChanged();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return scoreModels.size();
        //return scoreModels == null?0:scoreModels.size();
    }

    @Override
    public int getItemViewType(int position) {
        return scoreModels.get(position).model?VIEW_TYPE_PLUS_BTN:VIEW_TYPE_ITEM;
    }

    public void deleteItem(int position) {
        scoreModels.remove(position);
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }

    private class ScoreitemViewHolder extends RecyclerView.ViewHolder{
        protected TextView textView;
        protected Button button;
        protected EditText editText;
        protected CheckBox checkBox;

        public ScoreitemViewHolder(@NonNull final View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.item_subName);
            button=(Button)itemView.findViewById(R.id.item_scoreBtn);
            editText=(EditText)itemView.findViewById(R.id.item_scoreEdt);
            checkBox=(CheckBox)itemView.findViewById(R.id.item_majorCbx);
        }
    }

    private class PlusBtnViewHolder extends RecyclerView.ViewHolder{
        protected Button button;

        public PlusBtnViewHolder(@NonNull View itemView) {
            super(itemView);
            button=(Button)itemView.findViewById(R.id.item_plusBtn);
        }
    }
}

package kr.ac.hanseo.calculater;

import android.widget.Button;

public class ScoreLetter {
    //field
    int[] sc_id={R.id.Ap,R.id.A,R.id.Bp,R.id.B,R.id.Cp,R.id.C,R.id.D,R.id.F,R.id.Pass,R.id.Fail};


    //constructor


    //method
    public void divide(int id, Button btn){

        if(id==sc_id[0]){
            btn.setText("A+");
        }
        if(id==sc_id[1]){
            btn.setText("A");
        }
        if(id==sc_id[2]){
            btn.setText("B+");
        }
        if(id==sc_id[3]){
            btn.setText("B");
        }
        if(id==sc_id[4]){
            btn.setText("C+");
        }
        if(id==sc_id[5]){
            btn.setText("C");
        }
        if(id==sc_id[6]){
            btn.setText("D");
        }
        if(id==sc_id[7]){
            btn.setText("F");
        }
        if(id==sc_id[8]){

        }
        if(id==sc_id[1]){

        }
    }

}

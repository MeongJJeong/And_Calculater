package kr.ac.hanseo.calculater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Integer[] btnId={R.id.sc_btn1,R.id.sc_btn2,R.id.sc_btn3,R.id.sc_btn4,R.id.sc_btn5,R.id.sc_btn6};
    Integer[] edtId={R.id.name_edt1,R.id.name_edt2,R.id.name_edt3,R.id.name_edt4,R.id.name_edt5,R.id.name_edt6};
    Integer[] scedtId={R.id.score_edt1,R.id.score_edt2,R.id.score_edt3,R.id.score_edt4,R.id.score_edt5,R.id.score_edt6};
    Integer[] cbxId={R.id.cbx1,R.id.cbx2,R.id.cbx3,R.id.cbx4,R.id.cbx5,R.id.cbx6};
    Button[] sc_btn=new Button[6];
    EditText[] nm_edt=new EditText[6];
    EditText[] sc_edt=new EditText[6];
    CheckBox[] cbx=new CheckBox[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0;i<btnId.length;i++){
            sc_btn[i]=(Button)findViewById(btnId[i]);
            registerForContextMenu(sc_btn[i]);
            nm_edt[i]=(EditText)findViewById(edtId[i]);
            sc_edt[i]=(EditText)findViewById(scedtId[i]);
            cbx[i]=(CheckBox)findViewById(cbxId[i]);
            sc_btn[i].setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View view) {

        final ScoreLetter s=new ScoreLetter();
        PopupMenu p=new PopupMenu(
                getApplicationContext(),view);

        for(int i=0;i<btnId.length;i++){
            if(view==sc_btn[i]){
                getMenuInflater().inflate(R.menu.score_menu,p.getMenu());
                final int finalI = i;
                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        int id= menuItem.getItemId();
                        s.divide(id,sc_btn[finalI]);
                        return false;
                    }
                });
                p.show();
            }
        }
    }
}

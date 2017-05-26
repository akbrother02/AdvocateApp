package loadingdata.ashish.advocateapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class IndexActivity extends AppCompatActivity implements View.OnClickListener {
    CardView create, viewall, viewtoday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        create=(CardView)findViewById(R.id.newproject);
        viewall=(CardView)findViewById(R.id.viewallcases);
        viewtoday=(CardView)findViewById(R.id.todaycases);
        create.setOnClickListener(this);
        viewall.setOnClickListener(this);
        viewtoday.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.newproject:
                Intent intent=new Intent(IndexActivity.this,NewCasesActivity.class);
                startActivity(intent);
                break;
            case R.id.viewallcases:
                Intent viewintent=new Intent(IndexActivity.this,ViewAllActivity.class);
                startActivity(viewintent);
                break;
            case R.id.todaycases:
                break;
        }
    }
}

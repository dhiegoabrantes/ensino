package br.edu.nassau.pmob.layouts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.buttonAlturaLargura).setOnClickListener(this);
        findViewById(R.id.buttonMarginPadding).setOnClickListener(this);
        findViewById(R.id.buttonFrameLayout).setOnClickListener(this);
        findViewById(R.id.buttonRelativeLayout).setOnClickListener(this);
        findViewById(R.id.buttonLinearLayout).setOnClickListener(this);
        findViewById(R.id.buttonTableLayout).setOnClickListener(this);
        findViewById(R.id.buttonGridLayout).setOnClickListener(this);
        findViewById(R.id.buttonScrollView).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonAlturaLargura:
                Intent widthHeightActivityIntent = new Intent(this, WidthHeightActivity.class);
                startActivity(widthHeightActivityIntent);
                break;
            case R.id.buttonMarginPadding:
                Intent marginPaddingActivityIntent = new Intent(this, MarginPaddingActivity.class);
                startActivity(marginPaddingActivityIntent);
                break;
            case R.id.buttonFrameLayout:
                Intent frameLayoutActivityIntent = new Intent(this, FrameLayoutActivity.class);
                startActivity(frameLayoutActivityIntent);
                break;
            case R.id.buttonRelativeLayout:
                Intent relativeLayoutActivityIntent = new Intent(this, RelativeLayoutActivity.class);
                startActivity(relativeLayoutActivityIntent);
                break;
            case R.id.buttonLinearLayout:
                Intent linearLayoutActivityIntent = new Intent(this, LinearLayoutActivity.class);
                startActivity(linearLayoutActivityIntent);
                break;
            case R.id.buttonTableLayout:
                Intent tableLayoutActivityIntent = new Intent(this, TableLayoutActivity.class);
                startActivity(tableLayoutActivityIntent);
                break;
            case R.id.buttonGridLayout:
                Intent gridLayoutActivityIntent = new Intent(this, GridLayoutActivity.class);
                startActivity(gridLayoutActivityIntent);
                break;
            case R.id.buttonScrollView:
                Intent scrollViewActivityIntent = new Intent(this, ScrollViewActivity.class);
                startActivity(scrollViewActivityIntent);
                break;
        }
    }
}

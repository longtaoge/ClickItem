package org.xiangbalao.clickitem;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.xiangbalao.common.MenuItem;
import org.xiangbalao.glide.GlideDemoActivity;

import xiangbalao.org.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MenuItem mi_item;
    private TextView tv_1;
    private TextView tv_2;
    private TextView tv_3;
    private LinearLayout ll_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);





        final Bitmap bmp = tv_2.getDrawingCache();

          fab.setImageBitmap(bmp);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent mIntent =new Intent(MainActivity.this, GlideDemoActivity.class);

                startActivity(mIntent);

            }
        });
    }


    private void initView() {
        mi_item = (MenuItem) findViewById(R.id.mi_item);


//      mi_item.setmClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.i(MainActivity.class.getSimpleName(), "click");
//                Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

          mi_item.setOnClickListener(this);






        tv_1 = (TextView) findViewById(R.id.tv_1);
        tv_1.setOnClickListener(this);
        tv_2 = (TextView) findViewById(R.id.tv_2);
        tv_3 = (TextView) findViewById(R.id.tv_3);
        tv_3.setOnClickListener(this);
        ll_item = (LinearLayout) findViewById(R.id.ll_item);
        ll_item.setOnClickListener(this);


    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

    }
}

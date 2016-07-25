package org.xiangbalao.glide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.orhanobut.hawk.Hawk;
import com.orhanobut.hawk.HawkBuilder;
import com.orhanobut.hawk.LogLevel;

import xiangbalao.org.R;

public class GlideDemoActivity extends AppCompatActivity implements View.OnClickListener {

    private   String url="http://img4.imgtn.bdimg.com/it/u=2203500063,2960982047&fm=21&gp=0.jpg";
    private  String url1="http://image30.360doc.com/DownloadImg/2011/06/1617/12959767_8.jpg";
    private ImageView imageView;
    private ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Hawk.init(this)
                .setEncryptionMethod(HawkBuilder.EncryptionMethod.MEDIUM)
                .setStorage(HawkBuilder.newSqliteStorage(this))
                .setLogLevel(LogLevel.FULL)
                .build();

        setContentView(R.layout.glide_demo_main);



        initView();


    }


    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

    }

    private void initView() {
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);




   /*     Glide.with(GlideDemoActivity.this)
                .load(url)
                .into(imageView);*/

        GlideUtils.loadImage(GlideDemoActivity.this,url,imageView);


        Glide.with(GlideDemoActivity.this)
                .load(url1)
                .into(imageView2);

    }
}

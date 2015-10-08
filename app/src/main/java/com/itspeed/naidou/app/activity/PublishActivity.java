package com.itspeed.naidou.app.activity;

import android.os.Bundle;
import android.view.Window;
import android.widget.RelativeLayout;

import com.itspeed.naidou.R;
import com.itspeed.naidou.app.fragment.PublishCookbookFragment;
import com.itspeed.naidou.app.util.LayoutUtils;

import org.kymjs.kjframe.KJActivity;
import org.kymjs.kjframe.ui.BindView;

/**
 * Created by jafir on 15/10/8.
 */
public class PublishActivity extends KJActivity {

    private PublishCookbookFragment publishCookbookFragment;
    @BindView(id = R.id.publish_view)
    private RelativeLayout mView;

    @Override
    public void setRootView() {
        setContentView(R.layout.activity_publish);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        //设置状态栏 包括颜色改变
        LayoutUtils.init1(aty, mView, R.color.topic_red);

        publishCookbookFragment = new PublishCookbookFragment();
        changeFragment(R.id.publish_frame, publishCookbookFragment);

    }
}

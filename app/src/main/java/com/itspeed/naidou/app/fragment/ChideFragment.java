package com.itspeed.naidou.app.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itspeed.naidou.R;
import com.itspeed.naidou.app.activity.MainActivity;
import com.itspeed.naidou.app.activity.TitleBarActivity;
import com.itspeed.naidou.app.util.UIHelper;
import com.itspeed.naidou.app.view.EmptyLayout;

import org.kymjs.kjframe.ui.BindView;
import org.kymjs.kjframe.ui.ViewInject;
import org.kymjs.kjframe.utils.KJLoger;

/**
 * Created by jafir on 15/9/1.
 * 吃的fragment
 * 包括 分类  父母（）孩子（）
 *
 */
public class ChideFragment extends TitleBarSupportFragment{


    private MainActivity aty;
    //父母的fragment
    private ParentFragment parentFragment;
    //孩子的fragment
    private ChildrenFragment childrenFragment;


    private Handler handler;

    @BindView(id = R.id.empty_layout)
    private EmptyLayout mEmptyLayout;

    @Override
    protected View inflaterView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View  view = View.inflate(aty,R.layout.frag_chide,null);
        return  view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //第一次手动调用
        onChange();
        aty = (MainActivity) getActivity();

        parentFragment = new ParentFragment();
        childrenFragment = new ChildrenFragment();
        changeFragment(R.id.cookbood_fl, parentFragment);
    }


    @Override
    protected void initData() {
        super.initData();
        handler =  new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                KJLoger.debug("2222222");
                mEmptyLayout.dismiss();
            }
        };
        handler.sendEmptyMessageDelayed(1, 3000);
    }

    @Override
    public void onChange() {
        super.onChange();
        setTitleType(TitleBarActivity.TitleBarType.Titlebar1);
        setBackImage(R.drawable.selector_titlebar_search);
        setMenuImage(R.drawable.selector_titlebar_add);
    }


    @Override
    public void onMenuClick() {
        super.onMenuClick();
        UIHelper.showPublish(aty);
    }


    @Override
    public void onBackClick() {
        super.onBackClick();
        ViewInject.toast("点击了back");
    }

    @Override
    public void onSegmentClick(int index) {
        super.onSegmentClick(index);
        KJLoger.debug("点击了："+index);
        switch (index){
            case 0:
                changeFragment(R.id.cookbood_fl,parentFragment);
                break;
            case 1:
                changeFragment(R.id.cookbood_fl,childrenFragment);
                break;
        }

    }

}

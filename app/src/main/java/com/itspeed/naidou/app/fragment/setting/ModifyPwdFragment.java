package com.itspeed.naidou.app.fragment.setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.itspeed.naidou.R;
import com.itspeed.naidou.app.activity.SimpleBackActivity;
import com.itspeed.naidou.app.activity.TitleBarActivity;
import com.itspeed.naidou.app.fragment.TitleBarSupportFragment;

import org.kymjs.kjframe.ui.BindView;

/**
 * Created by jafir on 15/9/28.
 * 设置里面 修改密码  fragment
 */
public class ModifyPwdFragment extends TitleBarSupportFragment{

    private SimpleBackActivity aty;
    private View layout;

    @BindView(id = R.id.modifypwd_confirm,click = true)
    private ImageView confirm;

    @Override
    protected View inflaterView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layout = View.inflate(aty, R.layout.frag_modifypwd,null);
        return layout;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        aty = (SimpleBackActivity) getActivity();
        onChange();
    }

    @Override
    public void onChange() {
        super.onChange();
        setTitleType(TitleBarActivity.TitleBarType.Titlebar2);
        setBackImage(R.drawable.selector_title_back);
        setTitle("修改密码");
        setMenuImage(null);
    }

    @Override
    protected void widgetClick(View v) {
        super.widgetClick(v);
        switch (v.getId()){
            case R.id.modifypwd_confirm:
                break;
        }
    }

    @Override
    public void onBackClick() {
        super.onBackClick();
        aty.finish();
    }
    @Override
    public void onDestroy() {
        aty = null;
        layout= null;
        confirm = null;
        super.onDestroy();
    }
}
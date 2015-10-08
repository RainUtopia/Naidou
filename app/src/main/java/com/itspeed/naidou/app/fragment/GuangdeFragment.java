package com.itspeed.naidou.app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.itspeed.naidou.R;
import com.itspeed.naidou.app.activity.MainActivity;
import com.itspeed.naidou.app.activity.TitleBarActivity;
import com.itspeed.naidou.app.adapter.GuangdeGridViewAdapter;

import org.kymjs.kjframe.ui.BindView;

/**
 * Created by jafir on 15/9/1.
 */
public class GuangdeFragment extends TitleBarSupportFragment {

    MainActivity aty;
    private View view;
    @BindView(id = R.id.guangde_gridview)
    private GridView mGridView;


    @Override
    protected View inflaterView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        aty = (MainActivity) getActivity();
        onChange();
        view = View.inflate(aty,R.layout.frag_guangde,null);
        return view;
    }



    @Override
    public void onChange() {
        super.onChange();
        setTitleType(TitleBarActivity.TitleBarType.Titlebar2);
        setTitle("逛的");
        setBackImage(null);
        setMenuImage(null);
    }


    @Override
    protected void initData() {
        super.initData();
        mGridView.setAdapter(new GuangdeGridViewAdapter());
    }
}

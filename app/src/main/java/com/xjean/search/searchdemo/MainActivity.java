package com.xjean.search.searchdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.xjean.search.SearchFragment;
import com.xjean.search.custom.IOnSearchClickListener;

public class MainActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener, IOnSearchClickListener {

    private Toolbar toolbar;
    private TextView search_info;
    private SearchFragment searchFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();
        toolbar.setTitle("SearchDialog");//标题
        setSupportActionBar(toolbar);

        searchFragment = SearchFragment.newInstance();//初始化

        toolbar.setOnMenuItemClickListener(this);//标题菜单

        searchFragment.setOnSearchClickListener(this);//查询fragment

    }

    private void initView() {

        toolbar = findViewById(R.id.toolbar);
        search_info = findViewById(R.id.search_info);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //加载菜单文件
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search://点击搜索
                searchFragment.show(getSupportFragmentManager(), SearchFragment.TAG);
                break;
        }
        return true;
    }

    @Override
    public void OnSearchClick(String keyword) {
        search_info.setText(keyword);
    }

}

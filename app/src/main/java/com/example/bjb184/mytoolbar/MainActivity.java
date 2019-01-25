package com.example.bjb184.mytoolbar;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = this.findViewById(R.id.toolBar);
        toolbar.setTitle("MyToolBar");

        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.mipmap.ic_back);//设置返回的图标
      /*  toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int id = menuItem.getItemId();
                String msg = "";
                switch (id) {
                    case android.R.id.home:
                        onBackPressed();
                        break;
                    case R.id.action_search:
                        msg = "action_search";
                        break;
                    case R.id.action_intent:
               *//*         msg = "action_intent";
                        //这个地方要注意使用这种方式增加actionprovider不然会报错
                MenuItemCompat.setActionProvider(menuItem, new MyActionProvider(MainActivity.this));*//*
                        break;
                    default:
                        break;

                }
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                return true;
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) searchItem.getActionView();
        //The default value is true ，
        // 设置为true直接展开显示 左侧有放大镜 右侧无叉叉 有输入内容后有叉叉,且会隐藏掉左侧放大镜
        // 设置为false直接展开显示 左侧有放大镜 右侧无叉叉 有输入内容后有叉叉
//        searchView.setIconifiedByDefault(true);
        //设置为false 左侧无放大镜 右侧有叉叉
        //设置为true 左侧有放大镜 右侧有叉叉
        searchView.setIconified(true);
//        ImageView submit = searchView.findViewById(R.id.search_go_btn);
//        submit.setImageResource(R.mipmap.ic_launcher_round);

        //内部调用了setIconified(false); 直接展开显示 左侧无放大镜 右侧无叉叉 有输入内容后有叉叉
//        searchView.onActionViewExpanded();

        //设置最右侧的提交按钮
        searchView.setSubmitButtonEnabled(false);
        searchView.setInputType(1);//.setImeOptions(SearchView.);
//        searchItem.expandActionView(); //展开SearchView
//        searchItem.collapseActionView(); //收缩SearchView

        /*三、SearchView一些属性
        如果想更改android默认的一些图标或者颜色的，可通过下边的属性进行。
        //输入框文字
        (TextView) findViewById(R.id.search_src_text);
        //右侧提交按钮
        (ImageView) findViewById(R.id.search_go_btn);
        //右侧关闭按钮(输入文字后出现的x)
        (ImageView) findViewById(R.id.search_close_btn);
        //语音输入按钮
        (ImageView) findViewById(R.id.search_voice_btn);
        //输入框内Icon
        (ImageView) findViewById(R.id.search_mag_icon);*/
        searchItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                Toast.makeText(MainActivity.this, "案秀云Expand!", Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
//                finish();
                Toast.makeText(MainActivity.this, "案秀云Collapse", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        String msg = "";
        switch (id) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.action_search:
                msg = "action_search";
                break;
            case R.id.action_intent:
                msg = "action_intent";
                //这个地方要注意使用这种方式增加actionprovider不然会报错
//                MenuItemCompat.setActionProvider(item, new MyActionProvider(MainActivity.this));
                break;

            case R.id.toolbar_r_1:
                msg = "登录";
                break;
            default:
                msg="未找到事件监听";
                break;

        }
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}

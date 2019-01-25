package com.example.bjb184.mytoolbar;

import android.content.Context;
import android.support.v4.view.ActionProvider;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Toast;

/**
 * 子菜单
 * Created by Administrator on 2015/8/14.
 */
public class MyActionProvider extends ActionProvider {
    private Context context;
    public MyActionProvider(Context context) {
        super(context);
        this.context = context;

    }

    @Override
    public View onCreateActionView() {
        return null;
    }

    @Override
    public boolean hasSubMenu() {
        return true;
    }

    @Override
    public void onPrepareSubMenu(SubMenu subMenu) {
        subMenu.clear();
        subMenu.add("sub item1")
                .setIcon(R.drawable.ic_launcher_background)
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                                                @Override
                                                public boolean onMenuItemClick(MenuItem item) {
                                                    Toast.makeText(context, "item1", Toast.LENGTH_SHORT).show();

                                                    return false;
                                                }
                                            }
                );

        subMenu.add("sub item2")
                .setIcon(R.drawable.ic_launcher_foreground)
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                                                @Override
                                                public boolean onMenuItemClick(MenuItem item) {
                                                    Toast.makeText(context, "item2", Toast.LENGTH_SHORT).show();

                                                    return false;
                                                }

                                            }
                );


        super.onPrepareSubMenu(subMenu);
    }
}
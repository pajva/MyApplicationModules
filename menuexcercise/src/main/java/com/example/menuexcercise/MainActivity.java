package com.example.menuexcercise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.snackbar.SnackbarContentLayout;

public class MainActivity extends AppCompatActivity implements MenuItem.OnMenuItemClickListener, PopupMenu.OnMenuItemClickListener {
    private final int share_item_id = 101;
    private boolean isItemAdd = false;
    private Button bt_op,bt_cn,bt_pop,button,navi_draw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_op=findViewById(R.id.btn_option);
        bt_op.setOnClickListener(onClickListener);
        bt_cn=findViewById(R.id.btn_context);
        bt_cn.setOnClickListener(onClickListener);
        registerForContextMenu(bt_cn);
        bt_pop=findViewById(R.id.btn_popup);
        bt_pop.setOnClickListener(onClickListener);
        button=findViewById(R.id.bt_optionprepare);
        navi_draw=findViewById(R.id.nav_draw);
        navi_draw.setOnClickListener(onClickListener);

    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.btn_option:
                    Toast.makeText(MainActivity.this, "Click overflow Button In the ActionBar", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_context:
                    Toast.makeText(MainActivity.this, "LongPress To Show ContextMenu", Toast.LENGTH_SHORT).show();
                    Snackbar.make(view, "This is main activity", Snackbar.LENGTH_LONG)
                            .setAction("CLOSE", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                }
                            })
                            .setActionTextColor(getResources().getColor(android.R.color.holo_red_light ))
                            .show();
                    break;
                case R.id.btn_popup:
                    showPopupMenu(view);
                    break;
                case R.id.bt_optionprepare:
                    Toast.makeText(MainActivity.this, "Share Option Added", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_draw:
                    Intent intent = new Intent(MainActivity.this,NavigationDrawerActivity.class);
                    startActivity(intent);
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.op_delete:
                Toast.makeText(this, "Delete...", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.op_save:
                Toast.makeText(this, "Save...", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.op_share:
                Toast.makeText(this, "Share...", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void manageShareOption(View view) {
        if (!isItemAdd)
        {
            isItemAdd=true;
            button.setText("Remove New Option");
            invalidateOptionsMenu();
        }
        else
        {
            isItemAdd=false;
            button.setText("Add New Option");
            invalidateOptionsMenu();
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (isItemAdd)
        {
            if(menu.findItem(share_item_id)==null)
            {
                MenuItem shareItem = menu.add(Menu.NONE,share_item_id,5,"New");
                shareItem.setIcon(R.drawable.ic_new_folder);
                shareItem.setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_ALWAYS);
                shareItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Toast.makeText(MainActivity.this, "Create New", Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
            }
        }
        else
        {
            menu.removeItem(share_item_id);
        }

        super.onPrepareOptionsMenu(menu);
        return true;
    }

    public void showPopupMenu(View v){
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.popup_menu);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch(menuItem.getItemId()){
            case R.id.item_setwal:
                Toast.makeText(this, "Wallpaper Changed", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_edit:
                Toast.makeText(this, "Edit Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_share:
                Toast.makeText(this, "Share Clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected( MenuItem item) {
        switch (item.getItemId()) {
            case R.id.co_send:
                Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.co_delete:
                Toast.makeText(this, "Delete....", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.co_edit:
                Toast.makeText(this, "Edit...", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }



}
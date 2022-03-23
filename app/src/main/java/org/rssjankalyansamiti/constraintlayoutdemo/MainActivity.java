package org.rssjankalyansamiti.constraintlayoutdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int MENU_INFO = 1, MENU_HELP = 2, MENU_SETTINGS = 3;
    final int MENU_PHONE_SETTINGS = 10, MENU_SYSTEM_SETTINGS = 11;
    private CheckBox chkSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkSettings = findViewById(R.id.chkSettings);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        mt("onCreateOptionsMenu");

        MenuItem menuItem;
        menuItem = menu.add(1, MENU_INFO, 0, "Info");
        menuItem.setIcon(R.mipmap.ic_launcher);
        menuItem.setAlphabeticShortcut('i');
        menuItem.setNumericShortcut('9');
        menuItem.setCheckable(true);
        menuItem.setChecked(true);

        menuItem = menu.add(1, MENU_HELP, 0, "Help");
        menuItem.setCheckable(true);

        SubMenu subMenu  = menu.addSubMenu(1, MENU_SETTINGS, 0, "Settings");
        subMenu.add(2, MENU_PHONE_SETTINGS, 0, "Phone Settings");
        subMenu.add(2, MENU_SYSTEM_SETTINGS, 0, "System Settings");
        /*if(chkSettings.isChecked()) {
            menuItem.setEnabled(true);
        }
        else {
            menuItem.setEnabled(false);
        }*/


        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        mt("onPrepareOptionsMenu");
        MenuItem menuItem = menu.findItem(MENU_SETTINGS);
        menuItem.setEnabled(chkSettings.isChecked());
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case MENU_INFO:
                mt("Info");
                break;
            case MENU_HELP:
                mt("Help");
                break;
            case MENU_SETTINGS:
                mt("Settings");
                break;
            case MENU_PHONE_SETTINGS:
                mt("Phone Settings");
                break;
            case MENU_SYSTEM_SETTINGS:
                mt("System Settings");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void mt(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}
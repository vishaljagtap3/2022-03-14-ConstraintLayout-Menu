package org.rssjankalyansamiti.constraintlayoutdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int MENU_INFO = 1, MENU_HELP = 2, MENU_SETTINGS = 3;
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

        menuItem = menu.add(1, MENU_SETTINGS, 0, "Settings");
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
        }
        return super.onOptionsItemSelected(item);
    }

    private void mt(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}
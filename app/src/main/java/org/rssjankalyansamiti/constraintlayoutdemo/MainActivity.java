package org.rssjankalyansamiti.constraintlayoutdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int MENU_INFO = 1, MENU_HELP = 2, MENU_SETTINGS = 3;
    final int MENU_PHONE_SETTINGS = 10, MENU_SYSTEM_SETTINGS = 11;
    final int MENU_COPY = 101, MENU_CUT = 102, MENU_PASTE = 103, MENU_APPEND = 104;
    private CheckBox chkSettings;

    private TextView txtInfo;
    private EditText edtInfo;

    private String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkSettings = findViewById(R.id.chkSettings);
        txtInfo = findViewById(R.id.txtInfo);
        edtInfo = findViewById(R.id.edtInfo);

        registerForContextMenu(txtInfo);
        registerForContextMenu(edtInfo);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);

        mt("onCreateContextMenu");

        if(view == txtInfo) {
            menu.add(1, MENU_PASTE, 0, "Paste");
            menu.add(1, MENU_APPEND, 0, "Append");
        }
        if(view.getId() == R.id.edtInfo) {
            menu.add(1, MENU_COPY, 0, "Copy");
            menu.add(1, MENU_CUT, 0, "Cut");
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case MENU_COPY:
                data = edtInfo.getText().toString();
                break;
            case MENU_CUT:
                data = edtInfo.getText().toString();
                edtInfo.setText("");
                break;
            case MENU_PASTE:
                txtInfo.setText(data);
                break;
            case MENU_APPEND:
                txtInfo.append(data);
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        mt("onCreateOptionsMenu");

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_activity_menu, menu);


        /*MenuItem menuItem;
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
        subMenu.add(2, MENU_SYSTEM_SETTINGS, 0, "System Settings");*/
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
        //MenuItem menuItem = menu.findItem(MENU_SETTINGS);
        MenuItem menuItem = menu.findItem(R.id.menuSettings);
        menuItem.setEnabled(chkSettings.isChecked());
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            //case MENU_INFO:
            case R.id.menuInfo:
                mt("Info");
                break;
            //case MENU_HELP:
            case R.id.menuHelp:
                mt("Help");
                break;
            //case MENU_SETTINGS:
            case R.id.menuSettings:
                mt("Settings");
                break;
            //case MENU_PHONE_SETTINGS:
            case R.id.menuPhoneSettings:
                mt("Phone Settings");
                break;
            //case MENU_SYSTEM_SETTINGS:
            case R.id.menuSystemSettings:
                mt("System Settings");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void mt(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}
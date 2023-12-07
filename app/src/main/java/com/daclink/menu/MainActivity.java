package com.daclink.menu;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.daclink.menu.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    boolean isVisible = true;
    Button button;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        button = binding.ButtonMenuShow;

        invalidateOptionsMenu();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public void menuItemToggle(View view){
        isVisible = !isVisible;
        Toast.makeText(this, "Visible == " + isVisible, Toast.LENGTH_SHORT).show();
        if(isVisible){
            button.setText(R.string.here);
        }else{
            button.setText(R.string.not_here);
        }
        invalidateOptionsMenu();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(R.id.showHide);
        item.setVisible(isVisible);
        return true;
    }
}
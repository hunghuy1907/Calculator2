package com.example.admin.calculator2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private CalculatorFragment mCalculatorFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_calculator, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_clear:
                mCalculatorFragment.clickAC();
                return true;

            case R.id.item_save:
                mCalculatorFragment.getOldResult();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showFragment() {
        mCalculatorFragment = new CalculatorFragment();
        getFragmentManager().beginTransaction().add(R.id.frame_layout, mCalculatorFragment).commit();
    }
}

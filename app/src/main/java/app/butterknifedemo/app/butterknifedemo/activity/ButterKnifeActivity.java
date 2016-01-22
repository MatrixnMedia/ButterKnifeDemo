package app.butterknifedemo.app.butterknifedemo.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import app.butterknifedemo.R;
import app.butterknifedemo.app.butterknifedemo.fragment.ButterKnifeFragment;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class ButterKnifeActivity extends FragmentActivity {

    @InjectView(R.id.text)
    TextView textview;
    @InjectView(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butterknife_main);
        ButterKnife.inject(this);

        textview.setText("This Activity use Butter Knife!");
        button.setText("Activity button");

        //replacing fragment in activity
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ButterKnifeFragment f = new ButterKnifeFragment();
        ft.replace(R.id.fragment, f);
        ft.commit();

    }


    @OnClick(R.id.button)
    void onClick() {
        Toast.makeText(this, "Activity Button onClick!", Toast.LENGTH_SHORT).show();
    }


}

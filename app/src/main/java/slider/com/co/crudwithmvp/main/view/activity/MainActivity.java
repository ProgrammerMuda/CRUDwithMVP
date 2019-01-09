package slider.com.co.crudwithmvp.main.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import slider.com.co.crudwithmvp.R;
import slider.com.co.crudwithmvp.main.presenter.MainPresenter;
import slider.com.co.crudwithmvp.main.view.fragment.MainFragment;
import slider.com.co.crudwithmvp.utils.ActivityUtils;
import slider.com.co.crudwithmvp.utils.Injection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MainFragment mainFragment = MainFragment.newInstance();
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), mainFragment, R.id.fl_main);

        new MainPresenter(Injection.proviceMainRepository(this), mainFragment);

    }
}

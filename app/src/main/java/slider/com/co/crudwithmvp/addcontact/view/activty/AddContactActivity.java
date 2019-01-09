package slider.com.co.crudwithmvp.addcontact.view.activty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import slider.com.co.crudwithmvp.R;
import slider.com.co.crudwithmvp.addcontact.presenter.AddContactPresenter;
import slider.com.co.crudwithmvp.addcontact.view.fragment.AddContactFragment;
import slider.com.co.crudwithmvp.utils.ActivityUtils;
import slider.com.co.crudwithmvp.utils.Injection;

public class AddContactActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 9165;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        AddContactFragment addContactFragment = AddContactFragment.newInstance();
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), addContactFragment, R.id.fl_add_contact);

        new AddContactPresenter(Injection.proviceAddContactRepository(this), addContactFragment);


    }
}

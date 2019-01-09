package slider.com.co.crudwithmvp.utils;

import android.content.Context;
import android.support.annotation.NonNull;

import slider.com.co.crudwithmvp.addcontact.datasource.AddContactRepository;
import slider.com.co.crudwithmvp.addcontact.datasource.local.AddContactLocalDataSource;
import slider.com.co.crudwithmvp.main.datasource.MainRepository;
import slider.com.co.crudwithmvp.main.datasource.local.MainLocalDataSource;

public class Injection {

    public static MainRepository proviceMainRepository(@NonNull Context context) {
        return MainRepository.getInstance(MainLocalDataSource.getInstance(context));
    }

    /**
     * Method yang digunakan untuk menginject add contact repository
     *
     * @param context merupakan context dari activity
     * @return merupakan object main repository
     */
    public static AddContactRepository proviceAddContactRepository(@NonNull Context context) {
        return AddContactRepository.getInstance(AddContactLocalDataSource.getsInstance(context));
    }

}

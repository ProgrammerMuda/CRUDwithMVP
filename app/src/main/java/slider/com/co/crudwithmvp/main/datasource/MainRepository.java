package slider.com.co.crudwithmvp.main.datasource;

import android.support.annotation.NonNull;

import java.util.List;

import slider.com.co.crudwithmvp.main.datasource.local.MainLocalDataSource;
import slider.com.co.crudwithmvp.main.model.Contact;

public class MainRepository implements MainDataSource {

    private static MainRepository sInstance = null;
    private MainLocalDataSource mMainLocalDataSource;

    private MainRepository(@NonNull MainLocalDataSource mainLocalDataSource) {
        mMainLocalDataSource = mainLocalDataSource;
    }

    public static MainRepository getInstance(@NonNull MainLocalDataSource mainLocalDataSource) {
        if (sInstance == null)
            sInstance = new MainRepository(mainLocalDataSource);

        return sInstance;
    }

    public static void destroyInstance() {
        sInstance = null;
    }

    @Override
    public void loadContacts(@NonNull List users, @NonNull LoadContactsCallback loadContactsCallback) {
        mMainLocalDataSource.loadContacts(users, loadContactsCallback);
    }

    @Override
    public void editContact(@NonNull Contact contact, @NonNull EditContactCallback editContactCallback) {
        // TODO edit contacts
    }

    @Override
    public void deleteContact(@NonNull Contact contact, @NonNull DeleteContactCallback deleteContactCallback) {
        mMainLocalDataSource.deleteContact(contact, deleteContactCallback);
    }
}


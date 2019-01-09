package slider.com.co.crudwithmvp.addcontact.datasource;

import android.support.annotation.NonNull;

import slider.com.co.crudwithmvp.addcontact.datasource.local.AddContactLocalDataSource;
import slider.com.co.crudwithmvp.main.model.Contact;

public class AddContactRepository implements AddContactDataSource {

    private static AddContactRepository sInstance = null;
    private AddContactLocalDataSource mAddContactLocalDataSource;

    private AddContactRepository(@NonNull AddContactLocalDataSource addContactLocalDataSource) {
        mAddContactLocalDataSource = addContactLocalDataSource;
    }

    public static AddContactRepository getInstance(@NonNull AddContactLocalDataSource addContactLocalDataSource) {
        if (sInstance == null)
            sInstance = new AddContactRepository(addContactLocalDataSource);

        return sInstance;
    }

    public static void destroyInstance() {
        sInstance = null;
    }


    @Override
    public void insertContact(@NonNull Contact contact, @NonNull InsertContactCallBack insertContactCallBack) {
        mAddContactLocalDataSource.insertContact(contact, insertContactCallBack);

    }
}

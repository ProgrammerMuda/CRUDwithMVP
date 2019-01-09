package slider.com.co.crudwithmvp.main.datasource;

import android.support.annotation.NonNull;

import java.util.List;

import slider.com.co.crudwithmvp.main.model.Contact;

public interface MainDataSource {

    interface LoadContactsCallback {

        void onLoadSuccess();
        void onLoadFailed();
    }

    interface EditContactCallback {

        void onEditSuccess(@NonNull Contact contact);
        void onEditFailed();
    }

    interface DeleteContactCallback {

        void onDeleteSuccess(@NonNull Contact contact);
        void onDeleteFailed();
    }

    void loadContacts(@NonNull List users, @NonNull LoadContactsCallback loadContactsCallback);
    void editContact(@NonNull Contact contact, @NonNull EditContactCallback editContactCallback);
    void deleteContact(@NonNull Contact contact, @NonNull DeleteContactCallback deleteContactCallback);
}

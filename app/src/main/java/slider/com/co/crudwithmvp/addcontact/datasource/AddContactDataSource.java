package slider.com.co.crudwithmvp.addcontact.datasource;

import android.support.annotation.NonNull;

import slider.com.co.crudwithmvp.main.model.Contact;

public interface AddContactDataSource {

    interface InsertContactCallBack{

        void onInsertSuccess();
        void onInsertFailed();

    }

    void insertContact(@NonNull  Contact contact, @NonNull InsertContactCallBack insertContactCallBack);

}

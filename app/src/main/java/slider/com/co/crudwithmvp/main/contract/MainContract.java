package slider.com.co.crudwithmvp.main.contract;

import android.content.Intent;
import android.support.annotation.NonNull;

import java.util.List;

import slider.com.co.crudwithmvp.base.BasePresenter;
import slider.com.co.crudwithmvp.base.BaseView;
import slider.com.co.crudwithmvp.main.model.Contact;

public interface MainContract {


    interface View extends BaseView<Presenter> {

        void showContacts();
        void showContactMenu(@NonNull Contact contact, @NonNull android.view.View view);
        void updateDeletedContacts(@NonNull Contact contact);
        void showAddContact();
        void showAddUserMessage(@NonNull String message);
    }

    interface Presenter extends BasePresenter {

        void loadContacs(@NonNull List users);
        void openContactMenu(@NonNull Contact contact, @NonNull android.view.View view);
        void editContact(@NonNull Contact contact);
        void deleteContact(@NonNull Contact contact);
        void openAddContact();
        void resultAddContact(@NonNull Integer requestCode, @NonNull Integer resultCode,
                              @NonNull Intent data);
    }


}

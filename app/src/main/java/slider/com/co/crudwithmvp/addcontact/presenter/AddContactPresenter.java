package slider.com.co.crudwithmvp.addcontact.presenter;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import slider.com.co.crudwithmvp.addcontact.contract.AddContractContract;
import slider.com.co.crudwithmvp.addcontact.datasource.AddContactDataSource;
import slider.com.co.crudwithmvp.addcontact.datasource.AddContactRepository;
import slider.com.co.crudwithmvp.main.model.Contact;

public class AddContactPresenter implements AddContractContract.Presenter {

    private final AddContractContract.View mView;
    private final AddContactRepository mAddContactRepository;

    public AddContactPresenter(AddContactRepository addContactRepository, AddContractContract.View view) {
        mAddContactRepository = addContactRepository;
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void saveContact(@NonNull Contact contact) {

        mView.showProgressDialog();

        if (TextUtils.isEmpty(contact.getmName()))
            mView.showNameEmpty();
        else {
            mView.hideNameEmpty();
            mAddContactRepository.insertContact(contact, new AddContactDataSource.InsertContactCallBack() {

                @Override
                public void onInsertSuccess() {
                    mView.hideProgressDialog();
                    mView.finishView("Insert contact success");
                }

                @Override
                public void onInsertFailed() {
                    mView.hideProgressDialog();
                    mView.finishView("Insert contact failed");
                }
            });
        }


    }


    @Override
    public void onCreate(){

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }
}

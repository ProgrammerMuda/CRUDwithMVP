package slider.com.co.crudwithmvp.addcontact.contract;

import android.support.annotation.NonNull;

import slider.com.co.crudwithmvp.base.BasePresenter;
import slider.com.co.crudwithmvp.base.BaseView;
import slider.com.co.crudwithmvp.main.model.Contact;

public interface AddContractContract {

    interface View extends BaseView<Presenter>{

        void showNameEmpty();
        void hideNameEmpty();
        void showProgressDialog();
        void hideProgressDialog();
        void finishView(@NonNull String message);

    }

    interface Presenter extends BasePresenter{

        void saveContact(@NonNull Contact contact);

    }

}

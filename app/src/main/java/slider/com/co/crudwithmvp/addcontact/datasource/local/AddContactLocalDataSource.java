package slider.com.co.crudwithmvp.addcontact.datasource.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import slider.com.co.crudwithmvp.addcontact.datasource.AddContactDataSource;
import slider.com.co.crudwithmvp.main.datasource.local.ContactHelper;
import slider.com.co.crudwithmvp.main.model.Contact;

public class AddContactLocalDataSource implements AddContactDataSource {

    private static AddContactLocalDataSource sInstance = null;
    private final Context mContext;
    private final ContactHelper mContactHelper;

    private AddContactLocalDataSource(@NonNull Context context){
        mContext = context;
        mContactHelper = new ContactHelper(mContext);
    }

    public static AddContactLocalDataSource getsInstance(@NonNull Context context){
        if (sInstance == null)
            sInstance = new AddContactLocalDataSource(context);
        return sInstance;
    }

    public static void destroyInstance(){
        sInstance = null;
    }

    @Override
    public void insertContact(@NonNull Contact contact, @NonNull InsertContactCallBack insertContactCallBack) {

        SQLiteDatabase sqLiteDatabase = mContactHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(ContactHelper.CONTACTS_COLUMN_NAME, contact.getmName());
        contentValues.put(ContactHelper.CONTACTS_COLUMN_PHONE, contact.getmPhone());
        contentValues.put(ContactHelper.CONTACTS_COLUMN_EMAIL, contact.getmEmail());
        contentValues.put(ContactHelper.CONTACTS_COLUMN_STREET, contact.getmStreet());
        contentValues.put(ContactHelper.CONTACTS_COLUMN_PLACE, contact.getmPlace());

        long returnValue = sqLiteDatabase.insert(ContactHelper.CONTACTS_TABLE_NAME, null, contentValues);

        if (returnValue == -1)
            insertContactCallBack.onInsertFailed();
        else
            insertContactCallBack.onInsertSuccess();

    }
}

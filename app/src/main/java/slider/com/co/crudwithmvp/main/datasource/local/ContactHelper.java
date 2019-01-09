package slider.com.co.crudwithmvp.main.datasource.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import slider.com.co.crudwithmvp.main.model.Contact;

public class ContactHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Contacts.db";
    public static final String CONTACTS_TABLE_NAME = "contacts";
    public static final String CONTACTS_COLUMN_ID = "id";
    public static final String CONTACTS_COLUMN_NAME =  "name";
    public static final String CONTACTS_COLUMN_PHONE = "phone";
    public static final String CONTACTS_COLUMN_EMAIL = "email";
    public static final String CONTACTS_COLUMN_STREET = "street";
    public static final String CONTACTS_COLUMN_PLACE = "place";

    private Context mContext;


    public ContactHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableSQL = "create table " + CONTACTS_TABLE_NAME + " (" + CONTACTS_COLUMN_ID +
                " integer primary key, " + CONTACTS_COLUMN_NAME + " text, " + CONTACTS_COLUMN_PHONE +
                " text, " + CONTACTS_COLUMN_EMAIL + " text, " + CONTACTS_COLUMN_STREET + " text, " +
                CONTACTS_COLUMN_PLACE + " text)";
        db.execSQL(createTableSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String dropTableSQL = "drop table if exists " + CONTACTS_TABLE_NAME;
        db.execSQL(dropTableSQL);
        onCreate(db);

    }


    public Contact relationalToObject(int id, String name, String phone, String email,
                                      String street, String place) {
        return new Contact(id, name, phone, email, street, place);
    }
}

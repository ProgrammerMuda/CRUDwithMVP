package slider.com.co.crudwithmvp.main.model;

public class Contact {

    private int mId;
    private String mName;
    private String mPhone;
    private String mEmail;
    private String mStreet;
    private String mPlace;

    public int getmId() {
        return mId;
    }

    public Contact(){
        this(null, null, null, null, null);
    }

    public Contact(String name, String phone, String email, String street, String place) {
        this(0, name, phone, email, street, place);
    }


    public Contact(int id, String name, String phone, String email, String street, String place) {
        mId = id;
        mName = name;
        mPhone = phone;
        mEmail = email;
        mStreet = street;
        mPlace = place;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmStreet() {
        return mStreet;
    }

    public void setmStreet(String mStreet) {
        this.mStreet = mStreet;
    }

    public String getmPlace() {
        return mPlace;
    }

    public void setmPlace(String mPlace) {
        this.mPlace = mPlace;
    }

    @Override
    public boolean equals( Object obj) {

        if (obj instanceof Contact) {
            Contact contact = (Contact) obj;
            int id = contact.getmId();

            if (id != 0)
                return id == mId;
            else
                return contact.getmName().equals(mName);
        } else
            return false;
        }
    }


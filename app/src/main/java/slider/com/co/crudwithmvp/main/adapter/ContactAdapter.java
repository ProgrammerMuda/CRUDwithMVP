package slider.com.co.crudwithmvp.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import slider.com.co.crudwithmvp.R;
import slider.com.co.crudwithmvp.main.contract.MainContract;
import slider.com.co.crudwithmvp.main.model.Contact;
import slider.com.co.crudwithmvp.main.viewholder.ContactViewHolder;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private ArrayList<Contact> mContacts;
    private Context mContext;
    private LayoutInflater mInflater;
    private MainContract.Presenter mPresenter;

    public ContactAdapter(Context context, ArrayList<Contact> contacts, MainContract.Presenter presenter) {
        mContacts = contacts;
        mContext = context;
        mPresenter = presenter;

        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row_contact, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        Contact contact = mContacts.get(position);

        ImageView ivMenu = holder.getivMenu();
        TextView tvName = holder.gettvName();
        TextView tvPhone = holder.gettvPhone();

        tvName.setText(contact.getmName());
        tvPhone.setText(contact.getmPhone());
        ivMenu.setOnClickListener(new OnMenuClickListener(contact, ivMenu));
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    private class OnMenuClickListener implements View.OnClickListener {

        private Contact mContact;
        private ImageView mIvMenu;

        private OnMenuClickListener(Contact contact, ImageView ivMenu) {
            mContact = contact;
            mIvMenu = ivMenu;
        }

        @Override
        public void onClick(View v) {
            mPresenter.openContactMenu(mContact, mIvMenu);
        }
    }
}


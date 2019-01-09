package slider.com.co.crudwithmvp.main.view.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import slider.com.co.crudwithmvp.R;
import slider.com.co.crudwithmvp.addcontact.view.activty.AddContactActivity;
import slider.com.co.crudwithmvp.main.adapter.ContactAdapter;
import slider.com.co.crudwithmvp.main.contract.MainContract;
import slider.com.co.crudwithmvp.main.model.Contact;

public class MainFragment extends Fragment implements MainContract.View {  private ArrayList<Contact> mContacts;
    private ContactAdapter mAdapter;
    private MainContract.Presenter mPresenter;
    private RecyclerView mRvMain;

    public MainFragment() {
        // Default constructor
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        mRvMain = view.findViewById(R.id.rv_main);
        mRvMain.setLayoutManager(new LinearLayoutManager(getContext()));
        mRvMain.setNestedScrollingEnabled(true);
        mRvMain.setHasFixedSize(true);

        getActivity().findViewById(R.id.fab_add).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mPresenter.openAddContact();
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        mPresenter.resultAddContact(requestCode, resultCode, data);
    }

    @Override
    public void setPresenter(@NonNull MainContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showContacts() {
        mContacts = new ArrayList<>();
        mPresenter.loadContacs(mContacts);

        mAdapter = new ContactAdapter(getContext(), mContacts, mPresenter);
        mRvMain.setAdapter(mAdapter);
    }

    @Override
    public void showContactMenu(@NonNull Contact contact, @NonNull View view) {
        PopupMenu popupMenu = new PopupMenu(getContext(), view);
        popupMenu.inflate(R.menu.main_menu);
        popupMenu.setOnMenuItemClickListener(new MenuClickListener(contact));
        popupMenu.show();
    }

    @Override
    public void updateDeletedContacts(@NonNull Contact contact) {
        int index = mContacts.indexOf(contact);
        mContacts.remove(index);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showAddContact() {
        Intent intent = new Intent(getContext(), AddContactActivity.class);
        startActivityForResult(intent, AddContactActivity.REQUEST_CODE);
    }

    @Override
    public void showAddUserMessage(@NonNull String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        String title = getString(R.string.add_contact_title);
        String ok = getString(R.string.ok);

        builder.setTitle(title)
                .setMessage(message)
                .setNegativeButton(ok, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();

        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    private class MenuClickListener implements PopupMenu.OnMenuItemClickListener {

        private Contact mContact;

        private MenuClickListener(Contact contact) {
            mContact = contact;
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            int id = item.getItemId();

            switch (id) {
                case R.id.menu_edit:
                    mPresenter.editContact(mContact);
                    break;
                case R.id.menu_delete:
                    mPresenter.deleteContact(mContact);
                    break;
            }

            return false;
        }
    }
}


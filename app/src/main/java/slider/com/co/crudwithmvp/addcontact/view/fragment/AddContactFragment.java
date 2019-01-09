package slider.com.co.crudwithmvp.addcontact.view.fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import slider.com.co.crudwithmvp.R;
import slider.com.co.crudwithmvp.addcontact.contract.AddContractContract;
import slider.com.co.crudwithmvp.main.model.Contact;

public class AddContactFragment extends Fragment implements AddContractContract.View {

    private AddContractContract.Presenter mPresenter;
    private ProgressDialog mProgressDialog;
    private TextInputEditText mTietName, mTietPhone, mTietEmail, mTietStreet, mTietPlace;
    private TextInputLayout mTilName;

    public AddContactFragment() {
        // Default constructor
    }

    public static AddContactFragment newInstance() {
        return new AddContactFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_contact, container, false);

        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        mProgressDialog = new ProgressDialog(getContext());
        String title = getString(R.string.add_contact_title);
        String message = getString(R.string.add_contact_message);

        mProgressDialog.setTitle(title);
        mProgressDialog.setMessage(message);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setCanceledOnTouchOutside(false);

        mTietName = view.findViewById(R.id.tiet_name);
        mTietPhone = view.findViewById(R.id.tiet_phone);
        mTietEmail = view.findViewById(R.id.tiet_email);
        mTietStreet = view.findViewById(R.id.tiet_street);
        mTietPlace = view.findViewById(R.id.tiet_place);

        mTilName = view.findViewById(R.id.til_name);

        getActivity().findViewById(R.id.fab_add_contact).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Contact contact = new Contact();

                contact.setmName(mTietName.getText().toString());
                contact.setmPhone(mTietPhone.getText().toString());
                contact.setmEmail(mTietEmail.getText().toString());
                contact.setmStreet(mTietStreet.getText().toString());
                contact.setmPlace(mTietPlace.getText().toString());

                mPresenter.saveContact(contact);
            }
        });

        return view;    }

    @Override
    public void showNameEmpty() {

        String nameEmpty = getString(R.string.name_empty);

        mTilName.setErrorEnabled(true);
        mTilName.setError(nameEmpty);

    }

    @Override
    public void hideNameEmpty() {

        mTilName.setErrorEnabled(false);


    }

    @Override
    public void showProgressDialog() {
        mProgressDialog.show();

    }

    @Override
    public void hideProgressDialog() {

        mProgressDialog.dismiss();


    }

    @Override
    public void finishView(@NonNull String message) {

        Intent intent = new Intent();
        intent.putExtra("message", message);

        getActivity().setResult(Activity.RESULT_OK, intent);
        getActivity().finish();

    }

    @Override
    public void setPresenter(@NonNull AddContractContract.Presenter presenter) {

        mPresenter = presenter;


    }
}

package slider.com.co.crudwithmvp.main.viewholder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import slider.com.co.crudwithmvp.R;

public class ContactViewHolder extends RecyclerView.ViewHolder {

    private CardView mCvContact;
    private ImageView mIvMenu;
    private TextView mTvName, mTvPhone;

    public ContactViewHolder(View view) {
        super(view);

        mCvContact = view.findViewById(R.id.cv_contact);
        mIvMenu = view.findViewById(R.id.iv_menu);
        mTvName = view.findViewById(R.id.tv_name);
        mTvPhone = view.findViewById(R.id.tv_phone);
    }

    public CardView getcvContact() {
        return mCvContact;
    }

    public ImageView getivMenu() {
        return mIvMenu;
    }

    public TextView gettvName() {
        return mTvName;
    }

    public TextView gettvPhone() {
        return mTvPhone;
    }
}

package com.vutuanchien.android_chap24_multiplescreensizes;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        ImageView ivAvatar = (ImageView) view.findViewById(R.id.ivAvatar);
        TextView tvName = (TextView) view.findViewById(R.id.tvName);
        TextViewEx tvConntent = (TextViewEx) view.findViewById(R.id.tvContent);
        Bundle bundle = getArguments();
        switch (bundle.getInt("ID", 0)) {
            case 1:
                ivAvatar.setImageResource(R.drawable.avatar2);
                tvName.setText("Lập Trình Viên Java");
                tvConntent.setText(DetailsFragment.this.getResources().getString(R.string.des_android), true);
                break;
            case 2:
                ivAvatar.setImageResource(R.drawable.avatar3);
                tvName.setText("Lập Trình Viên Android");
                tvConntent.setText(DetailsFragment.this.getResources().getString(R.string.des_android), true);
                break;
            default:
                ivAvatar.setImageResource(R.drawable.avartar1);
                tvName.setText("Lập Trình Viên IOS");
                tvConntent.setText(DetailsFragment.this.getResources().getString(R.string.des_android), true);
                break;

        }
        return view;
    }
}

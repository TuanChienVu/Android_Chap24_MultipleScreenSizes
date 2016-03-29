package com.vutuanchien.android_chap24_multiplescreensizes;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MenuFragment extends Fragment implements View.OnClickListener {

    boolean mDualPane;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        View detailFrame = getActivity().findViewById(R.id.flDetail);
        mDualPane = detailFrame != null;
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Button btnPerson1, btnPerson2, btnPerson3;
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        btnPerson1 = (Button) view.findViewById(R.id.btnPerson1);
        btnPerson2 = (Button) view.findViewById(R.id.btnPerson2);
        btnPerson3 = (Button) view.findViewById(R.id.btnPerson3);
        btnPerson1.setOnClickListener(this);
        btnPerson2.setOnClickListener(this);
        btnPerson3.setOnClickListener(this);
        return view;
    }

    private void changeLayout(int id) {
        if (mDualPane) {
            DetailsFragment detailFragment = new DetailsFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("ID", id);
            detailFragment.setArguments(bundle);
            getFragmentManager().beginTransaction().replace(R.id.flDetail, detailFragment).commit();
        } else {
            Intent intent = new Intent();
            intent.setClass(getActivity(), DetailsActivity.class);
            intent.putExtra("ID", id);
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPerson1:
                changeLayout(0);
                break;
            case R.id.btnPerson2:
                changeLayout(1);
                break;
            case R.id.btnPerson3:
                changeLayout(2);
                break;

        }
    }
}

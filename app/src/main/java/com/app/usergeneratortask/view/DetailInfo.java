package com.app.usergeneratortask.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.app.usergeneratortask.R;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailInfo extends Fragment {

    public static DetailInfo newInstance(Map<String, String> userData) {
        Bundle argument = new Bundle();

        for (Map.Entry<String, String> item : userData.entrySet()) {
            argument.putString(item.getKey(), item.getValue());
        }

        DetailInfo fragment = new DetailInfo();
        fragment.setArguments(argument);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.contact_card, container, false);

        setDataInView(root);

        return root;
    }

    @SuppressLint("SetText")
    private void setDataInView(View root) {

        TextView name = root.findViewById(R.id.user_name);
        TextView age = root.findViewById(R.id.user_age);
        TextView  gender= root.findViewById(R.id.user_gender);
        TextView date = root.findViewById(R.id.dob_user);
        TextView phone = root.findViewById(R.id.user_phone_number);
        CircleImageView img = root.findViewById(R.id.imageview_userdetail_avatar);

        assert getArguments() != null;
        name.setText(getString(R.string.name) + " " +getArguments(). getString("NAME"));
        gender.setText(getString(R.string.gender) + " " + getArguments().getString("GENDER"));
        age.setText(getString(R.string.age) + " " + getArguments().getString("AGE"));

        //not done yet
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

        date.setText(getString(R.string.date) + "" + getArguments().getString("DATE"));
        phone.setText(getString(R.string.phone) + " " + getArguments().getString("PHONE"));

        Picasso.get().load(getArguments().getString("IMG"))
                .resize(360, 360)
                .into(img);

    }
}
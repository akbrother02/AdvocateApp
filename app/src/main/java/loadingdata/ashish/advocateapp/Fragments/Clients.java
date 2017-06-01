package loadingdata.ashish.advocateapp.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import loadingdata.ashish.advocateapp.R;
import loadingdata.ashish.advocateapp.Activity.UserProfileDescription;


public class Clients extends Fragment {

    String array[];
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        UserProfileDescription activity = (UserProfileDescription) getActivity();
        String myDataFromActivity = activity.getData();
        array=myDataFromActivity.split("-");
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_userprofile, container, false);
        EditText tvname= (EditText) view.findViewById(R.id.name);
        tvname.setText(array[0]);
        EditText tvAddress= (EditText) view.findViewById(R.id.etaddress);
        tvAddress.setText(array[1]);
        EditText tvContact=(EditText)view.findViewById(R.id.etContact);
        tvContact.setText(array[2]);
        EditText tvEmail=(EditText)view.findViewById(R.id.etEmail);
        tvEmail.setText(array[3]);

        return view;


    }


}

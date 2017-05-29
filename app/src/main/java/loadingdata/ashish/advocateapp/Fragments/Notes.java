package loadingdata.ashish.advocateapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import loadingdata.ashish.advocateapp.R;

/**
 * Created by Aashish on 5/29/2017.
 */

public class Notes extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_userprofile, container, false);
    }
}

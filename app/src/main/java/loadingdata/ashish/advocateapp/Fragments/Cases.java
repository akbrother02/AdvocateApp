package loadingdata.ashish.advocateapp.Fragments;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import loadingdata.ashish.advocateapp.Activity.ViewAllActivity;
import loadingdata.ashish.advocateapp.Database.DbHelper;
import loadingdata.ashish.advocateapp.Model.CasesModel;
import loadingdata.ashish.advocateapp.Model.UserRecords;
import loadingdata.ashish.advocateapp.R;
import loadingdata.ashish.advocateapp.Activity.UserProfileDescription;

/**
 * Created by Aashish on 5/29/2017.
 */

public class Cases extends Fragment {
    ListView listView;
    DbHelper mydb;
    ArrayList<CasesModel> contactList = new ArrayList<CasesModel>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragments_case, container, false);
        mydb=new DbHelper(getActivity());
        listView=(ListView)view.findViewById(R.id.listview);
        ShowList();

        return view;

    }

    private void ShowList() {

        Cursor c1 = mydb.getCaseDetails();
        if (c1 != null && c1.getCount() != 0) {
            if (c1.moveToFirst()) {
                do {
                    CasesModel contactListItems = new CasesModel();
                    contactListItems.setClientName(c1.getString(c1.getColumnIndex("ClientName")));
                    contactListItems.setCasename(c1.getString(c1.getColumnIndex("CaseName")));
                    contactListItems.setCasenumber(c1.getString(c1.getColumnIndex("CaseNumber")));
                    contactListItems.setStatus(c1.getString(c1.getColumnIndex("Status")));
                    contactListItems.setRegisterdate(c1.getString(c1.getColumnIndex("RegisterDate")));
                    contactListItems.setCasetype(c1.getString(c1.getColumnIndex("CaseType")));
                    contactListItems.setCasefees(c1.getString(c1.getColumnIndex("Fees")));
                    contactListItems.setOpponentName(c1.getString(c1.getColumnIndex("OpponentName")));
                    contactListItems.setOpponentLawyer(c1.getString(c1.getColumnIndex("OpponentLawyer")));
                    contactListItems.setOpponentContactNumber(c1.getString(c1.getColumnIndex("OpponentContact")));
                    contactListItems.setJudgeName(c1.getString(c1.getColumnIndex("JudgeName")));
                    contactListItems.setCourtName(c1.getString(c1.getColumnIndex("CourtName")));
                    contactListItems.setCourtCity(c1.getString(c1.getColumnIndex("CourtCity")));
                    contactListItems.setCaseRemarks(c1.getString(c1.getColumnIndex("CaseRemark")));
                    contactList.add(contactListItems);

                } while (c1.moveToNext());
            }
        }
        c1.close();
       CustomAdapter contactListAdapter = new CustomAdapter(
                getActivity(), contactList);
        listView.setAdapter(contactListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {





            }
        });


    }


    private class CustomAdapter extends BaseAdapter {

        Context fragmentActivity;
        ArrayList<CasesModel> caseslist;

        public CustomAdapter(FragmentActivity activity, ArrayList<CasesModel> contactList) {
            this.fragmentActivity=activity;
            this.caseslist=contactList;
        }

        @Override
        public int getCount() {
            return caseslist.size();
        }

        @Override
        public Object getItem(int i) {
            return caseslist.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {

            final CasesModel casesModel=caseslist.get(i);
            Holder holder;
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) getActivity()
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.fragment_caseitem, null);
                holder = new Holder();
                holder.Casename = (TextView) convertView.findViewById(R.id.casename);
                holder.ClientName=(TextView) convertView.findViewById(R.id.username) ;
                holder.CaseStatus=(TextView) convertView.findViewById(R.id.casestatus);
                holder.Courtname=(TextView) convertView.findViewById(R.id.courtname);
                holder.RegisterDate=(TextView) convertView.findViewById(R.id.registerdate);
                 convertView.setTag(holder);
            } else{
                holder = (Holder) convertView.getTag();
            }
            holder.Casename.setText(casesModel.getCasename());
            holder.ClientName.setText(casesModel.getClientName());
            holder.CaseStatus.setText(casesModel.getStatus());
            holder.Courtname.setText(casesModel.getCourtName());
            holder.RegisterDate.setText(casesModel.getRegisterdate());
            return null;
        }
    }

    private class Holder {

        TextView Casename, ClientName,CaseStatus, Courtname, RegisterDate;


    }
}
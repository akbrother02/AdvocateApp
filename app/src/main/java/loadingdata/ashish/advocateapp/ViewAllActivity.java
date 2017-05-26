package loadingdata.ashish.advocateapp;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewAllActivity extends AppCompatActivity {

    ListView listView;
    DbHelper mydb;
    ArrayList<UserRecords> contactList = new ArrayList<UserRecords>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);
        mydb=new DbHelper(this);
        listView=(ListView)findViewById(R.id.listview);
        ShowList();

    }

    private void ShowList() {
        Cursor c1 = mydb.getRecords();
        if (c1 != null && c1.getCount() != 0) {
            if (c1.moveToFirst()) {
                do {
                    UserRecords contactListItems = new UserRecords();

                    contactListItems.setCasenumber(c1.getString(c1.getColumnIndex("Caseno")));
                    contactListItems.setContactnumber(c1.getString(c1.getColumnIndex("Name")));
                    contactListItems.setName(c1.getString(c1.getColumnIndex("Contact")));
                    contactListItems.setCasetype(c1.getString(c1.getColumnIndex("CaseType")));
                    contactListItems.setCourtname(c1.getString(c1.getColumnIndex("Court")));
                    contactList.add(contactListItems);

                } while (c1.moveToNext());
            }
        }
        c1.close();
        CustomAdapter contactListAdapter = new CustomAdapter(
                ViewAllActivity.this, contactList);
        listView.setAdapter(contactListAdapter);
    }


    private class CustomAdapter extends BaseAdapter {

        Context context;
        ArrayList<UserRecords> contactList;


        public CustomAdapter(Context context, ArrayList<UserRecords> contactList) {
            this.context=context;
            this.contactList=contactList;
        }

        @Override
        public int getCount() {
            return contactList.size();
        }

        @Override
        public Object getItem(int i) {
            return contactList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {
            UserRecords contactListItems = contactList.get(i);

            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.layout_listitem, null);

            }
            TextView Name = (TextView) convertView.findViewById(R.id.username);
            Name.setText(contactListItems.getName());
            TextView Casetype=(TextView)convertView.findViewById(R.id.casetype);
            Casetype.setText(contactListItems.getCasetype());
            TextView Contact=(TextView) convertView.findViewById(R.id.contact);
            Contact.setText(contactListItems.getContactnumber());
            TextView CourtName=(TextView) convertView.findViewById(R.id.courtname);
            CourtName.setText(contactListItems.getCourtname());
            TextView Casenumber=(TextView)convertView.findViewById(R.id.casenumber);
            Casenumber.setText(contactListItems.getCasenumber());
            return convertView;
        }
    }


}
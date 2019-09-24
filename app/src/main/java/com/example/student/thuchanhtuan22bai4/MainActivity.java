package com.example.student.thuchanhtuan22bai4;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends ListActivity {
    private TextView ketqua,txten;
    private Button btnnhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectView();
        final ArrayList<String> users = new ArrayList<>();
        users.add("Tom");users.add("Jerry");users.add("Doggy");users.add("John");
        final ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, users);
        setListAdapter(arrayAdapter);
        btnnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newten = txten.getText().toString();
                users.add(newten);
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String item = (String)getListAdapter().getItem(position);
        ketqua.setText("position :"+position+ "; Value :"+item);
    }

    private void connectView() {
        ketqua = (TextView)findViewById(R.id.hienthi);
        txten = (TextView)findViewById(R.id.txtten);
        btnnhap = (Button)findViewById(R.id.btnnhap);
    }

}

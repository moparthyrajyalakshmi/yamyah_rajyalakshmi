package com.example.raji.tensorflow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class customerActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;

    TextView t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        String cid = getIntent().getStringExtra("cid1");
        t1=(TextView)findViewById(R.id.tv);
        t2=(TextView)findViewById(R.id.qty);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference(cid);
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                // Log.d(TAG, "Value is: " + value);
              //Toast.makeText(getApplicationContext(),dataSnapshot.getValue().toString(), Toast.LENGTH_LONG).show();
                /* for(DataSnapshot productSnapshot :dataSnapshot.getChildren() ){
                    CustomerProduct cp = productSnapshot.getValue(CustomerProduct.class);
                    Toast.makeText(getApplicationContext(),productSnapshot.toString(),Toast.LENGTH_LONG).show();
                }*/
                int max=0;
                String name="";
                for(DataSnapshot productSnapshot: dataSnapshot.getChildren()){
                   CustomerProduct cp = productSnapshot.getValue(CustomerProduct.class);
                    int x=cp.getQty();
                    if(x>max)
                    {
                        max=x;
                        name=cp.getPname();
                    }
                    // String x = datasnapshot.child("qty").toString();
                    //String a=datasnapshot.child("pname").toString();
                   // Toast.makeText(customerActivity.this,x,Toast.LENGTH_LONG).show();


                }
                t1.setText(name);
                t2.setText(""+max);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
                Toast.makeText(customerActivity.this, "not ret", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

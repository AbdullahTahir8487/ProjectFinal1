package com.example.projectfinal1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FireData extends AppCompatActivity {

    EditText id,fname,lname,prof,stat,gen,dob,par;
    Button add,del,view;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_data);

        EditText id=(EditText) findViewById(R.id.id);
        EditText fname=(EditText) findViewById(R.id.fname);
        EditText lname=(EditText) findViewById(R.id.lname);
        EditText prof=(EditText) findViewById(R.id.prof);
        EditText stat=(EditText) findViewById(R.id.status);
        EditText gen=(EditText) findViewById(R.id.gender);
        EditText dob =(EditText) findViewById(R.id.dob);
        EditText par=(EditText) findViewById(R.id.parents);


        Button add=(Button) findViewById(R.id.addPD);
        Button del=(Button) findViewById(R.id.ViewPD);
        Button view=(Button) findViewById(R.id.deletePD);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode= FirebaseDatabase.getInstance();
                reference=rootNode.getReference("UserData");



                String ID=id.getText().toString();
                String FNAME=fname.getText().toString();
                String LNAME=lname.getText().toString();
                String PROF=prof.getText().toString();
                String STAT=stat.getText().toString();
                String GEN=gen.getText().toString();
                String DOB=dob.getText().toString();
                String PAR=par.getText().toString();

                FireHelperAddclass helperclass=new FireHelperAddclass(ID,FNAME,LNAME,PROF,STAT,GEN,DOB,PAR);



                reference.child(ID).setValue(helperclass);
            }
        });
    }
}
package com.example.projectfinal1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PersonalDatabase extends AppCompatActivity {

    Button Adding,Viewing,Deleting,Updating;
    DatabaseHelper dbhandler;
    EditText ID,FNAME,FAMNAME,PROF,STATUS,DOB,GENDER,PARENTS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_database);

        dbhandler=new DatabaseHelper(this);

        Adding=(Button)findViewById(R.id.addPD);

       Viewing=(Button)findViewById(R.id.ViewPD);

        Deleting=(Button)findViewById(R.id.deletePD);

        Updating=(Button)findViewById(R.id.updatePD);


        ID=(EditText) findViewById(R.id.id);
        FNAME=(EditText) findViewById(R.id.fname);
        FAMNAME=(EditText) findViewById(R.id.lname);
        PROF=(EditText) findViewById(R.id.prof);
        STATUS=(EditText) findViewById(R.id.status);
        DOB=(EditText) findViewById(R.id.dob);
        GENDER=(EditText) findViewById(R.id.gender);
        PARENTS=(EditText) findViewById(R.id.parents);

        Adding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ID1= ID.getText().toString();
                String FIRSTNAME1=FNAME.getText().toString();
                String LASTNAME1=FAMNAME.getText().toString();
                String PROFFESION1=PROF.getText().toString();
                String STATUS1=STATUS.getText().toString();
                String GENDER1=DOB.getText().toString();
                String PARENTNAME1=GENDER.getText().toString();
                String DATEOFBIRTH1=PARENTS.getText().toString();



                dbhandler.AddCitizen(ID1,FIRSTNAME1,LASTNAME1,PROFFESION1,STATUS1,GENDER1,PARENTNAME1,DATEOFBIRTH1);
                Toast.makeText(PersonalDatabase.this, "Employee has been added.", Toast.LENGTH_LONG).show();
            }

        });


        Updating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ID1= ID.getText().toString();
                String FIRSTNAME1=FNAME.getText().toString();
                String LASTNAME1=FAMNAME.getText().toString();
                String PROFFESION1=PROF.getText().toString();
                String STATUS1=STATUS.getText().toString();
                String GENDER1=DOB.getText().toString();
                String PARENTNAME1=GENDER.getText().toString();
                String DATEOFBIRTH1=PARENTS.getText().toString();



                dbhandler.AddCitizen(ID1,FIRSTNAME1,LASTNAME1,PROFFESION1,STATUS1,GENDER1,PARENTNAME1,DATEOFBIRTH1);
                Toast.makeText(PersonalDatabase.this, "Employee has been updated.", Toast.LENGTH_LONG).show();
            }

        });


        Viewing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res =dbhandler.ViewCitizen();
                StringBuffer buffer=new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("ID: "+ res.getString(0) +"\n" );
                    buffer.append("FIRST NAME: "+ res.getString(1) +"\n" );
                    buffer.append("LAST NAME: "+ res.getString(2) +"\n" );
                    buffer.append("PROFESSION: "+ res.getString(3) +"\n" );
                    buffer.append("STATUS: "+ res.getString(4) +"\n" );
                    buffer.append("GENDER: "+ res.getString(5) +"\n" );
                    buffer.append("PARENTNAMES: "+ res.getString(6) +"\n" );
                    buffer.append("DOB: "+ res.getString(7) +"\n\n" );

                }

                AlertDialog.Builder builder=new AlertDialog.Builder(PersonalDatabase.this);
                builder.setCancelable(true);
                builder.setTitle("All Employees");
                builder.setMessage(buffer.toString());
                builder.show();

            }
        });
        Deleting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String CITIZENID=ID.getText().toString();

                dbhandler.DeleteCitizen(CITIZENID);
                Toast.makeText(PersonalDatabase.this,"Employee was removed",Toast.LENGTH_LONG).show();
            }
        });

    }
}
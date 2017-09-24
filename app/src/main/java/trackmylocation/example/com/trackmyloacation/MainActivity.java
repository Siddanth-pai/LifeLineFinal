package trackmylocation.example.com.trackmyloacation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText ext;

    ImageView tick;
    Button bt1;
    Spinner bloodspinner;
    Map<String,String> values;
    //DatabaseReference dbref;
    String name;


    public void change(View view)
    {
        Intent i1=new Intent(MainActivity.this,MapsActivity.class);
        startActivity(i1);
    }



    public void add(View view)
    {


        String bloodgroup=bloodspinner.getSelectedItem().toString();



        name=ext.getText().toString();
        if(name.matches(""))
        {
            ext.setError("enter your phone");
        }




        //else
        //{
            //values.put("name",""+ name+" "+bloodgroup);



            //dbref.push().setValue(values, new DatabaseReference.CompletionListener() {
              //  @Override
                //public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {

                    //if ((databaseError == null)) {
                      //  Toast.makeText(MainActivity.this, "uploaded successfully", Toast.LENGTH_LONG).show();
                    //} else {
                      //  Toast.makeText(MainActivity.this, "unsuccesful", Toast.LENGTH_LONG).show();

                    //}

               // }
            //});
            tick.setVisibility(View.VISIBLE);

        }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ext=(EditText)findViewById(R.id.name);
        bt1=(Button)findViewById(R.id.pushbutton);
        bloodspinner=(Spinner)findViewById(R.id.bloodgrp);

        values=new HashMap<>();
        tick=(ImageView)findViewById(R.id.tick);
      //  dbref= FirebaseDatabase.getInstance().getReference();

    }
}
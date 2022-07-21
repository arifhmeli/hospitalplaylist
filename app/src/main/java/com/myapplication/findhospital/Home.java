package com.myapplication.findhospital;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class Home extends AppCompatActivity{

    GoogleSignInClient mGoogleSignInClient;
    String name, email;

    Button map_button;
    Button report_button;
    //Button find_me_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView name1 = (TextView) findViewById(R.id.name1);
        TextView email1 = (TextView) findViewById(R.id.email1);

        name = getIntent().getStringExtra("Name");
        email = getIntent().getStringExtra("Email");

        name1.setText(name);
        email1.setText(email);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        map_button = (Button) findViewById(R.id.map_button);

        map_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),Maps.class);
                startActivity(intent);
            }
        });

        //find_me_button.setOnClickListener(new View.OnClickListener() {
         //   @Override
          //  public void onClick(View v) {
          //      Intent mapIntent = new Intent(Intent.ACTION_VIEW);
           //     mapIntent.setPackage("com.google.android.apps.maps");
           //     startActivity(mapIntent);
           // }
        //});

       report_button = (Button) findViewById(R.id.report_button);

       report_button.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
       Intent intent = new Intent();
       intent.setClass(getApplicationContext(),Server.class);
       startActivity(intent);
       }
       });
    }

    //menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {

       int id = item.getItemId();
    //toast
       switch (item.getItemId()){
          case R.id.menu1:
              Toast.makeText(this, "About Us is selected.", Toast.LENGTH_SHORT).show();
             Intent intent = new Intent(Home.this, AboutUs.class);
             startActivity(intent);
            return true;
           case R.id.menu2:
               mGoogleSignInClient.signOut()
                       .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                           @Override
                           public void onComplete(@NonNull Task<Void> task) {
                               Toast.makeText(getApplicationContext(),email + " signed out",Toast.LENGTH_SHORT).show();
                               finish();
                           }
                       });
               return true;
    }
    return super.onOptionsItemSelected(item);
    }

}
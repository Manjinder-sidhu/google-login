package com.example.googleauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signout extends AppCompatActivity {


    private GoogleSignInClient mGoogleSignInClient;
    private  String TAG = "MainActivity";
    private FirebaseAuth mAuth;
    private Button btnSignOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signout);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        btnSignOut = findViewById(R.id.sign_out_button);
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        Intent i = getIntent();
        String name = i.getStringExtra("name");
        String id = i.getStringExtra("id");
//        Toast.makeText(this, name +"......."+ id ,Toast.LENGTH_SHORT).show();

        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGoogleSignInClient.signOut();
                Toast.makeText(signout.this,"You are Logged Out",Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(signout.this,MainActivity.class);
                startActivity(intent);
                btnSignOut.setVisibility(View.INVISIBLE);
            }
        });
    }


}

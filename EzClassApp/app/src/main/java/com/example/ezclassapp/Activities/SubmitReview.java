package com.example.ezclassapp.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ezclassapp.Models.Review;
import com.example.ezclassapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SubmitReview extends AppCompatActivity {

    private Toolbar mToolbar;
    private Button mSubmit_btn;
    private TextInputLayout mReviewText;
    public static final String ARG_PARAM1 = "courseName";
    public static final String ARG_PARAM2 = "reviewListId";
    private DatabaseReference mDatabase;
    private DatabaseReference reviewReference;
    private DatabaseReference particularCourseReference;
    private DatabaseReference courseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_review);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mReviewText = (TextInputLayout)findViewById(R.id.review_input);
        mSubmit_btn = (Button) findViewById(R.id.submit_btn);
        Bundle currentBundle = getIntent().getExtras();
        final String courseid = currentBundle.getString(ARG_PARAM1);
        final ArrayList<String> reviewListId = currentBundle.getStringArrayList(ARG_PARAM2);
        Toast.makeText(getApplicationContext(), courseid, Toast.LENGTH_SHORT).show();
        reviewReference = mDatabase.child(Constants.REVIEW);
        particularCourseReference = mDatabase.child(Constants.COURSE).child(courseid).child(Constants.REVIEWLIST);

        /*courseReference = mDatabase.child(Constants.COURSE).child(courseid);
        courseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name;
                name = dataSnapshot.child("courseName").getValue().toString();
                Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        }); */



        mSubmit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key = reviewReference.push().getKey();
                Review review = new Review(key,courseid,mReviewText.getEditText().getText().toString());
                reviewReference.child(key).setValue(review).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        //finish();
                    }
                });
                if (reviewListId == null || reviewListId.isEmpty()) {
                    ArrayList<String> newReviewListId = new ArrayList<String>();
                    newReviewListId.add(key);
                    particularCourseReference.setValue(newReviewListId);
                } else {
                    reviewListId.add(key);
                    particularCourseReference.setValue(reviewListId);

                }
                finish();


            }
        });

    }

}

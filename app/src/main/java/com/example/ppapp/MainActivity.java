package com.example.ppapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.example.ppapp.Fragments.LoginFragment;
import com.example.ppapp.Model.Group;
import com.example.ppapp.Model.Question;
import com.example.ppapp.Model.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


//    FirebaseDatabase firebaseDatabase;
//    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // firebaseDatabase = firebaseDatabase.getInstance();
        //  databaseReference = firebaseDatabase.getReference("Group");

        ArrayList<Integer> groupId = new ArrayList<>();
        groupId.add(10);

        User user1 = new User(1, "Matyas", "", groupId);
        User user2 = new User(2, "Karcsi", "", groupId);
        User user3 = new User(3, "Peter");


        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        Question question1 = new Question(1, "Rate this app!", true, users);
        Question question2 = new Question(2, "Do you like Java?", true, users);

        ArrayList<Question> questions = new ArrayList<>();
        questions.add(question1);
        questions.add(question2);

        //   String id = databaseReference.push().getKey();

        //  Group group1 = new Group(id, true, questions);
        //  Log.d("tag" , group1.toString());


        // databaseReference.setValue(group1);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, new LoginFragment());
        fragmentTransaction.commit();
    }


    }

package com.example.ppapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.ppapp.Model.Group;
import com.example.ppapp.Model.Question;
import com.example.ppapp.Model.User;
import com.example.ppapp.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class LoginFragment extends Fragment {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    public LoginFragment(){};

    public void Oncreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(
                R.layout.fragment_login, container, false);



        EditText et_groupId = view.findViewById(R.id.Login_groupId);
        EditText et_name = view.findViewById(R.id.Login_name);

        Button login_button = view.findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
                QuestionFragment Qfragment = new QuestionFragment();
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, Qfragment);
                fr.addToBackStack(null);
                fr.commit();
            }
        });
        return  view;
    }

    public void insertData(){

         firebaseDatabase = firebaseDatabase.getInstance();
         databaseReference = firebaseDatabase.getReference("Group");

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

         Group group1 = new Group("1", true, questions);
        //  Log.d("tag" , group1.toString());

        //databaseReference.push().setValue(user3);
            databaseReference.child("Group").setValue(group1);
    }
}

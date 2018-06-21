package com.qhackers.djcloud;

import java.io.IOException;
import java.io.InputStream;
import java.util.function.Consumer;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

public class FirebaseUtility {
    private static FirebaseDatabase db = null;
    private static DatabaseReference dbReference = null;

    public FirebaseUtility(FirebaseDatabase instance, DatabaseReference reference) {
        db = instance;
        dbReference = reference;
    }

    public FirebaseUtility() {
        this(FirebaseDatabase.getInstance(), FirebaseDatabase.getInstance().getReference());
    }

    public void test() {
        System.out.println();
    }

    public void readDataOnce(String key, Consumer<String> c) {
        System.out.println();
        dbReference.child(key).addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot snapshot) {
                c.accept(new Gson().toJson(snapshot.getValue()));
            }

            @Override
            public void onCancelled(DatabaseError error) {
                System.out.println("Cancelled");
            }
        });
        System.out.println();
    }

    public void listenForValueChanges(String key, Consumer<String> c) {
        dbReference.child(key).addValueEventListener(new ValueEventListener(){
        
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                c.accept(new Gson().toJson(snapshot.getValue()));
            }
        
            @Override
            public void onCancelled(DatabaseError error) {
                
            }
        });
    }
}
package com.qhackers.djcloud;

import java.io.FileInputStream;
import com.google.firebase.FirebaseOptions;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("hello");
        FileInputStream serviceAccount = new FileInputStream("dj-cloud-fdbf5-firebase-adminsdk-mjsrn-b1c015f95b.json");
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://dj-cloud-fdbf5.firebaseio.com").build();
        FirebaseApp.initializeApp(options);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("admin");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Object document = dataSnapshot.getValue();
                System.out.println(document);
            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });
        System.out.println("end");
    }
}
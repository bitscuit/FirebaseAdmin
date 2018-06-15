package com.qhackers.djcloud;

import java.io.IOException;
import java.io.InputStream;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.function.Consumer;
import java.util.function.Function;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class FirebaseUtility {
    private static FirebaseDatabase db = null;

    public FirebaseUtility() throws IOException {
        if (db == null) {
            InputStream serviceAccount = ClassLoader.getSystemResourceAsStream("serviceAccount.json");
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://dj-cloud-fdbf5.firebaseio.com").build();
            FirebaseApp.initializeApp(options);
            db = FirebaseDatabase.getInstance();
        }
    }

    public void readDataOnce(String key, Consumer<String> c) {
        DatabaseReference ref = db.getReference(key);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Gson g = new Gson();
                String j = g.toJson(snapshot.getValue());
                c.accept(j);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                System.out.println("Cancelled");
            }
        });
    }
}
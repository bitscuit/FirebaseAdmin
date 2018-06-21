package com.qhackers.djcloud;

import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.InputStream;

public class FirebaseAuthUtil {

    public FirebaseAuthUtil() throws IOException{
        InputStream serviceAccount = ClassLoader.getSystemResourceAsStream("serviceAccount.json");
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://dj-cloud-fdbf5.firebaseio.com").build();
        FirebaseApp.initializeApp(options);
    }
}
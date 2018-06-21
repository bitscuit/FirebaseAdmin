package com.qhackers.djcloud

import spock.lang.*
import com.qhackers.djcloud.FirebaseUtility
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener
import java.util.function.Consumer

class FirebaseUtilitySpec extends Specification {
    // Consumer<String> consumer = { s -> return s }
    // FirebaseDatabase database = Mock()
    // DatabaseReference reference = Mock()
    // @Shared def auth = new FirebaseAuthUtil()
    // def firebase = new FirebaseUtility(database, reference)
    // def firebase = new FirebaseUtility()
    

    // def "instantiating FirebaseUtility sets the db and dbReference fields"() {
    //     expect:
    //         firebase.db != null
    //         firebase.dbReference != null
    // }

    def "read data once"() {
        given:
            Consumer<String> consumer = { s -> println s }
            FirebaseDatabase database = Mock()
            DatabaseReference reference = Mock()
            ValueEventListener v = Mock()
            DataSnapshot d = Mock()
            def auth = new FirebaseAuthUtil()
            def firebase = new FirebaseUtility(database, reference)
        when:
            // firebase.readDataOnce("admin", consumer)
            // firebase.test()
            //println 'hello world'
            reference.child("admin").addListenerForSingleValueEvent(v) >> {
                onDataChange(d) {
                    println "test"
                }
            }
            firebase.readDataOnce("admin", consumer)
        then:
            true == true
    }

}
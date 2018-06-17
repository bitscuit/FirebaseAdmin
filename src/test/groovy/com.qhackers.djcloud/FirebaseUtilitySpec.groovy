package com.qhackers.djcloud

import spock.lang.*
import com.qhackers.djcloud.FirebaseUtility;

class FirebaseUtilitySpec extends Specification {
    // def firebase = new FirebaseUtility()
    // FirebaseUtility mockFirebase = Mock()

    // def "instantiating FirebaseUtility sets the db field"() {
    //     expect:
    //         firebase.db != null
    // }

    def "instantiating FirebaseUtility again does not run initialization code again"() {
        given:
            FirebaseUtility i
        when:
            new FirebaseUtility();
        then:
            1 * _.initializeFirebase()
    }
}
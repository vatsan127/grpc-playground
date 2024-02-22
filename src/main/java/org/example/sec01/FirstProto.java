package org.example.sec01;

import org.example.person.PersonOuterClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstProto {
    private static final Logger log = LoggerFactory.getLogger(FirstProto.class);

    public static void main(String[] args) {
        PersonOuterClass.Person person =
                PersonOuterClass.Person.newBuilder()
                        .setName("Srivatsan")
                        .setAge(22)
                        .build();
        log.info("{}",person);

    }
}
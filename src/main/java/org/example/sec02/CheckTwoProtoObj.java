package org.example.sec02;

import org.example.person.PersonOuterClass.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckTwoProtoObj {
    private static final Logger LOG = LoggerFactory.getLogger(CheckTwoProtoObj.class);

    public static void main(String[] args) {
        Person person = Person.newBuilder()
                .setName("Srivatsan")
                .setAge(22)
                .build();

        Person person2 = Person.newBuilder()
                .setName("Srivatsan")
                .setAge(22)
                .build();
        LOG.info("{}", person);
        LOG.info("{}", person.equals(person2));
    }
}

package org.example.sec03_Collection;


import org.example.grpcCollection.SchoolOuterClass.*;
import org.example.sec02.CheckTwoProtoObj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GrpcCollection {
    private static final Logger LOG = LoggerFactory.getLogger(CheckTwoProtoObj.class);

    public static void main(String[] args) {
        Email email = Email.newBuilder()
                .setEmail("srivatsan.n@comviva.com")
                .setPassword("password").build();

        Student student = Student.newBuilder()
                .setName("Srivatsan")
                .setAge(22)
                .setEmail(email)
                .build();

        LOG.info("Student :: {}", student);

        School school = School.newBuilder()
                .setStudent(student)
                .build();
        LOG.info("School :: " + "\n" + "{}", school);

    }
}

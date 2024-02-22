package org.example.sec04_list;

import org.example.list.ListStudent;
import org.example.list.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GrpcList {
    private static final Logger log = LoggerFactory.getLogger(GrpcList.class);

    public static void main(String[] args) {
        Student student1 = org.example.list.Student.newBuilder()
                .setName("srivatsan")
                .setEmail("srivatsan.n@comviva.com")
                .build();

        Student student2 = org.example.list.Student.newBuilder()
                .setName("steve")
                .setEmail("steve.n@comviva.com")
                .build();

        ListStudent  studentList = org.example.list.ListStudent.newBuilder()
                .addAllStudent(List.of(student1,student2))
                .build()  ;
        log.info("{}",studentList);
    }
}

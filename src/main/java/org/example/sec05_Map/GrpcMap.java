package org.example.sec05_Map;

import org.example.grpc.map.GrpcMap.Student;
import org.example.grpc.map.GrpcMap.StudentMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class GrpcMap {
    private static final Logger log = LoggerFactory.getLogger(GrpcMap.class);

    public static void main(String[] args) {
        Map<String, Student> studentMap = new HashMap<>();

        studentMap.put("steve", Student.newBuilder().setName("steve").setEmail("steve@gmail.com").build());
        StudentMap map = StudentMap.newBuilder()
                .putAllStudentMap(studentMap)
                .build();

        log.info("{} ",map);
    }
}

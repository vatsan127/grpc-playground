package org.example.sec07;

import com.google.protobuf.Int32Value;
import com.google.protobuf.Timestamp;
import org.example.grpc.collection.GrpcWrappers.Sample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;

public class Wrappers {
    private static Logger log = LoggerFactory.getLogger(Wrappers.class);
    public static void main(String[] args) {
        Sample sample = Sample.newBuilder()
                .setAge(Int32Value.of(22))
                .setLoginTime(Timestamp.newBuilder().setSeconds(Instant.now().getEpochSecond()).build())
                .build();

        log.info("{}",Instant.ofEpochSecond(sample.getLoginTime().getSeconds()));

    }
}

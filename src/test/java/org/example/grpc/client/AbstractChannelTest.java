package org.example.grpc.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/*This channel is used for managing Channel*/
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AbstractChannelTest {
    private int port = 6565;
    protected ManagedChannel channel;
    private static final Logger log  = LoggerFactory.getLogger(UnaryBlockingTest.class);


    @BeforeAll
    void setUp() {
        this.channel = ManagedChannelBuilder
                .forAddress("localhost", port)
                /*use plain text when ssl certificate is not present*/
                .usePlaintext()
                .build();
        if (channel == null){
            log.error(" AbstractChannelTest ::  channel is NULL");
        }else {
            log.debug("AbstractChannelTest :: Channel is not NULL {}",channel);
        }
    }

    @AfterAll
    void tearDown() throws InterruptedException {
        this.channel.shutdownNow()
                .awaitTermination(5, TimeUnit.SECONDS);
    }
}
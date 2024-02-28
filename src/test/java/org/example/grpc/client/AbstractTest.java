package org.example.grpc.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.grpc.collection.BankServiceGrpc;
import org.example.grpc.server.GrpcServer;
import org.example.sec08_Unary.BankService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*This class is used for Starting server and channel*/
public class AbstractTest extends AbstractChannelTest{
    private static final GrpcServer server = GrpcServer.create(new BankService());
    protected BankServiceGrpc.BankServiceBlockingStub blockingStub;
    private static final Logger log  = LoggerFactory.getLogger(UnaryBlockingTest.class);

    @BeforeAll
    public void start(){
        this.server.start();
//        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build();
        if (channel == null){
            log.error("channel is NULL");
        }
        this.blockingStub = BankServiceGrpc.newBlockingStub(channel);
    }

    @AfterAll
    public void stop(){
        this.server.stop();
    }



}

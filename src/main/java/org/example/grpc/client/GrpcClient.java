package org.example.grpc.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.grpc.collection.BankServiceOuterClass;
import org.example.grpc.server.GrpcServer;
import org.example.grpc.collection.BankServiceGrpc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GrpcClient {
    private static int port = 6565;
    private static Logger log = LoggerFactory.getLogger(GrpcServer.class);

    public static void main(String[] args) {
        ManagedChannel builder = ManagedChannelBuilder
                .forAddress("localhost", port)
                /*use plain text when ssl certificate is not present*/
                .usePlaintext()
                .build();
        var stub = BankServiceGrpc.newBlockingStub(builder);
        BankServiceOuterClass.BankRequest request = BankServiceOuterClass.BankRequest.newBuilder()
                .setAccountNumber(127)
                .build();
        var balance = stub.getAccountBalance(request);
        log.info("GrpcClient :: balance :: {}",balance);
    }
}

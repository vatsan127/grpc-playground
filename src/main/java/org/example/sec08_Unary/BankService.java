package org.example.sec08_Unary;

import io.grpc.stub.StreamObserver;
import org.example.grpc.collection.BankServiceGrpc;
import org.example.grpc.collection.BankServiceOuterClass;
import org.example.grpc.server.GrpcServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankService extends BankServiceGrpc.BankServiceImplBase {
    private static Logger log = LoggerFactory.getLogger(GrpcServer.class);
    @Override
    public void getAccountBalance(BankServiceOuterClass.BankRequest request, StreamObserver<BankServiceOuterClass.BankResponse> responseObserver) {
    log.info("BankService :: getAccountBalance :: incomingRequest :: {}",request);
        int accountNumber = request.getAccountNumber();
        BankServiceOuterClass.BankResponse bankResponse = BankServiceOuterClass.BankResponse.newBuilder()
                .setAccountNumber(accountNumber)
                .setAccountBalance(500)
                .build();
        log.info("BankService :: getAccountBalance :: resopnse :: {}",bankResponse);
        responseObserver.onNext(bankResponse);
        responseObserver.onCompleted();
    }
}

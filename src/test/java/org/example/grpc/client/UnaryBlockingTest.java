package org.example.grpc.client;

import org.example.grpc.collection.BankServiceOuterClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnaryBlockingTest extends AbstractTest{
    private static final Logger log  = LoggerFactory.getLogger(UnaryBlockingTest.class);

    @Test
    public void getBalanceTest(){
        var request = BankServiceOuterClass.BankRequest.newBuilder()
                .setAccountNumber(1787)
                .build();

        var response = this.blockingStub.getAccountBalance(request);
        log.info("UnaryBlockingTest :: getBalanceTest :: {}",response);
        Assertions.assertEquals(500,response.getAccountBalance());
    }

}

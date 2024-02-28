package org.example.grpc.server;

import org.example.sec08_Unary.BankService;

public class DemoServer {
    public static void main(String[] args) {
        GrpcServer.create(new BankService()).start().await();
    }
}

package org.example.grpc.server;

import io.grpc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GrpcServer {
    private static int port = 6565;
    private static Logger log = LoggerFactory.getLogger(GrpcServer.class);

    private final Server server;

    private GrpcServer(Server server) {
        this.server = server;
    }

    /*For default server port*/
    public static GrpcServer create(BindableService... services){
        return create(6565, services);
    }

    public static GrpcServer create(int port, BindableService... services) {
        ServerBuilder builder = ServerBuilder.forPort(port);
        Arrays.asList(services).forEach(service -> builder.addService(service));
        return new GrpcServer(builder.build());
    }

    public GrpcServer start() {
        List<String> grpcServices = server.getServices()
                .stream()
                .map(ServerServiceDefinition::getServiceDescriptor)
                .map(ServiceDescriptor::getName)
                .collect(Collectors.toList());

        try {
            server.start();
            log.info("Started gRPC server on port {} .", port);
            log.info("Services running {} .", grpcServices);
            return this;
        } catch (Exception e) {
            log.error("Failed to start gRPC server on port {} .", port);
            throw new RuntimeException(e);
        }
    }

    public void await() {
        try {
            server.awaitTermination();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void stop(){
        server.shutdownNow();
        log.debug("gRPC Server stopped");
    }

}

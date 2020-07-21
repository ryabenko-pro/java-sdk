package com.elarian.sdk

import io.grpc.ManagedChannelBuilder
import io.grpc.Metadata
import io.grpc.stub.MetadataUtils
import com.elarian.hera.proto.GrpcWebService


class Elarian(val apiKey: String, val sandbox: Boolean = false) {

    lateinit var stub: GrpcWebServiceCoroutineStub

    init {
        val host = if (sandbox) "api.elarian.dev" else "api.elarian.com"
        val port = 443
        val channel = ManagedChannelBuilder
                .forAddress(host, port)
                .useTransportSecurity()
                .build()
        val metadata = Metadata()
        val key = Metadata.Key.of("api-key", Metadata.ASCII_STRING_MARSHALLER)
        metadata.put(key, apiKey)
        stub = GrpcWebServiceCoroutineStub(channel)
        stub = MetadataUtils.attachHeaders(stub, metadata)
    }

}
/**
 * @fileoverview gRPC-Web generated client stub for io.vertx.grpcweb
 * @enhanceable
 * @public
 */

// Code generated by protoc-gen-grpc-web. DO NOT EDIT.
// versions:
// 	protoc-gen-grpc-web v1.5.0
// 	protoc              v3.21.12
// source: grpc-web-testing.proto


/* eslint-disable */
// @ts-nocheck



const grpc = {};
grpc.web = require('grpc-web');

const proto = {};
proto.io = {};
proto.io.vertx = {};
proto.io.vertx.grpcweb = require('./grpc-web-testing_pb.js');

/**
 * @param {string} hostname
 * @param {?Object} credentials
 * @param {?grpc.web.ClientOptions} options
 * @constructor
 * @struct
 * @final
 */
proto.io.vertx.grpcweb.TestServiceClient =
    function(hostname, credentials, options) {
  if (!options) options = {};
  options.format = 'text';

  /**
   * @private @const {!grpc.web.GrpcWebClientBase} The client
   */
  this.client_ = new grpc.web.GrpcWebClientBase(options);

  /**
   * @private @const {string} The hostname
   */
  this.hostname_ = hostname.replace(/\/+$/, '');

};


/**
 * @param {string} hostname
 * @param {?Object} credentials
 * @param {?grpc.web.ClientOptions} options
 * @constructor
 * @struct
 * @final
 */
proto.io.vertx.grpcweb.TestServicePromiseClient =
    function(hostname, credentials, options) {
  if (!options) options = {};
  options.format = 'text';

  /**
   * @private @const {!grpc.web.GrpcWebClientBase} The client
   */
  this.client_ = new grpc.web.GrpcWebClientBase(options);

  /**
   * @private @const {string} The hostname
   */
  this.hostname_ = hostname.replace(/\/+$/, '');

};


/**
 * @const
 * @type {!grpc.web.MethodDescriptor<
 *   !proto.io.vertx.grpcweb.Empty,
 *   !proto.io.vertx.grpcweb.Empty>}
 */
const methodDescriptor_TestService_EmptyCall = new grpc.web.MethodDescriptor(
  '/io.vertx.grpcweb.TestService/EmptyCall',
  grpc.web.MethodType.UNARY,
  proto.io.vertx.grpcweb.Empty,
  proto.io.vertx.grpcweb.Empty,
  /**
   * @param {!proto.io.vertx.grpcweb.Empty} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  proto.io.vertx.grpcweb.Empty.deserializeBinary
);


/**
 * @param {!proto.io.vertx.grpcweb.Empty} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @param {function(?grpc.web.RpcError, ?proto.io.vertx.grpcweb.Empty)}
 *     callback The callback function(error, response)
 * @return {!grpc.web.ClientReadableStream<!proto.io.vertx.grpcweb.Empty>|undefined}
 *     The XHR Node Readable Stream
 */
proto.io.vertx.grpcweb.TestServiceClient.prototype.emptyCall =
    function(request, metadata, callback) {
  return this.client_.rpcCall(this.hostname_ +
      '/io.vertx.grpcweb.TestService/EmptyCall',
      request,
      metadata || {},
      methodDescriptor_TestService_EmptyCall,
      callback);
};


/**
 * @param {!proto.io.vertx.grpcweb.Empty} request The
 *     request proto
 * @param {?Object<string, string>=} metadata User defined
 *     call metadata
 * @return {!Promise<!proto.io.vertx.grpcweb.Empty>}
 *     Promise that resolves to the response
 */
proto.io.vertx.grpcweb.TestServicePromiseClient.prototype.emptyCall =
    function(request, metadata) {
  return this.client_.unaryCall(this.hostname_ +
      '/io.vertx.grpcweb.TestService/EmptyCall',
      request,
      metadata || {},
      methodDescriptor_TestService_EmptyCall);
};


/**
 * @const
 * @type {!grpc.web.MethodDescriptor<
 *   !proto.io.vertx.grpcweb.EchoRequest,
 *   !proto.io.vertx.grpcweb.EchoResponse>}
 */
const methodDescriptor_TestService_UnaryCall = new grpc.web.MethodDescriptor(
  '/io.vertx.grpcweb.TestService/UnaryCall',
  grpc.web.MethodType.UNARY,
  proto.io.vertx.grpcweb.EchoRequest,
  proto.io.vertx.grpcweb.EchoResponse,
  /**
   * @param {!proto.io.vertx.grpcweb.EchoRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  proto.io.vertx.grpcweb.EchoResponse.deserializeBinary
);


/**
 * @param {!proto.io.vertx.grpcweb.EchoRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @param {function(?grpc.web.RpcError, ?proto.io.vertx.grpcweb.EchoResponse)}
 *     callback The callback function(error, response)
 * @return {!grpc.web.ClientReadableStream<!proto.io.vertx.grpcweb.EchoResponse>|undefined}
 *     The XHR Node Readable Stream
 */
proto.io.vertx.grpcweb.TestServiceClient.prototype.unaryCall =
    function(request, metadata, callback) {
  return this.client_.rpcCall(this.hostname_ +
      '/io.vertx.grpcweb.TestService/UnaryCall',
      request,
      metadata || {},
      methodDescriptor_TestService_UnaryCall,
      callback);
};


/**
 * @param {!proto.io.vertx.grpcweb.EchoRequest} request The
 *     request proto
 * @param {?Object<string, string>=} metadata User defined
 *     call metadata
 * @return {!Promise<!proto.io.vertx.grpcweb.EchoResponse>}
 *     Promise that resolves to the response
 */
proto.io.vertx.grpcweb.TestServicePromiseClient.prototype.unaryCall =
    function(request, metadata) {
  return this.client_.unaryCall(this.hostname_ +
      '/io.vertx.grpcweb.TestService/UnaryCall',
      request,
      metadata || {},
      methodDescriptor_TestService_UnaryCall);
};


/**
 * @const
 * @type {!grpc.web.MethodDescriptor<
 *   !proto.io.vertx.grpcweb.StreamingRequest,
 *   !proto.io.vertx.grpcweb.StreamingResponse>}
 */
const methodDescriptor_TestService_StreamingCall = new grpc.web.MethodDescriptor(
  '/io.vertx.grpcweb.TestService/StreamingCall',
  grpc.web.MethodType.SERVER_STREAMING,
  proto.io.vertx.grpcweb.StreamingRequest,
  proto.io.vertx.grpcweb.StreamingResponse,
  /**
   * @param {!proto.io.vertx.grpcweb.StreamingRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  proto.io.vertx.grpcweb.StreamingResponse.deserializeBinary
);


/**
 * @param {!proto.io.vertx.grpcweb.StreamingRequest} request The request proto
 * @param {?Object<string, string>=} metadata User defined
 *     call metadata
 * @return {!grpc.web.ClientReadableStream<!proto.io.vertx.grpcweb.StreamingResponse>}
 *     The XHR Node Readable Stream
 */
proto.io.vertx.grpcweb.TestServiceClient.prototype.streamingCall =
    function(request, metadata) {
  return this.client_.serverStreaming(this.hostname_ +
      '/io.vertx.grpcweb.TestService/StreamingCall',
      request,
      metadata || {},
      methodDescriptor_TestService_StreamingCall);
};


/**
 * @param {!proto.io.vertx.grpcweb.StreamingRequest} request The request proto
 * @param {?Object<string, string>=} metadata User defined
 *     call metadata
 * @return {!grpc.web.ClientReadableStream<!proto.io.vertx.grpcweb.StreamingResponse>}
 *     The XHR Node Readable Stream
 */
proto.io.vertx.grpcweb.TestServicePromiseClient.prototype.streamingCall =
    function(request, metadata) {
  return this.client_.serverStreaming(this.hostname_ +
      '/io.vertx.grpcweb.TestService/StreamingCall',
      request,
      metadata || {},
      methodDescriptor_TestService_StreamingCall);
};


/**
 * @param {string} hostname
 * @param {?Object} credentials
 * @param {?grpc.web.ClientOptions} options
 * @constructor
 * @struct
 * @final
 */
proto.io.vertx.grpcweb.UnimplementedServiceClient =
    function(hostname, credentials, options) {
  if (!options) options = {};
  options.format = 'text';

  /**
   * @private @const {!grpc.web.GrpcWebClientBase} The client
   */
  this.client_ = new grpc.web.GrpcWebClientBase(options);

  /**
   * @private @const {string} The hostname
   */
  this.hostname_ = hostname.replace(/\/+$/, '');

};


/**
 * @param {string} hostname
 * @param {?Object} credentials
 * @param {?grpc.web.ClientOptions} options
 * @constructor
 * @struct
 * @final
 */
proto.io.vertx.grpcweb.UnimplementedServicePromiseClient =
    function(hostname, credentials, options) {
  if (!options) options = {};
  options.format = 'text';

  /**
   * @private @const {!grpc.web.GrpcWebClientBase} The client
   */
  this.client_ = new grpc.web.GrpcWebClientBase(options);

  /**
   * @private @const {string} The hostname
   */
  this.hostname_ = hostname.replace(/\/+$/, '');

};


/**
 * @const
 * @type {!grpc.web.MethodDescriptor<
 *   !proto.io.vertx.grpcweb.Empty,
 *   !proto.io.vertx.grpcweb.Empty>}
 */
const methodDescriptor_UnimplementedService_UnimplementedCall = new grpc.web.MethodDescriptor(
  '/io.vertx.grpcweb.UnimplementedService/UnimplementedCall',
  grpc.web.MethodType.UNARY,
  proto.io.vertx.grpcweb.Empty,
  proto.io.vertx.grpcweb.Empty,
  /**
   * @param {!proto.io.vertx.grpcweb.Empty} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  proto.io.vertx.grpcweb.Empty.deserializeBinary
);


/**
 * @param {!proto.io.vertx.grpcweb.Empty} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @param {function(?grpc.web.RpcError, ?proto.io.vertx.grpcweb.Empty)}
 *     callback The callback function(error, response)
 * @return {!grpc.web.ClientReadableStream<!proto.io.vertx.grpcweb.Empty>|undefined}
 *     The XHR Node Readable Stream
 */
proto.io.vertx.grpcweb.UnimplementedServiceClient.prototype.unimplementedCall =
    function(request, metadata, callback) {
  return this.client_.rpcCall(this.hostname_ +
      '/io.vertx.grpcweb.UnimplementedService/UnimplementedCall',
      request,
      metadata || {},
      methodDescriptor_UnimplementedService_UnimplementedCall,
      callback);
};


/**
 * @param {!proto.io.vertx.grpcweb.Empty} request The
 *     request proto
 * @param {?Object<string, string>=} metadata User defined
 *     call metadata
 * @return {!Promise<!proto.io.vertx.grpcweb.Empty>}
 *     Promise that resolves to the response
 */
proto.io.vertx.grpcweb.UnimplementedServicePromiseClient.prototype.unimplementedCall =
    function(request, metadata) {
  return this.client_.unaryCall(this.hostname_ +
      '/io.vertx.grpcweb.UnimplementedService/UnimplementedCall',
      request,
      metadata || {},
      methodDescriptor_UnimplementedService_UnimplementedCall);
};


module.exports = proto.io.vertx.grpcweb;


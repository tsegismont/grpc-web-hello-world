const {Empty, EchoRequest, StreamingRequest} = require('./grpc-web-testing_pb');
const {TestServiceClient, UnimplementedServiceClient} = require('./grpc-web-testing_grpc_web_pb');

const testServiceClient = new TestServiceClient('http://' + window.location.hostname + ':8080', null, null);
const unimplementedServiceClient = new UnimplementedServiceClient('http://' + window.location.hostname + ':8080', null, null);

const ECHO_INITIAL_KEY = 'x-grpc-test-echo-initial';
const ECHO_INITIAL_VALUE = 'test_initial_metadata_value';
const ECHO_TRAILING_KEY = 'x-grpc-test-echo-trailing-bin';
const ECHO_TRAILING_VALUE = 0xababab;
const someMetadata = {
  [ECHO_INITIAL_KEY]: ECHO_INITIAL_VALUE,
  [ECHO_TRAILING_KEY]: ECHO_TRAILING_VALUE
};

// Empty Payload
const empty = new Empty();
testServiceClient.emptyCall(empty, {}, (err, response) => {
  if (err) {
    console.log(`Unexpected error for emptyCall: code = ${err.code}` + `, message = "${err.message}"`);
  } else {
    console.log(response instanceof Empty);
  }
});

// Empty Payload with Metdata
testServiceClient.emptyCall(empty, someMetadata, (err, response) => {
  if (err) {
    console.log(`Unexpected error for emptyCall: code = ${err.code}` + `, message = "${err.message}"`);
  } else {
    console.log(response instanceof Empty);
  }
})
  .on('metadata', (metadata) => {
    console.log(`Got metadata: ${metadata[ECHO_INITIAL_KEY]}`)
  })
  .on('status', (status) => {
    console.log(`Got status: ${status.metadata[ECHO_TRAILING_KEY]}`)
  });

// Small payload
const smallEchoRequest = new EchoRequest();
smallEchoRequest.setPayload("foobar");
testServiceClient.unaryCall(smallEchoRequest, {}, (err, response) => {
  if (err) {
    console.log(`Unexpected error for unaryCall: code = ${err.code}` + `, message = "${err.message}"`);
  } else {
    console.log(response.getPayload());
  }
});

// Large payload with metadata
const largeEchoRequest = new EchoRequest();
largeEchoRequest.setPayload("foobar".repeat(16 * 1024));
testServiceClient.unaryCall(largeEchoRequest, someMetadata, (err, response) => {
  if (err) {
    console.log(`Unexpected error for unaryCall: code = ${err.code}` + `, message = "${err.message}"`);
  } else {
    console.log(response.getPayload() === largeEchoRequest.getPayload());
  }
});

// Server-side Streaming
const streamRequest = new StreamingRequest();
streamRequest.setResponseSizeList([157, 52, 16 * 1024, 1]);

testServiceClient.streamingCall(streamRequest, {})
  .on('data', (response) => {
  console.log(response.getPayload().length);
  })
  .on('error', (err) => {
  console.log(`Unexpected stream error: code = ${err.code}` + `, message = "${err.message}"`);
});

// Server-side Streaming with metadata
testServiceClient.streamingCall(streamRequest, someMetadata)
  .on('data', (response) => {
    console.log(response.getPayload().length);
  })
  .on('error', (err) => {
    console.log(`Unexpected stream error: code = ${err.code}` + `, message = "${err.message}"`);
  })

  .on('metadata', (metadata) => {
    console.log(`Got metadata: ${metadata[ECHO_INITIAL_KEY]}`)
  })
  .on('status', (status) => {
    console.log(`Got status: ${status.metadata[ECHO_TRAILING_KEY]}`)
  });

// Custom metadata
const someEchoRequest = new EchoRequest();
someEchoRequest.setPayload("foobar".repeat(16 * 1024));
testServiceClient.unaryCall(someEchoRequest, someMetadata, (err, response) => {
  if (err) {
    console.log(`Unexpected error for unaryCall: code = ${err.code}` + `, message = "${err.message}"`);
  } else {
    console.log(response.getPayload() === someEchoRequest.getPayload());
  }
})
  .on('metadata', (metadata) => {
    console.log(`Got metadata: ${metadata[ECHO_INITIAL_KEY]}`)
  })
  .on('status', (status) => {
    console.log(`Got status: ${status.metadata[ECHO_TRAILING_KEY]}`)
  });

// Unimplemented method
unimplementedServiceClient.unimplementedCall(new Empty(), {}, (err, response) => {
  if (err) {
    console.log(`Error for unimplementedCall: code = ${err.code}` + `, message = "${err.message}"`);
  } else {
    console.log(`Unexpected success for unimplementedCall`);
  }
});

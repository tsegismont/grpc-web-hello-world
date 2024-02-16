const {Empty, EchoRequest, StreamingRequest} = require('./grpc-web-testing_pb');
const {TestServiceClient, UnimplementedServiceClient} = require('./grpc-web-testing_grpc_web_pb');

const testServiceClient = new TestServiceClient('http://' + window.location.hostname + ':8080', null, null);
const unimplementedServiceClient = new UnimplementedServiceClient('http://' + window.location.hostname + ':8080', null, null);

const HEADER_TEXT_KEY = 'x-header-text-key';
const HEADER_TEXT_VALUE = 'header_text_value';

const HEADER_BIN_KEY = 'x-header-bin-key-bin';
const HEADER_BIN_VALUE = 0xabcdef;


const TRAILER_TEXT_KEY = 'x-trailer-text-key';
const TRAILER_TEXT_VALUE = 'trailer_text_value';

const TRAILER_BIN_KEY = 'x-trailer-bin-key-bin';
const TRAILER_BIN_VALUE = 0xfedcba;

const TRAILER_ERROR_KEY = "x-error-trailer"

const someMetadata = {
  [HEADER_TEXT_KEY]: HEADER_TEXT_VALUE,
  [HEADER_BIN_KEY]: HEADER_BIN_VALUE,
  [TRAILER_TEXT_KEY]: TRAILER_TEXT_VALUE,
  [TRAILER_BIN_KEY]: TRAILER_BIN_VALUE,
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

// Empty Payload with metadata
testServiceClient.emptyCall(empty, someMetadata, (err, response) => {
  if (err) {
    console.log(`Unexpected error for emptyCall: code = ${err.code}` + `, message = "${err.message}"`);
  } else {
    console.log(response instanceof Empty);
  }
})
  .on('metadata', (metadata) => {
    console.log(`Got metadata: ${metadata[HEADER_TEXT_KEY]}`)
  })
  .on('status', (status) => {
    console.log(`Got status: ${status.metadata[TRAILER_BIN_KEY]}`)
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
    console.log(`Got metadata: ${metadata[HEADER_TEXT_KEY]}`)
  })
  .on('status', (status) => {
    console.log(`Got status: ${status.metadata[TRAILER_BIN_KEY]}`)
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
    console.log(`Got metadata: ${metadata[HEADER_TEXT_KEY]}`)
  })
  .on('status', (status) => {
    console.log(`Got status: ${status.metadata[TRAILER_BIN_KEY]}`)
  });

// Trailers-only
const boomRequest = new EchoRequest();
boomRequest.setPayload("boom");
testServiceClient.unaryCall(boomRequest, someMetadata, (err, response) => {
  if (err) {
    console.log(`Expected error for unaryCall: code = ${err.code}` + `, message = "${err.message}"`);
  } else {
    console.log(response.getPayload() === boomRequest.getPayload());
  }
})
  .on('metadata', (metadata) => {
    console.log(`Got metadata: ${metadata[HEADER_TEXT_KEY]}`)
  })
  .on('status', (status) => {
    console.log(`Got status: ${status.code}`)
  });

// Unimplemented method
unimplementedServiceClient.unimplementedCall(new Empty(), {}, (err, response) => {
  if (err) {
    console.log(`Error for unimplementedCall: code = ${err.code}` + `, message = "${err.message}"`);
  } else {
    console.log(`Unexpected success for unimplementedCall`);
  }
});

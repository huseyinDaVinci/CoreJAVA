import java.io.IOException;

public class Main {

	// main package for this classes is "java.io" and also "java.nio"
	// non-blocking I/O improved performance.

	// Purpose is able to read and write the streams of data while transmitting
	// from one point to another
	// can be streamed as byte after byte, character after character, primitive
	// after primitive

	/*
	 * SUMMARY
	 * 
	 * InputStreams and OutputStreams byte by byte Reader and Writer character
	 * by character DataInputStream and DataOutputStream primitive by primitive
	 * 
	 * 1-How to decide which StreamReader and Writer we use? --it depends on
	 * simply which kind of data is coming and going. No matter which type of
	 * stream you used the operations will be the same.
	 * 
	 * opening the stream pointing stream source which can be a file,a socket or
	 * a URL. read/write should close the stream channel.
	 */

	public Main() {

		ByteStreams byteStreams;
		try {
			byteStreams = ByteStreams.byteStreamsInstance();

			byteStreams.readTest();

			byteStreams.writeTest("This is written for testing outputstream", "testOut.txt");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		new Main();
	}
}

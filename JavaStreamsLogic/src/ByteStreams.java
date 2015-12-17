import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreams {

	// Ok. lets try bytestreams (InputStream and OutputStream)

	// we can use FileInputStream/FileOutputStream the subclass of (InputStream
	// and OutputStream)

	public static ByteStreams byteStreamsInstance() {

		ByteStreams byteStreams = new ByteStreams();

		return byteStreams;

	}

	public void writeTest(String content, String filename) throws IOException {

		FileOutputStream fileOutputStream = null;

		try {

			fileOutputStream = new FileOutputStream(new File(filename));

			for (int i : content.getBytes()) {

				fileOutputStream.write(i);

			}
		} catch (Exception e) {

			System.out.println("@WriteTest:" + e.getMessage().toLowerCase());

		} finally {

			fileOutputStream.close();
		}

	}

	public void readTest() throws IOException {

		FileInputStream fileInputStream = null;
		try {

			fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\test.txt");

			boolean eof = false;

			while (!eof) {

				int value = fileInputStream.read();

				if (value == -1)
					eof = true;

				System.out.println(fileInputStream.read());

			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage().toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage().toString());
		} finally {

			fileInputStream.close();
		}

	}

}

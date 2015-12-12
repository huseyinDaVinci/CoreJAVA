import java.io.IOException;
import java.io.InputStream;

public class DownloadURLImpl extends DownloadURLBase {

	public DownloadURLImpl() {

		super();

	}

	@Override
	public void processDataURL(InputStream input) throws IOException {
		int data = input.read();

		StringBuilder sb = new StringBuilder();
		while (data != -1) {

			sb.append((char) data);

			data = input.read();
		}

		System.out.println(sb.toString());

	}

}

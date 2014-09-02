import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;



public class raspberrypi_bt_server{
	//static PipedOutputStream output;
	//static PipedInputStream input;
	
	
    private static final int PORT = 9001;
    //private static final int PORT = 9001;
    private static final String SERVER_ADDRESS = "10.0.0.16";
	
	public static void main(String[] args) throws IOException{
		PipedOutputStream output = new PipedOutputStream();
		PipedInputStream input = new PipedInputStream(output);

	}
	
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Principal {

	public static void main(String[] args) {
//		
//		ServerSocket server;
//        Socket client;
//        InputStream input;
//
//        try {
//            server = new ServerSocket(1010);
//            client = server.accept();
//
//            input = client.getInputStream();
//            String inputString = Principal.inputStreamAsString(input);

            PrinterService printerService = new PrinterService();

            System.out.println(printerService.getPrinters());
            
            String inputString = "teste";

            String command =
            		"^XA\n"+
            				"^FO,20,20^BQ,2,10\n"+
            				"^FDD03048F,LM,N0123456789,A12AABB,B0006qrcode^FS\n"+
            				"^XZ\n";
//                    "N\n" + 
//            		"S3\n"+
//            		"D8\n"+
//            		"ZT\n"+
//            		"JF\n"+
//                    "A10,0,0,3,0,1,1,N,\""+inputString+"\"\n" +
//                    "A20,50,0,3,0,1,1,R,\""+inputString+"\"\n" + 
//                    "P1\n";
            //print some stuff. Change the printer name to your thermal printer name.
            printerService.printBytes("ELGIN L42PRO 2", command.getBytes());
            
//            System.out.println(inputString);
//
//            client.close();
//            server.close();
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        // cut that paper!
//        byte[] cutP = new byte[] { 0x1d, 'V', 1 };
//
//        printerService.printBytes("EPSON-TM-T20II", cutP);
	}
	
	public static String inputStreamAsString(InputStream stream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(stream));
        StringBuilder sb = new StringBuilder();
        String line = null;

        while ((line = br.readLine()) != null) {
            sb.append(line + "\n");
        }

        br.close();
        return sb.toString();
    }


}

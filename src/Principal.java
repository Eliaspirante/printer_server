import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Principal {

	public static void main(String[] args) {
		ServerSocket server;
        Socket client;
        InputStream input;

        try {
        	server = new ServerSocket(8081);
        
        	System.out.print("Server started!!");
        	
        	while(true) {
	            client = server.accept();
	
	            input = client.getInputStream();
	            String inputString = Principal.inputStreamAsString(input);
	
	            PrinterService printerService = new PrinterService();
	
	            System.out.println(printerService.getPrinters());
	            
	            StringBuilder texto = new StringBuilder();
	            
	            String[] datas = inputString.split(";");
	            
	            for(int i = 0; i < datas.length; i++) {
		            String[] data = datas[i].split(":");
		            String type = data[0];
		            String data1 = data[1];
		            
		            texto.append("N\n");
		            texto.append("JF\n");
		            texto.append("ZB\n");
		            texto.append("Q100,24\n");
		            texto.append("q760\n");
//		            texto.append("A80,0,0,4,1,1,N,\""+data1+"\"\n");
		            System.out.println(type);
		            if(type.equals("EAN")) {
		            	String codigo = data[2].replace("\n", "");
		            	System.out.println("ENTROU EAN");
		            	System.out.println(data[2].replace("\n", ""));
//		            	texto.append("B250,0,0,UE0,3,3,30,B,\""+codigo+"\"\n");
		            	texto.append("B50,0,0,UE0,3,3,30,B,\""+codigo+"\"\n");
		            }
		            if(type.equals("EAN128")) {
		            	String codigo = data[2].replace("\n", "");
		            	System.out.println("ENTROU EAN128");
		            	System.out.println(data[2].replace("\n", ""));
//		            	texto.append("B270,0,0,1E,2,3,30,B,\""+codigo+"\"\n");
		            	texto.append("B70,0,0,1E,2,3,30,B,\""+codigo+"\"\n");
		            }
		            if(type.equals("2OF5")) {
		            	String codigo = data[2].replace("\n", "");
		            	System.out.println("ENTROU 2OF5");
		            	System.out.println(data[2].replace("\n", ""));
//		            	texto.append("B300,0,0,2D,5,6,30,B,\""+codigo+"\"\n");
		            	texto.append("B100,0,0,2D,5,6,30,B,\""+codigo+"\"\n");
		            }
		            if(type.equals("CODE39")) {
		            	String codigo = data[2].replace("\n", "");
		            	System.out.println("ENTROU CODE");
		            	System.out.println(data[2]);
//		            	texto.append("B250,0,0,1,3,4,20,N,\""+codigo+"\"\n");
		            	texto.append("B50,0,0,1,3,4,20,N,\""+codigo+"\"\n");
		            }
		            texto.append("A250,0,0,4,1,1,N,\""+data1+"\"\n");
		            texto.append("P1\n");
	            }
	            
	            printerService.printBytes("ELGIN_L42PRO", texto.toString().getBytes());
	            
	            System.out.println("Print data!!");
	            System.out.println(inputString);
	
	            client.close();
        	}
        	
        	
        }
        catch (Exception e) {
            e.printStackTrace();
            
        }

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

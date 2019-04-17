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
            
            String teste = "TESTE DE IMPRESSAO";
            String teste2 = "aqui novo";
            StringBuilder texto = new StringBuilder("N\n"); //  (limpa o buffer de impressão, para ser iniciado um novo arquivo BPLB)
            texto.append("D27\n");  //(configura a Densidade ou aquecimento da cabeça de impressão para o valor 9)
            texto.append("S1\n");  //(configura a Velocidade de impressão para 3 pol./seg)
            texto.append("JF\n");  //(habilita o “backfeed” para que ao final da impressão, o espaço entre etiquetas pare na serrilha)
            texto.append("ZB\n");  //(indica que a impressão deve inciar a partir do topo, ou seja, de cabeça para baixo)
            texto.append("q760\n");
            texto.append("A40,20,0,3,1,1,N," + '"' +  teste  + '"' + "\n");
            texto.append("A250,20,0,3,1,1,N," + '"' +  teste2  + '"' + "\n");
            texto.append("P1\n");
            //print some stuff. Change the printer name to your thermal printer name.
            printerService.printBytes("ELGIN L42Pro", texto.toString().getBytes());
            		
//            printerService.printString("ELGIN L42Pro","teste");
            
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

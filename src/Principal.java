
public class Principal {

	public static void main(String[] args) {
		PrinterService printerService = new PrinterService();

        System.out.println(printerService.getPrinters());

        String command =  
                "N\n" + 
                "q609\n" + 
                "Q203,26\n" + 
                "A26,26,0,5,1,2,N,\"HI, MOM!\"\n" + 
                "P1,1";
        //print some stuff. Change the printer name to your thermal printer name.
        printerService.printBytes("ELGIN L42PRO", command.getBytes());
//
//        // cut that paper!
//        byte[] cutP = new byte[] { 0x1d, 'V', 1 };
//
//        printerService.printBytes("EPSON-TM-T20II", cutP);
	}

}

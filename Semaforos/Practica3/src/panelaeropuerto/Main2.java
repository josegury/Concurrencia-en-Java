package panelaeropuerto;

public class Main2 {


   private static void nap(int millisecs) {
        try {
            Thread.sleep(millisecs);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String [] args) {
	PanelNivel2 d = new IPanel2();

	for(int i=0; i < 20; i++) {
	    d.ponLinea("AAAAAAAAAAAA  "+i);
	    d.ponLinea("BBBBBBBBBBBB  "+i);
	    nap(500);
	    d.borraLinea(0);
            nap(500);
	}
      
    }
}
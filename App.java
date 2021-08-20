import java.awt.EventQueue;

import vista.VistaRequerimientos;

public class App {

	public static void main(String[] args) {
		 
        // Ejecutar Swing en otro hilo
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
                try{
                    VistaRequerimientos frame = new VistaRequerimientos();
                    frame.setVisible(true);
                } catch(Exception e){
                    e.printStackTrace();
                }
                
            }
            
        });
        
	}

}

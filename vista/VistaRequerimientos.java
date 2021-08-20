package vista;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controlador.ControladorRequerimientos;
import modelo.VO.LideresCostosPromVO;
import modelo.VO.LideresVO;
import modelo.VO.MaterialesProyectosVO;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class VistaRequerimientos extends JFrame {

	private static final ControladorRequerimientos controlador = new ControladorRequerimientos();
	
	  private static final long serialVersionUID = 1L;
	    private JPanel contentPane;
	    private JTextArea textArea;

	    public VistaRequerimientos(){
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(450, 200, 520,488);
	        contentPane = new JPanel();
	        contentPane.setBackground(SystemColor.activeCaption);
	        contentPane.setBorder(new EmptyBorder(5,5,5,5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        JLabel lbltitulo = new JLabel("Reto 5");
	        lbltitulo.setFont(new Font("Arial", Font.PLAIN, 40));
	        lbltitulo.setBounds(199, 11, 139, 56);
	        contentPane.add(lbltitulo);

	        // Dimensiona el contenido dentro de la ventana
	        JScrollPane scrollPane = new JScrollPane();
	        scrollPane.setBounds(28, 70, 463, 288);
	        contentPane.add(scrollPane);

	        // Proporciona una vista desplazable de un componente en una ventana grafica
	        textArea = new JTextArea();
	        textArea.setEditable(false);
	        textArea.setFont(new Font("Arial", Font.PLAIN, 13));
	        scrollPane.setViewportView(textArea);

	        JButton btnConsuta1 = new JButton("Requerimiento 1");
	        btnConsuta1.setBackground(Color.GRAY);
	        btnConsuta1.addActionListener(new ActionListener(){
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                requerimiento1();
	            }
	        });
	        btnConsuta1.setBounds(28, 369, 133, 29);
	        contentPane.add(btnConsuta1);

	        JButton btnConsuta2 = new JButton("Requerimiento 2");
	        btnConsuta2.setBackground(Color.GRAY);
	        btnConsuta2.addActionListener(new ActionListener(){
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                requerimiento2();
	            }
	        });
	        btnConsuta2.setBounds(171, 369, 133, 29);
	        contentPane.add(btnConsuta2);

	        JButton btnConsuta3 = new JButton("Requerimiento 3");
	        btnConsuta3.setBackground(Color.GRAY);
	        btnConsuta3.addActionListener(new ActionListener(){
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                requerimiento3();
	            }
	        });
	        btnConsuta3.setBounds(314, 369, 133, 29);
	        contentPane.add(btnConsuta3);

	        JButton btnLimpiar = new JButton("Limpiar");
	        btnLimpiar.addActionListener(new ActionListener(){
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                textArea.setText("");
	            }
	        });
	        btnLimpiar.setBounds(181, 409, 117, 29);
	        contentPane.add(btnLimpiar);

	    }
	
	public  void requerimiento1(){
		String salida = "Requerimiento 1, Consulta 1: \n" + 
		"Lider   \t\t Cargo \n";		
		try {
			ArrayList<LideresVO> arregloResultados = controlador.consultarLideresCargo();
			for(LideresVO registro: arregloResultados){
				salida += registro.getNombre() + "\t" + registro.getCargo() + "\n";
				
			}
			
			textArea.setText(salida);
		} catch (Exception e) {
			System.out.println("Error !! " + e.getMessage());
		}
	}

	public  void requerimiento2() {

		String salida = "Requerimiento 2, Consulta 4: \n" +
						"Nombre Material \t Precio Unidad \t  Total \n" ;
		try {
			ArrayList<MaterialesProyectosVO> arregloResultados = controlador.consultarMaterialesProyectos();
			for( MaterialesProyectosVO registro: arregloResultados){
				salida += registro.getNombreMaterial() + "\t\t  " + registro.getPrecio() + " \t\t   " + registro.getTotal() + "\n";
			}
			
			textArea.setText(salida);

		} catch (Exception e) {
			System.out.println("Error !!! " + e.getMessage());
		}

	}
	
	public  void requerimiento3(){
		String salida = "Requerimiento 3, Consulta 5: \n" +
						"Lider \t\t Promedio \n";
		
		try{
			
			ArrayList<LideresCostosPromVO> arregloResultados = controlador.consultarPromedioCostos();
			for(LideresCostosPromVO registro: arregloResultados){
				salida += registro.getNombre() + " \t " + registro.getPromedio() + "\n";
			}
			
			textArea.setText(salida);
			
		}catch (Exception e) {
			System.out.println("Error !!! " + e.getMessage());

		}
	}

}

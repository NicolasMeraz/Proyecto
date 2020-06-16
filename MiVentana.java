import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.io.*;


public class MiVentana{


public class MiVentana extends JFrame implements ActionListener{

	// declaracion de objetos
	JPanel panel;
	JLabel lblTexto1;
	JButton btnBoton1,btnBoton2;
	JTextField txtCampoTexto1,txtCampoTexto2;
	JTextArea txaArea1, txaArea2;
	ArrayList <String> contenido_1;

	JMenuBar menuBar;
	JMenu menu;
	JMenuItem menuItem;

	public MiVentana()
	{	
	


		panel = new JPanel();
		panel.setLayout(null);

		lblTexto1=new JLabel();
		lblTexto1.setBounds(320,85,200,10);

		contenido_1=new ArrayList<String>();
		txaArea1=new JTextArea();
		txaArea1.setBounds(50,110,250,300);
		txaArea2=new JTextArea();
		txaArea2.setBounds(450,110,250,300);


		btnBoton1=new JButton("Leer");
		btnBoton1.setBounds(50,70,100,30);

		btnBoton2=new JButton("Crear");
		btnBoton2.setBounds(450,70,100,30);

		txtCampoTexto1 = new JTextField();
		txtCampoTexto1.setBounds(155,70,150,30);
		txtCampoTexto2 = new JTextField();
		txtCampoTexto2.setBounds(560,70,150,30);

		//MenuBar

		menuBar = new JMenuBar();
		menu=new JMenu("Archivo");
		menuItem=new JMenuItem("Guardar");


		menu.add(menuItem);
		menuBar.add(menu);
		this.setJMenuBar(menuBar);






		panel.add(btnBoton1);
		panel.add(txaArea1);
		panel.add(txaArea2);
		panel.add(btnBoton2);
		panel.add(txtCampoTexto1);
		panel.add(txtCampoTexto2);
		panel.add(lblTexto1);

		this.add(panel);
		this.setTitle("Ventana de Prueba");
		this.setSize(1000,1000);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
		btnBoton1.addActionListener(this);
		btnBoton2.addActionListener(this);
		menuItem.addActionListener(this);


	}

	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource()==btnBoton1)
		{
			contenido_1= Archivo.leerTodo(txtCampoTexto1.getText());
			String cadena = "";
			for(int i=0;i<contenido_1.size();i++)
			{
				cadena=cadena + contenido_1.get(i) + "\n";
			}
			txaArea1.setText(cadena);
			txaArea1.setEditable(false);
		}

		/*else if(event.getSource()==btnBoton2)
		{
			Archivo.guardarTodo(txtCampoTexto2.getText(),txaArea2.getText());
		}*/

		else if(event.getSource()==menuItem)
		{
			//Archivo.guardarTodo(txtCampoTexto2.getText(),txaArea2.getText());
			//MiVentanaEmergente1 mve = new MiVentanaEmergente1();
			JFileChooser fc= new JFileChooser();
			fc.setDialogTitle("Guardando Archivo...");

			int userSelection=fc.showSaveDialog(this);

			if(userSelection == JFileChooser.APPROVE_OPTION)
			{
				File fs = fc.getSelectedFile();
				System.out.println(fs.getAbsolutePath());

				String nombre_archivo = "";
			nombre_archivo=fs.getAbsolutePath();
			Archivo.guardarTodo(nombre_archivo,txaArea2.getText());
			}

			


		}
	}

}
	
}
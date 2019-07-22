package student;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Search_Student {

	private JFrame frame;
	private JTextField ID_field;
	private JTextField name_field;
	private JTextField cgpa_field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search_Student window = new Search_Student();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Search_Student() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 408, 407);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblId.setBounds(21, 30, 82, 43);
		frame.getContentPane().add(lblId);
		
		ID_field = new JTextField();
		ID_field.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id= ID_field.getText();
				name_field.setText(null);
				cgpa_field.setText(null);
				try {
					BufferedReader br=new BufferedReader(new FileReader("input.txt"));
					String string=new String();
					try {
						string = br.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
					while(string!=null)
					{
						String[] ar=string.split("_");
						if(ar[1].equals(id))
						{
							name_field.setText(ar[0]);
							cgpa_field.setText(ar[2]);
							break;
						}
						try {
							string= br.readLine();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if(string==null)
					{
						JOptionPane.showMessageDialog(null, "ID doesn't exist");
					}
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(null,"File Not Found");
				}
			}
		});
		ID_field.setColumns(10);
		ID_field.setBounds(79, 39, 211, 29);
		frame.getContentPane().add(ID_field);
		
		name_field = new JTextField();
		name_field.setColumns(10);
		name_field.setBounds(79, 84, 211, 29);
		frame.getContentPane().add(name_field);
		
		JLabel label = new JLabel("Name");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label.setBounds(10, 79, 82, 43);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("CGPA");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label_1.setBounds(10, 124, 82, 43);
		frame.getContentPane().add(label_1);
		
		cgpa_field = new JTextField();
		cgpa_field.setColumns(10);
		cgpa_field.setBounds(79, 133, 211, 29);
		frame.getContentPane().add(cgpa_field);
	}

}

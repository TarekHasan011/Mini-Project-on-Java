package student;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Student {

	private JFrame frame;
	private JTextField Name_textfield;
	private JTextField ID_textField;
	private JTextField cgpa_textfield;
	private JTextField trimester_textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student window = new Student();
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
	public Student() {
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
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(30, 25, 82, 43);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblId.setBounds(30, 73, 82, 43);
		frame.getContentPane().add(lblId);
		
		JLabel lblCgpa = new JLabel("CGPA");
		lblCgpa.setHorizontalAlignment(SwingConstants.LEFT);
		lblCgpa.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblCgpa.setBounds(30, 117, 82, 43);
		frame.getContentPane().add(lblCgpa);
		
		JLabel lblTrimester = new JLabel("Trimester");
		lblTrimester.setHorizontalAlignment(SwingConstants.LEFT);
		lblTrimester.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTrimester.setBounds(30, 162, 82, 43);
		frame.getContentPane().add(lblTrimester);
		
		Name_textfield = new JTextField();
		Name_textfield.setBounds(108, 30, 211, 29);
		frame.getContentPane().add(Name_textfield);
		Name_textfield.setColumns(10);
		
		ID_textField = new JTextField();
		ID_textField.setColumns(10);
		ID_textField.setBounds(108, 79, 211, 29);
		frame.getContentPane().add(ID_textField);
		
		cgpa_textfield = new JTextField();
		cgpa_textfield.setColumns(10);
		cgpa_textfield.setBounds(108, 127, 211, 29);
		frame.getContentPane().add(cgpa_textfield);
		
		trimester_textField = new JTextField();
		trimester_textField.setColumns(10);
		trimester_textField.setBounds(108, 171, 211, 29);
		frame.getContentPane().add(trimester_textField);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					BufferedWriter bw= new BufferedWriter(new FileWriter(new File("input.txt"),true));
					bw.write(Name_textfield.getText()+"_"+ID_textField.getText()+"_"+cgpa_textfield.getText()+"_"+trimester_textField.getText()+"\r\n");
					bw.close();
					Name_textfield.setText(null);
					ID_textField.setText(null);
					cgpa_textfield.setText(null);
					trimester_textField.setText(null);
					JOptionPane.showMessageDialog(null, "Successfully Added");
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "File not Found");
				}
			}
		});
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSubmit.setBounds(179, 261, 89, 29);
		frame.getContentPane().add(btnSubmit);
	}
}

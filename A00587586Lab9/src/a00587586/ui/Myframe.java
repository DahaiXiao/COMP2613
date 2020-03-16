/**
 * Project:Lab9_A00587586
 * File:Myframe.java
 * Date:Mar 15, 2020
 * Time:9:13:20 PM
 */
package a00587586.ui;


import java.awt.event.ActionEvent;
import java.util.ArrayList;

import java.util.Random;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import a00587586.data.customer.Customer;

import net.miginfocom.swing.MigLayout;
import java.awt.Color;

/**
 * @author Haini Xiao, A00587586
 *
 */
@SuppressWarnings("serial")
public class Myframe extends JFrame {

	private JPanel contentPane;


	/**
	 * Launch the application.
	 */
	/**public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Myframe frame = new Myframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
**/

	/**
	 * Create the frame.
	 */
	public Myframe(ArrayList <Customer> customerList){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450,194);
		setLocationRelativeTo(null);
		setTitle("Haini Frame");


		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);

		JMenuItem menuCustomer = new JMenuItem("Customer");
		menuCustomer.setAccelerator(KeyStroke.getKeyStroke("alt C"));
		menuCustomer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				try {
				
					Customer customer = selectRandomCustomer(customerList);
					CustomerDialog dialog = new CustomerDialog(customer);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		menuFile.add(menuCustomer);

		JSeparator separator = new JSeparator();
		menuFile.add(separator);

		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.setAccelerator(KeyStroke.getKeyStroke("alt X"));
		menuExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuFile.add(menuExit);

		JMenu menuHelp = new JMenu("Help");
		menuBar.add(menuHelp);

		JMenuItem menuAbout = new JMenuItem("About");
		menuAbout.setAccelerator(KeyStroke.getKeyStroke("F1"));
		menuAbout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(menuHelp, "Lab 9\nBy HAINI A00587586", "About Lab 9", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		menuHelp.add(menuAbout);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[]", "[]"));
	}
	
	
	
	public Customer selectRandomCustomer(ArrayList<Customer> customerList){
		
		int arraysize = customerList.size();
		return customerList.get(new Random().nextInt(arraysize));

	}

}

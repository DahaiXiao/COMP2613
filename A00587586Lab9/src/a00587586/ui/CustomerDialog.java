/**
 * Project:Lab7_A00587586
 * File:CustomerDialog.java
 * Date:Mar 12, 2020
 * Time:10:34:22 PM
 */
package a00587586.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import a00587586.data.customer.Customer;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * @author Haini Xiao, A00587586
 *
 */
@SuppressWarnings("serial")
public class CustomerDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;//id
	private JTextField textField_1;//first name
	private JTextField textField_2;//last name
	private JTextField textField_3;//street
	private JTextField textField_4;//city
	private JTextField textField_5;//postal code
	private JTextField textField_6;//phone
	private JTextField textField_7;//email
	private JTextField textField_8;//date

	/**
	 * Launch the application.
	 */
	/**public static void main(String[] args) {
		try {
			CustomerDialog dialog = new CustomerDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/

	/**
	 * Create the dialog.
	 */
	public CustomerDialog(Customer customer) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(new Color(255, 255, 255));
		contentPanel.setBackground(new Color(205, 92, 92));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[70.00][grow]", "[][][][][][][][][]"));
		{
			JLabel lblId = new JLabel("ID");
			lblId.setForeground(new Color(255, 255, 255));
			contentPanel.add(lblId, "cell 0 0,alignx trailing");
		}
		{
			textField = new JTextField();
			textField.setBackground(new Color(204, 204, 204));
			textField.setEditable(false);
			textField.setText(String.valueOf(customer.getId()));
			contentPanel.add(textField, "cell 1 0,growx");
			textField.setColumns(10);
		}
		{
			JLabel lblFirstName = new JLabel("First Name");
			lblFirstName.setForeground(new Color(255, 255, 255));
			contentPanel.add(lblFirstName, "cell 0 1,alignx trailing");
		}
		{
			textField_1 = new JTextField();
			textField_1.setText(customer.getFirstName());
			contentPanel.add(textField_1, "cell 1 1,growx");
			textField_1.setColumns(10);
		}
		{
			JLabel lblLastName = new JLabel("Last Name");
			lblLastName.setForeground(new Color(255, 255, 255));
			contentPanel.add(lblLastName, "cell 0 2,alignx trailing");
		}
		{
			textField_2 = new JTextField();
			textField_2.setText(customer.getLastName());

			contentPanel.add(textField_2, "cell 1 2,growx");
			textField_2.setColumns(10);
		}
		{
			JLabel lblStreet = new JLabel("Street");
			lblStreet.setForeground(new Color(255, 255, 255));
			contentPanel.add(lblStreet, "cell 0 3,alignx trailing");
		}
		{
			textField_3 = new JTextField();
			textField_3.setText(customer.getStreet());

			contentPanel.add(textField_3, "cell 1 3,growx");
			textField_3.setColumns(10);
		}
		{
			JLabel lblCity = new JLabel("City");
			lblCity.setForeground(new Color(255, 255, 255));
			lblCity.setBackground(new Color(51, 102, 153));
			lblCity.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lblCity, "cell 0 4,alignx trailing");
		}
		{
			textField_4 = new JTextField();
			textField_4.setText(customer.getCity());

			contentPanel.add(textField_4, "cell 1 4,growx");
			textField_4.setColumns(10);
		}
		{
			JLabel lblPostalCode = new JLabel("Postal Code");
			lblPostalCode.setForeground(new Color(255, 255, 255));
			lblPostalCode.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lblPostalCode, "cell 0 5,alignx trailing");
		}
		{
			textField_5 = new JTextField();
			textField_5.setText(customer.getPostalCode());
			contentPanel.add(textField_5, "cell 1 5,growx");
			textField_5.setColumns(10);
		}
		{
			JLabel lblPhone = new JLabel("Phone");
			lblPhone.setForeground(new Color(255, 255, 255));
			contentPanel.add(lblPhone, "cell 0 6,alignx trailing");
		}
		{
			textField_6 = new JTextField();
			textField_6.setText(customer.getPhone());
			contentPanel.add(textField_6, "cell 1 6,growx");
			textField_6.setColumns(10);
		}
		{
			JLabel lblEmail = new JLabel("Email");
			lblEmail.setForeground(new Color(255, 255, 255));
			contentPanel.add(lblEmail, "cell 0 7,alignx trailing");
		}
		{
			textField_7 = new JTextField();
			textField_7.setText(customer.getEmailAddress());
			contentPanel.add(textField_7, "cell 1 7,growx");
			textField_7.setColumns(10);
		}
		{
			JLabel lblJoinedDate = new JLabel("Joined Date");
			lblJoinedDate.setForeground(new Color(255, 255, 255));
			contentPanel.add(lblJoinedDate, "cell 0 8,alignx trailing");
		}
		{
			textField_8 = new JTextField();
			textField_8.setText(customer.getJoinDateString());
			contentPanel.add(textField_8, "cell 1 8,growx");
			textField_8.setColumns(10);
		}
	
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(205, 92, 92));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}

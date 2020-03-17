/**
 * Project: A00123456Lab9
 * File: MainFrame.java
 * Date: Nov 7, 2016
 * Time: 12:06:41 PM
 */

package a00123456.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a00123456.Lab9;
import a00123456.data.customer.Customer;
import a00123456.data.customer.CustomerDao;

/**
 * @author Sam Cirka, A00123456
 *
 */
@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private static final Logger LOG = LogManager.getLogger();

	private JPanel contentPane;
	private CustomerDao customerDao;

	/**
	 * Create the frame.
	 */
	public MainFrame(final CustomerDao dao) {
		LOG.debug("Creating the MainFrame");
		customerDao = dao;

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});

		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmCustomer = new JMenuItem("Customer");
		mntmCustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_MASK));
		mntmCustomer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					// get a random customer
					List<Long> ids = customerDao.getCustomerIds();
					if (ids.size() == 0) {
						JOptionPane.showMessageDialog(MainFrame.this, "Zero customers - perhaps there's a problem connecting to the database?",
								"Warning", JOptionPane.WARNING_MESSAGE);
						return;
					}
					Random random = new Random();
					int index = random.nextInt(ids.size());
					Customer customer = customerDao.getCustomer(ids.get(index));
					// show the dialog
					CustomerDialog dialog = new CustomerDialog(MainFrame.this);
					dialog.setCustomer(customer);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		mnFile.add(mntmCustomer);

		JSeparator separator = new JSeparator();
		mnFile.add(separator);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));
		mntmExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		mnFile.add(mntmExit);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mntmAbout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MainFrame.this, "Lab 9\nBy Fred Fish A00123456", "About Lab 9", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	private void exit() {
		Instant endTime = Instant.now();
		LOG.info("End: " + endTime);
		LOG.info(String.format("Duration: %d ms", Duration.between(Lab9.getStartTime(), endTime).toMillis()));
		System.exit(0);
	}

}

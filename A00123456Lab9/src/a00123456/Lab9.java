/**
 * Project: A00123456Lab9
 * File: Lab9.java
 */

package a00123456;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Instant;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import a00123456.data.customer.CustomerDao;
import a00123456.db.Database;
import a00123456.ui.MainFrame;

/**
 * To demonstrate knowledge of Graphical User Interfaces
 * 
 * @author Sam Cirka, A00123456
 *
 */
public class Lab9 {

	private static final Instant startTime = Instant.now();
	private static final String DROP_OPTION = "-drop";
	private static final String LOG4J_CONFIG_FILENAME = "log4j2.xml";
	private Database db;

	static {
		configureLogging();
	}

	private static final Logger LOG = LogManager.getLogger();

	private static void configureLogging() {
		ConfigurationSource source;
		try {
			source = new ConfigurationSource(new FileInputStream(LOG4J_CONFIG_FILENAME));
			Configurator.initialize(null, source);

		} catch (IOException e) {
			System.out.println(String.format("Can't find the log4j logging configuration file %s.", LOG4J_CONFIG_FILENAME));
		}
	}

	/**
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) {
		LOG.info("Start: " + startTime);

		if (args.length == 1 && args[0].equalsIgnoreCase(DROP_OPTION)) {
			Database.requestDbTableDrop();
		}

		Lab9 lab9 = null;
		try {
			lab9 = new Lab9();
			lab9.run();
		} catch (IOException e) {
			e.printStackTrace();
			LOG.error(e.getMessage());
		}

		LOG.debug("main thread exiting");
	}

	/**
	 * Lab9 constructor. Initialized the customers collection.
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public Lab9() throws FileNotFoundException, IOException {
		db = new Database();
	}

	/**
	 * Populate the customers and print them out.
	 */
	private void run() {
		try {
			CustomerDao dao = new CustomerDao(db);
			createUI(dao);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
	}

	/**
	 * @return the startTime
	 */
	public static Instant getStartTime() {
		return startTime;
	}

	public static void createUI(final CustomerDao dao) {
		LOG.debug("Creating the UI");
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					LOG.debug("Setting the Look & Feel");
					for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(info.getName())) {
							UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}

					MainFrame frame = new MainFrame(dao);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					LOG.error(e.getMessage());
				}
			}
		});
	}

}

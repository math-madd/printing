package org.openwms.wms.printing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.print.*;

import org.ameba.app.SolutionApp;
import org.openwms.wms.printing.api.Printer;
import org.openwms.wms.printing.impl.PrintingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(
		scanBasePackageClasses = {
				PrintingApplication.class,
				SolutionApp.class
		})
@EntityScan(basePackageClasses = {Printer.class})
public class PrintingApplication {


//	public int print(Graphics g, PageFormat pf, int page) throws
//			PrinterException {
//
//		if (page > 0) { /* We have only one page, and 'page' is zero-based */
//			return NO_SUCH_PAGE;
//		}
//
//		/* User (0,0) is typically outside the imageable area, so we must
//		 * translate by the X and Y values in the PageFormat to avoid clipping
//		 */
//		Graphics2D g2d = (Graphics2D)g;
//		g2d.translate(pf.getImageableX(), pf.getImageableY());
//
//		/* Now we perform our rendering */
//		g.drawString("Hello world!", 100, 100);
//
//		/* tell the caller that this page is part of the printed document */
//		return PAGE_EXISTS;
//	}
//
//	public void actionPerformed(ActionEvent e) {
//		PrinterJob job = PrinterJob.getPrinterJob();
//		PageFormat format = job.pageDialog(job.defaultPage());
//		job.setPrintable(this);
//		boolean ok = job.printDialog();
//		if (ok) {
//			try {
//				job.print();
//			} catch (PrinterException ex) {
//				/* The job did not successfully complete */
//			}
//		}
//	}


	public static void main(String args[]) {

//		UIManager.put("swing.boldMetal", Boolean.FALSE);
//		JFrame f = new JFrame("Hello World Printer");
//		f.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent e) {System.exit(0);}
//		});
//		JButton printButton = new JButton("Print");
//		printButton.addActionListener(new PrintingApplication());
//		f.add("Center", printButton);
//		f.pack();
//		f.setVisible(true);

		SpringApplication.run(PrintingApplication.class, args);
	}
}

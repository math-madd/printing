package org.openwms.wms.printing.api;

import org.ameba.http.AbstractBase;
import org.aspectj.lang.annotation.Before;
import org.openwms.wms.printing.impl.PrintingService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.print.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.List;


@Component
public class Printer extends AbstractBase implements PrintingService {



    private String pKey;
    private String name;

//    private Map<String, String> details = new HashMap<>();


//    public int print(Graphics g, PageFormat pf, int page) throws
//            PrinterException {
//
//        if (page > 0) { /* We have only one page, and 'page' is zero-based */
//            return NO_SUCH_PAGE;
//        }
//
//        /* User (0,0) is typically outside the imageable area, so we must
//         * translate by the X and Y values in the PageFormat to avoid clipping
//         */
//        Graphics2D g2d = (Graphics2D)g;
//        g2d.translate(pf.getImageableX(), pf.getImageableY());
//
//        /* Now we perform our rendering */
//        g.drawString("Hello world!", 100, 100);
//
//        /* tell the caller that this page is part of the printed document */
//        return PAGE_EXISTS;
//    }


    @Override
    public List<String> findPrinters() {

        PrintService[] printServices = PrinterJob.lookupPrintServices();

        List<String> printers = new ArrayList<>();

        for(PrintService printService : printServices) {
            String name = printService.getName();
            printers.add(name);
        }
       return printers;
    }

    @Override
    public String screenshot() {

        String result;

        try {
            Robot robot = new Robot();
            String format = "jpg";
            String fileName = "FullScreenshot." + format;

            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
            ImageIO.write(screenFullImage, format, new File(fileName));
            System.out.println("A full screenshot saved!");
        } catch (AWTException | IOException ex) {
            System.err.println(ex);
        }
        result = "Complete";
        return result;
    }



//    public void actionPerformed(ActionEvent e) {
//        PrinterJob job = PrinterJob.getPrinterJob();
//        PageFormat format = job.pageDialog(job.defaultPage());
//        job.setPrintable(this);
//        boolean ok = job.printDialog();
//        if (ok) {
//            try {
//                job.print();
//            } catch (PrinterException ex) {
//                /* The job did not successfully complete */
//            }
//        }
//    }
}


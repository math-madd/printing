package org.openwms.wms.printing.api;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import org.ameba.http.AbstractBase;
import org.openwms.wms.printing.impl.PrintingService;
import org.springframework.stereotype.Component;
import javax.imageio.ImageIO;
import javax.print.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;


@Component
public class Printer extends AbstractBase implements PrintingService {


    private String pKey;
    private String name;


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
        result = "Screenshot Captured";
        return result;
    }

    @Override
    public String generateLabel()
    {
            //Data encoded in the barcode
            String data = "This is a barcode";

            //Location where barcode will be stored
            String path = "C:\\openWMS\\Resources\\Data\\Printing\\Barcodes\\test_barcode000.jpg";

            //Format of the barcode
            Code128Writer writer = new Code128Writer();
            BitMatrix matrix = writer.encode(data, BarcodeFormat.CODE_128, 600, 300);

            //Convert barcode to an image
        try {
            MatrixToImageWriter.writeToPath(matrix, "jpg", Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String result = "Barcode created";

        return result;
    }

}


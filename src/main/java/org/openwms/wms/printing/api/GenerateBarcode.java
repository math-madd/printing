package org.openwms.wms.printing.api;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;


public class GenerateBarcode  {

    public static void createBarcode() throws Exception
    {

        try {

            //Data encoded in the barcode
            String data = "This is a barcode";

            //Location where barcode will be stored
            String path = "C:\\openWMS\\Resources\\Data\\Printing\\Barcodes\\test_barcode.jpg";

            //Format of the barcode
            Code128Writer writer = new Code128Writer();
            BitMatrix matrix = writer.encode(data, BarcodeFormat.CODE_128, 600, 300);

            //Convert barcode to an image
            MatrixToImageWriter.writeToPath(matrix, "jpg", Paths.get(path));

            System.out.println("Barcode created");

        } catch(Exception e) {
            System.out.println("Error creating barcode");

        }
    }



}

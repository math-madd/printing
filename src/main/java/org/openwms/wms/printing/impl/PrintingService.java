package org.openwms.wms.printing.impl;

import org.openwms.wms.printing.api.Printer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.util.List;

public interface PrintingService {

    public List<String> findPrinters();

    public String screenshot();

    public String generateLabel();


}

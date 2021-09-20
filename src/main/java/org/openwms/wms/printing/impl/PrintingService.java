package org.openwms.wms.printing.impl;

import java.util.List;

public interface PrintingService {

    public List<String> findPrinters();

    public String screenshot();

    public void generateBarcode();

}

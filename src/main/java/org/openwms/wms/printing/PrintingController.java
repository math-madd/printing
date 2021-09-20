package org.openwms.wms.printing;

import org.ameba.http.MeasuredRestController;
import org.openwms.core.http.AbstractWebController;
import org.openwms.core.http.Index;
import org.openwms.wms.printing.impl.PrintingService;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Validated
@MeasuredRestController
public class PrintingController extends AbstractWebController {

    private final PrintingService service;

    PrintingController(PrintingService service) {
        this.service = service;
    }

    @GetMapping("/v1/printing/index")
    public ResponseEntity<Index> index() throws IOException {
        return ResponseEntity.ok(
                new Index(
                        linkTo(methodOn(PrintingController.class).findPrinters()).withRel("find-all-printers"),
                        linkTo(methodOn(PrintingController.class).screenshot()).withRel("screenshot"),
                        linkTo(methodOn(PrintingController.class).generateBarcode()).withRel("generateBarcode"),
                        linkTo(methodOn(DocumentsController.class).docIndex()).withRel("documents")

                )
                );
    }


    @GetMapping("/v1/printing/findPrinters")
    public List<String> findPrinters() {
        List<String> devices = service.findPrinters();
        return devices;

    }


    @GetMapping("/v1/printing/screenshot")
    public ResponseEntity<String> screenshot() {
        String screenshot = service.screenshot();
        return ResponseEntity.ok(screenshot);

    }


    @GetMapping("/v1/printing/generateLabel")
    public ResponseEntity<Void> generateBarcode() {
        service.generateBarcode();
        return null;

    }



}

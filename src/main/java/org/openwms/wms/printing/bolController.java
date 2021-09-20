package org.openwms.wms.printing;

import org.ameba.http.MeasuredRestController;
import org.openwms.core.http.AbstractWebController;
import org.openwms.core.http.Index;
import org.openwms.wms.printing.impl.DocumentService;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Validated
@MeasuredRestController
public class bolController extends AbstractWebController {

    private final DocumentService service;

    bolController(DocumentService service) {
        this.service = service;
    }

    @GetMapping("/v1/documents/bol")
    public ResponseEntity<Index> bolIndex() throws IOException {
        return ResponseEntity.ok(
                new Index(
                        linkTo(methodOn(bolController.class).generateBOL()).withRel("getBOLTemplate"),
                        linkTo(methodOn(bolController.class).editBOL()).withRel("editBolTemplate"),
                        linkTo(methodOn(bolController.class).editBOL()).withRel("mergeBolTemplate"),
                        linkTo(methodOn(bolController.class).editBOL()).withRel("deleteBolTemplate")

                )
        );
    }


    @GetMapping("v1/documents/getBOLTemplate")
    public ResponseEntity<Void> generateBOL() {
        service.generateBOL();
        return null;
    }


    @GetMapping("v1/documents/editBOLTemplate")
    public ResponseEntity<Void> editBOL() {
        service.editBOL();
        return null;
    }


    @PostMapping("v1/documents/mergeBOLTemplate")
    public ResponseEntity<Void> mergeBOL() {
        service.mergeBOL();
        return null;
    }


    @DeleteMapping("v1/documents/deleteBOLTemplate")
    public ResponseEntity<Void> deleteBOL() {
        service.deleteBOL();
        return null;
    }
}
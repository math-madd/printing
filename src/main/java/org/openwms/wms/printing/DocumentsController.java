package org.openwms.wms.printing;

import org.openwms.core.http.Index;
import org.openwms.wms.printing.api.Printer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController("printingDocumentsController")
public class DocumentsController {

    @GetMapping("/v1/documents/index")
    public ResponseEntity<Index> docIndex() throws IOException {
        return ResponseEntity.ok(
                new Index(
                        linkTo(methodOn(bolController.class).bolIndex()).withRel("bill-of-lading")

                )
        );
    }
}
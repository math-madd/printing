package org.openwms.wms.printing;

import org.openwms.core.http.Index;
import org.openwms.wms.printing.api.Printer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController("printingIndexController")
class IndexController {

    @GetMapping("/index")
    public ResponseEntity<Index> getIndex() {
        return ResponseEntity.ok(
                new Index(
                        linkTo(methodOn(PrintingController.class).index()).withRel("printing-index")
                )
        );
    }
}

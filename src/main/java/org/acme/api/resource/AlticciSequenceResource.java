package org.acme.api.resource;

import org.acme.domain.service.AlticciSequenceService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alticci")
public class AlticciSequenceResource {

    @Autowired
    private AlticciSequenceService alticciSequenceService;

    @GetMapping("/{n}")
    @Operation(summary = "Alticci Sequence", description = "Calculate alticci value from a given index")
    public ResponseEntity<Long> calculateAlticciSequence (@Parameter(description = "Index", example = "1", required = true) @PathVariable("n") Long number) {
        final Long result = alticciSequenceService.sequence(number);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

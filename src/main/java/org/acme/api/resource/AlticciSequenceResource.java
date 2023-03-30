package org.acme.api.resource;

import org.acme.api.exceptionhandler.Error;
import org.acme.domain.exception.ValidationException;
import org.acme.domain.service.AlticciSequenceService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigInteger;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/alticci")
public class AlticciSequenceResource {

    @Autowired
    private AlticciSequenceService alticciSequenceService;

    @Operation(summary = "Alticci Sequence", description = "Calculate alticci value from a given index")
    @APIResponses(
            value = {
                    @APIResponse(
                            responseCode = "200",
                            description = "Exemplo retornado com sucesso",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = BigInteger.class))
                    ),
                    @APIResponse(
                            responseCode = "400",
                            description = "Parâmetro inválido"
                    )
            }
    )
    @GetMapping("/{n}")
    @ResponseStatus(HttpStatus.OK)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response calculateAlticciSequence(
            @Parameter(description = "Alticci Sequence Index", example = "0", required = true) @PathVariable("n") Long number) {

        BigInteger result;

        try {
            result = alticciSequenceService.sequence(number);
        }catch(ValidationException validationException) {
           return Response.status(Response.Status.BAD_REQUEST).
                    entity(new Error(LocalDateTime.now(), validationException.getMessage())).build();
        }

        return Response.status(Response.Status.OK).
                entity(result).build();
    }
}

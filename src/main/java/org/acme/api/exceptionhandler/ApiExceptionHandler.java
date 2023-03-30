package org.acme.api.exceptionhandler;

import org.acme.domain.exception.ValidationException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.time.LocalDateTime;
@Provider
public class ApiExceptionHandler implements ExceptionMapper<ValidationException> {
    @Override
    public Response toResponse(ValidationException exception) {
        return Response.status(Response.Status.BAD_REQUEST).
                entity(new Error(LocalDateTime.now(), exception.getMessage())).build();
    }
}

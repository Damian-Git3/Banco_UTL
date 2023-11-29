package com.dg.banco_utl.rest;

import com.dg.banco_utl.appservice.CuentaAppService;
import com.dg.banco_utl.viewmodel.CuentaViewModel;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author Damian Gamboa
 */
@Path("/cuenta")
public class CuentaREST {
    
    @POST
    @Path("/retiro")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response retiro(CuentaViewModel cuentaVM) {
        
        CuentaAppService cuentaAS = new CuentaAppService();

        return cuentaAS.retiroExterno(cuentaVM);
    }
    
}

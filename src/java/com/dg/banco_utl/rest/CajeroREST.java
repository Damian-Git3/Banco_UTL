package com.dg.banco_utl.rest;

import com.dg.banco_utl.appservice.CajeroAppService;
import com.dg.banco_utl.appservice.CuentaAppService;
import com.dg.banco_utl.cqrs.CajeroCQRS;
import com.dg.banco_utl.cqrs.CuentaCQRS;
import com.dg.banco_utl.dao.CuentaDAO;
import com.dg.banco_utl.modelos.Cuenta;
import com.dg.banco_utl.viewmodel.CuentaViewModel;

import jakarta.validation.OverridesAttribute.List;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import java.util.*;

/**
 *
 * @author Damian Gamboa
 */
@Path("/cajero")
public class CajeroREST {

    CuentaDAO cuentaDAO = new CuentaDAO();
    
    @GET
    @Path("/saludo")
    @Produces(MediaType.TEXT_PLAIN)
    public Response saludo() {
        
        return Response.ok("Hola").build();
    }

    @POST
    @Path("/retiro")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response retiro(CuentaViewModel cuentaVM) {
        
        CajeroAppService cajeroAS = new CajeroAppService();

        return cajeroAS.retirar(cuentaVM);
    }

    @POST
    @Path("/retiroExterno")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response retiroExterno(CuentaViewModel cuentaVM, @QueryParam("banco") String banco) {
        CajeroAppService cajeroAS = new CajeroAppService();
        
        return cajeroAS.retiroExterno(cuentaVM, banco);

    }
    
    
}

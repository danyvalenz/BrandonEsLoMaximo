package com.cedisropa.arquitectura.api;

import com.cedisropa.arquitectura.entities.StructureResponse;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIpruebas {
///api/validarSurtidor/{ip}/{numTerminal}/{numArea}/{numSurtidor}

    @GET("validarSurtidor/{ip}/{numTerminal}/{numArea}/{numSurtidor}")
    Call<StructureResponse<JsonObject>> vaidarSurtidor(
            @Path("ip") String ip,
            @Path("numTerminal") int numTerminal,
            @Path("numArea") int numArea,
            @Path("numSurtidor") int numSurtidor
    );



}

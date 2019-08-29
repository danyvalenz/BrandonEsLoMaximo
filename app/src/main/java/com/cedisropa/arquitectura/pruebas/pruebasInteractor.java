package com.cedisropa.arquitectura.pruebas;

import android.util.Log;

import com.cedisropa.arquitectura.api.APIpruebas;
import com.cedisropa.arquitectura.entities.Data;
import com.cedisropa.arquitectura.entities.StructureResponse;
import com.cedisropa.arquitectura.services.RetrofitClient;
import com.cedisropa.arquitectura.utils.ResourceProvider;
import com.cedisropa.sdk.WebServices;
import com.cedisropa.sdk.WebserviceNotFoundException;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class pruebasInteractor implements pruebasProvider{
    private static final String LOG_TAG = pruebasInteractor.class.getSimpleName();
    private ResourceProvider resourceProvider;
    private APIpruebas pruebasService;
    private pruebasObteiner obteiner;

    public pruebasInteractor(pruebasObteiner obteiner,ResourceProvider resourceProvider){

        this.resourceProvider = resourceProvider;
        this.obteiner = obteiner;

        try{
            pruebasService = RetrofitClient.getService(APIpruebas.class, WebServices.getService(9).getUrl().toString());
        }catch (WebserviceNotFoundException e){
            e.printStackTrace();
        }

    }

    @Override
    public void obtenerNombreSurtidor(String ip, int numTerminal, int numArea, int numSurtidor) {

        Call<StructureResponse<JsonObject>> call =
                pruebasService.vaidarSurtidor(ip, numTerminal, numArea, numSurtidor);
        call.enqueue(new Callback<StructureResponse<JsonObject>>() {
            @Override
            public void onResponse(Call<StructureResponse<JsonObject>> call,
                                   Response<StructureResponse<JsonObject>> response) {

                Data<JsonObject> data = response.body().getData();
                if(data.getStatus() == 1){
                    String nomSurtidor = data.getData().get("nomSurtidor").getAsString();
                    obteiner.responseOobtenerNomSurtidor(nomSurtidor);
                }else{
                    //TODO: avisar que el usuario no se encontró
                }


            }

            @Override
            public void onFailure(Call<StructureResponse<JsonObject>> call, Throwable t) {

                Log.e(LOG_TAG,"Error al validar surtidor",t);

            }
        });

    }
}

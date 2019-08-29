package com.cedisropa.arquitectura.pruebas;

import com.cedisropa.arquitectura.utils.ResourceProvider;
import com.cedisropa.sdk.DatosGenerales;

public class pruebasPresenter implements pruebasViewPresenter,pruebasObteiner{
    private DatosGenerales datosGenerales;
    private ResourceProvider resourceProvider;
    private pruebasProvider provider;
    private pruebasView view;


    public pruebasPresenter(pruebasView view,ResourceProvider resourceProvider){
        this.resourceProvider = resourceProvider;
        this.view = view;
        this.provider = new pruebasInteractor(this,resourceProvider);
    }

    @Override
    public void recibirDatosGenerales(DatosGenerales datosGenerales) {

        this.datosGenerales = datosGenerales;

    }

    @Override
    public void obtenerNombreSurtidor(int numSurtidor) {

        provider.obtenerNombreSurtidor(datosGenerales.getIpBodega(),datosGenerales.getNumTerminal(),datosGenerales.getNumArea(),numSurtidor);

    }

    @Override
    public void responseOobtenerNomSurtidor(String nomSurtidor) {

        view.mostrarNomsurtidor(nomSurtidor);

    }
}

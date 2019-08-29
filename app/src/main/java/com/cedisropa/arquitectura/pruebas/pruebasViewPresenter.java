package com.cedisropa.arquitectura.pruebas;

import com.cedisropa.sdk.DatosGenerales;

public interface pruebasViewPresenter {

    void recibirDatosGenerales(DatosGenerales datosGenerales);
    void obtenerNombreSurtidor(int numSurtidor);
}

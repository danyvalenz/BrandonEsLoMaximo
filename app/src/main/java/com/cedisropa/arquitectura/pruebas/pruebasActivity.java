package com.cedisropa.arquitectura.pruebas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.cedisropa.arquitectura.R;
import com.cedisropa.arquitectura.utils.ResourceProvider;
import com.cedisropa.sdk.DatosGenerales;

import butterknife.BindView;
import butterknife.ButterKnife;

public class pruebasActivity extends AppCompatActivity implements pruebasView {


    @BindView(R.id.txt_num_surtidor)
    EditText txtNumSurtidor;
    @BindView(R.id.lbl_nom_surtidor)
    TextView lblNomSurtidor;

    private pruebasViewPresenter viewPresenter;
    //private pruebasView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pruebas);
        ButterKnife.bind(this);


        ResourceProvider resourceProvider = new ResourceProvider(this.getResources());
        this.viewPresenter = new pruebasPresenter(this,resourceProvider);

        DatosGenerales datosGenerales = new DatosGenerales();
        datosGenerales.setIpBodega("10.28.114.110");
        datosGenerales.setNumTerminal(1286);
        datosGenerales.setNumArea(1);

        viewPresenter.recibirDatosGenerales(datosGenerales);



        txtNumSurtidor.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {

                if(keyCode == KeyEvent.KEYCODE_ENTER && txtNumSurtidor.length()>0){
                    int numSurtidor = Integer.valueOf(txtNumSurtidor.getText().toString());
                    viewPresenter.obtenerNombreSurtidor(numSurtidor);

                }
                return false;
            }
        });
    }

    @Override
    public void mostrarNomsurtidor(String nomSurtidor) {
        lblNomSurtidor.setText(nomSurtidor);


    }
}

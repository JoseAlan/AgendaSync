package br.com.alura.agenda.services;

import android.preference.PreferenceActivity;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Alan on 09/03/2018.
 */

public interface DispositivoService {

        @POST("firebase/dispositivo")
        Call<Void> enviaToken(@Header("token") String token);
}

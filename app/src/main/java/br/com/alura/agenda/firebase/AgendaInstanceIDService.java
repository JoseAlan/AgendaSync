package br.com.alura.agenda.firebase;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import br.com.alura.agenda.retrofit.RetrofitInicializador;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Alan on 09/03/2018.
 */

public class AgendaInstanceIDService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("Token Firebase", "Refreshed token: " + refreshedToken);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        enviaTokenParaServidor(refreshedToken);
    }
//dzSa5ZFyYBQ:APA91bEJnf7kGlWXN_YtYbDpNtkpeOcvYUhbRnFS-FqFt_Wto-6fTD0_xd6lnT2u-T2Uzrm4VIiM9ZpOsIP0DLjoX2izWjUhZimIP2wFU6GUlG-jnyjZKFZEQcbj6Jmx4Qpe6u2IfyO2
    private void enviaTokenParaServidor(final String refreshedToken) {

        Call<Void> call = new RetrofitInicializador().getDispositivoService().enviaToken(refreshedToken);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.i("token enviado", refreshedToken);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.e("token falhou", t.getMessage() );
            }
        });
    }
}

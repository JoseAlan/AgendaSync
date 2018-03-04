package br.com.alura.agenda.retrofit;

import br.com.alura.agenda.services.AlunoService;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by Alan on 03/03/2018.
 */

public class RetrofitInicializador {

    private final Retrofit retrofit;

    public RetrofitInicializador() {
        retrofit = new Retrofit.Builder().baseUrl("http://192.168.1.9:8080/api/")
                .addConverterFactory(JacksonConverterFactory.create()).build();
    }

    public AlunoService getAlunoServece() {
        return retrofit.create(AlunoService.class);
    }
}

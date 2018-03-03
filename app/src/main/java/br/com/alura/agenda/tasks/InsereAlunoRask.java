package br.com.alura.agenda.tasks;

import android.os.AsyncTask;

import br.com.alura.agenda.converter.AlunoConverter;
import br.com.alura.agenda.modelo.Aluno;
import br.com.alura.agenda.web.WebClient;

/**
 * Created by Alan on 02/03/2018.
 */

public class InsereAlunoRask extends AsyncTask {
    private final Aluno aluno;

    public InsereAlunoRask(Aluno aluno) {
        this.aluno =aluno;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        String json = new AlunoConverter().converteParaJSONCompleto(aluno);

        new WebClient().insere(json);

        return null;
    }
}

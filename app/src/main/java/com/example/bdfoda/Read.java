package com.example.bdfoda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;

public class Read extends AppCompatActivity {


    //perfil

    String login = "jefferson9312@gmail.com";
    String senha = "12345678";
    String nome = "maonaparede";
    String telefone = "41 4002-8922";
    String cidade = "Pinhais";
    String caminhoFoto = "img/usuario/jefferson9312@gmail.com/perfil";
    String descricao = "Curto Gintama e Basket";


//encontro

//YYYY-MM-DD
//default 0 = privado

    String dono = "jefferson9312@gmail.com";
    String data = "2019-12-24";
    String Caminhofoto = "img/encontros/Natal";
    String nomeE = "Natal";
    String descricaoE = "Bora comemorar o Natal";
    String local = "Minha Casa";
    String publico = "0";

//add adm

    String donoE = "jefferson9312@gmail.com";
    String membro = "jefferson9312@gmail.com";
    String id_encontro = "1";

//add membro

    String membroE = "joao9312@gmail.com";
    String id_encontroE = "1";

    String dono1 = "jefferson9312@gmail.com";
    String membro1 = "joaoa9312@gmail.com";
    String id_encontro1 = "1";



//msg usuario usuario

    String login1 = "jefferson9312@gmail.com";
    String amigo1 = "joao9312@gmail.com";
    String mensagem1 ="Salve Mano";


//msg usuario encontro

    String membro2 = "joao9312@gmail.com";
    String id_encontro2 = "1";
    String mensagem3 ="Salve parça";

    String afinidade = "Gintama";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
    }


    public void confereLogin(View v) throws IOException, JSONException {

        JSONArray verificarLogin = BDHelper.verificarLogin(login,senha);

    }

    public void pegarPerfil(View v) throws IOException, JSONException {

        JSONArray pegarPerfil = BDHelper.readPerfil(login);

    }

    public void pegarAmigos(View v) throws IOException, JSONException {

        JSONArray pegarAmigos = BDHelper.readAmigo(login);

    }

    public void pegarAfinidade(View v) throws IOException, JSONException {

        JSONArray pegarAfinidade = BDHelper.readAfinidade(login);

    }

    public void pegarMSG(View v) throws IOException, JSONException {

        JSONArray pegarMSG = BDHelper.readMensagemUsuario(login,amigo1);

    }
}

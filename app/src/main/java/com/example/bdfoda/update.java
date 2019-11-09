package com.example.bdfoda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ServiceConnection;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

public class update extends AppCompatActivity {


    //perfil

    String login = "jefferson9312@gmail.com";
    String senha = "12345678";
    String nome = "maonaparededad";
    String telefone = "41 400aaaa2";
    String cidade = "Pinhaisadasd";
    String caminhoFoto = "img/usuario/jefferson9312@gmail.com/perfil";
    String descricao = "Curto Basket";


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
        setContentView(R.layout.activity_update);
    }


    public void updatePerfil(View v) throws IOException {
        int resposta = BDHelper.updatePerfil(login, senha, "vaitomanovu", telefone, cidade, descricao);
        resposta(resposta);
    }

    public void resposta(int resposta){
        if (resposta == 1) {
            Toast.makeText(this, "Update realizado com sucesso!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Erro! Update não realizado!", Toast.LENGTH_LONG).show();
        }
    }
}

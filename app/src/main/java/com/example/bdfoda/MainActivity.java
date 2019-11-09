package com.example.bdfoda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_main);
    }


    public void insertPerfil(View v)throws IOException {
        int resposta = BDHelper.insertPerfil(login, senha, nome, telefone, cidade, descricao);
        resposta(resposta);
    }

    public void deletePerfil(View v)throws IOException{
        int resposta = BDHelper.deletePerfil(login,senha);
        resposta(resposta);
    }

    public void insertAmigo(View v)throws IOException{
        int resposta = BDHelper.insertAmigo(login,amigo1);
        resposta(resposta);
    }

    public void deleteAmigo(View v)throws IOException{
        int resposta = BDHelper.deleteAmigo(login,amigo1);
        resposta(resposta);
    }

    public void insertAfinidade(View v)throws IOException{
        int resposta = BDHelper.insertAfinidade(login,afinidade);
        resposta(resposta);
    }

    public void deleteAfinidade(View v)throws IOException{
        int resposta = BDHelper.deleteAfinidade(login,afinidade);
        resposta(resposta);
    }

    public void insertMsgUsuario(View v)throws IOException{
        int resposta = BDHelper.insertMensagemUsuario(login,amigo1,mensagem3);
        resposta(resposta);
    }



    public void resposta(int resposta){
        if (resposta == 1) {
            Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Erro! Cadastro não realizado!", Toast.LENGTH_LONG).show();
        }
    }

    public void telaRead(View v){
        Intent intent = new Intent(this, Read.class);
        startActivity(intent);
    }

    public void telaUpdate(View v){
        Intent intent = new Intent(this, update.class);
        startActivity(intent);
    }
}

package com.example.bdfoda;

import android.os.Build;
import android.os.StrictMode;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BDHelper {

    private static String WEB_SERVICE_URL = "http://192.168.1.105:80";

    private static String inserir = "/Rede_Social/ws_insert";
    private static String deletar = "/Rede_Social/ws_remove";
    private static String ler = "/Rede_Social/ws_read";
    private static String update = "/Rede_Social/ws_update";

    private static void checkThreadPolicy() {
        int SDK_VERSION = Build.VERSION.SDK_INT;
        if (SDK_VERSION > 8) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }



// ------------------------------------------ PERFIL ----------------------------------------------------//

    public static int insertPerfil(String login,String senha,String nome,String telefone,
                                   String cidade,String descricao)throws IOException {
        checkThreadPolicy();
        String values = "&login="+login+"&senha="+senha+"&nome="+nome+"&telefone="
                +telefone+"&cidade="+cidade+"&descricao="+descricao;
        URL url = new URL(WEB_SERVICE_URL + inserir + "/insert_perfil/insert_login.php?"+values);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        String resposta = br.readLine();
        if (resposta.equals("true")) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int deletePerfil(String login,String senha)throws IOException {
        checkThreadPolicy();
        String values = "&login="+login+"&senha="+senha;
        URL url = new URL(WEB_SERVICE_URL + deletar + "/delete_perfil/delete_perfil.php?"+values);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        String resposta = br.readLine();
        if (resposta.equals("true")) {
            return 1;
        } else {
            return 0;
        }
    }


    public static void sairPerfil(){
        //apagar a variavel do SQLite e "matar" o app (mandar pra tela de login)
    }


    public static int insertAmigo(String login,String amigo)throws IOException {
        checkThreadPolicy();
        String values = "&login="+login+"&amigo="+amigo;
        URL url = new URL(WEB_SERVICE_URL + inserir + "/insert_perfil/insert_amigo.php?"+values);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        String resposta = br.readLine();
        if (resposta.equals("true")) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int deleteAmigo(String login,String amigo)throws IOException {
        checkThreadPolicy();
        String values = "&login="+login+"&amigo="+amigo;
        URL url = new URL(WEB_SERVICE_URL + deletar + "/delete_perfil/delete_amigo.php?"+values);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        String resposta = br.readLine();
        if (resposta.equals("true")) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int insertAfinidade(String login,String afinidade)throws IOException {
        checkThreadPolicy();
        String values = "&login="+login+"&afinidade="+afinidade;
        URL url = new URL(WEB_SERVICE_URL + inserir + "/insert_perfil/insert_afinidade.php?"+values);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        String resposta = br.readLine();
        if (resposta.equals("true")) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int deleteAfinidade(String login,String afinidade)throws IOException {
        checkThreadPolicy();
        String values = "&login="+login+"&afinidade="+afinidade;
        URL url = new URL(WEB_SERVICE_URL + deletar + "/delete_perfil/delete_afinidade.php?"+values);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        String resposta = br.readLine();
        if (resposta.equals("true")) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int insertMensagemUsuario(String login1,String amigo,String mensagem)throws IOException {
        checkThreadPolicy();
        String values = "&login="+login1+"&amigo="+amigo+"&mensagem="+mensagem;
        URL url = new URL(WEB_SERVICE_URL + inserir +"/insert_mensagem_usuario/insert_mensagemUsuario.php?"+values);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        String resposta = br.readLine();
        if (resposta.equals("true")) {
            return 1;
        } else {
            return 0;
        }
    }

    //---------------------------read----------------//

    public static JSONArray verificarLogin(String login,String senha)throws IOException, JSONException{
        checkThreadPolicy();
        String values = "&login="+login+"&senha="+senha;
        URL url = new URL(WEB_SERVICE_URL + ler + "/read_perfil/read_login.php?"+values);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String linha;
        while ((linha = br.readLine()) != null) {
            sb.append(linha);
        }
        JSONArray jsonArray = new JSONArray(sb.toString().trim());
        return jsonArray;
    }

    public static JSONArray readPerfil(String login)throws IOException, JSONException{
        checkThreadPolicy();
        String values = "&login="+login;
        URL url = new URL(WEB_SERVICE_URL + ler + "/read_perfil/read_perfil.php?"+values);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String linha;
        while ((linha = br.readLine()) != null) {
            sb.append(linha);
        }
        JSONArray jsonArray = new JSONArray(sb.toString().trim());
        return jsonArray;
    }

    public static JSONArray readAmigo(String login)throws IOException, JSONException{
        checkThreadPolicy();
        String values = "&login="+login;
        URL url = new URL(WEB_SERVICE_URL + ler + "/read_perfil/read_amigos.php?"+values);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String linha;
        while ((linha = br.readLine()) != null) {
            sb.append(linha);
        }
        JSONArray jsonArray = new JSONArray(sb.toString().trim());
        return jsonArray;
    }


    public static JSONArray readAfinidade(String login)throws IOException, JSONException{
        checkThreadPolicy();
        String values = "&login="+login;
        URL url = new URL(WEB_SERVICE_URL + ler + "/read_perfil/read_afinidades.php?"+values);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String linha;
        while ((linha = br.readLine()) != null) {
            sb.append(linha);
        }
        JSONArray jsonArray = new JSONArray(sb.toString().trim());
        return jsonArray;
    }



    public static JSONArray readMensagemUsuario(String login,String amigo) throws IOException, JSONException {
        checkThreadPolicy();
        String values = "&login="+login+"&amigo="+amigo;
        URL url = new URL(WEB_SERVICE_URL + "/read_mensagem_usuario/read_mensagemUsuario.php");
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String linha;
        while ((linha = br.readLine()) != null) {
            sb.append(linha);
        }
        JSONArray jsonArray = new JSONArray(sb.toString().trim());
        return jsonArray;
    }

    //------------------Update---------//

    public static int updatePerfil(String login,String senha,String nome,String telefone,
                                   String cidade,String descricao)throws IOException {
        checkThreadPolicy();
        String values = "&login="+login+"&senha="+senha+"&nome="+nome+"&telefone="
                +telefone+"&cidade="+cidade+"&descricao="+descricao;
        URL url = new URL(WEB_SERVICE_URL + update + "/update_perfil/update_perfil.php?"+values);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        String resposta = br.readLine();
        if (resposta.equals("true")) {
            return 1;
        } else {
            return 0;
        }
    }
}

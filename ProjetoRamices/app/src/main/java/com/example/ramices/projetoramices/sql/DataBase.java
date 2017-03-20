package com.example.ramices.projetoramices.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ramices.projetoramices.base.Museu;
import com.example.ramices.projetoramices.base.Teatro;

import java.util.ArrayList;

/**
 * Created by Ramices on 15/03/2017.
 */

public class DataBase {

    private static DataBase instance = null;
    private DbOpenHelper open;
    private SQLiteDatabase database;


    public static DataBase getInstance(Context context)
    {
        if(instance == null)
            instance = new DataBase(context);

            return instance;
    }

    public DataBase(Context context)
    {
        open = new DbOpenHelper(context);
       createTeatros();
       createMuseus();

    }


    private void createMuseus()
    {
        ArrayList<Museu> data = povoarMuseu();

        database = open.getWritableDatabase();

        for(int i = 0; i < data.size(); ++i)
        {
            ContentValues values = new ContentValues();

            values.put(MuseuContract.NOME, data.get(i).getNome());
            values.put(MuseuContract.DESCRICAO, data.get(i).getDescricao());
            values.put(MuseuContract.BAIRRO, data.get(i).getBairro());
            values.put(MuseuContract.LOGRADOURO, data.get(i).getLogradouro());
            values.put(MuseuContract.TELEFONE, data.get(i).getTelefone());
            values.put(MuseuContract.LATITUDE, data.get(i).getLatitude());
            values.put(MuseuContract.LONGITUDE, data.get(i).getLongitude());
            values.put(MuseuContract.SITE, data.get(i).getSite());
            database.insert(MuseuContract.TABLE_NAME, null, values);
        }

        database.close();
    }

    private void createTeatros()
    {
        ArrayList<Teatro> data = povoarTeatros();



        database = open.getWritableDatabase();

        for(int i = 0; i < data.size(); ++i)
        {
            ContentValues values = new ContentValues();

            values.put(TeatroContract.NOME, data.get(i).getNome());
            values.put(TeatroContract.DESCRICAO, data.get(i).getDescricao());
            values.put(TeatroContract.BAIRRO, data.get(i).getBairro());
            values.put(TeatroContract.LOGRADOURO, data.get(i).getLogradouro());
            values.put(TeatroContract.TELEFONE, data.get(i).getTelefone());
            values.put(TeatroContract.LATITUDE, data.get(i).getLatitude());
            values.put(TeatroContract.LONGITUDE, data.get(i).getLongitude());
            database.insert(TeatroContract.TABLE_NAME, null, values);
        }

        database.close();
    }


    public ArrayList<Teatro> getTeatros()
    {
        database = open.getReadableDatabase();

        Cursor cursor = database.rawQuery("select * from "+ TeatroContract.TABLE_NAME  , null);
        ArrayList<Teatro> teatros = new ArrayList<Teatro>();


        while (cursor.moveToNext())
        {
            Teatro teatro = new Teatro();

            teatro.setNome(cursor.getString(1));
            teatro.setDescricao(cursor.getString(2));
            teatro.setBairro(cursor.getString(3));
            teatro.setLogradouro(cursor.getString(4));
            teatro.setTelefone(cursor.getString(5));
            teatro.setLatitude(cursor.getDouble(6));
            teatro.setLongitude(cursor.getDouble(7));

            if(!(teatros.contains(teatro)))
            teatros.add(teatro);


        }

        return  teatros;
    }


    public ArrayList<Museu> getMuseus()
    {
        database = open.getReadableDatabase();

        Cursor cursor = database.rawQuery("select * from "+ MuseuContract.TABLE_NAME, null);
        ArrayList<Museu> museus = new ArrayList<Museu>();

        while (cursor.moveToNext())
        {
            Museu museu = new Museu();

            museu.setNome(cursor.getString(1));
            museu.setDescricao(cursor.getString(2));
            museu.setBairro(cursor.getString(3));
            museu.setLogradouro(cursor.getString(4));
            museu.setTelefone(cursor.getString(5));
            museu.setLatitude(cursor.getDouble(6));
            museu.setLongitude(cursor.getDouble(7));
            museu.setSite(cursor.getString(8));

            if(!(museus.contains(museu)))
            museus.add(museu);


        }

        return  museus;
    }


    public  ArrayList<Museu> povoarMuseu()
    {
        ArrayList<Museu> data = new ArrayList<Museu>();
        Museu museu = new Museu();

        museu.setNome("Museu do Homem do Nordeste");
        museu.setDescricao("Sao cerca de 15 mil pecas no acervo retratando a formacaoo do povo nordestino considerado um dos mais importantes museus antropologicos brasileiros.");
        museu.setBairro("Casa Forte");
        museu.setLogradouro("Av. Dezessete de Agosto 2187");
        museu.setTelefone("(81) 3073-6340");
        museu.setLatitude(-8.030196);
        museu.setLongitude(-34.925281);
        museu.setSite("http://www.fundaj.gov.br/");

        data.add(museu);
        museu = new Museu();

        museu.setNome("Museu Murilo La Greca");
        museu.setDescricao("Os amantes da arte contemporanea conhecerao o acervo de 14 mil desenhos de Murilo La Greca em tecnicas diversas. No local tambem sao  guardadas 160 pinturas e cartas trocadas pelo artista com Portinari e Giacometti.");
        museu.setBairro("Parnamirim");
        museu.setLogradouro("R. Leonardo Bezerra Cavalcante 366");
        museu.setTelefone("(81)3355-3126");
        museu.setLatitude(-8.037325);
        museu.setLongitude(-34.909832);
        museu.setSite("http://museumurillolagreca.com.br/");

        data.add(museu);
        museu = new Museu();

        museu.setNome("Museu da Cidade do Recife");
        museu.setDescricao("Fica dentro do Forte das Cinco Pontas, e uma construcao holandesa de 1630. No local o visitante pode desfrutar de um extenso acervo de documentos iconograficos sobre o Recife alem de 150 mil imagens de antigas residencias pagas religiosas.");
        museu.setBairro("Sao  Joao");
        museu.setLogradouro("Praca das cinco pontas");
        museu.setTelefone("(81)-33552812");
        museu.setLatitude(-8.071313);
        museu.setLongitude(-34.880809);
        museu.setSite("http://www.recife.pe.gov.br/cultura/museucidade.php");

        data.add(museu);
        museu = new Museu();

        museu.setNome("Museu Militar");
        museu.setDescricao("Localizada no Forte do Brum no Bairro do Recife. O forte foi construido no seculo XVI para seguranca e protecao das povoacoes  do Recife alem de ter sido cenario de inumeros acontecimentos historicos. ");
        museu.setBairro("Recife");
        museu.setLogradouro("Av. Militar ");
        museu.setTelefone("((81) 3224-4620");
        museu.setLatitude(-8.052803);
        museu.setLongitude(-34.871412);
        museu.setSite("-");

        data.add(museu);
        museu = new Museu();

        museu.setNome("Museu de Arte Moderna Aloisio Magalhaes");
        museu.setDescricao("Integra o circuito de museus de arte moderna do Brasil e tem seu forte nas exposicoes temporarias.");
        museu.setBairro("Boa Vista");
        museu.setLogradouro("Rua da Aurora 265");
        museu.setTelefone("(81) 3355-6870");
        museu.setLatitude(-8.061285);
        museu.setLongitude(-34.881394);
        museu.setSite("http://www.mamam.art.br/");

        data.add(museu);
        museu = new Museu();


        museu.setNome("Museu Franciscano de Arte Sacra");
        museu.setDescricao("Localizada no bairro de Santo Antonio os visitantes podem observar valiosas pecas do catolicismo no Recife e desfrutar da beleza da Capela Dourada datada de 1696 um dos melhores exemplos da arte sacra e do estilo barroco brasileiro.");
        museu.setBairro("Santo Antonio");
        museu.setLogradouro("R. Imperador Dom Pedro II 57");
        museu.setTelefone("(81) 3224-0530");
        museu.setLatitude(-8.062427);
        museu.setLongitude(-34.877231);
        museu.setSite("http://www.capeladourada.com.br/noticias/museu-franciscano-de-arte-sacra");

        data.add(museu);
        museu = new Museu();

        museu.setNome("Casa-Museu Magdalena e Gilberto Freyre");
        museu.setDescricao("No bairro de Apipucos onde o escritor viveu por mais de 40 anos totalmente conservada com objetos moveis e livros exatamente na mesma posicao como eram no tempo de Gilberto Freyre.");
        museu.setBairro("Apipucos");
        museu.setLogradouro("Rua Jorge Tasso Neto");
        museu.setTelefone("(81) 3441-2883");
        museu.setLatitude(-8.020598);
        museu.setLongitude(-34.938482);
        museu.setSite("http://www.fgf.org.br/index.html");

        data.add(museu);
        museu = new Museu();

        museu.setNome("Oficina Brennand");
        museu.setDescricao("Na Varzea reunindo as obras do artista plastico Francisco Brennand conhecido em varias partes do mundo e considerado um dos expoentes das artes plasticas contemporaneas. O espaco abriga mais de 2 mil esculturas alem de paineis murais quadros e desenhos do artista. Outros dois pontos para conferir suas obras sao no Parque das Esculturas de Francisco Brennand no molhe do Porto do Recife e o Patioo das Esculturas do Shopping Recife que reune pecas de varios artistas consagrados.");
        museu.setBairro("Varzea");
        museu.setLogradouro("Propriedade Santos Cosme e Damiao");
        museu.setTelefone("(81)3271-2466");
        museu.setLatitude(-8.052569);
        museu.setLongitude(-34.974795);
        museu.setSite("http://www.brennand.com.br");

        data.add(museu);
        museu = new Museu();

        museu.setNome("Instituto Ricardo Brennand (IRB)");
        museu.setDescricao("Localizado na Varrzea e um castelo medieval que guarda uma fabulosa colecaoo de armas brancas, telas do Brasil Colonial obras de arte de diversas epocas e procedencias e a maior colcao privada do pintor holandes Frans Post.  Destaque para a escultura de Botero e uma replica de O pensador de Rodin.");
        museu.setBairro("Varzea");
        museu.setLogradouro("Alameda Antonio Brennand ");
        museu.setTelefone("(81)2121-0352/2121-0365");
        museu.setLatitude(-8.065768);
        museu.setLongitude(-34.964301);
        museu.setSite("http://www.institutoricardobrennand.org.br/");

        data.add(museu);
        museu = new Museu();

        museu.setNome("Museu da Abolicao");
        museu.setDescricao("No bairro da Madalena o museu discute temas sobre escravidao e abolicao visando preservar a memoria do povo negro e a influencia na formacao da cultura brasileira. Possui sala memorial miniauditorio e sala para exposicao temporarias.");
        museu.setBairro("Madalena");
        museu.setLogradouro("R. Benfica 1150");
        museu.setTelefone("(81) 3228-3248 ");
        museu.setLatitude(-8.0571555);
        museu.setLongitude(-34.9090307);
        museu.setSite("http://museudaabolicao.museus.gov.br/");

        data.add(museu);
        museu = new Museu();



        return data;
    }



    private  ArrayList<Teatro> povoarTeatros()
    {
        ArrayList<Teatro> data = new ArrayList<Teatro>();

        Teatro teatro = new Teatro();
        teatro.setNome("Teatro do Parque");
        teatro.setDescricao("Completado 100 anos em 2015 o teatro se encontra fechado para obras desde 2014 com previsao para voltar a funcionar em Novembro de 2016.");
        teatro.setBairro("Boa vista");
        teatro.setLogradouro("Rua do Hospicio");
        teatro.setTelefone("(81)33551553");
        teatro.setLatitude(-8.06198);
        teatro.setLongitude(-34.8847);

        data.add(teatro);

        teatro = new Teatro();

        teatro.setNome("Teatro Barreto Junior");
        teatro.setDescricao("Primeiro teatro da zona sul da cidade local onde funcionava o Cine Atlântico recebe espetaculos internacionais e festivais de danca locais.");
        teatro.setBairro("Pina");
        teatro.setLogradouro("Rua Estudante Jeremias Bastos");
        teatro.setTelefone("(81)33556398  / 33556399");
        teatro.setLatitude(-8.09058);
        teatro.setLongitude(-34.8841);

        data.add(teatro);

        teatro = new Teatro();

        teatro.setNome("Teatro de Santa Isabel");
        teatro.setDescricao("Primeiro e mais expressivo exemplar de arquitetura neoclassica em Pernambuco idealizado por Francisco do Rego Barros atualmente proporciona visitas guiadas e concertos da Orquestra Sinfonica do Recife alem de espetaculos com tematicas variadas.");
        teatro.setBairro("Santo Antonio");
        teatro.setLogradouro("Praca da Republica");
        teatro.setTelefone("(81)3355.3323 /  33553324");
        teatro.setLatitude(-8.06069);
        teatro.setLongitude(-34.8781);

        data.add(teatro);

        teatro = new Teatro();

        teatro.setNome("Teatro Apolo");
        teatro.setDescricao("Com fachada em marmore de Lisboa o teatro integra o Centro de Formacoes e Pesquisas das Artes Cenicas ApoloHermilo. Estilo Neoclassico");
        teatro.setBairro("Santo Antonio");
        teatro.setLogradouro("Rua do Apolo 121");
        teatro.setTelefone("(81) 33553320 / 33553321");
        teatro.setLatitude(-8.06144);
        teatro.setLongitude(-34.8725);

        data.add(teatro);

        teatro = new Teatro();

        teatro.setNome("Teatro Hermilo Borba Filho");
        teatro.setDescricao("A partir da adaptacao de dois armazens que ficavam nos fundos do Teatro Apolo surge o teatro Hermilo Borba Filho com espaco de configuracao flexivel permitindo ajustes de suas arquibancadas em funcao do espetaculo. Possui programacao com precos populares.");
        teatro.setBairro("Recife");
        teatro.setLogradouro("Cais do Apolo");
        teatro.setTelefone("(81) 33553320 / 33553321");
        teatro.setLatitude(-8.06183);
        teatro.setLongitude(-34.8728);

        data.add(teatro);

        teatro = new Teatro();

        teatro.setNome("Teatro Luiz Mendonca");
        teatro.setDescricao("Instalado no Parque Dona Lindu bairro de Boa Viagem o teatro e um dos mais recentes da capital pernambucana e possui um sistema flexivel, possibilitando funcionamento tanto para a area interna quanto para a esplanada em casos de apresentacoes ao ar livre.");
        teatro.setBairro("Boa Viagem");
        teatro.setLogradouro("Avenida Boa Viagem");
        teatro.setTelefone("(81) 33559821 / 33559823");
        teatro.setLatitude(-8.14196);
        teatro.setLongitude(-34.9037);

        data.add(teatro);

        teatro = new Teatro();

        teatro.setNome("Teatro Boa Vista");
        teatro.setDescricao("Criado em 2010 nas dependencias do Colegio Salesiano o Teatro Boa Vista dispoe de 800 lugares para o publico e recebe festivais de danca e pecas infantis nacionais.");
        teatro.setBairro("Boa Vista");
        teatro.setLogradouro("R. Dom Basco 551");
        teatro.setTelefone("(81) 21295961");
        teatro.setLatitude(-8.06058);
        teatro.setLongitude(-34.8936);

        data.add(teatro);

        teatro = new Teatro();

        teatro.setNome("Teatro Arraial");
        teatro.setDescricao("Localizado na Rua da Aurora O Teatro Arraial Ariano Suassuna e um equipamento de pequeno porte com apenas 94 poltronas e dois camarins. Em seu acervo o espaco conta com 150 fonogramas para utilizacao nos espetaculos e possui programacoes variada destinada a um publico de todas as idades.");
        teatro.setBairro("Boa Vista");
        teatro.setLogradouro("R. da Aurora 45");
        teatro.setTelefone("(81) 31843057");
        teatro.setLatitude(-8.05994);
        teatro.setLongitude(-34.8803);

        data.add(teatro);

        teatro = new Teatro();


        teatro.setNome("Teatro Valdemar Oliveira");
        teatro.setDescricao("No bairro da Soledade o Teatro Valdemar Oliveira e um espaco moderno de meio porte muito utilizado para pecas infantis.");
        teatro.setBairro("Soledade");
        teatro.setLogradouro("Praca Osvaldo Cruz 412");
        teatro.setTelefone("(81) 32221200 / 32221284");
        teatro.setLatitude(-8.05529);
        teatro.setLongitude(-34.8915);

        data.add(teatro);

        teatro = new Teatro();

        teatro.setNome("Teatro Alfredo de Oliveira");
        teatro.setDescricao("Localizado na Praca Osvaldo Cruz o espaco de artes cenicas possui programacoes variada visando todos os publicos");
        teatro.setBairro("Soledade");
        teatro.setLogradouro("Praca Osvaldo Cruz 412A");
        teatro.setTelefone("(81)32221284");
        teatro.setLatitude(-8.05562);
        teatro.setLongitude(-34.8918);

        data.add(teatro);

        teatro = new Teatro();


        teatro.setNome("Teatro Marco Camarotti");
        teatro.setDescricao("Pertencente ao Sesc Santo Amaro o Teatro Marco Camarotti e ativo e possui programacoes variada contemplando publicos de todas as idades.");
        teatro.setBairro("Santo Amaro");
        teatro.setLogradouro(" R. Treze de Maio 455 ");
        teatro.setTelefone("(81) 32161728");
        teatro.setLatitude(-8.0496);
        teatro.setLongitude(-34.8819);

        data.add(teatro);

        teatro = new Teatro();

        teatro.setNome("Teatro Joaquim Cardozo");
        teatro.setDescricao("No Casarao do Centro Cultural Benfica bairro da Madalena o teatro possui apenas 50 lugares com o intuito de oferecer um contato maior entre artista e publico.");
        teatro.setBairro("Madalena");
        teatro.setLogradouro(" R. Benfica 157");
        teatro.setTelefone("(81) 21267388");
        teatro.setLatitude(-8.06007);
        teatro.setLongitude(-34.9017);

        data.add(teatro);

        teatro = new Teatro();

        teatro.setNome("Teatro Rio Mar");
        teatro.setDescricao("Pertencente ao Shopping Rio Mar o teatro possui capacidade para 696 espectadores e conta com equipamentos e sistemas de audio e iluminacao de alta qualidade. E acessivel para cadeirantes e pessoas com dificuldade de locomocao.");
        teatro.setBairro("Pina");
        teatro.setLogradouro("Av. Republica do Libano 251");
        teatro.setTelefone("-");
        teatro.setLatitude(-8.08612);
        teatro.setLongitude(-34.8948);

        data.add(teatro);

        return data;

    }




}

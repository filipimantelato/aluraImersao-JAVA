import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception { 
        //inicializando a conexao HTTP com a api para implementar os top 250 filmes.
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json"; //main url for search.
        URI adress = URI.create(url);  //URI é uma forma de usar o url completo.
        HttpClient client = HttpClient.newHttpClient(); //criando um httpClient que foi colocado em umna variavel.
        HttpRequest request = HttpRequest.newBuilder(adress).GET().build(); //criando um httpRequest, sendo seu builder o proprio URI.
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString()); //por meio do client, mandamos a informacao do request, para ler "BodyHandles" a documentacao em String(ofString).
        String body = response.body(); //response é dado como "body", e nesse caso estamos jogando o body em uma String para imprimir.

        //extrair apenas dados necessarios(titulo, poster, classificacao).
        var parser = new jsonParser();
        List<Map<String,String>> filmsList = parser.parse(body);
        //System.out.println(filmsList.size()); nos fornece o tamanho da filmslist, nessa caso é 10.
        //System.out.println(filmsList.get(0)); essa linha pega o primeiro filme, da filmslist que esta na posicao 0 e nos mostra no cmd.

        //exibir e manipular dados
        System.out.println("\uD83E\uDD47\u001b[4m\u001b[1m\u001b[31m Top 10 - Films:\u001b[m\n");
        for(Map<String,String> films : filmsList) { //esta pegando no Map string e indicando que mostraremos os filmes
            System.out.println("\u001b[1m\u001b[4m\u001b[32mRank:\u001b[m " + films.get("rank"));
            System.out.println("\u001b[1m\u001b[4m\u001b[90mTitle:\u001b[m " + films.get("fullTitle")); //printando a key que foi pega no films, nesse caso o fulltitle e assim por diante.
            System.out.println("\u001b[1m\u001b[4m\u001b[3m\u001b[93mPoster:\u001b[m " + films.get("image"));
            System.out.println("\u001b[1m\u001b[4m\u001b[3m\u001b[94mRating:\u001b[m \u2B50 " + films.get("imDbRating"));
            System.out.println();
            System.out.println();
        }
    }
}

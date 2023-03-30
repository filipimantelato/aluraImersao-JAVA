import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class clientHttp {
    public String buscaDados(String url) {

        try {

            URI adress = URI.create(url);  //URI é uma forma de usar o url completo.
            HttpClient client = HttpClient.newHttpClient(); //criando um httpClient que foi colocado em umna variavel.
            HttpRequest request = HttpRequest.newBuilder(adress).GET().build(); //criando um httpRequest, sendo seu builder o proprio URI.
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString()); //por meio do client, mandamos a informacao do request, para ler "BodyHandles" a documentacao em String(ofString).
            String body = response.body(); //response é dado como "body", e nesse caso estamos jogando o body em uma String para imprimir.
            return body;
            
        } catch(IOException | InterruptedException ex) {
            throw new ClientHttpException("Erro ao consumir a URL");
        }
    }

}

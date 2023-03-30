import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception { 
        
        //inicializando a conexao HTTP com a api para implementar os top 250 filmes.

        //String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        //ExtratorConteudo extrator = new ExtratorImdb();

        //String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/NASA-APOD.json"; //main url for search.
        //ExtratorConteudo extrator= new ExtratorNasa();

        //API api = API.IMDB_TOP_MOVIES;
        API api = API.NASA;
        String url = api.getUrl();
        ExtratorConteudo extrator= api.getExtrator();

        clientHttp http = new clientHttp();
        String json = http.buscaDados(url);
        
        //exibir e manipular dados
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var stickerGenerator = new stickerGenerator();

        for(int i = 0; i < 3; i++) { //esta pegando no Map string e indicando que mostraremos os filmes
            Conteudo conteudo = conteudos.get(i);

            String textoFigurinha = conteudo.titulo();

            InputStream inputStream = new URL(conteudo.urlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.titulo() + ".png";

            stickerGenerator.gera(inputStream, nomeArquivo, textoFigurinha);

            System.out.println(conteudo.titulo());
            System.out.println();
        }
    }
}

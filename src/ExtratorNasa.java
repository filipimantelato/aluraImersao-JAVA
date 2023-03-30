import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorNasa implements ExtratorConteudo{
    public List<Conteudo> extraiConteudos(String json) {

        //extrair apenas dados necessarios(titulo, poster, classificacao).
        var parser = new jsonParser();
        List<Map<String,String>> listaDeAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        //o codigo abaixo pode ser alterado para o seguinte modo
        /*(return listaDeAtributos.stream()
            .map(atributos -> new Conteudo(atributos.get("title"), atibutos.get("url")))
            .toList();*/

        //popular a lista de conteudos
        for (Map<String,String> atributos : listaDeAtributos) {
            String titulo = atributos.get("title");
            String urlImage = atributos.get("url");
            Conteudo conteudo = new Conteudo(titulo, urlImage);

            conteudos.add(conteudo); //conteudos = lista, conteudo = objeto
        }

        return conteudos;   
    }
}

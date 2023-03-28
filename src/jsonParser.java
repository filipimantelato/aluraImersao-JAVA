import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class jsonParser {
    private static final Pattern REGEX_ITEMS = Pattern.compile(".*\\[(.+)\\].*"); //essa regex fez a leitura da documentacao do uri, e separou todo o conteudo que estava dentro dos colchetes, ou seja, separou o conteudo que é necessario por meio do .*\\[(.+)\\].*
    private static final Pattern REGEX_ATRIBUTOS_JSON = Pattern.compile("\"(.+?)\":\"(.*?)\""); //separando em grupos(id, title, rating....)

    public List<Map<String, String>> parse(String json) {
        Matcher matcher = REGEX_ITEMS.matcher(json);

        if (!matcher.find()) {

            throw new IllegalArgumentException("Não encontrou items.");
        }

        String[] items = matcher.group(1).split("\\},\\{"); //cada filme esta separado entre eles por },{ e por conta disso essa expressao split com regex ta marcando oque esta delimitando os filmes, deixando os filmes cada um por si
        List<Map<String, String>> dados = new ArrayList<>();

        for (String item : items) {
            Map<String, String> atributosItem = new HashMap<>();

            Matcher matcherAtributosJson = REGEX_ATRIBUTOS_JSON.matcher(item);
            while (matcherAtributosJson.find()) {
                String atributo = matcherAtributosJson.group(1);
                String valor = matcherAtributosJson.group(2);
                atributosItem.put(atributo, valor);
            }

            dados.add(atributosItem);
        }

        return dados;
    }      
}

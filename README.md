<h1 align=center"> Imersão Alura_Java ☕ </h1>
                 <p><img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge"/></p>
                 <p> 🏁 <b>Dia 1:</b> <p>
                 <p> • Nessa etapa foi utilizada a <a href="https://imdb-api.com"><b>API do IMDB</b></a> requisitando o endpoint que retorna os 250 melhores filmes. Para isso foi utilizado o pacote <a href="https://docs.oracle.com/javase/7/docs/api/java/net/package-summary.html"><b>java.net</b></a> que fornece todas as ferramentas para estabelecer a conexão httpClient.</p>
                 <p> • Além da utilização da biblioteca Gson do google para desserializar o JSON da requisição e armazenar as informações em objetos Java.</br></p>
                 <p> <b>Resultados:</b> </p>
                 <table>
                  <tr>
                    <td><img src="https://user-images.githubusercontent.com/112342523/228338346-3439d6e7-71ba-4bd1-bbec-3f7c2a8cdb44.png" width="500" height "500"></td>
                    <td><img src="https://user-images.githubusercontent.com/112342523/228338930-14d0e8bc-61d3-4ff4-be6d-de75be398eb1.png" width="500" height "500"</br></br></td>
                  </tr>
                 </table>
                 <p></br></br> 🏁 <b>Dia 2:</b> <p>
                 <p> • Com o auxílio dos pacotes java.awt, java.io e java.ImageIO foi possível realizar a edição das imagens e a inserção de textos.</p>
                 <p> • Uma classificação baseada no IMDB foi aplicada, filmes com baixa pontuação: "É PAIA", e os filmes de maior pontuação "É DENTRO!". A mesma metodologia foi aplicada aos programas de Tv.</p>
                 <p> • Para persistência dos dados foi criada uma pasta saida/imdb onde as figurinhas geradas podem ser exportadas no formato png.</p>
                 <p> <b>Resultados(Filmes):</b> </p>
                 <table>
                    <tr>
                    <td><img src="https://github.com/filipimantelato/aluraImersao-JAVA/blob/main/saida/The%20Dark%20Knight.png?raw=true" width="200" height "200"/></td>
                    <td><img src="https://github.com/filipimantelato/aluraImersao-JAVA/blob/main/saida/The%20Godfather.png?raw=true" width="200" height "200"/></td>
                    <td><img src="https://github.com/filipimantelato/aluraImersao-JAVA/blob/main/saida/The%20Shawshank%20Redemption.png?raw=true" width="200" height "200"/</td>                                           </tr>
                </table>
                 <p> <b>Resultados(TV's Shows):</b> </p>
                 <table>
                    <tr>
                    <td><img src="https://github.com/filipimantelato/aluraImersao-JAVA/blob/main/saida/Stranger%20Things.png?raw=true" width="200" height "200"/></td>
                    <td><img src="https://github.com/filipimantelato/aluraImersao-JAVA/blob/main/saida/The%20Boys.png?raw=true" width="200" height "200"/></td>
                    <td><img src="https://github.com/filipimantelato/aluraImersao-JAVA/blob/main/saida/The%20Terminal%20List.png?raw=true" width="200" height "200"/</td>                                           </tr>
                </table>
                <p></br></br> 🏁 <b>Dia 3:</b> <p>
                 <p> • O código foi aprimorado com o objetivo de simplificar a aplicação utilizando a programação orientada a objetos como o polimorfismo.</p>
                 <p> • Para que isso, foram implementadas as ferramentas <b>Record</b>, <b> Interface</b> e <b> Enum</b>.</p>
                 <p> • Também foi utilizado a ferramenta <b> Excalidraw </b>para criar um mapa da ordem que é seguida quando o programa é executado. Assim que o programa executa, a classe <b> APP </b> faz conexão com a classe <b> API </b> onde é solicitado a URL e qual extrator será usado na execução. Após ser definido qual extrador sera utilizado dentre os dois existentes, a interface <b> ExtratorConteudo </b> é solicitada, devolvendo assim a lista de conteúdos do documento JSON por meio da classe <b> clientHttp </b>. Por fim a classe <b> APP </b> utiliza os metodos da classe <b> stickerGenerator </b> passando o conteúdo e retornando a figurinha com a mensagem desejada.</p>
                 <img src="https://user-images.githubusercontent.com/112342523/228933486-5f8433b4-e6a3-4965-91f8-07232c08852f.png"/>
                 <p> <b>Resultado:</b> </p>    
                 <table align="center">
                    <tr>
                    <td><img src="https://github.com/filipimantelato/aluraImersao-JAVA/blob/main/saida/Find%20the%20Man%20in%20the%20Moon.png?raw=true" width="400" height "400" align="center"/></td>
                    <td><img src="https://github.com/filipimantelato/aluraImersao-JAVA/blob/main/saida/Satellites%20Behind%20Pinnacles.png?raw=true" width="400" height "400" align="center"/></td>                                        
                   </tr>
                </table>                                                                                                                




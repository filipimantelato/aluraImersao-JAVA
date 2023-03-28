import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class stickerGenerator {
    public void gera(InputStream inputStream, String nomeArquivo, String texto) throws Exception{
        try {
            java.util.Properties props = System.getProperties();
            props.put("myFont", "Comic Sans MS-PLAIN-12");
            System.setProperties(props);
        }
        catch(Exception e) {
            System.err.println("Exception getting/setting properties: " + e);
        }

        //leitura da imagem
        //InputStream inputStream = new FileInputStream(new File("entrada/TopMovies_1.jpg"));
        //InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg").openStream();
        BufferedImage imgOriginal = ImageIO.read(inputStream);

        //cria uma nova imagem em memoria com transparencia, com tamanho novo
        int width = imgOriginal.getWidth(); //largura do proprio poster
        int height = imgOriginal.getHeight(); //altura do proprio poster
        int newHeight = height + 200; //na imagem nova vai ter a altura do proprio postar mais 200 para a escrita
        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT); //largura padrao, nova altura e o tipo é translucent(transparente)

        //copiar a imagem original para nova imagem(em memoria)
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(imgOriginal, 0, 0, null);

        //configurar a fonte
        var font = new Font("Comic Sans MS", Font.BOLD, 100);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(font);

        //escrever uma frase na nova imagem
        FontMetrics fontMetrics = graphics.getFontMetrics();
        Rectangle2D retangulo = fontMetrics.getStringBounds(texto, graphics);
        int larguraTexto = (int) retangulo.getWidth();
        int posicaoTextoX = (width - larguraTexto) / 2;
        int posicaoTextoY = (newHeight - 100);
        graphics.drawString(texto, posicaoTextoX, posicaoTextoY);

        FontRenderContext fontRenderContext = graphics.getFontRenderContext();
        TextLayout textLayout = new TextLayout(texto, font, fontRenderContext);

        Shape outline = textLayout.getOutline(null);
        AffineTransform transform = graphics.getTransform();
        transform.translate(posicaoTextoX, posicaoTextoY);
        graphics.setTransform(transform);

        BasicStroke basicStroke = new BasicStroke(width * 0.004f);
        graphics.setStroke(basicStroke);

        graphics.setColor(Color.BLACK);
        graphics.draw(outline);
        graphics.setClip(outline);

        //escrever a nova imagem em um novo arquivo
        ImageIO.write(newImage, "png", new File(nomeArquivo));
    }
}


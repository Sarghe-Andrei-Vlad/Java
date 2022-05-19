package network.svgExport;

import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.*;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import java.awt.*;
import java.io.*;
import java.util.List;
import java.util.Map;

public class SVGExport {
    private final DOMImplementation domImplementation = GenericDOMImplementation.getDOMImplementation();
    private final String svgNS = "http://www.w3.org/2000/svg";
    private final Document document = domImplementation.createDocument(svgNS, "svg", null);
    private final SVGGeneratorContext svgGeneratorContext;
    private final SVGGraphics2D svgGenerator;
    private final Map<String, List<String>> socialNetwork;

    public SVGExport(Map<String, List<String>> network) {
        this.svgGeneratorContext = SVGGeneratorContext.createDefault(document);
        svgGeneratorContext.setComment("Lab 10 - Social Network");
        svgGeneratorContext.setEmbeddedFontsOn(true);
        this.svgGenerator = new SVGGraphics2D(svgGeneratorContext, true);
        this.socialNetwork = network;
    }

    public void export() throws IOException {
        Graphics2D svg = svgGenerator;
        svg.setColor(Color.BLACK);
        String fontName = "Raleway";
        Font font = new Font(fontName, Font.PLAIN, 10);
        svg.setFont(font);
        svg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        String line;
        int textY = 7;
        for(Map.Entry<String,List<String>> entry : socialNetwork.entrySet()){
            line = getString(entry.getKey());
            svg.drawString(line, 0, textY);
            textY += 10;
        }

        OutputStream outputStream = new FileOutputStream("D:\\Facultate\\An2Sem2\\PA---Java\\Lab10Homework\\test.html");
        Writer out = new OutputStreamWriter(outputStream, "UTF-8");
        svgGenerator.stream(out, true);
    }

    private String getString(String username){
        StringBuilder line = new StringBuilder();

        line.append("username: ").append(username).append(" -> friends: ");

        for(String friend : socialNetwork.get(username)){
            line.append(friend).append(", ");
        }

        return line.toString();
    }
}

package book8.ch5;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.text.NumberFormat;

public class XMLTest
{
    public static void main(String[] args)
    {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        Document doc = getDocument("C:\\Users\\Rourke Scott\\Documents\\1) Bootcamp\\6. Java_Beginner\\JavaGroupA\\src\\book8\\ch5\\movies.xml");
        System.out.println("DOM CREATED!!\n");
        int count = 0;
        Element root = doc.getDocumentElement();

        /*Node movie = root.getFirstChild();
        while (movie != null)
        {
            count ++;
            movie = movie.getNextSibling();
        }
        System.out.println("There are " + count + " movies.");*/

        NodeList movies = root.getChildNodes();
//        Element movie = (Element) root.getFirstChild();
        for (int i = 0; i < movies.getLength(); i++)
        {
            Element movie = (Element)movies.item(i);
            Node title = movie.getFirstChild();
            System.out.println(title.getTextContent());

            System.out.println(movie.getAttribute("year"));

            Node price = movie.getFirstChild().getNextSibling();
            double dPrice = Double.parseDouble(price.getTextContent());
            System.out.println(nf.format(dPrice) + "\n");
            /*System.out.println(movie.getFirstChild().getTextContent());
            System.out.println(movie.getAttributes().getNamedItem("year").getTextContent());
            System.out.println(movie.getFirstChild().getNextSibling().getTextContent() + "\n");
*/

        }

       /* int oldest = 9999;
        while (movie != null)
        {
            String s = movie.getAttribute("year");
            int year = Integer.parseInt(s);

            if (year < oldest)
            {
                oldest = year;
            }
            movie = (Element) movie.getNextSibling();
        }
        System.out.println("The oldest movie is in the year " + oldest);*/
    }

    /*private static String getTextValue(Node n)
    {
        return n.getTextContent();
    }*/

    private static Document getDocument(String name)
    {
        try
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setIgnoringComments(true);
            factory.setIgnoringElementContentWhitespace(true);
            factory.setValidating(true);

            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(new InputSource(name));
        }catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }
}

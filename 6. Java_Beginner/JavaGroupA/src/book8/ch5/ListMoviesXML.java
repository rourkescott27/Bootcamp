package book8.ch5;

import book8.ch2.Movie;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.text.NumberFormat;

public class ListMoviesXML
{
    private static NumberFormat cf = NumberFormat.getCurrencyInstance();

    public static void main(String[] args)
    {
        Document doc = getDocument("C:\\Users\\Rourke Scott\\Documents\\1) Bootcamp\\6. Java_Beginner\\JavaGroupA\\src\\book8\\ch5\\movies.xml");
        Element root = doc.getDocumentElement(); // XML ROOT ELEMENT (MOVIES)
        Element movieElement = (Element) root.getFirstChild();
        Movie m;

        while (movieElement != null)
        {
            m = getMovie(movieElement); // GETS INFO OF CURRENT MOVIE
            String msg = Integer.toString(m.year);
            msg += ": " + m.title;
            msg += "(" + cf.format(m.price) + ")";
            System.out.println(msg);
            movieElement = (Element) movieElement.getNextSibling();
        }
    }

    private static Document getDocument(String name)
    {
        try
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setIgnoringComments(true); // IGNORES COMMENTS IN THE XML FILE
            factory.setIgnoringElementContentWhitespace(true); //IGNORES WHITESPACE WITHIN THE ELEMENTS
            factory.setValidating(true); // VALIDATES THE XML DOCUMENT(LOOKS AT DTD SCHEMA FIRST TO VALIDATE)
            DocumentBuilder builder = factory.newDocumentBuilder();

            return builder.parse(new InputSource(name));

        } catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }

    private static Movie getMovie(Element e)
    {
//        GET THE YEAR ATTRIBUTE
        String yearString = e.getAttribute("year");
        int year = Integer.parseInt(yearString);
//        GET THE TITLE ELEMENT
        Element tElement = (Element) e.getFirstChild();
        String title = getTextValue(tElement).trim();
//        GET THE PRICE ELEMENT
        Element pElement = (Element) tElement.getNextSibling();
        String pString = getTextValue(pElement).trim();
        double price = Double.parseDouble(pString);
        return new Movie(title, year, price);
    }

    private static String getTextValue(Node n)
    {
        return n.getFirstChild().getNodeValue();
    }

    private static  class Movie
    {
        public String title;
        public int year;
        public double price;

        public  Movie(String title, int year, double price)
        {
            this.title = title;
            this.year = year;
            this.price = price;
        }
    }
}

/*
Author  : Ahmad Hussein
Id      : 1181285
*/
package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a book ID: ");
            String input = scanner.nextLine();
            File file = new File("src\\main\\java\\org\\example\\sample.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("book");
            String bookString = null;
            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element bookElement = (Element) node;

                    Book book = new Book(bookElement.getAttribute("id"),
                            bookElement.getElementsByTagName("author").item(0).getTextContent(),
                            bookElement.getElementsByTagName("title").item(0).getTextContent(),
                            bookElement.getElementsByTagName("genre").item(0).getTextContent(),
                            bookElement.getElementsByTagName("price").item(0).getTextContent(),
                            bookElement.getElementsByTagName("publish_date").item(0).getTextContent(),
                            bookElement.getElementsByTagName("description").item(0).getTextContent()
                    );
                    if (book.getId().equals(input)) {
                        bookString =  book.toString();
                        System.out.println("Book With Id = " + input + ": " + bookString);
                        break;
                    }
                }
            }
            if(bookString == null)
                System.out.println("No book found in this xml file with id: " + input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


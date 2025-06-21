
import java.util.Scanner;

interface WordDocument {
    void create();
}
interface PdfDocument {
    void create();
}
interface excelDocument {
    void create();
}
class WordDocumentImpl implements WordDocument {
    @Override
    public void create() {
        System.out.println("Word Document Created");
    }
}
class PdfDocumentImpl implements PdfDocument {
    @Override
    public void create() {
        System.out.println("PDF Document Created");
    }
}
class ExcelDocumentImpl implements excelDocument {
    @Override
    public void create() {
        System.out.println("Excel Document Created");
    }
}
abstract class DocumentFactory{
    abstract void createDocument();
}
class WordDocumentFactory extends DocumentFactory {
    @Override
    void createDocument() {
        WordDocument wordDoc = new WordDocumentImpl();
        wordDoc.create();
    }
}
class PdfDocumentFactory extends DocumentFactory {
    @Override
    void createDocument() {
        PdfDocument pdfDoc = new PdfDocumentImpl();
        pdfDoc.create();
    }
}
class ExcelDocumentFactory extends DocumentFactory {
    @Override
    void createDocument() {
        excelDocument excelDoc = new ExcelDocumentImpl();
        excelDoc.create();
    }
}
public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the type of document to create (Word/PDF/Excel): ");
        String documentType = scanner.nextLine().trim().toLowerCase();
        scanner.close();
        DocumentFactory factory;
        factory = switch (documentType) {
            case "word" -> new WordDocumentFactory();
            case "pdf" -> new PdfDocumentFactory();
            case "excel" -> new ExcelDocumentFactory();
            default -> {
                System.out.println("Invalid document type.");
                yield null;
            }
        };
        if (factory != null) {
            factory.createDocument();
        }
    }
}

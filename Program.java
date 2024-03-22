package Images;

public class Program {
    public static void main(String[] args) {
        
        Image image1 = new ProxyImage("Imagen1.jpeg");
        Image image2 = new ProxyImage("Imagen2.jpeg");
        
        image1.display();
        image1.display();
        image2.display();
        image2.display();

    }
    
}

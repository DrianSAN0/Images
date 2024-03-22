// ProxyImage.java
package Images;

import java.util.HashMap;
import java.util.Map;

public class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;
    private boolean loading = false;
    private static Map<String, RealImage> imageCache = new HashMap<>();

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    public void display() {
        if (imageCache.containsKey(filename)) {
            realImage = imageCache.get(filename);
        } else if (!loading) {
            loading = true;
            Thread thread = new Thread(() -> {
                realImage = new RealImage(filename);
                imageCache.put(filename, realImage);
                loading = false;
                realImage.display();
            });
            thread.start();
        } else {
            System.out.println("Image is already loading");
        }

        if (realImage != null) {
            realImage.display();
        }
    }
}
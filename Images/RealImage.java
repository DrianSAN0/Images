// RealImage.java
package Images;

import java.io.File;

public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        // Usar la ruta real de las imágenes
        File file = new File(filename);
        if (!file.exists()) {
            throw new RuntimeException("Image not found: " + filename);
        }
        System.out.println("Loading " + filename);
    }

    public void display() {
        System.out.println("Displaying " + filename);
    }
}
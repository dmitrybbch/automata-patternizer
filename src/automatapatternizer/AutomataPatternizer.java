
package automatapatternizer;

import automatapatternizer.imageLoader.ImageLoader;
import automatapatternizer.toTextSaver.ToTxtSaver;
import java.awt.image.BufferedImage;

public class AutomataPatternizer {
    public static BufferedImage image;
    
    public static void main(String[] args) {
        switch(args.length){
            case 0:
                System.out.println("No arguments given!");
                
                image = ImageLoader.loadImage("Image.jpg");
                System.out.println("Image loading done.");
                ToTxtSaver.saveToTxt(image, "finished", "12345/3");
                System.out.println("Image saving done.");
                break;
            case 1:
                System.out.println("One argument given.");
                
                image = ImageLoader.loadImage(args[0]);
                System.out.println("Image loading done.");
                ToTxtSaver.saveToTxt(image, "finished", "12345/3");
                System.out.println("Image saving done.");
                break;
            case 2:
                System.out.println("Two arguments given.");
                
                image = ImageLoader.loadImage(args[0]);
                System.out.println("Image loading done.");
                ToTxtSaver.saveToTxt(image, args[1], "12345/3");
                System.out.println("Image saving done.");
                break;
            case 3:
                System.out.println("Three arguments given.");
                
                image = ImageLoader.loadImage(args[0]);
                System.out.println("Image loading done.");
                ToTxtSaver.saveToTxt(image, args[1], args[2]);
                System.out.println("Image saving done.");
                break;
        }
        
    }
    
}


package automatapatternizer.toTextSaver;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ToTxtSaver {
    
    public static File file;
    
    public static void saveToTxt(BufferedImage image, String path, String rule){
        
        file = new File(path);
        int[][] pixels = new int[image.getHeight()][image.getWidth()];
        
        for(int y=0; y<image.getHeight(); y++)
            for(int x=0; x<image.getWidth(); x++){
                
                int color = image.getRGB(x, y);
                int  red   = (color & 0x00ff0000) >> 16;
                int  green = (color & 0x0000ff00) >> 8;
                int  blue  =  color & 0x000000ff;
                
                int numberOfShades = 150;
                int conversionFactor = 255 / (numberOfShades - 1);
                int averageValue = (red + green + blue) / 3;
                pixels[y][x] = (int) (((averageValue / conversionFactor) + 0.5) * conversionFactor);
                
                //pixels[y][x] = (red+green+blue) / 3;
            }
        
        
        
        ///WRITING IN THE SELECTED FILE
        FileWriter fileWriter;
        if(file!=null) //Only proceed if the file has been given a name
            try {
                fileWriter = new FileWriter(file.getAbsoluteFile()+".txt", false); //false to erase content and rewrite everything
                
                fileWriter.write(rule);
                for(int y=0; y<pixels.length; y++){
                    fileWriter.write("\n");
                    for(int x=0; x<pixels[y].length; x++)
                        fileWriter.write(pixels[y][x] + " ");
                }
                fileWriter.close();
                
            } catch (IOException ex) {
                System.err.println("Error in the file saving method.");
            }
        
    }
    
}

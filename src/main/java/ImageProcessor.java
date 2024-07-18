import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageProcessor extends JPanel {
    public ImageProcessor() {
        //Mouse Listener
        //Mouse Motion Listener
    }
    private void openFileChooser() {
        boolean imageReady = false;
        BufferedImage bufferedImage;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new CustomImageFilter());
        fileChooser.setAcceptAllFileFilterUsed(false);

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            try {
                BufferedImage tempImage = ImageIO.read(fileChooser.getSelectedFile());
                Image scaledImage = tempImage.getScaledInstance(tempImage.getWidth() * 2,
                        tempImage.getHeight() * 2, Image.SCALE_SMOOTH);
                while (scaledImage.getWidth(null) > screenSize.width ||
                        scaledImage.getHeight(null) > screenSize.height) {
                    int newWidth = scaledImage.getWidth(null);
                    if (scaledImage.getWidth(null) > screenSize.width) {
                        newWidth = (int) (scaledImage.getWidth(null) / 1.5);
                    }

                    int newHeight = scaledImage.getHeight(null);
                    if (scaledImage.getHeight(null) > screenSize.height) {
                        newHeight = (int) (scaledImage.getHeight(null) / 1.5);
                    }
                    scaledImage = scaledImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
                }

                bufferedImage = ImageIO.read(new File("path"));
                bufferedImage = new BufferedImage(scaledImage.getWidth(null),
                        scaledImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
                Graphics2D bGr = bufferedImage.createGraphics();
                bGr.drawImage(scaledImage, 0, 0, null);
                bGr.dispose();
                imageReady = true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public BufferedImage doFilter(BufferedImage image) {
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                Color current = new Color(image.getRGB(x, y));
                int red = current.getRed();
                int green = current.getGreen();
                int blue = current.getBlue();
                image.setRGB(x,y, new Color(red, green, blue).getRGB());
            }
        }
        return image;
    }
}

package net.jogeum.text2image;

import lombok.Builder;
import lombok.Getter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Objects;

import static java.awt.RenderingHints.KEY_ANTIALIASING;
import static java.awt.RenderingHints.VALUE_ANTIALIAS_ON;

/**
 * @author jogeum
 * @since 14/10/2019
 */
@Getter
public class CustomImage {
    private final static int margin = 60;
    private final static int lingSpacing = 10;
    private int imageWidth;
    private int imageHeight;
    private String imageColor;

    private int startHeight;

    @Builder
    public CustomImage(Integer imageWidth, Integer imageHeight, String imageColor) {
        this.imageWidth = Objects.requireNonNull(imageWidth);
        this.imageHeight = Objects.requireNonNull(imageHeight);
        this.imageColor = Objects.requireNonNull(imageColor);

        this.startHeight = margin;
    }

    public void converting(String filePath, CustomText... customTexts) {
        if (customTexts == null || customTexts.length == 0) {
            throw new RuntimeException("text 를 입력해 주세요.");
        }

        BufferedImage image = getBufferedImage();
        for (CustomText customText : customTexts) {
            this.draw(image, customText);
        }
        try (OutputStream os = new FileOutputStream(new File(filePath))) {
            ImageIO.write(image, "png", os);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private BufferedImage getBufferedImage() {
        BufferedImage image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);
        graphics.setPaint(this.getColor());
        graphics.fillRect(0, 0, image.getWidth(), image.getHeight());
        return image;
    }

    private void draw(BufferedImage image, CustomText customText) {
        Graphics2D graphics = image.createGraphics();

        graphics.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);
        graphics.setFont(customText.getFont());
        graphics.setColor(customText.getColor());
        FontMetrics fontMetrics = graphics.getFontMetrics();
        int fontHalfSize = fontMetrics.getHeight() / 2;

        graphics.drawString(customText.getText(), margin, startHeight + fontHalfSize);
        graphics.dispose();

        this.addHeight(fontMetrics.getHeight());
    }

    private void addHeight(Integer height) {
        startHeight += height + lingSpacing;
    }

    public Color getColor() {
        return Utils.getColor(this.imageColor);
    }
}

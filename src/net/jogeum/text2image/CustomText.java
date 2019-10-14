package net.jogeum.text2image;

import lombok.Builder;
import lombok.Getter;

import java.awt.*;
import java.util.Objects;

/**
 * @author jogeum
 * @since 14/10/2019
 */
@Getter
public class CustomText {
    private String text;
    private String fontFamily;
    private int fontSize;
    private String fontColor;
    private FontStyle fontStyle;

    public enum FontStyle {
        PLAIN, BOLD, ITALIC
    }

    @Builder
    public CustomText(String text, String fontFamily, Integer fontSize, String fontColor, FontStyle fontStyle) {
        this.text = Objects.requireNonNull(text);
        this.fontFamily = Objects.requireNonNull(fontFamily);
        this.fontSize = Objects.requireNonNull(fontSize);
        this.fontColor = Objects.requireNonNull(fontColor);
        this.fontStyle = fontStyle == null ? FontStyle.PLAIN : fontStyle;
    }

    public Font getFont() {
        return new Font(this.fontFamily, this.getFontStyle(), this.fontSize);
    }

    private int getFontStyle() {
        switch (this.fontStyle) {
            case BOLD: return Font.BOLD;
            case ITALIC: return Font.ITALIC;
            default: return Font.PLAIN;
        }
    }

    public Color getColor() {
        return Utils.getColor(this.fontColor);
    }
}

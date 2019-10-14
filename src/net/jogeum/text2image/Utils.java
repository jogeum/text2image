package net.jogeum.text2image;

import lombok.experimental.UtilityClass;

import java.awt.*;

/**
 * @author jogeum
 * @since 14/10/2019
 */
@UtilityClass
public class Utils {
    public Color getColor(String textColor) {
        if (textColor == null || textColor.length() != 7) {
            throw new RuntimeException("Web Color 를 입력해 주세요.");
        }
        return new Color(
                Integer.valueOf(textColor.substring(1, 3), 16),
                Integer.valueOf(textColor.substring(3, 5), 16),
                Integer.valueOf(textColor.substring(5, 7), 16)
        );
    }
}

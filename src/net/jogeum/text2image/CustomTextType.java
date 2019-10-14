package net.jogeum.text2image;

/**
 * @author jogeum
 * @since 14/10/2019
 */
public enum CustomTextType {
    title {
        @Override
        public CustomText getText(String text) {
            return CustomText.builder()
                    .text(text)
                    .fontFamily("나눔고딕")
                    .fontColor("#EDF5E1")
                    .fontSize(48)
                    .fontStyle(CustomText.FontStyle.BOLD)
                    .build();
        }
    },
    subtitle {
        @Override
        public CustomText getText(String text) {
            return CustomText.builder()
                    .text(text)
                    .fontFamily("나눔고딕")
                    .fontColor("#BEE4AF")
                    .fontSize(36)
                    .build();
        }
    },
    content{
        @Override
        public CustomText getText(String text) {
            return CustomText.builder()
                    .text(text)
                    .fontFamily("나눔고딕")
                    .fontColor("#379683")
                    .fontSize(18)
                    .build();
        }
    },
    comment{
        @Override
        public CustomText getText(String text) {
            return CustomText.builder()
                    .text(text)
                    .fontFamily("나눔고딕")
                    .fontColor("#05386B")
                    .fontSize(14)
                    .build();
        }
    };

    abstract public CustomText getText(String text);
}

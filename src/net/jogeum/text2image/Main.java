package net.jogeum.text2image;

public class Main {

    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");;
        String filePath = String.format("%s/test.png", userDir);
        System.out.println("생성될 파일 : " + filePath);

        CustomImage image = CustomImage.builder()
                .imageWidth(600)
                .imageHeight(600)
                .imageColor("#5CDB95")
                .build();

        image.converting(
                filePath,
                CustomTextType.title.getText("TEXT TO"),
                CustomTextType.title.getText("IMAGE ++"),
                CustomTextType.title.getText("CONVERTING"),
                CustomTextType.subtitle.getText("created by jogeum"),
                CustomTextType.content.getText("java로 text를 image로 변환하기"),
                CustomTextType.comment.getText("java 11 / lombok / awt / 나눔고딕")
        );

        System.out.println("파일 생성 완료 !!");
    }
}

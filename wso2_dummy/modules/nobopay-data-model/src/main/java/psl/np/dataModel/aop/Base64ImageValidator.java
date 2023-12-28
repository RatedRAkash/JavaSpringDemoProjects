package psl.np.dataModel.aop;

import javax.imageio.ImageIO;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.Base64;

public class Base64ImageValidator implements ConstraintValidator<ValidBase64Image,String> {
    private String message;

    @Override
    public void initialize(ValidBase64Image constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.message= constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            byte[] imageBytes = Base64.getDecoder().decode(value);
            // Create a BufferedImage from the bytes
            ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
            BufferedImage image = null;
            image = ImageIO.read(bis);
            // Check if the image is null
            if (image == null) {
                return false;
            }
            // Check if the image format is supported by ImageIO
            String formatName = ImageIO.getImageReadersByMIMEType("image/jpeg").next().getFormatName();
            return formatName != null;
        } catch (Exception e) {
            return false;
        }
    }
}

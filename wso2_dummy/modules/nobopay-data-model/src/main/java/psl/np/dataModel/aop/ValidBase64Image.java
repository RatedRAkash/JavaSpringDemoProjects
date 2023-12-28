package psl.np.dataModel.aop;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented

@Constraint(validatedBy = Base64ImageValidator.class)
@Target({FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
public @interface ValidBase64Image {
    String message() default "Invalid base64 data for image";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

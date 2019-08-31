package com.me.storyhubuserrepositorybackend.validator.annotation;

import com.me.storyhubuserrepositorybackend.validator.constraint.UniqueEmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target({ TYPE, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = UniqueEmailValidator.class)
public @interface ValidUniqueEmail {

    String message() default "{validation.message.email-already-exists}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrameworkAnotaciones;

import java.lang.annotation.ElementType;
import static java.lang.annotation.ElementType.FIELD;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

@Retention( RUNTIME )
@Target(ElementType.TYPE)
/**
 *
 * @author Labing
 */
public @interface FixedName {
    String className() default "";
    
}

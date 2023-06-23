package com.gregtechceu.gtceu.api.syncdata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author KilaBash
 * @date 2023/6/23
 * @implNote RequireRerender. annotated field needs re-rendering while updated.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface RequireRerender {
}

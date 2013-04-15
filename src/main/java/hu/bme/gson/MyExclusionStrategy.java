package hu.bme.gson;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class MyExclusionStrategy implements ExclusionStrategy {

	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.FIELD })
	public @interface Serialize {

	}

	private final Class<?> typeToSkip;

	public MyExclusionStrategy(Class<?> typeToSkip) {
		this.typeToSkip = typeToSkip;
	}

	public boolean shouldSkipField(FieldAttributes f) {
		return f.getAnnotation(Serialize.class) == null;
	}

	public boolean shouldSkipClass(Class<?> clazz) {
		return (clazz == typeToSkip);
	}

}

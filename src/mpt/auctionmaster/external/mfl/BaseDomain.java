package mpt.auctionmaster.external.mfl;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by UTUOMMA on 8/9/2015.
 */
@XmlRootElement
//@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class BaseDomain implements Serializable {

	@Override
	public String toString() {
		return makeToString(this);
	}

	public static String makeToString(Object o) {
		return o.toString();
	}

	/**
	 *	Produces a toString representation of the values in the supplied object
	 *	ignoring transient values and those annotated with {@link DoNotLog}.
	 *
	 * 	@param o
	 * 		target object.
	 * 	@return
	 * 		formatted toString.
	 */

	/*public static String makeToString(Object o) {

		final StringBuilder builder = new StringBuilder();
		final Class clazz = o.getClass();
		if (ClassUtils.isPrimitiveOrWrapper(clazz)) {
			return o.toString();
		}

		for (Field field : clazz.getDeclaredFields()) {

			if ( // ignore transient / static
				Modifier.isTransient(field.getModifiers()) ||
				Modifier.isStatic(field.getModifiers())
			) {
				continue;
			}

			boolean log = true;
			for (Annotation a : field.getDeclaredAnnotations()) {
				if (a instanceof DoNotLog)
					log = false;
			}


			try {
				field.setAccessible(true);
				final Object val = log ? field.get(o) : "***";
				builder.append(field.getName()).append(": ").append(val).append(", ");
			} catch (IllegalAccessException ignored) {
				System.out.println(ignored);
			}
		}

		final String className = clazz.getName();
		if (builder.length() > 0) {
			builder.setLength(builder.length() - 2);
		}

		if (builder.length() > 0) {
			return String.format("%s - {%s}", className, builder);
		} else {
			return className;
		}
	}*/
}

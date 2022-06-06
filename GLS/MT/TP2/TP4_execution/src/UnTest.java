import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface UnTest {
	class ExceptionValide extends Exception{
		private ExceptionValide() {
			super();
		}
	}
	public boolean enabled() default true;
	public Class<? extends Throwable> expected() default ExceptionValide.class;
	
}

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;

import java.lang.annotation.ElementType;
import java.lang.reflect.Modifier;
import java.util.*;
import javax.tools.Diagnostic.Kind;

/** Check that a class marked {@code @Utility} is indeed a utility class. */
@SupportedAnnotationTypes("Utility")
@SupportedSourceVersion(SourceVersion.RELEASE_11)
public class UtilityProcessor extends AbstractProcessor {

	@Override
	public boolean process(
			Set<? extends TypeElement> annotations,
			RoundEnvironment roundingEnvironment)
	{
		Messager messager = processingEnv.getMessager();
		messager.printMessage(Kind.NOTE,
				"UtilityProcessor executed.");
		for (TypeElement te : annotations) {
			for (Element elt : roundingEnvironment.getElementsAnnotatedWith(te)) {
				if (elt.getKind() == ElementKind.CLASS) {	// elt is a class
					if (elt.getModifiers().contains(Modifier.FINAL)){
						List<? extends Element> liste = elt.getEnclosedElements();
						for (Element e : liste) {
							if(e.getKind() == ElementKind.CONSTRUCTOR) {
								if(!e.getModifiers().contains(Modifier.PRIVATE)){
									messager.printMessage(Kind.ERROR,
											"The Constructor of the Class must be private:", e);
								}
							}else if(e.getKind() == ElementKind.METHOD) {
								if(e.getModifiers().contains(Modifier.STATIC)){
									messager.printMessage(Kind.ERROR,
											"The Method of the Class must be static:", e);
								}
							}else {
								messager.printMessage(Kind.ERROR,
										"The Class should contains only a Constructor and Methods:", e);
							}
						}
					}
				} else {
					messager.printMessage(Kind.ERROR,
							"@Utility applies to class only:", elt);
				}
			}
		}
		return true;
	}

}

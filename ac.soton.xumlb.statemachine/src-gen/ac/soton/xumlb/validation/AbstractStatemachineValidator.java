/*
 * generated by Xtext 2.21.0
 */
package ac.soton.xumlb.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

public abstract class AbstractStatemachineValidator extends AbstractDeclarativeValidator {
	
	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<EPackage>();
		result.add(EPackage.Registry.INSTANCE.getEPackage("http://soton.ac.uk/models/eventb/statemachines/2014"));
		result.add(EPackage.Registry.INSTANCE.getEPackage("http://soton.ac.uk/models/eventb/coreextension/2014"));
		result.add(EPackage.Registry.INSTANCE.getEPackage("http://emf.eventb.org/models/core/machine/2014"));
		return result;
	}
}

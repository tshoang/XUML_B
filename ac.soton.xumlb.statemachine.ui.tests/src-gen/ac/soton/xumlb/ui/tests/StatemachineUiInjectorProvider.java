/*
 * generated by Xtext 2.14.0
 */
package ac.soton.xumlb.ui.tests;

import ac.soton.xumlb.statemachine.ui.internal.StatemachineActivator;
import com.google.inject.Injector;
import org.eclipse.xtext.testing.IInjectorProvider;

public class StatemachineUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return StatemachineActivator.getInstance().getInjector("ac.soton.xumlb.Statemachine");
	}

}

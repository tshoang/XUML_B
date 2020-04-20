/*
 * generated by Xtext 2.15.0
 */
package ac.soton.xumlb.ui;

import ac.soton.xumlb.statemachine.ui.internal.StatemachineActivator;
import com.google.inject.Injector;
import org.eclipse.core.runtime.Platform;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class StatemachineExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return Platform.getBundle(StatemachineActivator.PLUGIN_ID);
	}
	
	@Override
	protected Injector getInjector() {
		StatemachineActivator activator = StatemachineActivator.getInstance();
		return activator != null ? activator.getInjector(StatemachineActivator.AC_SOTON_XUMLB_STATEMACHINE) : null;
	}

}

/**
 * generated by Xtext 2.14.0
 */
package ac.soton.xumlb.ide;

import ac.soton.xumlb.StatemachineRuntimeModule;
import ac.soton.xumlb.StatemachineStandaloneSetup;
import ac.soton.xumlb.ide.StatemachineIdeModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages as language servers.
 */
@SuppressWarnings("all")
public class StatemachineIdeSetup extends StatemachineStandaloneSetup {
  @Override
  public Injector createInjector() {
    StatemachineRuntimeModule _statemachineRuntimeModule = new StatemachineRuntimeModule();
    StatemachineIdeModule _statemachineIdeModule = new StatemachineIdeModule();
    return Guice.createInjector(Modules2.mixin(_statemachineRuntimeModule, _statemachineIdeModule));
  }
}

/**
 * generated by Xtext 2.14.0
 */
package ac.soton.xumlb;

import ac.soton.xumlb.StatemachineStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
@SuppressWarnings("all")
public class StatemachineStandaloneSetup extends StatemachineStandaloneSetupGenerated {
  public static void doSetup() {
    new StatemachineStandaloneSetup().createInjectorAndDoEMFRegistration();
  }
}

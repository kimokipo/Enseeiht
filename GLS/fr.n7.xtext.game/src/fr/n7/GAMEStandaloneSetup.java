/*
 * generated by Xtext 2.23.0
 */
package fr.n7;


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
public class GAMEStandaloneSetup extends GAMEStandaloneSetupGenerated {

	public static void doSetup() {
		new GAMEStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}
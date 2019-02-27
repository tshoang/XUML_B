/*
 * generated by Xtext 2.14.0
 */
package ac.soton.xumlb.formatting2

import ac.soton.eventb.statemachines.Statemachine
import ac.soton.eventb.statemachines.Transition
import ac.soton.xumlb.services.StatemachineGrammarAccess
import com.google.inject.Inject
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument

class StatemachineFormatter extends AbstractFormatter2 {
	
	@Inject extension StatemachineGrammarAccess

	def dispatch void format(Statemachine statemachine, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		for (abstractNode : statemachine.nodes) {
			abstractNode.format
		}
		for (transition : statemachine.transitions) {
			transition.format
		}
	}

	def dispatch void format(Transition transition, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
//		for (typedParameter : transition.parameters) {
//			typedParameter.format
//		}
//		for (guard : transition.guards) {
//			guard.format
//		}
//		for (action : transition.actions) {
//			action.format
//		}
//		for (witness : transition.witnesses) {
//			witness.format
//		}
	}
	
	// TODO: implement for State
}
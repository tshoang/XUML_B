/*******************************************************************************
 *  Copyright (c) 2020 University of Southampton.
 *
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0/
 *
 *  SPDX-License-Identifier: EPL-2.0
 *
 *  Contributors:
 *  University of Southampton - initial API and implementation *   
 *******************************************************************************/

package ac.soton.xumlb.generator

import ac.soton.emf.translator.TranslatorFactory
import ac.soton.eventb.emf.diagrams.Diagram
import ac.soton.eventb.statemachines.Statemachine
import ac.soton.xeventb.xmachine.IContainmentGenerator
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.emf.transaction.TransactionalEditingDomain
import org.eventb.emf.core.CoreFactory
import org.eventb.emf.core.machine.Machine

/**
 * @author htson
 *
 */
class StatemachineContainmentGenerator implements IContainmentGenerator {
	
	new() {
		//Default constructor
	}
	
	override generate(Machine mch, Diagram containedComponent, TransactionalEditingDomain editingDomain) {
		// If the diagrams is an instance of Statemachine then set the translation target annotation.
		if (containedComponent instanceof Statemachine) {
			val stm = containedComponent as Statemachine
			var annotations = stm.annotations
			val annot = CoreFactory.eINSTANCE.createAnnotation()
			annot.setSource("ac.soton.diagrams.translationTarget")
			annot.references.add(mch)
			annotations.add(annot)
		}

		// Translate the diagram using the translate factory
		val containmentCommandId = 'ac.soton.eventb.emf.diagrams.generator.translateToEventB'
		val factory = TranslatorFactory.getFactory()
		if (factory.canTranslate(containmentCommandId, containedComponent.eClass())) {
			var monitor = new NullProgressMonitor as IProgressMonitor;
			factory.translate(editingDomain, containedComponent, containmentCommandId, monitor)
		}
	}
	
}
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
import org.eclipse.emf.transaction.RecordingCommand
import org.eclipse.emf.transaction.TransactionalEditingDomain
import org.eventb.emf.core.CoreFactory
import org.eventb.emf.core.machine.Machine

/**
 * @author htson - Initial implementation
 * @version 0.1
 * @see IContainmentGenerator
 * @since 0.1
 */
class StatemachineContainmentGenerator implements IContainmentGenerator {
	
	new() {
		//Default constructor
	}
	
	override generate(Machine mch, Diagram containedComponent, TransactionalEditingDomain editingDomain) {
		// If the diagrams is an instance of Statemachine then set the translation target annotation.
		val stm = containedComponent as Statemachine
		val annot = CoreFactory.eINSTANCE.createAnnotation()
		annot.setSource("ac.soton.diagrams.translationTarget")
		annot.getReferences().add(mch);
		val command = new RecordingCommand(editingDomain, "Set Annotations") {
			override doExecute() {
				stm.getAnnotations().clear()
				stm.getAnnotations().add(annot)
			}
		};
		if (command.canExecute()){
			editingDomain.getCommandStack().execute(command);
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
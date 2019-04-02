 /*******************************************************************************
 * Copyright (c) 2019 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     University of Southampton - initial API and implementation
 *******************************************************************************/

package ac.soton.xumlb;

import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.resource.IDerivedStateComputer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import ac.soton.eventb.statemachines.AbstractNode;
import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.Transition;
import ac.soton.eventb.statemachines.StatemachinesPackage;

/**
 * <p>
 * Use this class to add some additional state to the AST model
 * </p>
 *
 * @author dd4g12
 * @version 0.1
 * @see 
 * @since 0.0.1
 */

public class XStatemachineDerivedStateComputer implements IDerivedStateComputer{
	
	/* The derived states: are the EOpposite "incoming" & "outgoing"
	 * for abstract nodes which are derived from the source and 
	 * target of transitions.
	*/

	@Override
	public void installDerivedState(DerivedStateAwareResource resource, boolean preLinkingPhase) {
		if (!resource.getContents().isEmpty() ) {//&& preLinkingPhase
			Statemachine sm = (Statemachine) resource.getContents().get(0);

			for(Transition trans : sm.getTransitions()) {
				final EObject proxy = EcoreUtil.create(StatemachinesPackage.Literals.TRANSITION);
				((InternalEObject) proxy).eSetProxyURI(EcoreUtil.getURI(trans));
				AbstractNode source = trans.getSource();
				if(source != null) 
					source.getOutgoing().add((Transition) proxy);
				
					
				AbstractNode target = trans.getTarget();
				if(target != null) 
					target.getIncoming().add((Transition) proxy);
				
			}
		}
		
	}

	@Override
	public void discardDerivedState(DerivedStateAwareResource resource) {
		// TODO Auto-generated method stub
		
	}

}

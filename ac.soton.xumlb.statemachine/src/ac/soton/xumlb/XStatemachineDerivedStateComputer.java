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
import org.eventb.emf.core.Annotation;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBObject;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.MachinePackage;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import ac.soton.eventb.statemachines.AbstractNode;
import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.Transition;
import ac.soton.eventb.statemachines.impl.TransitionImpl;
import ac.soton.eventb.statemachines.StatemachinesPackage;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;


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
             
			//allTransitions include all transitions even in the sub-statemachines, however it includes some null values.
			 EList<EObject> allTransitions = sm.getAllContained(StatemachinesPackage.Literals.TRANSITION, true);
			for(EObject o: allTransitions) {
				
				if(o != null) {
					TransitionImpl trans = (TransitionImpl) o;
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
			//test
			setAnnotation(sm);
			
			
		}
			
	}

	@Override
	public void discardDerivedState(DerivedStateAwareResource resource) {
		// TODO Auto-generated method stub
		
	}
   
	
	private void setAnnotation(Statemachine sm) {
		String comment = sm.getComment();
        
		URI mchURI = sm.eResource().getURI().trimFragment().trimSegments(1).appendSegment(comment+".bum");
		
		Annotation annot = (Annotation) EcoreUtil.create(CorePackage.Literals.ANNOTATION);
        ResourceSet rs=new ResourceSetImpl();
		Resource mchRes=rs.getResource(mchURI,true);
		annot.setSource("ac.soton.diagrams.translationTarget");
        annot.getReferences().add(mchRes.getContents().get(0));
		sm.getAnnotations().add(annot);

	}
}

/*******************************************************************************
 * Copyright (c) 2020 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     University of Southampton - initial API and implementation
 *******************************************************************************/
package ac.soton.xumlb.scoping

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import java.util.ArrayList
import org.eclipse.xtext.scoping.Scopes
import ac.soton.eventb.statemachines.Statemachine
import ac.soton.eventb.statemachines.StatemachinesPackage
import ac.soton.eventb.emf.core.^extension.coreextension.CoreextensionPackage
import ac.soton.eventb.statemachines.Transition
import org.eclipse.xtext.EcoreUtil2
import org.eventb.emf.core.machine.Machine
import org.eventb.emf.persistence.EMFRodinDB
import ch.ethz.eventb.utils.EventBUtils
import org.eventb.core.basis.MachineRoot
import org.eventb.emf.core.EventBNamedCommentedComponentElement
import org.eventb.emf.core.context.Context
import ac.soton.eventb.statemachines.AbstractNode

//import ac.soton.eventb.emf.core.^extension.coreextension.EventBLabeled


/**
 * <p>
 * Statemachine scope provider, in particular the scope for statemachine instances, transition events,
 * ....
 * </p>
 *
 * @author DanaDghaym (dd4g12)
 * @version 0.1
 * @see EMFRodinDB
 * @since 0.0.1
 */
class StatemachineScopeProvider extends AbstractStatemachineScopeProvider {
	override getScope(EObject context, EReference reference) {

 		if (context instanceof Transition && reference == CoreextensionPackage.Literals.EVENT_BEVENT_GROUP__ELABORATES) {
			
		    val sm = EcoreUtil2.getRootContainer(context, true) as Statemachine
			val mchName = sm.comment
			if (mchName !== ""){
				val mch = getAnnotatedMachine(sm)
				if (mch !== null){
					val evts = mch.events
					return Scopes.scopeFor(evts);
				}
			}
		}
		
		 if (context instanceof Statemachine && reference == StatemachinesPackage.Literals.STATEMACHINE__INSTANCES ) {
			
		    val sm = context as Statemachine
		    val mchName = sm.comment
			if (mchName !== ""){
				val mch = getAnnotatedMachine(sm)
				if (mch !== null){
					var list = getAvailableDataElements(mch)
					var instances = new ArrayList <EObject>
					
					for (l : list)
						instances.add(l as EObject)
			  
					return Scopes.scopeFor(instances);
				}
			}
			
		}
		
		//scope for source abstract nodes
		if (context instanceof Transition && reference == StatemachinesPackage.Literals.TRANSITION__SOURCE) {
		    val sm = EcoreUtil2.getRootContainer(context, true) as Statemachine
		    var nodes = new ArrayList()
			nodes.addAll(EcoreUtil2.getAllContentsOfType(sm, AbstractNode))
			nodes.addAll(EcoreUtil2.getContainerOfType(sm, AbstractNode))

			return Scopes.scopeFor(nodes);
       }

       
       	//scope for target abstract nodes
		if (context instanceof Transition && reference == StatemachinesPackage.Literals.TRANSITION__TARGET) {
		    val sm = EcoreUtil2.getRootContainer(context, true) as Statemachine
		  	var nodes = new ArrayList()
			nodes.addAll(EcoreUtil2.getAllContentsOfType(sm, AbstractNode))
			nodes.addAll(EcoreUtil2.getContainerOfType(sm, AbstractNode))
			return Scopes.scopeFor(nodes);
       }
       
       
//       // scope for statemachine refinement
//
// 		if (context instanceof Statemachine && reference == StatemachinesPackage.Literals.STATEMACHINE__REFINES ) {
//			val smachine = context as Statemachine
//			val x = getStatemachines(smachine)
//		
////			val cont = sm.eResource
////			var emfRodinDB = new EMFRodinDB;
////			System.out.println("state machine name: " + sm.name) 
////			var prjName = emfRodinDB.getProjectName(sm);
////			var eBPrj = EventBUtils.getEventBProject(prjName)
////			var rdPrj = eBPrj.getRodinProject()
////			var sms = rdPrj.children.filter(Statemachine)
////			return Scopes.scopeFor(sms);	 
//
//		}

        return super.getScope(context, reference);
	}


	/* This method helps to get the scope of instances which is the constants and sets in all accessible contexts
	* Get avaialable elements based on get AvaialbleDataElements from ac.soton.eventb.statemachines.diagram.sheet.custom InstancesPropertySection  
	* In this method the variables are removed as their translation is not yet supported, but can be added once support is available*/

	
	def getAvailableDataElements(EventBNamedCommentedComponentElement container) {
		var list =  new ArrayList();
		if (container instanceof Machine){
			var m = (container as Machine);
			for (Context c : m.getSees()){
				list.addAll(getAvailableDataElements(c));
			}			
		}else if (container instanceof Context){
			var c = (container as Context);
			list.addAll(c.getSets());
			list.addAll(c.getConstants());
			for (Context x : c.getExtends()){
				list.addAll(getAvailableDataElements(x));
			}
		}
		return list;
	}
	
	def getAnnotatedMachine(Statemachine sm){
		val mchName = sm.comment
		var emfRodinDB = new EMFRodinDB;
		var prjName = emfRodinDB.getProjectName(sm);
		var eBPrj = EventBUtils.getEventBProject(prjName)
		var rdPrj = eBPrj.getRodinProject()
		var mchRoots = rdPrj.getRootElementsOfType(MachineRoot.ELEMENT_TYPE)
			
		for (mchRoot : mchRoots) {
			var mch = emfRodinDB.loadEventBComponent(mchRoot)
			if ((mch as Machine).name == mchName){
				return (mch as Machine)
			}
		}
	}
}

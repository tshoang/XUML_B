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
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.scoping.IScope
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.resource.Resource
import org.eventb.emf.core.Annotation
import org.eventb.emf.core.CorePackage
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eventb.emf.core.machine.Event
import ac.soton.eventb.statemachines.impl.TransitionImpl
import org.eventb.core.basis.MachineRoot
import org.eventb.emf.core.EventBNamedCommentedComponentElement
import java.util.List
import org.eventb.emf.core.context.Context

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
//				   		instances.addAll(EcoreUtil2.getAllContentsOfType(l as EObject, EventBNamedCommentedComponentElement));
			  
					return Scopes.scopeFor(instances);
				}
			}
			
		}
		//New: scope for source abstract nodes
		// This needs to be rechecked for refined statemachines
//		if (context instanceof Transition && reference == StatemachinesPackage.Literals.TRANSITION__SOURCE) {
//		    val sm = EcoreUtil2.getRootContainer(context, true) as Statemachine
//		  	val nodes = sm.nodes
//			return Scopes.scopeFor(nodes);
//       }

       
       	//New: scope for target abstract nodes
       	// This needs to be rechecked for refined statemachines
//		if (context instanceof Transition && reference == StatemachinesPackage.Literals.TRANSITION__TARGET) {
//		    val sm = EcoreUtil2.getRootContainer(context, true) as Statemachine
//		  	val nodes = sm.nodes
//			return Scopes.scopeFor(nodes);
//       }




        return super.getScope(context, reference);
	}
	def String getProjectName(Statemachine sm)  {
			
			val eventBelementUri = sm.eResource().getURI();
			val projectUri = eventBelementUri.trimFragment().trimSegments(1);
	
			return projectUri.lastSegment();
	
		}
	
	/* This method helps to get the scope of instances which is the constants and sets in all accessible contexts
	* Get avaialable elements based on get AvaialbleDataElements from ac.soton.eventb.statemachines.diagram.sheet.custom.InstancesPropertySection  
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
	//original machine 
	//            var emfRodinDB = new EMFRodinDB;
//			val prjName = getProjectName(sm);
//			System.out.println("----project name: " + prjName)
//            var eBPrj = EventBUtils.getEventBProject(prjName)
//			var rdPrj = eBPrj.getRodinProject()
//             emfRodinDB.loadEventBComponent(mchName)
//        val mchURI = sm.eResource().getURI().trimFragment().trimSegments(1).appendSegment(mchName+".bum");
//		
//		var rs=new ResourceSetImpl();
//		val mchRes=rs.getResource(mchURI,true);
////		val evts = EcoreUtil2.getAllContentsOfType(mchRes.getEObject(mchName), Event)
//		if(mchRes.contents.get(0) instanceof Machine){
//			val mch = mchRes.contents.get(0) as Machine
//			val evts = mch.events
//			return Scopes.scopeFor(evts);
//		 }
//		 else
//		 	return IScope.NULLSCOPE
}

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
package ac.soton.xumlb.validation

import org.eclipse.xtext.validation.Check
import ac.soton.eventb.statemachines.Statemachine
import org.eventb.emf.persistence.EMFRodinDB
import ch.ethz.eventb.utils.EventBUtils
import org.eventb.core.basis.MachineRoot
import org.eventb.emf.core.EventBObject
import org.eventb.emf.core.machine.Machine
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl

/**
 * <p>
 * StateMachine validator, provides custom validation rules for the xtext machine file.
 * </p>
 *
 * @author dd4g12
 * @version 0.1
 * @since 1.0
 */
class StatemachineValidator extends AbstractStatemachineValidator {
	
    // Check the name of the .stm file is the same as the statemachine name
//	@Check
//	def checkStatemachineName(Statemachine sm){
//		val res = sm.eResource
//		val fileName = res.URI.lastSegment.toString
//		val smName= fileName.substring(0, fileName.indexOf('.'))
//		if (smName != sm.name)
//			error('Statemachine name should be the same as the file name: ' + smName, null) 
//	}
	
	 // Check annotate should be a machine
	@Check
	def checkAnnotates(Statemachine sm){
//		var mach = false
//		val annot = sm.comment
//		val mchURI = sm.eResource().getURI().trimFragment().trimSegments(1).appendSegment(annot+".bum");
//	// the problem is the URI the way we find a project recheck machien work and see if it works	
//      
//        if (mchURI.hasAbsolutePath){
//        	var rs=new ResourceSetImpl();
//        	val mchRes=rs.getResource(mchURI,true); // the problem is here the resource doesn't exist
//	    
//       		if(mchRes.contents.get(0) instanceof Machine)
//        		mach = true
//        }
//		
//        System.out.println("********\n" + mach +"********\n" )
//        if(mach == false)
//          error('annotate should be a machine', null)
          //----------------------------------------
//          var emfRodinDB = new EMFRodinDB;
//			var prjName = emfRodinDB.getProjectName(sm);
// 			var eBPrj = EventBUtils.getEventBProject(prjName)
//			var rdPrj = eBPrj.getRodinProject()
//			var mchRoots = rdPrj.getRootElementsOfType(MachineRoot.ELEMENT_TYPE)
//			for (mchRoot : mchRoots) {
//				var mch = emfRodinDB.loadEventBComponent(mchRoot)
//				if ((mch as Machine).name == sm.comment)
//				{
//					mach = true
//					System.out.println("********\n" + mch +"********\n" )
//					return
//				}
//			}
//			if(mach == false)
//          		error('annotate should be a machine', null)
          
          //--------------------------------------
   
       
	}
	
	
}

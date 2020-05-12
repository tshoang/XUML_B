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
package ac.soton.xumlb

import ac.soton.xeventb.common.EventBValueConverter
import org.eclipse.xtext.conversion.IValueConverterService
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService
import org.eclipse.xtext.resource.IDerivedStateComputer
import org.eclipse.xtext.resource.DerivedStateAwareResourceDescriptionManager
import org.eclipse.xtext.resource.DerivedStateAwareResource
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.IResourceDescription.Manager
//import ac.soton.xeventb.common.EventBQualifiedNameProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import ac.soton.xumlb.scoping.StatemachineScopeProvider;
//import org.eclipse.xtext.linking.ILinker

/**
 * <p>
 * Use this class to register components for XMachine to be used at runtime /
 * without the Equinox extension registry.
 * </p>
 *
 * @author dd4g12
 * @version 0.1
 * @see 
 * @since 0.0.1
 */
class StatemachineRuntimeModule extends AbstractStatemachineRuntimeModule {
	
	 /**
	 * Bind the transient value service for XStatemachine, use for serialisation of
	 * EMF Event-B to XText.
	 * 
	 * @see XStatemachineTransientValueService
	 */
	 override Class<? extends ITransientValueService> bindITransientValueService() {
		return typeof(XStatemachineTransientValueService);
	}
	
	/**
	 * Bind the value converter service for Event-B values, e.g., converting comments,
	 * labels, etc.
	 * 
	 * @see EventBValueConverter
	 */
	 override Class<? extends IValueConverterService> bindIValueConverterService() {
		return typeof(EventBValueConverter);
	}
	
	/**
	 * Bind the derived state computer for XStatemachine
	 * The derived state: are the EOpposite: incoming and outgoing 
	 * for abstract nodes which are derived from the source and 
	 * target of transitions.
	 * 
	 * Also requires bindIResourceDescription$Manager & bindXtextResource
	 * 
	 * @see XStatemachineDerivedStateComputer
	 */
    def Class<? extends IDerivedStateComputer> bindIDerivedStateComputer() {
		XStatemachineDerivedStateComputer
	}
	
	def Class<? extends Manager> bindIResourceDescription$Manager() {
		DerivedStateAwareResourceDescriptionManager
	}
	
	override Class<? extends XtextResource> bindXtextResource() {
		DerivedStateAwareResource
	}
	
		
    /**
	* Bind the scope provider, use for references for context seeing, machine
	* refinement, event refinement, etc.
	* 
	* @see XStatemachineScopeProvider
    */
    override Class<? extends IScopeProvider> bindIScopeProvider() {
		return typeof(StatemachineScopeProvider);
	}	
	
		/**
		 * Bind the qualified Name provider service for machine qualified name.
		 * The qualified name of a machine is projName.machineName
		 * 
		 * @see EventBQualifiedNameProvider
		 */
//		override Class<? extends org.eclipse.xtext.naming.IQualifiedNameProvider> bindIQualifiedNameProvider() {
//			return typeof(StatemachineQualifiedNameProvider);
//		}
//
//override Class<? extends ILinker> bindILinker() {
//		return typeof(XStatemachineLazyLinker);
//	}

}

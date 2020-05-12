/**
 * Copyright (c) 2019 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     University of Southampton - initial API and implementation
 */
package ac.soton.xumlb;

import ac.soton.xeventb.common.EventBValueConverter;
import ac.soton.xumlb.AbstractStatemachineRuntimeModule;
import ac.soton.xumlb.XStatemachineDerivedStateComputer;
import ac.soton.xumlb.XStatemachineTransientValueService;
import ac.soton.xumlb.scoping.StatemachineScopeProvider;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;
import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.resource.DerivedStateAwareResourceDescriptionManager;
import org.eclipse.xtext.resource.IDerivedStateComputer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScopeProvider;

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
@SuppressWarnings("all")
public class StatemachineRuntimeModule extends AbstractStatemachineRuntimeModule {
  /**
   * Bind the transient value service for XStatemachine, use for serialisation of
   * EMF Event-B to XText.
   * 
   * @see XStatemachineTransientValueService
   */
  @Override
  public Class<? extends ITransientValueService> bindITransientValueService() {
    return XStatemachineTransientValueService.class;
  }
  
  /**
   * Bind the value converter service for Event-B values, e.g., converting comments,
   * labels, etc.
   * 
   * @see EventBValueConverter
   */
  @Override
  public Class<? extends IValueConverterService> bindIValueConverterService() {
    return EventBValueConverter.class;
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
  public Class<? extends IDerivedStateComputer> bindIDerivedStateComputer() {
    return XStatemachineDerivedStateComputer.class;
  }
  
  public Class<? extends IResourceDescription.Manager> bindIResourceDescription$Manager() {
    return DerivedStateAwareResourceDescriptionManager.class;
  }
  
  @Override
  public Class<? extends XtextResource> bindXtextResource() {
    return DerivedStateAwareResource.class;
  }
  
  /**
   * Bind the scope provider, use for references for context seeing, machine
   * refinement, event refinement, etc.
   * 
   * @see XStatemachineScopeProvider
   */
  @Override
  public Class<? extends IScopeProvider> bindIScopeProvider() {
    return StatemachineScopeProvider.class;
  }
}

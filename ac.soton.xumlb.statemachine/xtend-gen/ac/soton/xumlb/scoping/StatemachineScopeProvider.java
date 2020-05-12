/**
 * Copyright (c) 2020 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     University of Southampton - initial API and implementation
 */
package ac.soton.xumlb.scoping;

import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;
import ac.soton.eventb.statemachines.AbstractNode;
import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.StatemachinesPackage;
import ac.soton.eventb.statemachines.Transition;
import ac.soton.xumlb.scoping.AbstractStatemachineScopeProvider;
import ch.ethz.eventb.utils.EventBUtils;
import com.google.common.base.Objects;
import java.util.ArrayList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eventb.core.IEventBProject;
import org.eventb.core.IMachineRoot;
import org.eventb.core.basis.MachineRoot;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamedCommentedComponentElement;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.persistence.EMFRodinDB;
import org.rodinp.core.IRodinProject;

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
@SuppressWarnings("all")
public class StatemachineScopeProvider extends AbstractStatemachineScopeProvider {
  @Override
  public IScope getScope(final EObject context, final EReference reference) {
    if (((context instanceof Transition) && Objects.equal(reference, CoreextensionPackage.Literals.EVENT_BEVENT_GROUP__ELABORATES))) {
      EObject _rootContainer = EcoreUtil2.getRootContainer(context, true);
      final Statemachine sm = ((Statemachine) _rootContainer);
      final String mchName = sm.getComment();
      if ((mchName != "")) {
        final Machine mch = this.getAnnotatedMachine(sm);
        if ((mch != null)) {
          final EList<Event> evts = mch.getEvents();
          return Scopes.scopeFor(evts);
        }
      }
    }
    if (((context instanceof Statemachine) && Objects.equal(reference, StatemachinesPackage.Literals.STATEMACHINE__INSTANCES))) {
      final Statemachine sm_1 = ((Statemachine) context);
      final String mchName_1 = sm_1.getComment();
      if ((mchName_1 != "")) {
        final Machine mch_1 = this.getAnnotatedMachine(sm_1);
        if ((mch_1 != null)) {
          ArrayList<Object> list = this.getAvailableDataElements(mch_1);
          ArrayList<EObject> instances = new ArrayList<EObject>();
          for (final Object l : list) {
            instances.add(((EObject) l));
          }
          return Scopes.scopeFor(instances);
        }
      }
    }
    if (((context instanceof Transition) && Objects.equal(reference, StatemachinesPackage.Literals.TRANSITION__SOURCE))) {
      EObject _rootContainer_1 = EcoreUtil2.getRootContainer(context, true);
      final Statemachine sm_2 = ((Statemachine) _rootContainer_1);
      ArrayList<AbstractNode> nodes = new ArrayList<AbstractNode>();
      nodes.addAll(EcoreUtil2.<AbstractNode>getAllContentsOfType(sm_2, AbstractNode.class));
      CollectionExtensions.<AbstractNode>addAll(nodes, EcoreUtil2.<AbstractNode>getContainerOfType(sm_2, AbstractNode.class));
      return Scopes.scopeFor(nodes);
    }
    if (((context instanceof Transition) && Objects.equal(reference, StatemachinesPackage.Literals.TRANSITION__TARGET))) {
      EObject _rootContainer_2 = EcoreUtil2.getRootContainer(context, true);
      final Statemachine sm_3 = ((Statemachine) _rootContainer_2);
      ArrayList<AbstractNode> nodes_1 = new ArrayList<AbstractNode>();
      nodes_1.addAll(EcoreUtil2.<AbstractNode>getAllContentsOfType(sm_3, AbstractNode.class));
      CollectionExtensions.<AbstractNode>addAll(nodes_1, EcoreUtil2.<AbstractNode>getContainerOfType(sm_3, AbstractNode.class));
      return Scopes.scopeFor(nodes_1);
    }
    return super.getScope(context, reference);
  }
  
  /**
   * This method helps to get the scope of instances which is the constants and sets in all accessible contexts
   * Get avaialable elements based on get AvaialbleDataElements from ac.soton.eventb.statemachines.diagram.sheet.custom InstancesPropertySection
   * In this method the variables are removed as their translation is not yet supported, but can be added once support is available
   */
  public ArrayList<Object> getAvailableDataElements(final EventBNamedCommentedComponentElement container) {
    ArrayList<Object> list = new ArrayList<Object>();
    if ((container instanceof Machine)) {
      Machine m = ((Machine) container);
      EList<Context> _sees = m.getSees();
      for (final Context c : _sees) {
        CollectionExtensions.<Object>addAll(list, this.getAvailableDataElements(c));
      }
    } else {
      if ((container instanceof Context)) {
        Context c_1 = ((Context) container);
        list.addAll(c_1.getSets());
        list.addAll(c_1.getConstants());
        EList<Context> _extends = c_1.getExtends();
        for (final Context x : _extends) {
          CollectionExtensions.<Object>addAll(list, this.getAvailableDataElements(x));
        }
      }
    }
    return list;
  }
  
  public Machine getAnnotatedMachine(final Statemachine sm) {
    try {
      final String mchName = sm.getComment();
      EMFRodinDB emfRodinDB = new EMFRodinDB();
      String prjName = emfRodinDB.getProjectName(sm);
      IEventBProject eBPrj = EventBUtils.getEventBProject(prjName);
      IRodinProject rdPrj = eBPrj.getRodinProject();
      IMachineRoot[] mchRoots = rdPrj.<IMachineRoot>getRootElementsOfType(MachineRoot.ELEMENT_TYPE);
      for (final IMachineRoot mchRoot : mchRoots) {
        {
          EventBElement mch = emfRodinDB.loadEventBComponent(mchRoot);
          String _name = ((Machine) mch).getName();
          boolean _equals = Objects.equal(_name, mchName);
          if (_equals) {
            return ((Machine) mch);
          }
        }
      }
      return null;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

/**
 * Copyright (c) 2020 University of Southampton.
 * 
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0/
 * 
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *  University of Southampton - initial API and implementation
 */
package ac.soton.xumlb.generator;

import ac.soton.emf.translator.TranslatorFactory;
import ac.soton.eventb.emf.diagrams.Diagram;
import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.xeventb.xmachine.IContainmentGenerator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eventb.emf.core.Annotation;
import org.eventb.emf.core.CoreFactory;
import org.eventb.emf.core.machine.Machine;

/**
 * @author htson - Initial implementation
 * @version 0.1
 * @see IContainmentGenerator
 * @since 0.1
 */
@SuppressWarnings("all")
public class StatemachineContainmentGenerator implements IContainmentGenerator {
  public StatemachineContainmentGenerator() {
  }
  
  @Override
  public void generate(final Machine mch, final Diagram containedComponent, final TransactionalEditingDomain editingDomain) {
    try {
      final Statemachine stm = ((Statemachine) containedComponent);
      final Annotation annot = CoreFactory.eINSTANCE.createAnnotation();
      annot.setSource("ac.soton.diagrams.translationTarget");
      annot.getReferences().add(mch);
      final RecordingCommand command = new RecordingCommand(editingDomain, "Set Annotations") {
        @Override
        public void doExecute() {
          stm.getAnnotations().clear();
          stm.getAnnotations().add(annot);
        }
      };
      boolean _canExecute = command.canExecute();
      if (_canExecute) {
        editingDomain.getCommandStack().execute(command);
      }
      final String containmentCommandId = "ac.soton.eventb.emf.diagrams.generator.translateToEventB";
      final TranslatorFactory factory = TranslatorFactory.getFactory();
      boolean _canTranslate = factory.canTranslate(containmentCommandId, containedComponent.eClass());
      if (_canTranslate) {
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        IProgressMonitor monitor = ((IProgressMonitor) _nullProgressMonitor);
        factory.translate(editingDomain, containedComponent, containmentCommandId, monitor);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

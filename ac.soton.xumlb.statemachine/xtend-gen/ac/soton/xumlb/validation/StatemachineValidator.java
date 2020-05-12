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
package ac.soton.xumlb.validation;

import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.xumlb.validation.AbstractStatemachineValidator;
import org.eclipse.xtext.validation.Check;

/**
 * <p>
 * StateMachine validator, provides custom validation rules for the xtext machine file.
 * </p>
 * 
 * @author dd4g12
 * @version 0.1
 * @since 1.0
 */
@SuppressWarnings("all")
public class StatemachineValidator extends AbstractStatemachineValidator {
  @Check
  public Object checkAnnotates(final Statemachine sm) {
    return null;
  }
}

package ac.soton.xumlb;

import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;

public class StatemachineQualifiedNameProvider  extends DefaultDeclarativeQualifiedNameProvider {
	QualifiedName qualifiedName(Event evt){
//		String projName= getProjectName(mch);
		String evtName = evt.getName();
		String mchName = "";
		Object cont = evt.eContainer();
		if(cont instanceof Machine)
			mchName = ((Machine)cont).getName();
			
		return QualifiedName.create(mchName,evtName);
	}

}

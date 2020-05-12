package ac.soton.xumlb;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Internal;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.diagnostics.IDiagnosticProducer;
import org.eclipse.xtext.linking.lazy.LazyLinker;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

import com.google.common.collect.Multimap;

import ac.soton.eventb.statemachines.AbstractNode;
import ac.soton.eventb.statemachines.State;
import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.Transition;
import ac.soton.eventb.statemachines.impl.StateImpl;
import ac.soton.eventb.statemachines.impl.TransitionImpl;
import ac.soton.eventb.statemachines.StatemachinesPackage;
import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;

public class XStatemachineLazyLinker extends LazyLinker {
//	@Override
//	protected void installProxies(EObject obj, IDiagnosticProducer producer,
//			Multimap<EStructuralFeature.Setting, INode> settingsToLink) {
//		 super.installProxies(obj, producer, settingsToLink);
//	      if(obj.eClass().getEStructuralFeature("target")!=null)
//	         {
//	         //Of course, you can use NodeModelUtils here.
//	    	  
////	         obj.eSet(obj.eClass().getEStructuralFeature("incoming"), obj.eClass().getEStructuralFeature("target"));
//	    	  
//	    	  EStructuralFeature targetFeature = obj.eClass().getEStructuralFeature("target");
////	    	 if( targetFeature.eIsProxy()) {
//	    		 Internal in = (Internal) targetFeature;
//	    		 EReference eOpposite = in.getEOpposite();
//	    		 if(eOpposite.eIsProxy())
//	    			 System.out.println("proxy");
//	    		 else
//	    			 System.out.println("not proxy");
//	    		 String name = eOpposite.getName();
//	    		 
////	              }
//	    	 
//	    	  TransitionImpl t = (TransitionImpl) obj;
//	    	
//	    	  StateImpl s = (StateImpl) t.getTarget();
//	    	  
//
//	    	  s.eSet(s.eClass().getEStructuralFeature("incoming"),t);
//	    	 s.getName();
//	        
//
////	    	  Resource res = obj2.eResource();
////	    	  EObject cont = obj2.eContainer();
////	    	  
////	    	  obj2.eSet(obj2.eClass().getEStructuralFeature("incoming"), obj.eClass().getEStructuralFeature("target"));
//	         }
//	}
	
//	@Override
//	protected EObject createProxy(EObject obj, INode node, EReference eRef) {
//            State s = (State) ((Transition)obj).eContainer();
//			Statemachine fsm = (Statemachine) s.eContainer();
//			for (State  state : fsm.getOwnedState())
//				if(state.getName().equals(node.getText())){
//					return state;
//				}
//
//		return super.createProxy(obj, node, eRef);
//	}
	
	@Override
	protected void clearReference(EObject obj, EReference ref) {
		 if (obj instanceof Transition && ref == CoreextensionPackage.Literals.EVENT_BEVENT_GROUP__ELABORATES)
		//if (ref == StatemachinesPackage.Literals.TRANSITION)
			super.clearReference(obj, ref);
	}
}

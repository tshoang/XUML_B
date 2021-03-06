/*
 * generated by Xtext 2.21.0
 */
package ac.soton.xumlb.ide.contentassist.antlr;

import ac.soton.xumlb.ide.contentassist.antlr.internal.InternalStatemachineParser;
import ac.soton.xumlb.services.StatemachineGrammarAccess;
import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class StatemachineParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(StatemachineGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, StatemachineGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getAbstractNodeAccess().getAlternatives(), "rule__AbstractNode__Alternatives");
			builder.put(grammarAccess.getEStringAccess().getAlternatives(), "rule__EString__Alternatives");
			builder.put(grammarAccess.getXComplexTypeAccess().getAlternatives(), "rule__XComplexType__Alternatives");
			builder.put(grammarAccess.getEVENT_B_BUILDIN_TYPEAccess().getAlternatives(), "rule__EVENT_B_BUILDIN_TYPE__Alternatives");
			builder.put(grammarAccess.getXFormulaAccess().getAlternatives(), "rule__XFormula__Alternatives");
			builder.put(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getAlternatives(), "rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives");
			builder.put(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getAlternatives(), "rule__EVENTB_PREDICATE_SYMBOLS__Alternatives");
			builder.put(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getAlternatives(), "rule__EVENTB_EXPRESSION_SYMBOLS__Alternatives");
			builder.put(grammarAccess.getTranslationKindAccess().getAlternatives(), "rule__TranslationKind__Alternatives");
			builder.put(grammarAccess.getStatemachineAccess().getGroup(), "rule__Statemachine__Group__0");
			builder.put(grammarAccess.getStatemachineAccess().getGroup_5(), "rule__Statemachine__Group_5__0");
			builder.put(grammarAccess.getStatemachineAccess().getGroup_6(), "rule__Statemachine__Group_6__0");
			builder.put(grammarAccess.getStatemachineAccess().getGroup_7(), "rule__Statemachine__Group_7__0");
			builder.put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
			builder.put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
			builder.put(grammarAccess.getTransitionAccess().getGroup(), "rule__Transition__Group__0");
			builder.put(grammarAccess.getTransitionAccess().getGroup_1(), "rule__Transition__Group_1__0");
			builder.put(grammarAccess.getTransitionAccess().getGroup_7(), "rule__Transition__Group_7__0");
			builder.put(grammarAccess.getTransitionAccess().getGroup_7_2(), "rule__Transition__Group_7_2__0");
			builder.put(grammarAccess.getTransitionAccess().getGroup_8(), "rule__Transition__Group_8__0");
			builder.put(grammarAccess.getTransitionAccess().getGroup_9(), "rule__Transition__Group_9__0");
			builder.put(grammarAccess.getTransitionAccess().getGroup_10(), "rule__Transition__Group_10__0");
			builder.put(grammarAccess.getTypedParameterAccess().getGroup(), "rule__TypedParameter__Group__0");
			builder.put(grammarAccess.getXTypeAccess().getGroup(), "rule__XType__Group__0");
			builder.put(grammarAccess.getXTypeAccess().getGroup_1(), "rule__XType__Group_1__0");
			builder.put(grammarAccess.getXComplexTypeAccess().getGroup_0(), "rule__XComplexType__Group_0__0");
			builder.put(grammarAccess.getGuardAccess().getGroup(), "rule__Guard__Group__0");
			builder.put(grammarAccess.getActionAccess().getGroup(), "rule__Action__Group__0");
			builder.put(grammarAccess.getWitnessAccess().getGroup(), "rule__Witness__Group__0");
			builder.put(grammarAccess.getStateAccess().getGroup(), "rule__State__Group__0");
			builder.put(grammarAccess.getStateAccess().getGroup_2(), "rule__State__Group_2__0");
			builder.put(grammarAccess.getStateAccess().getGroup_3(), "rule__State__Group_3__0");
			builder.put(grammarAccess.getStateAccess().getGroup_4(), "rule__State__Group_4__0");
			builder.put(grammarAccess.getStateAccess().getGroup_5(), "rule__State__Group_5__0");
			builder.put(grammarAccess.getStateAccess().getGroup_6(), "rule__State__Group_6__0");
			builder.put(grammarAccess.getInvariantAccess().getGroup(), "rule__Invariant__Group__0");
			builder.put(grammarAccess.getInitialAccess().getGroup(), "rule__Initial__Group__0");
			builder.put(grammarAccess.getFinalAccess().getGroup(), "rule__Final__Group__0");
			builder.put(grammarAccess.getAnyAccess().getGroup(), "rule__Any__Group__0");
			builder.put(grammarAccess.getJunctionAccess().getGroup(), "rule__Junction__Group__0");
			builder.put(grammarAccess.getForkAccess().getGroup(), "rule__Fork__Group__0");
			builder.put(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getGroup_32(), "rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0");
			builder.put(grammarAccess.getStatemachineAccess().getNameAssignment_1(), "rule__Statemachine__NameAssignment_1");
			builder.put(grammarAccess.getStatemachineAccess().getTranslationAssignment_3(), "rule__Statemachine__TranslationAssignment_3");
			builder.put(grammarAccess.getStatemachineAccess().getCommentAssignment_5_1(), "rule__Statemachine__CommentAssignment_5_1");
			builder.put(grammarAccess.getStatemachineAccess().getRefinesAssignment_6_1(), "rule__Statemachine__RefinesAssignment_6_1");
			builder.put(grammarAccess.getStatemachineAccess().getInstancesAssignment_7_1(), "rule__Statemachine__InstancesAssignment_7_1");
			builder.put(grammarAccess.getStatemachineAccess().getSelfNameAssignment_7_3(), "rule__Statemachine__SelfNameAssignment_7_3");
			builder.put(grammarAccess.getStatemachineAccess().getNodesAssignment_8(), "rule__Statemachine__NodesAssignment_8");
			builder.put(grammarAccess.getStatemachineAccess().getTransitionsAssignment_9(), "rule__Statemachine__TransitionsAssignment_9");
			builder.put(grammarAccess.getTransitionAccess().getElaboratesAssignment_1_1(), "rule__Transition__ElaboratesAssignment_1_1");
			builder.put(grammarAccess.getTransitionAccess().getExtendedAssignment_2(), "rule__Transition__ExtendedAssignment_2");
			builder.put(grammarAccess.getTransitionAccess().getSourceAssignment_4(), "rule__Transition__SourceAssignment_4");
			builder.put(grammarAccess.getTransitionAccess().getTargetAssignment_6(), "rule__Transition__TargetAssignment_6");
			builder.put(grammarAccess.getTransitionAccess().getParametersAssignment_7_1(), "rule__Transition__ParametersAssignment_7_1");
			builder.put(grammarAccess.getTransitionAccess().getParametersAssignment_7_2_1(), "rule__Transition__ParametersAssignment_7_2_1");
			builder.put(grammarAccess.getTransitionAccess().getGuardsAssignment_8_1(), "rule__Transition__GuardsAssignment_8_1");
			builder.put(grammarAccess.getTransitionAccess().getActionsAssignment_9_1(), "rule__Transition__ActionsAssignment_9_1");
			builder.put(grammarAccess.getTransitionAccess().getWitnessesAssignment_10_1(), "rule__Transition__WitnessesAssignment_10_1");
			builder.put(grammarAccess.getTypedParameterAccess().getNameAssignment_0(), "rule__TypedParameter__NameAssignment_0");
			builder.put(grammarAccess.getTypedParameterAccess().getTypeAssignment_2(), "rule__TypedParameter__TypeAssignment_2");
			builder.put(grammarAccess.getGuardAccess().getTheoremAssignment_0(), "rule__Guard__TheoremAssignment_0");
			builder.put(grammarAccess.getGuardAccess().getNameAssignment_1(), "rule__Guard__NameAssignment_1");
			builder.put(grammarAccess.getGuardAccess().getPredicateAssignment_2(), "rule__Guard__PredicateAssignment_2");
			builder.put(grammarAccess.getActionAccess().getNameAssignment_0(), "rule__Action__NameAssignment_0");
			builder.put(grammarAccess.getActionAccess().getActionAssignment_1(), "rule__Action__ActionAssignment_1");
			builder.put(grammarAccess.getWitnessAccess().getNameAssignment_0(), "rule__Witness__NameAssignment_0");
			builder.put(grammarAccess.getWitnessAccess().getPredicateAssignment_1(), "rule__Witness__PredicateAssignment_1");
			builder.put(grammarAccess.getStateAccess().getNameAssignment_1(), "rule__State__NameAssignment_1");
			builder.put(grammarAccess.getStateAccess().getRefinesAssignment_2_1(), "rule__State__RefinesAssignment_2_1");
			builder.put(grammarAccess.getStateAccess().getStatemachinesAssignment_3_2(), "rule__State__StatemachinesAssignment_3_2");
			builder.put(grammarAccess.getStateAccess().getStatemachinesAssignment_3_3(), "rule__State__StatemachinesAssignment_3_3");
			builder.put(grammarAccess.getStateAccess().getInvariantsAssignment_4_1(), "rule__State__InvariantsAssignment_4_1");
			builder.put(grammarAccess.getStateAccess().getEntryActionsAssignment_5_1(), "rule__State__EntryActionsAssignment_5_1");
			builder.put(grammarAccess.getStateAccess().getExitActionsAssignment_6_1(), "rule__State__ExitActionsAssignment_6_1");
			builder.put(grammarAccess.getInvariantAccess().getTheoremAssignment_0(), "rule__Invariant__TheoremAssignment_0");
			builder.put(grammarAccess.getInvariantAccess().getNameAssignment_1(), "rule__Invariant__NameAssignment_1");
			builder.put(grammarAccess.getInvariantAccess().getPredicateAssignment_2(), "rule__Invariant__PredicateAssignment_2");
			builder.put(grammarAccess.getInitialAccess().getNameAssignment_1(), "rule__Initial__NameAssignment_1");
			builder.put(grammarAccess.getFinalAccess().getNameAssignment_1(), "rule__Final__NameAssignment_1");
			builder.put(grammarAccess.getAnyAccess().getNameAssignment_1(), "rule__Any__NameAssignment_1");
			builder.put(grammarAccess.getJunctionAccess().getNameAssignment_1(), "rule__Junction__NameAssignment_1");
			builder.put(grammarAccess.getForkAccess().getNameAssignment_1(), "rule__Fork__NameAssignment_1");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private StatemachineGrammarAccess grammarAccess;

	@Override
	protected InternalStatemachineParser createParser() {
		InternalStatemachineParser result = new InternalStatemachineParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public StatemachineGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(StatemachineGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}

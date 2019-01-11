package ac.soton.xumlb.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import ac.soton.xumlb.services.StatemachineGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalStatemachineParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_XLABEL", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'statemachine'", "'('", "')'", "'refines'", "'instances'", "'selfName'", "'transition'", "'elaborates'", "'extended'", "'target'", "'source'", "'any'", "','", "'where'", "'then'", "'with'", "'end'", "':'", "'\\u00D7'", "'\\u2119'", "'BOOL'", "'\\u2124'", "'theorem'", "'State'", "'statemachines'", "'begin'", "'invariants'", "'entryActions'", "'exitActions'", "'Initial'", "'Final'", "'Any'", "'Junction'", "'Fork'", "'FALSE'", "'TRUE'", "'bool'", "'card'", "'dom'", "'finite'", "'id'", "'inter'", "'max'", "'min'", "'mod'", "'pred'", "'prj1'", "'prj2'", "'ran'", "'succ'", "'union'", "'\\u21151'", "'\\u2115'", "'\\u21191'", "'\\u21D4'", "'\\u21D2'", "'\\u2227'", "'&'", "'\\u2228'", "'\\u00AC'", "'\\u22A4'", "'\\u22A5'", "'\\u2200'", "'!'", "'\\u2203'", "'#'", "'\\u00B7'", "'.'", "'='", "'\\u2260'", "'\\u2264'", "'<'", "'\\u2265'", "'>'", "'\\u2208'", "'\\u2209'", "'\\u2282'", "'\\u2284'", "'\\u2286'", "'\\u2288'", "'partition'", "'\\u2194'", "'\\uE100'", "'\\uE101'", "'\\uE102'", "'\\u21F8'", "'\\u2192'", "'\\u2914'", "'\\u21A3'", "'\\u2900'", "'\\u21A0'", "'\\u2916'", "'{'", "'}'", "'\\u21A6'", "'\\u2205'", "'\\u2229'", "'\\u222A'", "'\\u2216'", "'['", "']'", "'\\uE103'", "'\\u2218'", "';'", "'\\u2297'", "'\\u2225'", "'\\u223C'", "'\\u25C1'", "'\\u2A64'", "'\\u25B7'", "'\\u2A65'", "'\\u03BB'", "'%'", "'\\u22C2'", "'\\u22C3'", "'\\u2223'", "'\\u2025'", "'+'", "'\\u2212'", "'-'", "'\\u2217'", "'*'", "'\\u00F7'", "'/'", "'^'", "'\\\\'", "'enumeration'", "'variables'", "'REFINEDVAR'"
    };
    public static final int T__50=50;
    public static final int T__140=140;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__137=137;
    public static final int T__52=52;
    public static final int T__136=136;
    public static final int T__53=53;
    public static final int T__139=139;
    public static final int T__54=54;
    public static final int T__138=138;
    public static final int T__133=133;
    public static final int T__132=132;
    public static final int T__60=60;
    public static final int T__135=135;
    public static final int T__61=61;
    public static final int T__134=134;
    public static final int RULE_ID=4;
    public static final int T__131=131;
    public static final int T__130=130;
    public static final int RULE_INT=7;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__67=67;
    public static final int T__129=129;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__126=126;
    public static final int T__63=63;
    public static final int T__125=125;
    public static final int T__64=64;
    public static final int T__128=128;
    public static final int T__65=65;
    public static final int T__127=127;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int RULE_XLABEL=6;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__99=99;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__122=122;
    public static final int T__70=70;
    public static final int T__121=121;
    public static final int T__71=71;
    public static final int T__124=124;
    public static final int T__72=72;
    public static final int T__123=123;
    public static final int T__120=120;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__77=77;
    public static final int T__119=119;
    public static final int T__78=78;
    public static final int T__118=118;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int T__75=75;
    public static final int T__117=117;
    public static final int T__76=76;
    public static final int T__116=116;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalStatemachineParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalStatemachineParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalStatemachineParser.tokenNames; }
    public String getGrammarFileName() { return "InternalStatemachine.g"; }



     	private StatemachineGrammarAccess grammarAccess;

        public InternalStatemachineParser(TokenStream input, StatemachineGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Statemachine";
       	}

       	@Override
       	protected StatemachineGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleStatemachine"
    // InternalStatemachine.g:65:1: entryRuleStatemachine returns [EObject current=null] : iv_ruleStatemachine= ruleStatemachine EOF ;
    public final EObject entryRuleStatemachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatemachine = null;


        try {
            // InternalStatemachine.g:65:53: (iv_ruleStatemachine= ruleStatemachine EOF )
            // InternalStatemachine.g:66:2: iv_ruleStatemachine= ruleStatemachine EOF
            {
             newCompositeNode(grammarAccess.getStatemachineRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStatemachine=ruleStatemachine();

            state._fsp--;

             current =iv_ruleStatemachine; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatemachine"


    // $ANTLR start "ruleStatemachine"
    // InternalStatemachine.g:72:1: ruleStatemachine returns [EObject current=null] : (otherlv_0= 'statemachine' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_translation_3_0= ruleTranslationKind ) ) otherlv_4= ')' (otherlv_5= 'refines' ( ( ruleEString ) ) )? (otherlv_7= 'instances' ( ( ruleEString ) ) otherlv_9= 'selfName' ( (lv_selfName_10_0= ruleEString ) ) )? ( (lv_nodes_11_0= ruleAbstractNode ) )* ( (lv_transitions_12_0= ruleTransition ) )* ) ;
    public final EObject ruleStatemachine() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Enumerator lv_translation_3_0 = null;

        AntlrDatatypeRuleToken lv_selfName_10_0 = null;

        EObject lv_nodes_11_0 = null;

        EObject lv_transitions_12_0 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:78:2: ( (otherlv_0= 'statemachine' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_translation_3_0= ruleTranslationKind ) ) otherlv_4= ')' (otherlv_5= 'refines' ( ( ruleEString ) ) )? (otherlv_7= 'instances' ( ( ruleEString ) ) otherlv_9= 'selfName' ( (lv_selfName_10_0= ruleEString ) ) )? ( (lv_nodes_11_0= ruleAbstractNode ) )* ( (lv_transitions_12_0= ruleTransition ) )* ) )
            // InternalStatemachine.g:79:2: (otherlv_0= 'statemachine' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_translation_3_0= ruleTranslationKind ) ) otherlv_4= ')' (otherlv_5= 'refines' ( ( ruleEString ) ) )? (otherlv_7= 'instances' ( ( ruleEString ) ) otherlv_9= 'selfName' ( (lv_selfName_10_0= ruleEString ) ) )? ( (lv_nodes_11_0= ruleAbstractNode ) )* ( (lv_transitions_12_0= ruleTransition ) )* )
            {
            // InternalStatemachine.g:79:2: (otherlv_0= 'statemachine' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_translation_3_0= ruleTranslationKind ) ) otherlv_4= ')' (otherlv_5= 'refines' ( ( ruleEString ) ) )? (otherlv_7= 'instances' ( ( ruleEString ) ) otherlv_9= 'selfName' ( (lv_selfName_10_0= ruleEString ) ) )? ( (lv_nodes_11_0= ruleAbstractNode ) )* ( (lv_transitions_12_0= ruleTransition ) )* )
            // InternalStatemachine.g:80:3: otherlv_0= 'statemachine' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_translation_3_0= ruleTranslationKind ) ) otherlv_4= ')' (otherlv_5= 'refines' ( ( ruleEString ) ) )? (otherlv_7= 'instances' ( ( ruleEString ) ) otherlv_9= 'selfName' ( (lv_selfName_10_0= ruleEString ) ) )? ( (lv_nodes_11_0= ruleAbstractNode ) )* ( (lv_transitions_12_0= ruleTransition ) )*
            {
            otherlv_0=(Token)match(input,12,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getStatemachineAccess().getStatemachineKeyword_0());
            		
            // InternalStatemachine.g:84:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalStatemachine.g:85:4: (lv_name_1_0= RULE_ID )
            {
            // InternalStatemachine.g:85:4: (lv_name_1_0= RULE_ID )
            // InternalStatemachine.g:86:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getStatemachineAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStatemachineRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"ac.soton.xumlb.Statemachine.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getStatemachineAccess().getLeftParenthesisKeyword_2());
            		
            // InternalStatemachine.g:106:3: ( (lv_translation_3_0= ruleTranslationKind ) )
            // InternalStatemachine.g:107:4: (lv_translation_3_0= ruleTranslationKind )
            {
            // InternalStatemachine.g:107:4: (lv_translation_3_0= ruleTranslationKind )
            // InternalStatemachine.g:108:5: lv_translation_3_0= ruleTranslationKind
            {

            					newCompositeNode(grammarAccess.getStatemachineAccess().getTranslationTranslationKindEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_6);
            lv_translation_3_0=ruleTranslationKind();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStatemachineRule());
            					}
            					set(
            						current,
            						"translation",
            						lv_translation_3_0,
            						"ac.soton.xumlb.Statemachine.TranslationKind");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,14,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getStatemachineAccess().getRightParenthesisKeyword_4());
            		
            // InternalStatemachine.g:129:3: (otherlv_5= 'refines' ( ( ruleEString ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==15) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalStatemachine.g:130:4: otherlv_5= 'refines' ( ( ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,15,FOLLOW_8); 

                    				newLeafNode(otherlv_5, grammarAccess.getStatemachineAccess().getRefinesKeyword_5_0());
                    			
                    // InternalStatemachine.g:134:4: ( ( ruleEString ) )
                    // InternalStatemachine.g:135:5: ( ruleEString )
                    {
                    // InternalStatemachine.g:135:5: ( ruleEString )
                    // InternalStatemachine.g:136:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStatemachineRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getStatemachineAccess().getRefinesStatemachineCrossReference_5_1_0());
                    					
                    pushFollow(FOLLOW_9);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalStatemachine.g:151:3: (otherlv_7= 'instances' ( ( ruleEString ) ) otherlv_9= 'selfName' ( (lv_selfName_10_0= ruleEString ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==16) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalStatemachine.g:152:4: otherlv_7= 'instances' ( ( ruleEString ) ) otherlv_9= 'selfName' ( (lv_selfName_10_0= ruleEString ) )
                    {
                    otherlv_7=(Token)match(input,16,FOLLOW_8); 

                    				newLeafNode(otherlv_7, grammarAccess.getStatemachineAccess().getInstancesKeyword_6_0());
                    			
                    // InternalStatemachine.g:156:4: ( ( ruleEString ) )
                    // InternalStatemachine.g:157:5: ( ruleEString )
                    {
                    // InternalStatemachine.g:157:5: ( ruleEString )
                    // InternalStatemachine.g:158:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStatemachineRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getStatemachineAccess().getInstancesEventBNamedCommentedElementCrossReference_6_1_0());
                    					
                    pushFollow(FOLLOW_10);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_9=(Token)match(input,17,FOLLOW_8); 

                    				newLeafNode(otherlv_9, grammarAccess.getStatemachineAccess().getSelfNameKeyword_6_2());
                    			
                    // InternalStatemachine.g:176:4: ( (lv_selfName_10_0= ruleEString ) )
                    // InternalStatemachine.g:177:5: (lv_selfName_10_0= ruleEString )
                    {
                    // InternalStatemachine.g:177:5: (lv_selfName_10_0= ruleEString )
                    // InternalStatemachine.g:178:6: lv_selfName_10_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getStatemachineAccess().getSelfNameEStringParserRuleCall_6_3_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_selfName_10_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStatemachineRule());
                    						}
                    						set(
                    							current,
                    							"selfName",
                    							lv_selfName_10_0,
                    							"ac.soton.xumlb.Statemachine.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalStatemachine.g:196:3: ( (lv_nodes_11_0= ruleAbstractNode ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==35||(LA3_0>=41 && LA3_0<=45)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalStatemachine.g:197:4: (lv_nodes_11_0= ruleAbstractNode )
            	    {
            	    // InternalStatemachine.g:197:4: (lv_nodes_11_0= ruleAbstractNode )
            	    // InternalStatemachine.g:198:5: lv_nodes_11_0= ruleAbstractNode
            	    {

            	    					newCompositeNode(grammarAccess.getStatemachineAccess().getNodesAbstractNodeParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_11);
            	    lv_nodes_11_0=ruleAbstractNode();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getStatemachineRule());
            	    					}
            	    					add(
            	    						current,
            	    						"nodes",
            	    						lv_nodes_11_0,
            	    						"ac.soton.xumlb.Statemachine.AbstractNode");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // InternalStatemachine.g:215:3: ( (lv_transitions_12_0= ruleTransition ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==18) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalStatemachine.g:216:4: (lv_transitions_12_0= ruleTransition )
            	    {
            	    // InternalStatemachine.g:216:4: (lv_transitions_12_0= ruleTransition )
            	    // InternalStatemachine.g:217:5: lv_transitions_12_0= ruleTransition
            	    {

            	    					newCompositeNode(grammarAccess.getStatemachineAccess().getTransitionsTransitionParserRuleCall_8_0());
            	    				
            	    pushFollow(FOLLOW_12);
            	    lv_transitions_12_0=ruleTransition();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getStatemachineRule());
            	    					}
            	    					add(
            	    						current,
            	    						"transitions",
            	    						lv_transitions_12_0,
            	    						"ac.soton.xumlb.Statemachine.Transition");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatemachine"


    // $ANTLR start "entryRuleAbstractNode"
    // InternalStatemachine.g:238:1: entryRuleAbstractNode returns [EObject current=null] : iv_ruleAbstractNode= ruleAbstractNode EOF ;
    public final EObject entryRuleAbstractNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractNode = null;


        try {
            // InternalStatemachine.g:238:53: (iv_ruleAbstractNode= ruleAbstractNode EOF )
            // InternalStatemachine.g:239:2: iv_ruleAbstractNode= ruleAbstractNode EOF
            {
             newCompositeNode(grammarAccess.getAbstractNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAbstractNode=ruleAbstractNode();

            state._fsp--;

             current =iv_ruleAbstractNode; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractNode"


    // $ANTLR start "ruleAbstractNode"
    // InternalStatemachine.g:245:1: ruleAbstractNode returns [EObject current=null] : (this_State_0= ruleState | this_Initial_1= ruleInitial | this_Final_2= ruleFinal | this_Any_3= ruleAny | this_Junction_4= ruleJunction | this_Fork_5= ruleFork ) ;
    public final EObject ruleAbstractNode() throws RecognitionException {
        EObject current = null;

        EObject this_State_0 = null;

        EObject this_Initial_1 = null;

        EObject this_Final_2 = null;

        EObject this_Any_3 = null;

        EObject this_Junction_4 = null;

        EObject this_Fork_5 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:251:2: ( (this_State_0= ruleState | this_Initial_1= ruleInitial | this_Final_2= ruleFinal | this_Any_3= ruleAny | this_Junction_4= ruleJunction | this_Fork_5= ruleFork ) )
            // InternalStatemachine.g:252:2: (this_State_0= ruleState | this_Initial_1= ruleInitial | this_Final_2= ruleFinal | this_Any_3= ruleAny | this_Junction_4= ruleJunction | this_Fork_5= ruleFork )
            {
            // InternalStatemachine.g:252:2: (this_State_0= ruleState | this_Initial_1= ruleInitial | this_Final_2= ruleFinal | this_Any_3= ruleAny | this_Junction_4= ruleJunction | this_Fork_5= ruleFork )
            int alt5=6;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt5=1;
                }
                break;
            case 41:
                {
                alt5=2;
                }
                break;
            case 42:
                {
                alt5=3;
                }
                break;
            case 43:
                {
                alt5=4;
                }
                break;
            case 44:
                {
                alt5=5;
                }
                break;
            case 45:
                {
                alt5=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalStatemachine.g:253:3: this_State_0= ruleState
                    {

                    			newCompositeNode(grammarAccess.getAbstractNodeAccess().getStateParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_State_0=ruleState();

                    state._fsp--;


                    			current = this_State_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalStatemachine.g:262:3: this_Initial_1= ruleInitial
                    {

                    			newCompositeNode(grammarAccess.getAbstractNodeAccess().getInitialParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Initial_1=ruleInitial();

                    state._fsp--;


                    			current = this_Initial_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalStatemachine.g:271:3: this_Final_2= ruleFinal
                    {

                    			newCompositeNode(grammarAccess.getAbstractNodeAccess().getFinalParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Final_2=ruleFinal();

                    state._fsp--;


                    			current = this_Final_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalStatemachine.g:280:3: this_Any_3= ruleAny
                    {

                    			newCompositeNode(grammarAccess.getAbstractNodeAccess().getAnyParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Any_3=ruleAny();

                    state._fsp--;


                    			current = this_Any_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalStatemachine.g:289:3: this_Junction_4= ruleJunction
                    {

                    			newCompositeNode(grammarAccess.getAbstractNodeAccess().getJunctionParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_Junction_4=ruleJunction();

                    state._fsp--;


                    			current = this_Junction_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalStatemachine.g:298:3: this_Fork_5= ruleFork
                    {

                    			newCompositeNode(grammarAccess.getAbstractNodeAccess().getForkParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_Fork_5=ruleFork();

                    state._fsp--;


                    			current = this_Fork_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractNode"


    // $ANTLR start "entryRuleEString"
    // InternalStatemachine.g:310:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalStatemachine.g:310:47: (iv_ruleEString= ruleEString EOF )
            // InternalStatemachine.g:311:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalStatemachine.g:317:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalStatemachine.g:323:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalStatemachine.g:324:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalStatemachine.g:324:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_STRING) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_ID) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalStatemachine.g:325:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalStatemachine.g:333:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_1);
                    		

                    			newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleTransition"
    // InternalStatemachine.g:344:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // InternalStatemachine.g:344:51: (iv_ruleTransition= ruleTransition EOF )
            // InternalStatemachine.g:345:2: iv_ruleTransition= ruleTransition EOF
            {
             newCompositeNode(grammarAccess.getTransitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTransition=ruleTransition();

            state._fsp--;

             current =iv_ruleTransition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransition"


    // $ANTLR start "ruleTransition"
    // InternalStatemachine.g:351:1: ruleTransition returns [EObject current=null] : (otherlv_0= 'transition' (otherlv_1= 'elaborates' ( ( ruleEString ) ) ( ( ruleEString ) )* )? ( (lv_extended_4_0= 'extended' ) )? otherlv_5= 'target' ( ( ruleEString ) ) otherlv_7= 'source' ( ( ruleEString ) ) (otherlv_9= 'any' ( (lv_parameters_10_0= ruleTypedParameter ) ) (otherlv_11= ',' ( (lv_parameters_12_0= ruleTypedParameter ) ) )* )? (otherlv_13= 'where' ( (lv_guards_14_0= ruleGuard ) )+ )? (otherlv_15= 'then' ( (lv_actions_16_0= ruleAction ) )+ )? (otherlv_17= 'with' ( (lv_witnesses_18_0= ruleWitness ) )+ )? otherlv_19= 'end' ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_extended_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        EObject lv_parameters_10_0 = null;

        EObject lv_parameters_12_0 = null;

        EObject lv_guards_14_0 = null;

        EObject lv_actions_16_0 = null;

        EObject lv_witnesses_18_0 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:357:2: ( (otherlv_0= 'transition' (otherlv_1= 'elaborates' ( ( ruleEString ) ) ( ( ruleEString ) )* )? ( (lv_extended_4_0= 'extended' ) )? otherlv_5= 'target' ( ( ruleEString ) ) otherlv_7= 'source' ( ( ruleEString ) ) (otherlv_9= 'any' ( (lv_parameters_10_0= ruleTypedParameter ) ) (otherlv_11= ',' ( (lv_parameters_12_0= ruleTypedParameter ) ) )* )? (otherlv_13= 'where' ( (lv_guards_14_0= ruleGuard ) )+ )? (otherlv_15= 'then' ( (lv_actions_16_0= ruleAction ) )+ )? (otherlv_17= 'with' ( (lv_witnesses_18_0= ruleWitness ) )+ )? otherlv_19= 'end' ) )
            // InternalStatemachine.g:358:2: (otherlv_0= 'transition' (otherlv_1= 'elaborates' ( ( ruleEString ) ) ( ( ruleEString ) )* )? ( (lv_extended_4_0= 'extended' ) )? otherlv_5= 'target' ( ( ruleEString ) ) otherlv_7= 'source' ( ( ruleEString ) ) (otherlv_9= 'any' ( (lv_parameters_10_0= ruleTypedParameter ) ) (otherlv_11= ',' ( (lv_parameters_12_0= ruleTypedParameter ) ) )* )? (otherlv_13= 'where' ( (lv_guards_14_0= ruleGuard ) )+ )? (otherlv_15= 'then' ( (lv_actions_16_0= ruleAction ) )+ )? (otherlv_17= 'with' ( (lv_witnesses_18_0= ruleWitness ) )+ )? otherlv_19= 'end' )
            {
            // InternalStatemachine.g:358:2: (otherlv_0= 'transition' (otherlv_1= 'elaborates' ( ( ruleEString ) ) ( ( ruleEString ) )* )? ( (lv_extended_4_0= 'extended' ) )? otherlv_5= 'target' ( ( ruleEString ) ) otherlv_7= 'source' ( ( ruleEString ) ) (otherlv_9= 'any' ( (lv_parameters_10_0= ruleTypedParameter ) ) (otherlv_11= ',' ( (lv_parameters_12_0= ruleTypedParameter ) ) )* )? (otherlv_13= 'where' ( (lv_guards_14_0= ruleGuard ) )+ )? (otherlv_15= 'then' ( (lv_actions_16_0= ruleAction ) )+ )? (otherlv_17= 'with' ( (lv_witnesses_18_0= ruleWitness ) )+ )? otherlv_19= 'end' )
            // InternalStatemachine.g:359:3: otherlv_0= 'transition' (otherlv_1= 'elaborates' ( ( ruleEString ) ) ( ( ruleEString ) )* )? ( (lv_extended_4_0= 'extended' ) )? otherlv_5= 'target' ( ( ruleEString ) ) otherlv_7= 'source' ( ( ruleEString ) ) (otherlv_9= 'any' ( (lv_parameters_10_0= ruleTypedParameter ) ) (otherlv_11= ',' ( (lv_parameters_12_0= ruleTypedParameter ) ) )* )? (otherlv_13= 'where' ( (lv_guards_14_0= ruleGuard ) )+ )? (otherlv_15= 'then' ( (lv_actions_16_0= ruleAction ) )+ )? (otherlv_17= 'with' ( (lv_witnesses_18_0= ruleWitness ) )+ )? otherlv_19= 'end'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getTransitionAccess().getTransitionKeyword_0());
            		
            // InternalStatemachine.g:363:3: (otherlv_1= 'elaborates' ( ( ruleEString ) ) ( ( ruleEString ) )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==19) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalStatemachine.g:364:4: otherlv_1= 'elaborates' ( ( ruleEString ) ) ( ( ruleEString ) )*
                    {
                    otherlv_1=(Token)match(input,19,FOLLOW_8); 

                    				newLeafNode(otherlv_1, grammarAccess.getTransitionAccess().getElaboratesKeyword_1_0());
                    			
                    // InternalStatemachine.g:368:4: ( ( ruleEString ) )
                    // InternalStatemachine.g:369:5: ( ruleEString )
                    {
                    // InternalStatemachine.g:369:5: ( ruleEString )
                    // InternalStatemachine.g:370:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTransitionRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getTransitionAccess().getElaboratesEventCrossReference_1_1_0());
                    					
                    pushFollow(FOLLOW_14);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalStatemachine.g:384:4: ( ( ruleEString ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>=RULE_ID && LA7_0<=RULE_STRING)) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalStatemachine.g:385:5: ( ruleEString )
                    	    {
                    	    // InternalStatemachine.g:385:5: ( ruleEString )
                    	    // InternalStatemachine.g:386:6: ruleEString
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getTransitionRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getTransitionAccess().getElaboratesEventCrossReference_1_2_0());
                    	    					
                    	    pushFollow(FOLLOW_14);
                    	    ruleEString();

                    	    state._fsp--;


                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalStatemachine.g:401:3: ( (lv_extended_4_0= 'extended' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==20) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalStatemachine.g:402:4: (lv_extended_4_0= 'extended' )
                    {
                    // InternalStatemachine.g:402:4: (lv_extended_4_0= 'extended' )
                    // InternalStatemachine.g:403:5: lv_extended_4_0= 'extended'
                    {
                    lv_extended_4_0=(Token)match(input,20,FOLLOW_15); 

                    					newLeafNode(lv_extended_4_0, grammarAccess.getTransitionAccess().getExtendedExtendedKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTransitionRule());
                    					}
                    					setWithLastConsumed(current, "extended", true, "extended");
                    				

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,21,FOLLOW_8); 

            			newLeafNode(otherlv_5, grammarAccess.getTransitionAccess().getTargetKeyword_3());
            		
            // InternalStatemachine.g:419:3: ( ( ruleEString ) )
            // InternalStatemachine.g:420:4: ( ruleEString )
            {
            // InternalStatemachine.g:420:4: ( ruleEString )
            // InternalStatemachine.g:421:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTransitionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTransitionAccess().getTargetAbstractNodeCrossReference_4_0());
            				
            pushFollow(FOLLOW_16);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,22,FOLLOW_8); 

            			newLeafNode(otherlv_7, grammarAccess.getTransitionAccess().getSourceKeyword_5());
            		
            // InternalStatemachine.g:439:3: ( ( ruleEString ) )
            // InternalStatemachine.g:440:4: ( ruleEString )
            {
            // InternalStatemachine.g:440:4: ( ruleEString )
            // InternalStatemachine.g:441:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTransitionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTransitionAccess().getSourceAbstractNodeCrossReference_6_0());
            				
            pushFollow(FOLLOW_17);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalStatemachine.g:455:3: (otherlv_9= 'any' ( (lv_parameters_10_0= ruleTypedParameter ) ) (otherlv_11= ',' ( (lv_parameters_12_0= ruleTypedParameter ) ) )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==23) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalStatemachine.g:456:4: otherlv_9= 'any' ( (lv_parameters_10_0= ruleTypedParameter ) ) (otherlv_11= ',' ( (lv_parameters_12_0= ruleTypedParameter ) ) )*
                    {
                    otherlv_9=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_9, grammarAccess.getTransitionAccess().getAnyKeyword_7_0());
                    			
                    // InternalStatemachine.g:460:4: ( (lv_parameters_10_0= ruleTypedParameter ) )
                    // InternalStatemachine.g:461:5: (lv_parameters_10_0= ruleTypedParameter )
                    {
                    // InternalStatemachine.g:461:5: (lv_parameters_10_0= ruleTypedParameter )
                    // InternalStatemachine.g:462:6: lv_parameters_10_0= ruleTypedParameter
                    {

                    						newCompositeNode(grammarAccess.getTransitionAccess().getParametersTypedParameterParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_parameters_10_0=ruleTypedParameter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTransitionRule());
                    						}
                    						add(
                    							current,
                    							"parameters",
                    							lv_parameters_10_0,
                    							"ac.soton.xumlb.Statemachine.TypedParameter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalStatemachine.g:479:4: (otherlv_11= ',' ( (lv_parameters_12_0= ruleTypedParameter ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==24) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalStatemachine.g:480:5: otherlv_11= ',' ( (lv_parameters_12_0= ruleTypedParameter ) )
                    	    {
                    	    otherlv_11=(Token)match(input,24,FOLLOW_3); 

                    	    					newLeafNode(otherlv_11, grammarAccess.getTransitionAccess().getCommaKeyword_7_2_0());
                    	    				
                    	    // InternalStatemachine.g:484:5: ( (lv_parameters_12_0= ruleTypedParameter ) )
                    	    // InternalStatemachine.g:485:6: (lv_parameters_12_0= ruleTypedParameter )
                    	    {
                    	    // InternalStatemachine.g:485:6: (lv_parameters_12_0= ruleTypedParameter )
                    	    // InternalStatemachine.g:486:7: lv_parameters_12_0= ruleTypedParameter
                    	    {

                    	    							newCompositeNode(grammarAccess.getTransitionAccess().getParametersTypedParameterParserRuleCall_7_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_18);
                    	    lv_parameters_12_0=ruleTypedParameter();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getTransitionRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"parameters",
                    	    								lv_parameters_12_0,
                    	    								"ac.soton.xumlb.Statemachine.TypedParameter");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalStatemachine.g:505:3: (otherlv_13= 'where' ( (lv_guards_14_0= ruleGuard ) )+ )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==25) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalStatemachine.g:506:4: otherlv_13= 'where' ( (lv_guards_14_0= ruleGuard ) )+
                    {
                    otherlv_13=(Token)match(input,25,FOLLOW_19); 

                    				newLeafNode(otherlv_13, grammarAccess.getTransitionAccess().getWhereKeyword_8_0());
                    			
                    // InternalStatemachine.g:510:4: ( (lv_guards_14_0= ruleGuard ) )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==RULE_XLABEL||LA12_0==34) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalStatemachine.g:511:5: (lv_guards_14_0= ruleGuard )
                    	    {
                    	    // InternalStatemachine.g:511:5: (lv_guards_14_0= ruleGuard )
                    	    // InternalStatemachine.g:512:6: lv_guards_14_0= ruleGuard
                    	    {

                    	    						newCompositeNode(grammarAccess.getTransitionAccess().getGuardsGuardParserRuleCall_8_1_0());
                    	    					
                    	    pushFollow(FOLLOW_20);
                    	    lv_guards_14_0=ruleGuard();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getTransitionRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"guards",
                    	    							lv_guards_14_0,
                    	    							"ac.soton.xumlb.Statemachine.Guard");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt12 >= 1 ) break loop12;
                                EarlyExitException eee =
                                    new EarlyExitException(12, input);
                                throw eee;
                        }
                        cnt12++;
                    } while (true);


                    }
                    break;

            }

            // InternalStatemachine.g:530:3: (otherlv_15= 'then' ( (lv_actions_16_0= ruleAction ) )+ )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==26) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalStatemachine.g:531:4: otherlv_15= 'then' ( (lv_actions_16_0= ruleAction ) )+
                    {
                    otherlv_15=(Token)match(input,26,FOLLOW_21); 

                    				newLeafNode(otherlv_15, grammarAccess.getTransitionAccess().getThenKeyword_9_0());
                    			
                    // InternalStatemachine.g:535:4: ( (lv_actions_16_0= ruleAction ) )+
                    int cnt14=0;
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==RULE_XLABEL) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalStatemachine.g:536:5: (lv_actions_16_0= ruleAction )
                    	    {
                    	    // InternalStatemachine.g:536:5: (lv_actions_16_0= ruleAction )
                    	    // InternalStatemachine.g:537:6: lv_actions_16_0= ruleAction
                    	    {

                    	    						newCompositeNode(grammarAccess.getTransitionAccess().getActionsActionParserRuleCall_9_1_0());
                    	    					
                    	    pushFollow(FOLLOW_22);
                    	    lv_actions_16_0=ruleAction();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getTransitionRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"actions",
                    	    							lv_actions_16_0,
                    	    							"ac.soton.xumlb.Statemachine.Action");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt14 >= 1 ) break loop14;
                                EarlyExitException eee =
                                    new EarlyExitException(14, input);
                                throw eee;
                        }
                        cnt14++;
                    } while (true);


                    }
                    break;

            }

            // InternalStatemachine.g:555:3: (otherlv_17= 'with' ( (lv_witnesses_18_0= ruleWitness ) )+ )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==27) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalStatemachine.g:556:4: otherlv_17= 'with' ( (lv_witnesses_18_0= ruleWitness ) )+
                    {
                    otherlv_17=(Token)match(input,27,FOLLOW_21); 

                    				newLeafNode(otherlv_17, grammarAccess.getTransitionAccess().getWithKeyword_10_0());
                    			
                    // InternalStatemachine.g:560:4: ( (lv_witnesses_18_0= ruleWitness ) )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==RULE_XLABEL) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalStatemachine.g:561:5: (lv_witnesses_18_0= ruleWitness )
                    	    {
                    	    // InternalStatemachine.g:561:5: (lv_witnesses_18_0= ruleWitness )
                    	    // InternalStatemachine.g:562:6: lv_witnesses_18_0= ruleWitness
                    	    {

                    	    						newCompositeNode(grammarAccess.getTransitionAccess().getWitnessesWitnessParserRuleCall_10_1_0());
                    	    					
                    	    pushFollow(FOLLOW_23);
                    	    lv_witnesses_18_0=ruleWitness();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getTransitionRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"witnesses",
                    	    							lv_witnesses_18_0,
                    	    							"ac.soton.xumlb.Statemachine.Witness");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt16 >= 1 ) break loop16;
                                EarlyExitException eee =
                                    new EarlyExitException(16, input);
                                throw eee;
                        }
                        cnt16++;
                    } while (true);


                    }
                    break;

            }

            otherlv_19=(Token)match(input,28,FOLLOW_2); 

            			newLeafNode(otherlv_19, grammarAccess.getTransitionAccess().getEndKeyword_11());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransition"


    // $ANTLR start "entryRuleTypedParameter"
    // InternalStatemachine.g:588:1: entryRuleTypedParameter returns [EObject current=null] : iv_ruleTypedParameter= ruleTypedParameter EOF ;
    public final EObject entryRuleTypedParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedParameter = null;


        try {
            // InternalStatemachine.g:588:55: (iv_ruleTypedParameter= ruleTypedParameter EOF )
            // InternalStatemachine.g:589:2: iv_ruleTypedParameter= ruleTypedParameter EOF
            {
             newCompositeNode(grammarAccess.getTypedParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTypedParameter=ruleTypedParameter();

            state._fsp--;

             current =iv_ruleTypedParameter; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypedParameter"


    // $ANTLR start "ruleTypedParameter"
    // InternalStatemachine.g:595:1: ruleTypedParameter returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleXType ) ) ) ;
    public final EObject ruleTypedParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_type_2_0 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:601:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleXType ) ) ) )
            // InternalStatemachine.g:602:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleXType ) ) )
            {
            // InternalStatemachine.g:602:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleXType ) ) )
            // InternalStatemachine.g:603:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleXType ) )
            {
            // InternalStatemachine.g:603:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalStatemachine.g:604:4: (lv_name_0_0= RULE_ID )
            {
            // InternalStatemachine.g:604:4: (lv_name_0_0= RULE_ID )
            // InternalStatemachine.g:605:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_24); 

            					newLeafNode(lv_name_0_0, grammarAccess.getTypedParameterAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTypedParameterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"ac.soton.xumlb.Statemachine.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,29,FOLLOW_25); 

            			newLeafNode(otherlv_1, grammarAccess.getTypedParameterAccess().getColonKeyword_1());
            		
            // InternalStatemachine.g:625:3: ( (lv_type_2_0= ruleXType ) )
            // InternalStatemachine.g:626:4: (lv_type_2_0= ruleXType )
            {
            // InternalStatemachine.g:626:4: (lv_type_2_0= ruleXType )
            // InternalStatemachine.g:627:5: lv_type_2_0= ruleXType
            {

            					newCompositeNode(grammarAccess.getTypedParameterAccess().getTypeXTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_type_2_0=ruleXType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTypedParameterRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_2_0,
            						"ac.soton.xumlb.Statemachine.XType");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypedParameter"


    // $ANTLR start "entryRuleXType"
    // InternalStatemachine.g:648:1: entryRuleXType returns [String current=null] : iv_ruleXType= ruleXType EOF ;
    public final String entryRuleXType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleXType = null;


        try {
            // InternalStatemachine.g:648:45: (iv_ruleXType= ruleXType EOF )
            // InternalStatemachine.g:649:2: iv_ruleXType= ruleXType EOF
            {
             newCompositeNode(grammarAccess.getXTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXType=ruleXType();

            state._fsp--;

             current =iv_ruleXType.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXType"


    // $ANTLR start "ruleXType"
    // InternalStatemachine.g:655:1: ruleXType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_XComplexType_0= ruleXComplexType (kw= '\\u00D7' this_XType_2= ruleXType )* ) ;
    public final AntlrDatatypeRuleToken ruleXType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_XComplexType_0 = null;

        AntlrDatatypeRuleToken this_XType_2 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:661:2: ( (this_XComplexType_0= ruleXComplexType (kw= '\\u00D7' this_XType_2= ruleXType )* ) )
            // InternalStatemachine.g:662:2: (this_XComplexType_0= ruleXComplexType (kw= '\\u00D7' this_XType_2= ruleXType )* )
            {
            // InternalStatemachine.g:662:2: (this_XComplexType_0= ruleXComplexType (kw= '\\u00D7' this_XType_2= ruleXType )* )
            // InternalStatemachine.g:663:3: this_XComplexType_0= ruleXComplexType (kw= '\\u00D7' this_XType_2= ruleXType )*
            {

            			newCompositeNode(grammarAccess.getXTypeAccess().getXComplexTypeParserRuleCall_0());
            		
            pushFollow(FOLLOW_26);
            this_XComplexType_0=ruleXComplexType();

            state._fsp--;


            			current.merge(this_XComplexType_0);
            		

            			afterParserOrEnumRuleCall();
            		
            // InternalStatemachine.g:673:3: (kw= '\\u00D7' this_XType_2= ruleXType )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==30) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalStatemachine.g:674:4: kw= '\\u00D7' this_XType_2= ruleXType
            	    {
            	    kw=(Token)match(input,30,FOLLOW_25); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getXTypeAccess().getMultiplicationSignKeyword_1_0());
            	    			

            	    				newCompositeNode(grammarAccess.getXTypeAccess().getXTypeParserRuleCall_1_1());
            	    			
            	    pushFollow(FOLLOW_26);
            	    this_XType_2=ruleXType();

            	    state._fsp--;


            	    				current.merge(this_XType_2);
            	    			

            	    				afterParserOrEnumRuleCall();
            	    			

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXType"


    // $ANTLR start "entryRuleXComplexType"
    // InternalStatemachine.g:694:1: entryRuleXComplexType returns [String current=null] : iv_ruleXComplexType= ruleXComplexType EOF ;
    public final String entryRuleXComplexType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleXComplexType = null;


        try {
            // InternalStatemachine.g:694:52: (iv_ruleXComplexType= ruleXComplexType EOF )
            // InternalStatemachine.g:695:2: iv_ruleXComplexType= ruleXComplexType EOF
            {
             newCompositeNode(grammarAccess.getXComplexTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXComplexType=ruleXComplexType();

            state._fsp--;

             current =iv_ruleXComplexType.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXComplexType"


    // $ANTLR start "ruleXComplexType"
    // InternalStatemachine.g:701:1: ruleXComplexType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '\\u2119' kw= '(' this_XType_2= ruleXType kw= ')' ) | this_EVENT_B_BUILDIN_TYPE_4= ruleEVENT_B_BUILDIN_TYPE | this_ID_5= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleXComplexType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_5=null;
        AntlrDatatypeRuleToken this_XType_2 = null;

        AntlrDatatypeRuleToken this_EVENT_B_BUILDIN_TYPE_4 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:707:2: ( ( (kw= '\\u2119' kw= '(' this_XType_2= ruleXType kw= ')' ) | this_EVENT_B_BUILDIN_TYPE_4= ruleEVENT_B_BUILDIN_TYPE | this_ID_5= RULE_ID ) )
            // InternalStatemachine.g:708:2: ( (kw= '\\u2119' kw= '(' this_XType_2= ruleXType kw= ')' ) | this_EVENT_B_BUILDIN_TYPE_4= ruleEVENT_B_BUILDIN_TYPE | this_ID_5= RULE_ID )
            {
            // InternalStatemachine.g:708:2: ( (kw= '\\u2119' kw= '(' this_XType_2= ruleXType kw= ')' ) | this_EVENT_B_BUILDIN_TYPE_4= ruleEVENT_B_BUILDIN_TYPE | this_ID_5= RULE_ID )
            int alt19=3;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt19=1;
                }
                break;
            case 32:
            case 33:
                {
                alt19=2;
                }
                break;
            case RULE_ID:
                {
                alt19=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // InternalStatemachine.g:709:3: (kw= '\\u2119' kw= '(' this_XType_2= ruleXType kw= ')' )
                    {
                    // InternalStatemachine.g:709:3: (kw= '\\u2119' kw= '(' this_XType_2= ruleXType kw= ')' )
                    // InternalStatemachine.g:710:4: kw= '\\u2119' kw= '(' this_XType_2= ruleXType kw= ')'
                    {
                    kw=(Token)match(input,31,FOLLOW_4); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getXComplexTypeAccess().getDoubleStruckCapitalPKeyword_0_0());
                    			
                    kw=(Token)match(input,13,FOLLOW_25); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getXComplexTypeAccess().getLeftParenthesisKeyword_0_1());
                    			

                    				newCompositeNode(grammarAccess.getXComplexTypeAccess().getXTypeParserRuleCall_0_2());
                    			
                    pushFollow(FOLLOW_6);
                    this_XType_2=ruleXType();

                    state._fsp--;


                    				current.merge(this_XType_2);
                    			

                    				afterParserOrEnumRuleCall();
                    			
                    kw=(Token)match(input,14,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getXComplexTypeAccess().getRightParenthesisKeyword_0_3());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalStatemachine.g:737:3: this_EVENT_B_BUILDIN_TYPE_4= ruleEVENT_B_BUILDIN_TYPE
                    {

                    			newCompositeNode(grammarAccess.getXComplexTypeAccess().getEVENT_B_BUILDIN_TYPEParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_EVENT_B_BUILDIN_TYPE_4=ruleEVENT_B_BUILDIN_TYPE();

                    state._fsp--;


                    			current.merge(this_EVENT_B_BUILDIN_TYPE_4);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalStatemachine.g:748:3: this_ID_5= RULE_ID
                    {
                    this_ID_5=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_5);
                    		

                    			newLeafNode(this_ID_5, grammarAccess.getXComplexTypeAccess().getIDTerminalRuleCall_2());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXComplexType"


    // $ANTLR start "entryRuleEVENT_B_BUILDIN_TYPE"
    // InternalStatemachine.g:759:1: entryRuleEVENT_B_BUILDIN_TYPE returns [String current=null] : iv_ruleEVENT_B_BUILDIN_TYPE= ruleEVENT_B_BUILDIN_TYPE EOF ;
    public final String entryRuleEVENT_B_BUILDIN_TYPE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEVENT_B_BUILDIN_TYPE = null;


        try {
            // InternalStatemachine.g:759:60: (iv_ruleEVENT_B_BUILDIN_TYPE= ruleEVENT_B_BUILDIN_TYPE EOF )
            // InternalStatemachine.g:760:2: iv_ruleEVENT_B_BUILDIN_TYPE= ruleEVENT_B_BUILDIN_TYPE EOF
            {
             newCompositeNode(grammarAccess.getEVENT_B_BUILDIN_TYPERule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEVENT_B_BUILDIN_TYPE=ruleEVENT_B_BUILDIN_TYPE();

            state._fsp--;

             current =iv_ruleEVENT_B_BUILDIN_TYPE.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEVENT_B_BUILDIN_TYPE"


    // $ANTLR start "ruleEVENT_B_BUILDIN_TYPE"
    // InternalStatemachine.g:766:1: ruleEVENT_B_BUILDIN_TYPE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'BOOL' | kw= '\\u2124' ) ;
    public final AntlrDatatypeRuleToken ruleEVENT_B_BUILDIN_TYPE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalStatemachine.g:772:2: ( (kw= 'BOOL' | kw= '\\u2124' ) )
            // InternalStatemachine.g:773:2: (kw= 'BOOL' | kw= '\\u2124' )
            {
            // InternalStatemachine.g:773:2: (kw= 'BOOL' | kw= '\\u2124' )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==32) ) {
                alt20=1;
            }
            else if ( (LA20_0==33) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalStatemachine.g:774:3: kw= 'BOOL'
                    {
                    kw=(Token)match(input,32,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENT_B_BUILDIN_TYPEAccess().getBOOLKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalStatemachine.g:780:3: kw= '\\u2124'
                    {
                    kw=(Token)match(input,33,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENT_B_BUILDIN_TYPEAccess().getDoubleStruckCapitalZKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEVENT_B_BUILDIN_TYPE"


    // $ANTLR start "entryRuleGuard"
    // InternalStatemachine.g:789:1: entryRuleGuard returns [EObject current=null] : iv_ruleGuard= ruleGuard EOF ;
    public final EObject entryRuleGuard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuard = null;


        try {
            // InternalStatemachine.g:789:46: (iv_ruleGuard= ruleGuard EOF )
            // InternalStatemachine.g:790:2: iv_ruleGuard= ruleGuard EOF
            {
             newCompositeNode(grammarAccess.getGuardRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGuard=ruleGuard();

            state._fsp--;

             current =iv_ruleGuard; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGuard"


    // $ANTLR start "ruleGuard"
    // InternalStatemachine.g:796:1: ruleGuard returns [EObject current=null] : ( ( (lv_theorem_0_0= 'theorem' ) )? ( (lv_name_1_0= RULE_XLABEL ) ) ( (lv_predicate_2_0= ruleXFormula ) ) ) ;
    public final EObject ruleGuard() throws RecognitionException {
        EObject current = null;

        Token lv_theorem_0_0=null;
        Token lv_name_1_0=null;
        AntlrDatatypeRuleToken lv_predicate_2_0 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:802:2: ( ( ( (lv_theorem_0_0= 'theorem' ) )? ( (lv_name_1_0= RULE_XLABEL ) ) ( (lv_predicate_2_0= ruleXFormula ) ) ) )
            // InternalStatemachine.g:803:2: ( ( (lv_theorem_0_0= 'theorem' ) )? ( (lv_name_1_0= RULE_XLABEL ) ) ( (lv_predicate_2_0= ruleXFormula ) ) )
            {
            // InternalStatemachine.g:803:2: ( ( (lv_theorem_0_0= 'theorem' ) )? ( (lv_name_1_0= RULE_XLABEL ) ) ( (lv_predicate_2_0= ruleXFormula ) ) )
            // InternalStatemachine.g:804:3: ( (lv_theorem_0_0= 'theorem' ) )? ( (lv_name_1_0= RULE_XLABEL ) ) ( (lv_predicate_2_0= ruleXFormula ) )
            {
            // InternalStatemachine.g:804:3: ( (lv_theorem_0_0= 'theorem' ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==34) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalStatemachine.g:805:4: (lv_theorem_0_0= 'theorem' )
                    {
                    // InternalStatemachine.g:805:4: (lv_theorem_0_0= 'theorem' )
                    // InternalStatemachine.g:806:5: lv_theorem_0_0= 'theorem'
                    {
                    lv_theorem_0_0=(Token)match(input,34,FOLLOW_21); 

                    					newLeafNode(lv_theorem_0_0, grammarAccess.getGuardAccess().getTheoremTheoremKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getGuardRule());
                    					}
                    					setWithLastConsumed(current, "theorem", true, "theorem");
                    				

                    }


                    }
                    break;

            }

            // InternalStatemachine.g:818:3: ( (lv_name_1_0= RULE_XLABEL ) )
            // InternalStatemachine.g:819:4: (lv_name_1_0= RULE_XLABEL )
            {
            // InternalStatemachine.g:819:4: (lv_name_1_0= RULE_XLABEL )
            // InternalStatemachine.g:820:5: lv_name_1_0= RULE_XLABEL
            {
            lv_name_1_0=(Token)match(input,RULE_XLABEL,FOLLOW_27); 

            					newLeafNode(lv_name_1_0, grammarAccess.getGuardAccess().getNameXLABELTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGuardRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"ac.soton.xumlb.Statemachine.XLABEL");
            				

            }


            }

            // InternalStatemachine.g:836:3: ( (lv_predicate_2_0= ruleXFormula ) )
            // InternalStatemachine.g:837:4: (lv_predicate_2_0= ruleXFormula )
            {
            // InternalStatemachine.g:837:4: (lv_predicate_2_0= ruleXFormula )
            // InternalStatemachine.g:838:5: lv_predicate_2_0= ruleXFormula
            {

            					newCompositeNode(grammarAccess.getGuardAccess().getPredicateXFormulaParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_predicate_2_0=ruleXFormula();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGuardRule());
            					}
            					set(
            						current,
            						"predicate",
            						lv_predicate_2_0,
            						"ac.soton.xumlb.Statemachine.XFormula");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGuard"


    // $ANTLR start "entryRuleAction"
    // InternalStatemachine.g:859:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // InternalStatemachine.g:859:47: (iv_ruleAction= ruleAction EOF )
            // InternalStatemachine.g:860:2: iv_ruleAction= ruleAction EOF
            {
             newCompositeNode(grammarAccess.getActionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAction=ruleAction();

            state._fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // InternalStatemachine.g:866:1: ruleAction returns [EObject current=null] : ( ( (lv_name_0_0= RULE_XLABEL ) ) ( (lv_action_1_0= ruleXFormula ) ) ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        AntlrDatatypeRuleToken lv_action_1_0 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:872:2: ( ( ( (lv_name_0_0= RULE_XLABEL ) ) ( (lv_action_1_0= ruleXFormula ) ) ) )
            // InternalStatemachine.g:873:2: ( ( (lv_name_0_0= RULE_XLABEL ) ) ( (lv_action_1_0= ruleXFormula ) ) )
            {
            // InternalStatemachine.g:873:2: ( ( (lv_name_0_0= RULE_XLABEL ) ) ( (lv_action_1_0= ruleXFormula ) ) )
            // InternalStatemachine.g:874:3: ( (lv_name_0_0= RULE_XLABEL ) ) ( (lv_action_1_0= ruleXFormula ) )
            {
            // InternalStatemachine.g:874:3: ( (lv_name_0_0= RULE_XLABEL ) )
            // InternalStatemachine.g:875:4: (lv_name_0_0= RULE_XLABEL )
            {
            // InternalStatemachine.g:875:4: (lv_name_0_0= RULE_XLABEL )
            // InternalStatemachine.g:876:5: lv_name_0_0= RULE_XLABEL
            {
            lv_name_0_0=(Token)match(input,RULE_XLABEL,FOLLOW_27); 

            					newLeafNode(lv_name_0_0, grammarAccess.getActionAccess().getNameXLABELTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"ac.soton.xumlb.Statemachine.XLABEL");
            				

            }


            }

            // InternalStatemachine.g:892:3: ( (lv_action_1_0= ruleXFormula ) )
            // InternalStatemachine.g:893:4: (lv_action_1_0= ruleXFormula )
            {
            // InternalStatemachine.g:893:4: (lv_action_1_0= ruleXFormula )
            // InternalStatemachine.g:894:5: lv_action_1_0= ruleXFormula
            {

            					newCompositeNode(grammarAccess.getActionAccess().getActionXFormulaParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_action_1_0=ruleXFormula();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getActionRule());
            					}
            					set(
            						current,
            						"action",
            						lv_action_1_0,
            						"ac.soton.xumlb.Statemachine.XFormula");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleWitness"
    // InternalStatemachine.g:915:1: entryRuleWitness returns [EObject current=null] : iv_ruleWitness= ruleWitness EOF ;
    public final EObject entryRuleWitness() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWitness = null;


        try {
            // InternalStatemachine.g:915:48: (iv_ruleWitness= ruleWitness EOF )
            // InternalStatemachine.g:916:2: iv_ruleWitness= ruleWitness EOF
            {
             newCompositeNode(grammarAccess.getWitnessRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWitness=ruleWitness();

            state._fsp--;

             current =iv_ruleWitness; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWitness"


    // $ANTLR start "ruleWitness"
    // InternalStatemachine.g:922:1: ruleWitness returns [EObject current=null] : ( ( (lv_name_0_0= RULE_XLABEL ) ) ( (lv_predicate_1_0= ruleXFormula ) ) ) ;
    public final EObject ruleWitness() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        AntlrDatatypeRuleToken lv_predicate_1_0 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:928:2: ( ( ( (lv_name_0_0= RULE_XLABEL ) ) ( (lv_predicate_1_0= ruleXFormula ) ) ) )
            // InternalStatemachine.g:929:2: ( ( (lv_name_0_0= RULE_XLABEL ) ) ( (lv_predicate_1_0= ruleXFormula ) ) )
            {
            // InternalStatemachine.g:929:2: ( ( (lv_name_0_0= RULE_XLABEL ) ) ( (lv_predicate_1_0= ruleXFormula ) ) )
            // InternalStatemachine.g:930:3: ( (lv_name_0_0= RULE_XLABEL ) ) ( (lv_predicate_1_0= ruleXFormula ) )
            {
            // InternalStatemachine.g:930:3: ( (lv_name_0_0= RULE_XLABEL ) )
            // InternalStatemachine.g:931:4: (lv_name_0_0= RULE_XLABEL )
            {
            // InternalStatemachine.g:931:4: (lv_name_0_0= RULE_XLABEL )
            // InternalStatemachine.g:932:5: lv_name_0_0= RULE_XLABEL
            {
            lv_name_0_0=(Token)match(input,RULE_XLABEL,FOLLOW_27); 

            					newLeafNode(lv_name_0_0, grammarAccess.getWitnessAccess().getNameXLABELTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getWitnessRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"ac.soton.xumlb.Statemachine.XLABEL");
            				

            }


            }

            // InternalStatemachine.g:948:3: ( (lv_predicate_1_0= ruleXFormula ) )
            // InternalStatemachine.g:949:4: (lv_predicate_1_0= ruleXFormula )
            {
            // InternalStatemachine.g:949:4: (lv_predicate_1_0= ruleXFormula )
            // InternalStatemachine.g:950:5: lv_predicate_1_0= ruleXFormula
            {

            					newCompositeNode(grammarAccess.getWitnessAccess().getPredicateXFormulaParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_predicate_1_0=ruleXFormula();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getWitnessRule());
            					}
            					set(
            						current,
            						"predicate",
            						lv_predicate_1_0,
            						"ac.soton.xumlb.Statemachine.XFormula");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWitness"


    // $ANTLR start "entryRuleState"
    // InternalStatemachine.g:971:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalStatemachine.g:971:46: (iv_ruleState= ruleState EOF )
            // InternalStatemachine.g:972:2: iv_ruleState= ruleState EOF
            {
             newCompositeNode(grammarAccess.getStateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleState=ruleState();

            state._fsp--;

             current =iv_ruleState; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // InternalStatemachine.g:978:1: ruleState returns [EObject current=null] : (otherlv_0= 'State' ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'refines' ( ( ruleEString ) ) )? (otherlv_4= 'statemachines' otherlv_5= 'begin' ( (lv_statemachines_6_0= ruleStatemachine ) ) ( (lv_statemachines_7_0= ruleStatemachine ) )* otherlv_8= 'end' )? (otherlv_9= 'invariants' ( (lv_invariants_10_0= ruleInvariant ) )+ )? (otherlv_11= 'entryActions' ( (lv_entryActions_12_0= ruleAction ) )+ )? (otherlv_13= 'exitActions' ( (lv_exitActions_14_0= ruleAction ) )+ )? ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_statemachines_6_0 = null;

        EObject lv_statemachines_7_0 = null;

        EObject lv_invariants_10_0 = null;

        EObject lv_entryActions_12_0 = null;

        EObject lv_exitActions_14_0 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:984:2: ( (otherlv_0= 'State' ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'refines' ( ( ruleEString ) ) )? (otherlv_4= 'statemachines' otherlv_5= 'begin' ( (lv_statemachines_6_0= ruleStatemachine ) ) ( (lv_statemachines_7_0= ruleStatemachine ) )* otherlv_8= 'end' )? (otherlv_9= 'invariants' ( (lv_invariants_10_0= ruleInvariant ) )+ )? (otherlv_11= 'entryActions' ( (lv_entryActions_12_0= ruleAction ) )+ )? (otherlv_13= 'exitActions' ( (lv_exitActions_14_0= ruleAction ) )+ )? ) )
            // InternalStatemachine.g:985:2: (otherlv_0= 'State' ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'refines' ( ( ruleEString ) ) )? (otherlv_4= 'statemachines' otherlv_5= 'begin' ( (lv_statemachines_6_0= ruleStatemachine ) ) ( (lv_statemachines_7_0= ruleStatemachine ) )* otherlv_8= 'end' )? (otherlv_9= 'invariants' ( (lv_invariants_10_0= ruleInvariant ) )+ )? (otherlv_11= 'entryActions' ( (lv_entryActions_12_0= ruleAction ) )+ )? (otherlv_13= 'exitActions' ( (lv_exitActions_14_0= ruleAction ) )+ )? )
            {
            // InternalStatemachine.g:985:2: (otherlv_0= 'State' ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'refines' ( ( ruleEString ) ) )? (otherlv_4= 'statemachines' otherlv_5= 'begin' ( (lv_statemachines_6_0= ruleStatemachine ) ) ( (lv_statemachines_7_0= ruleStatemachine ) )* otherlv_8= 'end' )? (otherlv_9= 'invariants' ( (lv_invariants_10_0= ruleInvariant ) )+ )? (otherlv_11= 'entryActions' ( (lv_entryActions_12_0= ruleAction ) )+ )? (otherlv_13= 'exitActions' ( (lv_exitActions_14_0= ruleAction ) )+ )? )
            // InternalStatemachine.g:986:3: otherlv_0= 'State' ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'refines' ( ( ruleEString ) ) )? (otherlv_4= 'statemachines' otherlv_5= 'begin' ( (lv_statemachines_6_0= ruleStatemachine ) ) ( (lv_statemachines_7_0= ruleStatemachine ) )* otherlv_8= 'end' )? (otherlv_9= 'invariants' ( (lv_invariants_10_0= ruleInvariant ) )+ )? (otherlv_11= 'entryActions' ( (lv_entryActions_12_0= ruleAction ) )+ )? (otherlv_13= 'exitActions' ( (lv_exitActions_14_0= ruleAction ) )+ )?
            {
            otherlv_0=(Token)match(input,35,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getStateAccess().getStateKeyword_0());
            		
            // InternalStatemachine.g:990:3: ( (lv_name_1_0= ruleEString ) )
            // InternalStatemachine.g:991:4: (lv_name_1_0= ruleEString )
            {
            // InternalStatemachine.g:991:4: (lv_name_1_0= ruleEString )
            // InternalStatemachine.g:992:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getStateAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_28);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStateRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"ac.soton.xumlb.Statemachine.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalStatemachine.g:1009:3: (otherlv_2= 'refines' ( ( ruleEString ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==15) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalStatemachine.g:1010:4: otherlv_2= 'refines' ( ( ruleEString ) )
                    {
                    otherlv_2=(Token)match(input,15,FOLLOW_8); 

                    				newLeafNode(otherlv_2, grammarAccess.getStateAccess().getRefinesKeyword_2_0());
                    			
                    // InternalStatemachine.g:1014:4: ( ( ruleEString ) )
                    // InternalStatemachine.g:1015:5: ( ruleEString )
                    {
                    // InternalStatemachine.g:1015:5: ( ruleEString )
                    // InternalStatemachine.g:1016:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStateRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getStateAccess().getRefinesStateCrossReference_2_1_0());
                    					
                    pushFollow(FOLLOW_29);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalStatemachine.g:1031:3: (otherlv_4= 'statemachines' otherlv_5= 'begin' ( (lv_statemachines_6_0= ruleStatemachine ) ) ( (lv_statemachines_7_0= ruleStatemachine ) )* otherlv_8= 'end' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==36) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalStatemachine.g:1032:4: otherlv_4= 'statemachines' otherlv_5= 'begin' ( (lv_statemachines_6_0= ruleStatemachine ) ) ( (lv_statemachines_7_0= ruleStatemachine ) )* otherlv_8= 'end'
                    {
                    otherlv_4=(Token)match(input,36,FOLLOW_30); 

                    				newLeafNode(otherlv_4, grammarAccess.getStateAccess().getStatemachinesKeyword_3_0());
                    			
                    otherlv_5=(Token)match(input,37,FOLLOW_31); 

                    				newLeafNode(otherlv_5, grammarAccess.getStateAccess().getBeginKeyword_3_1());
                    			
                    // InternalStatemachine.g:1040:4: ( (lv_statemachines_6_0= ruleStatemachine ) )
                    // InternalStatemachine.g:1041:5: (lv_statemachines_6_0= ruleStatemachine )
                    {
                    // InternalStatemachine.g:1041:5: (lv_statemachines_6_0= ruleStatemachine )
                    // InternalStatemachine.g:1042:6: lv_statemachines_6_0= ruleStatemachine
                    {

                    						newCompositeNode(grammarAccess.getStateAccess().getStatemachinesStatemachineParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_statemachines_6_0=ruleStatemachine();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStateRule());
                    						}
                    						add(
                    							current,
                    							"statemachines",
                    							lv_statemachines_6_0,
                    							"ac.soton.xumlb.Statemachine.Statemachine");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalStatemachine.g:1059:4: ( (lv_statemachines_7_0= ruleStatemachine ) )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==12) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // InternalStatemachine.g:1060:5: (lv_statemachines_7_0= ruleStatemachine )
                    	    {
                    	    // InternalStatemachine.g:1060:5: (lv_statemachines_7_0= ruleStatemachine )
                    	    // InternalStatemachine.g:1061:6: lv_statemachines_7_0= ruleStatemachine
                    	    {

                    	    						newCompositeNode(grammarAccess.getStateAccess().getStatemachinesStatemachineParserRuleCall_3_3_0());
                    	    					
                    	    pushFollow(FOLLOW_32);
                    	    lv_statemachines_7_0=ruleStatemachine();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getStateRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"statemachines",
                    	    							lv_statemachines_7_0,
                    	    							"ac.soton.xumlb.Statemachine.Statemachine");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,28,FOLLOW_33); 

                    				newLeafNode(otherlv_8, grammarAccess.getStateAccess().getEndKeyword_3_4());
                    			

                    }
                    break;

            }

            // InternalStatemachine.g:1083:3: (otherlv_9= 'invariants' ( (lv_invariants_10_0= ruleInvariant ) )+ )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==38) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalStatemachine.g:1084:4: otherlv_9= 'invariants' ( (lv_invariants_10_0= ruleInvariant ) )+
                    {
                    otherlv_9=(Token)match(input,38,FOLLOW_34); 

                    				newLeafNode(otherlv_9, grammarAccess.getStateAccess().getInvariantsKeyword_4_0());
                    			
                    // InternalStatemachine.g:1088:4: ( (lv_invariants_10_0= ruleInvariant ) )+
                    int cnt25=0;
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==34) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // InternalStatemachine.g:1089:5: (lv_invariants_10_0= ruleInvariant )
                    	    {
                    	    // InternalStatemachine.g:1089:5: (lv_invariants_10_0= ruleInvariant )
                    	    // InternalStatemachine.g:1090:6: lv_invariants_10_0= ruleInvariant
                    	    {

                    	    						newCompositeNode(grammarAccess.getStateAccess().getInvariantsInvariantParserRuleCall_4_1_0());
                    	    					
                    	    pushFollow(FOLLOW_35);
                    	    lv_invariants_10_0=ruleInvariant();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getStateRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"invariants",
                    	    							lv_invariants_10_0,
                    	    							"ac.soton.xumlb.Statemachine.Invariant");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt25 >= 1 ) break loop25;
                                EarlyExitException eee =
                                    new EarlyExitException(25, input);
                                throw eee;
                        }
                        cnt25++;
                    } while (true);


                    }
                    break;

            }

            // InternalStatemachine.g:1108:3: (otherlv_11= 'entryActions' ( (lv_entryActions_12_0= ruleAction ) )+ )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==39) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalStatemachine.g:1109:4: otherlv_11= 'entryActions' ( (lv_entryActions_12_0= ruleAction ) )+
                    {
                    otherlv_11=(Token)match(input,39,FOLLOW_21); 

                    				newLeafNode(otherlv_11, grammarAccess.getStateAccess().getEntryActionsKeyword_5_0());
                    			
                    // InternalStatemachine.g:1113:4: ( (lv_entryActions_12_0= ruleAction ) )+
                    int cnt27=0;
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==RULE_XLABEL) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // InternalStatemachine.g:1114:5: (lv_entryActions_12_0= ruleAction )
                    	    {
                    	    // InternalStatemachine.g:1114:5: (lv_entryActions_12_0= ruleAction )
                    	    // InternalStatemachine.g:1115:6: lv_entryActions_12_0= ruleAction
                    	    {

                    	    						newCompositeNode(grammarAccess.getStateAccess().getEntryActionsActionParserRuleCall_5_1_0());
                    	    					
                    	    pushFollow(FOLLOW_36);
                    	    lv_entryActions_12_0=ruleAction();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getStateRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"entryActions",
                    	    							lv_entryActions_12_0,
                    	    							"ac.soton.xumlb.Statemachine.Action");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt27 >= 1 ) break loop27;
                                EarlyExitException eee =
                                    new EarlyExitException(27, input);
                                throw eee;
                        }
                        cnt27++;
                    } while (true);


                    }
                    break;

            }

            // InternalStatemachine.g:1133:3: (otherlv_13= 'exitActions' ( (lv_exitActions_14_0= ruleAction ) )+ )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==40) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalStatemachine.g:1134:4: otherlv_13= 'exitActions' ( (lv_exitActions_14_0= ruleAction ) )+
                    {
                    otherlv_13=(Token)match(input,40,FOLLOW_21); 

                    				newLeafNode(otherlv_13, grammarAccess.getStateAccess().getExitActionsKeyword_6_0());
                    			
                    // InternalStatemachine.g:1138:4: ( (lv_exitActions_14_0= ruleAction ) )+
                    int cnt29=0;
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==RULE_XLABEL) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // InternalStatemachine.g:1139:5: (lv_exitActions_14_0= ruleAction )
                    	    {
                    	    // InternalStatemachine.g:1139:5: (lv_exitActions_14_0= ruleAction )
                    	    // InternalStatemachine.g:1140:6: lv_exitActions_14_0= ruleAction
                    	    {

                    	    						newCompositeNode(grammarAccess.getStateAccess().getExitActionsActionParserRuleCall_6_1_0());
                    	    					
                    	    pushFollow(FOLLOW_37);
                    	    lv_exitActions_14_0=ruleAction();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getStateRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"exitActions",
                    	    							lv_exitActions_14_0,
                    	    							"ac.soton.xumlb.Statemachine.Action");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt29 >= 1 ) break loop29;
                                EarlyExitException eee =
                                    new EarlyExitException(29, input);
                                throw eee;
                        }
                        cnt29++;
                    } while (true);


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleInvariant"
    // InternalStatemachine.g:1162:1: entryRuleInvariant returns [EObject current=null] : iv_ruleInvariant= ruleInvariant EOF ;
    public final EObject entryRuleInvariant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvariant = null;


        try {
            // InternalStatemachine.g:1162:50: (iv_ruleInvariant= ruleInvariant EOF )
            // InternalStatemachine.g:1163:2: iv_ruleInvariant= ruleInvariant EOF
            {
             newCompositeNode(grammarAccess.getInvariantRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInvariant=ruleInvariant();

            state._fsp--;

             current =iv_ruleInvariant; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInvariant"


    // $ANTLR start "ruleInvariant"
    // InternalStatemachine.g:1169:1: ruleInvariant returns [EObject current=null] : ( ( (lv_theorem_0_0= 'theorem' ) ) ( (lv_name_1_0= RULE_XLABEL ) ) ( (lv_predicate_2_0= ruleXFormula ) ) ) ;
    public final EObject ruleInvariant() throws RecognitionException {
        EObject current = null;

        Token lv_theorem_0_0=null;
        Token lv_name_1_0=null;
        AntlrDatatypeRuleToken lv_predicate_2_0 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:1175:2: ( ( ( (lv_theorem_0_0= 'theorem' ) ) ( (lv_name_1_0= RULE_XLABEL ) ) ( (lv_predicate_2_0= ruleXFormula ) ) ) )
            // InternalStatemachine.g:1176:2: ( ( (lv_theorem_0_0= 'theorem' ) ) ( (lv_name_1_0= RULE_XLABEL ) ) ( (lv_predicate_2_0= ruleXFormula ) ) )
            {
            // InternalStatemachine.g:1176:2: ( ( (lv_theorem_0_0= 'theorem' ) ) ( (lv_name_1_0= RULE_XLABEL ) ) ( (lv_predicate_2_0= ruleXFormula ) ) )
            // InternalStatemachine.g:1177:3: ( (lv_theorem_0_0= 'theorem' ) ) ( (lv_name_1_0= RULE_XLABEL ) ) ( (lv_predicate_2_0= ruleXFormula ) )
            {
            // InternalStatemachine.g:1177:3: ( (lv_theorem_0_0= 'theorem' ) )
            // InternalStatemachine.g:1178:4: (lv_theorem_0_0= 'theorem' )
            {
            // InternalStatemachine.g:1178:4: (lv_theorem_0_0= 'theorem' )
            // InternalStatemachine.g:1179:5: lv_theorem_0_0= 'theorem'
            {
            lv_theorem_0_0=(Token)match(input,34,FOLLOW_21); 

            					newLeafNode(lv_theorem_0_0, grammarAccess.getInvariantAccess().getTheoremTheoremKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInvariantRule());
            					}
            					setWithLastConsumed(current, "theorem", true, "theorem");
            				

            }


            }

            // InternalStatemachine.g:1191:3: ( (lv_name_1_0= RULE_XLABEL ) )
            // InternalStatemachine.g:1192:4: (lv_name_1_0= RULE_XLABEL )
            {
            // InternalStatemachine.g:1192:4: (lv_name_1_0= RULE_XLABEL )
            // InternalStatemachine.g:1193:5: lv_name_1_0= RULE_XLABEL
            {
            lv_name_1_0=(Token)match(input,RULE_XLABEL,FOLLOW_27); 

            					newLeafNode(lv_name_1_0, grammarAccess.getInvariantAccess().getNameXLABELTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInvariantRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"ac.soton.xumlb.Statemachine.XLABEL");
            				

            }


            }

            // InternalStatemachine.g:1209:3: ( (lv_predicate_2_0= ruleXFormula ) )
            // InternalStatemachine.g:1210:4: (lv_predicate_2_0= ruleXFormula )
            {
            // InternalStatemachine.g:1210:4: (lv_predicate_2_0= ruleXFormula )
            // InternalStatemachine.g:1211:5: lv_predicate_2_0= ruleXFormula
            {

            					newCompositeNode(grammarAccess.getInvariantAccess().getPredicateXFormulaParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_predicate_2_0=ruleXFormula();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getInvariantRule());
            					}
            					set(
            						current,
            						"predicate",
            						lv_predicate_2_0,
            						"ac.soton.xumlb.Statemachine.XFormula");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInvariant"


    // $ANTLR start "entryRuleInitial"
    // InternalStatemachine.g:1232:1: entryRuleInitial returns [EObject current=null] : iv_ruleInitial= ruleInitial EOF ;
    public final EObject entryRuleInitial() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitial = null;


        try {
            // InternalStatemachine.g:1232:48: (iv_ruleInitial= ruleInitial EOF )
            // InternalStatemachine.g:1233:2: iv_ruleInitial= ruleInitial EOF
            {
             newCompositeNode(grammarAccess.getInitialRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInitial=ruleInitial();

            state._fsp--;

             current =iv_ruleInitial; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInitial"


    // $ANTLR start "ruleInitial"
    // InternalStatemachine.g:1239:1: ruleInitial returns [EObject current=null] : (otherlv_0= 'Initial' ( (lv_name_1_0= ruleEString ) ) ) ;
    public final EObject ruleInitial() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:1245:2: ( (otherlv_0= 'Initial' ( (lv_name_1_0= ruleEString ) ) ) )
            // InternalStatemachine.g:1246:2: (otherlv_0= 'Initial' ( (lv_name_1_0= ruleEString ) ) )
            {
            // InternalStatemachine.g:1246:2: (otherlv_0= 'Initial' ( (lv_name_1_0= ruleEString ) ) )
            // InternalStatemachine.g:1247:3: otherlv_0= 'Initial' ( (lv_name_1_0= ruleEString ) )
            {
            otherlv_0=(Token)match(input,41,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getInitialAccess().getInitialKeyword_0());
            		
            // InternalStatemachine.g:1251:3: ( (lv_name_1_0= ruleEString ) )
            // InternalStatemachine.g:1252:4: (lv_name_1_0= ruleEString )
            {
            // InternalStatemachine.g:1252:4: (lv_name_1_0= ruleEString )
            // InternalStatemachine.g:1253:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getInitialAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getInitialRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"ac.soton.xumlb.Statemachine.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInitial"


    // $ANTLR start "entryRuleFinal"
    // InternalStatemachine.g:1274:1: entryRuleFinal returns [EObject current=null] : iv_ruleFinal= ruleFinal EOF ;
    public final EObject entryRuleFinal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFinal = null;


        try {
            // InternalStatemachine.g:1274:46: (iv_ruleFinal= ruleFinal EOF )
            // InternalStatemachine.g:1275:2: iv_ruleFinal= ruleFinal EOF
            {
             newCompositeNode(grammarAccess.getFinalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFinal=ruleFinal();

            state._fsp--;

             current =iv_ruleFinal; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFinal"


    // $ANTLR start "ruleFinal"
    // InternalStatemachine.g:1281:1: ruleFinal returns [EObject current=null] : (otherlv_0= 'Final' ( (lv_name_1_0= ruleEString ) ) ) ;
    public final EObject ruleFinal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:1287:2: ( (otherlv_0= 'Final' ( (lv_name_1_0= ruleEString ) ) ) )
            // InternalStatemachine.g:1288:2: (otherlv_0= 'Final' ( (lv_name_1_0= ruleEString ) ) )
            {
            // InternalStatemachine.g:1288:2: (otherlv_0= 'Final' ( (lv_name_1_0= ruleEString ) ) )
            // InternalStatemachine.g:1289:3: otherlv_0= 'Final' ( (lv_name_1_0= ruleEString ) )
            {
            otherlv_0=(Token)match(input,42,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getFinalAccess().getFinalKeyword_0());
            		
            // InternalStatemachine.g:1293:3: ( (lv_name_1_0= ruleEString ) )
            // InternalStatemachine.g:1294:4: (lv_name_1_0= ruleEString )
            {
            // InternalStatemachine.g:1294:4: (lv_name_1_0= ruleEString )
            // InternalStatemachine.g:1295:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getFinalAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFinalRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"ac.soton.xumlb.Statemachine.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFinal"


    // $ANTLR start "entryRuleAny"
    // InternalStatemachine.g:1316:1: entryRuleAny returns [EObject current=null] : iv_ruleAny= ruleAny EOF ;
    public final EObject entryRuleAny() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAny = null;


        try {
            // InternalStatemachine.g:1316:44: (iv_ruleAny= ruleAny EOF )
            // InternalStatemachine.g:1317:2: iv_ruleAny= ruleAny EOF
            {
             newCompositeNode(grammarAccess.getAnyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAny=ruleAny();

            state._fsp--;

             current =iv_ruleAny; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAny"


    // $ANTLR start "ruleAny"
    // InternalStatemachine.g:1323:1: ruleAny returns [EObject current=null] : (otherlv_0= 'Any' ( (lv_name_1_0= ruleEString ) ) ) ;
    public final EObject ruleAny() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:1329:2: ( (otherlv_0= 'Any' ( (lv_name_1_0= ruleEString ) ) ) )
            // InternalStatemachine.g:1330:2: (otherlv_0= 'Any' ( (lv_name_1_0= ruleEString ) ) )
            {
            // InternalStatemachine.g:1330:2: (otherlv_0= 'Any' ( (lv_name_1_0= ruleEString ) ) )
            // InternalStatemachine.g:1331:3: otherlv_0= 'Any' ( (lv_name_1_0= ruleEString ) )
            {
            otherlv_0=(Token)match(input,43,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getAnyAccess().getAnyKeyword_0());
            		
            // InternalStatemachine.g:1335:3: ( (lv_name_1_0= ruleEString ) )
            // InternalStatemachine.g:1336:4: (lv_name_1_0= ruleEString )
            {
            // InternalStatemachine.g:1336:4: (lv_name_1_0= ruleEString )
            // InternalStatemachine.g:1337:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getAnyAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAnyRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"ac.soton.xumlb.Statemachine.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAny"


    // $ANTLR start "entryRuleJunction"
    // InternalStatemachine.g:1358:1: entryRuleJunction returns [EObject current=null] : iv_ruleJunction= ruleJunction EOF ;
    public final EObject entryRuleJunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJunction = null;


        try {
            // InternalStatemachine.g:1358:49: (iv_ruleJunction= ruleJunction EOF )
            // InternalStatemachine.g:1359:2: iv_ruleJunction= ruleJunction EOF
            {
             newCompositeNode(grammarAccess.getJunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJunction=ruleJunction();

            state._fsp--;

             current =iv_ruleJunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJunction"


    // $ANTLR start "ruleJunction"
    // InternalStatemachine.g:1365:1: ruleJunction returns [EObject current=null] : (otherlv_0= 'Junction' ( (lv_name_1_0= ruleEString ) ) ) ;
    public final EObject ruleJunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:1371:2: ( (otherlv_0= 'Junction' ( (lv_name_1_0= ruleEString ) ) ) )
            // InternalStatemachine.g:1372:2: (otherlv_0= 'Junction' ( (lv_name_1_0= ruleEString ) ) )
            {
            // InternalStatemachine.g:1372:2: (otherlv_0= 'Junction' ( (lv_name_1_0= ruleEString ) ) )
            // InternalStatemachine.g:1373:3: otherlv_0= 'Junction' ( (lv_name_1_0= ruleEString ) )
            {
            otherlv_0=(Token)match(input,44,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getJunctionAccess().getJunctionKeyword_0());
            		
            // InternalStatemachine.g:1377:3: ( (lv_name_1_0= ruleEString ) )
            // InternalStatemachine.g:1378:4: (lv_name_1_0= ruleEString )
            {
            // InternalStatemachine.g:1378:4: (lv_name_1_0= ruleEString )
            // InternalStatemachine.g:1379:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getJunctionAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJunctionRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"ac.soton.xumlb.Statemachine.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJunction"


    // $ANTLR start "entryRuleFork"
    // InternalStatemachine.g:1400:1: entryRuleFork returns [EObject current=null] : iv_ruleFork= ruleFork EOF ;
    public final EObject entryRuleFork() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFork = null;


        try {
            // InternalStatemachine.g:1400:45: (iv_ruleFork= ruleFork EOF )
            // InternalStatemachine.g:1401:2: iv_ruleFork= ruleFork EOF
            {
             newCompositeNode(grammarAccess.getForkRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFork=ruleFork();

            state._fsp--;

             current =iv_ruleFork; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFork"


    // $ANTLR start "ruleFork"
    // InternalStatemachine.g:1407:1: ruleFork returns [EObject current=null] : (otherlv_0= 'Fork' ( (lv_name_1_0= ruleEString ) ) ) ;
    public final EObject ruleFork() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:1413:2: ( (otherlv_0= 'Fork' ( (lv_name_1_0= ruleEString ) ) ) )
            // InternalStatemachine.g:1414:2: (otherlv_0= 'Fork' ( (lv_name_1_0= ruleEString ) ) )
            {
            // InternalStatemachine.g:1414:2: (otherlv_0= 'Fork' ( (lv_name_1_0= ruleEString ) ) )
            // InternalStatemachine.g:1415:3: otherlv_0= 'Fork' ( (lv_name_1_0= ruleEString ) )
            {
            otherlv_0=(Token)match(input,45,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getForkAccess().getForkKeyword_0());
            		
            // InternalStatemachine.g:1419:3: ( (lv_name_1_0= ruleEString ) )
            // InternalStatemachine.g:1420:4: (lv_name_1_0= ruleEString )
            {
            // InternalStatemachine.g:1420:4: (lv_name_1_0= ruleEString )
            // InternalStatemachine.g:1421:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getForkAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForkRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"ac.soton.xumlb.Statemachine.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFork"


    // $ANTLR start "entryRuleXFormula"
    // InternalStatemachine.g:1442:1: entryRuleXFormula returns [String current=null] : iv_ruleXFormula= ruleXFormula EOF ;
    public final String entryRuleXFormula() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleXFormula = null;


        try {
            // InternalStatemachine.g:1442:48: (iv_ruleXFormula= ruleXFormula EOF )
            // InternalStatemachine.g:1443:2: iv_ruleXFormula= ruleXFormula EOF
            {
             newCompositeNode(grammarAccess.getXFormulaRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXFormula=ruleXFormula();

            state._fsp--;

             current =iv_ruleXFormula.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXFormula"


    // $ANTLR start "ruleXFormula"
    // InternalStatemachine.g:1449:1: ruleXFormula returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_EVENTB_IDENTIFIER_KEYWORD_0= ruleEVENTB_IDENTIFIER_KEYWORD | this_EVENTB_PREDICATE_SYMBOLS_1= ruleEVENTB_PREDICATE_SYMBOLS | this_EVENTB_EXPRESSION_SYMBOLS_2= ruleEVENTB_EXPRESSION_SYMBOLS | this_ID_3= RULE_ID | this_INT_4= RULE_INT )+ ;
    public final AntlrDatatypeRuleToken ruleXFormula() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_3=null;
        Token this_INT_4=null;
        AntlrDatatypeRuleToken this_EVENTB_IDENTIFIER_KEYWORD_0 = null;

        AntlrDatatypeRuleToken this_EVENTB_PREDICATE_SYMBOLS_1 = null;

        AntlrDatatypeRuleToken this_EVENTB_EXPRESSION_SYMBOLS_2 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:1455:2: ( (this_EVENTB_IDENTIFIER_KEYWORD_0= ruleEVENTB_IDENTIFIER_KEYWORD | this_EVENTB_PREDICATE_SYMBOLS_1= ruleEVENTB_PREDICATE_SYMBOLS | this_EVENTB_EXPRESSION_SYMBOLS_2= ruleEVENTB_EXPRESSION_SYMBOLS | this_ID_3= RULE_ID | this_INT_4= RULE_INT )+ )
            // InternalStatemachine.g:1456:2: (this_EVENTB_IDENTIFIER_KEYWORD_0= ruleEVENTB_IDENTIFIER_KEYWORD | this_EVENTB_PREDICATE_SYMBOLS_1= ruleEVENTB_PREDICATE_SYMBOLS | this_EVENTB_EXPRESSION_SYMBOLS_2= ruleEVENTB_EXPRESSION_SYMBOLS | this_ID_3= RULE_ID | this_INT_4= RULE_INT )+
            {
            // InternalStatemachine.g:1456:2: (this_EVENTB_IDENTIFIER_KEYWORD_0= ruleEVENTB_IDENTIFIER_KEYWORD | this_EVENTB_PREDICATE_SYMBOLS_1= ruleEVENTB_PREDICATE_SYMBOLS | this_EVENTB_EXPRESSION_SYMBOLS_2= ruleEVENTB_EXPRESSION_SYMBOLS | this_ID_3= RULE_ID | this_INT_4= RULE_INT )+
            int cnt31=0;
            loop31:
            do {
                int alt31=6;
                switch ( input.LA(1) ) {
                case 31:
                case 32:
                case 33:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                    {
                    alt31=1;
                    }
                    break;
                case 13:
                case 14:
                case 24:
                case 29:
                case 66:
                case 67:
                case 68:
                case 69:
                case 70:
                case 71:
                case 72:
                case 73:
                case 74:
                case 75:
                case 76:
                case 77:
                case 78:
                case 79:
                case 80:
                case 81:
                case 82:
                case 83:
                case 84:
                case 85:
                case 86:
                case 87:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                    {
                    alt31=2;
                    }
                    break;
                case 30:
                case 93:
                case 94:
                case 95:
                case 96:
                case 97:
                case 98:
                case 99:
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 106:
                case 107:
                case 108:
                case 109:
                case 110:
                case 111:
                case 112:
                case 113:
                case 114:
                case 115:
                case 116:
                case 117:
                case 118:
                case 119:
                case 120:
                case 121:
                case 122:
                case 123:
                case 124:
                case 126:
                case 127:
                case 128:
                case 129:
                case 130:
                case 131:
                case 132:
                case 133:
                case 134:
                case 135:
                case 136:
                case 137:
                    {
                    alt31=3;
                    }
                    break;
                case RULE_ID:
                    {
                    alt31=4;
                    }
                    break;
                case RULE_INT:
                    {
                    alt31=5;
                    }
                    break;

                }

                switch (alt31) {
            	case 1 :
            	    // InternalStatemachine.g:1457:3: this_EVENTB_IDENTIFIER_KEYWORD_0= ruleEVENTB_IDENTIFIER_KEYWORD
            	    {

            	    			newCompositeNode(grammarAccess.getXFormulaAccess().getEVENTB_IDENTIFIER_KEYWORDParserRuleCall_0());
            	    		
            	    pushFollow(FOLLOW_38);
            	    this_EVENTB_IDENTIFIER_KEYWORD_0=ruleEVENTB_IDENTIFIER_KEYWORD();

            	    state._fsp--;


            	    			current.merge(this_EVENTB_IDENTIFIER_KEYWORD_0);
            	    		

            	    			afterParserOrEnumRuleCall();
            	    		

            	    }
            	    break;
            	case 2 :
            	    // InternalStatemachine.g:1468:3: this_EVENTB_PREDICATE_SYMBOLS_1= ruleEVENTB_PREDICATE_SYMBOLS
            	    {

            	    			newCompositeNode(grammarAccess.getXFormulaAccess().getEVENTB_PREDICATE_SYMBOLSParserRuleCall_1());
            	    		
            	    pushFollow(FOLLOW_38);
            	    this_EVENTB_PREDICATE_SYMBOLS_1=ruleEVENTB_PREDICATE_SYMBOLS();

            	    state._fsp--;


            	    			current.merge(this_EVENTB_PREDICATE_SYMBOLS_1);
            	    		

            	    			afterParserOrEnumRuleCall();
            	    		

            	    }
            	    break;
            	case 3 :
            	    // InternalStatemachine.g:1479:3: this_EVENTB_EXPRESSION_SYMBOLS_2= ruleEVENTB_EXPRESSION_SYMBOLS
            	    {

            	    			newCompositeNode(grammarAccess.getXFormulaAccess().getEVENTB_EXPRESSION_SYMBOLSParserRuleCall_2());
            	    		
            	    pushFollow(FOLLOW_38);
            	    this_EVENTB_EXPRESSION_SYMBOLS_2=ruleEVENTB_EXPRESSION_SYMBOLS();

            	    state._fsp--;


            	    			current.merge(this_EVENTB_EXPRESSION_SYMBOLS_2);
            	    		

            	    			afterParserOrEnumRuleCall();
            	    		

            	    }
            	    break;
            	case 4 :
            	    // InternalStatemachine.g:1490:3: this_ID_3= RULE_ID
            	    {
            	    this_ID_3=(Token)match(input,RULE_ID,FOLLOW_38); 

            	    			current.merge(this_ID_3);
            	    		

            	    			newLeafNode(this_ID_3, grammarAccess.getXFormulaAccess().getIDTerminalRuleCall_3());
            	    		

            	    }
            	    break;
            	case 5 :
            	    // InternalStatemachine.g:1498:3: this_INT_4= RULE_INT
            	    {
            	    this_INT_4=(Token)match(input,RULE_INT,FOLLOW_38); 

            	    			current.merge(this_INT_4);
            	    		

            	    			newLeafNode(this_INT_4, grammarAccess.getXFormulaAccess().getINTTerminalRuleCall_4());
            	    		

            	    }
            	    break;

            	default :
            	    if ( cnt31 >= 1 ) break loop31;
                        EarlyExitException eee =
                            new EarlyExitException(31, input);
                        throw eee;
                }
                cnt31++;
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXFormula"


    // $ANTLR start "entryRuleEVENTB_IDENTIFIER_KEYWORD"
    // InternalStatemachine.g:1509:1: entryRuleEVENTB_IDENTIFIER_KEYWORD returns [String current=null] : iv_ruleEVENTB_IDENTIFIER_KEYWORD= ruleEVENTB_IDENTIFIER_KEYWORD EOF ;
    public final String entryRuleEVENTB_IDENTIFIER_KEYWORD() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEVENTB_IDENTIFIER_KEYWORD = null;


        try {
            // InternalStatemachine.g:1509:65: (iv_ruleEVENTB_IDENTIFIER_KEYWORD= ruleEVENTB_IDENTIFIER_KEYWORD EOF )
            // InternalStatemachine.g:1510:2: iv_ruleEVENTB_IDENTIFIER_KEYWORD= ruleEVENTB_IDENTIFIER_KEYWORD EOF
            {
             newCompositeNode(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEVENTB_IDENTIFIER_KEYWORD=ruleEVENTB_IDENTIFIER_KEYWORD();

            state._fsp--;

             current =iv_ruleEVENTB_IDENTIFIER_KEYWORD.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEVENTB_IDENTIFIER_KEYWORD"


    // $ANTLR start "ruleEVENTB_IDENTIFIER_KEYWORD"
    // InternalStatemachine.g:1516:1: ruleEVENTB_IDENTIFIER_KEYWORD returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'BOOL' | kw= 'FALSE' | kw= 'TRUE' | kw= 'bool' | kw= 'card' | kw= 'dom' | kw= 'finite' | kw= 'id' | kw= 'inter' | kw= 'max' | kw= 'min' | kw= 'mod' | kw= 'pred' | kw= 'prj1' | kw= 'prj2' | kw= 'ran' | kw= 'succ' | kw= 'union' | kw= '\\u21151' | kw= '\\u2115' | kw= '\\u21191' | kw= '\\u2119' | kw= '\\u2124' ) ;
    public final AntlrDatatypeRuleToken ruleEVENTB_IDENTIFIER_KEYWORD() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalStatemachine.g:1522:2: ( (kw= 'BOOL' | kw= 'FALSE' | kw= 'TRUE' | kw= 'bool' | kw= 'card' | kw= 'dom' | kw= 'finite' | kw= 'id' | kw= 'inter' | kw= 'max' | kw= 'min' | kw= 'mod' | kw= 'pred' | kw= 'prj1' | kw= 'prj2' | kw= 'ran' | kw= 'succ' | kw= 'union' | kw= '\\u21151' | kw= '\\u2115' | kw= '\\u21191' | kw= '\\u2119' | kw= '\\u2124' ) )
            // InternalStatemachine.g:1523:2: (kw= 'BOOL' | kw= 'FALSE' | kw= 'TRUE' | kw= 'bool' | kw= 'card' | kw= 'dom' | kw= 'finite' | kw= 'id' | kw= 'inter' | kw= 'max' | kw= 'min' | kw= 'mod' | kw= 'pred' | kw= 'prj1' | kw= 'prj2' | kw= 'ran' | kw= 'succ' | kw= 'union' | kw= '\\u21151' | kw= '\\u2115' | kw= '\\u21191' | kw= '\\u2119' | kw= '\\u2124' )
            {
            // InternalStatemachine.g:1523:2: (kw= 'BOOL' | kw= 'FALSE' | kw= 'TRUE' | kw= 'bool' | kw= 'card' | kw= 'dom' | kw= 'finite' | kw= 'id' | kw= 'inter' | kw= 'max' | kw= 'min' | kw= 'mod' | kw= 'pred' | kw= 'prj1' | kw= 'prj2' | kw= 'ran' | kw= 'succ' | kw= 'union' | kw= '\\u21151' | kw= '\\u2115' | kw= '\\u21191' | kw= '\\u2119' | kw= '\\u2124' )
            int alt32=23;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt32=1;
                }
                break;
            case 46:
                {
                alt32=2;
                }
                break;
            case 47:
                {
                alt32=3;
                }
                break;
            case 48:
                {
                alt32=4;
                }
                break;
            case 49:
                {
                alt32=5;
                }
                break;
            case 50:
                {
                alt32=6;
                }
                break;
            case 51:
                {
                alt32=7;
                }
                break;
            case 52:
                {
                alt32=8;
                }
                break;
            case 53:
                {
                alt32=9;
                }
                break;
            case 54:
                {
                alt32=10;
                }
                break;
            case 55:
                {
                alt32=11;
                }
                break;
            case 56:
                {
                alt32=12;
                }
                break;
            case 57:
                {
                alt32=13;
                }
                break;
            case 58:
                {
                alt32=14;
                }
                break;
            case 59:
                {
                alt32=15;
                }
                break;
            case 60:
                {
                alt32=16;
                }
                break;
            case 61:
                {
                alt32=17;
                }
                break;
            case 62:
                {
                alt32=18;
                }
                break;
            case 63:
                {
                alt32=19;
                }
                break;
            case 64:
                {
                alt32=20;
                }
                break;
            case 65:
                {
                alt32=21;
                }
                break;
            case 31:
                {
                alt32=22;
                }
                break;
            case 33:
                {
                alt32=23;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // InternalStatemachine.g:1524:3: kw= 'BOOL'
                    {
                    kw=(Token)match(input,32,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getBOOLKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalStatemachine.g:1530:3: kw= 'FALSE'
                    {
                    kw=(Token)match(input,46,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getFALSEKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalStatemachine.g:1536:3: kw= 'TRUE'
                    {
                    kw=(Token)match(input,47,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getTRUEKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalStatemachine.g:1542:3: kw= 'bool'
                    {
                    kw=(Token)match(input,48,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getBoolKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalStatemachine.g:1548:3: kw= 'card'
                    {
                    kw=(Token)match(input,49,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getCardKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalStatemachine.g:1554:3: kw= 'dom'
                    {
                    kw=(Token)match(input,50,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDomKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalStatemachine.g:1560:3: kw= 'finite'
                    {
                    kw=(Token)match(input,51,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getFiniteKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalStatemachine.g:1566:3: kw= 'id'
                    {
                    kw=(Token)match(input,52,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getIdKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalStatemachine.g:1572:3: kw= 'inter'
                    {
                    kw=(Token)match(input,53,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getInterKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalStatemachine.g:1578:3: kw= 'max'
                    {
                    kw=(Token)match(input,54,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getMaxKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalStatemachine.g:1584:3: kw= 'min'
                    {
                    kw=(Token)match(input,55,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getMinKeyword_10());
                    		

                    }
                    break;
                case 12 :
                    // InternalStatemachine.g:1590:3: kw= 'mod'
                    {
                    kw=(Token)match(input,56,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getModKeyword_11());
                    		

                    }
                    break;
                case 13 :
                    // InternalStatemachine.g:1596:3: kw= 'pred'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getPredKeyword_12());
                    		

                    }
                    break;
                case 14 :
                    // InternalStatemachine.g:1602:3: kw= 'prj1'
                    {
                    kw=(Token)match(input,58,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getPrj1Keyword_13());
                    		

                    }
                    break;
                case 15 :
                    // InternalStatemachine.g:1608:3: kw= 'prj2'
                    {
                    kw=(Token)match(input,59,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getPrj2Keyword_14());
                    		

                    }
                    break;
                case 16 :
                    // InternalStatemachine.g:1614:3: kw= 'ran'
                    {
                    kw=(Token)match(input,60,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getRanKeyword_15());
                    		

                    }
                    break;
                case 17 :
                    // InternalStatemachine.g:1620:3: kw= 'succ'
                    {
                    kw=(Token)match(input,61,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getSuccKeyword_16());
                    		

                    }
                    break;
                case 18 :
                    // InternalStatemachine.g:1626:3: kw= 'union'
                    {
                    kw=(Token)match(input,62,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getUnionKeyword_17());
                    		

                    }
                    break;
                case 19 :
                    // InternalStatemachine.g:1632:3: kw= '\\u21151'
                    {
                    kw=(Token)match(input,63,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalNDigitOneKeyword_18());
                    		

                    }
                    break;
                case 20 :
                    // InternalStatemachine.g:1638:3: kw= '\\u2115'
                    {
                    kw=(Token)match(input,64,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalNKeyword_19());
                    		

                    }
                    break;
                case 21 :
                    // InternalStatemachine.g:1644:3: kw= '\\u21191'
                    {
                    kw=(Token)match(input,65,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalPDigitOneKeyword_20());
                    		

                    }
                    break;
                case 22 :
                    // InternalStatemachine.g:1650:3: kw= '\\u2119'
                    {
                    kw=(Token)match(input,31,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalPKeyword_21());
                    		

                    }
                    break;
                case 23 :
                    // InternalStatemachine.g:1656:3: kw= '\\u2124'
                    {
                    kw=(Token)match(input,33,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalZKeyword_22());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEVENTB_IDENTIFIER_KEYWORD"


    // $ANTLR start "entryRuleEVENTB_PREDICATE_SYMBOLS"
    // InternalStatemachine.g:1665:1: entryRuleEVENTB_PREDICATE_SYMBOLS returns [String current=null] : iv_ruleEVENTB_PREDICATE_SYMBOLS= ruleEVENTB_PREDICATE_SYMBOLS EOF ;
    public final String entryRuleEVENTB_PREDICATE_SYMBOLS() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEVENTB_PREDICATE_SYMBOLS = null;


        try {
            // InternalStatemachine.g:1665:64: (iv_ruleEVENTB_PREDICATE_SYMBOLS= ruleEVENTB_PREDICATE_SYMBOLS EOF )
            // InternalStatemachine.g:1666:2: iv_ruleEVENTB_PREDICATE_SYMBOLS= ruleEVENTB_PREDICATE_SYMBOLS EOF
            {
             newCompositeNode(grammarAccess.getEVENTB_PREDICATE_SYMBOLSRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEVENTB_PREDICATE_SYMBOLS=ruleEVENTB_PREDICATE_SYMBOLS();

            state._fsp--;

             current =iv_ruleEVENTB_PREDICATE_SYMBOLS.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEVENTB_PREDICATE_SYMBOLS"


    // $ANTLR start "ruleEVENTB_PREDICATE_SYMBOLS"
    // InternalStatemachine.g:1672:1: ruleEVENTB_PREDICATE_SYMBOLS returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '(' | kw= ')' | kw= '\\u21D4' | kw= '\\u21D2' | kw= '\\u2227' | kw= '&' | kw= '\\u2228' | kw= '\\u00AC' | kw= '\\u22A4' | kw= '\\u22A5' | kw= '\\u2200' | kw= '!' | kw= '\\u2203' | kw= '#' | kw= ',' | kw= '\\u00B7' | kw= '.' | kw= '=' | kw= '\\u2260' | kw= '\\u2264' | kw= '<' | kw= '\\u2265' | kw= '>' | kw= '\\u2208' | kw= ':' | kw= '\\u2209' | kw= '\\u2282' | kw= '\\u2284' | kw= '\\u2286' | kw= '\\u2288' | kw= 'partition' ) ;
    public final AntlrDatatypeRuleToken ruleEVENTB_PREDICATE_SYMBOLS() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalStatemachine.g:1678:2: ( (kw= '(' | kw= ')' | kw= '\\u21D4' | kw= '\\u21D2' | kw= '\\u2227' | kw= '&' | kw= '\\u2228' | kw= '\\u00AC' | kw= '\\u22A4' | kw= '\\u22A5' | kw= '\\u2200' | kw= '!' | kw= '\\u2203' | kw= '#' | kw= ',' | kw= '\\u00B7' | kw= '.' | kw= '=' | kw= '\\u2260' | kw= '\\u2264' | kw= '<' | kw= '\\u2265' | kw= '>' | kw= '\\u2208' | kw= ':' | kw= '\\u2209' | kw= '\\u2282' | kw= '\\u2284' | kw= '\\u2286' | kw= '\\u2288' | kw= 'partition' ) )
            // InternalStatemachine.g:1679:2: (kw= '(' | kw= ')' | kw= '\\u21D4' | kw= '\\u21D2' | kw= '\\u2227' | kw= '&' | kw= '\\u2228' | kw= '\\u00AC' | kw= '\\u22A4' | kw= '\\u22A5' | kw= '\\u2200' | kw= '!' | kw= '\\u2203' | kw= '#' | kw= ',' | kw= '\\u00B7' | kw= '.' | kw= '=' | kw= '\\u2260' | kw= '\\u2264' | kw= '<' | kw= '\\u2265' | kw= '>' | kw= '\\u2208' | kw= ':' | kw= '\\u2209' | kw= '\\u2282' | kw= '\\u2284' | kw= '\\u2286' | kw= '\\u2288' | kw= 'partition' )
            {
            // InternalStatemachine.g:1679:2: (kw= '(' | kw= ')' | kw= '\\u21D4' | kw= '\\u21D2' | kw= '\\u2227' | kw= '&' | kw= '\\u2228' | kw= '\\u00AC' | kw= '\\u22A4' | kw= '\\u22A5' | kw= '\\u2200' | kw= '!' | kw= '\\u2203' | kw= '#' | kw= ',' | kw= '\\u00B7' | kw= '.' | kw= '=' | kw= '\\u2260' | kw= '\\u2264' | kw= '<' | kw= '\\u2265' | kw= '>' | kw= '\\u2208' | kw= ':' | kw= '\\u2209' | kw= '\\u2282' | kw= '\\u2284' | kw= '\\u2286' | kw= '\\u2288' | kw= 'partition' )
            int alt33=31;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt33=1;
                }
                break;
            case 14:
                {
                alt33=2;
                }
                break;
            case 66:
                {
                alt33=3;
                }
                break;
            case 67:
                {
                alt33=4;
                }
                break;
            case 68:
                {
                alt33=5;
                }
                break;
            case 69:
                {
                alt33=6;
                }
                break;
            case 70:
                {
                alt33=7;
                }
                break;
            case 71:
                {
                alt33=8;
                }
                break;
            case 72:
                {
                alt33=9;
                }
                break;
            case 73:
                {
                alt33=10;
                }
                break;
            case 74:
                {
                alt33=11;
                }
                break;
            case 75:
                {
                alt33=12;
                }
                break;
            case 76:
                {
                alt33=13;
                }
                break;
            case 77:
                {
                alt33=14;
                }
                break;
            case 24:
                {
                alt33=15;
                }
                break;
            case 78:
                {
                alt33=16;
                }
                break;
            case 79:
                {
                alt33=17;
                }
                break;
            case 80:
                {
                alt33=18;
                }
                break;
            case 81:
                {
                alt33=19;
                }
                break;
            case 82:
                {
                alt33=20;
                }
                break;
            case 83:
                {
                alt33=21;
                }
                break;
            case 84:
                {
                alt33=22;
                }
                break;
            case 85:
                {
                alt33=23;
                }
                break;
            case 86:
                {
                alt33=24;
                }
                break;
            case 29:
                {
                alt33=25;
                }
                break;
            case 87:
                {
                alt33=26;
                }
                break;
            case 88:
                {
                alt33=27;
                }
                break;
            case 89:
                {
                alt33=28;
                }
                break;
            case 90:
                {
                alt33=29;
                }
                break;
            case 91:
                {
                alt33=30;
                }
                break;
            case 92:
                {
                alt33=31;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // InternalStatemachine.g:1680:3: kw= '('
                    {
                    kw=(Token)match(input,13,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLeftParenthesisKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalStatemachine.g:1686:3: kw= ')'
                    {
                    kw=(Token)match(input,14,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getRightParenthesisKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalStatemachine.g:1692:3: kw= '\\u21D4'
                    {
                    kw=(Token)match(input,66,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLeftRightDoubleArrowKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalStatemachine.g:1698:3: kw= '\\u21D2'
                    {
                    kw=(Token)match(input,67,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getRightwardsDoubleArrowKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalStatemachine.g:1704:3: kw= '\\u2227'
                    {
                    kw=(Token)match(input,68,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLogicalAndKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalStatemachine.g:1710:3: kw= '&'
                    {
                    kw=(Token)match(input,69,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getAmpersandKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalStatemachine.g:1716:3: kw= '\\u2228'
                    {
                    kw=(Token)match(input,70,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLogicalOrKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalStatemachine.g:1722:3: kw= '\\u00AC'
                    {
                    kw=(Token)match(input,71,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotSignKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalStatemachine.g:1728:3: kw= '\\u22A4'
                    {
                    kw=(Token)match(input,72,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getDownTackKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalStatemachine.g:1734:3: kw= '\\u22A5'
                    {
                    kw=(Token)match(input,73,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getUpTackKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalStatemachine.g:1740:3: kw= '\\u2200'
                    {
                    kw=(Token)match(input,74,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getForAllKeyword_10());
                    		

                    }
                    break;
                case 12 :
                    // InternalStatemachine.g:1746:3: kw= '!'
                    {
                    kw=(Token)match(input,75,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getExclamationMarkKeyword_11());
                    		

                    }
                    break;
                case 13 :
                    // InternalStatemachine.g:1752:3: kw= '\\u2203'
                    {
                    kw=(Token)match(input,76,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getThereExistsKeyword_12());
                    		

                    }
                    break;
                case 14 :
                    // InternalStatemachine.g:1758:3: kw= '#'
                    {
                    kw=(Token)match(input,77,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNumberSignKeyword_13());
                    		

                    }
                    break;
                case 15 :
                    // InternalStatemachine.g:1764:3: kw= ','
                    {
                    kw=(Token)match(input,24,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getCommaKeyword_14());
                    		

                    }
                    break;
                case 16 :
                    // InternalStatemachine.g:1770:3: kw= '\\u00B7'
                    {
                    kw=(Token)match(input,78,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getMiddleDotKeyword_15());
                    		

                    }
                    break;
                case 17 :
                    // InternalStatemachine.g:1776:3: kw= '.'
                    {
                    kw=(Token)match(input,79,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getFullStopKeyword_16());
                    		

                    }
                    break;
                case 18 :
                    // InternalStatemachine.g:1782:3: kw= '='
                    {
                    kw=(Token)match(input,80,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getEqualsSignKeyword_17());
                    		

                    }
                    break;
                case 19 :
                    // InternalStatemachine.g:1788:3: kw= '\\u2260'
                    {
                    kw=(Token)match(input,81,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotEqualToKeyword_18());
                    		

                    }
                    break;
                case 20 :
                    // InternalStatemachine.g:1794:3: kw= '\\u2264'
                    {
                    kw=(Token)match(input,82,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLessThanOrEqualToKeyword_19());
                    		

                    }
                    break;
                case 21 :
                    // InternalStatemachine.g:1800:3: kw= '<'
                    {
                    kw=(Token)match(input,83,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLessThanSignKeyword_20());
                    		

                    }
                    break;
                case 22 :
                    // InternalStatemachine.g:1806:3: kw= '\\u2265'
                    {
                    kw=(Token)match(input,84,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getGreaterThanOrEqualToKeyword_21());
                    		

                    }
                    break;
                case 23 :
                    // InternalStatemachine.g:1812:3: kw= '>'
                    {
                    kw=(Token)match(input,85,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getGreaterThanSignKeyword_22());
                    		

                    }
                    break;
                case 24 :
                    // InternalStatemachine.g:1818:3: kw= '\\u2208'
                    {
                    kw=(Token)match(input,86,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getElementOfKeyword_23());
                    		

                    }
                    break;
                case 25 :
                    // InternalStatemachine.g:1824:3: kw= ':'
                    {
                    kw=(Token)match(input,29,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getColonKeyword_24());
                    		

                    }
                    break;
                case 26 :
                    // InternalStatemachine.g:1830:3: kw= '\\u2209'
                    {
                    kw=(Token)match(input,87,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotAnElementOfKeyword_25());
                    		

                    }
                    break;
                case 27 :
                    // InternalStatemachine.g:1836:3: kw= '\\u2282'
                    {
                    kw=(Token)match(input,88,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getSubsetOfKeyword_26());
                    		

                    }
                    break;
                case 28 :
                    // InternalStatemachine.g:1842:3: kw= '\\u2284'
                    {
                    kw=(Token)match(input,89,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotASubsetOfKeyword_27());
                    		

                    }
                    break;
                case 29 :
                    // InternalStatemachine.g:1848:3: kw= '\\u2286'
                    {
                    kw=(Token)match(input,90,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getSubsetOfOrEqualToKeyword_28());
                    		

                    }
                    break;
                case 30 :
                    // InternalStatemachine.g:1854:3: kw= '\\u2288'
                    {
                    kw=(Token)match(input,91,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNeitherASubsetOfNorEqualToKeyword_29());
                    		

                    }
                    break;
                case 31 :
                    // InternalStatemachine.g:1860:3: kw= 'partition'
                    {
                    kw=(Token)match(input,92,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getPartitionKeyword_30());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEVENTB_PREDICATE_SYMBOLS"


    // $ANTLR start "entryRuleEVENTB_EXPRESSION_SYMBOLS"
    // InternalStatemachine.g:1869:1: entryRuleEVENTB_EXPRESSION_SYMBOLS returns [String current=null] : iv_ruleEVENTB_EXPRESSION_SYMBOLS= ruleEVENTB_EXPRESSION_SYMBOLS EOF ;
    public final String entryRuleEVENTB_EXPRESSION_SYMBOLS() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEVENTB_EXPRESSION_SYMBOLS = null;


        try {
            // InternalStatemachine.g:1869:65: (iv_ruleEVENTB_EXPRESSION_SYMBOLS= ruleEVENTB_EXPRESSION_SYMBOLS EOF )
            // InternalStatemachine.g:1870:2: iv_ruleEVENTB_EXPRESSION_SYMBOLS= ruleEVENTB_EXPRESSION_SYMBOLS EOF
            {
             newCompositeNode(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEVENTB_EXPRESSION_SYMBOLS=ruleEVENTB_EXPRESSION_SYMBOLS();

            state._fsp--;

             current =iv_ruleEVENTB_EXPRESSION_SYMBOLS.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEVENTB_EXPRESSION_SYMBOLS"


    // $ANTLR start "ruleEVENTB_EXPRESSION_SYMBOLS"
    // InternalStatemachine.g:1876:1: ruleEVENTB_EXPRESSION_SYMBOLS returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '\\u2194' | kw= '\\uE100' | kw= '\\uE101' | kw= '\\uE102' | kw= '\\u21F8' | kw= '\\u2192' | kw= '\\u2914' | kw= '\\u21A3' | kw= '\\u2900' | kw= '\\u21A0' | kw= '\\u2916' | kw= '{' | kw= '}' | kw= '\\u21A6' | kw= '\\u2205' | kw= '\\u2229' | kw= '\\u222A' | kw= '\\u2216' | kw= '\\u00D7' | kw= '[' | kw= ']' | kw= '\\uE103' | kw= '\\u2218' | kw= ';' | kw= '\\u2297' | kw= '\\u2225' | kw= '\\u223C' | kw= '\\u25C1' | kw= '\\u2A64' | kw= '\\u25B7' | kw= '\\u2A65' | kw= '\\u03BB' | (kw= '%' kw= '\\u22C2' ) | kw= '\\u22C3' | kw= '\\u2223' | kw= '\\u2025' | kw= '+' | kw= '\\u2212' | kw= '-' | kw= '\\u2217' | kw= '*' | kw= '\\u00F7' | kw= '/' | kw= '^' | kw= '\\\\' ) ;
    public final AntlrDatatypeRuleToken ruleEVENTB_EXPRESSION_SYMBOLS() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalStatemachine.g:1882:2: ( (kw= '\\u2194' | kw= '\\uE100' | kw= '\\uE101' | kw= '\\uE102' | kw= '\\u21F8' | kw= '\\u2192' | kw= '\\u2914' | kw= '\\u21A3' | kw= '\\u2900' | kw= '\\u21A0' | kw= '\\u2916' | kw= '{' | kw= '}' | kw= '\\u21A6' | kw= '\\u2205' | kw= '\\u2229' | kw= '\\u222A' | kw= '\\u2216' | kw= '\\u00D7' | kw= '[' | kw= ']' | kw= '\\uE103' | kw= '\\u2218' | kw= ';' | kw= '\\u2297' | kw= '\\u2225' | kw= '\\u223C' | kw= '\\u25C1' | kw= '\\u2A64' | kw= '\\u25B7' | kw= '\\u2A65' | kw= '\\u03BB' | (kw= '%' kw= '\\u22C2' ) | kw= '\\u22C3' | kw= '\\u2223' | kw= '\\u2025' | kw= '+' | kw= '\\u2212' | kw= '-' | kw= '\\u2217' | kw= '*' | kw= '\\u00F7' | kw= '/' | kw= '^' | kw= '\\\\' ) )
            // InternalStatemachine.g:1883:2: (kw= '\\u2194' | kw= '\\uE100' | kw= '\\uE101' | kw= '\\uE102' | kw= '\\u21F8' | kw= '\\u2192' | kw= '\\u2914' | kw= '\\u21A3' | kw= '\\u2900' | kw= '\\u21A0' | kw= '\\u2916' | kw= '{' | kw= '}' | kw= '\\u21A6' | kw= '\\u2205' | kw= '\\u2229' | kw= '\\u222A' | kw= '\\u2216' | kw= '\\u00D7' | kw= '[' | kw= ']' | kw= '\\uE103' | kw= '\\u2218' | kw= ';' | kw= '\\u2297' | kw= '\\u2225' | kw= '\\u223C' | kw= '\\u25C1' | kw= '\\u2A64' | kw= '\\u25B7' | kw= '\\u2A65' | kw= '\\u03BB' | (kw= '%' kw= '\\u22C2' ) | kw= '\\u22C3' | kw= '\\u2223' | kw= '\\u2025' | kw= '+' | kw= '\\u2212' | kw= '-' | kw= '\\u2217' | kw= '*' | kw= '\\u00F7' | kw= '/' | kw= '^' | kw= '\\\\' )
            {
            // InternalStatemachine.g:1883:2: (kw= '\\u2194' | kw= '\\uE100' | kw= '\\uE101' | kw= '\\uE102' | kw= '\\u21F8' | kw= '\\u2192' | kw= '\\u2914' | kw= '\\u21A3' | kw= '\\u2900' | kw= '\\u21A0' | kw= '\\u2916' | kw= '{' | kw= '}' | kw= '\\u21A6' | kw= '\\u2205' | kw= '\\u2229' | kw= '\\u222A' | kw= '\\u2216' | kw= '\\u00D7' | kw= '[' | kw= ']' | kw= '\\uE103' | kw= '\\u2218' | kw= ';' | kw= '\\u2297' | kw= '\\u2225' | kw= '\\u223C' | kw= '\\u25C1' | kw= '\\u2A64' | kw= '\\u25B7' | kw= '\\u2A65' | kw= '\\u03BB' | (kw= '%' kw= '\\u22C2' ) | kw= '\\u22C3' | kw= '\\u2223' | kw= '\\u2025' | kw= '+' | kw= '\\u2212' | kw= '-' | kw= '\\u2217' | kw= '*' | kw= '\\u00F7' | kw= '/' | kw= '^' | kw= '\\\\' )
            int alt34=45;
            switch ( input.LA(1) ) {
            case 93:
                {
                alt34=1;
                }
                break;
            case 94:
                {
                alt34=2;
                }
                break;
            case 95:
                {
                alt34=3;
                }
                break;
            case 96:
                {
                alt34=4;
                }
                break;
            case 97:
                {
                alt34=5;
                }
                break;
            case 98:
                {
                alt34=6;
                }
                break;
            case 99:
                {
                alt34=7;
                }
                break;
            case 100:
                {
                alt34=8;
                }
                break;
            case 101:
                {
                alt34=9;
                }
                break;
            case 102:
                {
                alt34=10;
                }
                break;
            case 103:
                {
                alt34=11;
                }
                break;
            case 104:
                {
                alt34=12;
                }
                break;
            case 105:
                {
                alt34=13;
                }
                break;
            case 106:
                {
                alt34=14;
                }
                break;
            case 107:
                {
                alt34=15;
                }
                break;
            case 108:
                {
                alt34=16;
                }
                break;
            case 109:
                {
                alt34=17;
                }
                break;
            case 110:
                {
                alt34=18;
                }
                break;
            case 30:
                {
                alt34=19;
                }
                break;
            case 111:
                {
                alt34=20;
                }
                break;
            case 112:
                {
                alt34=21;
                }
                break;
            case 113:
                {
                alt34=22;
                }
                break;
            case 114:
                {
                alt34=23;
                }
                break;
            case 115:
                {
                alt34=24;
                }
                break;
            case 116:
                {
                alt34=25;
                }
                break;
            case 117:
                {
                alt34=26;
                }
                break;
            case 118:
                {
                alt34=27;
                }
                break;
            case 119:
                {
                alt34=28;
                }
                break;
            case 120:
                {
                alt34=29;
                }
                break;
            case 121:
                {
                alt34=30;
                }
                break;
            case 122:
                {
                alt34=31;
                }
                break;
            case 123:
                {
                alt34=32;
                }
                break;
            case 124:
                {
                alt34=33;
                }
                break;
            case 126:
                {
                alt34=34;
                }
                break;
            case 127:
                {
                alt34=35;
                }
                break;
            case 128:
                {
                alt34=36;
                }
                break;
            case 129:
                {
                alt34=37;
                }
                break;
            case 130:
                {
                alt34=38;
                }
                break;
            case 131:
                {
                alt34=39;
                }
                break;
            case 132:
                {
                alt34=40;
                }
                break;
            case 133:
                {
                alt34=41;
                }
                break;
            case 134:
                {
                alt34=42;
                }
                break;
            case 135:
                {
                alt34=43;
                }
                break;
            case 136:
                {
                alt34=44;
                }
                break;
            case 137:
                {
                alt34=45;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // InternalStatemachine.g:1884:3: kw= '\\u2194'
                    {
                    kw=(Token)match(input,93,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLeftRightArrowKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalStatemachine.g:1890:3: kw= '\\uE100'
                    {
                    kw=(Token)match(input,94,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE100Keyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalStatemachine.g:1896:3: kw= '\\uE101'
                    {
                    kw=(Token)match(input,95,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE101Keyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalStatemachine.g:1902:3: kw= '\\uE102'
                    {
                    kw=(Token)match(input,96,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE102Keyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalStatemachine.g:1908:3: kw= '\\u21F8'
                    {
                    kw=(Token)match(input,97,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowWithVerticalStrokeKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalStatemachine.g:1914:3: kw= '\\u2192'
                    {
                    kw=(Token)match(input,98,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalStatemachine.g:1920:3: kw= '\\u2914'
                    {
                    kw=(Token)match(input,99,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowWithTailWithVerticalStrokeKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalStatemachine.g:1926:3: kw= '\\u21A3'
                    {
                    kw=(Token)match(input,100,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowWithTailKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalStatemachine.g:1932:3: kw= '\\u2900'
                    {
                    kw=(Token)match(input,101,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsTwoHeadedArrowWithVerticalStrokeKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalStatemachine.g:1938:3: kw= '\\u21A0'
                    {
                    kw=(Token)match(input,102,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsTwoHeadedArrowKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalStatemachine.g:1944:3: kw= '\\u2916'
                    {
                    kw=(Token)match(input,103,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsTwoHeadedArrowWithTailKeyword_10());
                    		

                    }
                    break;
                case 12 :
                    // InternalStatemachine.g:1950:3: kw= '{'
                    {
                    kw=(Token)match(input,104,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLeftCurlyBracketKeyword_11());
                    		

                    }
                    break;
                case 13 :
                    // InternalStatemachine.g:1956:3: kw= '}'
                    {
                    kw=(Token)match(input,105,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightCurlyBracketKeyword_12());
                    		

                    }
                    break;
                case 14 :
                    // InternalStatemachine.g:1962:3: kw= '\\u21A6'
                    {
                    kw=(Token)match(input,106,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowFromBarKeyword_13());
                    		

                    }
                    break;
                case 15 :
                    // InternalStatemachine.g:1968:3: kw= '\\u2205'
                    {
                    kw=(Token)match(input,107,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getEmptySetKeyword_14());
                    		

                    }
                    break;
                case 16 :
                    // InternalStatemachine.g:1974:3: kw= '\\u2229'
                    {
                    kw=(Token)match(input,108,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getIntersectionKeyword_15());
                    		

                    }
                    break;
                case 17 :
                    // InternalStatemachine.g:1980:3: kw= '\\u222A'
                    {
                    kw=(Token)match(input,109,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getUnionKeyword_16());
                    		

                    }
                    break;
                case 18 :
                    // InternalStatemachine.g:1986:3: kw= '\\u2216'
                    {
                    kw=(Token)match(input,110,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getSetMinusKeyword_17());
                    		

                    }
                    break;
                case 19 :
                    // InternalStatemachine.g:1992:3: kw= '\\u00D7'
                    {
                    kw=(Token)match(input,30,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getMultiplicationSignKeyword_18());
                    		

                    }
                    break;
                case 20 :
                    // InternalStatemachine.g:1998:3: kw= '['
                    {
                    kw=(Token)match(input,111,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLeftSquareBracketKeyword_19());
                    		

                    }
                    break;
                case 21 :
                    // InternalStatemachine.g:2004:3: kw= ']'
                    {
                    kw=(Token)match(input,112,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightSquareBracketKeyword_20());
                    		

                    }
                    break;
                case 22 :
                    // InternalStatemachine.g:2010:3: kw= '\\uE103'
                    {
                    kw=(Token)match(input,113,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE103Keyword_21());
                    		

                    }
                    break;
                case 23 :
                    // InternalStatemachine.g:2016:3: kw= '\\u2218'
                    {
                    kw=(Token)match(input,114,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRingOperatorKeyword_22());
                    		

                    }
                    break;
                case 24 :
                    // InternalStatemachine.g:2022:3: kw= ';'
                    {
                    kw=(Token)match(input,115,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getSemicolonKeyword_23());
                    		

                    }
                    break;
                case 25 :
                    // InternalStatemachine.g:2028:3: kw= '\\u2297'
                    {
                    kw=(Token)match(input,116,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getCircledTimesKeyword_24());
                    		

                    }
                    break;
                case 26 :
                    // InternalStatemachine.g:2034:3: kw= '\\u2225'
                    {
                    kw=(Token)match(input,117,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getParallelToKeyword_25());
                    		

                    }
                    break;
                case 27 :
                    // InternalStatemachine.g:2040:3: kw= '\\u223C'
                    {
                    kw=(Token)match(input,118,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getTildeOperatorKeyword_26());
                    		

                    }
                    break;
                case 28 :
                    // InternalStatemachine.g:2046:3: kw= '\\u25C1'
                    {
                    kw=(Token)match(input,119,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getWhiteLeftPointingTriangleKeyword_27());
                    		

                    }
                    break;
                case 29 :
                    // InternalStatemachine.g:2052:3: kw= '\\u2A64'
                    {
                    kw=(Token)match(input,120,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getZNotationDomainAntirestrictionKeyword_28());
                    		

                    }
                    break;
                case 30 :
                    // InternalStatemachine.g:2058:3: kw= '\\u25B7'
                    {
                    kw=(Token)match(input,121,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getWhiteRightPointingTriangleKeyword_29());
                    		

                    }
                    break;
                case 31 :
                    // InternalStatemachine.g:2064:3: kw= '\\u2A65'
                    {
                    kw=(Token)match(input,122,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getZNotationRangeAntirestrictionKeyword_30());
                    		

                    }
                    break;
                case 32 :
                    // InternalStatemachine.g:2070:3: kw= '\\u03BB'
                    {
                    kw=(Token)match(input,123,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getGreekSmallLetterLamdaKeyword_31());
                    		

                    }
                    break;
                case 33 :
                    // InternalStatemachine.g:2076:3: (kw= '%' kw= '\\u22C2' )
                    {
                    // InternalStatemachine.g:2076:3: (kw= '%' kw= '\\u22C2' )
                    // InternalStatemachine.g:2077:4: kw= '%' kw= '\\u22C2'
                    {
                    kw=(Token)match(input,124,FOLLOW_39); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPercentSignKeyword_32_0());
                    			
                    kw=(Token)match(input,125,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getNAryIntersectionKeyword_32_1());
                    			

                    }


                    }
                    break;
                case 34 :
                    // InternalStatemachine.g:2089:3: kw= '\\u22C3'
                    {
                    kw=(Token)match(input,126,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getNAryUnionKeyword_33());
                    		

                    }
                    break;
                case 35 :
                    // InternalStatemachine.g:2095:3: kw= '\\u2223'
                    {
                    kw=(Token)match(input,127,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getDividesKeyword_34());
                    		

                    }
                    break;
                case 36 :
                    // InternalStatemachine.g:2101:3: kw= '\\u2025'
                    {
                    kw=(Token)match(input,128,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getTwoDotLeaderKeyword_35());
                    		

                    }
                    break;
                case 37 :
                    // InternalStatemachine.g:2107:3: kw= '+'
                    {
                    kw=(Token)match(input,129,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPlusSignKeyword_36());
                    		

                    }
                    break;
                case 38 :
                    // InternalStatemachine.g:2113:3: kw= '\\u2212'
                    {
                    kw=(Token)match(input,130,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getMinusSignKeyword_37());
                    		

                    }
                    break;
                case 39 :
                    // InternalStatemachine.g:2119:3: kw= '-'
                    {
                    kw=(Token)match(input,131,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getHyphenMinusKeyword_38());
                    		

                    }
                    break;
                case 40 :
                    // InternalStatemachine.g:2125:3: kw= '\\u2217'
                    {
                    kw=(Token)match(input,132,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getAsteriskOperatorKeyword_39());
                    		

                    }
                    break;
                case 41 :
                    // InternalStatemachine.g:2131:3: kw= '*'
                    {
                    kw=(Token)match(input,133,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getAsteriskKeyword_40());
                    		

                    }
                    break;
                case 42 :
                    // InternalStatemachine.g:2137:3: kw= '\\u00F7'
                    {
                    kw=(Token)match(input,134,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getDivisionSignKeyword_41());
                    		

                    }
                    break;
                case 43 :
                    // InternalStatemachine.g:2143:3: kw= '/'
                    {
                    kw=(Token)match(input,135,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getSolidusKeyword_42());
                    		

                    }
                    break;
                case 44 :
                    // InternalStatemachine.g:2149:3: kw= '^'
                    {
                    kw=(Token)match(input,136,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getCircumflexAccentKeyword_43());
                    		

                    }
                    break;
                case 45 :
                    // InternalStatemachine.g:2155:3: kw= '\\\\'
                    {
                    kw=(Token)match(input,137,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getBackslashKeyword_44());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEVENTB_EXPRESSION_SYMBOLS"


    // $ANTLR start "ruleTranslationKind"
    // InternalStatemachine.g:2164:1: ruleTranslationKind returns [Enumerator current=null] : ( (enumLiteral_0= 'enumeration' ) | (enumLiteral_1= 'variables' ) | (enumLiteral_2= 'REFINEDVAR' ) ) ;
    public final Enumerator ruleTranslationKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalStatemachine.g:2170:2: ( ( (enumLiteral_0= 'enumeration' ) | (enumLiteral_1= 'variables' ) | (enumLiteral_2= 'REFINEDVAR' ) ) )
            // InternalStatemachine.g:2171:2: ( (enumLiteral_0= 'enumeration' ) | (enumLiteral_1= 'variables' ) | (enumLiteral_2= 'REFINEDVAR' ) )
            {
            // InternalStatemachine.g:2171:2: ( (enumLiteral_0= 'enumeration' ) | (enumLiteral_1= 'variables' ) | (enumLiteral_2= 'REFINEDVAR' ) )
            int alt35=3;
            switch ( input.LA(1) ) {
            case 138:
                {
                alt35=1;
                }
                break;
            case 139:
                {
                alt35=2;
                }
                break;
            case 140:
                {
                alt35=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // InternalStatemachine.g:2172:3: (enumLiteral_0= 'enumeration' )
                    {
                    // InternalStatemachine.g:2172:3: (enumLiteral_0= 'enumeration' )
                    // InternalStatemachine.g:2173:4: enumLiteral_0= 'enumeration'
                    {
                    enumLiteral_0=(Token)match(input,138,FOLLOW_2); 

                    				current = grammarAccess.getTranslationKindAccess().getMULTIVAREnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getTranslationKindAccess().getMULTIVAREnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalStatemachine.g:2180:3: (enumLiteral_1= 'variables' )
                    {
                    // InternalStatemachine.g:2180:3: (enumLiteral_1= 'variables' )
                    // InternalStatemachine.g:2181:4: enumLiteral_1= 'variables'
                    {
                    enumLiteral_1=(Token)match(input,139,FOLLOW_2); 

                    				current = grammarAccess.getTranslationKindAccess().getSINGLEVAREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getTranslationKindAccess().getSINGLEVAREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalStatemachine.g:2188:3: (enumLiteral_2= 'REFINEDVAR' )
                    {
                    // InternalStatemachine.g:2188:3: (enumLiteral_2= 'REFINEDVAR' )
                    // InternalStatemachine.g:2189:4: enumLiteral_2= 'REFINEDVAR'
                    {
                    enumLiteral_2=(Token)match(input,140,FOLLOW_2); 

                    				current = grammarAccess.getTranslationKindAccess().getREFINEDVAREnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getTranslationKindAccess().getREFINEDVAREnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTranslationKind"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001C00L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00003E0800058002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00003E0800050002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00003E0800040002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000380000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000300030L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x000000001E800000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x000000001F000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000400000040L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x000000041C000040L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000018000040L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000010000040L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000380000010L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0xFFFFC003E1006090L,0xDFFFFFFFFFFFFFFFL,0x00000000000003FFL});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x000001D000008002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x000001D000000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000010001000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x000001C000000002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000018400000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000010000000042L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0xFFFFC003E1006092L,0xDFFFFFFFFFFFFFFFL,0x00000000000003FFL});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});

}
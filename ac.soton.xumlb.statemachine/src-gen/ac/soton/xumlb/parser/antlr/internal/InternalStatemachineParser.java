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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_XLABEL", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'statemachine'", "'('", "')'", "'annotates'", "'refines'", "'instances'", "'selfName'", "'.'", "'transition'", "'elaborates'", "'extended'", "'source'", "'target'", "'any'", "','", "'where'", "'then'", "'with'", "'end'", "':'", "'\\u00D7'", "'\\u2119'", "'BOOL'", "'\\u2124'", "'theorem'", "'State'", "'statemachines'", "'begin'", "'invariants'", "'entryActions'", "'exitActions'", "'Initial'", "'Final'", "'Any'", "'Junction'", "'Fork'", "'FALSE'", "'TRUE'", "'bool'", "'card'", "'dom'", "'finite'", "'id'", "'inter'", "'max'", "'min'", "'mod'", "'pred'", "'prj1'", "'prj2'", "'ran'", "'succ'", "'union'", "'\\u21151'", "'\\u2115'", "'\\u21191'", "'\\u21D4'", "'\\u21D2'", "'\\u2227'", "'&'", "'\\u2228'", "'\\u00AC'", "'\\u22A4'", "'\\u22A5'", "'\\u2200'", "'!'", "'\\u2203'", "'#'", "'\\u00B7'", "'='", "'\\u2260'", "'\\u2264'", "'<'", "'\\u2265'", "'>'", "'\\u2208'", "'\\u2209'", "'\\u2282'", "'\\u2284'", "'\\u2286'", "'\\u2288'", "'partition'", "'\\u2194'", "'\\uE100'", "'\\uE101'", "'\\uE102'", "'\\u21F8'", "'\\u2192'", "'\\u2914'", "'\\u21A3'", "'\\u2900'", "'\\u21A0'", "'\\u2916'", "'{'", "'}'", "'\\u21A6'", "'\\u2205'", "'\\u2229'", "'\\u222A'", "'\\u2216'", "'['", "']'", "'\\uE103'", "'\\u2218'", "';'", "'\\u2297'", "'\\u2225'", "'\\u223C'", "'\\u25C1'", "'\\u2A64'", "'\\u25B7'", "'\\u2A65'", "'\\u03BB'", "'%'", "'\\u22C2'", "'\\u22C3'", "'\\u2223'", "'\\u2025'", "'+'", "'\\u2212'", "'-'", "'\\u2217'", "'*'", "'\\u00F7'", "'/'", "'^'", "'\\\\'", "'variables'", "'enumeration'", "'REFINEDVAR'"
    };
    public static final int T__50=50;
    public static final int T__140=140;
    public static final int T__141=141;
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
    // InternalStatemachine.g:72:1: ruleStatemachine returns [EObject current=null] : (otherlv_0= 'statemachine' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_translation_3_0= ruleTranslationKind ) ) otherlv_4= ')' (otherlv_5= 'annotates' ( (lv_comment_6_0= ruleEString ) ) )? (otherlv_7= 'refines' ( ( ruleQualifiedName ) ) )? (otherlv_9= 'instances' ( ( ruleQualifiedName ) ) otherlv_11= 'selfName' ( (lv_selfName_12_0= ruleEString ) ) )? ( (lv_nodes_13_0= ruleAbstractNode ) )* ( (lv_transitions_14_0= ruleTransition ) )* ) ;
    public final EObject ruleStatemachine() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Enumerator lv_translation_3_0 = null;

        AntlrDatatypeRuleToken lv_comment_6_0 = null;

        AntlrDatatypeRuleToken lv_selfName_12_0 = null;

        EObject lv_nodes_13_0 = null;

        EObject lv_transitions_14_0 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:78:2: ( (otherlv_0= 'statemachine' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_translation_3_0= ruleTranslationKind ) ) otherlv_4= ')' (otherlv_5= 'annotates' ( (lv_comment_6_0= ruleEString ) ) )? (otherlv_7= 'refines' ( ( ruleQualifiedName ) ) )? (otherlv_9= 'instances' ( ( ruleQualifiedName ) ) otherlv_11= 'selfName' ( (lv_selfName_12_0= ruleEString ) ) )? ( (lv_nodes_13_0= ruleAbstractNode ) )* ( (lv_transitions_14_0= ruleTransition ) )* ) )
            // InternalStatemachine.g:79:2: (otherlv_0= 'statemachine' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_translation_3_0= ruleTranslationKind ) ) otherlv_4= ')' (otherlv_5= 'annotates' ( (lv_comment_6_0= ruleEString ) ) )? (otherlv_7= 'refines' ( ( ruleQualifiedName ) ) )? (otherlv_9= 'instances' ( ( ruleQualifiedName ) ) otherlv_11= 'selfName' ( (lv_selfName_12_0= ruleEString ) ) )? ( (lv_nodes_13_0= ruleAbstractNode ) )* ( (lv_transitions_14_0= ruleTransition ) )* )
            {
            // InternalStatemachine.g:79:2: (otherlv_0= 'statemachine' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_translation_3_0= ruleTranslationKind ) ) otherlv_4= ')' (otherlv_5= 'annotates' ( (lv_comment_6_0= ruleEString ) ) )? (otherlv_7= 'refines' ( ( ruleQualifiedName ) ) )? (otherlv_9= 'instances' ( ( ruleQualifiedName ) ) otherlv_11= 'selfName' ( (lv_selfName_12_0= ruleEString ) ) )? ( (lv_nodes_13_0= ruleAbstractNode ) )* ( (lv_transitions_14_0= ruleTransition ) )* )
            // InternalStatemachine.g:80:3: otherlv_0= 'statemachine' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_translation_3_0= ruleTranslationKind ) ) otherlv_4= ')' (otherlv_5= 'annotates' ( (lv_comment_6_0= ruleEString ) ) )? (otherlv_7= 'refines' ( ( ruleQualifiedName ) ) )? (otherlv_9= 'instances' ( ( ruleQualifiedName ) ) otherlv_11= 'selfName' ( (lv_selfName_12_0= ruleEString ) ) )? ( (lv_nodes_13_0= ruleAbstractNode ) )* ( (lv_transitions_14_0= ruleTransition ) )*
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
            		
            // InternalStatemachine.g:129:3: (otherlv_5= 'annotates' ( (lv_comment_6_0= ruleEString ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==15) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalStatemachine.g:130:4: otherlv_5= 'annotates' ( (lv_comment_6_0= ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,15,FOLLOW_8); 

                    				newLeafNode(otherlv_5, grammarAccess.getStatemachineAccess().getAnnotatesKeyword_5_0());
                    			
                    // InternalStatemachine.g:134:4: ( (lv_comment_6_0= ruleEString ) )
                    // InternalStatemachine.g:135:5: (lv_comment_6_0= ruleEString )
                    {
                    // InternalStatemachine.g:135:5: (lv_comment_6_0= ruleEString )
                    // InternalStatemachine.g:136:6: lv_comment_6_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getStatemachineAccess().getCommentEStringParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_9);
                    lv_comment_6_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStatemachineRule());
                    						}
                    						set(
                    							current,
                    							"comment",
                    							lv_comment_6_0,
                    							"ac.soton.xumlb.Statemachine.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalStatemachine.g:154:3: (otherlv_7= 'refines' ( ( ruleQualifiedName ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==16) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalStatemachine.g:155:4: otherlv_7= 'refines' ( ( ruleQualifiedName ) )
                    {
                    otherlv_7=(Token)match(input,16,FOLLOW_3); 

                    				newLeafNode(otherlv_7, grammarAccess.getStatemachineAccess().getRefinesKeyword_6_0());
                    			
                    // InternalStatemachine.g:159:4: ( ( ruleQualifiedName ) )
                    // InternalStatemachine.g:160:5: ( ruleQualifiedName )
                    {
                    // InternalStatemachine.g:160:5: ( ruleQualifiedName )
                    // InternalStatemachine.g:161:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStatemachineRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getStatemachineAccess().getRefinesStatemachineCrossReference_6_1_0());
                    					
                    pushFollow(FOLLOW_10);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalStatemachine.g:176:3: (otherlv_9= 'instances' ( ( ruleQualifiedName ) ) otherlv_11= 'selfName' ( (lv_selfName_12_0= ruleEString ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==17) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalStatemachine.g:177:4: otherlv_9= 'instances' ( ( ruleQualifiedName ) ) otherlv_11= 'selfName' ( (lv_selfName_12_0= ruleEString ) )
                    {
                    otherlv_9=(Token)match(input,17,FOLLOW_3); 

                    				newLeafNode(otherlv_9, grammarAccess.getStatemachineAccess().getInstancesKeyword_7_0());
                    			
                    // InternalStatemachine.g:181:4: ( ( ruleQualifiedName ) )
                    // InternalStatemachine.g:182:5: ( ruleQualifiedName )
                    {
                    // InternalStatemachine.g:182:5: ( ruleQualifiedName )
                    // InternalStatemachine.g:183:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStatemachineRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getStatemachineAccess().getInstancesEventBNamedCommentedElementCrossReference_7_1_0());
                    					
                    pushFollow(FOLLOW_11);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,18,FOLLOW_8); 

                    				newLeafNode(otherlv_11, grammarAccess.getStatemachineAccess().getSelfNameKeyword_7_2());
                    			
                    // InternalStatemachine.g:201:4: ( (lv_selfName_12_0= ruleEString ) )
                    // InternalStatemachine.g:202:5: (lv_selfName_12_0= ruleEString )
                    {
                    // InternalStatemachine.g:202:5: (lv_selfName_12_0= ruleEString )
                    // InternalStatemachine.g:203:6: lv_selfName_12_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getStatemachineAccess().getSelfNameEStringParserRuleCall_7_3_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_selfName_12_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStatemachineRule());
                    						}
                    						set(
                    							current,
                    							"selfName",
                    							lv_selfName_12_0,
                    							"ac.soton.xumlb.Statemachine.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalStatemachine.g:221:3: ( (lv_nodes_13_0= ruleAbstractNode ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==37||(LA4_0>=43 && LA4_0<=47)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalStatemachine.g:222:4: (lv_nodes_13_0= ruleAbstractNode )
            	    {
            	    // InternalStatemachine.g:222:4: (lv_nodes_13_0= ruleAbstractNode )
            	    // InternalStatemachine.g:223:5: lv_nodes_13_0= ruleAbstractNode
            	    {

            	    					newCompositeNode(grammarAccess.getStatemachineAccess().getNodesAbstractNodeParserRuleCall_8_0());
            	    				
            	    pushFollow(FOLLOW_12);
            	    lv_nodes_13_0=ruleAbstractNode();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getStatemachineRule());
            	    					}
            	    					add(
            	    						current,
            	    						"nodes",
            	    						lv_nodes_13_0,
            	    						"ac.soton.xumlb.Statemachine.AbstractNode");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // InternalStatemachine.g:240:3: ( (lv_transitions_14_0= ruleTransition ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==20) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalStatemachine.g:241:4: (lv_transitions_14_0= ruleTransition )
            	    {
            	    // InternalStatemachine.g:241:4: (lv_transitions_14_0= ruleTransition )
            	    // InternalStatemachine.g:242:5: lv_transitions_14_0= ruleTransition
            	    {

            	    					newCompositeNode(grammarAccess.getStatemachineAccess().getTransitionsTransitionParserRuleCall_9_0());
            	    				
            	    pushFollow(FOLLOW_13);
            	    lv_transitions_14_0=ruleTransition();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getStatemachineRule());
            	    					}
            	    					add(
            	    						current,
            	    						"transitions",
            	    						lv_transitions_14_0,
            	    						"ac.soton.xumlb.Statemachine.Transition");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
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
    // InternalStatemachine.g:263:1: entryRuleAbstractNode returns [EObject current=null] : iv_ruleAbstractNode= ruleAbstractNode EOF ;
    public final EObject entryRuleAbstractNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractNode = null;


        try {
            // InternalStatemachine.g:263:53: (iv_ruleAbstractNode= ruleAbstractNode EOF )
            // InternalStatemachine.g:264:2: iv_ruleAbstractNode= ruleAbstractNode EOF
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
    // InternalStatemachine.g:270:1: ruleAbstractNode returns [EObject current=null] : (this_State_0= ruleState | this_Initial_1= ruleInitial | this_Final_2= ruleFinal | this_Any_3= ruleAny | this_Junction_4= ruleJunction | this_Fork_5= ruleFork ) ;
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
            // InternalStatemachine.g:276:2: ( (this_State_0= ruleState | this_Initial_1= ruleInitial | this_Final_2= ruleFinal | this_Any_3= ruleAny | this_Junction_4= ruleJunction | this_Fork_5= ruleFork ) )
            // InternalStatemachine.g:277:2: (this_State_0= ruleState | this_Initial_1= ruleInitial | this_Final_2= ruleFinal | this_Any_3= ruleAny | this_Junction_4= ruleJunction | this_Fork_5= ruleFork )
            {
            // InternalStatemachine.g:277:2: (this_State_0= ruleState | this_Initial_1= ruleInitial | this_Final_2= ruleFinal | this_Any_3= ruleAny | this_Junction_4= ruleJunction | this_Fork_5= ruleFork )
            int alt6=6;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt6=1;
                }
                break;
            case 43:
                {
                alt6=2;
                }
                break;
            case 44:
                {
                alt6=3;
                }
                break;
            case 45:
                {
                alt6=4;
                }
                break;
            case 46:
                {
                alt6=5;
                }
                break;
            case 47:
                {
                alt6=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalStatemachine.g:278:3: this_State_0= ruleState
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
                    // InternalStatemachine.g:287:3: this_Initial_1= ruleInitial
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
                    // InternalStatemachine.g:296:3: this_Final_2= ruleFinal
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
                    // InternalStatemachine.g:305:3: this_Any_3= ruleAny
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
                    // InternalStatemachine.g:314:3: this_Junction_4= ruleJunction
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
                    // InternalStatemachine.g:323:3: this_Fork_5= ruleFork
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
    // InternalStatemachine.g:335:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalStatemachine.g:335:47: (iv_ruleEString= ruleEString EOF )
            // InternalStatemachine.g:336:2: iv_ruleEString= ruleEString EOF
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
    // InternalStatemachine.g:342:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalStatemachine.g:348:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalStatemachine.g:349:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalStatemachine.g:349:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_STRING) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_ID) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalStatemachine.g:350:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalStatemachine.g:358:3: this_ID_1= RULE_ID
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


    // $ANTLR start "entryRuleQualifiedName"
    // InternalStatemachine.g:369:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalStatemachine.g:369:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalStatemachine.g:370:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalStatemachine.g:376:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalStatemachine.g:382:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? ) )
            // InternalStatemachine.g:383:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? )
            {
            // InternalStatemachine.g:383:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? )
            // InternalStatemachine.g:384:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_14); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalStatemachine.g:391:3: (kw= '.' this_ID_2= RULE_ID )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==19) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalStatemachine.g:392:4: kw= '.' this_ID_2= RULE_ID
                    {
                    kw=(Token)match(input,19,FOLLOW_3); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
                    			
                    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_2); 

                    				current.merge(this_ID_2);
                    			

                    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
                    			

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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleTransition"
    // InternalStatemachine.g:409:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // InternalStatemachine.g:409:51: (iv_ruleTransition= ruleTransition EOF )
            // InternalStatemachine.g:410:2: iv_ruleTransition= ruleTransition EOF
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
    // InternalStatemachine.g:416:1: ruleTransition returns [EObject current=null] : (otherlv_0= 'transition' (otherlv_1= 'elaborates' ( ( ruleEString ) )+ )? ( (lv_extended_3_0= 'extended' ) )? otherlv_4= 'source' ( ( ruleQualifiedName ) ) otherlv_6= 'target' ( ( ruleQualifiedName ) ) (otherlv_8= 'any' ( (lv_parameters_9_0= ruleTypedParameter ) ) (otherlv_10= ',' ( (lv_parameters_11_0= ruleTypedParameter ) ) )* )? (otherlv_12= 'where' ( (lv_guards_13_0= ruleGuard ) )+ )? (otherlv_14= 'then' ( (lv_actions_15_0= ruleAction ) )+ )? (otherlv_16= 'with' ( (lv_witnesses_17_0= ruleWitness ) )+ )? otherlv_18= 'end' ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_extended_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        EObject lv_parameters_9_0 = null;

        EObject lv_parameters_11_0 = null;

        EObject lv_guards_13_0 = null;

        EObject lv_actions_15_0 = null;

        EObject lv_witnesses_17_0 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:422:2: ( (otherlv_0= 'transition' (otherlv_1= 'elaborates' ( ( ruleEString ) )+ )? ( (lv_extended_3_0= 'extended' ) )? otherlv_4= 'source' ( ( ruleQualifiedName ) ) otherlv_6= 'target' ( ( ruleQualifiedName ) ) (otherlv_8= 'any' ( (lv_parameters_9_0= ruleTypedParameter ) ) (otherlv_10= ',' ( (lv_parameters_11_0= ruleTypedParameter ) ) )* )? (otherlv_12= 'where' ( (lv_guards_13_0= ruleGuard ) )+ )? (otherlv_14= 'then' ( (lv_actions_15_0= ruleAction ) )+ )? (otherlv_16= 'with' ( (lv_witnesses_17_0= ruleWitness ) )+ )? otherlv_18= 'end' ) )
            // InternalStatemachine.g:423:2: (otherlv_0= 'transition' (otherlv_1= 'elaborates' ( ( ruleEString ) )+ )? ( (lv_extended_3_0= 'extended' ) )? otherlv_4= 'source' ( ( ruleQualifiedName ) ) otherlv_6= 'target' ( ( ruleQualifiedName ) ) (otherlv_8= 'any' ( (lv_parameters_9_0= ruleTypedParameter ) ) (otherlv_10= ',' ( (lv_parameters_11_0= ruleTypedParameter ) ) )* )? (otherlv_12= 'where' ( (lv_guards_13_0= ruleGuard ) )+ )? (otherlv_14= 'then' ( (lv_actions_15_0= ruleAction ) )+ )? (otherlv_16= 'with' ( (lv_witnesses_17_0= ruleWitness ) )+ )? otherlv_18= 'end' )
            {
            // InternalStatemachine.g:423:2: (otherlv_0= 'transition' (otherlv_1= 'elaborates' ( ( ruleEString ) )+ )? ( (lv_extended_3_0= 'extended' ) )? otherlv_4= 'source' ( ( ruleQualifiedName ) ) otherlv_6= 'target' ( ( ruleQualifiedName ) ) (otherlv_8= 'any' ( (lv_parameters_9_0= ruleTypedParameter ) ) (otherlv_10= ',' ( (lv_parameters_11_0= ruleTypedParameter ) ) )* )? (otherlv_12= 'where' ( (lv_guards_13_0= ruleGuard ) )+ )? (otherlv_14= 'then' ( (lv_actions_15_0= ruleAction ) )+ )? (otherlv_16= 'with' ( (lv_witnesses_17_0= ruleWitness ) )+ )? otherlv_18= 'end' )
            // InternalStatemachine.g:424:3: otherlv_0= 'transition' (otherlv_1= 'elaborates' ( ( ruleEString ) )+ )? ( (lv_extended_3_0= 'extended' ) )? otherlv_4= 'source' ( ( ruleQualifiedName ) ) otherlv_6= 'target' ( ( ruleQualifiedName ) ) (otherlv_8= 'any' ( (lv_parameters_9_0= ruleTypedParameter ) ) (otherlv_10= ',' ( (lv_parameters_11_0= ruleTypedParameter ) ) )* )? (otherlv_12= 'where' ( (lv_guards_13_0= ruleGuard ) )+ )? (otherlv_14= 'then' ( (lv_actions_15_0= ruleAction ) )+ )? (otherlv_16= 'with' ( (lv_witnesses_17_0= ruleWitness ) )+ )? otherlv_18= 'end'
            {
            otherlv_0=(Token)match(input,20,FOLLOW_15); 

            			newLeafNode(otherlv_0, grammarAccess.getTransitionAccess().getTransitionKeyword_0());
            		
            // InternalStatemachine.g:428:3: (otherlv_1= 'elaborates' ( ( ruleEString ) )+ )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==21) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalStatemachine.g:429:4: otherlv_1= 'elaborates' ( ( ruleEString ) )+
                    {
                    otherlv_1=(Token)match(input,21,FOLLOW_8); 

                    				newLeafNode(otherlv_1, grammarAccess.getTransitionAccess().getElaboratesKeyword_1_0());
                    			
                    // InternalStatemachine.g:433:4: ( ( ruleEString ) )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>=RULE_ID && LA9_0<=RULE_STRING)) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalStatemachine.g:434:5: ( ruleEString )
                    	    {
                    	    // InternalStatemachine.g:434:5: ( ruleEString )
                    	    // InternalStatemachine.g:435:6: ruleEString
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getTransitionRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getTransitionAccess().getElaboratesEventCrossReference_1_1_0());
                    	    					
                    	    pushFollow(FOLLOW_16);
                    	    ruleEString();

                    	    state._fsp--;


                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt9 >= 1 ) break loop9;
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);


                    }
                    break;

            }

            // InternalStatemachine.g:450:3: ( (lv_extended_3_0= 'extended' ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==22) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalStatemachine.g:451:4: (lv_extended_3_0= 'extended' )
                    {
                    // InternalStatemachine.g:451:4: (lv_extended_3_0= 'extended' )
                    // InternalStatemachine.g:452:5: lv_extended_3_0= 'extended'
                    {
                    lv_extended_3_0=(Token)match(input,22,FOLLOW_17); 

                    					newLeafNode(lv_extended_3_0, grammarAccess.getTransitionAccess().getExtendedExtendedKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTransitionRule());
                    					}
                    					setWithLastConsumed(current, "extended", true, "extended");
                    				

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,23,FOLLOW_3); 

            			newLeafNode(otherlv_4, grammarAccess.getTransitionAccess().getSourceKeyword_3());
            		
            // InternalStatemachine.g:468:3: ( ( ruleQualifiedName ) )
            // InternalStatemachine.g:469:4: ( ruleQualifiedName )
            {
            // InternalStatemachine.g:469:4: ( ruleQualifiedName )
            // InternalStatemachine.g:470:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTransitionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTransitionAccess().getSourceAbstractNodeCrossReference_4_0());
            				
            pushFollow(FOLLOW_18);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,24,FOLLOW_3); 

            			newLeafNode(otherlv_6, grammarAccess.getTransitionAccess().getTargetKeyword_5());
            		
            // InternalStatemachine.g:488:3: ( ( ruleQualifiedName ) )
            // InternalStatemachine.g:489:4: ( ruleQualifiedName )
            {
            // InternalStatemachine.g:489:4: ( ruleQualifiedName )
            // InternalStatemachine.g:490:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTransitionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTransitionAccess().getTargetAbstractNodeCrossReference_6_0());
            				
            pushFollow(FOLLOW_19);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalStatemachine.g:504:3: (otherlv_8= 'any' ( (lv_parameters_9_0= ruleTypedParameter ) ) (otherlv_10= ',' ( (lv_parameters_11_0= ruleTypedParameter ) ) )* )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==25) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalStatemachine.g:505:4: otherlv_8= 'any' ( (lv_parameters_9_0= ruleTypedParameter ) ) (otherlv_10= ',' ( (lv_parameters_11_0= ruleTypedParameter ) ) )*
                    {
                    otherlv_8=(Token)match(input,25,FOLLOW_3); 

                    				newLeafNode(otherlv_8, grammarAccess.getTransitionAccess().getAnyKeyword_7_0());
                    			
                    // InternalStatemachine.g:509:4: ( (lv_parameters_9_0= ruleTypedParameter ) )
                    // InternalStatemachine.g:510:5: (lv_parameters_9_0= ruleTypedParameter )
                    {
                    // InternalStatemachine.g:510:5: (lv_parameters_9_0= ruleTypedParameter )
                    // InternalStatemachine.g:511:6: lv_parameters_9_0= ruleTypedParameter
                    {

                    						newCompositeNode(grammarAccess.getTransitionAccess().getParametersTypedParameterParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_20);
                    lv_parameters_9_0=ruleTypedParameter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTransitionRule());
                    						}
                    						add(
                    							current,
                    							"parameters",
                    							lv_parameters_9_0,
                    							"ac.soton.xumlb.Statemachine.TypedParameter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalStatemachine.g:528:4: (otherlv_10= ',' ( (lv_parameters_11_0= ruleTypedParameter ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==26) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalStatemachine.g:529:5: otherlv_10= ',' ( (lv_parameters_11_0= ruleTypedParameter ) )
                    	    {
                    	    otherlv_10=(Token)match(input,26,FOLLOW_3); 

                    	    					newLeafNode(otherlv_10, grammarAccess.getTransitionAccess().getCommaKeyword_7_2_0());
                    	    				
                    	    // InternalStatemachine.g:533:5: ( (lv_parameters_11_0= ruleTypedParameter ) )
                    	    // InternalStatemachine.g:534:6: (lv_parameters_11_0= ruleTypedParameter )
                    	    {
                    	    // InternalStatemachine.g:534:6: (lv_parameters_11_0= ruleTypedParameter )
                    	    // InternalStatemachine.g:535:7: lv_parameters_11_0= ruleTypedParameter
                    	    {

                    	    							newCompositeNode(grammarAccess.getTransitionAccess().getParametersTypedParameterParserRuleCall_7_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_20);
                    	    lv_parameters_11_0=ruleTypedParameter();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getTransitionRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"parameters",
                    	    								lv_parameters_11_0,
                    	    								"ac.soton.xumlb.Statemachine.TypedParameter");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalStatemachine.g:554:3: (otherlv_12= 'where' ( (lv_guards_13_0= ruleGuard ) )+ )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==27) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalStatemachine.g:555:4: otherlv_12= 'where' ( (lv_guards_13_0= ruleGuard ) )+
                    {
                    otherlv_12=(Token)match(input,27,FOLLOW_21); 

                    				newLeafNode(otherlv_12, grammarAccess.getTransitionAccess().getWhereKeyword_8_0());
                    			
                    // InternalStatemachine.g:559:4: ( (lv_guards_13_0= ruleGuard ) )+
                    int cnt14=0;
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==RULE_XLABEL||LA14_0==36) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalStatemachine.g:560:5: (lv_guards_13_0= ruleGuard )
                    	    {
                    	    // InternalStatemachine.g:560:5: (lv_guards_13_0= ruleGuard )
                    	    // InternalStatemachine.g:561:6: lv_guards_13_0= ruleGuard
                    	    {

                    	    						newCompositeNode(grammarAccess.getTransitionAccess().getGuardsGuardParserRuleCall_8_1_0());
                    	    					
                    	    pushFollow(FOLLOW_22);
                    	    lv_guards_13_0=ruleGuard();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getTransitionRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"guards",
                    	    							lv_guards_13_0,
                    	    							"ac.soton.xumlb.Statemachine.Guard");
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

            // InternalStatemachine.g:579:3: (otherlv_14= 'then' ( (lv_actions_15_0= ruleAction ) )+ )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==28) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalStatemachine.g:580:4: otherlv_14= 'then' ( (lv_actions_15_0= ruleAction ) )+
                    {
                    otherlv_14=(Token)match(input,28,FOLLOW_23); 

                    				newLeafNode(otherlv_14, grammarAccess.getTransitionAccess().getThenKeyword_9_0());
                    			
                    // InternalStatemachine.g:584:4: ( (lv_actions_15_0= ruleAction ) )+
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
                    	    // InternalStatemachine.g:585:5: (lv_actions_15_0= ruleAction )
                    	    {
                    	    // InternalStatemachine.g:585:5: (lv_actions_15_0= ruleAction )
                    	    // InternalStatemachine.g:586:6: lv_actions_15_0= ruleAction
                    	    {

                    	    						newCompositeNode(grammarAccess.getTransitionAccess().getActionsActionParserRuleCall_9_1_0());
                    	    					
                    	    pushFollow(FOLLOW_24);
                    	    lv_actions_15_0=ruleAction();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getTransitionRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"actions",
                    	    							lv_actions_15_0,
                    	    							"ac.soton.xumlb.Statemachine.Action");
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

            // InternalStatemachine.g:604:3: (otherlv_16= 'with' ( (lv_witnesses_17_0= ruleWitness ) )+ )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==29) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalStatemachine.g:605:4: otherlv_16= 'with' ( (lv_witnesses_17_0= ruleWitness ) )+
                    {
                    otherlv_16=(Token)match(input,29,FOLLOW_23); 

                    				newLeafNode(otherlv_16, grammarAccess.getTransitionAccess().getWithKeyword_10_0());
                    			
                    // InternalStatemachine.g:609:4: ( (lv_witnesses_17_0= ruleWitness ) )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==RULE_XLABEL) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalStatemachine.g:610:5: (lv_witnesses_17_0= ruleWitness )
                    	    {
                    	    // InternalStatemachine.g:610:5: (lv_witnesses_17_0= ruleWitness )
                    	    // InternalStatemachine.g:611:6: lv_witnesses_17_0= ruleWitness
                    	    {

                    	    						newCompositeNode(grammarAccess.getTransitionAccess().getWitnessesWitnessParserRuleCall_10_1_0());
                    	    					
                    	    pushFollow(FOLLOW_25);
                    	    lv_witnesses_17_0=ruleWitness();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getTransitionRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"witnesses",
                    	    							lv_witnesses_17_0,
                    	    							"ac.soton.xumlb.Statemachine.Witness");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt18 >= 1 ) break loop18;
                                EarlyExitException eee =
                                    new EarlyExitException(18, input);
                                throw eee;
                        }
                        cnt18++;
                    } while (true);


                    }
                    break;

            }

            otherlv_18=(Token)match(input,30,FOLLOW_2); 

            			newLeafNode(otherlv_18, grammarAccess.getTransitionAccess().getEndKeyword_11());
            		

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
    // InternalStatemachine.g:637:1: entryRuleTypedParameter returns [EObject current=null] : iv_ruleTypedParameter= ruleTypedParameter EOF ;
    public final EObject entryRuleTypedParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedParameter = null;


        try {
            // InternalStatemachine.g:637:55: (iv_ruleTypedParameter= ruleTypedParameter EOF )
            // InternalStatemachine.g:638:2: iv_ruleTypedParameter= ruleTypedParameter EOF
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
    // InternalStatemachine.g:644:1: ruleTypedParameter returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleXType ) ) ) ;
    public final EObject ruleTypedParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_type_2_0 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:650:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleXType ) ) ) )
            // InternalStatemachine.g:651:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleXType ) ) )
            {
            // InternalStatemachine.g:651:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleXType ) ) )
            // InternalStatemachine.g:652:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleXType ) )
            {
            // InternalStatemachine.g:652:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalStatemachine.g:653:4: (lv_name_0_0= RULE_ID )
            {
            // InternalStatemachine.g:653:4: (lv_name_0_0= RULE_ID )
            // InternalStatemachine.g:654:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_26); 

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

            otherlv_1=(Token)match(input,31,FOLLOW_27); 

            			newLeafNode(otherlv_1, grammarAccess.getTypedParameterAccess().getColonKeyword_1());
            		
            // InternalStatemachine.g:674:3: ( (lv_type_2_0= ruleXType ) )
            // InternalStatemachine.g:675:4: (lv_type_2_0= ruleXType )
            {
            // InternalStatemachine.g:675:4: (lv_type_2_0= ruleXType )
            // InternalStatemachine.g:676:5: lv_type_2_0= ruleXType
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
    // InternalStatemachine.g:697:1: entryRuleXType returns [String current=null] : iv_ruleXType= ruleXType EOF ;
    public final String entryRuleXType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleXType = null;


        try {
            // InternalStatemachine.g:697:45: (iv_ruleXType= ruleXType EOF )
            // InternalStatemachine.g:698:2: iv_ruleXType= ruleXType EOF
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
    // InternalStatemachine.g:704:1: ruleXType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_XComplexType_0= ruleXComplexType (kw= '\\u00D7' this_XType_2= ruleXType )* ) ;
    public final AntlrDatatypeRuleToken ruleXType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_XComplexType_0 = null;

        AntlrDatatypeRuleToken this_XType_2 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:710:2: ( (this_XComplexType_0= ruleXComplexType (kw= '\\u00D7' this_XType_2= ruleXType )* ) )
            // InternalStatemachine.g:711:2: (this_XComplexType_0= ruleXComplexType (kw= '\\u00D7' this_XType_2= ruleXType )* )
            {
            // InternalStatemachine.g:711:2: (this_XComplexType_0= ruleXComplexType (kw= '\\u00D7' this_XType_2= ruleXType )* )
            // InternalStatemachine.g:712:3: this_XComplexType_0= ruleXComplexType (kw= '\\u00D7' this_XType_2= ruleXType )*
            {

            			newCompositeNode(grammarAccess.getXTypeAccess().getXComplexTypeParserRuleCall_0());
            		
            pushFollow(FOLLOW_28);
            this_XComplexType_0=ruleXComplexType();

            state._fsp--;


            			current.merge(this_XComplexType_0);
            		

            			afterParserOrEnumRuleCall();
            		
            // InternalStatemachine.g:722:3: (kw= '\\u00D7' this_XType_2= ruleXType )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==32) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalStatemachine.g:723:4: kw= '\\u00D7' this_XType_2= ruleXType
            	    {
            	    kw=(Token)match(input,32,FOLLOW_27); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getXTypeAccess().getMultiplicationSignKeyword_1_0());
            	    			

            	    				newCompositeNode(grammarAccess.getXTypeAccess().getXTypeParserRuleCall_1_1());
            	    			
            	    pushFollow(FOLLOW_28);
            	    this_XType_2=ruleXType();

            	    state._fsp--;


            	    				current.merge(this_XType_2);
            	    			

            	    				afterParserOrEnumRuleCall();
            	    			

            	    }
            	    break;

            	default :
            	    break loop20;
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
    // InternalStatemachine.g:743:1: entryRuleXComplexType returns [String current=null] : iv_ruleXComplexType= ruleXComplexType EOF ;
    public final String entryRuleXComplexType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleXComplexType = null;


        try {
            // InternalStatemachine.g:743:52: (iv_ruleXComplexType= ruleXComplexType EOF )
            // InternalStatemachine.g:744:2: iv_ruleXComplexType= ruleXComplexType EOF
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
    // InternalStatemachine.g:750:1: ruleXComplexType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '\\u2119' kw= '(' this_XType_2= ruleXType kw= ')' ) | this_EVENT_B_BUILDIN_TYPE_4= ruleEVENT_B_BUILDIN_TYPE | this_ID_5= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleXComplexType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_5=null;
        AntlrDatatypeRuleToken this_XType_2 = null;

        AntlrDatatypeRuleToken this_EVENT_B_BUILDIN_TYPE_4 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:756:2: ( ( (kw= '\\u2119' kw= '(' this_XType_2= ruleXType kw= ')' ) | this_EVENT_B_BUILDIN_TYPE_4= ruleEVENT_B_BUILDIN_TYPE | this_ID_5= RULE_ID ) )
            // InternalStatemachine.g:757:2: ( (kw= '\\u2119' kw= '(' this_XType_2= ruleXType kw= ')' ) | this_EVENT_B_BUILDIN_TYPE_4= ruleEVENT_B_BUILDIN_TYPE | this_ID_5= RULE_ID )
            {
            // InternalStatemachine.g:757:2: ( (kw= '\\u2119' kw= '(' this_XType_2= ruleXType kw= ')' ) | this_EVENT_B_BUILDIN_TYPE_4= ruleEVENT_B_BUILDIN_TYPE | this_ID_5= RULE_ID )
            int alt21=3;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt21=1;
                }
                break;
            case 34:
            case 35:
                {
                alt21=2;
                }
                break;
            case RULE_ID:
                {
                alt21=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // InternalStatemachine.g:758:3: (kw= '\\u2119' kw= '(' this_XType_2= ruleXType kw= ')' )
                    {
                    // InternalStatemachine.g:758:3: (kw= '\\u2119' kw= '(' this_XType_2= ruleXType kw= ')' )
                    // InternalStatemachine.g:759:4: kw= '\\u2119' kw= '(' this_XType_2= ruleXType kw= ')'
                    {
                    kw=(Token)match(input,33,FOLLOW_4); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getXComplexTypeAccess().getDoubleStruckCapitalPKeyword_0_0());
                    			
                    kw=(Token)match(input,13,FOLLOW_27); 

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
                    // InternalStatemachine.g:786:3: this_EVENT_B_BUILDIN_TYPE_4= ruleEVENT_B_BUILDIN_TYPE
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
                    // InternalStatemachine.g:797:3: this_ID_5= RULE_ID
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
    // InternalStatemachine.g:808:1: entryRuleEVENT_B_BUILDIN_TYPE returns [String current=null] : iv_ruleEVENT_B_BUILDIN_TYPE= ruleEVENT_B_BUILDIN_TYPE EOF ;
    public final String entryRuleEVENT_B_BUILDIN_TYPE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEVENT_B_BUILDIN_TYPE = null;


        try {
            // InternalStatemachine.g:808:60: (iv_ruleEVENT_B_BUILDIN_TYPE= ruleEVENT_B_BUILDIN_TYPE EOF )
            // InternalStatemachine.g:809:2: iv_ruleEVENT_B_BUILDIN_TYPE= ruleEVENT_B_BUILDIN_TYPE EOF
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
    // InternalStatemachine.g:815:1: ruleEVENT_B_BUILDIN_TYPE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'BOOL' | kw= '\\u2124' ) ;
    public final AntlrDatatypeRuleToken ruleEVENT_B_BUILDIN_TYPE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalStatemachine.g:821:2: ( (kw= 'BOOL' | kw= '\\u2124' ) )
            // InternalStatemachine.g:822:2: (kw= 'BOOL' | kw= '\\u2124' )
            {
            // InternalStatemachine.g:822:2: (kw= 'BOOL' | kw= '\\u2124' )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==34) ) {
                alt22=1;
            }
            else if ( (LA22_0==35) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalStatemachine.g:823:3: kw= 'BOOL'
                    {
                    kw=(Token)match(input,34,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENT_B_BUILDIN_TYPEAccess().getBOOLKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalStatemachine.g:829:3: kw= '\\u2124'
                    {
                    kw=(Token)match(input,35,FOLLOW_2); 

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
    // InternalStatemachine.g:838:1: entryRuleGuard returns [EObject current=null] : iv_ruleGuard= ruleGuard EOF ;
    public final EObject entryRuleGuard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuard = null;


        try {
            // InternalStatemachine.g:838:46: (iv_ruleGuard= ruleGuard EOF )
            // InternalStatemachine.g:839:2: iv_ruleGuard= ruleGuard EOF
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
    // InternalStatemachine.g:845:1: ruleGuard returns [EObject current=null] : ( ( (lv_theorem_0_0= 'theorem' ) )? ( (lv_name_1_0= RULE_XLABEL ) ) ( (lv_predicate_2_0= ruleXFormula ) ) ) ;
    public final EObject ruleGuard() throws RecognitionException {
        EObject current = null;

        Token lv_theorem_0_0=null;
        Token lv_name_1_0=null;
        AntlrDatatypeRuleToken lv_predicate_2_0 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:851:2: ( ( ( (lv_theorem_0_0= 'theorem' ) )? ( (lv_name_1_0= RULE_XLABEL ) ) ( (lv_predicate_2_0= ruleXFormula ) ) ) )
            // InternalStatemachine.g:852:2: ( ( (lv_theorem_0_0= 'theorem' ) )? ( (lv_name_1_0= RULE_XLABEL ) ) ( (lv_predicate_2_0= ruleXFormula ) ) )
            {
            // InternalStatemachine.g:852:2: ( ( (lv_theorem_0_0= 'theorem' ) )? ( (lv_name_1_0= RULE_XLABEL ) ) ( (lv_predicate_2_0= ruleXFormula ) ) )
            // InternalStatemachine.g:853:3: ( (lv_theorem_0_0= 'theorem' ) )? ( (lv_name_1_0= RULE_XLABEL ) ) ( (lv_predicate_2_0= ruleXFormula ) )
            {
            // InternalStatemachine.g:853:3: ( (lv_theorem_0_0= 'theorem' ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==36) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalStatemachine.g:854:4: (lv_theorem_0_0= 'theorem' )
                    {
                    // InternalStatemachine.g:854:4: (lv_theorem_0_0= 'theorem' )
                    // InternalStatemachine.g:855:5: lv_theorem_0_0= 'theorem'
                    {
                    lv_theorem_0_0=(Token)match(input,36,FOLLOW_23); 

                    					newLeafNode(lv_theorem_0_0, grammarAccess.getGuardAccess().getTheoremTheoremKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getGuardRule());
                    					}
                    					setWithLastConsumed(current, "theorem", true, "theorem");
                    				

                    }


                    }
                    break;

            }

            // InternalStatemachine.g:867:3: ( (lv_name_1_0= RULE_XLABEL ) )
            // InternalStatemachine.g:868:4: (lv_name_1_0= RULE_XLABEL )
            {
            // InternalStatemachine.g:868:4: (lv_name_1_0= RULE_XLABEL )
            // InternalStatemachine.g:869:5: lv_name_1_0= RULE_XLABEL
            {
            lv_name_1_0=(Token)match(input,RULE_XLABEL,FOLLOW_29); 

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

            // InternalStatemachine.g:885:3: ( (lv_predicate_2_0= ruleXFormula ) )
            // InternalStatemachine.g:886:4: (lv_predicate_2_0= ruleXFormula )
            {
            // InternalStatemachine.g:886:4: (lv_predicate_2_0= ruleXFormula )
            // InternalStatemachine.g:887:5: lv_predicate_2_0= ruleXFormula
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
    // InternalStatemachine.g:908:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // InternalStatemachine.g:908:47: (iv_ruleAction= ruleAction EOF )
            // InternalStatemachine.g:909:2: iv_ruleAction= ruleAction EOF
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
    // InternalStatemachine.g:915:1: ruleAction returns [EObject current=null] : ( ( (lv_name_0_0= RULE_XLABEL ) ) ( (lv_action_1_0= ruleXFormula ) ) ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        AntlrDatatypeRuleToken lv_action_1_0 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:921:2: ( ( ( (lv_name_0_0= RULE_XLABEL ) ) ( (lv_action_1_0= ruleXFormula ) ) ) )
            // InternalStatemachine.g:922:2: ( ( (lv_name_0_0= RULE_XLABEL ) ) ( (lv_action_1_0= ruleXFormula ) ) )
            {
            // InternalStatemachine.g:922:2: ( ( (lv_name_0_0= RULE_XLABEL ) ) ( (lv_action_1_0= ruleXFormula ) ) )
            // InternalStatemachine.g:923:3: ( (lv_name_0_0= RULE_XLABEL ) ) ( (lv_action_1_0= ruleXFormula ) )
            {
            // InternalStatemachine.g:923:3: ( (lv_name_0_0= RULE_XLABEL ) )
            // InternalStatemachine.g:924:4: (lv_name_0_0= RULE_XLABEL )
            {
            // InternalStatemachine.g:924:4: (lv_name_0_0= RULE_XLABEL )
            // InternalStatemachine.g:925:5: lv_name_0_0= RULE_XLABEL
            {
            lv_name_0_0=(Token)match(input,RULE_XLABEL,FOLLOW_29); 

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

            // InternalStatemachine.g:941:3: ( (lv_action_1_0= ruleXFormula ) )
            // InternalStatemachine.g:942:4: (lv_action_1_0= ruleXFormula )
            {
            // InternalStatemachine.g:942:4: (lv_action_1_0= ruleXFormula )
            // InternalStatemachine.g:943:5: lv_action_1_0= ruleXFormula
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
    // InternalStatemachine.g:964:1: entryRuleWitness returns [EObject current=null] : iv_ruleWitness= ruleWitness EOF ;
    public final EObject entryRuleWitness() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWitness = null;


        try {
            // InternalStatemachine.g:964:48: (iv_ruleWitness= ruleWitness EOF )
            // InternalStatemachine.g:965:2: iv_ruleWitness= ruleWitness EOF
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
    // InternalStatemachine.g:971:1: ruleWitness returns [EObject current=null] : ( ( (lv_name_0_0= RULE_XLABEL ) ) ( (lv_predicate_1_0= ruleXFormula ) ) ) ;
    public final EObject ruleWitness() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        AntlrDatatypeRuleToken lv_predicate_1_0 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:977:2: ( ( ( (lv_name_0_0= RULE_XLABEL ) ) ( (lv_predicate_1_0= ruleXFormula ) ) ) )
            // InternalStatemachine.g:978:2: ( ( (lv_name_0_0= RULE_XLABEL ) ) ( (lv_predicate_1_0= ruleXFormula ) ) )
            {
            // InternalStatemachine.g:978:2: ( ( (lv_name_0_0= RULE_XLABEL ) ) ( (lv_predicate_1_0= ruleXFormula ) ) )
            // InternalStatemachine.g:979:3: ( (lv_name_0_0= RULE_XLABEL ) ) ( (lv_predicate_1_0= ruleXFormula ) )
            {
            // InternalStatemachine.g:979:3: ( (lv_name_0_0= RULE_XLABEL ) )
            // InternalStatemachine.g:980:4: (lv_name_0_0= RULE_XLABEL )
            {
            // InternalStatemachine.g:980:4: (lv_name_0_0= RULE_XLABEL )
            // InternalStatemachine.g:981:5: lv_name_0_0= RULE_XLABEL
            {
            lv_name_0_0=(Token)match(input,RULE_XLABEL,FOLLOW_29); 

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

            // InternalStatemachine.g:997:3: ( (lv_predicate_1_0= ruleXFormula ) )
            // InternalStatemachine.g:998:4: (lv_predicate_1_0= ruleXFormula )
            {
            // InternalStatemachine.g:998:4: (lv_predicate_1_0= ruleXFormula )
            // InternalStatemachine.g:999:5: lv_predicate_1_0= ruleXFormula
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
    // InternalStatemachine.g:1020:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalStatemachine.g:1020:46: (iv_ruleState= ruleState EOF )
            // InternalStatemachine.g:1021:2: iv_ruleState= ruleState EOF
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
    // InternalStatemachine.g:1027:1: ruleState returns [EObject current=null] : (otherlv_0= 'State' ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'refines' ( ( ruleQualifiedName ) ) )? (otherlv_4= 'statemachines' otherlv_5= 'begin' ( (lv_statemachines_6_0= ruleStatemachine ) ) ( (lv_statemachines_7_0= ruleStatemachine ) )* otherlv_8= 'end' )? (otherlv_9= 'invariants' ( (lv_invariants_10_0= ruleInvariant ) )+ )? (otherlv_11= 'entryActions' ( (lv_entryActions_12_0= ruleAction ) )+ )? (otherlv_13= 'exitActions' ( (lv_exitActions_14_0= ruleAction ) )+ )? ) ;
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
            // InternalStatemachine.g:1033:2: ( (otherlv_0= 'State' ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'refines' ( ( ruleQualifiedName ) ) )? (otherlv_4= 'statemachines' otherlv_5= 'begin' ( (lv_statemachines_6_0= ruleStatemachine ) ) ( (lv_statemachines_7_0= ruleStatemachine ) )* otherlv_8= 'end' )? (otherlv_9= 'invariants' ( (lv_invariants_10_0= ruleInvariant ) )+ )? (otherlv_11= 'entryActions' ( (lv_entryActions_12_0= ruleAction ) )+ )? (otherlv_13= 'exitActions' ( (lv_exitActions_14_0= ruleAction ) )+ )? ) )
            // InternalStatemachine.g:1034:2: (otherlv_0= 'State' ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'refines' ( ( ruleQualifiedName ) ) )? (otherlv_4= 'statemachines' otherlv_5= 'begin' ( (lv_statemachines_6_0= ruleStatemachine ) ) ( (lv_statemachines_7_0= ruleStatemachine ) )* otherlv_8= 'end' )? (otherlv_9= 'invariants' ( (lv_invariants_10_0= ruleInvariant ) )+ )? (otherlv_11= 'entryActions' ( (lv_entryActions_12_0= ruleAction ) )+ )? (otherlv_13= 'exitActions' ( (lv_exitActions_14_0= ruleAction ) )+ )? )
            {
            // InternalStatemachine.g:1034:2: (otherlv_0= 'State' ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'refines' ( ( ruleQualifiedName ) ) )? (otherlv_4= 'statemachines' otherlv_5= 'begin' ( (lv_statemachines_6_0= ruleStatemachine ) ) ( (lv_statemachines_7_0= ruleStatemachine ) )* otherlv_8= 'end' )? (otherlv_9= 'invariants' ( (lv_invariants_10_0= ruleInvariant ) )+ )? (otherlv_11= 'entryActions' ( (lv_entryActions_12_0= ruleAction ) )+ )? (otherlv_13= 'exitActions' ( (lv_exitActions_14_0= ruleAction ) )+ )? )
            // InternalStatemachine.g:1035:3: otherlv_0= 'State' ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'refines' ( ( ruleQualifiedName ) ) )? (otherlv_4= 'statemachines' otherlv_5= 'begin' ( (lv_statemachines_6_0= ruleStatemachine ) ) ( (lv_statemachines_7_0= ruleStatemachine ) )* otherlv_8= 'end' )? (otherlv_9= 'invariants' ( (lv_invariants_10_0= ruleInvariant ) )+ )? (otherlv_11= 'entryActions' ( (lv_entryActions_12_0= ruleAction ) )+ )? (otherlv_13= 'exitActions' ( (lv_exitActions_14_0= ruleAction ) )+ )?
            {
            otherlv_0=(Token)match(input,37,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getStateAccess().getStateKeyword_0());
            		
            // InternalStatemachine.g:1039:3: ( (lv_name_1_0= ruleEString ) )
            // InternalStatemachine.g:1040:4: (lv_name_1_0= ruleEString )
            {
            // InternalStatemachine.g:1040:4: (lv_name_1_0= ruleEString )
            // InternalStatemachine.g:1041:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getStateAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_30);
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

            // InternalStatemachine.g:1058:3: (otherlv_2= 'refines' ( ( ruleQualifiedName ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==16) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalStatemachine.g:1059:4: otherlv_2= 'refines' ( ( ruleQualifiedName ) )
                    {
                    otherlv_2=(Token)match(input,16,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getStateAccess().getRefinesKeyword_2_0());
                    			
                    // InternalStatemachine.g:1063:4: ( ( ruleQualifiedName ) )
                    // InternalStatemachine.g:1064:5: ( ruleQualifiedName )
                    {
                    // InternalStatemachine.g:1064:5: ( ruleQualifiedName )
                    // InternalStatemachine.g:1065:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStateRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getStateAccess().getRefinesStateCrossReference_2_1_0());
                    					
                    pushFollow(FOLLOW_31);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalStatemachine.g:1080:3: (otherlv_4= 'statemachines' otherlv_5= 'begin' ( (lv_statemachines_6_0= ruleStatemachine ) ) ( (lv_statemachines_7_0= ruleStatemachine ) )* otherlv_8= 'end' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==38) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalStatemachine.g:1081:4: otherlv_4= 'statemachines' otherlv_5= 'begin' ( (lv_statemachines_6_0= ruleStatemachine ) ) ( (lv_statemachines_7_0= ruleStatemachine ) )* otherlv_8= 'end'
                    {
                    otherlv_4=(Token)match(input,38,FOLLOW_32); 

                    				newLeafNode(otherlv_4, grammarAccess.getStateAccess().getStatemachinesKeyword_3_0());
                    			
                    otherlv_5=(Token)match(input,39,FOLLOW_33); 

                    				newLeafNode(otherlv_5, grammarAccess.getStateAccess().getBeginKeyword_3_1());
                    			
                    // InternalStatemachine.g:1089:4: ( (lv_statemachines_6_0= ruleStatemachine ) )
                    // InternalStatemachine.g:1090:5: (lv_statemachines_6_0= ruleStatemachine )
                    {
                    // InternalStatemachine.g:1090:5: (lv_statemachines_6_0= ruleStatemachine )
                    // InternalStatemachine.g:1091:6: lv_statemachines_6_0= ruleStatemachine
                    {

                    						newCompositeNode(grammarAccess.getStateAccess().getStatemachinesStatemachineParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_34);
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

                    // InternalStatemachine.g:1108:4: ( (lv_statemachines_7_0= ruleStatemachine ) )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==12) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // InternalStatemachine.g:1109:5: (lv_statemachines_7_0= ruleStatemachine )
                    	    {
                    	    // InternalStatemachine.g:1109:5: (lv_statemachines_7_0= ruleStatemachine )
                    	    // InternalStatemachine.g:1110:6: lv_statemachines_7_0= ruleStatemachine
                    	    {

                    	    						newCompositeNode(grammarAccess.getStateAccess().getStatemachinesStatemachineParserRuleCall_3_3_0());
                    	    					
                    	    pushFollow(FOLLOW_34);
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
                    	    break loop25;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,30,FOLLOW_35); 

                    				newLeafNode(otherlv_8, grammarAccess.getStateAccess().getEndKeyword_3_4());
                    			

                    }
                    break;

            }

            // InternalStatemachine.g:1132:3: (otherlv_9= 'invariants' ( (lv_invariants_10_0= ruleInvariant ) )+ )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==40) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalStatemachine.g:1133:4: otherlv_9= 'invariants' ( (lv_invariants_10_0= ruleInvariant ) )+
                    {
                    otherlv_9=(Token)match(input,40,FOLLOW_36); 

                    				newLeafNode(otherlv_9, grammarAccess.getStateAccess().getInvariantsKeyword_4_0());
                    			
                    // InternalStatemachine.g:1137:4: ( (lv_invariants_10_0= ruleInvariant ) )+
                    int cnt27=0;
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==36) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // InternalStatemachine.g:1138:5: (lv_invariants_10_0= ruleInvariant )
                    	    {
                    	    // InternalStatemachine.g:1138:5: (lv_invariants_10_0= ruleInvariant )
                    	    // InternalStatemachine.g:1139:6: lv_invariants_10_0= ruleInvariant
                    	    {

                    	    						newCompositeNode(grammarAccess.getStateAccess().getInvariantsInvariantParserRuleCall_4_1_0());
                    	    					
                    	    pushFollow(FOLLOW_37);
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

            // InternalStatemachine.g:1157:3: (otherlv_11= 'entryActions' ( (lv_entryActions_12_0= ruleAction ) )+ )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==41) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalStatemachine.g:1158:4: otherlv_11= 'entryActions' ( (lv_entryActions_12_0= ruleAction ) )+
                    {
                    otherlv_11=(Token)match(input,41,FOLLOW_23); 

                    				newLeafNode(otherlv_11, grammarAccess.getStateAccess().getEntryActionsKeyword_5_0());
                    			
                    // InternalStatemachine.g:1162:4: ( (lv_entryActions_12_0= ruleAction ) )+
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
                    	    // InternalStatemachine.g:1163:5: (lv_entryActions_12_0= ruleAction )
                    	    {
                    	    // InternalStatemachine.g:1163:5: (lv_entryActions_12_0= ruleAction )
                    	    // InternalStatemachine.g:1164:6: lv_entryActions_12_0= ruleAction
                    	    {

                    	    						newCompositeNode(grammarAccess.getStateAccess().getEntryActionsActionParserRuleCall_5_1_0());
                    	    					
                    	    pushFollow(FOLLOW_38);
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

            // InternalStatemachine.g:1182:3: (otherlv_13= 'exitActions' ( (lv_exitActions_14_0= ruleAction ) )+ )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==42) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalStatemachine.g:1183:4: otherlv_13= 'exitActions' ( (lv_exitActions_14_0= ruleAction ) )+
                    {
                    otherlv_13=(Token)match(input,42,FOLLOW_23); 

                    				newLeafNode(otherlv_13, grammarAccess.getStateAccess().getExitActionsKeyword_6_0());
                    			
                    // InternalStatemachine.g:1187:4: ( (lv_exitActions_14_0= ruleAction ) )+
                    int cnt31=0;
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==RULE_XLABEL) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // InternalStatemachine.g:1188:5: (lv_exitActions_14_0= ruleAction )
                    	    {
                    	    // InternalStatemachine.g:1188:5: (lv_exitActions_14_0= ruleAction )
                    	    // InternalStatemachine.g:1189:6: lv_exitActions_14_0= ruleAction
                    	    {

                    	    						newCompositeNode(grammarAccess.getStateAccess().getExitActionsActionParserRuleCall_6_1_0());
                    	    					
                    	    pushFollow(FOLLOW_39);
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
                    	    if ( cnt31 >= 1 ) break loop31;
                                EarlyExitException eee =
                                    new EarlyExitException(31, input);
                                throw eee;
                        }
                        cnt31++;
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
    // InternalStatemachine.g:1211:1: entryRuleInvariant returns [EObject current=null] : iv_ruleInvariant= ruleInvariant EOF ;
    public final EObject entryRuleInvariant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvariant = null;


        try {
            // InternalStatemachine.g:1211:50: (iv_ruleInvariant= ruleInvariant EOF )
            // InternalStatemachine.g:1212:2: iv_ruleInvariant= ruleInvariant EOF
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
    // InternalStatemachine.g:1218:1: ruleInvariant returns [EObject current=null] : ( ( (lv_theorem_0_0= 'theorem' ) ) ( (lv_name_1_0= RULE_XLABEL ) ) ( (lv_predicate_2_0= ruleXFormula ) ) ) ;
    public final EObject ruleInvariant() throws RecognitionException {
        EObject current = null;

        Token lv_theorem_0_0=null;
        Token lv_name_1_0=null;
        AntlrDatatypeRuleToken lv_predicate_2_0 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:1224:2: ( ( ( (lv_theorem_0_0= 'theorem' ) ) ( (lv_name_1_0= RULE_XLABEL ) ) ( (lv_predicate_2_0= ruleXFormula ) ) ) )
            // InternalStatemachine.g:1225:2: ( ( (lv_theorem_0_0= 'theorem' ) ) ( (lv_name_1_0= RULE_XLABEL ) ) ( (lv_predicate_2_0= ruleXFormula ) ) )
            {
            // InternalStatemachine.g:1225:2: ( ( (lv_theorem_0_0= 'theorem' ) ) ( (lv_name_1_0= RULE_XLABEL ) ) ( (lv_predicate_2_0= ruleXFormula ) ) )
            // InternalStatemachine.g:1226:3: ( (lv_theorem_0_0= 'theorem' ) ) ( (lv_name_1_0= RULE_XLABEL ) ) ( (lv_predicate_2_0= ruleXFormula ) )
            {
            // InternalStatemachine.g:1226:3: ( (lv_theorem_0_0= 'theorem' ) )
            // InternalStatemachine.g:1227:4: (lv_theorem_0_0= 'theorem' )
            {
            // InternalStatemachine.g:1227:4: (lv_theorem_0_0= 'theorem' )
            // InternalStatemachine.g:1228:5: lv_theorem_0_0= 'theorem'
            {
            lv_theorem_0_0=(Token)match(input,36,FOLLOW_23); 

            					newLeafNode(lv_theorem_0_0, grammarAccess.getInvariantAccess().getTheoremTheoremKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInvariantRule());
            					}
            					setWithLastConsumed(current, "theorem", true, "theorem");
            				

            }


            }

            // InternalStatemachine.g:1240:3: ( (lv_name_1_0= RULE_XLABEL ) )
            // InternalStatemachine.g:1241:4: (lv_name_1_0= RULE_XLABEL )
            {
            // InternalStatemachine.g:1241:4: (lv_name_1_0= RULE_XLABEL )
            // InternalStatemachine.g:1242:5: lv_name_1_0= RULE_XLABEL
            {
            lv_name_1_0=(Token)match(input,RULE_XLABEL,FOLLOW_29); 

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

            // InternalStatemachine.g:1258:3: ( (lv_predicate_2_0= ruleXFormula ) )
            // InternalStatemachine.g:1259:4: (lv_predicate_2_0= ruleXFormula )
            {
            // InternalStatemachine.g:1259:4: (lv_predicate_2_0= ruleXFormula )
            // InternalStatemachine.g:1260:5: lv_predicate_2_0= ruleXFormula
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
    // InternalStatemachine.g:1281:1: entryRuleInitial returns [EObject current=null] : iv_ruleInitial= ruleInitial EOF ;
    public final EObject entryRuleInitial() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitial = null;


        try {
            // InternalStatemachine.g:1281:48: (iv_ruleInitial= ruleInitial EOF )
            // InternalStatemachine.g:1282:2: iv_ruleInitial= ruleInitial EOF
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
    // InternalStatemachine.g:1288:1: ruleInitial returns [EObject current=null] : (otherlv_0= 'Initial' ( (lv_name_1_0= ruleEString ) ) ) ;
    public final EObject ruleInitial() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:1294:2: ( (otherlv_0= 'Initial' ( (lv_name_1_0= ruleEString ) ) ) )
            // InternalStatemachine.g:1295:2: (otherlv_0= 'Initial' ( (lv_name_1_0= ruleEString ) ) )
            {
            // InternalStatemachine.g:1295:2: (otherlv_0= 'Initial' ( (lv_name_1_0= ruleEString ) ) )
            // InternalStatemachine.g:1296:3: otherlv_0= 'Initial' ( (lv_name_1_0= ruleEString ) )
            {
            otherlv_0=(Token)match(input,43,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getInitialAccess().getInitialKeyword_0());
            		
            // InternalStatemachine.g:1300:3: ( (lv_name_1_0= ruleEString ) )
            // InternalStatemachine.g:1301:4: (lv_name_1_0= ruleEString )
            {
            // InternalStatemachine.g:1301:4: (lv_name_1_0= ruleEString )
            // InternalStatemachine.g:1302:5: lv_name_1_0= ruleEString
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
    // InternalStatemachine.g:1323:1: entryRuleFinal returns [EObject current=null] : iv_ruleFinal= ruleFinal EOF ;
    public final EObject entryRuleFinal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFinal = null;


        try {
            // InternalStatemachine.g:1323:46: (iv_ruleFinal= ruleFinal EOF )
            // InternalStatemachine.g:1324:2: iv_ruleFinal= ruleFinal EOF
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
    // InternalStatemachine.g:1330:1: ruleFinal returns [EObject current=null] : (otherlv_0= 'Final' ( (lv_name_1_0= ruleEString ) ) ) ;
    public final EObject ruleFinal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:1336:2: ( (otherlv_0= 'Final' ( (lv_name_1_0= ruleEString ) ) ) )
            // InternalStatemachine.g:1337:2: (otherlv_0= 'Final' ( (lv_name_1_0= ruleEString ) ) )
            {
            // InternalStatemachine.g:1337:2: (otherlv_0= 'Final' ( (lv_name_1_0= ruleEString ) ) )
            // InternalStatemachine.g:1338:3: otherlv_0= 'Final' ( (lv_name_1_0= ruleEString ) )
            {
            otherlv_0=(Token)match(input,44,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getFinalAccess().getFinalKeyword_0());
            		
            // InternalStatemachine.g:1342:3: ( (lv_name_1_0= ruleEString ) )
            // InternalStatemachine.g:1343:4: (lv_name_1_0= ruleEString )
            {
            // InternalStatemachine.g:1343:4: (lv_name_1_0= ruleEString )
            // InternalStatemachine.g:1344:5: lv_name_1_0= ruleEString
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
    // InternalStatemachine.g:1365:1: entryRuleAny returns [EObject current=null] : iv_ruleAny= ruleAny EOF ;
    public final EObject entryRuleAny() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAny = null;


        try {
            // InternalStatemachine.g:1365:44: (iv_ruleAny= ruleAny EOF )
            // InternalStatemachine.g:1366:2: iv_ruleAny= ruleAny EOF
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
    // InternalStatemachine.g:1372:1: ruleAny returns [EObject current=null] : (otherlv_0= 'Any' ( (lv_name_1_0= ruleEString ) ) ) ;
    public final EObject ruleAny() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:1378:2: ( (otherlv_0= 'Any' ( (lv_name_1_0= ruleEString ) ) ) )
            // InternalStatemachine.g:1379:2: (otherlv_0= 'Any' ( (lv_name_1_0= ruleEString ) ) )
            {
            // InternalStatemachine.g:1379:2: (otherlv_0= 'Any' ( (lv_name_1_0= ruleEString ) ) )
            // InternalStatemachine.g:1380:3: otherlv_0= 'Any' ( (lv_name_1_0= ruleEString ) )
            {
            otherlv_0=(Token)match(input,45,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getAnyAccess().getAnyKeyword_0());
            		
            // InternalStatemachine.g:1384:3: ( (lv_name_1_0= ruleEString ) )
            // InternalStatemachine.g:1385:4: (lv_name_1_0= ruleEString )
            {
            // InternalStatemachine.g:1385:4: (lv_name_1_0= ruleEString )
            // InternalStatemachine.g:1386:5: lv_name_1_0= ruleEString
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
    // InternalStatemachine.g:1407:1: entryRuleJunction returns [EObject current=null] : iv_ruleJunction= ruleJunction EOF ;
    public final EObject entryRuleJunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJunction = null;


        try {
            // InternalStatemachine.g:1407:49: (iv_ruleJunction= ruleJunction EOF )
            // InternalStatemachine.g:1408:2: iv_ruleJunction= ruleJunction EOF
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
    // InternalStatemachine.g:1414:1: ruleJunction returns [EObject current=null] : (otherlv_0= 'Junction' ( (lv_name_1_0= ruleEString ) ) ) ;
    public final EObject ruleJunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:1420:2: ( (otherlv_0= 'Junction' ( (lv_name_1_0= ruleEString ) ) ) )
            // InternalStatemachine.g:1421:2: (otherlv_0= 'Junction' ( (lv_name_1_0= ruleEString ) ) )
            {
            // InternalStatemachine.g:1421:2: (otherlv_0= 'Junction' ( (lv_name_1_0= ruleEString ) ) )
            // InternalStatemachine.g:1422:3: otherlv_0= 'Junction' ( (lv_name_1_0= ruleEString ) )
            {
            otherlv_0=(Token)match(input,46,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getJunctionAccess().getJunctionKeyword_0());
            		
            // InternalStatemachine.g:1426:3: ( (lv_name_1_0= ruleEString ) )
            // InternalStatemachine.g:1427:4: (lv_name_1_0= ruleEString )
            {
            // InternalStatemachine.g:1427:4: (lv_name_1_0= ruleEString )
            // InternalStatemachine.g:1428:5: lv_name_1_0= ruleEString
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
    // InternalStatemachine.g:1449:1: entryRuleFork returns [EObject current=null] : iv_ruleFork= ruleFork EOF ;
    public final EObject entryRuleFork() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFork = null;


        try {
            // InternalStatemachine.g:1449:45: (iv_ruleFork= ruleFork EOF )
            // InternalStatemachine.g:1450:2: iv_ruleFork= ruleFork EOF
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
    // InternalStatemachine.g:1456:1: ruleFork returns [EObject current=null] : (otherlv_0= 'Fork' ( (lv_name_1_0= ruleEString ) ) ) ;
    public final EObject ruleFork() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:1462:2: ( (otherlv_0= 'Fork' ( (lv_name_1_0= ruleEString ) ) ) )
            // InternalStatemachine.g:1463:2: (otherlv_0= 'Fork' ( (lv_name_1_0= ruleEString ) ) )
            {
            // InternalStatemachine.g:1463:2: (otherlv_0= 'Fork' ( (lv_name_1_0= ruleEString ) ) )
            // InternalStatemachine.g:1464:3: otherlv_0= 'Fork' ( (lv_name_1_0= ruleEString ) )
            {
            otherlv_0=(Token)match(input,47,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getForkAccess().getForkKeyword_0());
            		
            // InternalStatemachine.g:1468:3: ( (lv_name_1_0= ruleEString ) )
            // InternalStatemachine.g:1469:4: (lv_name_1_0= ruleEString )
            {
            // InternalStatemachine.g:1469:4: (lv_name_1_0= ruleEString )
            // InternalStatemachine.g:1470:5: lv_name_1_0= ruleEString
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
    // InternalStatemachine.g:1491:1: entryRuleXFormula returns [String current=null] : iv_ruleXFormula= ruleXFormula EOF ;
    public final String entryRuleXFormula() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleXFormula = null;


        try {
            // InternalStatemachine.g:1491:48: (iv_ruleXFormula= ruleXFormula EOF )
            // InternalStatemachine.g:1492:2: iv_ruleXFormula= ruleXFormula EOF
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
    // InternalStatemachine.g:1498:1: ruleXFormula returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_EVENTB_IDENTIFIER_KEYWORD_0= ruleEVENTB_IDENTIFIER_KEYWORD | this_EVENTB_PREDICATE_SYMBOLS_1= ruleEVENTB_PREDICATE_SYMBOLS | this_EVENTB_EXPRESSION_SYMBOLS_2= ruleEVENTB_EXPRESSION_SYMBOLS | this_ID_3= RULE_ID | this_INT_4= RULE_INT )+ ;
    public final AntlrDatatypeRuleToken ruleXFormula() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_3=null;
        Token this_INT_4=null;
        AntlrDatatypeRuleToken this_EVENTB_IDENTIFIER_KEYWORD_0 = null;

        AntlrDatatypeRuleToken this_EVENTB_PREDICATE_SYMBOLS_1 = null;

        AntlrDatatypeRuleToken this_EVENTB_EXPRESSION_SYMBOLS_2 = null;



        	enterRule();

        try {
            // InternalStatemachine.g:1504:2: ( (this_EVENTB_IDENTIFIER_KEYWORD_0= ruleEVENTB_IDENTIFIER_KEYWORD | this_EVENTB_PREDICATE_SYMBOLS_1= ruleEVENTB_PREDICATE_SYMBOLS | this_EVENTB_EXPRESSION_SYMBOLS_2= ruleEVENTB_EXPRESSION_SYMBOLS | this_ID_3= RULE_ID | this_INT_4= RULE_INT )+ )
            // InternalStatemachine.g:1505:2: (this_EVENTB_IDENTIFIER_KEYWORD_0= ruleEVENTB_IDENTIFIER_KEYWORD | this_EVENTB_PREDICATE_SYMBOLS_1= ruleEVENTB_PREDICATE_SYMBOLS | this_EVENTB_EXPRESSION_SYMBOLS_2= ruleEVENTB_EXPRESSION_SYMBOLS | this_ID_3= RULE_ID | this_INT_4= RULE_INT )+
            {
            // InternalStatemachine.g:1505:2: (this_EVENTB_IDENTIFIER_KEYWORD_0= ruleEVENTB_IDENTIFIER_KEYWORD | this_EVENTB_PREDICATE_SYMBOLS_1= ruleEVENTB_PREDICATE_SYMBOLS | this_EVENTB_EXPRESSION_SYMBOLS_2= ruleEVENTB_EXPRESSION_SYMBOLS | this_ID_3= RULE_ID | this_INT_4= RULE_INT )+
            int cnt33=0;
            loop33:
            do {
                int alt33=6;
                switch ( input.LA(1) ) {
                case 33:
                case 34:
                case 35:
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
                case 66:
                case 67:
                    {
                    alt33=1;
                    }
                    break;
                case 13:
                case 14:
                case 19:
                case 26:
                case 31:
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
                case 93:
                    {
                    alt33=2;
                    }
                    break;
                case 32:
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
                case 125:
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
                case 138:
                    {
                    alt33=3;
                    }
                    break;
                case RULE_ID:
                    {
                    alt33=4;
                    }
                    break;
                case RULE_INT:
                    {
                    alt33=5;
                    }
                    break;

                }

                switch (alt33) {
            	case 1 :
            	    // InternalStatemachine.g:1506:3: this_EVENTB_IDENTIFIER_KEYWORD_0= ruleEVENTB_IDENTIFIER_KEYWORD
            	    {

            	    			newCompositeNode(grammarAccess.getXFormulaAccess().getEVENTB_IDENTIFIER_KEYWORDParserRuleCall_0());
            	    		
            	    pushFollow(FOLLOW_40);
            	    this_EVENTB_IDENTIFIER_KEYWORD_0=ruleEVENTB_IDENTIFIER_KEYWORD();

            	    state._fsp--;


            	    			current.merge(this_EVENTB_IDENTIFIER_KEYWORD_0);
            	    		

            	    			afterParserOrEnumRuleCall();
            	    		

            	    }
            	    break;
            	case 2 :
            	    // InternalStatemachine.g:1517:3: this_EVENTB_PREDICATE_SYMBOLS_1= ruleEVENTB_PREDICATE_SYMBOLS
            	    {

            	    			newCompositeNode(grammarAccess.getXFormulaAccess().getEVENTB_PREDICATE_SYMBOLSParserRuleCall_1());
            	    		
            	    pushFollow(FOLLOW_40);
            	    this_EVENTB_PREDICATE_SYMBOLS_1=ruleEVENTB_PREDICATE_SYMBOLS();

            	    state._fsp--;


            	    			current.merge(this_EVENTB_PREDICATE_SYMBOLS_1);
            	    		

            	    			afterParserOrEnumRuleCall();
            	    		

            	    }
            	    break;
            	case 3 :
            	    // InternalStatemachine.g:1528:3: this_EVENTB_EXPRESSION_SYMBOLS_2= ruleEVENTB_EXPRESSION_SYMBOLS
            	    {

            	    			newCompositeNode(grammarAccess.getXFormulaAccess().getEVENTB_EXPRESSION_SYMBOLSParserRuleCall_2());
            	    		
            	    pushFollow(FOLLOW_40);
            	    this_EVENTB_EXPRESSION_SYMBOLS_2=ruleEVENTB_EXPRESSION_SYMBOLS();

            	    state._fsp--;


            	    			current.merge(this_EVENTB_EXPRESSION_SYMBOLS_2);
            	    		

            	    			afterParserOrEnumRuleCall();
            	    		

            	    }
            	    break;
            	case 4 :
            	    // InternalStatemachine.g:1539:3: this_ID_3= RULE_ID
            	    {
            	    this_ID_3=(Token)match(input,RULE_ID,FOLLOW_40); 

            	    			current.merge(this_ID_3);
            	    		

            	    			newLeafNode(this_ID_3, grammarAccess.getXFormulaAccess().getIDTerminalRuleCall_3());
            	    		

            	    }
            	    break;
            	case 5 :
            	    // InternalStatemachine.g:1547:3: this_INT_4= RULE_INT
            	    {
            	    this_INT_4=(Token)match(input,RULE_INT,FOLLOW_40); 

            	    			current.merge(this_INT_4);
            	    		

            	    			newLeafNode(this_INT_4, grammarAccess.getXFormulaAccess().getINTTerminalRuleCall_4());
            	    		

            	    }
            	    break;

            	default :
            	    if ( cnt33 >= 1 ) break loop33;
                        EarlyExitException eee =
                            new EarlyExitException(33, input);
                        throw eee;
                }
                cnt33++;
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
    // InternalStatemachine.g:1558:1: entryRuleEVENTB_IDENTIFIER_KEYWORD returns [String current=null] : iv_ruleEVENTB_IDENTIFIER_KEYWORD= ruleEVENTB_IDENTIFIER_KEYWORD EOF ;
    public final String entryRuleEVENTB_IDENTIFIER_KEYWORD() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEVENTB_IDENTIFIER_KEYWORD = null;


        try {
            // InternalStatemachine.g:1558:65: (iv_ruleEVENTB_IDENTIFIER_KEYWORD= ruleEVENTB_IDENTIFIER_KEYWORD EOF )
            // InternalStatemachine.g:1559:2: iv_ruleEVENTB_IDENTIFIER_KEYWORD= ruleEVENTB_IDENTIFIER_KEYWORD EOF
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
    // InternalStatemachine.g:1565:1: ruleEVENTB_IDENTIFIER_KEYWORD returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'BOOL' | kw= 'FALSE' | kw= 'TRUE' | kw= 'bool' | kw= 'card' | kw= 'dom' | kw= 'finite' | kw= 'id' | kw= 'inter' | kw= 'max' | kw= 'min' | kw= 'mod' | kw= 'pred' | kw= 'prj1' | kw= 'prj2' | kw= 'ran' | kw= 'succ' | kw= 'union' | kw= '\\u21151' | kw= '\\u2115' | kw= '\\u21191' | kw= '\\u2119' | kw= '\\u2124' ) ;
    public final AntlrDatatypeRuleToken ruleEVENTB_IDENTIFIER_KEYWORD() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalStatemachine.g:1571:2: ( (kw= 'BOOL' | kw= 'FALSE' | kw= 'TRUE' | kw= 'bool' | kw= 'card' | kw= 'dom' | kw= 'finite' | kw= 'id' | kw= 'inter' | kw= 'max' | kw= 'min' | kw= 'mod' | kw= 'pred' | kw= 'prj1' | kw= 'prj2' | kw= 'ran' | kw= 'succ' | kw= 'union' | kw= '\\u21151' | kw= '\\u2115' | kw= '\\u21191' | kw= '\\u2119' | kw= '\\u2124' ) )
            // InternalStatemachine.g:1572:2: (kw= 'BOOL' | kw= 'FALSE' | kw= 'TRUE' | kw= 'bool' | kw= 'card' | kw= 'dom' | kw= 'finite' | kw= 'id' | kw= 'inter' | kw= 'max' | kw= 'min' | kw= 'mod' | kw= 'pred' | kw= 'prj1' | kw= 'prj2' | kw= 'ran' | kw= 'succ' | kw= 'union' | kw= '\\u21151' | kw= '\\u2115' | kw= '\\u21191' | kw= '\\u2119' | kw= '\\u2124' )
            {
            // InternalStatemachine.g:1572:2: (kw= 'BOOL' | kw= 'FALSE' | kw= 'TRUE' | kw= 'bool' | kw= 'card' | kw= 'dom' | kw= 'finite' | kw= 'id' | kw= 'inter' | kw= 'max' | kw= 'min' | kw= 'mod' | kw= 'pred' | kw= 'prj1' | kw= 'prj2' | kw= 'ran' | kw= 'succ' | kw= 'union' | kw= '\\u21151' | kw= '\\u2115' | kw= '\\u21191' | kw= '\\u2119' | kw= '\\u2124' )
            int alt34=23;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt34=1;
                }
                break;
            case 48:
                {
                alt34=2;
                }
                break;
            case 49:
                {
                alt34=3;
                }
                break;
            case 50:
                {
                alt34=4;
                }
                break;
            case 51:
                {
                alt34=5;
                }
                break;
            case 52:
                {
                alt34=6;
                }
                break;
            case 53:
                {
                alt34=7;
                }
                break;
            case 54:
                {
                alt34=8;
                }
                break;
            case 55:
                {
                alt34=9;
                }
                break;
            case 56:
                {
                alt34=10;
                }
                break;
            case 57:
                {
                alt34=11;
                }
                break;
            case 58:
                {
                alt34=12;
                }
                break;
            case 59:
                {
                alt34=13;
                }
                break;
            case 60:
                {
                alt34=14;
                }
                break;
            case 61:
                {
                alt34=15;
                }
                break;
            case 62:
                {
                alt34=16;
                }
                break;
            case 63:
                {
                alt34=17;
                }
                break;
            case 64:
                {
                alt34=18;
                }
                break;
            case 65:
                {
                alt34=19;
                }
                break;
            case 66:
                {
                alt34=20;
                }
                break;
            case 67:
                {
                alt34=21;
                }
                break;
            case 33:
                {
                alt34=22;
                }
                break;
            case 35:
                {
                alt34=23;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // InternalStatemachine.g:1573:3: kw= 'BOOL'
                    {
                    kw=(Token)match(input,34,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getBOOLKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalStatemachine.g:1579:3: kw= 'FALSE'
                    {
                    kw=(Token)match(input,48,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getFALSEKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalStatemachine.g:1585:3: kw= 'TRUE'
                    {
                    kw=(Token)match(input,49,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getTRUEKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalStatemachine.g:1591:3: kw= 'bool'
                    {
                    kw=(Token)match(input,50,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getBoolKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalStatemachine.g:1597:3: kw= 'card'
                    {
                    kw=(Token)match(input,51,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getCardKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalStatemachine.g:1603:3: kw= 'dom'
                    {
                    kw=(Token)match(input,52,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDomKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalStatemachine.g:1609:3: kw= 'finite'
                    {
                    kw=(Token)match(input,53,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getFiniteKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalStatemachine.g:1615:3: kw= 'id'
                    {
                    kw=(Token)match(input,54,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getIdKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalStatemachine.g:1621:3: kw= 'inter'
                    {
                    kw=(Token)match(input,55,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getInterKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalStatemachine.g:1627:3: kw= 'max'
                    {
                    kw=(Token)match(input,56,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getMaxKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalStatemachine.g:1633:3: kw= 'min'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getMinKeyword_10());
                    		

                    }
                    break;
                case 12 :
                    // InternalStatemachine.g:1639:3: kw= 'mod'
                    {
                    kw=(Token)match(input,58,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getModKeyword_11());
                    		

                    }
                    break;
                case 13 :
                    // InternalStatemachine.g:1645:3: kw= 'pred'
                    {
                    kw=(Token)match(input,59,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getPredKeyword_12());
                    		

                    }
                    break;
                case 14 :
                    // InternalStatemachine.g:1651:3: kw= 'prj1'
                    {
                    kw=(Token)match(input,60,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getPrj1Keyword_13());
                    		

                    }
                    break;
                case 15 :
                    // InternalStatemachine.g:1657:3: kw= 'prj2'
                    {
                    kw=(Token)match(input,61,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getPrj2Keyword_14());
                    		

                    }
                    break;
                case 16 :
                    // InternalStatemachine.g:1663:3: kw= 'ran'
                    {
                    kw=(Token)match(input,62,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getRanKeyword_15());
                    		

                    }
                    break;
                case 17 :
                    // InternalStatemachine.g:1669:3: kw= 'succ'
                    {
                    kw=(Token)match(input,63,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getSuccKeyword_16());
                    		

                    }
                    break;
                case 18 :
                    // InternalStatemachine.g:1675:3: kw= 'union'
                    {
                    kw=(Token)match(input,64,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getUnionKeyword_17());
                    		

                    }
                    break;
                case 19 :
                    // InternalStatemachine.g:1681:3: kw= '\\u21151'
                    {
                    kw=(Token)match(input,65,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalNDigitOneKeyword_18());
                    		

                    }
                    break;
                case 20 :
                    // InternalStatemachine.g:1687:3: kw= '\\u2115'
                    {
                    kw=(Token)match(input,66,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalNKeyword_19());
                    		

                    }
                    break;
                case 21 :
                    // InternalStatemachine.g:1693:3: kw= '\\u21191'
                    {
                    kw=(Token)match(input,67,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalPDigitOneKeyword_20());
                    		

                    }
                    break;
                case 22 :
                    // InternalStatemachine.g:1699:3: kw= '\\u2119'
                    {
                    kw=(Token)match(input,33,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalPKeyword_21());
                    		

                    }
                    break;
                case 23 :
                    // InternalStatemachine.g:1705:3: kw= '\\u2124'
                    {
                    kw=(Token)match(input,35,FOLLOW_2); 

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
    // InternalStatemachine.g:1714:1: entryRuleEVENTB_PREDICATE_SYMBOLS returns [String current=null] : iv_ruleEVENTB_PREDICATE_SYMBOLS= ruleEVENTB_PREDICATE_SYMBOLS EOF ;
    public final String entryRuleEVENTB_PREDICATE_SYMBOLS() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEVENTB_PREDICATE_SYMBOLS = null;


        try {
            // InternalStatemachine.g:1714:64: (iv_ruleEVENTB_PREDICATE_SYMBOLS= ruleEVENTB_PREDICATE_SYMBOLS EOF )
            // InternalStatemachine.g:1715:2: iv_ruleEVENTB_PREDICATE_SYMBOLS= ruleEVENTB_PREDICATE_SYMBOLS EOF
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
    // InternalStatemachine.g:1721:1: ruleEVENTB_PREDICATE_SYMBOLS returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '(' | kw= ')' | kw= '\\u21D4' | kw= '\\u21D2' | kw= '\\u2227' | kw= '&' | kw= '\\u2228' | kw= '\\u00AC' | kw= '\\u22A4' | kw= '\\u22A5' | kw= '\\u2200' | kw= '!' | kw= '\\u2203' | kw= '#' | kw= ',' | kw= '\\u00B7' | kw= '.' | kw= '=' | kw= '\\u2260' | kw= '\\u2264' | kw= '<' | kw= '\\u2265' | kw= '>' | kw= '\\u2208' | kw= ':' | kw= '\\u2209' | kw= '\\u2282' | kw= '\\u2284' | kw= '\\u2286' | kw= '\\u2288' | kw= 'partition' ) ;
    public final AntlrDatatypeRuleToken ruleEVENTB_PREDICATE_SYMBOLS() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalStatemachine.g:1727:2: ( (kw= '(' | kw= ')' | kw= '\\u21D4' | kw= '\\u21D2' | kw= '\\u2227' | kw= '&' | kw= '\\u2228' | kw= '\\u00AC' | kw= '\\u22A4' | kw= '\\u22A5' | kw= '\\u2200' | kw= '!' | kw= '\\u2203' | kw= '#' | kw= ',' | kw= '\\u00B7' | kw= '.' | kw= '=' | kw= '\\u2260' | kw= '\\u2264' | kw= '<' | kw= '\\u2265' | kw= '>' | kw= '\\u2208' | kw= ':' | kw= '\\u2209' | kw= '\\u2282' | kw= '\\u2284' | kw= '\\u2286' | kw= '\\u2288' | kw= 'partition' ) )
            // InternalStatemachine.g:1728:2: (kw= '(' | kw= ')' | kw= '\\u21D4' | kw= '\\u21D2' | kw= '\\u2227' | kw= '&' | kw= '\\u2228' | kw= '\\u00AC' | kw= '\\u22A4' | kw= '\\u22A5' | kw= '\\u2200' | kw= '!' | kw= '\\u2203' | kw= '#' | kw= ',' | kw= '\\u00B7' | kw= '.' | kw= '=' | kw= '\\u2260' | kw= '\\u2264' | kw= '<' | kw= '\\u2265' | kw= '>' | kw= '\\u2208' | kw= ':' | kw= '\\u2209' | kw= '\\u2282' | kw= '\\u2284' | kw= '\\u2286' | kw= '\\u2288' | kw= 'partition' )
            {
            // InternalStatemachine.g:1728:2: (kw= '(' | kw= ')' | kw= '\\u21D4' | kw= '\\u21D2' | kw= '\\u2227' | kw= '&' | kw= '\\u2228' | kw= '\\u00AC' | kw= '\\u22A4' | kw= '\\u22A5' | kw= '\\u2200' | kw= '!' | kw= '\\u2203' | kw= '#' | kw= ',' | kw= '\\u00B7' | kw= '.' | kw= '=' | kw= '\\u2260' | kw= '\\u2264' | kw= '<' | kw= '\\u2265' | kw= '>' | kw= '\\u2208' | kw= ':' | kw= '\\u2209' | kw= '\\u2282' | kw= '\\u2284' | kw= '\\u2286' | kw= '\\u2288' | kw= 'partition' )
            int alt35=31;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt35=1;
                }
                break;
            case 14:
                {
                alt35=2;
                }
                break;
            case 68:
                {
                alt35=3;
                }
                break;
            case 69:
                {
                alt35=4;
                }
                break;
            case 70:
                {
                alt35=5;
                }
                break;
            case 71:
                {
                alt35=6;
                }
                break;
            case 72:
                {
                alt35=7;
                }
                break;
            case 73:
                {
                alt35=8;
                }
                break;
            case 74:
                {
                alt35=9;
                }
                break;
            case 75:
                {
                alt35=10;
                }
                break;
            case 76:
                {
                alt35=11;
                }
                break;
            case 77:
                {
                alt35=12;
                }
                break;
            case 78:
                {
                alt35=13;
                }
                break;
            case 79:
                {
                alt35=14;
                }
                break;
            case 26:
                {
                alt35=15;
                }
                break;
            case 80:
                {
                alt35=16;
                }
                break;
            case 19:
                {
                alt35=17;
                }
                break;
            case 81:
                {
                alt35=18;
                }
                break;
            case 82:
                {
                alt35=19;
                }
                break;
            case 83:
                {
                alt35=20;
                }
                break;
            case 84:
                {
                alt35=21;
                }
                break;
            case 85:
                {
                alt35=22;
                }
                break;
            case 86:
                {
                alt35=23;
                }
                break;
            case 87:
                {
                alt35=24;
                }
                break;
            case 31:
                {
                alt35=25;
                }
                break;
            case 88:
                {
                alt35=26;
                }
                break;
            case 89:
                {
                alt35=27;
                }
                break;
            case 90:
                {
                alt35=28;
                }
                break;
            case 91:
                {
                alt35=29;
                }
                break;
            case 92:
                {
                alt35=30;
                }
                break;
            case 93:
                {
                alt35=31;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // InternalStatemachine.g:1729:3: kw= '('
                    {
                    kw=(Token)match(input,13,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLeftParenthesisKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalStatemachine.g:1735:3: kw= ')'
                    {
                    kw=(Token)match(input,14,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getRightParenthesisKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalStatemachine.g:1741:3: kw= '\\u21D4'
                    {
                    kw=(Token)match(input,68,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLeftRightDoubleArrowKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalStatemachine.g:1747:3: kw= '\\u21D2'
                    {
                    kw=(Token)match(input,69,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getRightwardsDoubleArrowKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalStatemachine.g:1753:3: kw= '\\u2227'
                    {
                    kw=(Token)match(input,70,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLogicalAndKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalStatemachine.g:1759:3: kw= '&'
                    {
                    kw=(Token)match(input,71,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getAmpersandKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalStatemachine.g:1765:3: kw= '\\u2228'
                    {
                    kw=(Token)match(input,72,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLogicalOrKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalStatemachine.g:1771:3: kw= '\\u00AC'
                    {
                    kw=(Token)match(input,73,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotSignKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalStatemachine.g:1777:3: kw= '\\u22A4'
                    {
                    kw=(Token)match(input,74,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getDownTackKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalStatemachine.g:1783:3: kw= '\\u22A5'
                    {
                    kw=(Token)match(input,75,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getUpTackKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalStatemachine.g:1789:3: kw= '\\u2200'
                    {
                    kw=(Token)match(input,76,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getForAllKeyword_10());
                    		

                    }
                    break;
                case 12 :
                    // InternalStatemachine.g:1795:3: kw= '!'
                    {
                    kw=(Token)match(input,77,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getExclamationMarkKeyword_11());
                    		

                    }
                    break;
                case 13 :
                    // InternalStatemachine.g:1801:3: kw= '\\u2203'
                    {
                    kw=(Token)match(input,78,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getThereExistsKeyword_12());
                    		

                    }
                    break;
                case 14 :
                    // InternalStatemachine.g:1807:3: kw= '#'
                    {
                    kw=(Token)match(input,79,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNumberSignKeyword_13());
                    		

                    }
                    break;
                case 15 :
                    // InternalStatemachine.g:1813:3: kw= ','
                    {
                    kw=(Token)match(input,26,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getCommaKeyword_14());
                    		

                    }
                    break;
                case 16 :
                    // InternalStatemachine.g:1819:3: kw= '\\u00B7'
                    {
                    kw=(Token)match(input,80,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getMiddleDotKeyword_15());
                    		

                    }
                    break;
                case 17 :
                    // InternalStatemachine.g:1825:3: kw= '.'
                    {
                    kw=(Token)match(input,19,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getFullStopKeyword_16());
                    		

                    }
                    break;
                case 18 :
                    // InternalStatemachine.g:1831:3: kw= '='
                    {
                    kw=(Token)match(input,81,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getEqualsSignKeyword_17());
                    		

                    }
                    break;
                case 19 :
                    // InternalStatemachine.g:1837:3: kw= '\\u2260'
                    {
                    kw=(Token)match(input,82,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotEqualToKeyword_18());
                    		

                    }
                    break;
                case 20 :
                    // InternalStatemachine.g:1843:3: kw= '\\u2264'
                    {
                    kw=(Token)match(input,83,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLessThanOrEqualToKeyword_19());
                    		

                    }
                    break;
                case 21 :
                    // InternalStatemachine.g:1849:3: kw= '<'
                    {
                    kw=(Token)match(input,84,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLessThanSignKeyword_20());
                    		

                    }
                    break;
                case 22 :
                    // InternalStatemachine.g:1855:3: kw= '\\u2265'
                    {
                    kw=(Token)match(input,85,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getGreaterThanOrEqualToKeyword_21());
                    		

                    }
                    break;
                case 23 :
                    // InternalStatemachine.g:1861:3: kw= '>'
                    {
                    kw=(Token)match(input,86,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getGreaterThanSignKeyword_22());
                    		

                    }
                    break;
                case 24 :
                    // InternalStatemachine.g:1867:3: kw= '\\u2208'
                    {
                    kw=(Token)match(input,87,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getElementOfKeyword_23());
                    		

                    }
                    break;
                case 25 :
                    // InternalStatemachine.g:1873:3: kw= ':'
                    {
                    kw=(Token)match(input,31,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getColonKeyword_24());
                    		

                    }
                    break;
                case 26 :
                    // InternalStatemachine.g:1879:3: kw= '\\u2209'
                    {
                    kw=(Token)match(input,88,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotAnElementOfKeyword_25());
                    		

                    }
                    break;
                case 27 :
                    // InternalStatemachine.g:1885:3: kw= '\\u2282'
                    {
                    kw=(Token)match(input,89,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getSubsetOfKeyword_26());
                    		

                    }
                    break;
                case 28 :
                    // InternalStatemachine.g:1891:3: kw= '\\u2284'
                    {
                    kw=(Token)match(input,90,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotASubsetOfKeyword_27());
                    		

                    }
                    break;
                case 29 :
                    // InternalStatemachine.g:1897:3: kw= '\\u2286'
                    {
                    kw=(Token)match(input,91,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getSubsetOfOrEqualToKeyword_28());
                    		

                    }
                    break;
                case 30 :
                    // InternalStatemachine.g:1903:3: kw= '\\u2288'
                    {
                    kw=(Token)match(input,92,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNeitherASubsetOfNorEqualToKeyword_29());
                    		

                    }
                    break;
                case 31 :
                    // InternalStatemachine.g:1909:3: kw= 'partition'
                    {
                    kw=(Token)match(input,93,FOLLOW_2); 

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
    // InternalStatemachine.g:1918:1: entryRuleEVENTB_EXPRESSION_SYMBOLS returns [String current=null] : iv_ruleEVENTB_EXPRESSION_SYMBOLS= ruleEVENTB_EXPRESSION_SYMBOLS EOF ;
    public final String entryRuleEVENTB_EXPRESSION_SYMBOLS() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEVENTB_EXPRESSION_SYMBOLS = null;


        try {
            // InternalStatemachine.g:1918:65: (iv_ruleEVENTB_EXPRESSION_SYMBOLS= ruleEVENTB_EXPRESSION_SYMBOLS EOF )
            // InternalStatemachine.g:1919:2: iv_ruleEVENTB_EXPRESSION_SYMBOLS= ruleEVENTB_EXPRESSION_SYMBOLS EOF
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
    // InternalStatemachine.g:1925:1: ruleEVENTB_EXPRESSION_SYMBOLS returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '\\u2194' | kw= '\\uE100' | kw= '\\uE101' | kw= '\\uE102' | kw= '\\u21F8' | kw= '\\u2192' | kw= '\\u2914' | kw= '\\u21A3' | kw= '\\u2900' | kw= '\\u21A0' | kw= '\\u2916' | kw= '{' | kw= '}' | kw= '\\u21A6' | kw= '\\u2205' | kw= '\\u2229' | kw= '\\u222A' | kw= '\\u2216' | kw= '\\u00D7' | kw= '[' | kw= ']' | kw= '\\uE103' | kw= '\\u2218' | kw= ';' | kw= '\\u2297' | kw= '\\u2225' | kw= '\\u223C' | kw= '\\u25C1' | kw= '\\u2A64' | kw= '\\u25B7' | kw= '\\u2A65' | kw= '\\u03BB' | (kw= '%' kw= '\\u22C2' ) | kw= '\\u22C3' | kw= '\\u2223' | kw= '\\u2025' | kw= '+' | kw= '\\u2212' | kw= '-' | kw= '\\u2217' | kw= '*' | kw= '\\u00F7' | kw= '/' | kw= '^' | kw= '\\\\' ) ;
    public final AntlrDatatypeRuleToken ruleEVENTB_EXPRESSION_SYMBOLS() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalStatemachine.g:1931:2: ( (kw= '\\u2194' | kw= '\\uE100' | kw= '\\uE101' | kw= '\\uE102' | kw= '\\u21F8' | kw= '\\u2192' | kw= '\\u2914' | kw= '\\u21A3' | kw= '\\u2900' | kw= '\\u21A0' | kw= '\\u2916' | kw= '{' | kw= '}' | kw= '\\u21A6' | kw= '\\u2205' | kw= '\\u2229' | kw= '\\u222A' | kw= '\\u2216' | kw= '\\u00D7' | kw= '[' | kw= ']' | kw= '\\uE103' | kw= '\\u2218' | kw= ';' | kw= '\\u2297' | kw= '\\u2225' | kw= '\\u223C' | kw= '\\u25C1' | kw= '\\u2A64' | kw= '\\u25B7' | kw= '\\u2A65' | kw= '\\u03BB' | (kw= '%' kw= '\\u22C2' ) | kw= '\\u22C3' | kw= '\\u2223' | kw= '\\u2025' | kw= '+' | kw= '\\u2212' | kw= '-' | kw= '\\u2217' | kw= '*' | kw= '\\u00F7' | kw= '/' | kw= '^' | kw= '\\\\' ) )
            // InternalStatemachine.g:1932:2: (kw= '\\u2194' | kw= '\\uE100' | kw= '\\uE101' | kw= '\\uE102' | kw= '\\u21F8' | kw= '\\u2192' | kw= '\\u2914' | kw= '\\u21A3' | kw= '\\u2900' | kw= '\\u21A0' | kw= '\\u2916' | kw= '{' | kw= '}' | kw= '\\u21A6' | kw= '\\u2205' | kw= '\\u2229' | kw= '\\u222A' | kw= '\\u2216' | kw= '\\u00D7' | kw= '[' | kw= ']' | kw= '\\uE103' | kw= '\\u2218' | kw= ';' | kw= '\\u2297' | kw= '\\u2225' | kw= '\\u223C' | kw= '\\u25C1' | kw= '\\u2A64' | kw= '\\u25B7' | kw= '\\u2A65' | kw= '\\u03BB' | (kw= '%' kw= '\\u22C2' ) | kw= '\\u22C3' | kw= '\\u2223' | kw= '\\u2025' | kw= '+' | kw= '\\u2212' | kw= '-' | kw= '\\u2217' | kw= '*' | kw= '\\u00F7' | kw= '/' | kw= '^' | kw= '\\\\' )
            {
            // InternalStatemachine.g:1932:2: (kw= '\\u2194' | kw= '\\uE100' | kw= '\\uE101' | kw= '\\uE102' | kw= '\\u21F8' | kw= '\\u2192' | kw= '\\u2914' | kw= '\\u21A3' | kw= '\\u2900' | kw= '\\u21A0' | kw= '\\u2916' | kw= '{' | kw= '}' | kw= '\\u21A6' | kw= '\\u2205' | kw= '\\u2229' | kw= '\\u222A' | kw= '\\u2216' | kw= '\\u00D7' | kw= '[' | kw= ']' | kw= '\\uE103' | kw= '\\u2218' | kw= ';' | kw= '\\u2297' | kw= '\\u2225' | kw= '\\u223C' | kw= '\\u25C1' | kw= '\\u2A64' | kw= '\\u25B7' | kw= '\\u2A65' | kw= '\\u03BB' | (kw= '%' kw= '\\u22C2' ) | kw= '\\u22C3' | kw= '\\u2223' | kw= '\\u2025' | kw= '+' | kw= '\\u2212' | kw= '-' | kw= '\\u2217' | kw= '*' | kw= '\\u00F7' | kw= '/' | kw= '^' | kw= '\\\\' )
            int alt36=45;
            switch ( input.LA(1) ) {
            case 94:
                {
                alt36=1;
                }
                break;
            case 95:
                {
                alt36=2;
                }
                break;
            case 96:
                {
                alt36=3;
                }
                break;
            case 97:
                {
                alt36=4;
                }
                break;
            case 98:
                {
                alt36=5;
                }
                break;
            case 99:
                {
                alt36=6;
                }
                break;
            case 100:
                {
                alt36=7;
                }
                break;
            case 101:
                {
                alt36=8;
                }
                break;
            case 102:
                {
                alt36=9;
                }
                break;
            case 103:
                {
                alt36=10;
                }
                break;
            case 104:
                {
                alt36=11;
                }
                break;
            case 105:
                {
                alt36=12;
                }
                break;
            case 106:
                {
                alt36=13;
                }
                break;
            case 107:
                {
                alt36=14;
                }
                break;
            case 108:
                {
                alt36=15;
                }
                break;
            case 109:
                {
                alt36=16;
                }
                break;
            case 110:
                {
                alt36=17;
                }
                break;
            case 111:
                {
                alt36=18;
                }
                break;
            case 32:
                {
                alt36=19;
                }
                break;
            case 112:
                {
                alt36=20;
                }
                break;
            case 113:
                {
                alt36=21;
                }
                break;
            case 114:
                {
                alt36=22;
                }
                break;
            case 115:
                {
                alt36=23;
                }
                break;
            case 116:
                {
                alt36=24;
                }
                break;
            case 117:
                {
                alt36=25;
                }
                break;
            case 118:
                {
                alt36=26;
                }
                break;
            case 119:
                {
                alt36=27;
                }
                break;
            case 120:
                {
                alt36=28;
                }
                break;
            case 121:
                {
                alt36=29;
                }
                break;
            case 122:
                {
                alt36=30;
                }
                break;
            case 123:
                {
                alt36=31;
                }
                break;
            case 124:
                {
                alt36=32;
                }
                break;
            case 125:
                {
                alt36=33;
                }
                break;
            case 127:
                {
                alt36=34;
                }
                break;
            case 128:
                {
                alt36=35;
                }
                break;
            case 129:
                {
                alt36=36;
                }
                break;
            case 130:
                {
                alt36=37;
                }
                break;
            case 131:
                {
                alt36=38;
                }
                break;
            case 132:
                {
                alt36=39;
                }
                break;
            case 133:
                {
                alt36=40;
                }
                break;
            case 134:
                {
                alt36=41;
                }
                break;
            case 135:
                {
                alt36=42;
                }
                break;
            case 136:
                {
                alt36=43;
                }
                break;
            case 137:
                {
                alt36=44;
                }
                break;
            case 138:
                {
                alt36=45;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // InternalStatemachine.g:1933:3: kw= '\\u2194'
                    {
                    kw=(Token)match(input,94,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLeftRightArrowKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalStatemachine.g:1939:3: kw= '\\uE100'
                    {
                    kw=(Token)match(input,95,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE100Keyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalStatemachine.g:1945:3: kw= '\\uE101'
                    {
                    kw=(Token)match(input,96,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE101Keyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalStatemachine.g:1951:3: kw= '\\uE102'
                    {
                    kw=(Token)match(input,97,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE102Keyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalStatemachine.g:1957:3: kw= '\\u21F8'
                    {
                    kw=(Token)match(input,98,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowWithVerticalStrokeKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalStatemachine.g:1963:3: kw= '\\u2192'
                    {
                    kw=(Token)match(input,99,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalStatemachine.g:1969:3: kw= '\\u2914'
                    {
                    kw=(Token)match(input,100,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowWithTailWithVerticalStrokeKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalStatemachine.g:1975:3: kw= '\\u21A3'
                    {
                    kw=(Token)match(input,101,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowWithTailKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalStatemachine.g:1981:3: kw= '\\u2900'
                    {
                    kw=(Token)match(input,102,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsTwoHeadedArrowWithVerticalStrokeKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalStatemachine.g:1987:3: kw= '\\u21A0'
                    {
                    kw=(Token)match(input,103,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsTwoHeadedArrowKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalStatemachine.g:1993:3: kw= '\\u2916'
                    {
                    kw=(Token)match(input,104,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsTwoHeadedArrowWithTailKeyword_10());
                    		

                    }
                    break;
                case 12 :
                    // InternalStatemachine.g:1999:3: kw= '{'
                    {
                    kw=(Token)match(input,105,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLeftCurlyBracketKeyword_11());
                    		

                    }
                    break;
                case 13 :
                    // InternalStatemachine.g:2005:3: kw= '}'
                    {
                    kw=(Token)match(input,106,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightCurlyBracketKeyword_12());
                    		

                    }
                    break;
                case 14 :
                    // InternalStatemachine.g:2011:3: kw= '\\u21A6'
                    {
                    kw=(Token)match(input,107,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowFromBarKeyword_13());
                    		

                    }
                    break;
                case 15 :
                    // InternalStatemachine.g:2017:3: kw= '\\u2205'
                    {
                    kw=(Token)match(input,108,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getEmptySetKeyword_14());
                    		

                    }
                    break;
                case 16 :
                    // InternalStatemachine.g:2023:3: kw= '\\u2229'
                    {
                    kw=(Token)match(input,109,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getIntersectionKeyword_15());
                    		

                    }
                    break;
                case 17 :
                    // InternalStatemachine.g:2029:3: kw= '\\u222A'
                    {
                    kw=(Token)match(input,110,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getUnionKeyword_16());
                    		

                    }
                    break;
                case 18 :
                    // InternalStatemachine.g:2035:3: kw= '\\u2216'
                    {
                    kw=(Token)match(input,111,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getSetMinusKeyword_17());
                    		

                    }
                    break;
                case 19 :
                    // InternalStatemachine.g:2041:3: kw= '\\u00D7'
                    {
                    kw=(Token)match(input,32,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getMultiplicationSignKeyword_18());
                    		

                    }
                    break;
                case 20 :
                    // InternalStatemachine.g:2047:3: kw= '['
                    {
                    kw=(Token)match(input,112,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLeftSquareBracketKeyword_19());
                    		

                    }
                    break;
                case 21 :
                    // InternalStatemachine.g:2053:3: kw= ']'
                    {
                    kw=(Token)match(input,113,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightSquareBracketKeyword_20());
                    		

                    }
                    break;
                case 22 :
                    // InternalStatemachine.g:2059:3: kw= '\\uE103'
                    {
                    kw=(Token)match(input,114,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE103Keyword_21());
                    		

                    }
                    break;
                case 23 :
                    // InternalStatemachine.g:2065:3: kw= '\\u2218'
                    {
                    kw=(Token)match(input,115,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRingOperatorKeyword_22());
                    		

                    }
                    break;
                case 24 :
                    // InternalStatemachine.g:2071:3: kw= ';'
                    {
                    kw=(Token)match(input,116,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getSemicolonKeyword_23());
                    		

                    }
                    break;
                case 25 :
                    // InternalStatemachine.g:2077:3: kw= '\\u2297'
                    {
                    kw=(Token)match(input,117,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getCircledTimesKeyword_24());
                    		

                    }
                    break;
                case 26 :
                    // InternalStatemachine.g:2083:3: kw= '\\u2225'
                    {
                    kw=(Token)match(input,118,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getParallelToKeyword_25());
                    		

                    }
                    break;
                case 27 :
                    // InternalStatemachine.g:2089:3: kw= '\\u223C'
                    {
                    kw=(Token)match(input,119,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getTildeOperatorKeyword_26());
                    		

                    }
                    break;
                case 28 :
                    // InternalStatemachine.g:2095:3: kw= '\\u25C1'
                    {
                    kw=(Token)match(input,120,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getWhiteLeftPointingTriangleKeyword_27());
                    		

                    }
                    break;
                case 29 :
                    // InternalStatemachine.g:2101:3: kw= '\\u2A64'
                    {
                    kw=(Token)match(input,121,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getZNotationDomainAntirestrictionKeyword_28());
                    		

                    }
                    break;
                case 30 :
                    // InternalStatemachine.g:2107:3: kw= '\\u25B7'
                    {
                    kw=(Token)match(input,122,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getWhiteRightPointingTriangleKeyword_29());
                    		

                    }
                    break;
                case 31 :
                    // InternalStatemachine.g:2113:3: kw= '\\u2A65'
                    {
                    kw=(Token)match(input,123,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getZNotationRangeAntirestrictionKeyword_30());
                    		

                    }
                    break;
                case 32 :
                    // InternalStatemachine.g:2119:3: kw= '\\u03BB'
                    {
                    kw=(Token)match(input,124,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getGreekSmallLetterLamdaKeyword_31());
                    		

                    }
                    break;
                case 33 :
                    // InternalStatemachine.g:2125:3: (kw= '%' kw= '\\u22C2' )
                    {
                    // InternalStatemachine.g:2125:3: (kw= '%' kw= '\\u22C2' )
                    // InternalStatemachine.g:2126:4: kw= '%' kw= '\\u22C2'
                    {
                    kw=(Token)match(input,125,FOLLOW_41); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPercentSignKeyword_32_0());
                    			
                    kw=(Token)match(input,126,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getNAryIntersectionKeyword_32_1());
                    			

                    }


                    }
                    break;
                case 34 :
                    // InternalStatemachine.g:2138:3: kw= '\\u22C3'
                    {
                    kw=(Token)match(input,127,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getNAryUnionKeyword_33());
                    		

                    }
                    break;
                case 35 :
                    // InternalStatemachine.g:2144:3: kw= '\\u2223'
                    {
                    kw=(Token)match(input,128,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getDividesKeyword_34());
                    		

                    }
                    break;
                case 36 :
                    // InternalStatemachine.g:2150:3: kw= '\\u2025'
                    {
                    kw=(Token)match(input,129,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getTwoDotLeaderKeyword_35());
                    		

                    }
                    break;
                case 37 :
                    // InternalStatemachine.g:2156:3: kw= '+'
                    {
                    kw=(Token)match(input,130,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPlusSignKeyword_36());
                    		

                    }
                    break;
                case 38 :
                    // InternalStatemachine.g:2162:3: kw= '\\u2212'
                    {
                    kw=(Token)match(input,131,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getMinusSignKeyword_37());
                    		

                    }
                    break;
                case 39 :
                    // InternalStatemachine.g:2168:3: kw= '-'
                    {
                    kw=(Token)match(input,132,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getHyphenMinusKeyword_38());
                    		

                    }
                    break;
                case 40 :
                    // InternalStatemachine.g:2174:3: kw= '\\u2217'
                    {
                    kw=(Token)match(input,133,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getAsteriskOperatorKeyword_39());
                    		

                    }
                    break;
                case 41 :
                    // InternalStatemachine.g:2180:3: kw= '*'
                    {
                    kw=(Token)match(input,134,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getAsteriskKeyword_40());
                    		

                    }
                    break;
                case 42 :
                    // InternalStatemachine.g:2186:3: kw= '\\u00F7'
                    {
                    kw=(Token)match(input,135,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getDivisionSignKeyword_41());
                    		

                    }
                    break;
                case 43 :
                    // InternalStatemachine.g:2192:3: kw= '/'
                    {
                    kw=(Token)match(input,136,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getSolidusKeyword_42());
                    		

                    }
                    break;
                case 44 :
                    // InternalStatemachine.g:2198:3: kw= '^'
                    {
                    kw=(Token)match(input,137,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getCircumflexAccentKeyword_43());
                    		

                    }
                    break;
                case 45 :
                    // InternalStatemachine.g:2204:3: kw= '\\\\'
                    {
                    kw=(Token)match(input,138,FOLLOW_2); 

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
    // InternalStatemachine.g:2213:1: ruleTranslationKind returns [Enumerator current=null] : ( (enumLiteral_0= 'variables' ) | (enumLiteral_1= 'enumeration' ) | (enumLiteral_2= 'REFINEDVAR' ) ) ;
    public final Enumerator ruleTranslationKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalStatemachine.g:2219:2: ( ( (enumLiteral_0= 'variables' ) | (enumLiteral_1= 'enumeration' ) | (enumLiteral_2= 'REFINEDVAR' ) ) )
            // InternalStatemachine.g:2220:2: ( (enumLiteral_0= 'variables' ) | (enumLiteral_1= 'enumeration' ) | (enumLiteral_2= 'REFINEDVAR' ) )
            {
            // InternalStatemachine.g:2220:2: ( (enumLiteral_0= 'variables' ) | (enumLiteral_1= 'enumeration' ) | (enumLiteral_2= 'REFINEDVAR' ) )
            int alt37=3;
            switch ( input.LA(1) ) {
            case 139:
                {
                alt37=1;
                }
                break;
            case 140:
                {
                alt37=2;
                }
                break;
            case 141:
                {
                alt37=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // InternalStatemachine.g:2221:3: (enumLiteral_0= 'variables' )
                    {
                    // InternalStatemachine.g:2221:3: (enumLiteral_0= 'variables' )
                    // InternalStatemachine.g:2222:4: enumLiteral_0= 'variables'
                    {
                    enumLiteral_0=(Token)match(input,139,FOLLOW_2); 

                    				current = grammarAccess.getTranslationKindAccess().getMULTIVAREnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getTranslationKindAccess().getMULTIVAREnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalStatemachine.g:2229:3: (enumLiteral_1= 'enumeration' )
                    {
                    // InternalStatemachine.g:2229:3: (enumLiteral_1= 'enumeration' )
                    // InternalStatemachine.g:2230:4: enumLiteral_1= 'enumeration'
                    {
                    enumLiteral_1=(Token)match(input,140,FOLLOW_2); 

                    				current = grammarAccess.getTranslationKindAccess().getSINGLEVAREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getTranslationKindAccess().getSINGLEVAREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalStatemachine.g:2237:3: (enumLiteral_2= 'REFINEDVAR' )
                    {
                    // InternalStatemachine.g:2237:3: (enumLiteral_2= 'REFINEDVAR' )
                    // InternalStatemachine.g:2238:4: enumLiteral_2= 'REFINEDVAR'
                    {
                    enumLiteral_2=(Token)match(input,141,FOLLOW_2); 

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
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000003800L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000F82000138002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000F82000130002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000F82000120002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000F82000100002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000E00000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000C00030L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x000000007A000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x000000007C000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000001000000040L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000001070000040L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000060000040L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000040000040L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000E00000010L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0xFFFF000F84086090L,0xBFFFFFFFFFFFFFFFL,0x00000000000007FFL});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000074000010002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000074000000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000040001000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000070000000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000061000000002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000040000000042L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0xFFFF000F84086092L,0xBFFFFFFFFFFFFFFFL,0x00000000000007FFL});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});

}
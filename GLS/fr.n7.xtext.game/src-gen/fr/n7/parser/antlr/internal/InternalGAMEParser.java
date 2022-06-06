package fr.n7.parser.antlr.internal;

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
import fr.n7.services.GAMEGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalGAMEParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'game'", "'{'", "'}'", "'explorateur'", "'objets'", "'connaisances'", "'lieuCourant'", "'lieuxExplores'", "'limiteTaille'", "'objet'", "'initVal'", "'taille'", "'etat'", "'obtention'", "'connaissance'", "'lieu'", "'personnes'", "'connaissances'", "'chemins'", "'territoire'", "'depart'", "'inter'", "'fins'", "'condition'", "'objetsTrue'", "'objetsFalse'", "'connaissanceTrue'", "'connaissanceFalse'", "'lieuExplores'", "'etatChemin'", "'de'", "'a'", "'visible'", "'ouverture'", "'obligation'", "'objetsTransmis'", "'prixObjets'", "'personne'", "'activite'", "'visibilite'", "'interaction'", "'choixDebut'", "'choixInter'", "'choixFin'", "'Fin'", "'choix'", "'actions'", "'action'", "'objetsConsommes'", "'objetsProduits'", "'connaissanceProduits'", "'qualif'", "'-'", "'true'", "'false'", "'non visible'", "'ouvert'", "'ferme'", "'actif'", "'inactif'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
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

    // delegates
    // delegators


        public InternalGAMEParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalGAMEParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalGAMEParser.tokenNames; }
    public String getGrammarFileName() { return "InternalGAME.g"; }



     	private GAMEGrammarAccess grammarAccess;

        public InternalGAMEParser(TokenStream input, GAMEGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Game";
       	}

       	@Override
       	protected GAMEGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleGame"
    // InternalGAME.g:65:1: entryRuleGame returns [EObject current=null] : iv_ruleGame= ruleGame EOF ;
    public final EObject entryRuleGame() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGame = null;


        try {
            // InternalGAME.g:65:45: (iv_ruleGame= ruleGame EOF )
            // InternalGAME.g:66:2: iv_ruleGame= ruleGame EOF
            {
             newCompositeNode(grammarAccess.getGameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGame=ruleGame();

            state._fsp--;

             current =iv_ruleGame; 
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
    // $ANTLR end "entryRuleGame"


    // $ANTLR start "ruleGame"
    // InternalGAME.g:72:1: ruleGame returns [EObject current=null] : (otherlv_0= 'game' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_explorateur_3_0= ruleExplorateur ) ) ( (lv_territoire_4_0= ruleTerritoire ) ) otherlv_5= '}' ) ;
    public final EObject ruleGame() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_explorateur_3_0 = null;

        EObject lv_territoire_4_0 = null;



        	enterRule();

        try {
            // InternalGAME.g:78:2: ( (otherlv_0= 'game' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_explorateur_3_0= ruleExplorateur ) ) ( (lv_territoire_4_0= ruleTerritoire ) ) otherlv_5= '}' ) )
            // InternalGAME.g:79:2: (otherlv_0= 'game' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_explorateur_3_0= ruleExplorateur ) ) ( (lv_territoire_4_0= ruleTerritoire ) ) otherlv_5= '}' )
            {
            // InternalGAME.g:79:2: (otherlv_0= 'game' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_explorateur_3_0= ruleExplorateur ) ) ( (lv_territoire_4_0= ruleTerritoire ) ) otherlv_5= '}' )
            // InternalGAME.g:80:3: otherlv_0= 'game' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_explorateur_3_0= ruleExplorateur ) ) ( (lv_territoire_4_0= ruleTerritoire ) ) otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getGameAccess().getGameKeyword_0());
            		
            // InternalGAME.g:84:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalGAME.g:85:4: (lv_name_1_0= RULE_ID )
            {
            // InternalGAME.g:85:4: (lv_name_1_0= RULE_ID )
            // InternalGAME.g:86:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getGameAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGameRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getGameAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalGAME.g:106:3: ( (lv_explorateur_3_0= ruleExplorateur ) )
            // InternalGAME.g:107:4: (lv_explorateur_3_0= ruleExplorateur )
            {
            // InternalGAME.g:107:4: (lv_explorateur_3_0= ruleExplorateur )
            // InternalGAME.g:108:5: lv_explorateur_3_0= ruleExplorateur
            {

            					newCompositeNode(grammarAccess.getGameAccess().getExplorateurExplorateurParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_6);
            lv_explorateur_3_0=ruleExplorateur();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGameRule());
            					}
            					set(
            						current,
            						"explorateur",
            						lv_explorateur_3_0,
            						"fr.n7.GAME.Explorateur");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGAME.g:125:3: ( (lv_territoire_4_0= ruleTerritoire ) )
            // InternalGAME.g:126:4: (lv_territoire_4_0= ruleTerritoire )
            {
            // InternalGAME.g:126:4: (lv_territoire_4_0= ruleTerritoire )
            // InternalGAME.g:127:5: lv_territoire_4_0= ruleTerritoire
            {

            					newCompositeNode(grammarAccess.getGameAccess().getTerritoireTerritoireParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_7);
            lv_territoire_4_0=ruleTerritoire();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGameRule());
            					}
            					set(
            						current,
            						"territoire",
            						lv_territoire_4_0,
            						"fr.n7.GAME.Territoire");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getGameAccess().getRightCurlyBracketKeyword_5());
            		

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
    // $ANTLR end "ruleGame"


    // $ANTLR start "entryRuleEString"
    // InternalGAME.g:152:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalGAME.g:152:47: (iv_ruleEString= ruleEString EOF )
            // InternalGAME.g:153:2: iv_ruleEString= ruleEString EOF
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
    // InternalGAME.g:159:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalGAME.g:165:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalGAME.g:166:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalGAME.g:166:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_STRING) ) {
                alt1=1;
            }
            else if ( (LA1_0==RULE_ID) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalGAME.g:167:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalGAME.g:175:3: this_ID_1= RULE_ID
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


    // $ANTLR start "entryRuleExplorateur"
    // InternalGAME.g:186:1: entryRuleExplorateur returns [EObject current=null] : iv_ruleExplorateur= ruleExplorateur EOF ;
    public final EObject entryRuleExplorateur() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExplorateur = null;


        try {
            // InternalGAME.g:186:52: (iv_ruleExplorateur= ruleExplorateur EOF )
            // InternalGAME.g:187:2: iv_ruleExplorateur= ruleExplorateur EOF
            {
             newCompositeNode(grammarAccess.getExplorateurRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExplorateur=ruleExplorateur();

            state._fsp--;

             current =iv_ruleExplorateur; 
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
    // $ANTLR end "entryRuleExplorateur"


    // $ANTLR start "ruleExplorateur"
    // InternalGAME.g:193:1: ruleExplorateur returns [EObject current=null] : (otherlv_0= 'explorateur' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'objets' ( (lv_objets_4_0= ruleObjet ) )* otherlv_5= 'connaisances' ( (lv_connaissances_6_0= ruleConnaissance ) )* otherlv_7= 'lieuCourant' ( (otherlv_8= RULE_ID ) ) otherlv_9= 'lieuxExplores' ( (otherlv_10= RULE_ID ) )* otherlv_11= 'limiteTaille' ( (lv_limite_12_0= ruleEInt ) ) otherlv_13= '}' ) ;
    public final EObject ruleExplorateur() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_objets_4_0 = null;

        EObject lv_connaissances_6_0 = null;

        AntlrDatatypeRuleToken lv_limite_12_0 = null;



        	enterRule();

        try {
            // InternalGAME.g:199:2: ( (otherlv_0= 'explorateur' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'objets' ( (lv_objets_4_0= ruleObjet ) )* otherlv_5= 'connaisances' ( (lv_connaissances_6_0= ruleConnaissance ) )* otherlv_7= 'lieuCourant' ( (otherlv_8= RULE_ID ) ) otherlv_9= 'lieuxExplores' ( (otherlv_10= RULE_ID ) )* otherlv_11= 'limiteTaille' ( (lv_limite_12_0= ruleEInt ) ) otherlv_13= '}' ) )
            // InternalGAME.g:200:2: (otherlv_0= 'explorateur' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'objets' ( (lv_objets_4_0= ruleObjet ) )* otherlv_5= 'connaisances' ( (lv_connaissances_6_0= ruleConnaissance ) )* otherlv_7= 'lieuCourant' ( (otherlv_8= RULE_ID ) ) otherlv_9= 'lieuxExplores' ( (otherlv_10= RULE_ID ) )* otherlv_11= 'limiteTaille' ( (lv_limite_12_0= ruleEInt ) ) otherlv_13= '}' )
            {
            // InternalGAME.g:200:2: (otherlv_0= 'explorateur' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'objets' ( (lv_objets_4_0= ruleObjet ) )* otherlv_5= 'connaisances' ( (lv_connaissances_6_0= ruleConnaissance ) )* otherlv_7= 'lieuCourant' ( (otherlv_8= RULE_ID ) ) otherlv_9= 'lieuxExplores' ( (otherlv_10= RULE_ID ) )* otherlv_11= 'limiteTaille' ( (lv_limite_12_0= ruleEInt ) ) otherlv_13= '}' )
            // InternalGAME.g:201:3: otherlv_0= 'explorateur' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'objets' ( (lv_objets_4_0= ruleObjet ) )* otherlv_5= 'connaisances' ( (lv_connaissances_6_0= ruleConnaissance ) )* otherlv_7= 'lieuCourant' ( (otherlv_8= RULE_ID ) ) otherlv_9= 'lieuxExplores' ( (otherlv_10= RULE_ID ) )* otherlv_11= 'limiteTaille' ( (lv_limite_12_0= ruleEInt ) ) otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getExplorateurAccess().getExplorateurKeyword_0());
            		
            // InternalGAME.g:205:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalGAME.g:206:4: (lv_name_1_0= RULE_ID )
            {
            // InternalGAME.g:206:4: (lv_name_1_0= RULE_ID )
            // InternalGAME.g:207:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getExplorateurAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getExplorateurRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getExplorateurAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,15,FOLLOW_9); 

            			newLeafNode(otherlv_3, grammarAccess.getExplorateurAccess().getObjetsKeyword_3());
            		
            // InternalGAME.g:231:3: ( (lv_objets_4_0= ruleObjet ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==20) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalGAME.g:232:4: (lv_objets_4_0= ruleObjet )
            	    {
            	    // InternalGAME.g:232:4: (lv_objets_4_0= ruleObjet )
            	    // InternalGAME.g:233:5: lv_objets_4_0= ruleObjet
            	    {

            	    					newCompositeNode(grammarAccess.getExplorateurAccess().getObjetsObjetParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_9);
            	    lv_objets_4_0=ruleObjet();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getExplorateurRule());
            	    					}
            	    					add(
            	    						current,
            	    						"objets",
            	    						lv_objets_4_0,
            	    						"fr.n7.GAME.Objet");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_5=(Token)match(input,16,FOLLOW_10); 

            			newLeafNode(otherlv_5, grammarAccess.getExplorateurAccess().getConnaisancesKeyword_5());
            		
            // InternalGAME.g:254:3: ( (lv_connaissances_6_0= ruleConnaissance ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==25) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalGAME.g:255:4: (lv_connaissances_6_0= ruleConnaissance )
            	    {
            	    // InternalGAME.g:255:4: (lv_connaissances_6_0= ruleConnaissance )
            	    // InternalGAME.g:256:5: lv_connaissances_6_0= ruleConnaissance
            	    {

            	    					newCompositeNode(grammarAccess.getExplorateurAccess().getConnaissancesConnaissanceParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_10);
            	    lv_connaissances_6_0=ruleConnaissance();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getExplorateurRule());
            	    					}
            	    					add(
            	    						current,
            	    						"connaissances",
            	    						lv_connaissances_6_0,
            	    						"fr.n7.GAME.Connaissance");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_7=(Token)match(input,17,FOLLOW_3); 

            			newLeafNode(otherlv_7, grammarAccess.getExplorateurAccess().getLieuCourantKeyword_7());
            		
            // InternalGAME.g:277:3: ( (otherlv_8= RULE_ID ) )
            // InternalGAME.g:278:4: (otherlv_8= RULE_ID )
            {
            // InternalGAME.g:278:4: (otherlv_8= RULE_ID )
            // InternalGAME.g:279:5: otherlv_8= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getExplorateurRule());
            					}
            				
            otherlv_8=(Token)match(input,RULE_ID,FOLLOW_11); 

            					newLeafNode(otherlv_8, grammarAccess.getExplorateurAccess().getLieuCourantLieuCrossReference_8_0());
            				

            }


            }

            otherlv_9=(Token)match(input,18,FOLLOW_12); 

            			newLeafNode(otherlv_9, grammarAccess.getExplorateurAccess().getLieuxExploresKeyword_9());
            		
            // InternalGAME.g:294:3: ( (otherlv_10= RULE_ID ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalGAME.g:295:4: (otherlv_10= RULE_ID )
            	    {
            	    // InternalGAME.g:295:4: (otherlv_10= RULE_ID )
            	    // InternalGAME.g:296:5: otherlv_10= RULE_ID
            	    {

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getExplorateurRule());
            	    					}
            	    				
            	    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_12); 

            	    					newLeafNode(otherlv_10, grammarAccess.getExplorateurAccess().getLieuExploresLieuCrossReference_10_0());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_11=(Token)match(input,19,FOLLOW_13); 

            			newLeafNode(otherlv_11, grammarAccess.getExplorateurAccess().getLimiteTailleKeyword_11());
            		
            // InternalGAME.g:311:3: ( (lv_limite_12_0= ruleEInt ) )
            // InternalGAME.g:312:4: (lv_limite_12_0= ruleEInt )
            {
            // InternalGAME.g:312:4: (lv_limite_12_0= ruleEInt )
            // InternalGAME.g:313:5: lv_limite_12_0= ruleEInt
            {

            					newCompositeNode(grammarAccess.getExplorateurAccess().getLimiteEIntParserRuleCall_12_0());
            				
            pushFollow(FOLLOW_7);
            lv_limite_12_0=ruleEInt();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExplorateurRule());
            					}
            					set(
            						current,
            						"limite",
            						lv_limite_12_0,
            						"fr.n7.GAME.EInt");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_13=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getExplorateurAccess().getRightCurlyBracketKeyword_13());
            		

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
    // $ANTLR end "ruleExplorateur"


    // $ANTLR start "entryRuleObjet"
    // InternalGAME.g:338:1: entryRuleObjet returns [EObject current=null] : iv_ruleObjet= ruleObjet EOF ;
    public final EObject entryRuleObjet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjet = null;


        try {
            // InternalGAME.g:338:46: (iv_ruleObjet= ruleObjet EOF )
            // InternalGAME.g:339:2: iv_ruleObjet= ruleObjet EOF
            {
             newCompositeNode(grammarAccess.getObjetRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObjet=ruleObjet();

            state._fsp--;

             current =iv_ruleObjet; 
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
    // $ANTLR end "entryRuleObjet"


    // $ANTLR start "ruleObjet"
    // InternalGAME.g:345:1: ruleObjet returns [EObject current=null] : (otherlv_0= 'objet' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'initVal' ( (lv_initVal_3_0= ruleEInt ) ) otherlv_4= 'taille' ( (lv_taille_5_0= ruleEInt ) ) otherlv_6= 'etat' ( (lv_etat_7_0= ruleEtatVisibilite ) ) (otherlv_8= 'obtention' ( (lv_condition_9_0= ruleCondition ) ) )? ( (lv_qualification_10_0= ruleQualification ) )* ) ;
    public final EObject ruleObjet() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_initVal_3_0 = null;

        AntlrDatatypeRuleToken lv_taille_5_0 = null;

        Enumerator lv_etat_7_0 = null;

        EObject lv_condition_9_0 = null;

        EObject lv_qualification_10_0 = null;



        	enterRule();

        try {
            // InternalGAME.g:351:2: ( (otherlv_0= 'objet' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'initVal' ( (lv_initVal_3_0= ruleEInt ) ) otherlv_4= 'taille' ( (lv_taille_5_0= ruleEInt ) ) otherlv_6= 'etat' ( (lv_etat_7_0= ruleEtatVisibilite ) ) (otherlv_8= 'obtention' ( (lv_condition_9_0= ruleCondition ) ) )? ( (lv_qualification_10_0= ruleQualification ) )* ) )
            // InternalGAME.g:352:2: (otherlv_0= 'objet' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'initVal' ( (lv_initVal_3_0= ruleEInt ) ) otherlv_4= 'taille' ( (lv_taille_5_0= ruleEInt ) ) otherlv_6= 'etat' ( (lv_etat_7_0= ruleEtatVisibilite ) ) (otherlv_8= 'obtention' ( (lv_condition_9_0= ruleCondition ) ) )? ( (lv_qualification_10_0= ruleQualification ) )* )
            {
            // InternalGAME.g:352:2: (otherlv_0= 'objet' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'initVal' ( (lv_initVal_3_0= ruleEInt ) ) otherlv_4= 'taille' ( (lv_taille_5_0= ruleEInt ) ) otherlv_6= 'etat' ( (lv_etat_7_0= ruleEtatVisibilite ) ) (otherlv_8= 'obtention' ( (lv_condition_9_0= ruleCondition ) ) )? ( (lv_qualification_10_0= ruleQualification ) )* )
            // InternalGAME.g:353:3: otherlv_0= 'objet' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'initVal' ( (lv_initVal_3_0= ruleEInt ) ) otherlv_4= 'taille' ( (lv_taille_5_0= ruleEInt ) ) otherlv_6= 'etat' ( (lv_etat_7_0= ruleEtatVisibilite ) ) (otherlv_8= 'obtention' ( (lv_condition_9_0= ruleCondition ) ) )? ( (lv_qualification_10_0= ruleQualification ) )*
            {
            otherlv_0=(Token)match(input,20,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getObjetAccess().getObjetKeyword_0());
            		
            // InternalGAME.g:357:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalGAME.g:358:4: (lv_name_1_0= RULE_ID )
            {
            // InternalGAME.g:358:4: (lv_name_1_0= RULE_ID )
            // InternalGAME.g:359:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(lv_name_1_0, grammarAccess.getObjetAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getObjetRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,21,FOLLOW_13); 

            			newLeafNode(otherlv_2, grammarAccess.getObjetAccess().getInitValKeyword_2());
            		
            // InternalGAME.g:379:3: ( (lv_initVal_3_0= ruleEInt ) )
            // InternalGAME.g:380:4: (lv_initVal_3_0= ruleEInt )
            {
            // InternalGAME.g:380:4: (lv_initVal_3_0= ruleEInt )
            // InternalGAME.g:381:5: lv_initVal_3_0= ruleEInt
            {

            					newCompositeNode(grammarAccess.getObjetAccess().getInitValEIntParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_15);
            lv_initVal_3_0=ruleEInt();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObjetRule());
            					}
            					set(
            						current,
            						"initVal",
            						lv_initVal_3_0,
            						"fr.n7.GAME.EInt");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,22,FOLLOW_13); 

            			newLeafNode(otherlv_4, grammarAccess.getObjetAccess().getTailleKeyword_4());
            		
            // InternalGAME.g:402:3: ( (lv_taille_5_0= ruleEInt ) )
            // InternalGAME.g:403:4: (lv_taille_5_0= ruleEInt )
            {
            // InternalGAME.g:403:4: (lv_taille_5_0= ruleEInt )
            // InternalGAME.g:404:5: lv_taille_5_0= ruleEInt
            {

            					newCompositeNode(grammarAccess.getObjetAccess().getTailleEIntParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_16);
            lv_taille_5_0=ruleEInt();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObjetRule());
            					}
            					set(
            						current,
            						"taille",
            						lv_taille_5_0,
            						"fr.n7.GAME.EInt");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,23,FOLLOW_17); 

            			newLeafNode(otherlv_6, grammarAccess.getObjetAccess().getEtatKeyword_6());
            		
            // InternalGAME.g:425:3: ( (lv_etat_7_0= ruleEtatVisibilite ) )
            // InternalGAME.g:426:4: (lv_etat_7_0= ruleEtatVisibilite )
            {
            // InternalGAME.g:426:4: (lv_etat_7_0= ruleEtatVisibilite )
            // InternalGAME.g:427:5: lv_etat_7_0= ruleEtatVisibilite
            {

            					newCompositeNode(grammarAccess.getObjetAccess().getEtatEtatVisibiliteEnumRuleCall_7_0());
            				
            pushFollow(FOLLOW_18);
            lv_etat_7_0=ruleEtatVisibilite();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObjetRule());
            					}
            					set(
            						current,
            						"etat",
            						lv_etat_7_0,
            						"fr.n7.GAME.EtatVisibilite");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGAME.g:444:3: (otherlv_8= 'obtention' ( (lv_condition_9_0= ruleCondition ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==24) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalGAME.g:445:4: otherlv_8= 'obtention' ( (lv_condition_9_0= ruleCondition ) )
                    {
                    otherlv_8=(Token)match(input,24,FOLLOW_19); 

                    				newLeafNode(otherlv_8, grammarAccess.getObjetAccess().getObtentionKeyword_8_0());
                    			
                    // InternalGAME.g:449:4: ( (lv_condition_9_0= ruleCondition ) )
                    // InternalGAME.g:450:5: (lv_condition_9_0= ruleCondition )
                    {
                    // InternalGAME.g:450:5: (lv_condition_9_0= ruleCondition )
                    // InternalGAME.g:451:6: lv_condition_9_0= ruleCondition
                    {

                    						newCompositeNode(grammarAccess.getObjetAccess().getConditionConditionParserRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_20);
                    lv_condition_9_0=ruleCondition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getObjetRule());
                    						}
                    						set(
                    							current,
                    							"condition",
                    							lv_condition_9_0,
                    							"fr.n7.GAME.Condition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalGAME.g:469:3: ( (lv_qualification_10_0= ruleQualification ) )*
            loop6:
            do {
                int alt6=2;
                alt6 = dfa6.predict(input);
                switch (alt6) {
            	case 1 :
            	    // InternalGAME.g:470:4: (lv_qualification_10_0= ruleQualification )
            	    {
            	    // InternalGAME.g:470:4: (lv_qualification_10_0= ruleQualification )
            	    // InternalGAME.g:471:5: lv_qualification_10_0= ruleQualification
            	    {

            	    					newCompositeNode(grammarAccess.getObjetAccess().getQualificationQualificationParserRuleCall_9_0());
            	    				
            	    pushFollow(FOLLOW_20);
            	    lv_qualification_10_0=ruleQualification();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getObjetRule());
            	    					}
            	    					add(
            	    						current,
            	    						"qualification",
            	    						lv_qualification_10_0,
            	    						"fr.n7.GAME.Qualification");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
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
    // $ANTLR end "ruleObjet"


    // $ANTLR start "entryRuleConnaissance"
    // InternalGAME.g:492:1: entryRuleConnaissance returns [EObject current=null] : iv_ruleConnaissance= ruleConnaissance EOF ;
    public final EObject entryRuleConnaissance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnaissance = null;


        try {
            // InternalGAME.g:492:53: (iv_ruleConnaissance= ruleConnaissance EOF )
            // InternalGAME.g:493:2: iv_ruleConnaissance= ruleConnaissance EOF
            {
             newCompositeNode(grammarAccess.getConnaissanceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConnaissance=ruleConnaissance();

            state._fsp--;

             current =iv_ruleConnaissance; 
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
    // $ANTLR end "entryRuleConnaissance"


    // $ANTLR start "ruleConnaissance"
    // InternalGAME.g:499:1: ruleConnaissance returns [EObject current=null] : (otherlv_0= 'connaissance' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_qualification_3_0= ruleQualification ) )* (otherlv_4= 'obtention' ( (lv_condition_5_0= ruleCondition ) ) )? otherlv_6= 'etat' ( (lv_etat_7_0= ruleEtatVisibilite ) ) otherlv_8= '}' ) ;
    public final EObject ruleConnaissance() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_qualification_3_0 = null;

        EObject lv_condition_5_0 = null;

        Enumerator lv_etat_7_0 = null;



        	enterRule();

        try {
            // InternalGAME.g:505:2: ( (otherlv_0= 'connaissance' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_qualification_3_0= ruleQualification ) )* (otherlv_4= 'obtention' ( (lv_condition_5_0= ruleCondition ) ) )? otherlv_6= 'etat' ( (lv_etat_7_0= ruleEtatVisibilite ) ) otherlv_8= '}' ) )
            // InternalGAME.g:506:2: (otherlv_0= 'connaissance' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_qualification_3_0= ruleQualification ) )* (otherlv_4= 'obtention' ( (lv_condition_5_0= ruleCondition ) ) )? otherlv_6= 'etat' ( (lv_etat_7_0= ruleEtatVisibilite ) ) otherlv_8= '}' )
            {
            // InternalGAME.g:506:2: (otherlv_0= 'connaissance' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_qualification_3_0= ruleQualification ) )* (otherlv_4= 'obtention' ( (lv_condition_5_0= ruleCondition ) ) )? otherlv_6= 'etat' ( (lv_etat_7_0= ruleEtatVisibilite ) ) otherlv_8= '}' )
            // InternalGAME.g:507:3: otherlv_0= 'connaissance' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_qualification_3_0= ruleQualification ) )* (otherlv_4= 'obtention' ( (lv_condition_5_0= ruleCondition ) ) )? otherlv_6= 'etat' ( (lv_etat_7_0= ruleEtatVisibilite ) ) otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getConnaissanceAccess().getConnaissanceKeyword_0());
            		
            // InternalGAME.g:511:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalGAME.g:512:4: (lv_name_1_0= RULE_ID )
            {
            // InternalGAME.g:512:4: (lv_name_1_0= RULE_ID )
            // InternalGAME.g:513:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getConnaissanceAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConnaissanceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getConnaissanceAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalGAME.g:533:3: ( (lv_qualification_3_0= ruleQualification ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==62) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalGAME.g:534:4: (lv_qualification_3_0= ruleQualification )
            	    {
            	    // InternalGAME.g:534:4: (lv_qualification_3_0= ruleQualification )
            	    // InternalGAME.g:535:5: lv_qualification_3_0= ruleQualification
            	    {

            	    					newCompositeNode(grammarAccess.getConnaissanceAccess().getQualificationQualificationParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_21);
            	    lv_qualification_3_0=ruleQualification();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getConnaissanceRule());
            	    					}
            	    					add(
            	    						current,
            	    						"qualification",
            	    						lv_qualification_3_0,
            	    						"fr.n7.GAME.Qualification");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // InternalGAME.g:552:3: (otherlv_4= 'obtention' ( (lv_condition_5_0= ruleCondition ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==24) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalGAME.g:553:4: otherlv_4= 'obtention' ( (lv_condition_5_0= ruleCondition ) )
                    {
                    otherlv_4=(Token)match(input,24,FOLLOW_19); 

                    				newLeafNode(otherlv_4, grammarAccess.getConnaissanceAccess().getObtentionKeyword_4_0());
                    			
                    // InternalGAME.g:557:4: ( (lv_condition_5_0= ruleCondition ) )
                    // InternalGAME.g:558:5: (lv_condition_5_0= ruleCondition )
                    {
                    // InternalGAME.g:558:5: (lv_condition_5_0= ruleCondition )
                    // InternalGAME.g:559:6: lv_condition_5_0= ruleCondition
                    {

                    						newCompositeNode(grammarAccess.getConnaissanceAccess().getConditionConditionParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_16);
                    lv_condition_5_0=ruleCondition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getConnaissanceRule());
                    						}
                    						set(
                    							current,
                    							"condition",
                    							lv_condition_5_0,
                    							"fr.n7.GAME.Condition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,23,FOLLOW_17); 

            			newLeafNode(otherlv_6, grammarAccess.getConnaissanceAccess().getEtatKeyword_5());
            		
            // InternalGAME.g:581:3: ( (lv_etat_7_0= ruleEtatVisibilite ) )
            // InternalGAME.g:582:4: (lv_etat_7_0= ruleEtatVisibilite )
            {
            // InternalGAME.g:582:4: (lv_etat_7_0= ruleEtatVisibilite )
            // InternalGAME.g:583:5: lv_etat_7_0= ruleEtatVisibilite
            {

            					newCompositeNode(grammarAccess.getConnaissanceAccess().getEtatEtatVisibiliteEnumRuleCall_6_0());
            				
            pushFollow(FOLLOW_7);
            lv_etat_7_0=ruleEtatVisibilite();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConnaissanceRule());
            					}
            					set(
            						current,
            						"etat",
            						lv_etat_7_0,
            						"fr.n7.GAME.EtatVisibilite");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getConnaissanceAccess().getRightCurlyBracketKeyword_7());
            		

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
    // $ANTLR end "ruleConnaissance"


    // $ANTLR start "entryRuleLieu"
    // InternalGAME.g:608:1: entryRuleLieu returns [EObject current=null] : iv_ruleLieu= ruleLieu EOF ;
    public final EObject entryRuleLieu() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLieu = null;


        try {
            // InternalGAME.g:608:45: (iv_ruleLieu= ruleLieu EOF )
            // InternalGAME.g:609:2: iv_ruleLieu= ruleLieu EOF
            {
             newCompositeNode(grammarAccess.getLieuRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLieu=ruleLieu();

            state._fsp--;

             current =iv_ruleLieu; 
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
    // $ANTLR end "entryRuleLieu"


    // $ANTLR start "ruleLieu"
    // InternalGAME.g:615:1: ruleLieu returns [EObject current=null] : (otherlv_0= 'lieu' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'personnes' ( (lv_personnes_4_0= rulePersonne ) )* otherlv_5= 'objets' ( (lv_objets_6_0= ruleObjet ) )* otherlv_7= 'connaissances' ( (lv_connaisances_8_0= ruleConnaissance ) )* otherlv_9= 'chemins' ( (lv_chemin_10_0= ruleChemin ) )* ( (lv_qualification_11_0= ruleQualification ) )* otherlv_12= '}' ) ;
    public final EObject ruleLieu() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_12=null;
        EObject lv_personnes_4_0 = null;

        EObject lv_objets_6_0 = null;

        EObject lv_connaisances_8_0 = null;

        EObject lv_chemin_10_0 = null;

        EObject lv_qualification_11_0 = null;



        	enterRule();

        try {
            // InternalGAME.g:621:2: ( (otherlv_0= 'lieu' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'personnes' ( (lv_personnes_4_0= rulePersonne ) )* otherlv_5= 'objets' ( (lv_objets_6_0= ruleObjet ) )* otherlv_7= 'connaissances' ( (lv_connaisances_8_0= ruleConnaissance ) )* otherlv_9= 'chemins' ( (lv_chemin_10_0= ruleChemin ) )* ( (lv_qualification_11_0= ruleQualification ) )* otherlv_12= '}' ) )
            // InternalGAME.g:622:2: (otherlv_0= 'lieu' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'personnes' ( (lv_personnes_4_0= rulePersonne ) )* otherlv_5= 'objets' ( (lv_objets_6_0= ruleObjet ) )* otherlv_7= 'connaissances' ( (lv_connaisances_8_0= ruleConnaissance ) )* otherlv_9= 'chemins' ( (lv_chemin_10_0= ruleChemin ) )* ( (lv_qualification_11_0= ruleQualification ) )* otherlv_12= '}' )
            {
            // InternalGAME.g:622:2: (otherlv_0= 'lieu' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'personnes' ( (lv_personnes_4_0= rulePersonne ) )* otherlv_5= 'objets' ( (lv_objets_6_0= ruleObjet ) )* otherlv_7= 'connaissances' ( (lv_connaisances_8_0= ruleConnaissance ) )* otherlv_9= 'chemins' ( (lv_chemin_10_0= ruleChemin ) )* ( (lv_qualification_11_0= ruleQualification ) )* otherlv_12= '}' )
            // InternalGAME.g:623:3: otherlv_0= 'lieu' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'personnes' ( (lv_personnes_4_0= rulePersonne ) )* otherlv_5= 'objets' ( (lv_objets_6_0= ruleObjet ) )* otherlv_7= 'connaissances' ( (lv_connaisances_8_0= ruleConnaissance ) )* otherlv_9= 'chemins' ( (lv_chemin_10_0= ruleChemin ) )* ( (lv_qualification_11_0= ruleQualification ) )* otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getLieuAccess().getLieuKeyword_0());
            		
            // InternalGAME.g:627:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalGAME.g:628:4: (lv_name_1_0= RULE_ID )
            {
            // InternalGAME.g:628:4: (lv_name_1_0= RULE_ID )
            // InternalGAME.g:629:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getLieuAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLieuRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_22); 

            			newLeafNode(otherlv_2, grammarAccess.getLieuAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,27,FOLLOW_23); 

            			newLeafNode(otherlv_3, grammarAccess.getLieuAccess().getPersonnesKeyword_3());
            		
            // InternalGAME.g:653:3: ( (lv_personnes_4_0= rulePersonne ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==48) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalGAME.g:654:4: (lv_personnes_4_0= rulePersonne )
            	    {
            	    // InternalGAME.g:654:4: (lv_personnes_4_0= rulePersonne )
            	    // InternalGAME.g:655:5: lv_personnes_4_0= rulePersonne
            	    {

            	    					newCompositeNode(grammarAccess.getLieuAccess().getPersonnesPersonneParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_23);
            	    lv_personnes_4_0=rulePersonne();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getLieuRule());
            	    					}
            	    					add(
            	    						current,
            	    						"personnes",
            	    						lv_personnes_4_0,
            	    						"fr.n7.GAME.Personne");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            otherlv_5=(Token)match(input,15,FOLLOW_24); 

            			newLeafNode(otherlv_5, grammarAccess.getLieuAccess().getObjetsKeyword_5());
            		
            // InternalGAME.g:676:3: ( (lv_objets_6_0= ruleObjet ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==20) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalGAME.g:677:4: (lv_objets_6_0= ruleObjet )
            	    {
            	    // InternalGAME.g:677:4: (lv_objets_6_0= ruleObjet )
            	    // InternalGAME.g:678:5: lv_objets_6_0= ruleObjet
            	    {

            	    					newCompositeNode(grammarAccess.getLieuAccess().getObjetsObjetParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_24);
            	    lv_objets_6_0=ruleObjet();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getLieuRule());
            	    					}
            	    					add(
            	    						current,
            	    						"objets",
            	    						lv_objets_6_0,
            	    						"fr.n7.GAME.Objet");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            otherlv_7=(Token)match(input,28,FOLLOW_25); 

            			newLeafNode(otherlv_7, grammarAccess.getLieuAccess().getConnaissancesKeyword_7());
            		
            // InternalGAME.g:699:3: ( (lv_connaisances_8_0= ruleConnaissance ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==25) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalGAME.g:700:4: (lv_connaisances_8_0= ruleConnaissance )
            	    {
            	    // InternalGAME.g:700:4: (lv_connaisances_8_0= ruleConnaissance )
            	    // InternalGAME.g:701:5: lv_connaisances_8_0= ruleConnaissance
            	    {

            	    					newCompositeNode(grammarAccess.getLieuAccess().getConnaisancesConnaissanceParserRuleCall_8_0());
            	    				
            	    pushFollow(FOLLOW_25);
            	    lv_connaisances_8_0=ruleConnaissance();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getLieuRule());
            	    					}
            	    					add(
            	    						current,
            	    						"connaisances",
            	    						lv_connaisances_8_0,
            	    						"fr.n7.GAME.Connaissance");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            otherlv_9=(Token)match(input,29,FOLLOW_26); 

            			newLeafNode(otherlv_9, grammarAccess.getLieuAccess().getCheminsKeyword_9());
            		
            // InternalGAME.g:722:3: ( (lv_chemin_10_0= ruleChemin ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==40) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalGAME.g:723:4: (lv_chemin_10_0= ruleChemin )
            	    {
            	    // InternalGAME.g:723:4: (lv_chemin_10_0= ruleChemin )
            	    // InternalGAME.g:724:5: lv_chemin_10_0= ruleChemin
            	    {

            	    					newCompositeNode(grammarAccess.getLieuAccess().getCheminCheminParserRuleCall_10_0());
            	    				
            	    pushFollow(FOLLOW_26);
            	    lv_chemin_10_0=ruleChemin();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getLieuRule());
            	    					}
            	    					add(
            	    						current,
            	    						"chemin",
            	    						lv_chemin_10_0,
            	    						"fr.n7.GAME.Chemin");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // InternalGAME.g:741:3: ( (lv_qualification_11_0= ruleQualification ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==62) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalGAME.g:742:4: (lv_qualification_11_0= ruleQualification )
            	    {
            	    // InternalGAME.g:742:4: (lv_qualification_11_0= ruleQualification )
            	    // InternalGAME.g:743:5: lv_qualification_11_0= ruleQualification
            	    {

            	    					newCompositeNode(grammarAccess.getLieuAccess().getQualificationQualificationParserRuleCall_11_0());
            	    				
            	    pushFollow(FOLLOW_27);
            	    lv_qualification_11_0=ruleQualification();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getLieuRule());
            	    					}
            	    					add(
            	    						current,
            	    						"qualification",
            	    						lv_qualification_11_0,
            	    						"fr.n7.GAME.Qualification");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            otherlv_12=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getLieuAccess().getRightCurlyBracketKeyword_12());
            		

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
    // $ANTLR end "ruleLieu"


    // $ANTLR start "entryRuleTerritoire"
    // InternalGAME.g:768:1: entryRuleTerritoire returns [EObject current=null] : iv_ruleTerritoire= ruleTerritoire EOF ;
    public final EObject entryRuleTerritoire() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerritoire = null;


        try {
            // InternalGAME.g:768:51: (iv_ruleTerritoire= ruleTerritoire EOF )
            // InternalGAME.g:769:2: iv_ruleTerritoire= ruleTerritoire EOF
            {
             newCompositeNode(grammarAccess.getTerritoireRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTerritoire=ruleTerritoire();

            state._fsp--;

             current =iv_ruleTerritoire; 
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
    // $ANTLR end "entryRuleTerritoire"


    // $ANTLR start "ruleTerritoire"
    // InternalGAME.g:775:1: ruleTerritoire returns [EObject current=null] : (otherlv_0= 'territoire' otherlv_1= '{' otherlv_2= 'depart' ( (lv_lieuDepart_3_0= ruleLieu ) ) otherlv_4= 'inter' ( (lv_lieux_5_0= ruleLieu ) )* otherlv_6= 'fins' ( (lv_lieuxFin_7_0= ruleLieu ) )* otherlv_8= 'chemins' ( (lv_chemins_9_0= ruleChemin ) )* otherlv_10= '}' ) ;
    public final EObject ruleTerritoire() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_lieuDepart_3_0 = null;

        EObject lv_lieux_5_0 = null;

        EObject lv_lieuxFin_7_0 = null;

        EObject lv_chemins_9_0 = null;



        	enterRule();

        try {
            // InternalGAME.g:781:2: ( (otherlv_0= 'territoire' otherlv_1= '{' otherlv_2= 'depart' ( (lv_lieuDepart_3_0= ruleLieu ) ) otherlv_4= 'inter' ( (lv_lieux_5_0= ruleLieu ) )* otherlv_6= 'fins' ( (lv_lieuxFin_7_0= ruleLieu ) )* otherlv_8= 'chemins' ( (lv_chemins_9_0= ruleChemin ) )* otherlv_10= '}' ) )
            // InternalGAME.g:782:2: (otherlv_0= 'territoire' otherlv_1= '{' otherlv_2= 'depart' ( (lv_lieuDepart_3_0= ruleLieu ) ) otherlv_4= 'inter' ( (lv_lieux_5_0= ruleLieu ) )* otherlv_6= 'fins' ( (lv_lieuxFin_7_0= ruleLieu ) )* otherlv_8= 'chemins' ( (lv_chemins_9_0= ruleChemin ) )* otherlv_10= '}' )
            {
            // InternalGAME.g:782:2: (otherlv_0= 'territoire' otherlv_1= '{' otherlv_2= 'depart' ( (lv_lieuDepart_3_0= ruleLieu ) ) otherlv_4= 'inter' ( (lv_lieux_5_0= ruleLieu ) )* otherlv_6= 'fins' ( (lv_lieuxFin_7_0= ruleLieu ) )* otherlv_8= 'chemins' ( (lv_chemins_9_0= ruleChemin ) )* otherlv_10= '}' )
            // InternalGAME.g:783:3: otherlv_0= 'territoire' otherlv_1= '{' otherlv_2= 'depart' ( (lv_lieuDepart_3_0= ruleLieu ) ) otherlv_4= 'inter' ( (lv_lieux_5_0= ruleLieu ) )* otherlv_6= 'fins' ( (lv_lieuxFin_7_0= ruleLieu ) )* otherlv_8= 'chemins' ( (lv_chemins_9_0= ruleChemin ) )* otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getTerritoireAccess().getTerritoireKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getTerritoireAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,31,FOLLOW_29); 

            			newLeafNode(otherlv_2, grammarAccess.getTerritoireAccess().getDepartKeyword_2());
            		
            // InternalGAME.g:795:3: ( (lv_lieuDepart_3_0= ruleLieu ) )
            // InternalGAME.g:796:4: (lv_lieuDepart_3_0= ruleLieu )
            {
            // InternalGAME.g:796:4: (lv_lieuDepart_3_0= ruleLieu )
            // InternalGAME.g:797:5: lv_lieuDepart_3_0= ruleLieu
            {

            					newCompositeNode(grammarAccess.getTerritoireAccess().getLieuDepartLieuParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_30);
            lv_lieuDepart_3_0=ruleLieu();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTerritoireRule());
            					}
            					set(
            						current,
            						"lieuDepart",
            						lv_lieuDepart_3_0,
            						"fr.n7.GAME.Lieu");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,32,FOLLOW_31); 

            			newLeafNode(otherlv_4, grammarAccess.getTerritoireAccess().getInterKeyword_4());
            		
            // InternalGAME.g:818:3: ( (lv_lieux_5_0= ruleLieu ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==26) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalGAME.g:819:4: (lv_lieux_5_0= ruleLieu )
            	    {
            	    // InternalGAME.g:819:4: (lv_lieux_5_0= ruleLieu )
            	    // InternalGAME.g:820:5: lv_lieux_5_0= ruleLieu
            	    {

            	    					newCompositeNode(grammarAccess.getTerritoireAccess().getLieuxLieuParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_31);
            	    lv_lieux_5_0=ruleLieu();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTerritoireRule());
            	    					}
            	    					add(
            	    						current,
            	    						"lieux",
            	    						lv_lieux_5_0,
            	    						"fr.n7.GAME.Lieu");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            otherlv_6=(Token)match(input,33,FOLLOW_32); 

            			newLeafNode(otherlv_6, grammarAccess.getTerritoireAccess().getFinsKeyword_6());
            		
            // InternalGAME.g:841:3: ( (lv_lieuxFin_7_0= ruleLieu ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==26) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalGAME.g:842:4: (lv_lieuxFin_7_0= ruleLieu )
            	    {
            	    // InternalGAME.g:842:4: (lv_lieuxFin_7_0= ruleLieu )
            	    // InternalGAME.g:843:5: lv_lieuxFin_7_0= ruleLieu
            	    {

            	    					newCompositeNode(grammarAccess.getTerritoireAccess().getLieuxFinLieuParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_32);
            	    lv_lieuxFin_7_0=ruleLieu();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTerritoireRule());
            	    					}
            	    					add(
            	    						current,
            	    						"lieuxFin",
            	    						lv_lieuxFin_7_0,
            	    						"fr.n7.GAME.Lieu");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            otherlv_8=(Token)match(input,29,FOLLOW_33); 

            			newLeafNode(otherlv_8, grammarAccess.getTerritoireAccess().getCheminsKeyword_8());
            		
            // InternalGAME.g:864:3: ( (lv_chemins_9_0= ruleChemin ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==40) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalGAME.g:865:4: (lv_chemins_9_0= ruleChemin )
            	    {
            	    // InternalGAME.g:865:4: (lv_chemins_9_0= ruleChemin )
            	    // InternalGAME.g:866:5: lv_chemins_9_0= ruleChemin
            	    {

            	    					newCompositeNode(grammarAccess.getTerritoireAccess().getCheminsCheminParserRuleCall_9_0());
            	    				
            	    pushFollow(FOLLOW_33);
            	    lv_chemins_9_0=ruleChemin();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTerritoireRule());
            	    					}
            	    					add(
            	    						current,
            	    						"chemins",
            	    						lv_chemins_9_0,
            	    						"fr.n7.GAME.Chemin");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            otherlv_10=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getTerritoireAccess().getRightCurlyBracketKeyword_10());
            		

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
    // $ANTLR end "ruleTerritoire"


    // $ANTLR start "entryRuleCondition"
    // InternalGAME.g:891:1: entryRuleCondition returns [EObject current=null] : iv_ruleCondition= ruleCondition EOF ;
    public final EObject entryRuleCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondition = null;


        try {
            // InternalGAME.g:891:50: (iv_ruleCondition= ruleCondition EOF )
            // InternalGAME.g:892:2: iv_ruleCondition= ruleCondition EOF
            {
             newCompositeNode(grammarAccess.getConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCondition=ruleCondition();

            state._fsp--;

             current =iv_ruleCondition; 
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
    // $ANTLR end "entryRuleCondition"


    // $ANTLR start "ruleCondition"
    // InternalGAME.g:898:1: ruleCondition returns [EObject current=null] : (otherlv_0= 'condition' ( (lv_val_1_0= ruleEBoolean ) ) otherlv_2= '{' otherlv_3= 'objetsTrue' ( (otherlv_4= RULE_ID ) )* otherlv_5= 'objetsFalse' ( (otherlv_6= RULE_ID ) )* otherlv_7= 'connaissanceTrue' ( (otherlv_8= RULE_ID ) )* otherlv_9= 'connaissanceFalse' ( (otherlv_10= RULE_ID ) )* otherlv_11= 'lieuExplores' ( (otherlv_12= RULE_ID ) )* otherlv_13= '}' ) ;
    public final EObject ruleCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        AntlrDatatypeRuleToken lv_val_1_0 = null;



        	enterRule();

        try {
            // InternalGAME.g:904:2: ( (otherlv_0= 'condition' ( (lv_val_1_0= ruleEBoolean ) ) otherlv_2= '{' otherlv_3= 'objetsTrue' ( (otherlv_4= RULE_ID ) )* otherlv_5= 'objetsFalse' ( (otherlv_6= RULE_ID ) )* otherlv_7= 'connaissanceTrue' ( (otherlv_8= RULE_ID ) )* otherlv_9= 'connaissanceFalse' ( (otherlv_10= RULE_ID ) )* otherlv_11= 'lieuExplores' ( (otherlv_12= RULE_ID ) )* otherlv_13= '}' ) )
            // InternalGAME.g:905:2: (otherlv_0= 'condition' ( (lv_val_1_0= ruleEBoolean ) ) otherlv_2= '{' otherlv_3= 'objetsTrue' ( (otherlv_4= RULE_ID ) )* otherlv_5= 'objetsFalse' ( (otherlv_6= RULE_ID ) )* otherlv_7= 'connaissanceTrue' ( (otherlv_8= RULE_ID ) )* otherlv_9= 'connaissanceFalse' ( (otherlv_10= RULE_ID ) )* otherlv_11= 'lieuExplores' ( (otherlv_12= RULE_ID ) )* otherlv_13= '}' )
            {
            // InternalGAME.g:905:2: (otherlv_0= 'condition' ( (lv_val_1_0= ruleEBoolean ) ) otherlv_2= '{' otherlv_3= 'objetsTrue' ( (otherlv_4= RULE_ID ) )* otherlv_5= 'objetsFalse' ( (otherlv_6= RULE_ID ) )* otherlv_7= 'connaissanceTrue' ( (otherlv_8= RULE_ID ) )* otherlv_9= 'connaissanceFalse' ( (otherlv_10= RULE_ID ) )* otherlv_11= 'lieuExplores' ( (otherlv_12= RULE_ID ) )* otherlv_13= '}' )
            // InternalGAME.g:906:3: otherlv_0= 'condition' ( (lv_val_1_0= ruleEBoolean ) ) otherlv_2= '{' otherlv_3= 'objetsTrue' ( (otherlv_4= RULE_ID ) )* otherlv_5= 'objetsFalse' ( (otherlv_6= RULE_ID ) )* otherlv_7= 'connaissanceTrue' ( (otherlv_8= RULE_ID ) )* otherlv_9= 'connaissanceFalse' ( (otherlv_10= RULE_ID ) )* otherlv_11= 'lieuExplores' ( (otherlv_12= RULE_ID ) )* otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,34,FOLLOW_34); 

            			newLeafNode(otherlv_0, grammarAccess.getConditionAccess().getConditionKeyword_0());
            		
            // InternalGAME.g:910:3: ( (lv_val_1_0= ruleEBoolean ) )
            // InternalGAME.g:911:4: (lv_val_1_0= ruleEBoolean )
            {
            // InternalGAME.g:911:4: (lv_val_1_0= ruleEBoolean )
            // InternalGAME.g:912:5: lv_val_1_0= ruleEBoolean
            {

            					newCompositeNode(grammarAccess.getConditionAccess().getValEBooleanParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_val_1_0=ruleEBoolean();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConditionRule());
            					}
            					set(
            						current,
            						"val",
            						lv_val_1_0,
            						"fr.n7.GAME.EBoolean");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_35); 

            			newLeafNode(otherlv_2, grammarAccess.getConditionAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,35,FOLLOW_36); 

            			newLeafNode(otherlv_3, grammarAccess.getConditionAccess().getObjetsTrueKeyword_3());
            		
            // InternalGAME.g:937:3: ( (otherlv_4= RULE_ID ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_ID) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalGAME.g:938:4: (otherlv_4= RULE_ID )
            	    {
            	    // InternalGAME.g:938:4: (otherlv_4= RULE_ID )
            	    // InternalGAME.g:939:5: otherlv_4= RULE_ID
            	    {

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getConditionRule());
            	    					}
            	    				
            	    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_36); 

            	    					newLeafNode(otherlv_4, grammarAccess.getConditionAccess().getObjetsTrueObjetCrossReference_4_0());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            otherlv_5=(Token)match(input,36,FOLLOW_37); 

            			newLeafNode(otherlv_5, grammarAccess.getConditionAccess().getObjetsFalseKeyword_5());
            		
            // InternalGAME.g:954:3: ( (otherlv_6= RULE_ID ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_ID) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalGAME.g:955:4: (otherlv_6= RULE_ID )
            	    {
            	    // InternalGAME.g:955:4: (otherlv_6= RULE_ID )
            	    // InternalGAME.g:956:5: otherlv_6= RULE_ID
            	    {

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getConditionRule());
            	    					}
            	    				
            	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_37); 

            	    					newLeafNode(otherlv_6, grammarAccess.getConditionAccess().getObjetsFalseObjetCrossReference_6_0());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            otherlv_7=(Token)match(input,37,FOLLOW_38); 

            			newLeafNode(otherlv_7, grammarAccess.getConditionAccess().getConnaissanceTrueKeyword_7());
            		
            // InternalGAME.g:971:3: ( (otherlv_8= RULE_ID ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_ID) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalGAME.g:972:4: (otherlv_8= RULE_ID )
            	    {
            	    // InternalGAME.g:972:4: (otherlv_8= RULE_ID )
            	    // InternalGAME.g:973:5: otherlv_8= RULE_ID
            	    {

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getConditionRule());
            	    					}
            	    				
            	    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_38); 

            	    					newLeafNode(otherlv_8, grammarAccess.getConditionAccess().getConnaissanceTrueConnaissanceCrossReference_8_0());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            otherlv_9=(Token)match(input,38,FOLLOW_39); 

            			newLeafNode(otherlv_9, grammarAccess.getConditionAccess().getConnaissanceFalseKeyword_9());
            		
            // InternalGAME.g:988:3: ( (otherlv_10= RULE_ID ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_ID) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalGAME.g:989:4: (otherlv_10= RULE_ID )
            	    {
            	    // InternalGAME.g:989:4: (otherlv_10= RULE_ID )
            	    // InternalGAME.g:990:5: otherlv_10= RULE_ID
            	    {

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getConditionRule());
            	    					}
            	    				
            	    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_39); 

            	    					newLeafNode(otherlv_10, grammarAccess.getConditionAccess().getConnaissanceFalseConnaissanceCrossReference_10_0());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            otherlv_11=(Token)match(input,39,FOLLOW_40); 

            			newLeafNode(otherlv_11, grammarAccess.getConditionAccess().getLieuExploresKeyword_11());
            		
            // InternalGAME.g:1005:3: ( (otherlv_12= RULE_ID ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_ID) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalGAME.g:1006:4: (otherlv_12= RULE_ID )
            	    {
            	    // InternalGAME.g:1006:4: (otherlv_12= RULE_ID )
            	    // InternalGAME.g:1007:5: otherlv_12= RULE_ID
            	    {

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getConditionRule());
            	    					}
            	    				
            	    otherlv_12=(Token)match(input,RULE_ID,FOLLOW_40); 

            	    					newLeafNode(otherlv_12, grammarAccess.getConditionAccess().getLieuxExploresLieuCrossReference_12_0());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            otherlv_13=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getConditionAccess().getRightCurlyBracketKeyword_13());
            		

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
    // $ANTLR end "ruleCondition"


    // $ANTLR start "entryRuleChemin"
    // InternalGAME.g:1026:1: entryRuleChemin returns [EObject current=null] : iv_ruleChemin= ruleChemin EOF ;
    public final EObject entryRuleChemin() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChemin = null;


        try {
            // InternalGAME.g:1026:47: (iv_ruleChemin= ruleChemin EOF )
            // InternalGAME.g:1027:2: iv_ruleChemin= ruleChemin EOF
            {
             newCompositeNode(grammarAccess.getCheminRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleChemin=ruleChemin();

            state._fsp--;

             current =iv_ruleChemin; 
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
    // $ANTLR end "entryRuleChemin"


    // $ANTLR start "ruleChemin"
    // InternalGAME.g:1033:1: ruleChemin returns [EObject current=null] : (otherlv_0= 'etatChemin' ( (lv_etat_1_0= ruleEtatChemin ) ) otherlv_2= 'de' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'a' ( (otherlv_5= RULE_ID ) ) otherlv_6= '{' otherlv_7= 'visible' ( (lv_conditionsVisible_8_0= ruleCondition ) ) otherlv_9= 'ouverture' ( (lv_conditionsOuverture_10_0= ruleCondition ) ) otherlv_11= 'obligation' ( (lv_conditionsObligation_12_0= ruleCondition ) ) otherlv_13= 'objetsTransmis' ( (lv_objetsTransmis_14_0= ruleObjet ) )* otherlv_15= 'prixObjets' ( (lv_prixObjets_16_0= ruleObjet ) )* ( (lv_qualification_17_0= ruleQualification ) )* otherlv_18= '}' ) ;
    public final EObject ruleChemin() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_18=null;
        Enumerator lv_etat_1_0 = null;

        EObject lv_conditionsVisible_8_0 = null;

        EObject lv_conditionsOuverture_10_0 = null;

        EObject lv_conditionsObligation_12_0 = null;

        EObject lv_objetsTransmis_14_0 = null;

        EObject lv_prixObjets_16_0 = null;

        EObject lv_qualification_17_0 = null;



        	enterRule();

        try {
            // InternalGAME.g:1039:2: ( (otherlv_0= 'etatChemin' ( (lv_etat_1_0= ruleEtatChemin ) ) otherlv_2= 'de' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'a' ( (otherlv_5= RULE_ID ) ) otherlv_6= '{' otherlv_7= 'visible' ( (lv_conditionsVisible_8_0= ruleCondition ) ) otherlv_9= 'ouverture' ( (lv_conditionsOuverture_10_0= ruleCondition ) ) otherlv_11= 'obligation' ( (lv_conditionsObligation_12_0= ruleCondition ) ) otherlv_13= 'objetsTransmis' ( (lv_objetsTransmis_14_0= ruleObjet ) )* otherlv_15= 'prixObjets' ( (lv_prixObjets_16_0= ruleObjet ) )* ( (lv_qualification_17_0= ruleQualification ) )* otherlv_18= '}' ) )
            // InternalGAME.g:1040:2: (otherlv_0= 'etatChemin' ( (lv_etat_1_0= ruleEtatChemin ) ) otherlv_2= 'de' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'a' ( (otherlv_5= RULE_ID ) ) otherlv_6= '{' otherlv_7= 'visible' ( (lv_conditionsVisible_8_0= ruleCondition ) ) otherlv_9= 'ouverture' ( (lv_conditionsOuverture_10_0= ruleCondition ) ) otherlv_11= 'obligation' ( (lv_conditionsObligation_12_0= ruleCondition ) ) otherlv_13= 'objetsTransmis' ( (lv_objetsTransmis_14_0= ruleObjet ) )* otherlv_15= 'prixObjets' ( (lv_prixObjets_16_0= ruleObjet ) )* ( (lv_qualification_17_0= ruleQualification ) )* otherlv_18= '}' )
            {
            // InternalGAME.g:1040:2: (otherlv_0= 'etatChemin' ( (lv_etat_1_0= ruleEtatChemin ) ) otherlv_2= 'de' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'a' ( (otherlv_5= RULE_ID ) ) otherlv_6= '{' otherlv_7= 'visible' ( (lv_conditionsVisible_8_0= ruleCondition ) ) otherlv_9= 'ouverture' ( (lv_conditionsOuverture_10_0= ruleCondition ) ) otherlv_11= 'obligation' ( (lv_conditionsObligation_12_0= ruleCondition ) ) otherlv_13= 'objetsTransmis' ( (lv_objetsTransmis_14_0= ruleObjet ) )* otherlv_15= 'prixObjets' ( (lv_prixObjets_16_0= ruleObjet ) )* ( (lv_qualification_17_0= ruleQualification ) )* otherlv_18= '}' )
            // InternalGAME.g:1041:3: otherlv_0= 'etatChemin' ( (lv_etat_1_0= ruleEtatChemin ) ) otherlv_2= 'de' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'a' ( (otherlv_5= RULE_ID ) ) otherlv_6= '{' otherlv_7= 'visible' ( (lv_conditionsVisible_8_0= ruleCondition ) ) otherlv_9= 'ouverture' ( (lv_conditionsOuverture_10_0= ruleCondition ) ) otherlv_11= 'obligation' ( (lv_conditionsObligation_12_0= ruleCondition ) ) otherlv_13= 'objetsTransmis' ( (lv_objetsTransmis_14_0= ruleObjet ) )* otherlv_15= 'prixObjets' ( (lv_prixObjets_16_0= ruleObjet ) )* ( (lv_qualification_17_0= ruleQualification ) )* otherlv_18= '}'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_41); 

            			newLeafNode(otherlv_0, grammarAccess.getCheminAccess().getEtatCheminKeyword_0());
            		
            // InternalGAME.g:1045:3: ( (lv_etat_1_0= ruleEtatChemin ) )
            // InternalGAME.g:1046:4: (lv_etat_1_0= ruleEtatChemin )
            {
            // InternalGAME.g:1046:4: (lv_etat_1_0= ruleEtatChemin )
            // InternalGAME.g:1047:5: lv_etat_1_0= ruleEtatChemin
            {

            					newCompositeNode(grammarAccess.getCheminAccess().getEtatEtatCheminEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_42);
            lv_etat_1_0=ruleEtatChemin();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCheminRule());
            					}
            					set(
            						current,
            						"etat",
            						lv_etat_1_0,
            						"fr.n7.GAME.EtatChemin");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,41,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getCheminAccess().getDeKeyword_2());
            		
            // InternalGAME.g:1068:3: ( (otherlv_3= RULE_ID ) )
            // InternalGAME.g:1069:4: (otherlv_3= RULE_ID )
            {
            // InternalGAME.g:1069:4: (otherlv_3= RULE_ID )
            // InternalGAME.g:1070:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCheminRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_43); 

            					newLeafNode(otherlv_3, grammarAccess.getCheminAccess().getPredecessorLieuCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,42,FOLLOW_3); 

            			newLeafNode(otherlv_4, grammarAccess.getCheminAccess().getAKeyword_4());
            		
            // InternalGAME.g:1085:3: ( (otherlv_5= RULE_ID ) )
            // InternalGAME.g:1086:4: (otherlv_5= RULE_ID )
            {
            // InternalGAME.g:1086:4: (otherlv_5= RULE_ID )
            // InternalGAME.g:1087:5: otherlv_5= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCheminRule());
            					}
            				
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(otherlv_5, grammarAccess.getCheminAccess().getSuccessorLieuCrossReference_5_0());
            				

            }


            }

            otherlv_6=(Token)match(input,12,FOLLOW_44); 

            			newLeafNode(otherlv_6, grammarAccess.getCheminAccess().getLeftCurlyBracketKeyword_6());
            		
            otherlv_7=(Token)match(input,43,FOLLOW_19); 

            			newLeafNode(otherlv_7, grammarAccess.getCheminAccess().getVisibleKeyword_7());
            		
            // InternalGAME.g:1106:3: ( (lv_conditionsVisible_8_0= ruleCondition ) )
            // InternalGAME.g:1107:4: (lv_conditionsVisible_8_0= ruleCondition )
            {
            // InternalGAME.g:1107:4: (lv_conditionsVisible_8_0= ruleCondition )
            // InternalGAME.g:1108:5: lv_conditionsVisible_8_0= ruleCondition
            {

            					newCompositeNode(grammarAccess.getCheminAccess().getConditionsVisibleConditionParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_45);
            lv_conditionsVisible_8_0=ruleCondition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCheminRule());
            					}
            					set(
            						current,
            						"conditionsVisible",
            						lv_conditionsVisible_8_0,
            						"fr.n7.GAME.Condition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,44,FOLLOW_19); 

            			newLeafNode(otherlv_9, grammarAccess.getCheminAccess().getOuvertureKeyword_9());
            		
            // InternalGAME.g:1129:3: ( (lv_conditionsOuverture_10_0= ruleCondition ) )
            // InternalGAME.g:1130:4: (lv_conditionsOuverture_10_0= ruleCondition )
            {
            // InternalGAME.g:1130:4: (lv_conditionsOuverture_10_0= ruleCondition )
            // InternalGAME.g:1131:5: lv_conditionsOuverture_10_0= ruleCondition
            {

            					newCompositeNode(grammarAccess.getCheminAccess().getConditionsOuvertureConditionParserRuleCall_10_0());
            				
            pushFollow(FOLLOW_46);
            lv_conditionsOuverture_10_0=ruleCondition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCheminRule());
            					}
            					set(
            						current,
            						"conditionsOuverture",
            						lv_conditionsOuverture_10_0,
            						"fr.n7.GAME.Condition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_11=(Token)match(input,45,FOLLOW_19); 

            			newLeafNode(otherlv_11, grammarAccess.getCheminAccess().getObligationKeyword_11());
            		
            // InternalGAME.g:1152:3: ( (lv_conditionsObligation_12_0= ruleCondition ) )
            // InternalGAME.g:1153:4: (lv_conditionsObligation_12_0= ruleCondition )
            {
            // InternalGAME.g:1153:4: (lv_conditionsObligation_12_0= ruleCondition )
            // InternalGAME.g:1154:5: lv_conditionsObligation_12_0= ruleCondition
            {

            					newCompositeNode(grammarAccess.getCheminAccess().getConditionsObligationConditionParserRuleCall_12_0());
            				
            pushFollow(FOLLOW_47);
            lv_conditionsObligation_12_0=ruleCondition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCheminRule());
            					}
            					set(
            						current,
            						"conditionsObligation",
            						lv_conditionsObligation_12_0,
            						"fr.n7.GAME.Condition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_13=(Token)match(input,46,FOLLOW_48); 

            			newLeafNode(otherlv_13, grammarAccess.getCheminAccess().getObjetsTransmisKeyword_13());
            		
            // InternalGAME.g:1175:3: ( (lv_objetsTransmis_14_0= ruleObjet ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==20) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalGAME.g:1176:4: (lv_objetsTransmis_14_0= ruleObjet )
            	    {
            	    // InternalGAME.g:1176:4: (lv_objetsTransmis_14_0= ruleObjet )
            	    // InternalGAME.g:1177:5: lv_objetsTransmis_14_0= ruleObjet
            	    {

            	    					newCompositeNode(grammarAccess.getCheminAccess().getObjetsTransmisObjetParserRuleCall_14_0());
            	    				
            	    pushFollow(FOLLOW_48);
            	    lv_objetsTransmis_14_0=ruleObjet();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getCheminRule());
            	    					}
            	    					add(
            	    						current,
            	    						"objetsTransmis",
            	    						lv_objetsTransmis_14_0,
            	    						"fr.n7.GAME.Objet");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            otherlv_15=(Token)match(input,47,FOLLOW_49); 

            			newLeafNode(otherlv_15, grammarAccess.getCheminAccess().getPrixObjetsKeyword_15());
            		
            // InternalGAME.g:1198:3: ( (lv_prixObjets_16_0= ruleObjet ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==20) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalGAME.g:1199:4: (lv_prixObjets_16_0= ruleObjet )
            	    {
            	    // InternalGAME.g:1199:4: (lv_prixObjets_16_0= ruleObjet )
            	    // InternalGAME.g:1200:5: lv_prixObjets_16_0= ruleObjet
            	    {

            	    					newCompositeNode(grammarAccess.getCheminAccess().getPrixObjetsObjetParserRuleCall_16_0());
            	    				
            	    pushFollow(FOLLOW_49);
            	    lv_prixObjets_16_0=ruleObjet();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getCheminRule());
            	    					}
            	    					add(
            	    						current,
            	    						"prixObjets",
            	    						lv_prixObjets_16_0,
            	    						"fr.n7.GAME.Objet");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            // InternalGAME.g:1217:3: ( (lv_qualification_17_0= ruleQualification ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==62) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalGAME.g:1218:4: (lv_qualification_17_0= ruleQualification )
            	    {
            	    // InternalGAME.g:1218:4: (lv_qualification_17_0= ruleQualification )
            	    // InternalGAME.g:1219:5: lv_qualification_17_0= ruleQualification
            	    {

            	    					newCompositeNode(grammarAccess.getCheminAccess().getQualificationQualificationParserRuleCall_17_0());
            	    				
            	    pushFollow(FOLLOW_27);
            	    lv_qualification_17_0=ruleQualification();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getCheminRule());
            	    					}
            	    					add(
            	    						current,
            	    						"qualification",
            	    						lv_qualification_17_0,
            	    						"fr.n7.GAME.Qualification");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            otherlv_18=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_18, grammarAccess.getCheminAccess().getRightCurlyBracketKeyword_18());
            		

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
    // $ANTLR end "ruleChemin"


    // $ANTLR start "entryRulePersonne"
    // InternalGAME.g:1244:1: entryRulePersonne returns [EObject current=null] : iv_rulePersonne= rulePersonne EOF ;
    public final EObject entryRulePersonne() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePersonne = null;


        try {
            // InternalGAME.g:1244:49: (iv_rulePersonne= rulePersonne EOF )
            // InternalGAME.g:1245:2: iv_rulePersonne= rulePersonne EOF
            {
             newCompositeNode(grammarAccess.getPersonneRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePersonne=rulePersonne();

            state._fsp--;

             current =iv_rulePersonne; 
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
    // $ANTLR end "entryRulePersonne"


    // $ANTLR start "rulePersonne"
    // InternalGAME.g:1251:1: rulePersonne returns [EObject current=null] : (otherlv_0= 'personne' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'activite' ( (lv_activite_4_0= ruleEtatActivite ) ) otherlv_5= 'visibilite' ( (lv_conditionsVisible_6_0= ruleCondition ) ) otherlv_7= 'obligation' ( (lv_conditionsObligation_8_0= ruleCondition ) ) otherlv_9= 'interaction' ( (lv_interaction_10_0= ruleInteraction ) ) ( (lv_qualification_11_0= ruleQualification ) )* otherlv_12= '}' ) ;
    public final EObject rulePersonne() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_12=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        Enumerator lv_activite_4_0 = null;

        EObject lv_conditionsVisible_6_0 = null;

        EObject lv_conditionsObligation_8_0 = null;

        EObject lv_interaction_10_0 = null;

        EObject lv_qualification_11_0 = null;



        	enterRule();

        try {
            // InternalGAME.g:1257:2: ( (otherlv_0= 'personne' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'activite' ( (lv_activite_4_0= ruleEtatActivite ) ) otherlv_5= 'visibilite' ( (lv_conditionsVisible_6_0= ruleCondition ) ) otherlv_7= 'obligation' ( (lv_conditionsObligation_8_0= ruleCondition ) ) otherlv_9= 'interaction' ( (lv_interaction_10_0= ruleInteraction ) ) ( (lv_qualification_11_0= ruleQualification ) )* otherlv_12= '}' ) )
            // InternalGAME.g:1258:2: (otherlv_0= 'personne' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'activite' ( (lv_activite_4_0= ruleEtatActivite ) ) otherlv_5= 'visibilite' ( (lv_conditionsVisible_6_0= ruleCondition ) ) otherlv_7= 'obligation' ( (lv_conditionsObligation_8_0= ruleCondition ) ) otherlv_9= 'interaction' ( (lv_interaction_10_0= ruleInteraction ) ) ( (lv_qualification_11_0= ruleQualification ) )* otherlv_12= '}' )
            {
            // InternalGAME.g:1258:2: (otherlv_0= 'personne' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'activite' ( (lv_activite_4_0= ruleEtatActivite ) ) otherlv_5= 'visibilite' ( (lv_conditionsVisible_6_0= ruleCondition ) ) otherlv_7= 'obligation' ( (lv_conditionsObligation_8_0= ruleCondition ) ) otherlv_9= 'interaction' ( (lv_interaction_10_0= ruleInteraction ) ) ( (lv_qualification_11_0= ruleQualification ) )* otherlv_12= '}' )
            // InternalGAME.g:1259:3: otherlv_0= 'personne' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'activite' ( (lv_activite_4_0= ruleEtatActivite ) ) otherlv_5= 'visibilite' ( (lv_conditionsVisible_6_0= ruleCondition ) ) otherlv_7= 'obligation' ( (lv_conditionsObligation_8_0= ruleCondition ) ) otherlv_9= 'interaction' ( (lv_interaction_10_0= ruleInteraction ) ) ( (lv_qualification_11_0= ruleQualification ) )* otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,48,FOLLOW_50); 

            			newLeafNode(otherlv_0, grammarAccess.getPersonneAccess().getPersonneKeyword_0());
            		
            // InternalGAME.g:1263:3: ( (lv_name_1_0= ruleEString ) )
            // InternalGAME.g:1264:4: (lv_name_1_0= ruleEString )
            {
            // InternalGAME.g:1264:4: (lv_name_1_0= ruleEString )
            // InternalGAME.g:1265:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getPersonneAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPersonneRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"fr.n7.GAME.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_51); 

            			newLeafNode(otherlv_2, grammarAccess.getPersonneAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,49,FOLLOW_52); 

            			newLeafNode(otherlv_3, grammarAccess.getPersonneAccess().getActiviteKeyword_3());
            		
            // InternalGAME.g:1290:3: ( (lv_activite_4_0= ruleEtatActivite ) )
            // InternalGAME.g:1291:4: (lv_activite_4_0= ruleEtatActivite )
            {
            // InternalGAME.g:1291:4: (lv_activite_4_0= ruleEtatActivite )
            // InternalGAME.g:1292:5: lv_activite_4_0= ruleEtatActivite
            {

            					newCompositeNode(grammarAccess.getPersonneAccess().getActiviteEtatActiviteEnumRuleCall_4_0());
            				
            pushFollow(FOLLOW_53);
            lv_activite_4_0=ruleEtatActivite();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPersonneRule());
            					}
            					set(
            						current,
            						"activite",
            						lv_activite_4_0,
            						"fr.n7.GAME.EtatActivite");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,50,FOLLOW_19); 

            			newLeafNode(otherlv_5, grammarAccess.getPersonneAccess().getVisibiliteKeyword_5());
            		
            // InternalGAME.g:1313:3: ( (lv_conditionsVisible_6_0= ruleCondition ) )
            // InternalGAME.g:1314:4: (lv_conditionsVisible_6_0= ruleCondition )
            {
            // InternalGAME.g:1314:4: (lv_conditionsVisible_6_0= ruleCondition )
            // InternalGAME.g:1315:5: lv_conditionsVisible_6_0= ruleCondition
            {

            					newCompositeNode(grammarAccess.getPersonneAccess().getConditionsVisibleConditionParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_46);
            lv_conditionsVisible_6_0=ruleCondition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPersonneRule());
            					}
            					set(
            						current,
            						"conditionsVisible",
            						lv_conditionsVisible_6_0,
            						"fr.n7.GAME.Condition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,45,FOLLOW_19); 

            			newLeafNode(otherlv_7, grammarAccess.getPersonneAccess().getObligationKeyword_7());
            		
            // InternalGAME.g:1336:3: ( (lv_conditionsObligation_8_0= ruleCondition ) )
            // InternalGAME.g:1337:4: (lv_conditionsObligation_8_0= ruleCondition )
            {
            // InternalGAME.g:1337:4: (lv_conditionsObligation_8_0= ruleCondition )
            // InternalGAME.g:1338:5: lv_conditionsObligation_8_0= ruleCondition
            {

            					newCompositeNode(grammarAccess.getPersonneAccess().getConditionsObligationConditionParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_54);
            lv_conditionsObligation_8_0=ruleCondition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPersonneRule());
            					}
            					set(
            						current,
            						"conditionsObligation",
            						lv_conditionsObligation_8_0,
            						"fr.n7.GAME.Condition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,51,FOLLOW_54); 

            			newLeafNode(otherlv_9, grammarAccess.getPersonneAccess().getInteractionKeyword_9());
            		
            // InternalGAME.g:1359:3: ( (lv_interaction_10_0= ruleInteraction ) )
            // InternalGAME.g:1360:4: (lv_interaction_10_0= ruleInteraction )
            {
            // InternalGAME.g:1360:4: (lv_interaction_10_0= ruleInteraction )
            // InternalGAME.g:1361:5: lv_interaction_10_0= ruleInteraction
            {

            					newCompositeNode(grammarAccess.getPersonneAccess().getInteractionInteractionParserRuleCall_10_0());
            				
            pushFollow(FOLLOW_27);
            lv_interaction_10_0=ruleInteraction();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPersonneRule());
            					}
            					set(
            						current,
            						"interaction",
            						lv_interaction_10_0,
            						"fr.n7.GAME.Interaction");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGAME.g:1378:3: ( (lv_qualification_11_0= ruleQualification ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==62) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalGAME.g:1379:4: (lv_qualification_11_0= ruleQualification )
            	    {
            	    // InternalGAME.g:1379:4: (lv_qualification_11_0= ruleQualification )
            	    // InternalGAME.g:1380:5: lv_qualification_11_0= ruleQualification
            	    {

            	    					newCompositeNode(grammarAccess.getPersonneAccess().getQualificationQualificationParserRuleCall_11_0());
            	    				
            	    pushFollow(FOLLOW_27);
            	    lv_qualification_11_0=ruleQualification();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getPersonneRule());
            	    					}
            	    					add(
            	    						current,
            	    						"qualification",
            	    						lv_qualification_11_0,
            	    						"fr.n7.GAME.Qualification");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            otherlv_12=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getPersonneAccess().getRightCurlyBracketKeyword_12());
            		

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
    // $ANTLR end "rulePersonne"


    // $ANTLR start "entryRuleInteraction"
    // InternalGAME.g:1405:1: entryRuleInteraction returns [EObject current=null] : iv_ruleInteraction= ruleInteraction EOF ;
    public final EObject entryRuleInteraction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInteraction = null;


        try {
            // InternalGAME.g:1405:52: (iv_ruleInteraction= ruleInteraction EOF )
            // InternalGAME.g:1406:2: iv_ruleInteraction= ruleInteraction EOF
            {
             newCompositeNode(grammarAccess.getInteractionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInteraction=ruleInteraction();

            state._fsp--;

             current =iv_ruleInteraction; 
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
    // $ANTLR end "entryRuleInteraction"


    // $ANTLR start "ruleInteraction"
    // InternalGAME.g:1412:1: ruleInteraction returns [EObject current=null] : (otherlv_0= 'interaction' otherlv_1= '{' otherlv_2= 'choixDebut' ( (lv_choixDebut_3_0= ruleChoix ) ) otherlv_4= 'choixInter' ( (lv_choixInter_5_0= ruleChoix ) )* otherlv_6= 'choixFin' ( (lv_choixFin_7_0= ruleChoix ) ) otherlv_8= 'Fin' ( (lv_condition_9_0= ruleCondition ) ) otherlv_10= '}' ) ;
    public final EObject ruleInteraction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_choixDebut_3_0 = null;

        EObject lv_choixInter_5_0 = null;

        EObject lv_choixFin_7_0 = null;

        EObject lv_condition_9_0 = null;



        	enterRule();

        try {
            // InternalGAME.g:1418:2: ( (otherlv_0= 'interaction' otherlv_1= '{' otherlv_2= 'choixDebut' ( (lv_choixDebut_3_0= ruleChoix ) ) otherlv_4= 'choixInter' ( (lv_choixInter_5_0= ruleChoix ) )* otherlv_6= 'choixFin' ( (lv_choixFin_7_0= ruleChoix ) ) otherlv_8= 'Fin' ( (lv_condition_9_0= ruleCondition ) ) otherlv_10= '}' ) )
            // InternalGAME.g:1419:2: (otherlv_0= 'interaction' otherlv_1= '{' otherlv_2= 'choixDebut' ( (lv_choixDebut_3_0= ruleChoix ) ) otherlv_4= 'choixInter' ( (lv_choixInter_5_0= ruleChoix ) )* otherlv_6= 'choixFin' ( (lv_choixFin_7_0= ruleChoix ) ) otherlv_8= 'Fin' ( (lv_condition_9_0= ruleCondition ) ) otherlv_10= '}' )
            {
            // InternalGAME.g:1419:2: (otherlv_0= 'interaction' otherlv_1= '{' otherlv_2= 'choixDebut' ( (lv_choixDebut_3_0= ruleChoix ) ) otherlv_4= 'choixInter' ( (lv_choixInter_5_0= ruleChoix ) )* otherlv_6= 'choixFin' ( (lv_choixFin_7_0= ruleChoix ) ) otherlv_8= 'Fin' ( (lv_condition_9_0= ruleCondition ) ) otherlv_10= '}' )
            // InternalGAME.g:1420:3: otherlv_0= 'interaction' otherlv_1= '{' otherlv_2= 'choixDebut' ( (lv_choixDebut_3_0= ruleChoix ) ) otherlv_4= 'choixInter' ( (lv_choixInter_5_0= ruleChoix ) )* otherlv_6= 'choixFin' ( (lv_choixFin_7_0= ruleChoix ) ) otherlv_8= 'Fin' ( (lv_condition_9_0= ruleCondition ) ) otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,51,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getInteractionAccess().getInteractionKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_55); 

            			newLeafNode(otherlv_1, grammarAccess.getInteractionAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,52,FOLLOW_56); 

            			newLeafNode(otherlv_2, grammarAccess.getInteractionAccess().getChoixDebutKeyword_2());
            		
            // InternalGAME.g:1432:3: ( (lv_choixDebut_3_0= ruleChoix ) )
            // InternalGAME.g:1433:4: (lv_choixDebut_3_0= ruleChoix )
            {
            // InternalGAME.g:1433:4: (lv_choixDebut_3_0= ruleChoix )
            // InternalGAME.g:1434:5: lv_choixDebut_3_0= ruleChoix
            {

            					newCompositeNode(grammarAccess.getInteractionAccess().getChoixDebutChoixParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_57);
            lv_choixDebut_3_0=ruleChoix();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getInteractionRule());
            					}
            					set(
            						current,
            						"choixDebut",
            						lv_choixDebut_3_0,
            						"fr.n7.GAME.Choix");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,53,FOLLOW_58); 

            			newLeafNode(otherlv_4, grammarAccess.getInteractionAccess().getChoixInterKeyword_4());
            		
            // InternalGAME.g:1455:3: ( (lv_choixInter_5_0= ruleChoix ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==56) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalGAME.g:1456:4: (lv_choixInter_5_0= ruleChoix )
            	    {
            	    // InternalGAME.g:1456:4: (lv_choixInter_5_0= ruleChoix )
            	    // InternalGAME.g:1457:5: lv_choixInter_5_0= ruleChoix
            	    {

            	    					newCompositeNode(grammarAccess.getInteractionAccess().getChoixInterChoixParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_58);
            	    lv_choixInter_5_0=ruleChoix();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getInteractionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"choixInter",
            	    						lv_choixInter_5_0,
            	    						"fr.n7.GAME.Choix");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            otherlv_6=(Token)match(input,54,FOLLOW_56); 

            			newLeafNode(otherlv_6, grammarAccess.getInteractionAccess().getChoixFinKeyword_6());
            		
            // InternalGAME.g:1478:3: ( (lv_choixFin_7_0= ruleChoix ) )
            // InternalGAME.g:1479:4: (lv_choixFin_7_0= ruleChoix )
            {
            // InternalGAME.g:1479:4: (lv_choixFin_7_0= ruleChoix )
            // InternalGAME.g:1480:5: lv_choixFin_7_0= ruleChoix
            {

            					newCompositeNode(grammarAccess.getInteractionAccess().getChoixFinChoixParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_59);
            lv_choixFin_7_0=ruleChoix();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getInteractionRule());
            					}
            					set(
            						current,
            						"choixFin",
            						lv_choixFin_7_0,
            						"fr.n7.GAME.Choix");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,55,FOLLOW_19); 

            			newLeafNode(otherlv_8, grammarAccess.getInteractionAccess().getFinKeyword_8());
            		
            // InternalGAME.g:1501:3: ( (lv_condition_9_0= ruleCondition ) )
            // InternalGAME.g:1502:4: (lv_condition_9_0= ruleCondition )
            {
            // InternalGAME.g:1502:4: (lv_condition_9_0= ruleCondition )
            // InternalGAME.g:1503:5: lv_condition_9_0= ruleCondition
            {

            					newCompositeNode(grammarAccess.getInteractionAccess().getConditionConditionParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_7);
            lv_condition_9_0=ruleCondition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getInteractionRule());
            					}
            					set(
            						current,
            						"condition",
            						lv_condition_9_0,
            						"fr.n7.GAME.Condition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_10=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getInteractionAccess().getRightCurlyBracketKeyword_10());
            		

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
    // $ANTLR end "ruleInteraction"


    // $ANTLR start "entryRuleChoix"
    // InternalGAME.g:1528:1: entryRuleChoix returns [EObject current=null] : iv_ruleChoix= ruleChoix EOF ;
    public final EObject entryRuleChoix() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoix = null;


        try {
            // InternalGAME.g:1528:46: (iv_ruleChoix= ruleChoix EOF )
            // InternalGAME.g:1529:2: iv_ruleChoix= ruleChoix EOF
            {
             newCompositeNode(grammarAccess.getChoixRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleChoix=ruleChoix();

            state._fsp--;

             current =iv_ruleChoix; 
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
    // $ANTLR end "entryRuleChoix"


    // $ANTLR start "ruleChoix"
    // InternalGAME.g:1535:1: ruleChoix returns [EObject current=null] : (otherlv_0= 'choix' otherlv_1= '{' otherlv_2= 'actions' ( (lv_actions_3_0= ruleAction ) )* otherlv_4= '}' ) ;
    public final EObject ruleChoix() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_actions_3_0 = null;



        	enterRule();

        try {
            // InternalGAME.g:1541:2: ( (otherlv_0= 'choix' otherlv_1= '{' otherlv_2= 'actions' ( (lv_actions_3_0= ruleAction ) )* otherlv_4= '}' ) )
            // InternalGAME.g:1542:2: (otherlv_0= 'choix' otherlv_1= '{' otherlv_2= 'actions' ( (lv_actions_3_0= ruleAction ) )* otherlv_4= '}' )
            {
            // InternalGAME.g:1542:2: (otherlv_0= 'choix' otherlv_1= '{' otherlv_2= 'actions' ( (lv_actions_3_0= ruleAction ) )* otherlv_4= '}' )
            // InternalGAME.g:1543:3: otherlv_0= 'choix' otherlv_1= '{' otherlv_2= 'actions' ( (lv_actions_3_0= ruleAction ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,56,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getChoixAccess().getChoixKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_60); 

            			newLeafNode(otherlv_1, grammarAccess.getChoixAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,57,FOLLOW_61); 

            			newLeafNode(otherlv_2, grammarAccess.getChoixAccess().getActionsKeyword_2());
            		
            // InternalGAME.g:1555:3: ( (lv_actions_3_0= ruleAction ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==58) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalGAME.g:1556:4: (lv_actions_3_0= ruleAction )
            	    {
            	    // InternalGAME.g:1556:4: (lv_actions_3_0= ruleAction )
            	    // InternalGAME.g:1557:5: lv_actions_3_0= ruleAction
            	    {

            	    					newCompositeNode(grammarAccess.getChoixAccess().getActionsActionParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_61);
            	    lv_actions_3_0=ruleAction();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getChoixRule());
            	    					}
            	    					add(
            	    						current,
            	    						"actions",
            	    						lv_actions_3_0,
            	    						"fr.n7.GAME.Action");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getChoixAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "ruleChoix"


    // $ANTLR start "entryRuleAction"
    // InternalGAME.g:1582:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // InternalGAME.g:1582:47: (iv_ruleAction= ruleAction EOF )
            // InternalGAME.g:1583:2: iv_ruleAction= ruleAction EOF
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
    // InternalGAME.g:1589:1: ruleAction returns [EObject current=null] : (otherlv_0= 'action' otherlv_1= '{' (otherlv_2= 'objetsConsommes' ( (lv_objetsConsommes_3_0= ruleObjet ) )* )? (otherlv_4= 'objetsProduits' ( (lv_objetsProduits_5_0= ruleObjet ) )* )? (otherlv_6= 'connaissanceProduits' ( (lv_connaissanceProduits_7_0= ruleConnaissance ) )* )? ( (lv_qualification_8_0= ruleQualification ) )* otherlv_9= '}' ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_9=null;
        EObject lv_objetsConsommes_3_0 = null;

        EObject lv_objetsProduits_5_0 = null;

        EObject lv_connaissanceProduits_7_0 = null;

        EObject lv_qualification_8_0 = null;



        	enterRule();

        try {
            // InternalGAME.g:1595:2: ( (otherlv_0= 'action' otherlv_1= '{' (otherlv_2= 'objetsConsommes' ( (lv_objetsConsommes_3_0= ruleObjet ) )* )? (otherlv_4= 'objetsProduits' ( (lv_objetsProduits_5_0= ruleObjet ) )* )? (otherlv_6= 'connaissanceProduits' ( (lv_connaissanceProduits_7_0= ruleConnaissance ) )* )? ( (lv_qualification_8_0= ruleQualification ) )* otherlv_9= '}' ) )
            // InternalGAME.g:1596:2: (otherlv_0= 'action' otherlv_1= '{' (otherlv_2= 'objetsConsommes' ( (lv_objetsConsommes_3_0= ruleObjet ) )* )? (otherlv_4= 'objetsProduits' ( (lv_objetsProduits_5_0= ruleObjet ) )* )? (otherlv_6= 'connaissanceProduits' ( (lv_connaissanceProduits_7_0= ruleConnaissance ) )* )? ( (lv_qualification_8_0= ruleQualification ) )* otherlv_9= '}' )
            {
            // InternalGAME.g:1596:2: (otherlv_0= 'action' otherlv_1= '{' (otherlv_2= 'objetsConsommes' ( (lv_objetsConsommes_3_0= ruleObjet ) )* )? (otherlv_4= 'objetsProduits' ( (lv_objetsProduits_5_0= ruleObjet ) )* )? (otherlv_6= 'connaissanceProduits' ( (lv_connaissanceProduits_7_0= ruleConnaissance ) )* )? ( (lv_qualification_8_0= ruleQualification ) )* otherlv_9= '}' )
            // InternalGAME.g:1597:3: otherlv_0= 'action' otherlv_1= '{' (otherlv_2= 'objetsConsommes' ( (lv_objetsConsommes_3_0= ruleObjet ) )* )? (otherlv_4= 'objetsProduits' ( (lv_objetsProduits_5_0= ruleObjet ) )* )? (otherlv_6= 'connaissanceProduits' ( (lv_connaissanceProduits_7_0= ruleConnaissance ) )* )? ( (lv_qualification_8_0= ruleQualification ) )* otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,58,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getActionAccess().getActionKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_62); 

            			newLeafNode(otherlv_1, grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalGAME.g:1605:3: (otherlv_2= 'objetsConsommes' ( (lv_objetsConsommes_3_0= ruleObjet ) )* )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==59) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalGAME.g:1606:4: otherlv_2= 'objetsConsommes' ( (lv_objetsConsommes_3_0= ruleObjet ) )*
                    {
                    otherlv_2=(Token)match(input,59,FOLLOW_63); 

                    				newLeafNode(otherlv_2, grammarAccess.getActionAccess().getObjetsConsommesKeyword_2_0());
                    			
                    // InternalGAME.g:1610:4: ( (lv_objetsConsommes_3_0= ruleObjet ) )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==20) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // InternalGAME.g:1611:5: (lv_objetsConsommes_3_0= ruleObjet )
                    	    {
                    	    // InternalGAME.g:1611:5: (lv_objetsConsommes_3_0= ruleObjet )
                    	    // InternalGAME.g:1612:6: lv_objetsConsommes_3_0= ruleObjet
                    	    {

                    	    						newCompositeNode(grammarAccess.getActionAccess().getObjetsConsommesObjetParserRuleCall_2_1_0());
                    	    					
                    	    pushFollow(FOLLOW_63);
                    	    lv_objetsConsommes_3_0=ruleObjet();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getActionRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"objetsConsommes",
                    	    							lv_objetsConsommes_3_0,
                    	    							"fr.n7.GAME.Objet");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalGAME.g:1630:3: (otherlv_4= 'objetsProduits' ( (lv_objetsProduits_5_0= ruleObjet ) )* )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==60) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalGAME.g:1631:4: otherlv_4= 'objetsProduits' ( (lv_objetsProduits_5_0= ruleObjet ) )*
                    {
                    otherlv_4=(Token)match(input,60,FOLLOW_64); 

                    				newLeafNode(otherlv_4, grammarAccess.getActionAccess().getObjetsProduitsKeyword_3_0());
                    			
                    // InternalGAME.g:1635:4: ( (lv_objetsProduits_5_0= ruleObjet ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==20) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // InternalGAME.g:1636:5: (lv_objetsProduits_5_0= ruleObjet )
                    	    {
                    	    // InternalGAME.g:1636:5: (lv_objetsProduits_5_0= ruleObjet )
                    	    // InternalGAME.g:1637:6: lv_objetsProduits_5_0= ruleObjet
                    	    {

                    	    						newCompositeNode(grammarAccess.getActionAccess().getObjetsProduitsObjetParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_64);
                    	    lv_objetsProduits_5_0=ruleObjet();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getActionRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"objetsProduits",
                    	    							lv_objetsProduits_5_0,
                    	    							"fr.n7.GAME.Objet");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalGAME.g:1655:3: (otherlv_6= 'connaissanceProduits' ( (lv_connaissanceProduits_7_0= ruleConnaissance ) )* )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==61) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalGAME.g:1656:4: otherlv_6= 'connaissanceProduits' ( (lv_connaissanceProduits_7_0= ruleConnaissance ) )*
                    {
                    otherlv_6=(Token)match(input,61,FOLLOW_65); 

                    				newLeafNode(otherlv_6, grammarAccess.getActionAccess().getConnaissanceProduitsKeyword_4_0());
                    			
                    // InternalGAME.g:1660:4: ( (lv_connaissanceProduits_7_0= ruleConnaissance ) )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==25) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // InternalGAME.g:1661:5: (lv_connaissanceProduits_7_0= ruleConnaissance )
                    	    {
                    	    // InternalGAME.g:1661:5: (lv_connaissanceProduits_7_0= ruleConnaissance )
                    	    // InternalGAME.g:1662:6: lv_connaissanceProduits_7_0= ruleConnaissance
                    	    {

                    	    						newCompositeNode(grammarAccess.getActionAccess().getConnaissanceProduitsConnaissanceParserRuleCall_4_1_0());
                    	    					
                    	    pushFollow(FOLLOW_65);
                    	    lv_connaissanceProduits_7_0=ruleConnaissance();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getActionRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"connaissanceProduits",
                    	    							lv_connaissanceProduits_7_0,
                    	    							"fr.n7.GAME.Connaissance");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalGAME.g:1680:3: ( (lv_qualification_8_0= ruleQualification ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==62) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalGAME.g:1681:4: (lv_qualification_8_0= ruleQualification )
            	    {
            	    // InternalGAME.g:1681:4: (lv_qualification_8_0= ruleQualification )
            	    // InternalGAME.g:1682:5: lv_qualification_8_0= ruleQualification
            	    {

            	    					newCompositeNode(grammarAccess.getActionAccess().getQualificationQualificationParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_27);
            	    lv_qualification_8_0=ruleQualification();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getActionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"qualification",
            	    						lv_qualification_8_0,
            	    						"fr.n7.GAME.Qualification");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            otherlv_9=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getActionAccess().getRightCurlyBracketKeyword_6());
            		

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


    // $ANTLR start "entryRuleQualification"
    // InternalGAME.g:1707:1: entryRuleQualification returns [EObject current=null] : iv_ruleQualification= ruleQualification EOF ;
    public final EObject entryRuleQualification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualification = null;


        try {
            // InternalGAME.g:1707:54: (iv_ruleQualification= ruleQualification EOF )
            // InternalGAME.g:1708:2: iv_ruleQualification= ruleQualification EOF
            {
             newCompositeNode(grammarAccess.getQualificationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualification=ruleQualification();

            state._fsp--;

             current =iv_ruleQualification; 
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
    // $ANTLR end "entryRuleQualification"


    // $ANTLR start "ruleQualification"
    // InternalGAME.g:1714:1: ruleQualification returns [EObject current=null] : (otherlv_0= 'qualif' ( (lv_texte_1_0= ruleEString ) ) otherlv_2= '{' ( (lv_condition_3_0= ruleCondition ) ) otherlv_4= '}' ) ;
    public final EObject ruleQualification() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_texte_1_0 = null;

        EObject lv_condition_3_0 = null;



        	enterRule();

        try {
            // InternalGAME.g:1720:2: ( (otherlv_0= 'qualif' ( (lv_texte_1_0= ruleEString ) ) otherlv_2= '{' ( (lv_condition_3_0= ruleCondition ) ) otherlv_4= '}' ) )
            // InternalGAME.g:1721:2: (otherlv_0= 'qualif' ( (lv_texte_1_0= ruleEString ) ) otherlv_2= '{' ( (lv_condition_3_0= ruleCondition ) ) otherlv_4= '}' )
            {
            // InternalGAME.g:1721:2: (otherlv_0= 'qualif' ( (lv_texte_1_0= ruleEString ) ) otherlv_2= '{' ( (lv_condition_3_0= ruleCondition ) ) otherlv_4= '}' )
            // InternalGAME.g:1722:3: otherlv_0= 'qualif' ( (lv_texte_1_0= ruleEString ) ) otherlv_2= '{' ( (lv_condition_3_0= ruleCondition ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,62,FOLLOW_50); 

            			newLeafNode(otherlv_0, grammarAccess.getQualificationAccess().getQualifKeyword_0());
            		
            // InternalGAME.g:1726:3: ( (lv_texte_1_0= ruleEString ) )
            // InternalGAME.g:1727:4: (lv_texte_1_0= ruleEString )
            {
            // InternalGAME.g:1727:4: (lv_texte_1_0= ruleEString )
            // InternalGAME.g:1728:5: lv_texte_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getQualificationAccess().getTexteEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_texte_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getQualificationRule());
            					}
            					set(
            						current,
            						"texte",
            						lv_texte_1_0,
            						"fr.n7.GAME.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getQualificationAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalGAME.g:1749:3: ( (lv_condition_3_0= ruleCondition ) )
            // InternalGAME.g:1750:4: (lv_condition_3_0= ruleCondition )
            {
            // InternalGAME.g:1750:4: (lv_condition_3_0= ruleCondition )
            // InternalGAME.g:1751:5: lv_condition_3_0= ruleCondition
            {

            					newCompositeNode(grammarAccess.getQualificationAccess().getConditionConditionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_7);
            lv_condition_3_0=ruleCondition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getQualificationRule());
            					}
            					set(
            						current,
            						"condition",
            						lv_condition_3_0,
            						"fr.n7.GAME.Condition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getQualificationAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "ruleQualification"


    // $ANTLR start "entryRuleEInt"
    // InternalGAME.g:1776:1: entryRuleEInt returns [String current=null] : iv_ruleEInt= ruleEInt EOF ;
    public final String entryRuleEInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEInt = null;


        try {
            // InternalGAME.g:1776:44: (iv_ruleEInt= ruleEInt EOF )
            // InternalGAME.g:1777:2: iv_ruleEInt= ruleEInt EOF
            {
             newCompositeNode(grammarAccess.getEIntRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEInt=ruleEInt();

            state._fsp--;

             current =iv_ruleEInt.getText(); 
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
    // $ANTLR end "entryRuleEInt"


    // $ANTLR start "ruleEInt"
    // InternalGAME.g:1783:1: ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;


        	enterRule();

        try {
            // InternalGAME.g:1789:2: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // InternalGAME.g:1790:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // InternalGAME.g:1790:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            // InternalGAME.g:1791:3: (kw= '-' )? this_INT_1= RULE_INT
            {
            // InternalGAME.g:1791:3: (kw= '-' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==63) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalGAME.g:1792:4: kw= '-'
                    {
                    kw=(Token)match(input,63,FOLLOW_66); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEIntAccess().getHyphenMinusKeyword_0());
                    			

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_2); 

            			current.merge(this_INT_1);
            		

            			newLeafNode(this_INT_1, grammarAccess.getEIntAccess().getINTTerminalRuleCall_1());
            		

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
    // $ANTLR end "ruleEInt"


    // $ANTLR start "entryRuleEBoolean"
    // InternalGAME.g:1809:1: entryRuleEBoolean returns [String current=null] : iv_ruleEBoolean= ruleEBoolean EOF ;
    public final String entryRuleEBoolean() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEBoolean = null;


        try {
            // InternalGAME.g:1809:48: (iv_ruleEBoolean= ruleEBoolean EOF )
            // InternalGAME.g:1810:2: iv_ruleEBoolean= ruleEBoolean EOF
            {
             newCompositeNode(grammarAccess.getEBooleanRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEBoolean=ruleEBoolean();

            state._fsp--;

             current =iv_ruleEBoolean.getText(); 
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
    // $ANTLR end "entryRuleEBoolean"


    // $ANTLR start "ruleEBoolean"
    // InternalGAME.g:1816:1: ruleEBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleEBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalGAME.g:1822:2: ( (kw= 'true' | kw= 'false' ) )
            // InternalGAME.g:1823:2: (kw= 'true' | kw= 'false' )
            {
            // InternalGAME.g:1823:2: (kw= 'true' | kw= 'false' )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==64) ) {
                alt36=1;
            }
            else if ( (LA36_0==65) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // InternalGAME.g:1824:3: kw= 'true'
                    {
                    kw=(Token)match(input,64,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEBooleanAccess().getTrueKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalGAME.g:1830:3: kw= 'false'
                    {
                    kw=(Token)match(input,65,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEBooleanAccess().getFalseKeyword_1());
                    		

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
    // $ANTLR end "ruleEBoolean"


    // $ANTLR start "ruleEtatVisibilite"
    // InternalGAME.g:1839:1: ruleEtatVisibilite returns [Enumerator current=null] : ( (enumLiteral_0= 'visible' ) | (enumLiteral_1= 'non visible' ) ) ;
    public final Enumerator ruleEtatVisibilite() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalGAME.g:1845:2: ( ( (enumLiteral_0= 'visible' ) | (enumLiteral_1= 'non visible' ) ) )
            // InternalGAME.g:1846:2: ( (enumLiteral_0= 'visible' ) | (enumLiteral_1= 'non visible' ) )
            {
            // InternalGAME.g:1846:2: ( (enumLiteral_0= 'visible' ) | (enumLiteral_1= 'non visible' ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==43) ) {
                alt37=1;
            }
            else if ( (LA37_0==66) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // InternalGAME.g:1847:3: (enumLiteral_0= 'visible' )
                    {
                    // InternalGAME.g:1847:3: (enumLiteral_0= 'visible' )
                    // InternalGAME.g:1848:4: enumLiteral_0= 'visible'
                    {
                    enumLiteral_0=(Token)match(input,43,FOLLOW_2); 

                    				current = grammarAccess.getEtatVisibiliteAccess().getVisibleEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getEtatVisibiliteAccess().getVisibleEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalGAME.g:1855:3: (enumLiteral_1= 'non visible' )
                    {
                    // InternalGAME.g:1855:3: (enumLiteral_1= 'non visible' )
                    // InternalGAME.g:1856:4: enumLiteral_1= 'non visible'
                    {
                    enumLiteral_1=(Token)match(input,66,FOLLOW_2); 

                    				current = grammarAccess.getEtatVisibiliteAccess().getNonvisibleEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getEtatVisibiliteAccess().getNonvisibleEnumLiteralDeclaration_1());
                    			

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
    // $ANTLR end "ruleEtatVisibilite"


    // $ANTLR start "ruleEtatChemin"
    // InternalGAME.g:1866:1: ruleEtatChemin returns [Enumerator current=null] : ( (enumLiteral_0= 'ouvert' ) | (enumLiteral_1= 'ferme' ) ) ;
    public final Enumerator ruleEtatChemin() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalGAME.g:1872:2: ( ( (enumLiteral_0= 'ouvert' ) | (enumLiteral_1= 'ferme' ) ) )
            // InternalGAME.g:1873:2: ( (enumLiteral_0= 'ouvert' ) | (enumLiteral_1= 'ferme' ) )
            {
            // InternalGAME.g:1873:2: ( (enumLiteral_0= 'ouvert' ) | (enumLiteral_1= 'ferme' ) )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==67) ) {
                alt38=1;
            }
            else if ( (LA38_0==68) ) {
                alt38=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // InternalGAME.g:1874:3: (enumLiteral_0= 'ouvert' )
                    {
                    // InternalGAME.g:1874:3: (enumLiteral_0= 'ouvert' )
                    // InternalGAME.g:1875:4: enumLiteral_0= 'ouvert'
                    {
                    enumLiteral_0=(Token)match(input,67,FOLLOW_2); 

                    				current = grammarAccess.getEtatCheminAccess().getOuvertEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getEtatCheminAccess().getOuvertEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalGAME.g:1882:3: (enumLiteral_1= 'ferme' )
                    {
                    // InternalGAME.g:1882:3: (enumLiteral_1= 'ferme' )
                    // InternalGAME.g:1883:4: enumLiteral_1= 'ferme'
                    {
                    enumLiteral_1=(Token)match(input,68,FOLLOW_2); 

                    				current = grammarAccess.getEtatCheminAccess().getFermeEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getEtatCheminAccess().getFermeEnumLiteralDeclaration_1());
                    			

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
    // $ANTLR end "ruleEtatChemin"


    // $ANTLR start "ruleEtatActivite"
    // InternalGAME.g:1893:1: ruleEtatActivite returns [Enumerator current=null] : ( (enumLiteral_0= 'actif' ) | (enumLiteral_1= 'inactif' ) ) ;
    public final Enumerator ruleEtatActivite() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalGAME.g:1899:2: ( ( (enumLiteral_0= 'actif' ) | (enumLiteral_1= 'inactif' ) ) )
            // InternalGAME.g:1900:2: ( (enumLiteral_0= 'actif' ) | (enumLiteral_1= 'inactif' ) )
            {
            // InternalGAME.g:1900:2: ( (enumLiteral_0= 'actif' ) | (enumLiteral_1= 'inactif' ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==69) ) {
                alt39=1;
            }
            else if ( (LA39_0==70) ) {
                alt39=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // InternalGAME.g:1901:3: (enumLiteral_0= 'actif' )
                    {
                    // InternalGAME.g:1901:3: (enumLiteral_0= 'actif' )
                    // InternalGAME.g:1902:4: enumLiteral_0= 'actif'
                    {
                    enumLiteral_0=(Token)match(input,69,FOLLOW_2); 

                    				current = grammarAccess.getEtatActiviteAccess().getActifEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getEtatActiviteAccess().getActifEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalGAME.g:1909:3: (enumLiteral_1= 'inactif' )
                    {
                    // InternalGAME.g:1909:3: (enumLiteral_1= 'inactif' )
                    // InternalGAME.g:1910:4: enumLiteral_1= 'inactif'
                    {
                    enumLiteral_1=(Token)match(input,70,FOLLOW_2); 

                    				current = grammarAccess.getEtatActiviteAccess().getInactifEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getEtatActiviteAccess().getInactifEnumLiteralDeclaration_1());
                    			

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
    // $ANTLR end "ruleEtatActivite"

    // Delegated rules


    protected DFA6 dfa6 = new DFA6(this);
    static final String dfa_1s = "\26\uffff";
    static final String dfa_2s = "\1\1\25\uffff";
    static final String dfa_3s = "\1\15\1\uffff\1\4\2\14\1\42\1\100\2\14\1\43\12\4\1\15\1\uffff";
    static final String dfa_4s = "\1\76\1\uffff\1\5\2\14\1\42\1\101\2\14\1\43\2\44\2\45\2\46\2\47\3\15\1\uffff";
    static final String dfa_5s = "\1\uffff\1\2\23\uffff\1\1";
    static final String dfa_6s = "\26\uffff}>";
    static final String[] dfa_7s = {
            "\1\1\2\uffff\1\1\3\uffff\1\1\7\uffff\1\1\22\uffff\1\1\14\uffff\2\1\1\2",
            "",
            "\1\4\1\3",
            "\1\5",
            "\1\5",
            "\1\6",
            "\1\7\1\10",
            "\1\11",
            "\1\11",
            "\1\12",
            "\1\13\37\uffff\1\14",
            "\1\13\37\uffff\1\14",
            "\1\15\40\uffff\1\16",
            "\1\15\40\uffff\1\16",
            "\1\17\41\uffff\1\20",
            "\1\17\41\uffff\1\20",
            "\1\21\42\uffff\1\22",
            "\1\21\42\uffff\1\22",
            "\1\23\10\uffff\1\24",
            "\1\23\10\uffff\1\24",
            "\1\25",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 469:3: ( (lv_qualification_10_0= ruleQualification ) )*";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000002020000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x8000000000000040L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x4000000001000002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x4000000001800000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0001000000008000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000010100000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x4000010000002000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x4000000000002000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000204000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000024000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000010000002000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000001000000010L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000002000000010L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000004000000010L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000008000000010L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000800000100000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x4000000000102000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0140000000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0400000000002000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x7800000000002000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x7000000000102000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x6000000000102000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x4000000002002000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000040L});

}
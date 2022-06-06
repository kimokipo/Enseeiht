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
import fr.n7.services.ENIGMEGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalENIGMEParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'jeu'", "'{'", "'}'", "'joueur'", "'limite'", "'objets'", "'connaissances'", "'connaissance'", "'etat'", "'objet'", "'occurrence'", "','", "'de'", "'taille'", "'territoire'", "'depart'", "'milieu'", "'fin'", "'chemins'", "'choix'", "'conditions'", "'interaction'", "'personne'", "'lieu'", "'personnes'", "'chemin'", "'a'", "'action'", "'c'", "'reponse'", "'>>'", "'qualification'", "'avec'", "'condition'", "'obj'", "'con'", "'bonne'", "'mauvaise'", "'possede'", "'npossede'", "'visible'", "'nvisible'", "'obligatoire'", "'nobligatoire'", "'ouvert'", "'ferme'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=6;
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


        public InternalENIGMEParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalENIGMEParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalENIGMEParser.tokenNames; }
    public String getGrammarFileName() { return "InternalENIGME.g"; }



     	private ENIGMEGrammarAccess grammarAccess;

        public InternalENIGMEParser(TokenStream input, ENIGMEGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Jeu";
       	}

       	@Override
       	protected ENIGMEGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleJeu"
    // InternalENIGME.g:65:1: entryRuleJeu returns [EObject current=null] : iv_ruleJeu= ruleJeu EOF ;
    public final EObject entryRuleJeu() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJeu = null;


        try {
            // InternalENIGME.g:65:44: (iv_ruleJeu= ruleJeu EOF )
            // InternalENIGME.g:66:2: iv_ruleJeu= ruleJeu EOF
            {
             newCompositeNode(grammarAccess.getJeuRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJeu=ruleJeu();

            state._fsp--;

             current =iv_ruleJeu; 
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
    // $ANTLR end "entryRuleJeu"


    // $ANTLR start "ruleJeu"
    // InternalENIGME.g:72:1: ruleJeu returns [EObject current=null] : (otherlv_0= 'jeu' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_jeuelement_3_0= ruleJeuElement ) )* otherlv_4= '}' ) ;
    public final EObject ruleJeu() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_jeuelement_3_0 = null;



        	enterRule();

        try {
            // InternalENIGME.g:78:2: ( (otherlv_0= 'jeu' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_jeuelement_3_0= ruleJeuElement ) )* otherlv_4= '}' ) )
            // InternalENIGME.g:79:2: (otherlv_0= 'jeu' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_jeuelement_3_0= ruleJeuElement ) )* otherlv_4= '}' )
            {
            // InternalENIGME.g:79:2: (otherlv_0= 'jeu' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_jeuelement_3_0= ruleJeuElement ) )* otherlv_4= '}' )
            // InternalENIGME.g:80:3: otherlv_0= 'jeu' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_jeuelement_3_0= ruleJeuElement ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getJeuAccess().getJeuKeyword_0());
            		
            // InternalENIGME.g:84:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalENIGME.g:85:4: (lv_name_1_0= RULE_ID )
            {
            // InternalENIGME.g:85:4: (lv_name_1_0= RULE_ID )
            // InternalENIGME.g:86:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getJeuAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJeuRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getJeuAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalENIGME.g:106:3: ( (lv_jeuelement_3_0= ruleJeuElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_INT||LA1_0==14||LA1_0==18||LA1_0==20||LA1_0==25||LA1_0==30||(LA1_0>=32 && LA1_0<=34)||LA1_0==36||LA1_0==38||LA1_0==40||LA1_0==44) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalENIGME.g:107:4: (lv_jeuelement_3_0= ruleJeuElement )
            	    {
            	    // InternalENIGME.g:107:4: (lv_jeuelement_3_0= ruleJeuElement )
            	    // InternalENIGME.g:108:5: lv_jeuelement_3_0= ruleJeuElement
            	    {

            	    					newCompositeNode(grammarAccess.getJeuAccess().getJeuelementJeuElementParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_jeuelement_3_0=ruleJeuElement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getJeuRule());
            	    					}
            	    					add(
            	    						current,
            	    						"jeuelement",
            	    						lv_jeuelement_3_0,
            	    						"fr.n7.ENIGME.JeuElement");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getJeuAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "ruleJeu"


    // $ANTLR start "entryRuleJeuElement"
    // InternalENIGME.g:133:1: entryRuleJeuElement returns [EObject current=null] : iv_ruleJeuElement= ruleJeuElement EOF ;
    public final EObject entryRuleJeuElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJeuElement = null;


        try {
            // InternalENIGME.g:133:51: (iv_ruleJeuElement= ruleJeuElement EOF )
            // InternalENIGME.g:134:2: iv_ruleJeuElement= ruleJeuElement EOF
            {
             newCompositeNode(grammarAccess.getJeuElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJeuElement=ruleJeuElement();

            state._fsp--;

             current =iv_ruleJeuElement; 
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
    // $ANTLR end "entryRuleJeuElement"


    // $ANTLR start "ruleJeuElement"
    // InternalENIGME.g:140:1: ruleJeuElement returns [EObject current=null] : (this_Territoire_0= ruleTerritoire | this_Joueur_1= ruleJoueur | this_Objet_2= ruleObjet | this_Choix_3= ruleChoix | this_Connaissance_4= ruleConnaissance | this_Lieu_5= ruleLieu | this_Reponse_6= ruleReponse | this_Action_7= ruleAction | this_Interaction_8= ruleInteraction | this_Personne_9= rulePersonne | this_Chemin_10= ruleChemin | this_Condition_11= ruleCondition | this_Qualification_12= ruleQualification ) ;
    public final EObject ruleJeuElement() throws RecognitionException {
        EObject current = null;

        EObject this_Territoire_0 = null;

        EObject this_Joueur_1 = null;

        EObject this_Objet_2 = null;

        EObject this_Choix_3 = null;

        EObject this_Connaissance_4 = null;

        EObject this_Lieu_5 = null;

        EObject this_Reponse_6 = null;

        EObject this_Action_7 = null;

        EObject this_Interaction_8 = null;

        EObject this_Personne_9 = null;

        EObject this_Chemin_10 = null;

        EObject this_Condition_11 = null;

        EObject this_Qualification_12 = null;



        	enterRule();

        try {
            // InternalENIGME.g:146:2: ( (this_Territoire_0= ruleTerritoire | this_Joueur_1= ruleJoueur | this_Objet_2= ruleObjet | this_Choix_3= ruleChoix | this_Connaissance_4= ruleConnaissance | this_Lieu_5= ruleLieu | this_Reponse_6= ruleReponse | this_Action_7= ruleAction | this_Interaction_8= ruleInteraction | this_Personne_9= rulePersonne | this_Chemin_10= ruleChemin | this_Condition_11= ruleCondition | this_Qualification_12= ruleQualification ) )
            // InternalENIGME.g:147:2: (this_Territoire_0= ruleTerritoire | this_Joueur_1= ruleJoueur | this_Objet_2= ruleObjet | this_Choix_3= ruleChoix | this_Connaissance_4= ruleConnaissance | this_Lieu_5= ruleLieu | this_Reponse_6= ruleReponse | this_Action_7= ruleAction | this_Interaction_8= ruleInteraction | this_Personne_9= rulePersonne | this_Chemin_10= ruleChemin | this_Condition_11= ruleCondition | this_Qualification_12= ruleQualification )
            {
            // InternalENIGME.g:147:2: (this_Territoire_0= ruleTerritoire | this_Joueur_1= ruleJoueur | this_Objet_2= ruleObjet | this_Choix_3= ruleChoix | this_Connaissance_4= ruleConnaissance | this_Lieu_5= ruleLieu | this_Reponse_6= ruleReponse | this_Action_7= ruleAction | this_Interaction_8= ruleInteraction | this_Personne_9= rulePersonne | this_Chemin_10= ruleChemin | this_Condition_11= ruleCondition | this_Qualification_12= ruleQualification )
            int alt2=13;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt2=1;
                }
                break;
            case 14:
                {
                alt2=2;
                }
                break;
            case 20:
                {
                alt2=3;
                }
                break;
            case 30:
                {
                alt2=4;
                }
                break;
            case 18:
                {
                alt2=5;
                }
                break;
            case 34:
                {
                alt2=6;
                }
                break;
            case 40:
                {
                alt2=7;
                }
                break;
            case 38:
                {
                alt2=8;
                }
                break;
            case 32:
                {
                alt2=9;
                }
                break;
            case 33:
                {
                alt2=10;
                }
                break;
            case 36:
                {
                alt2=11;
                }
                break;
            case 44:
                {
                alt2=12;
                }
                break;
            case RULE_INT:
                {
                alt2=13;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalENIGME.g:148:3: this_Territoire_0= ruleTerritoire
                    {

                    			newCompositeNode(grammarAccess.getJeuElementAccess().getTerritoireParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Territoire_0=ruleTerritoire();

                    state._fsp--;


                    			current = this_Territoire_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalENIGME.g:157:3: this_Joueur_1= ruleJoueur
                    {

                    			newCompositeNode(grammarAccess.getJeuElementAccess().getJoueurParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Joueur_1=ruleJoueur();

                    state._fsp--;


                    			current = this_Joueur_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalENIGME.g:166:3: this_Objet_2= ruleObjet
                    {

                    			newCompositeNode(grammarAccess.getJeuElementAccess().getObjetParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Objet_2=ruleObjet();

                    state._fsp--;


                    			current = this_Objet_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalENIGME.g:175:3: this_Choix_3= ruleChoix
                    {

                    			newCompositeNode(grammarAccess.getJeuElementAccess().getChoixParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Choix_3=ruleChoix();

                    state._fsp--;


                    			current = this_Choix_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalENIGME.g:184:3: this_Connaissance_4= ruleConnaissance
                    {

                    			newCompositeNode(grammarAccess.getJeuElementAccess().getConnaissanceParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_Connaissance_4=ruleConnaissance();

                    state._fsp--;


                    			current = this_Connaissance_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalENIGME.g:193:3: this_Lieu_5= ruleLieu
                    {

                    			newCompositeNode(grammarAccess.getJeuElementAccess().getLieuParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_Lieu_5=ruleLieu();

                    state._fsp--;


                    			current = this_Lieu_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalENIGME.g:202:3: this_Reponse_6= ruleReponse
                    {

                    			newCompositeNode(grammarAccess.getJeuElementAccess().getReponseParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_Reponse_6=ruleReponse();

                    state._fsp--;


                    			current = this_Reponse_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalENIGME.g:211:3: this_Action_7= ruleAction
                    {

                    			newCompositeNode(grammarAccess.getJeuElementAccess().getActionParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_Action_7=ruleAction();

                    state._fsp--;


                    			current = this_Action_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 9 :
                    // InternalENIGME.g:220:3: this_Interaction_8= ruleInteraction
                    {

                    			newCompositeNode(grammarAccess.getJeuElementAccess().getInteractionParserRuleCall_8());
                    		
                    pushFollow(FOLLOW_2);
                    this_Interaction_8=ruleInteraction();

                    state._fsp--;


                    			current = this_Interaction_8;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 10 :
                    // InternalENIGME.g:229:3: this_Personne_9= rulePersonne
                    {

                    			newCompositeNode(grammarAccess.getJeuElementAccess().getPersonneParserRuleCall_9());
                    		
                    pushFollow(FOLLOW_2);
                    this_Personne_9=rulePersonne();

                    state._fsp--;


                    			current = this_Personne_9;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 11 :
                    // InternalENIGME.g:238:3: this_Chemin_10= ruleChemin
                    {

                    			newCompositeNode(grammarAccess.getJeuElementAccess().getCheminParserRuleCall_10());
                    		
                    pushFollow(FOLLOW_2);
                    this_Chemin_10=ruleChemin();

                    state._fsp--;


                    			current = this_Chemin_10;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 12 :
                    // InternalENIGME.g:247:3: this_Condition_11= ruleCondition
                    {

                    			newCompositeNode(grammarAccess.getJeuElementAccess().getConditionParserRuleCall_11());
                    		
                    pushFollow(FOLLOW_2);
                    this_Condition_11=ruleCondition();

                    state._fsp--;


                    			current = this_Condition_11;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 13 :
                    // InternalENIGME.g:256:3: this_Qualification_12= ruleQualification
                    {

                    			newCompositeNode(grammarAccess.getJeuElementAccess().getQualificationParserRuleCall_12());
                    		
                    pushFollow(FOLLOW_2);
                    this_Qualification_12=ruleQualification();

                    state._fsp--;


                    			current = this_Qualification_12;
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
    // $ANTLR end "ruleJeuElement"


    // $ANTLR start "entryRuleJoueur"
    // InternalENIGME.g:268:1: entryRuleJoueur returns [EObject current=null] : iv_ruleJoueur= ruleJoueur EOF ;
    public final EObject entryRuleJoueur() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJoueur = null;


        try {
            // InternalENIGME.g:268:47: (iv_ruleJoueur= ruleJoueur EOF )
            // InternalENIGME.g:269:2: iv_ruleJoueur= ruleJoueur EOF
            {
             newCompositeNode(grammarAccess.getJoueurRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJoueur=ruleJoueur();

            state._fsp--;

             current =iv_ruleJoueur; 
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
    // $ANTLR end "entryRuleJoueur"


    // $ANTLR start "ruleJoueur"
    // InternalENIGME.g:275:1: ruleJoueur returns [EObject current=null] : (otherlv_0= 'joueur' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'limite' ( (lv_limite_4_0= RULE_INT ) ) otherlv_5= 'objets' otherlv_6= '{' ( (otherlv_7= RULE_ID ) )* otherlv_8= '}' otherlv_9= 'connaissances' otherlv_10= '{' ( (otherlv_11= RULE_ID ) )* otherlv_12= '}' otherlv_13= '}' ) ;
    public final EObject ruleJoueur() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_limite_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;


        	enterRule();

        try {
            // InternalENIGME.g:281:2: ( (otherlv_0= 'joueur' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'limite' ( (lv_limite_4_0= RULE_INT ) ) otherlv_5= 'objets' otherlv_6= '{' ( (otherlv_7= RULE_ID ) )* otherlv_8= '}' otherlv_9= 'connaissances' otherlv_10= '{' ( (otherlv_11= RULE_ID ) )* otherlv_12= '}' otherlv_13= '}' ) )
            // InternalENIGME.g:282:2: (otherlv_0= 'joueur' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'limite' ( (lv_limite_4_0= RULE_INT ) ) otherlv_5= 'objets' otherlv_6= '{' ( (otherlv_7= RULE_ID ) )* otherlv_8= '}' otherlv_9= 'connaissances' otherlv_10= '{' ( (otherlv_11= RULE_ID ) )* otherlv_12= '}' otherlv_13= '}' )
            {
            // InternalENIGME.g:282:2: (otherlv_0= 'joueur' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'limite' ( (lv_limite_4_0= RULE_INT ) ) otherlv_5= 'objets' otherlv_6= '{' ( (otherlv_7= RULE_ID ) )* otherlv_8= '}' otherlv_9= 'connaissances' otherlv_10= '{' ( (otherlv_11= RULE_ID ) )* otherlv_12= '}' otherlv_13= '}' )
            // InternalENIGME.g:283:3: otherlv_0= 'joueur' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'limite' ( (lv_limite_4_0= RULE_INT ) ) otherlv_5= 'objets' otherlv_6= '{' ( (otherlv_7= RULE_ID ) )* otherlv_8= '}' otherlv_9= 'connaissances' otherlv_10= '{' ( (otherlv_11= RULE_ID ) )* otherlv_12= '}' otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getJoueurAccess().getJoueurKeyword_0());
            		
            // InternalENIGME.g:287:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalENIGME.g:288:4: (lv_name_1_0= RULE_ID )
            {
            // InternalENIGME.g:288:4: (lv_name_1_0= RULE_ID )
            // InternalENIGME.g:289:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getJoueurAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJoueurRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getJoueurAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,15,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getJoueurAccess().getLimiteKeyword_3());
            		
            // InternalENIGME.g:313:3: ( (lv_limite_4_0= RULE_INT ) )
            // InternalENIGME.g:314:4: (lv_limite_4_0= RULE_INT )
            {
            // InternalENIGME.g:314:4: (lv_limite_4_0= RULE_INT )
            // InternalENIGME.g:315:5: lv_limite_4_0= RULE_INT
            {
            lv_limite_4_0=(Token)match(input,RULE_INT,FOLLOW_8); 

            					newLeafNode(lv_limite_4_0, grammarAccess.getJoueurAccess().getLimiteINTTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJoueurRule());
            					}
            					setWithLastConsumed(
            						current,
            						"limite",
            						lv_limite_4_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_5=(Token)match(input,16,FOLLOW_4); 

            			newLeafNode(otherlv_5, grammarAccess.getJoueurAccess().getObjetsKeyword_5());
            		
            otherlv_6=(Token)match(input,12,FOLLOW_9); 

            			newLeafNode(otherlv_6, grammarAccess.getJoueurAccess().getLeftCurlyBracketKeyword_6());
            		
            // InternalENIGME.g:339:3: ( (otherlv_7= RULE_ID ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalENIGME.g:340:4: (otherlv_7= RULE_ID )
            	    {
            	    // InternalENIGME.g:340:4: (otherlv_7= RULE_ID )
            	    // InternalENIGME.g:341:5: otherlv_7= RULE_ID
            	    {

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getJoueurRule());
            	    					}
            	    				
            	    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_9); 

            	    					newLeafNode(otherlv_7, grammarAccess.getJoueurAccess().getObjetsObjetCrossReference_7_0());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_8=(Token)match(input,13,FOLLOW_10); 

            			newLeafNode(otherlv_8, grammarAccess.getJoueurAccess().getRightCurlyBracketKeyword_8());
            		
            otherlv_9=(Token)match(input,17,FOLLOW_4); 

            			newLeafNode(otherlv_9, grammarAccess.getJoueurAccess().getConnaissancesKeyword_9());
            		
            otherlv_10=(Token)match(input,12,FOLLOW_9); 

            			newLeafNode(otherlv_10, grammarAccess.getJoueurAccess().getLeftCurlyBracketKeyword_10());
            		
            // InternalENIGME.g:364:3: ( (otherlv_11= RULE_ID ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalENIGME.g:365:4: (otherlv_11= RULE_ID )
            	    {
            	    // InternalENIGME.g:365:4: (otherlv_11= RULE_ID )
            	    // InternalENIGME.g:366:5: otherlv_11= RULE_ID
            	    {

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getJoueurRule());
            	    					}
            	    				
            	    otherlv_11=(Token)match(input,RULE_ID,FOLLOW_9); 

            	    					newLeafNode(otherlv_11, grammarAccess.getJoueurAccess().getConnaissancesConnaissanceCrossReference_11_0());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_12=(Token)match(input,13,FOLLOW_11); 

            			newLeafNode(otherlv_12, grammarAccess.getJoueurAccess().getRightCurlyBracketKeyword_12());
            		
            otherlv_13=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getJoueurAccess().getRightCurlyBracketKeyword_13());
            		

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
    // $ANTLR end "ruleJoueur"


    // $ANTLR start "entryRuleConnaissance"
    // InternalENIGME.g:389:1: entryRuleConnaissance returns [EObject current=null] : iv_ruleConnaissance= ruleConnaissance EOF ;
    public final EObject entryRuleConnaissance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnaissance = null;


        try {
            // InternalENIGME.g:389:53: (iv_ruleConnaissance= ruleConnaissance EOF )
            // InternalENIGME.g:390:2: iv_ruleConnaissance= ruleConnaissance EOF
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
    // InternalENIGME.g:396:1: ruleConnaissance returns [EObject current=null] : (otherlv_0= 'connaissance' ( (lv_name_1_0= RULE_ID ) ) ( (lv_nomConnaissance_2_0= RULE_STRING ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= 'etat' ( (lv_etatv_5_0= ruleEtatVisibilite ) ) ( (lv_etatp_6_0= ruleEtatPossession ) ) ) ;
    public final EObject ruleConnaissance() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_nomConnaissance_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Enumerator lv_etatv_5_0 = null;

        Enumerator lv_etatp_6_0 = null;



        	enterRule();

        try {
            // InternalENIGME.g:402:2: ( (otherlv_0= 'connaissance' ( (lv_name_1_0= RULE_ID ) ) ( (lv_nomConnaissance_2_0= RULE_STRING ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= 'etat' ( (lv_etatv_5_0= ruleEtatVisibilite ) ) ( (lv_etatp_6_0= ruleEtatPossession ) ) ) )
            // InternalENIGME.g:403:2: (otherlv_0= 'connaissance' ( (lv_name_1_0= RULE_ID ) ) ( (lv_nomConnaissance_2_0= RULE_STRING ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= 'etat' ( (lv_etatv_5_0= ruleEtatVisibilite ) ) ( (lv_etatp_6_0= ruleEtatPossession ) ) )
            {
            // InternalENIGME.g:403:2: (otherlv_0= 'connaissance' ( (lv_name_1_0= RULE_ID ) ) ( (lv_nomConnaissance_2_0= RULE_STRING ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= 'etat' ( (lv_etatv_5_0= ruleEtatVisibilite ) ) ( (lv_etatp_6_0= ruleEtatPossession ) ) )
            // InternalENIGME.g:404:3: otherlv_0= 'connaissance' ( (lv_name_1_0= RULE_ID ) ) ( (lv_nomConnaissance_2_0= RULE_STRING ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= 'etat' ( (lv_etatv_5_0= ruleEtatVisibilite ) ) ( (lv_etatp_6_0= ruleEtatPossession ) )
            {
            otherlv_0=(Token)match(input,18,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getConnaissanceAccess().getConnaissanceKeyword_0());
            		
            // InternalENIGME.g:408:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalENIGME.g:409:4: (lv_name_1_0= RULE_ID )
            {
            // InternalENIGME.g:409:4: (lv_name_1_0= RULE_ID )
            // InternalENIGME.g:410:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_12); 

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

            // InternalENIGME.g:426:3: ( (lv_nomConnaissance_2_0= RULE_STRING ) )
            // InternalENIGME.g:427:4: (lv_nomConnaissance_2_0= RULE_STRING )
            {
            // InternalENIGME.g:427:4: (lv_nomConnaissance_2_0= RULE_STRING )
            // InternalENIGME.g:428:5: lv_nomConnaissance_2_0= RULE_STRING
            {
            lv_nomConnaissance_2_0=(Token)match(input,RULE_STRING,FOLLOW_3); 

            					newLeafNode(lv_nomConnaissance_2_0, grammarAccess.getConnaissanceAccess().getNomConnaissanceSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConnaissanceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"nomConnaissance",
            						lv_nomConnaissance_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalENIGME.g:444:3: ( (otherlv_3= RULE_ID ) )
            // InternalENIGME.g:445:4: (otherlv_3= RULE_ID )
            {
            // InternalENIGME.g:445:4: (otherlv_3= RULE_ID )
            // InternalENIGME.g:446:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConnaissanceRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(otherlv_3, grammarAccess.getConnaissanceAccess().getQualificationQualificationCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,19,FOLLOW_14); 

            			newLeafNode(otherlv_4, grammarAccess.getConnaissanceAccess().getEtatKeyword_4());
            		
            // InternalENIGME.g:461:3: ( (lv_etatv_5_0= ruleEtatVisibilite ) )
            // InternalENIGME.g:462:4: (lv_etatv_5_0= ruleEtatVisibilite )
            {
            // InternalENIGME.g:462:4: (lv_etatv_5_0= ruleEtatVisibilite )
            // InternalENIGME.g:463:5: lv_etatv_5_0= ruleEtatVisibilite
            {

            					newCompositeNode(grammarAccess.getConnaissanceAccess().getEtatvEtatVisibiliteEnumRuleCall_5_0());
            				
            pushFollow(FOLLOW_15);
            lv_etatv_5_0=ruleEtatVisibilite();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConnaissanceRule());
            					}
            					set(
            						current,
            						"etatv",
            						lv_etatv_5_0,
            						"fr.n7.ENIGME.EtatVisibilite");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalENIGME.g:480:3: ( (lv_etatp_6_0= ruleEtatPossession ) )
            // InternalENIGME.g:481:4: (lv_etatp_6_0= ruleEtatPossession )
            {
            // InternalENIGME.g:481:4: (lv_etatp_6_0= ruleEtatPossession )
            // InternalENIGME.g:482:5: lv_etatp_6_0= ruleEtatPossession
            {

            					newCompositeNode(grammarAccess.getConnaissanceAccess().getEtatpEtatPossessionEnumRuleCall_6_0());
            				
            pushFollow(FOLLOW_2);
            lv_etatp_6_0=ruleEtatPossession();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConnaissanceRule());
            					}
            					set(
            						current,
            						"etatp",
            						lv_etatp_6_0,
            						"fr.n7.ENIGME.EtatPossession");
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
    // $ANTLR end "ruleConnaissance"


    // $ANTLR start "entryRuleObjet"
    // InternalENIGME.g:503:1: entryRuleObjet returns [EObject current=null] : iv_ruleObjet= ruleObjet EOF ;
    public final EObject entryRuleObjet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjet = null;


        try {
            // InternalENIGME.g:503:46: (iv_ruleObjet= ruleObjet EOF )
            // InternalENIGME.g:504:2: iv_ruleObjet= ruleObjet EOF
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
    // InternalENIGME.g:510:1: ruleObjet returns [EObject current=null] : (otherlv_0= 'objet' ( (lv_name_1_0= RULE_ID ) ) ( (lv_nomObjet_2_0= RULE_STRING ) ) otherlv_3= 'occurrence' ( (lv_occurrence_4_0= RULE_INT ) ) otherlv_5= ',' otherlv_6= 'de' otherlv_7= 'taille' ( (lv_taille_8_0= RULE_INT ) ) otherlv_9= 'etat' ( (lv_etatv_10_0= ruleEtatVisibilite ) ) ( (lv_etatp_11_0= ruleEtatPossession ) ) ) ;
    public final EObject ruleObjet() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_nomObjet_2_0=null;
        Token otherlv_3=null;
        Token lv_occurrence_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_taille_8_0=null;
        Token otherlv_9=null;
        Enumerator lv_etatv_10_0 = null;

        Enumerator lv_etatp_11_0 = null;



        	enterRule();

        try {
            // InternalENIGME.g:516:2: ( (otherlv_0= 'objet' ( (lv_name_1_0= RULE_ID ) ) ( (lv_nomObjet_2_0= RULE_STRING ) ) otherlv_3= 'occurrence' ( (lv_occurrence_4_0= RULE_INT ) ) otherlv_5= ',' otherlv_6= 'de' otherlv_7= 'taille' ( (lv_taille_8_0= RULE_INT ) ) otherlv_9= 'etat' ( (lv_etatv_10_0= ruleEtatVisibilite ) ) ( (lv_etatp_11_0= ruleEtatPossession ) ) ) )
            // InternalENIGME.g:517:2: (otherlv_0= 'objet' ( (lv_name_1_0= RULE_ID ) ) ( (lv_nomObjet_2_0= RULE_STRING ) ) otherlv_3= 'occurrence' ( (lv_occurrence_4_0= RULE_INT ) ) otherlv_5= ',' otherlv_6= 'de' otherlv_7= 'taille' ( (lv_taille_8_0= RULE_INT ) ) otherlv_9= 'etat' ( (lv_etatv_10_0= ruleEtatVisibilite ) ) ( (lv_etatp_11_0= ruleEtatPossession ) ) )
            {
            // InternalENIGME.g:517:2: (otherlv_0= 'objet' ( (lv_name_1_0= RULE_ID ) ) ( (lv_nomObjet_2_0= RULE_STRING ) ) otherlv_3= 'occurrence' ( (lv_occurrence_4_0= RULE_INT ) ) otherlv_5= ',' otherlv_6= 'de' otherlv_7= 'taille' ( (lv_taille_8_0= RULE_INT ) ) otherlv_9= 'etat' ( (lv_etatv_10_0= ruleEtatVisibilite ) ) ( (lv_etatp_11_0= ruleEtatPossession ) ) )
            // InternalENIGME.g:518:3: otherlv_0= 'objet' ( (lv_name_1_0= RULE_ID ) ) ( (lv_nomObjet_2_0= RULE_STRING ) ) otherlv_3= 'occurrence' ( (lv_occurrence_4_0= RULE_INT ) ) otherlv_5= ',' otherlv_6= 'de' otherlv_7= 'taille' ( (lv_taille_8_0= RULE_INT ) ) otherlv_9= 'etat' ( (lv_etatv_10_0= ruleEtatVisibilite ) ) ( (lv_etatp_11_0= ruleEtatPossession ) )
            {
            otherlv_0=(Token)match(input,20,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getObjetAccess().getObjetKeyword_0());
            		
            // InternalENIGME.g:522:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalENIGME.g:523:4: (lv_name_1_0= RULE_ID )
            {
            // InternalENIGME.g:523:4: (lv_name_1_0= RULE_ID )
            // InternalENIGME.g:524:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_12); 

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

            // InternalENIGME.g:540:3: ( (lv_nomObjet_2_0= RULE_STRING ) )
            // InternalENIGME.g:541:4: (lv_nomObjet_2_0= RULE_STRING )
            {
            // InternalENIGME.g:541:4: (lv_nomObjet_2_0= RULE_STRING )
            // InternalENIGME.g:542:5: lv_nomObjet_2_0= RULE_STRING
            {
            lv_nomObjet_2_0=(Token)match(input,RULE_STRING,FOLLOW_16); 

            					newLeafNode(lv_nomObjet_2_0, grammarAccess.getObjetAccess().getNomObjetSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getObjetRule());
            					}
            					setWithLastConsumed(
            						current,
            						"nomObjet",
            						lv_nomObjet_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_3=(Token)match(input,21,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getObjetAccess().getOccurrenceKeyword_3());
            		
            // InternalENIGME.g:562:3: ( (lv_occurrence_4_0= RULE_INT ) )
            // InternalENIGME.g:563:4: (lv_occurrence_4_0= RULE_INT )
            {
            // InternalENIGME.g:563:4: (lv_occurrence_4_0= RULE_INT )
            // InternalENIGME.g:564:5: lv_occurrence_4_0= RULE_INT
            {
            lv_occurrence_4_0=(Token)match(input,RULE_INT,FOLLOW_17); 

            					newLeafNode(lv_occurrence_4_0, grammarAccess.getObjetAccess().getOccurrenceINTTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getObjetRule());
            					}
            					setWithLastConsumed(
            						current,
            						"occurrence",
            						lv_occurrence_4_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_5=(Token)match(input,22,FOLLOW_18); 

            			newLeafNode(otherlv_5, grammarAccess.getObjetAccess().getCommaKeyword_5());
            		
            otherlv_6=(Token)match(input,23,FOLLOW_19); 

            			newLeafNode(otherlv_6, grammarAccess.getObjetAccess().getDeKeyword_6());
            		
            otherlv_7=(Token)match(input,24,FOLLOW_7); 

            			newLeafNode(otherlv_7, grammarAccess.getObjetAccess().getTailleKeyword_7());
            		
            // InternalENIGME.g:592:3: ( (lv_taille_8_0= RULE_INT ) )
            // InternalENIGME.g:593:4: (lv_taille_8_0= RULE_INT )
            {
            // InternalENIGME.g:593:4: (lv_taille_8_0= RULE_INT )
            // InternalENIGME.g:594:5: lv_taille_8_0= RULE_INT
            {
            lv_taille_8_0=(Token)match(input,RULE_INT,FOLLOW_13); 

            					newLeafNode(lv_taille_8_0, grammarAccess.getObjetAccess().getTailleINTTerminalRuleCall_8_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getObjetRule());
            					}
            					setWithLastConsumed(
            						current,
            						"taille",
            						lv_taille_8_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_9=(Token)match(input,19,FOLLOW_14); 

            			newLeafNode(otherlv_9, grammarAccess.getObjetAccess().getEtatKeyword_9());
            		
            // InternalENIGME.g:614:3: ( (lv_etatv_10_0= ruleEtatVisibilite ) )
            // InternalENIGME.g:615:4: (lv_etatv_10_0= ruleEtatVisibilite )
            {
            // InternalENIGME.g:615:4: (lv_etatv_10_0= ruleEtatVisibilite )
            // InternalENIGME.g:616:5: lv_etatv_10_0= ruleEtatVisibilite
            {

            					newCompositeNode(grammarAccess.getObjetAccess().getEtatvEtatVisibiliteEnumRuleCall_10_0());
            				
            pushFollow(FOLLOW_15);
            lv_etatv_10_0=ruleEtatVisibilite();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObjetRule());
            					}
            					set(
            						current,
            						"etatv",
            						lv_etatv_10_0,
            						"fr.n7.ENIGME.EtatVisibilite");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalENIGME.g:633:3: ( (lv_etatp_11_0= ruleEtatPossession ) )
            // InternalENIGME.g:634:4: (lv_etatp_11_0= ruleEtatPossession )
            {
            // InternalENIGME.g:634:4: (lv_etatp_11_0= ruleEtatPossession )
            // InternalENIGME.g:635:5: lv_etatp_11_0= ruleEtatPossession
            {

            					newCompositeNode(grammarAccess.getObjetAccess().getEtatpEtatPossessionEnumRuleCall_11_0());
            				
            pushFollow(FOLLOW_2);
            lv_etatp_11_0=ruleEtatPossession();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObjetRule());
            					}
            					set(
            						current,
            						"etatp",
            						lv_etatp_11_0,
            						"fr.n7.ENIGME.EtatPossession");
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
    // $ANTLR end "ruleObjet"


    // $ANTLR start "entryRuleTerritoire"
    // InternalENIGME.g:656:1: entryRuleTerritoire returns [EObject current=null] : iv_ruleTerritoire= ruleTerritoire EOF ;
    public final EObject entryRuleTerritoire() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerritoire = null;


        try {
            // InternalENIGME.g:656:51: (iv_ruleTerritoire= ruleTerritoire EOF )
            // InternalENIGME.g:657:2: iv_ruleTerritoire= ruleTerritoire EOF
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
    // InternalENIGME.g:663:1: ruleTerritoire returns [EObject current=null] : (otherlv_0= 'territoire' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'depart' ( (lv_lieuDebut_4_0= ruleLieu ) ) otherlv_5= 'milieu' otherlv_6= '{' ( (lv_lieuxintermediaires_7_0= ruleLieu ) )* otherlv_8= '}' otherlv_9= 'fin' otherlv_10= '{' ( (lv_lieuxFin_11_0= ruleLieu ) )* otherlv_12= '}' otherlv_13= 'chemins' otherlv_14= '{' ( (lv_chemins_15_0= ruleChemin ) )* otherlv_16= '}' otherlv_17= '}' ) ;
    public final EObject ruleTerritoire() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        EObject lv_lieuDebut_4_0 = null;

        EObject lv_lieuxintermediaires_7_0 = null;

        EObject lv_lieuxFin_11_0 = null;

        EObject lv_chemins_15_0 = null;



        	enterRule();

        try {
            // InternalENIGME.g:669:2: ( (otherlv_0= 'territoire' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'depart' ( (lv_lieuDebut_4_0= ruleLieu ) ) otherlv_5= 'milieu' otherlv_6= '{' ( (lv_lieuxintermediaires_7_0= ruleLieu ) )* otherlv_8= '}' otherlv_9= 'fin' otherlv_10= '{' ( (lv_lieuxFin_11_0= ruleLieu ) )* otherlv_12= '}' otherlv_13= 'chemins' otherlv_14= '{' ( (lv_chemins_15_0= ruleChemin ) )* otherlv_16= '}' otherlv_17= '}' ) )
            // InternalENIGME.g:670:2: (otherlv_0= 'territoire' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'depart' ( (lv_lieuDebut_4_0= ruleLieu ) ) otherlv_5= 'milieu' otherlv_6= '{' ( (lv_lieuxintermediaires_7_0= ruleLieu ) )* otherlv_8= '}' otherlv_9= 'fin' otherlv_10= '{' ( (lv_lieuxFin_11_0= ruleLieu ) )* otherlv_12= '}' otherlv_13= 'chemins' otherlv_14= '{' ( (lv_chemins_15_0= ruleChemin ) )* otherlv_16= '}' otherlv_17= '}' )
            {
            // InternalENIGME.g:670:2: (otherlv_0= 'territoire' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'depart' ( (lv_lieuDebut_4_0= ruleLieu ) ) otherlv_5= 'milieu' otherlv_6= '{' ( (lv_lieuxintermediaires_7_0= ruleLieu ) )* otherlv_8= '}' otherlv_9= 'fin' otherlv_10= '{' ( (lv_lieuxFin_11_0= ruleLieu ) )* otherlv_12= '}' otherlv_13= 'chemins' otherlv_14= '{' ( (lv_chemins_15_0= ruleChemin ) )* otherlv_16= '}' otherlv_17= '}' )
            // InternalENIGME.g:671:3: otherlv_0= 'territoire' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'depart' ( (lv_lieuDebut_4_0= ruleLieu ) ) otherlv_5= 'milieu' otherlv_6= '{' ( (lv_lieuxintermediaires_7_0= ruleLieu ) )* otherlv_8= '}' otherlv_9= 'fin' otherlv_10= '{' ( (lv_lieuxFin_11_0= ruleLieu ) )* otherlv_12= '}' otherlv_13= 'chemins' otherlv_14= '{' ( (lv_chemins_15_0= ruleChemin ) )* otherlv_16= '}' otherlv_17= '}'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getTerritoireAccess().getTerritoireKeyword_0());
            		
            // InternalENIGME.g:675:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalENIGME.g:676:4: (lv_name_1_0= RULE_ID )
            {
            // InternalENIGME.g:676:4: (lv_name_1_0= RULE_ID )
            // InternalENIGME.g:677:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getTerritoireAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTerritoireRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_20); 

            			newLeafNode(otherlv_2, grammarAccess.getTerritoireAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,26,FOLLOW_21); 

            			newLeafNode(otherlv_3, grammarAccess.getTerritoireAccess().getDepartKeyword_3());
            		
            // InternalENIGME.g:701:3: ( (lv_lieuDebut_4_0= ruleLieu ) )
            // InternalENIGME.g:702:4: (lv_lieuDebut_4_0= ruleLieu )
            {
            // InternalENIGME.g:702:4: (lv_lieuDebut_4_0= ruleLieu )
            // InternalENIGME.g:703:5: lv_lieuDebut_4_0= ruleLieu
            {

            					newCompositeNode(grammarAccess.getTerritoireAccess().getLieuDebutLieuParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_22);
            lv_lieuDebut_4_0=ruleLieu();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTerritoireRule());
            					}
            					set(
            						current,
            						"lieuDebut",
            						lv_lieuDebut_4_0,
            						"fr.n7.ENIGME.Lieu");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,27,FOLLOW_4); 

            			newLeafNode(otherlv_5, grammarAccess.getTerritoireAccess().getMilieuKeyword_5());
            		
            otherlv_6=(Token)match(input,12,FOLLOW_23); 

            			newLeafNode(otherlv_6, grammarAccess.getTerritoireAccess().getLeftCurlyBracketKeyword_6());
            		
            // InternalENIGME.g:728:3: ( (lv_lieuxintermediaires_7_0= ruleLieu ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==34) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalENIGME.g:729:4: (lv_lieuxintermediaires_7_0= ruleLieu )
            	    {
            	    // InternalENIGME.g:729:4: (lv_lieuxintermediaires_7_0= ruleLieu )
            	    // InternalENIGME.g:730:5: lv_lieuxintermediaires_7_0= ruleLieu
            	    {

            	    					newCompositeNode(grammarAccess.getTerritoireAccess().getLieuxintermediairesLieuParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_23);
            	    lv_lieuxintermediaires_7_0=ruleLieu();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTerritoireRule());
            	    					}
            	    					add(
            	    						current,
            	    						"lieuxintermediaires",
            	    						lv_lieuxintermediaires_7_0,
            	    						"fr.n7.ENIGME.Lieu");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_8=(Token)match(input,13,FOLLOW_24); 

            			newLeafNode(otherlv_8, grammarAccess.getTerritoireAccess().getRightCurlyBracketKeyword_8());
            		
            otherlv_9=(Token)match(input,28,FOLLOW_4); 

            			newLeafNode(otherlv_9, grammarAccess.getTerritoireAccess().getFinKeyword_9());
            		
            otherlv_10=(Token)match(input,12,FOLLOW_23); 

            			newLeafNode(otherlv_10, grammarAccess.getTerritoireAccess().getLeftCurlyBracketKeyword_10());
            		
            // InternalENIGME.g:759:3: ( (lv_lieuxFin_11_0= ruleLieu ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==34) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalENIGME.g:760:4: (lv_lieuxFin_11_0= ruleLieu )
            	    {
            	    // InternalENIGME.g:760:4: (lv_lieuxFin_11_0= ruleLieu )
            	    // InternalENIGME.g:761:5: lv_lieuxFin_11_0= ruleLieu
            	    {

            	    					newCompositeNode(grammarAccess.getTerritoireAccess().getLieuxFinLieuParserRuleCall_11_0());
            	    				
            	    pushFollow(FOLLOW_23);
            	    lv_lieuxFin_11_0=ruleLieu();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTerritoireRule());
            	    					}
            	    					add(
            	    						current,
            	    						"lieuxFin",
            	    						lv_lieuxFin_11_0,
            	    						"fr.n7.ENIGME.Lieu");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_12=(Token)match(input,13,FOLLOW_25); 

            			newLeafNode(otherlv_12, grammarAccess.getTerritoireAccess().getRightCurlyBracketKeyword_12());
            		
            otherlv_13=(Token)match(input,29,FOLLOW_4); 

            			newLeafNode(otherlv_13, grammarAccess.getTerritoireAccess().getCheminsKeyword_13());
            		
            otherlv_14=(Token)match(input,12,FOLLOW_26); 

            			newLeafNode(otherlv_14, grammarAccess.getTerritoireAccess().getLeftCurlyBracketKeyword_14());
            		
            // InternalENIGME.g:790:3: ( (lv_chemins_15_0= ruleChemin ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==36) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalENIGME.g:791:4: (lv_chemins_15_0= ruleChemin )
            	    {
            	    // InternalENIGME.g:791:4: (lv_chemins_15_0= ruleChemin )
            	    // InternalENIGME.g:792:5: lv_chemins_15_0= ruleChemin
            	    {

            	    					newCompositeNode(grammarAccess.getTerritoireAccess().getCheminsCheminParserRuleCall_15_0());
            	    				
            	    pushFollow(FOLLOW_26);
            	    lv_chemins_15_0=ruleChemin();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTerritoireRule());
            	    					}
            	    					add(
            	    						current,
            	    						"chemins",
            	    						lv_chemins_15_0,
            	    						"fr.n7.ENIGME.Chemin");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_16=(Token)match(input,13,FOLLOW_11); 

            			newLeafNode(otherlv_16, grammarAccess.getTerritoireAccess().getRightCurlyBracketKeyword_16());
            		
            otherlv_17=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_17, grammarAccess.getTerritoireAccess().getRightCurlyBracketKeyword_17());
            		

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


    // $ANTLR start "entryRuleChoix"
    // InternalENIGME.g:821:1: entryRuleChoix returns [EObject current=null] : iv_ruleChoix= ruleChoix EOF ;
    public final EObject entryRuleChoix() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoix = null;


        try {
            // InternalENIGME.g:821:46: (iv_ruleChoix= ruleChoix EOF )
            // InternalENIGME.g:822:2: iv_ruleChoix= ruleChoix EOF
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
    // InternalENIGME.g:828:1: ruleChoix returns [EObject current=null] : (otherlv_0= 'choix' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (otherlv_3= RULE_ID ) )* otherlv_4= 'conditions' otherlv_5= '{' ( (otherlv_6= RULE_ID ) )* otherlv_7= '}' otherlv_8= '}' ) ;
    public final EObject ruleChoix() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;


        	enterRule();

        try {
            // InternalENIGME.g:834:2: ( (otherlv_0= 'choix' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (otherlv_3= RULE_ID ) )* otherlv_4= 'conditions' otherlv_5= '{' ( (otherlv_6= RULE_ID ) )* otherlv_7= '}' otherlv_8= '}' ) )
            // InternalENIGME.g:835:2: (otherlv_0= 'choix' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (otherlv_3= RULE_ID ) )* otherlv_4= 'conditions' otherlv_5= '{' ( (otherlv_6= RULE_ID ) )* otherlv_7= '}' otherlv_8= '}' )
            {
            // InternalENIGME.g:835:2: (otherlv_0= 'choix' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (otherlv_3= RULE_ID ) )* otherlv_4= 'conditions' otherlv_5= '{' ( (otherlv_6= RULE_ID ) )* otherlv_7= '}' otherlv_8= '}' )
            // InternalENIGME.g:836:3: otherlv_0= 'choix' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (otherlv_3= RULE_ID ) )* otherlv_4= 'conditions' otherlv_5= '{' ( (otherlv_6= RULE_ID ) )* otherlv_7= '}' otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getChoixAccess().getChoixKeyword_0());
            		
            // InternalENIGME.g:840:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalENIGME.g:841:4: (lv_name_1_0= RULE_ID )
            {
            // InternalENIGME.g:841:4: (lv_name_1_0= RULE_ID )
            // InternalENIGME.g:842:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getChoixAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getChoixRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_27); 

            			newLeafNode(otherlv_2, grammarAccess.getChoixAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalENIGME.g:862:3: ( (otherlv_3= RULE_ID ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalENIGME.g:863:4: (otherlv_3= RULE_ID )
            	    {
            	    // InternalENIGME.g:863:4: (otherlv_3= RULE_ID )
            	    // InternalENIGME.g:864:5: otherlv_3= RULE_ID
            	    {

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getChoixRule());
            	    					}
            	    				
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_27); 

            	    					newLeafNode(otherlv_3, grammarAccess.getChoixAccess().getReponsesReponseCrossReference_3_0());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            otherlv_4=(Token)match(input,31,FOLLOW_4); 

            			newLeafNode(otherlv_4, grammarAccess.getChoixAccess().getConditionsKeyword_4());
            		
            otherlv_5=(Token)match(input,12,FOLLOW_9); 

            			newLeafNode(otherlv_5, grammarAccess.getChoixAccess().getLeftCurlyBracketKeyword_5());
            		
            // InternalENIGME.g:883:3: ( (otherlv_6= RULE_ID ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_ID) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalENIGME.g:884:4: (otherlv_6= RULE_ID )
            	    {
            	    // InternalENIGME.g:884:4: (otherlv_6= RULE_ID )
            	    // InternalENIGME.g:885:5: otherlv_6= RULE_ID
            	    {

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getChoixRule());
            	    					}
            	    				
            	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_9); 

            	    					newLeafNode(otherlv_6, grammarAccess.getChoixAccess().getConditionsConditionCrossReference_6_0());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            otherlv_7=(Token)match(input,13,FOLLOW_11); 

            			newLeafNode(otherlv_7, grammarAccess.getChoixAccess().getRightCurlyBracketKeyword_7());
            		
            otherlv_8=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getChoixAccess().getRightCurlyBracketKeyword_8());
            		

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


    // $ANTLR start "entryRuleInteraction"
    // InternalENIGME.g:908:1: entryRuleInteraction returns [EObject current=null] : iv_ruleInteraction= ruleInteraction EOF ;
    public final EObject entryRuleInteraction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInteraction = null;


        try {
            // InternalENIGME.g:908:52: (iv_ruleInteraction= ruleInteraction EOF )
            // InternalENIGME.g:909:2: iv_ruleInteraction= ruleInteraction EOF
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
    // InternalENIGME.g:915:1: ruleInteraction returns [EObject current=null] : (otherlv_0= 'interaction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= '}' ) ;
    public final EObject ruleInteraction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalENIGME.g:921:2: ( (otherlv_0= 'interaction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= '}' ) )
            // InternalENIGME.g:922:2: (otherlv_0= 'interaction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= '}' )
            {
            // InternalENIGME.g:922:2: (otherlv_0= 'interaction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= '}' )
            // InternalENIGME.g:923:3: otherlv_0= 'interaction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getInteractionAccess().getInteractionKeyword_0());
            		
            // InternalENIGME.g:927:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalENIGME.g:928:4: (lv_name_1_0= RULE_ID )
            {
            // InternalENIGME.g:928:4: (lv_name_1_0= RULE_ID )
            // InternalENIGME.g:929:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getInteractionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInteractionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getInteractionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalENIGME.g:949:3: ( (otherlv_3= RULE_ID ) )
            // InternalENIGME.g:950:4: (otherlv_3= RULE_ID )
            {
            // InternalENIGME.g:950:4: (otherlv_3= RULE_ID )
            // InternalENIGME.g:951:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInteractionRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(otherlv_3, grammarAccess.getInteractionAccess().getChoixChoixCrossReference_3_0());
            				

            }


            }

            // InternalENIGME.g:962:3: ( (otherlv_4= RULE_ID ) )
            // InternalENIGME.g:963:4: (otherlv_4= RULE_ID )
            {
            // InternalENIGME.g:963:4: (otherlv_4= RULE_ID )
            // InternalENIGME.g:964:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInteractionRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_11); 

            					newLeafNode(otherlv_4, grammarAccess.getInteractionAccess().getChoixFinChoixCrossReference_4_0());
            				

            }


            }

            otherlv_5=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getInteractionAccess().getRightCurlyBracketKeyword_5());
            		

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


    // $ANTLR start "entryRulePersonne"
    // InternalENIGME.g:983:1: entryRulePersonne returns [EObject current=null] : iv_rulePersonne= rulePersonne EOF ;
    public final EObject entryRulePersonne() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePersonne = null;


        try {
            // InternalENIGME.g:983:49: (iv_rulePersonne= rulePersonne EOF )
            // InternalENIGME.g:984:2: iv_rulePersonne= rulePersonne EOF
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
    // InternalENIGME.g:990:1: rulePersonne returns [EObject current=null] : (otherlv_0= 'personne' ( (lv_name_1_0= RULE_ID ) ) ( (lv_etato_2_0= ruleEtatObligation ) ) ( (otherlv_3= RULE_ID ) ) ( (lv_etatv_4_0= ruleEtatVisibilite ) ) ( (otherlv_5= RULE_ID ) ) otherlv_6= '{' ( (otherlv_7= RULE_ID ) ) ( (otherlv_8= RULE_ID ) )? otherlv_9= '}' ) ;
    public final EObject rulePersonne() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Enumerator lv_etato_2_0 = null;

        Enumerator lv_etatv_4_0 = null;



        	enterRule();

        try {
            // InternalENIGME.g:996:2: ( (otherlv_0= 'personne' ( (lv_name_1_0= RULE_ID ) ) ( (lv_etato_2_0= ruleEtatObligation ) ) ( (otherlv_3= RULE_ID ) ) ( (lv_etatv_4_0= ruleEtatVisibilite ) ) ( (otherlv_5= RULE_ID ) ) otherlv_6= '{' ( (otherlv_7= RULE_ID ) ) ( (otherlv_8= RULE_ID ) )? otherlv_9= '}' ) )
            // InternalENIGME.g:997:2: (otherlv_0= 'personne' ( (lv_name_1_0= RULE_ID ) ) ( (lv_etato_2_0= ruleEtatObligation ) ) ( (otherlv_3= RULE_ID ) ) ( (lv_etatv_4_0= ruleEtatVisibilite ) ) ( (otherlv_5= RULE_ID ) ) otherlv_6= '{' ( (otherlv_7= RULE_ID ) ) ( (otherlv_8= RULE_ID ) )? otherlv_9= '}' )
            {
            // InternalENIGME.g:997:2: (otherlv_0= 'personne' ( (lv_name_1_0= RULE_ID ) ) ( (lv_etato_2_0= ruleEtatObligation ) ) ( (otherlv_3= RULE_ID ) ) ( (lv_etatv_4_0= ruleEtatVisibilite ) ) ( (otherlv_5= RULE_ID ) ) otherlv_6= '{' ( (otherlv_7= RULE_ID ) ) ( (otherlv_8= RULE_ID ) )? otherlv_9= '}' )
            // InternalENIGME.g:998:3: otherlv_0= 'personne' ( (lv_name_1_0= RULE_ID ) ) ( (lv_etato_2_0= ruleEtatObligation ) ) ( (otherlv_3= RULE_ID ) ) ( (lv_etatv_4_0= ruleEtatVisibilite ) ) ( (otherlv_5= RULE_ID ) ) otherlv_6= '{' ( (otherlv_7= RULE_ID ) ) ( (otherlv_8= RULE_ID ) )? otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getPersonneAccess().getPersonneKeyword_0());
            		
            // InternalENIGME.g:1002:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalENIGME.g:1003:4: (lv_name_1_0= RULE_ID )
            {
            // InternalENIGME.g:1003:4: (lv_name_1_0= RULE_ID )
            // InternalENIGME.g:1004:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_28); 

            					newLeafNode(lv_name_1_0, grammarAccess.getPersonneAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPersonneRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalENIGME.g:1020:3: ( (lv_etato_2_0= ruleEtatObligation ) )
            // InternalENIGME.g:1021:4: (lv_etato_2_0= ruleEtatObligation )
            {
            // InternalENIGME.g:1021:4: (lv_etato_2_0= ruleEtatObligation )
            // InternalENIGME.g:1022:5: lv_etato_2_0= ruleEtatObligation
            {

            					newCompositeNode(grammarAccess.getPersonneAccess().getEtatoEtatObligationEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_3);
            lv_etato_2_0=ruleEtatObligation();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPersonneRule());
            					}
            					set(
            						current,
            						"etato",
            						lv_etato_2_0,
            						"fr.n7.ENIGME.EtatObligation");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalENIGME.g:1039:3: ( (otherlv_3= RULE_ID ) )
            // InternalENIGME.g:1040:4: (otherlv_3= RULE_ID )
            {
            // InternalENIGME.g:1040:4: (otherlv_3= RULE_ID )
            // InternalENIGME.g:1041:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPersonneRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(otherlv_3, grammarAccess.getPersonneAccess().getConditionoConditionCrossReference_3_0());
            				

            }


            }

            // InternalENIGME.g:1052:3: ( (lv_etatv_4_0= ruleEtatVisibilite ) )
            // InternalENIGME.g:1053:4: (lv_etatv_4_0= ruleEtatVisibilite )
            {
            // InternalENIGME.g:1053:4: (lv_etatv_4_0= ruleEtatVisibilite )
            // InternalENIGME.g:1054:5: lv_etatv_4_0= ruleEtatVisibilite
            {

            					newCompositeNode(grammarAccess.getPersonneAccess().getEtatvEtatVisibiliteEnumRuleCall_4_0());
            				
            pushFollow(FOLLOW_3);
            lv_etatv_4_0=ruleEtatVisibilite();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPersonneRule());
            					}
            					set(
            						current,
            						"etatv",
            						lv_etatv_4_0,
            						"fr.n7.ENIGME.EtatVisibilite");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalENIGME.g:1071:3: ( (otherlv_5= RULE_ID ) )
            // InternalENIGME.g:1072:4: (otherlv_5= RULE_ID )
            {
            // InternalENIGME.g:1072:4: (otherlv_5= RULE_ID )
            // InternalENIGME.g:1073:5: otherlv_5= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPersonneRule());
            					}
            				
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(otherlv_5, grammarAccess.getPersonneAccess().getConditionvConditionCrossReference_5_0());
            				

            }


            }

            otherlv_6=(Token)match(input,12,FOLLOW_3); 

            			newLeafNode(otherlv_6, grammarAccess.getPersonneAccess().getLeftCurlyBracketKeyword_6());
            		
            // InternalENIGME.g:1088:3: ( (otherlv_7= RULE_ID ) )
            // InternalENIGME.g:1089:4: (otherlv_7= RULE_ID )
            {
            // InternalENIGME.g:1089:4: (otherlv_7= RULE_ID )
            // InternalENIGME.g:1090:5: otherlv_7= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPersonneRule());
            					}
            				
            otherlv_7=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(otherlv_7, grammarAccess.getPersonneAccess().getTexteQualificationCrossReference_7_0());
            				

            }


            }

            // InternalENIGME.g:1101:3: ( (otherlv_8= RULE_ID ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalENIGME.g:1102:4: (otherlv_8= RULE_ID )
                    {
                    // InternalENIGME.g:1102:4: (otherlv_8= RULE_ID )
                    // InternalENIGME.g:1103:5: otherlv_8= RULE_ID
                    {

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPersonneRule());
                    					}
                    				
                    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_11); 

                    					newLeafNode(otherlv_8, grammarAccess.getPersonneAccess().getInteractionInteractionCrossReference_8_0());
                    				

                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getPersonneAccess().getRightCurlyBracketKeyword_9());
            		

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


    // $ANTLR start "entryRuleLieu"
    // InternalENIGME.g:1122:1: entryRuleLieu returns [EObject current=null] : iv_ruleLieu= ruleLieu EOF ;
    public final EObject entryRuleLieu() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLieu = null;


        try {
            // InternalENIGME.g:1122:45: (iv_ruleLieu= ruleLieu EOF )
            // InternalENIGME.g:1123:2: iv_ruleLieu= ruleLieu EOF
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
    // InternalENIGME.g:1129:1: ruleLieu returns [EObject current=null] : (otherlv_0= 'lieu' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'personnes' otherlv_4= '{' ( (lv_personnes_5_0= rulePersonne ) )* otherlv_6= '}' )? otherlv_7= '}' ) ;
    public final EObject ruleLieu() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_personnes_5_0 = null;



        	enterRule();

        try {
            // InternalENIGME.g:1135:2: ( (otherlv_0= 'lieu' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'personnes' otherlv_4= '{' ( (lv_personnes_5_0= rulePersonne ) )* otherlv_6= '}' )? otherlv_7= '}' ) )
            // InternalENIGME.g:1136:2: (otherlv_0= 'lieu' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'personnes' otherlv_4= '{' ( (lv_personnes_5_0= rulePersonne ) )* otherlv_6= '}' )? otherlv_7= '}' )
            {
            // InternalENIGME.g:1136:2: (otherlv_0= 'lieu' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'personnes' otherlv_4= '{' ( (lv_personnes_5_0= rulePersonne ) )* otherlv_6= '}' )? otherlv_7= '}' )
            // InternalENIGME.g:1137:3: otherlv_0= 'lieu' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'personnes' otherlv_4= '{' ( (lv_personnes_5_0= rulePersonne ) )* otherlv_6= '}' )? otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,34,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getLieuAccess().getLieuKeyword_0());
            		
            // InternalENIGME.g:1141:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalENIGME.g:1142:4: (lv_name_1_0= RULE_ID )
            {
            // InternalENIGME.g:1142:4: (lv_name_1_0= RULE_ID )
            // InternalENIGME.g:1143:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,12,FOLLOW_29); 

            			newLeafNode(otherlv_2, grammarAccess.getLieuAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalENIGME.g:1163:3: (otherlv_3= 'personnes' otherlv_4= '{' ( (lv_personnes_5_0= rulePersonne ) )* otherlv_6= '}' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==35) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalENIGME.g:1164:4: otherlv_3= 'personnes' otherlv_4= '{' ( (lv_personnes_5_0= rulePersonne ) )* otherlv_6= '}'
                    {
                    otherlv_3=(Token)match(input,35,FOLLOW_4); 

                    				newLeafNode(otherlv_3, grammarAccess.getLieuAccess().getPersonnesKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,12,FOLLOW_30); 

                    				newLeafNode(otherlv_4, grammarAccess.getLieuAccess().getLeftCurlyBracketKeyword_3_1());
                    			
                    // InternalENIGME.g:1172:4: ( (lv_personnes_5_0= rulePersonne ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==33) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalENIGME.g:1173:5: (lv_personnes_5_0= rulePersonne )
                    	    {
                    	    // InternalENIGME.g:1173:5: (lv_personnes_5_0= rulePersonne )
                    	    // InternalENIGME.g:1174:6: lv_personnes_5_0= rulePersonne
                    	    {

                    	    						newCompositeNode(grammarAccess.getLieuAccess().getPersonnesPersonneParserRuleCall_3_2_0());
                    	    					
                    	    pushFollow(FOLLOW_30);
                    	    lv_personnes_5_0=rulePersonne();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getLieuRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"personnes",
                    	    							lv_personnes_5_0,
                    	    							"fr.n7.ENIGME.Personne");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,13,FOLLOW_11); 

                    				newLeafNode(otherlv_6, grammarAccess.getLieuAccess().getRightCurlyBracketKeyword_3_3());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getLieuAccess().getRightCurlyBracketKeyword_4());
            		

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


    // $ANTLR start "entryRuleChemin"
    // InternalENIGME.g:1204:1: entryRuleChemin returns [EObject current=null] : iv_ruleChemin= ruleChemin EOF ;
    public final EObject entryRuleChemin() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChemin = null;


        try {
            // InternalENIGME.g:1204:47: (iv_ruleChemin= ruleChemin EOF )
            // InternalENIGME.g:1205:2: iv_ruleChemin= ruleChemin EOF
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
    // InternalENIGME.g:1211:1: ruleChemin returns [EObject current=null] : (otherlv_0= 'chemin' ( (lv_etatc_1_0= ruleEtatChemin ) ) ( (otherlv_2= RULE_ID ) ) ( (lv_etato_3_0= ruleEtatObligation ) ) ( (otherlv_4= RULE_ID ) ) ( (lv_etatv_5_0= ruleEtatVisibilite ) ) ( (otherlv_6= RULE_ID ) ) otherlv_7= 'de' ( (otherlv_8= RULE_ID ) ) otherlv_9= 'a' ( (otherlv_10= RULE_ID ) ) ) ;
    public final EObject ruleChemin() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Enumerator lv_etatc_1_0 = null;

        Enumerator lv_etato_3_0 = null;

        Enumerator lv_etatv_5_0 = null;



        	enterRule();

        try {
            // InternalENIGME.g:1217:2: ( (otherlv_0= 'chemin' ( (lv_etatc_1_0= ruleEtatChemin ) ) ( (otherlv_2= RULE_ID ) ) ( (lv_etato_3_0= ruleEtatObligation ) ) ( (otherlv_4= RULE_ID ) ) ( (lv_etatv_5_0= ruleEtatVisibilite ) ) ( (otherlv_6= RULE_ID ) ) otherlv_7= 'de' ( (otherlv_8= RULE_ID ) ) otherlv_9= 'a' ( (otherlv_10= RULE_ID ) ) ) )
            // InternalENIGME.g:1218:2: (otherlv_0= 'chemin' ( (lv_etatc_1_0= ruleEtatChemin ) ) ( (otherlv_2= RULE_ID ) ) ( (lv_etato_3_0= ruleEtatObligation ) ) ( (otherlv_4= RULE_ID ) ) ( (lv_etatv_5_0= ruleEtatVisibilite ) ) ( (otherlv_6= RULE_ID ) ) otherlv_7= 'de' ( (otherlv_8= RULE_ID ) ) otherlv_9= 'a' ( (otherlv_10= RULE_ID ) ) )
            {
            // InternalENIGME.g:1218:2: (otherlv_0= 'chemin' ( (lv_etatc_1_0= ruleEtatChemin ) ) ( (otherlv_2= RULE_ID ) ) ( (lv_etato_3_0= ruleEtatObligation ) ) ( (otherlv_4= RULE_ID ) ) ( (lv_etatv_5_0= ruleEtatVisibilite ) ) ( (otherlv_6= RULE_ID ) ) otherlv_7= 'de' ( (otherlv_8= RULE_ID ) ) otherlv_9= 'a' ( (otherlv_10= RULE_ID ) ) )
            // InternalENIGME.g:1219:3: otherlv_0= 'chemin' ( (lv_etatc_1_0= ruleEtatChemin ) ) ( (otherlv_2= RULE_ID ) ) ( (lv_etato_3_0= ruleEtatObligation ) ) ( (otherlv_4= RULE_ID ) ) ( (lv_etatv_5_0= ruleEtatVisibilite ) ) ( (otherlv_6= RULE_ID ) ) otherlv_7= 'de' ( (otherlv_8= RULE_ID ) ) otherlv_9= 'a' ( (otherlv_10= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,36,FOLLOW_31); 

            			newLeafNode(otherlv_0, grammarAccess.getCheminAccess().getCheminKeyword_0());
            		
            // InternalENIGME.g:1223:3: ( (lv_etatc_1_0= ruleEtatChemin ) )
            // InternalENIGME.g:1224:4: (lv_etatc_1_0= ruleEtatChemin )
            {
            // InternalENIGME.g:1224:4: (lv_etatc_1_0= ruleEtatChemin )
            // InternalENIGME.g:1225:5: lv_etatc_1_0= ruleEtatChemin
            {

            					newCompositeNode(grammarAccess.getCheminAccess().getEtatcEtatCheminEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
            lv_etatc_1_0=ruleEtatChemin();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCheminRule());
            					}
            					set(
            						current,
            						"etatc",
            						lv_etatc_1_0,
            						"fr.n7.ENIGME.EtatChemin");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalENIGME.g:1242:3: ( (otherlv_2= RULE_ID ) )
            // InternalENIGME.g:1243:4: (otherlv_2= RULE_ID )
            {
            // InternalENIGME.g:1243:4: (otherlv_2= RULE_ID )
            // InternalENIGME.g:1244:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCheminRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_28); 

            					newLeafNode(otherlv_2, grammarAccess.getCheminAccess().getConditioncConditionCrossReference_2_0());
            				

            }


            }

            // InternalENIGME.g:1255:3: ( (lv_etato_3_0= ruleEtatObligation ) )
            // InternalENIGME.g:1256:4: (lv_etato_3_0= ruleEtatObligation )
            {
            // InternalENIGME.g:1256:4: (lv_etato_3_0= ruleEtatObligation )
            // InternalENIGME.g:1257:5: lv_etato_3_0= ruleEtatObligation
            {

            					newCompositeNode(grammarAccess.getCheminAccess().getEtatoEtatObligationEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_3);
            lv_etato_3_0=ruleEtatObligation();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCheminRule());
            					}
            					set(
            						current,
            						"etato",
            						lv_etato_3_0,
            						"fr.n7.ENIGME.EtatObligation");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalENIGME.g:1274:3: ( (otherlv_4= RULE_ID ) )
            // InternalENIGME.g:1275:4: (otherlv_4= RULE_ID )
            {
            // InternalENIGME.g:1275:4: (otherlv_4= RULE_ID )
            // InternalENIGME.g:1276:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCheminRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(otherlv_4, grammarAccess.getCheminAccess().getConditionoConditionCrossReference_4_0());
            				

            }


            }

            // InternalENIGME.g:1287:3: ( (lv_etatv_5_0= ruleEtatVisibilite ) )
            // InternalENIGME.g:1288:4: (lv_etatv_5_0= ruleEtatVisibilite )
            {
            // InternalENIGME.g:1288:4: (lv_etatv_5_0= ruleEtatVisibilite )
            // InternalENIGME.g:1289:5: lv_etatv_5_0= ruleEtatVisibilite
            {

            					newCompositeNode(grammarAccess.getCheminAccess().getEtatvEtatVisibiliteEnumRuleCall_5_0());
            				
            pushFollow(FOLLOW_3);
            lv_etatv_5_0=ruleEtatVisibilite();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCheminRule());
            					}
            					set(
            						current,
            						"etatv",
            						lv_etatv_5_0,
            						"fr.n7.ENIGME.EtatVisibilite");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalENIGME.g:1306:3: ( (otherlv_6= RULE_ID ) )
            // InternalENIGME.g:1307:4: (otherlv_6= RULE_ID )
            {
            // InternalENIGME.g:1307:4: (otherlv_6= RULE_ID )
            // InternalENIGME.g:1308:5: otherlv_6= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCheminRule());
            					}
            				
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_18); 

            					newLeafNode(otherlv_6, grammarAccess.getCheminAccess().getConditionvConditionCrossReference_6_0());
            				

            }


            }

            otherlv_7=(Token)match(input,23,FOLLOW_3); 

            			newLeafNode(otherlv_7, grammarAccess.getCheminAccess().getDeKeyword_7());
            		
            // InternalENIGME.g:1323:3: ( (otherlv_8= RULE_ID ) )
            // InternalENIGME.g:1324:4: (otherlv_8= RULE_ID )
            {
            // InternalENIGME.g:1324:4: (otherlv_8= RULE_ID )
            // InternalENIGME.g:1325:5: otherlv_8= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCheminRule());
            					}
            				
            otherlv_8=(Token)match(input,RULE_ID,FOLLOW_32); 

            					newLeafNode(otherlv_8, grammarAccess.getCheminAccess().getPrecedentLieuCrossReference_8_0());
            				

            }


            }

            otherlv_9=(Token)match(input,37,FOLLOW_3); 

            			newLeafNode(otherlv_9, grammarAccess.getCheminAccess().getAKeyword_9());
            		
            // InternalENIGME.g:1340:3: ( (otherlv_10= RULE_ID ) )
            // InternalENIGME.g:1341:4: (otherlv_10= RULE_ID )
            {
            // InternalENIGME.g:1341:4: (otherlv_10= RULE_ID )
            // InternalENIGME.g:1342:5: otherlv_10= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCheminRule());
            					}
            				
            otherlv_10=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_10, grammarAccess.getCheminAccess().getSuivantLieuCrossReference_10_0());
            				

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
    // $ANTLR end "ruleChemin"


    // $ANTLR start "entryRuleQualification"
    // InternalENIGME.g:1357:1: entryRuleQualification returns [EObject current=null] : iv_ruleQualification= ruleQualification EOF ;
    public final EObject entryRuleQualification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualification = null;


        try {
            // InternalENIGME.g:1357:54: (iv_ruleQualification= ruleQualification EOF )
            // InternalENIGME.g:1358:2: iv_ruleQualification= ruleQualification EOF
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
    // InternalENIGME.g:1364:1: ruleQualification returns [EObject current=null] : ( ( (lv_id_0_0= RULE_INT ) ) ( (lv_qualification_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleQualification() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;
        Token lv_qualification_1_0=null;


        	enterRule();

        try {
            // InternalENIGME.g:1370:2: ( ( ( (lv_id_0_0= RULE_INT ) ) ( (lv_qualification_1_0= RULE_STRING ) ) ) )
            // InternalENIGME.g:1371:2: ( ( (lv_id_0_0= RULE_INT ) ) ( (lv_qualification_1_0= RULE_STRING ) ) )
            {
            // InternalENIGME.g:1371:2: ( ( (lv_id_0_0= RULE_INT ) ) ( (lv_qualification_1_0= RULE_STRING ) ) )
            // InternalENIGME.g:1372:3: ( (lv_id_0_0= RULE_INT ) ) ( (lv_qualification_1_0= RULE_STRING ) )
            {
            // InternalENIGME.g:1372:3: ( (lv_id_0_0= RULE_INT ) )
            // InternalENIGME.g:1373:4: (lv_id_0_0= RULE_INT )
            {
            // InternalENIGME.g:1373:4: (lv_id_0_0= RULE_INT )
            // InternalENIGME.g:1374:5: lv_id_0_0= RULE_INT
            {
            lv_id_0_0=(Token)match(input,RULE_INT,FOLLOW_12); 

            					newLeafNode(lv_id_0_0, grammarAccess.getQualificationAccess().getIdINTTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getQualificationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"id",
            						lv_id_0_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalENIGME.g:1390:3: ( (lv_qualification_1_0= RULE_STRING ) )
            // InternalENIGME.g:1391:4: (lv_qualification_1_0= RULE_STRING )
            {
            // InternalENIGME.g:1391:4: (lv_qualification_1_0= RULE_STRING )
            // InternalENIGME.g:1392:5: lv_qualification_1_0= RULE_STRING
            {
            lv_qualification_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_qualification_1_0, grammarAccess.getQualificationAccess().getQualificationSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getQualificationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"qualification",
            						lv_qualification_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

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
    // $ANTLR end "ruleQualification"


    // $ANTLR start "entryRuleAction"
    // InternalENIGME.g:1412:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // InternalENIGME.g:1412:47: (iv_ruleAction= ruleAction EOF )
            // InternalENIGME.g:1413:2: iv_ruleAction= ruleAction EOF
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
    // InternalENIGME.g:1419:1: ruleAction returns [EObject current=null] : (otherlv_0= 'action' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'objets' otherlv_4= 'c' otherlv_5= '{' ( (otherlv_6= RULE_ID ) )* otherlv_7= '}' otherlv_8= 'objets' otherlv_9= 'a' otherlv_10= '{' ( (otherlv_11= RULE_ID ) )* otherlv_12= '}' otherlv_13= 'connaissances' otherlv_14= 'a' otherlv_15= '{' ( (otherlv_16= RULE_ID ) )* otherlv_17= '}' otherlv_18= '}' ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
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
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;


        	enterRule();

        try {
            // InternalENIGME.g:1425:2: ( (otherlv_0= 'action' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'objets' otherlv_4= 'c' otherlv_5= '{' ( (otherlv_6= RULE_ID ) )* otherlv_7= '}' otherlv_8= 'objets' otherlv_9= 'a' otherlv_10= '{' ( (otherlv_11= RULE_ID ) )* otherlv_12= '}' otherlv_13= 'connaissances' otherlv_14= 'a' otherlv_15= '{' ( (otherlv_16= RULE_ID ) )* otherlv_17= '}' otherlv_18= '}' ) )
            // InternalENIGME.g:1426:2: (otherlv_0= 'action' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'objets' otherlv_4= 'c' otherlv_5= '{' ( (otherlv_6= RULE_ID ) )* otherlv_7= '}' otherlv_8= 'objets' otherlv_9= 'a' otherlv_10= '{' ( (otherlv_11= RULE_ID ) )* otherlv_12= '}' otherlv_13= 'connaissances' otherlv_14= 'a' otherlv_15= '{' ( (otherlv_16= RULE_ID ) )* otherlv_17= '}' otherlv_18= '}' )
            {
            // InternalENIGME.g:1426:2: (otherlv_0= 'action' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'objets' otherlv_4= 'c' otherlv_5= '{' ( (otherlv_6= RULE_ID ) )* otherlv_7= '}' otherlv_8= 'objets' otherlv_9= 'a' otherlv_10= '{' ( (otherlv_11= RULE_ID ) )* otherlv_12= '}' otherlv_13= 'connaissances' otherlv_14= 'a' otherlv_15= '{' ( (otherlv_16= RULE_ID ) )* otherlv_17= '}' otherlv_18= '}' )
            // InternalENIGME.g:1427:3: otherlv_0= 'action' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'objets' otherlv_4= 'c' otherlv_5= '{' ( (otherlv_6= RULE_ID ) )* otherlv_7= '}' otherlv_8= 'objets' otherlv_9= 'a' otherlv_10= '{' ( (otherlv_11= RULE_ID ) )* otherlv_12= '}' otherlv_13= 'connaissances' otherlv_14= 'a' otherlv_15= '{' ( (otherlv_16= RULE_ID ) )* otherlv_17= '}' otherlv_18= '}'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getActionAccess().getActionKeyword_0());
            		
            // InternalENIGME.g:1431:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalENIGME.g:1432:4: (lv_name_1_0= RULE_ID )
            {
            // InternalENIGME.g:1432:4: (lv_name_1_0= RULE_ID )
            // InternalENIGME.g:1433:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getActionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,16,FOLLOW_33); 

            			newLeafNode(otherlv_3, grammarAccess.getActionAccess().getObjetsKeyword_3());
            		
            otherlv_4=(Token)match(input,39,FOLLOW_4); 

            			newLeafNode(otherlv_4, grammarAccess.getActionAccess().getCKeyword_4());
            		
            otherlv_5=(Token)match(input,12,FOLLOW_9); 

            			newLeafNode(otherlv_5, grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_5());
            		
            // InternalENIGME.g:1465:3: ( (otherlv_6= RULE_ID ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_ID) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalENIGME.g:1466:4: (otherlv_6= RULE_ID )
            	    {
            	    // InternalENIGME.g:1466:4: (otherlv_6= RULE_ID )
            	    // InternalENIGME.g:1467:5: otherlv_6= RULE_ID
            	    {

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getActionRule());
            	    					}
            	    				
            	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_9); 

            	    					newLeafNode(otherlv_6, grammarAccess.getActionAccess().getObjetsconsommablesObjetCrossReference_6_0());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            otherlv_7=(Token)match(input,13,FOLLOW_8); 

            			newLeafNode(otherlv_7, grammarAccess.getActionAccess().getRightCurlyBracketKeyword_7());
            		
            otherlv_8=(Token)match(input,16,FOLLOW_32); 

            			newLeafNode(otherlv_8, grammarAccess.getActionAccess().getObjetsKeyword_8());
            		
            otherlv_9=(Token)match(input,37,FOLLOW_4); 

            			newLeafNode(otherlv_9, grammarAccess.getActionAccess().getAKeyword_9());
            		
            otherlv_10=(Token)match(input,12,FOLLOW_9); 

            			newLeafNode(otherlv_10, grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_10());
            		
            // InternalENIGME.g:1494:3: ( (otherlv_11= RULE_ID ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_ID) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalENIGME.g:1495:4: (otherlv_11= RULE_ID )
            	    {
            	    // InternalENIGME.g:1495:4: (otherlv_11= RULE_ID )
            	    // InternalENIGME.g:1496:5: otherlv_11= RULE_ID
            	    {

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getActionRule());
            	    					}
            	    				
            	    otherlv_11=(Token)match(input,RULE_ID,FOLLOW_9); 

            	    					newLeafNode(otherlv_11, grammarAccess.getActionAccess().getObjetsattribuablesObjetCrossReference_11_0());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            otherlv_12=(Token)match(input,13,FOLLOW_10); 

            			newLeafNode(otherlv_12, grammarAccess.getActionAccess().getRightCurlyBracketKeyword_12());
            		
            otherlv_13=(Token)match(input,17,FOLLOW_32); 

            			newLeafNode(otherlv_13, grammarAccess.getActionAccess().getConnaissancesKeyword_13());
            		
            otherlv_14=(Token)match(input,37,FOLLOW_4); 

            			newLeafNode(otherlv_14, grammarAccess.getActionAccess().getAKeyword_14());
            		
            otherlv_15=(Token)match(input,12,FOLLOW_9); 

            			newLeafNode(otherlv_15, grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_15());
            		
            // InternalENIGME.g:1523:3: ( (otherlv_16= RULE_ID ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_ID) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalENIGME.g:1524:4: (otherlv_16= RULE_ID )
            	    {
            	    // InternalENIGME.g:1524:4: (otherlv_16= RULE_ID )
            	    // InternalENIGME.g:1525:5: otherlv_16= RULE_ID
            	    {

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getActionRule());
            	    					}
            	    				
            	    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_9); 

            	    					newLeafNode(otherlv_16, grammarAccess.getActionAccess().getConnaissancesattribuablesConnaissanceCrossReference_16_0());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            otherlv_17=(Token)match(input,13,FOLLOW_11); 

            			newLeafNode(otherlv_17, grammarAccess.getActionAccess().getRightCurlyBracketKeyword_17());
            		
            otherlv_18=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_18, grammarAccess.getActionAccess().getRightCurlyBracketKeyword_18());
            		

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


    // $ANTLR start "entryRuleReponse"
    // InternalENIGME.g:1548:1: entryRuleReponse returns [EObject current=null] : iv_ruleReponse= ruleReponse EOF ;
    public final EObject entryRuleReponse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReponse = null;


        try {
            // InternalENIGME.g:1548:48: (iv_ruleReponse= ruleReponse EOF )
            // InternalENIGME.g:1549:2: iv_ruleReponse= ruleReponse EOF
            {
             newCompositeNode(grammarAccess.getReponseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReponse=ruleReponse();

            state._fsp--;

             current =iv_ruleReponse; 
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
    // $ANTLR end "entryRuleReponse"


    // $ANTLR start "ruleReponse"
    // InternalENIGME.g:1555:1: ruleReponse returns [EObject current=null] : (otherlv_0= 'reponse' otherlv_1= '>>' ( (lv_name_2_0= RULE_ID ) ) ( (lv_etat_3_0= ruleEtatReponse ) ) otherlv_4= 'de' otherlv_5= 'qualification' ( (otherlv_6= RULE_ID ) ) otherlv_7= 'avec' ( (otherlv_8= RULE_ID ) ) ) ;
    public final EObject ruleReponse() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Enumerator lv_etat_3_0 = null;



        	enterRule();

        try {
            // InternalENIGME.g:1561:2: ( (otherlv_0= 'reponse' otherlv_1= '>>' ( (lv_name_2_0= RULE_ID ) ) ( (lv_etat_3_0= ruleEtatReponse ) ) otherlv_4= 'de' otherlv_5= 'qualification' ( (otherlv_6= RULE_ID ) ) otherlv_7= 'avec' ( (otherlv_8= RULE_ID ) ) ) )
            // InternalENIGME.g:1562:2: (otherlv_0= 'reponse' otherlv_1= '>>' ( (lv_name_2_0= RULE_ID ) ) ( (lv_etat_3_0= ruleEtatReponse ) ) otherlv_4= 'de' otherlv_5= 'qualification' ( (otherlv_6= RULE_ID ) ) otherlv_7= 'avec' ( (otherlv_8= RULE_ID ) ) )
            {
            // InternalENIGME.g:1562:2: (otherlv_0= 'reponse' otherlv_1= '>>' ( (lv_name_2_0= RULE_ID ) ) ( (lv_etat_3_0= ruleEtatReponse ) ) otherlv_4= 'de' otherlv_5= 'qualification' ( (otherlv_6= RULE_ID ) ) otherlv_7= 'avec' ( (otherlv_8= RULE_ID ) ) )
            // InternalENIGME.g:1563:3: otherlv_0= 'reponse' otherlv_1= '>>' ( (lv_name_2_0= RULE_ID ) ) ( (lv_etat_3_0= ruleEtatReponse ) ) otherlv_4= 'de' otherlv_5= 'qualification' ( (otherlv_6= RULE_ID ) ) otherlv_7= 'avec' ( (otherlv_8= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,40,FOLLOW_34); 

            			newLeafNode(otherlv_0, grammarAccess.getReponseAccess().getReponseKeyword_0());
            		
            otherlv_1=(Token)match(input,41,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getReponseAccess().getGreaterThanSignGreaterThanSignKeyword_1());
            		
            // InternalENIGME.g:1571:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalENIGME.g:1572:4: (lv_name_2_0= RULE_ID )
            {
            // InternalENIGME.g:1572:4: (lv_name_2_0= RULE_ID )
            // InternalENIGME.g:1573:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_35); 

            					newLeafNode(lv_name_2_0, grammarAccess.getReponseAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReponseRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalENIGME.g:1589:3: ( (lv_etat_3_0= ruleEtatReponse ) )
            // InternalENIGME.g:1590:4: (lv_etat_3_0= ruleEtatReponse )
            {
            // InternalENIGME.g:1590:4: (lv_etat_3_0= ruleEtatReponse )
            // InternalENIGME.g:1591:5: lv_etat_3_0= ruleEtatReponse
            {

            					newCompositeNode(grammarAccess.getReponseAccess().getEtatEtatReponseEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_18);
            lv_etat_3_0=ruleEtatReponse();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getReponseRule());
            					}
            					set(
            						current,
            						"etat",
            						lv_etat_3_0,
            						"fr.n7.ENIGME.EtatReponse");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,23,FOLLOW_36); 

            			newLeafNode(otherlv_4, grammarAccess.getReponseAccess().getDeKeyword_4());
            		
            otherlv_5=(Token)match(input,42,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getReponseAccess().getQualificationKeyword_5());
            		
            // InternalENIGME.g:1616:3: ( (otherlv_6= RULE_ID ) )
            // InternalENIGME.g:1617:4: (otherlv_6= RULE_ID )
            {
            // InternalENIGME.g:1617:4: (otherlv_6= RULE_ID )
            // InternalENIGME.g:1618:5: otherlv_6= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReponseRule());
            					}
            				
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_37); 

            					newLeafNode(otherlv_6, grammarAccess.getReponseAccess().getTexteQualificationCrossReference_6_0());
            				

            }


            }

            otherlv_7=(Token)match(input,43,FOLLOW_3); 

            			newLeafNode(otherlv_7, grammarAccess.getReponseAccess().getAvecKeyword_7());
            		
            // InternalENIGME.g:1633:3: ( (otherlv_8= RULE_ID ) )
            // InternalENIGME.g:1634:4: (otherlv_8= RULE_ID )
            {
            // InternalENIGME.g:1634:4: (otherlv_8= RULE_ID )
            // InternalENIGME.g:1635:5: otherlv_8= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReponseRule());
            					}
            				
            otherlv_8=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_8, grammarAccess.getReponseAccess().getActionActionCrossReference_8_0());
            				

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
    // $ANTLR end "ruleReponse"


    // $ANTLR start "entryRuleCondition"
    // InternalENIGME.g:1650:1: entryRuleCondition returns [EObject current=null] : iv_ruleCondition= ruleCondition EOF ;
    public final EObject entryRuleCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondition = null;


        try {
            // InternalENIGME.g:1650:50: (iv_ruleCondition= ruleCondition EOF )
            // InternalENIGME.g:1651:2: iv_ruleCondition= ruleCondition EOF
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
    // InternalENIGME.g:1657:1: ruleCondition returns [EObject current=null] : (otherlv_0= 'condition' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'obj' otherlv_4= '{' ( (otherlv_5= RULE_ID ) )* otherlv_6= '}' otherlv_7= 'con' otherlv_8= '{' ( (otherlv_9= RULE_ID ) )* otherlv_10= '}' otherlv_11= '}' ) ;
    public final EObject ruleCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
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


        	enterRule();

        try {
            // InternalENIGME.g:1663:2: ( (otherlv_0= 'condition' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'obj' otherlv_4= '{' ( (otherlv_5= RULE_ID ) )* otherlv_6= '}' otherlv_7= 'con' otherlv_8= '{' ( (otherlv_9= RULE_ID ) )* otherlv_10= '}' otherlv_11= '}' ) )
            // InternalENIGME.g:1664:2: (otherlv_0= 'condition' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'obj' otherlv_4= '{' ( (otherlv_5= RULE_ID ) )* otherlv_6= '}' otherlv_7= 'con' otherlv_8= '{' ( (otherlv_9= RULE_ID ) )* otherlv_10= '}' otherlv_11= '}' )
            {
            // InternalENIGME.g:1664:2: (otherlv_0= 'condition' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'obj' otherlv_4= '{' ( (otherlv_5= RULE_ID ) )* otherlv_6= '}' otherlv_7= 'con' otherlv_8= '{' ( (otherlv_9= RULE_ID ) )* otherlv_10= '}' otherlv_11= '}' )
            // InternalENIGME.g:1665:3: otherlv_0= 'condition' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'obj' otherlv_4= '{' ( (otherlv_5= RULE_ID ) )* otherlv_6= '}' otherlv_7= 'con' otherlv_8= '{' ( (otherlv_9= RULE_ID ) )* otherlv_10= '}' otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getConditionAccess().getConditionKeyword_0());
            		
            // InternalENIGME.g:1669:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalENIGME.g:1670:4: (lv_name_1_0= RULE_ID )
            {
            // InternalENIGME.g:1670:4: (lv_name_1_0= RULE_ID )
            // InternalENIGME.g:1671:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getConditionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConditionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_38); 

            			newLeafNode(otherlv_2, grammarAccess.getConditionAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,45,FOLLOW_4); 

            			newLeafNode(otherlv_3, grammarAccess.getConditionAccess().getObjKeyword_3());
            		
            otherlv_4=(Token)match(input,12,FOLLOW_9); 

            			newLeafNode(otherlv_4, grammarAccess.getConditionAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalENIGME.g:1699:3: ( (otherlv_5= RULE_ID ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_ID) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalENIGME.g:1700:4: (otherlv_5= RULE_ID )
            	    {
            	    // InternalENIGME.g:1700:4: (otherlv_5= RULE_ID )
            	    // InternalENIGME.g:1701:5: otherlv_5= RULE_ID
            	    {

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getConditionRule());
            	    					}
            	    				
            	    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_9); 

            	    					newLeafNode(otherlv_5, grammarAccess.getConditionAccess().getObjetsRequisObjetCrossReference_5_0());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            otherlv_6=(Token)match(input,13,FOLLOW_39); 

            			newLeafNode(otherlv_6, grammarAccess.getConditionAccess().getRightCurlyBracketKeyword_6());
            		
            otherlv_7=(Token)match(input,46,FOLLOW_4); 

            			newLeafNode(otherlv_7, grammarAccess.getConditionAccess().getConKeyword_7());
            		
            otherlv_8=(Token)match(input,12,FOLLOW_9); 

            			newLeafNode(otherlv_8, grammarAccess.getConditionAccess().getLeftCurlyBracketKeyword_8());
            		
            // InternalENIGME.g:1724:3: ( (otherlv_9= RULE_ID ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_ID) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalENIGME.g:1725:4: (otherlv_9= RULE_ID )
            	    {
            	    // InternalENIGME.g:1725:4: (otherlv_9= RULE_ID )
            	    // InternalENIGME.g:1726:5: otherlv_9= RULE_ID
            	    {

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getConditionRule());
            	    					}
            	    				
            	    otherlv_9=(Token)match(input,RULE_ID,FOLLOW_9); 

            	    					newLeafNode(otherlv_9, grammarAccess.getConditionAccess().getConnaissancesRequisesConnaissanceCrossReference_9_0());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            otherlv_10=(Token)match(input,13,FOLLOW_11); 

            			newLeafNode(otherlv_10, grammarAccess.getConditionAccess().getRightCurlyBracketKeyword_10());
            		
            otherlv_11=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getConditionAccess().getRightCurlyBracketKeyword_11());
            		

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


    // $ANTLR start "ruleEtatReponse"
    // InternalENIGME.g:1749:1: ruleEtatReponse returns [Enumerator current=null] : ( (enumLiteral_0= 'bonne' ) | (enumLiteral_1= 'mauvaise' ) ) ;
    public final Enumerator ruleEtatReponse() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalENIGME.g:1755:2: ( ( (enumLiteral_0= 'bonne' ) | (enumLiteral_1= 'mauvaise' ) ) )
            // InternalENIGME.g:1756:2: ( (enumLiteral_0= 'bonne' ) | (enumLiteral_1= 'mauvaise' ) )
            {
            // InternalENIGME.g:1756:2: ( (enumLiteral_0= 'bonne' ) | (enumLiteral_1= 'mauvaise' ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==47) ) {
                alt18=1;
            }
            else if ( (LA18_0==48) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalENIGME.g:1757:3: (enumLiteral_0= 'bonne' )
                    {
                    // InternalENIGME.g:1757:3: (enumLiteral_0= 'bonne' )
                    // InternalENIGME.g:1758:4: enumLiteral_0= 'bonne'
                    {
                    enumLiteral_0=(Token)match(input,47,FOLLOW_2); 

                    				current = grammarAccess.getEtatReponseAccess().getBonneEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getEtatReponseAccess().getBonneEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalENIGME.g:1765:3: (enumLiteral_1= 'mauvaise' )
                    {
                    // InternalENIGME.g:1765:3: (enumLiteral_1= 'mauvaise' )
                    // InternalENIGME.g:1766:4: enumLiteral_1= 'mauvaise'
                    {
                    enumLiteral_1=(Token)match(input,48,FOLLOW_2); 

                    				current = grammarAccess.getEtatReponseAccess().getMauvaiseEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getEtatReponseAccess().getMauvaiseEnumLiteralDeclaration_1());
                    			

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
    // $ANTLR end "ruleEtatReponse"


    // $ANTLR start "ruleEtatPossession"
    // InternalENIGME.g:1776:1: ruleEtatPossession returns [Enumerator current=null] : ( (enumLiteral_0= 'possede' ) | (enumLiteral_1= 'npossede' ) ) ;
    public final Enumerator ruleEtatPossession() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalENIGME.g:1782:2: ( ( (enumLiteral_0= 'possede' ) | (enumLiteral_1= 'npossede' ) ) )
            // InternalENIGME.g:1783:2: ( (enumLiteral_0= 'possede' ) | (enumLiteral_1= 'npossede' ) )
            {
            // InternalENIGME.g:1783:2: ( (enumLiteral_0= 'possede' ) | (enumLiteral_1= 'npossede' ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==49) ) {
                alt19=1;
            }
            else if ( (LA19_0==50) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalENIGME.g:1784:3: (enumLiteral_0= 'possede' )
                    {
                    // InternalENIGME.g:1784:3: (enumLiteral_0= 'possede' )
                    // InternalENIGME.g:1785:4: enumLiteral_0= 'possede'
                    {
                    enumLiteral_0=(Token)match(input,49,FOLLOW_2); 

                    				current = grammarAccess.getEtatPossessionAccess().getPossedeEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getEtatPossessionAccess().getPossedeEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalENIGME.g:1792:3: (enumLiteral_1= 'npossede' )
                    {
                    // InternalENIGME.g:1792:3: (enumLiteral_1= 'npossede' )
                    // InternalENIGME.g:1793:4: enumLiteral_1= 'npossede'
                    {
                    enumLiteral_1=(Token)match(input,50,FOLLOW_2); 

                    				current = grammarAccess.getEtatPossessionAccess().getNpossedeEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getEtatPossessionAccess().getNpossedeEnumLiteralDeclaration_1());
                    			

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
    // $ANTLR end "ruleEtatPossession"


    // $ANTLR start "ruleEtatVisibilite"
    // InternalENIGME.g:1803:1: ruleEtatVisibilite returns [Enumerator current=null] : ( (enumLiteral_0= 'visible' ) | (enumLiteral_1= 'nvisible' ) ) ;
    public final Enumerator ruleEtatVisibilite() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalENIGME.g:1809:2: ( ( (enumLiteral_0= 'visible' ) | (enumLiteral_1= 'nvisible' ) ) )
            // InternalENIGME.g:1810:2: ( (enumLiteral_0= 'visible' ) | (enumLiteral_1= 'nvisible' ) )
            {
            // InternalENIGME.g:1810:2: ( (enumLiteral_0= 'visible' ) | (enumLiteral_1= 'nvisible' ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==51) ) {
                alt20=1;
            }
            else if ( (LA20_0==52) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalENIGME.g:1811:3: (enumLiteral_0= 'visible' )
                    {
                    // InternalENIGME.g:1811:3: (enumLiteral_0= 'visible' )
                    // InternalENIGME.g:1812:4: enumLiteral_0= 'visible'
                    {
                    enumLiteral_0=(Token)match(input,51,FOLLOW_2); 

                    				current = grammarAccess.getEtatVisibiliteAccess().getVisibleEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getEtatVisibiliteAccess().getVisibleEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalENIGME.g:1819:3: (enumLiteral_1= 'nvisible' )
                    {
                    // InternalENIGME.g:1819:3: (enumLiteral_1= 'nvisible' )
                    // InternalENIGME.g:1820:4: enumLiteral_1= 'nvisible'
                    {
                    enumLiteral_1=(Token)match(input,52,FOLLOW_2); 

                    				current = grammarAccess.getEtatVisibiliteAccess().getNvisibleEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getEtatVisibiliteAccess().getNvisibleEnumLiteralDeclaration_1());
                    			

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


    // $ANTLR start "ruleEtatObligation"
    // InternalENIGME.g:1830:1: ruleEtatObligation returns [Enumerator current=null] : ( (enumLiteral_0= 'obligatoire' ) | (enumLiteral_1= 'nobligatoire' ) ) ;
    public final Enumerator ruleEtatObligation() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalENIGME.g:1836:2: ( ( (enumLiteral_0= 'obligatoire' ) | (enumLiteral_1= 'nobligatoire' ) ) )
            // InternalENIGME.g:1837:2: ( (enumLiteral_0= 'obligatoire' ) | (enumLiteral_1= 'nobligatoire' ) )
            {
            // InternalENIGME.g:1837:2: ( (enumLiteral_0= 'obligatoire' ) | (enumLiteral_1= 'nobligatoire' ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==53) ) {
                alt21=1;
            }
            else if ( (LA21_0==54) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalENIGME.g:1838:3: (enumLiteral_0= 'obligatoire' )
                    {
                    // InternalENIGME.g:1838:3: (enumLiteral_0= 'obligatoire' )
                    // InternalENIGME.g:1839:4: enumLiteral_0= 'obligatoire'
                    {
                    enumLiteral_0=(Token)match(input,53,FOLLOW_2); 

                    				current = grammarAccess.getEtatObligationAccess().getObligatoireEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getEtatObligationAccess().getObligatoireEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalENIGME.g:1846:3: (enumLiteral_1= 'nobligatoire' )
                    {
                    // InternalENIGME.g:1846:3: (enumLiteral_1= 'nobligatoire' )
                    // InternalENIGME.g:1847:4: enumLiteral_1= 'nobligatoire'
                    {
                    enumLiteral_1=(Token)match(input,54,FOLLOW_2); 

                    				current = grammarAccess.getEtatObligationAccess().getNobligatoireEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getEtatObligationAccess().getNobligatoireEnumLiteralDeclaration_1());
                    			

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
    // $ANTLR end "ruleEtatObligation"


    // $ANTLR start "ruleEtatChemin"
    // InternalENIGME.g:1857:1: ruleEtatChemin returns [Enumerator current=null] : ( (enumLiteral_0= 'ouvert' ) | (enumLiteral_1= 'ferme' ) ) ;
    public final Enumerator ruleEtatChemin() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalENIGME.g:1863:2: ( ( (enumLiteral_0= 'ouvert' ) | (enumLiteral_1= 'ferme' ) ) )
            // InternalENIGME.g:1864:2: ( (enumLiteral_0= 'ouvert' ) | (enumLiteral_1= 'ferme' ) )
            {
            // InternalENIGME.g:1864:2: ( (enumLiteral_0= 'ouvert' ) | (enumLiteral_1= 'ferme' ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==55) ) {
                alt22=1;
            }
            else if ( (LA22_0==56) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalENIGME.g:1865:3: (enumLiteral_0= 'ouvert' )
                    {
                    // InternalENIGME.g:1865:3: (enumLiteral_0= 'ouvert' )
                    // InternalENIGME.g:1866:4: enumLiteral_0= 'ouvert'
                    {
                    enumLiteral_0=(Token)match(input,55,FOLLOW_2); 

                    				current = grammarAccess.getEtatCheminAccess().getOuvertEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getEtatCheminAccess().getOuvertEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalENIGME.g:1873:3: (enumLiteral_1= 'ferme' )
                    {
                    // InternalENIGME.g:1873:3: (enumLiteral_1= 'ferme' )
                    // InternalENIGME.g:1874:4: enumLiteral_1= 'ferme'
                    {
                    enumLiteral_1=(Token)match(input,56,FOLLOW_2); 

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

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000115742146020L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0018000000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0006000000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000400002000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000001000002000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0060000000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000800002000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000200002000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0180000000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0001800000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000400000000000L});

}
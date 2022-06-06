package fr.n7.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import fr.n7.services.GAMEGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalGAMEParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'true'", "'false'", "'visible'", "'non visible'", "'ouvert'", "'ferme'", "'actif'", "'inactif'", "'game'", "'{'", "'}'", "'explorateur'", "'objets'", "'connaisances'", "'lieuCourant'", "'lieuxExplores'", "'limiteTaille'", "'objet'", "'initVal'", "'taille'", "'etat'", "'obtention'", "'connaissance'", "'lieu'", "'personnes'", "'connaissances'", "'chemins'", "'territoire'", "'depart'", "'inter'", "'fins'", "'condition'", "'objetsTrue'", "'objetsFalse'", "'connaissanceTrue'", "'connaissanceFalse'", "'lieuExplores'", "'etatChemin'", "'de'", "'a'", "'ouverture'", "'obligation'", "'objetsTransmis'", "'prixObjets'", "'personne'", "'activite'", "'visibilite'", "'interaction'", "'choixDebut'", "'choixInter'", "'choixFin'", "'Fin'", "'choix'", "'actions'", "'action'", "'objetsConsommes'", "'objetsProduits'", "'connaissanceProduits'", "'qualif'", "'-'"
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
    public static final int RULE_ID=5;
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
    public static final int RULE_STRING=4;
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

    	public void setGrammarAccess(GAMEGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleGame"
    // InternalGAME.g:53:1: entryRuleGame : ruleGame EOF ;
    public final void entryRuleGame() throws RecognitionException {
        try {
            // InternalGAME.g:54:1: ( ruleGame EOF )
            // InternalGAME.g:55:1: ruleGame EOF
            {
             before(grammarAccess.getGameRule()); 
            pushFollow(FOLLOW_1);
            ruleGame();

            state._fsp--;

             after(grammarAccess.getGameRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGame"


    // $ANTLR start "ruleGame"
    // InternalGAME.g:62:1: ruleGame : ( ( rule__Game__Group__0 ) ) ;
    public final void ruleGame() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:66:2: ( ( ( rule__Game__Group__0 ) ) )
            // InternalGAME.g:67:2: ( ( rule__Game__Group__0 ) )
            {
            // InternalGAME.g:67:2: ( ( rule__Game__Group__0 ) )
            // InternalGAME.g:68:3: ( rule__Game__Group__0 )
            {
             before(grammarAccess.getGameAccess().getGroup()); 
            // InternalGAME.g:69:3: ( rule__Game__Group__0 )
            // InternalGAME.g:69:4: rule__Game__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Game__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGameAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGame"


    // $ANTLR start "entryRuleEString"
    // InternalGAME.g:78:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalGAME.g:79:1: ( ruleEString EOF )
            // InternalGAME.g:80:1: ruleEString EOF
            {
             before(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEStringRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalGAME.g:87:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:91:2: ( ( ( rule__EString__Alternatives ) ) )
            // InternalGAME.g:92:2: ( ( rule__EString__Alternatives ) )
            {
            // InternalGAME.g:92:2: ( ( rule__EString__Alternatives ) )
            // InternalGAME.g:93:3: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalGAME.g:94:3: ( rule__EString__Alternatives )
            // InternalGAME.g:94:4: rule__EString__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EString__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEStringAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleExplorateur"
    // InternalGAME.g:103:1: entryRuleExplorateur : ruleExplorateur EOF ;
    public final void entryRuleExplorateur() throws RecognitionException {
        try {
            // InternalGAME.g:104:1: ( ruleExplorateur EOF )
            // InternalGAME.g:105:1: ruleExplorateur EOF
            {
             before(grammarAccess.getExplorateurRule()); 
            pushFollow(FOLLOW_1);
            ruleExplorateur();

            state._fsp--;

             after(grammarAccess.getExplorateurRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExplorateur"


    // $ANTLR start "ruleExplorateur"
    // InternalGAME.g:112:1: ruleExplorateur : ( ( rule__Explorateur__Group__0 ) ) ;
    public final void ruleExplorateur() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:116:2: ( ( ( rule__Explorateur__Group__0 ) ) )
            // InternalGAME.g:117:2: ( ( rule__Explorateur__Group__0 ) )
            {
            // InternalGAME.g:117:2: ( ( rule__Explorateur__Group__0 ) )
            // InternalGAME.g:118:3: ( rule__Explorateur__Group__0 )
            {
             before(grammarAccess.getExplorateurAccess().getGroup()); 
            // InternalGAME.g:119:3: ( rule__Explorateur__Group__0 )
            // InternalGAME.g:119:4: rule__Explorateur__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Explorateur__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExplorateurAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExplorateur"


    // $ANTLR start "entryRuleObjet"
    // InternalGAME.g:128:1: entryRuleObjet : ruleObjet EOF ;
    public final void entryRuleObjet() throws RecognitionException {
        try {
            // InternalGAME.g:129:1: ( ruleObjet EOF )
            // InternalGAME.g:130:1: ruleObjet EOF
            {
             before(grammarAccess.getObjetRule()); 
            pushFollow(FOLLOW_1);
            ruleObjet();

            state._fsp--;

             after(grammarAccess.getObjetRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleObjet"


    // $ANTLR start "ruleObjet"
    // InternalGAME.g:137:1: ruleObjet : ( ( rule__Objet__Group__0 ) ) ;
    public final void ruleObjet() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:141:2: ( ( ( rule__Objet__Group__0 ) ) )
            // InternalGAME.g:142:2: ( ( rule__Objet__Group__0 ) )
            {
            // InternalGAME.g:142:2: ( ( rule__Objet__Group__0 ) )
            // InternalGAME.g:143:3: ( rule__Objet__Group__0 )
            {
             before(grammarAccess.getObjetAccess().getGroup()); 
            // InternalGAME.g:144:3: ( rule__Objet__Group__0 )
            // InternalGAME.g:144:4: rule__Objet__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Objet__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getObjetAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleObjet"


    // $ANTLR start "entryRuleConnaissance"
    // InternalGAME.g:153:1: entryRuleConnaissance : ruleConnaissance EOF ;
    public final void entryRuleConnaissance() throws RecognitionException {
        try {
            // InternalGAME.g:154:1: ( ruleConnaissance EOF )
            // InternalGAME.g:155:1: ruleConnaissance EOF
            {
             before(grammarAccess.getConnaissanceRule()); 
            pushFollow(FOLLOW_1);
            ruleConnaissance();

            state._fsp--;

             after(grammarAccess.getConnaissanceRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConnaissance"


    // $ANTLR start "ruleConnaissance"
    // InternalGAME.g:162:1: ruleConnaissance : ( ( rule__Connaissance__Group__0 ) ) ;
    public final void ruleConnaissance() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:166:2: ( ( ( rule__Connaissance__Group__0 ) ) )
            // InternalGAME.g:167:2: ( ( rule__Connaissance__Group__0 ) )
            {
            // InternalGAME.g:167:2: ( ( rule__Connaissance__Group__0 ) )
            // InternalGAME.g:168:3: ( rule__Connaissance__Group__0 )
            {
             before(grammarAccess.getConnaissanceAccess().getGroup()); 
            // InternalGAME.g:169:3: ( rule__Connaissance__Group__0 )
            // InternalGAME.g:169:4: rule__Connaissance__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Connaissance__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConnaissanceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConnaissance"


    // $ANTLR start "entryRuleLieu"
    // InternalGAME.g:178:1: entryRuleLieu : ruleLieu EOF ;
    public final void entryRuleLieu() throws RecognitionException {
        try {
            // InternalGAME.g:179:1: ( ruleLieu EOF )
            // InternalGAME.g:180:1: ruleLieu EOF
            {
             before(grammarAccess.getLieuRule()); 
            pushFollow(FOLLOW_1);
            ruleLieu();

            state._fsp--;

             after(grammarAccess.getLieuRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLieu"


    // $ANTLR start "ruleLieu"
    // InternalGAME.g:187:1: ruleLieu : ( ( rule__Lieu__Group__0 ) ) ;
    public final void ruleLieu() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:191:2: ( ( ( rule__Lieu__Group__0 ) ) )
            // InternalGAME.g:192:2: ( ( rule__Lieu__Group__0 ) )
            {
            // InternalGAME.g:192:2: ( ( rule__Lieu__Group__0 ) )
            // InternalGAME.g:193:3: ( rule__Lieu__Group__0 )
            {
             before(grammarAccess.getLieuAccess().getGroup()); 
            // InternalGAME.g:194:3: ( rule__Lieu__Group__0 )
            // InternalGAME.g:194:4: rule__Lieu__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Lieu__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLieuAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLieu"


    // $ANTLR start "entryRuleTerritoire"
    // InternalGAME.g:203:1: entryRuleTerritoire : ruleTerritoire EOF ;
    public final void entryRuleTerritoire() throws RecognitionException {
        try {
            // InternalGAME.g:204:1: ( ruleTerritoire EOF )
            // InternalGAME.g:205:1: ruleTerritoire EOF
            {
             before(grammarAccess.getTerritoireRule()); 
            pushFollow(FOLLOW_1);
            ruleTerritoire();

            state._fsp--;

             after(grammarAccess.getTerritoireRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTerritoire"


    // $ANTLR start "ruleTerritoire"
    // InternalGAME.g:212:1: ruleTerritoire : ( ( rule__Territoire__Group__0 ) ) ;
    public final void ruleTerritoire() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:216:2: ( ( ( rule__Territoire__Group__0 ) ) )
            // InternalGAME.g:217:2: ( ( rule__Territoire__Group__0 ) )
            {
            // InternalGAME.g:217:2: ( ( rule__Territoire__Group__0 ) )
            // InternalGAME.g:218:3: ( rule__Territoire__Group__0 )
            {
             before(grammarAccess.getTerritoireAccess().getGroup()); 
            // InternalGAME.g:219:3: ( rule__Territoire__Group__0 )
            // InternalGAME.g:219:4: rule__Territoire__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Territoire__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTerritoireAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTerritoire"


    // $ANTLR start "entryRuleCondition"
    // InternalGAME.g:228:1: entryRuleCondition : ruleCondition EOF ;
    public final void entryRuleCondition() throws RecognitionException {
        try {
            // InternalGAME.g:229:1: ( ruleCondition EOF )
            // InternalGAME.g:230:1: ruleCondition EOF
            {
             before(grammarAccess.getConditionRule()); 
            pushFollow(FOLLOW_1);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getConditionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCondition"


    // $ANTLR start "ruleCondition"
    // InternalGAME.g:237:1: ruleCondition : ( ( rule__Condition__Group__0 ) ) ;
    public final void ruleCondition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:241:2: ( ( ( rule__Condition__Group__0 ) ) )
            // InternalGAME.g:242:2: ( ( rule__Condition__Group__0 ) )
            {
            // InternalGAME.g:242:2: ( ( rule__Condition__Group__0 ) )
            // InternalGAME.g:243:3: ( rule__Condition__Group__0 )
            {
             before(grammarAccess.getConditionAccess().getGroup()); 
            // InternalGAME.g:244:3: ( rule__Condition__Group__0 )
            // InternalGAME.g:244:4: rule__Condition__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Condition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConditionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCondition"


    // $ANTLR start "entryRuleChemin"
    // InternalGAME.g:253:1: entryRuleChemin : ruleChemin EOF ;
    public final void entryRuleChemin() throws RecognitionException {
        try {
            // InternalGAME.g:254:1: ( ruleChemin EOF )
            // InternalGAME.g:255:1: ruleChemin EOF
            {
             before(grammarAccess.getCheminRule()); 
            pushFollow(FOLLOW_1);
            ruleChemin();

            state._fsp--;

             after(grammarAccess.getCheminRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleChemin"


    // $ANTLR start "ruleChemin"
    // InternalGAME.g:262:1: ruleChemin : ( ( rule__Chemin__Group__0 ) ) ;
    public final void ruleChemin() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:266:2: ( ( ( rule__Chemin__Group__0 ) ) )
            // InternalGAME.g:267:2: ( ( rule__Chemin__Group__0 ) )
            {
            // InternalGAME.g:267:2: ( ( rule__Chemin__Group__0 ) )
            // InternalGAME.g:268:3: ( rule__Chemin__Group__0 )
            {
             before(grammarAccess.getCheminAccess().getGroup()); 
            // InternalGAME.g:269:3: ( rule__Chemin__Group__0 )
            // InternalGAME.g:269:4: rule__Chemin__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Chemin__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCheminAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleChemin"


    // $ANTLR start "entryRulePersonne"
    // InternalGAME.g:278:1: entryRulePersonne : rulePersonne EOF ;
    public final void entryRulePersonne() throws RecognitionException {
        try {
            // InternalGAME.g:279:1: ( rulePersonne EOF )
            // InternalGAME.g:280:1: rulePersonne EOF
            {
             before(grammarAccess.getPersonneRule()); 
            pushFollow(FOLLOW_1);
            rulePersonne();

            state._fsp--;

             after(grammarAccess.getPersonneRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePersonne"


    // $ANTLR start "rulePersonne"
    // InternalGAME.g:287:1: rulePersonne : ( ( rule__Personne__Group__0 ) ) ;
    public final void rulePersonne() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:291:2: ( ( ( rule__Personne__Group__0 ) ) )
            // InternalGAME.g:292:2: ( ( rule__Personne__Group__0 ) )
            {
            // InternalGAME.g:292:2: ( ( rule__Personne__Group__0 ) )
            // InternalGAME.g:293:3: ( rule__Personne__Group__0 )
            {
             before(grammarAccess.getPersonneAccess().getGroup()); 
            // InternalGAME.g:294:3: ( rule__Personne__Group__0 )
            // InternalGAME.g:294:4: rule__Personne__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Personne__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPersonneAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePersonne"


    // $ANTLR start "entryRuleInteraction"
    // InternalGAME.g:303:1: entryRuleInteraction : ruleInteraction EOF ;
    public final void entryRuleInteraction() throws RecognitionException {
        try {
            // InternalGAME.g:304:1: ( ruleInteraction EOF )
            // InternalGAME.g:305:1: ruleInteraction EOF
            {
             before(grammarAccess.getInteractionRule()); 
            pushFollow(FOLLOW_1);
            ruleInteraction();

            state._fsp--;

             after(grammarAccess.getInteractionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleInteraction"


    // $ANTLR start "ruleInteraction"
    // InternalGAME.g:312:1: ruleInteraction : ( ( rule__Interaction__Group__0 ) ) ;
    public final void ruleInteraction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:316:2: ( ( ( rule__Interaction__Group__0 ) ) )
            // InternalGAME.g:317:2: ( ( rule__Interaction__Group__0 ) )
            {
            // InternalGAME.g:317:2: ( ( rule__Interaction__Group__0 ) )
            // InternalGAME.g:318:3: ( rule__Interaction__Group__0 )
            {
             before(grammarAccess.getInteractionAccess().getGroup()); 
            // InternalGAME.g:319:3: ( rule__Interaction__Group__0 )
            // InternalGAME.g:319:4: rule__Interaction__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Interaction__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getInteractionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInteraction"


    // $ANTLR start "entryRuleChoix"
    // InternalGAME.g:328:1: entryRuleChoix : ruleChoix EOF ;
    public final void entryRuleChoix() throws RecognitionException {
        try {
            // InternalGAME.g:329:1: ( ruleChoix EOF )
            // InternalGAME.g:330:1: ruleChoix EOF
            {
             before(grammarAccess.getChoixRule()); 
            pushFollow(FOLLOW_1);
            ruleChoix();

            state._fsp--;

             after(grammarAccess.getChoixRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleChoix"


    // $ANTLR start "ruleChoix"
    // InternalGAME.g:337:1: ruleChoix : ( ( rule__Choix__Group__0 ) ) ;
    public final void ruleChoix() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:341:2: ( ( ( rule__Choix__Group__0 ) ) )
            // InternalGAME.g:342:2: ( ( rule__Choix__Group__0 ) )
            {
            // InternalGAME.g:342:2: ( ( rule__Choix__Group__0 ) )
            // InternalGAME.g:343:3: ( rule__Choix__Group__0 )
            {
             before(grammarAccess.getChoixAccess().getGroup()); 
            // InternalGAME.g:344:3: ( rule__Choix__Group__0 )
            // InternalGAME.g:344:4: rule__Choix__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Choix__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getChoixAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleChoix"


    // $ANTLR start "entryRuleAction"
    // InternalGAME.g:353:1: entryRuleAction : ruleAction EOF ;
    public final void entryRuleAction() throws RecognitionException {
        try {
            // InternalGAME.g:354:1: ( ruleAction EOF )
            // InternalGAME.g:355:1: ruleAction EOF
            {
             before(grammarAccess.getActionRule()); 
            pushFollow(FOLLOW_1);
            ruleAction();

            state._fsp--;

             after(grammarAccess.getActionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // InternalGAME.g:362:1: ruleAction : ( ( rule__Action__Group__0 ) ) ;
    public final void ruleAction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:366:2: ( ( ( rule__Action__Group__0 ) ) )
            // InternalGAME.g:367:2: ( ( rule__Action__Group__0 ) )
            {
            // InternalGAME.g:367:2: ( ( rule__Action__Group__0 ) )
            // InternalGAME.g:368:3: ( rule__Action__Group__0 )
            {
             before(grammarAccess.getActionAccess().getGroup()); 
            // InternalGAME.g:369:3: ( rule__Action__Group__0 )
            // InternalGAME.g:369:4: rule__Action__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Action__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getActionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleQualification"
    // InternalGAME.g:378:1: entryRuleQualification : ruleQualification EOF ;
    public final void entryRuleQualification() throws RecognitionException {
        try {
            // InternalGAME.g:379:1: ( ruleQualification EOF )
            // InternalGAME.g:380:1: ruleQualification EOF
            {
             before(grammarAccess.getQualificationRule()); 
            pushFollow(FOLLOW_1);
            ruleQualification();

            state._fsp--;

             after(grammarAccess.getQualificationRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualification"


    // $ANTLR start "ruleQualification"
    // InternalGAME.g:387:1: ruleQualification : ( ( rule__Qualification__Group__0 ) ) ;
    public final void ruleQualification() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:391:2: ( ( ( rule__Qualification__Group__0 ) ) )
            // InternalGAME.g:392:2: ( ( rule__Qualification__Group__0 ) )
            {
            // InternalGAME.g:392:2: ( ( rule__Qualification__Group__0 ) )
            // InternalGAME.g:393:3: ( rule__Qualification__Group__0 )
            {
             before(grammarAccess.getQualificationAccess().getGroup()); 
            // InternalGAME.g:394:3: ( rule__Qualification__Group__0 )
            // InternalGAME.g:394:4: rule__Qualification__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Qualification__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualificationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualification"


    // $ANTLR start "entryRuleEInt"
    // InternalGAME.g:403:1: entryRuleEInt : ruleEInt EOF ;
    public final void entryRuleEInt() throws RecognitionException {
        try {
            // InternalGAME.g:404:1: ( ruleEInt EOF )
            // InternalGAME.g:405:1: ruleEInt EOF
            {
             before(grammarAccess.getEIntRule()); 
            pushFollow(FOLLOW_1);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getEIntRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEInt"


    // $ANTLR start "ruleEInt"
    // InternalGAME.g:412:1: ruleEInt : ( ( rule__EInt__Group__0 ) ) ;
    public final void ruleEInt() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:416:2: ( ( ( rule__EInt__Group__0 ) ) )
            // InternalGAME.g:417:2: ( ( rule__EInt__Group__0 ) )
            {
            // InternalGAME.g:417:2: ( ( rule__EInt__Group__0 ) )
            // InternalGAME.g:418:3: ( rule__EInt__Group__0 )
            {
             before(grammarAccess.getEIntAccess().getGroup()); 
            // InternalGAME.g:419:3: ( rule__EInt__Group__0 )
            // InternalGAME.g:419:4: rule__EInt__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EInt__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEIntAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEInt"


    // $ANTLR start "entryRuleEBoolean"
    // InternalGAME.g:428:1: entryRuleEBoolean : ruleEBoolean EOF ;
    public final void entryRuleEBoolean() throws RecognitionException {
        try {
            // InternalGAME.g:429:1: ( ruleEBoolean EOF )
            // InternalGAME.g:430:1: ruleEBoolean EOF
            {
             before(grammarAccess.getEBooleanRule()); 
            pushFollow(FOLLOW_1);
            ruleEBoolean();

            state._fsp--;

             after(grammarAccess.getEBooleanRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEBoolean"


    // $ANTLR start "ruleEBoolean"
    // InternalGAME.g:437:1: ruleEBoolean : ( ( rule__EBoolean__Alternatives ) ) ;
    public final void ruleEBoolean() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:441:2: ( ( ( rule__EBoolean__Alternatives ) ) )
            // InternalGAME.g:442:2: ( ( rule__EBoolean__Alternatives ) )
            {
            // InternalGAME.g:442:2: ( ( rule__EBoolean__Alternatives ) )
            // InternalGAME.g:443:3: ( rule__EBoolean__Alternatives )
            {
             before(grammarAccess.getEBooleanAccess().getAlternatives()); 
            // InternalGAME.g:444:3: ( rule__EBoolean__Alternatives )
            // InternalGAME.g:444:4: rule__EBoolean__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EBoolean__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEBooleanAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEBoolean"


    // $ANTLR start "ruleEtatVisibilite"
    // InternalGAME.g:453:1: ruleEtatVisibilite : ( ( rule__EtatVisibilite__Alternatives ) ) ;
    public final void ruleEtatVisibilite() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:457:1: ( ( ( rule__EtatVisibilite__Alternatives ) ) )
            // InternalGAME.g:458:2: ( ( rule__EtatVisibilite__Alternatives ) )
            {
            // InternalGAME.g:458:2: ( ( rule__EtatVisibilite__Alternatives ) )
            // InternalGAME.g:459:3: ( rule__EtatVisibilite__Alternatives )
            {
             before(grammarAccess.getEtatVisibiliteAccess().getAlternatives()); 
            // InternalGAME.g:460:3: ( rule__EtatVisibilite__Alternatives )
            // InternalGAME.g:460:4: rule__EtatVisibilite__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EtatVisibilite__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEtatVisibiliteAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEtatVisibilite"


    // $ANTLR start "ruleEtatChemin"
    // InternalGAME.g:469:1: ruleEtatChemin : ( ( rule__EtatChemin__Alternatives ) ) ;
    public final void ruleEtatChemin() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:473:1: ( ( ( rule__EtatChemin__Alternatives ) ) )
            // InternalGAME.g:474:2: ( ( rule__EtatChemin__Alternatives ) )
            {
            // InternalGAME.g:474:2: ( ( rule__EtatChemin__Alternatives ) )
            // InternalGAME.g:475:3: ( rule__EtatChemin__Alternatives )
            {
             before(grammarAccess.getEtatCheminAccess().getAlternatives()); 
            // InternalGAME.g:476:3: ( rule__EtatChemin__Alternatives )
            // InternalGAME.g:476:4: rule__EtatChemin__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EtatChemin__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEtatCheminAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEtatChemin"


    // $ANTLR start "ruleEtatActivite"
    // InternalGAME.g:485:1: ruleEtatActivite : ( ( rule__EtatActivite__Alternatives ) ) ;
    public final void ruleEtatActivite() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:489:1: ( ( ( rule__EtatActivite__Alternatives ) ) )
            // InternalGAME.g:490:2: ( ( rule__EtatActivite__Alternatives ) )
            {
            // InternalGAME.g:490:2: ( ( rule__EtatActivite__Alternatives ) )
            // InternalGAME.g:491:3: ( rule__EtatActivite__Alternatives )
            {
             before(grammarAccess.getEtatActiviteAccess().getAlternatives()); 
            // InternalGAME.g:492:3: ( rule__EtatActivite__Alternatives )
            // InternalGAME.g:492:4: rule__EtatActivite__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EtatActivite__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEtatActiviteAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEtatActivite"


    // $ANTLR start "rule__EString__Alternatives"
    // InternalGAME.g:500:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:504:1: ( ( RULE_STRING ) | ( RULE_ID ) )
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
                    // InternalGAME.g:505:2: ( RULE_STRING )
                    {
                    // InternalGAME.g:505:2: ( RULE_STRING )
                    // InternalGAME.g:506:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalGAME.g:511:2: ( RULE_ID )
                    {
                    // InternalGAME.g:511:2: ( RULE_ID )
                    // InternalGAME.g:512:3: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EString__Alternatives"


    // $ANTLR start "rule__EBoolean__Alternatives"
    // InternalGAME.g:521:1: rule__EBoolean__Alternatives : ( ( 'true' ) | ( 'false' ) );
    public final void rule__EBoolean__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:525:1: ( ( 'true' ) | ( 'false' ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            else if ( (LA2_0==12) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalGAME.g:526:2: ( 'true' )
                    {
                    // InternalGAME.g:526:2: ( 'true' )
                    // InternalGAME.g:527:3: 'true'
                    {
                     before(grammarAccess.getEBooleanAccess().getTrueKeyword_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getEBooleanAccess().getTrueKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalGAME.g:532:2: ( 'false' )
                    {
                    // InternalGAME.g:532:2: ( 'false' )
                    // InternalGAME.g:533:3: 'false'
                    {
                     before(grammarAccess.getEBooleanAccess().getFalseKeyword_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getEBooleanAccess().getFalseKeyword_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EBoolean__Alternatives"


    // $ANTLR start "rule__EtatVisibilite__Alternatives"
    // InternalGAME.g:542:1: rule__EtatVisibilite__Alternatives : ( ( ( 'visible' ) ) | ( ( 'non visible' ) ) );
    public final void rule__EtatVisibilite__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:546:1: ( ( ( 'visible' ) ) | ( ( 'non visible' ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            else if ( (LA3_0==14) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalGAME.g:547:2: ( ( 'visible' ) )
                    {
                    // InternalGAME.g:547:2: ( ( 'visible' ) )
                    // InternalGAME.g:548:3: ( 'visible' )
                    {
                     before(grammarAccess.getEtatVisibiliteAccess().getVisibleEnumLiteralDeclaration_0()); 
                    // InternalGAME.g:549:3: ( 'visible' )
                    // InternalGAME.g:549:4: 'visible'
                    {
                    match(input,13,FOLLOW_2); 

                    }

                     after(grammarAccess.getEtatVisibiliteAccess().getVisibleEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalGAME.g:553:2: ( ( 'non visible' ) )
                    {
                    // InternalGAME.g:553:2: ( ( 'non visible' ) )
                    // InternalGAME.g:554:3: ( 'non visible' )
                    {
                     before(grammarAccess.getEtatVisibiliteAccess().getNonvisibleEnumLiteralDeclaration_1()); 
                    // InternalGAME.g:555:3: ( 'non visible' )
                    // InternalGAME.g:555:4: 'non visible'
                    {
                    match(input,14,FOLLOW_2); 

                    }

                     after(grammarAccess.getEtatVisibiliteAccess().getNonvisibleEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EtatVisibilite__Alternatives"


    // $ANTLR start "rule__EtatChemin__Alternatives"
    // InternalGAME.g:563:1: rule__EtatChemin__Alternatives : ( ( ( 'ouvert' ) ) | ( ( 'ferme' ) ) );
    public final void rule__EtatChemin__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:567:1: ( ( ( 'ouvert' ) ) | ( ( 'ferme' ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            else if ( (LA4_0==16) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalGAME.g:568:2: ( ( 'ouvert' ) )
                    {
                    // InternalGAME.g:568:2: ( ( 'ouvert' ) )
                    // InternalGAME.g:569:3: ( 'ouvert' )
                    {
                     before(grammarAccess.getEtatCheminAccess().getOuvertEnumLiteralDeclaration_0()); 
                    // InternalGAME.g:570:3: ( 'ouvert' )
                    // InternalGAME.g:570:4: 'ouvert'
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getEtatCheminAccess().getOuvertEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalGAME.g:574:2: ( ( 'ferme' ) )
                    {
                    // InternalGAME.g:574:2: ( ( 'ferme' ) )
                    // InternalGAME.g:575:3: ( 'ferme' )
                    {
                     before(grammarAccess.getEtatCheminAccess().getFermeEnumLiteralDeclaration_1()); 
                    // InternalGAME.g:576:3: ( 'ferme' )
                    // InternalGAME.g:576:4: 'ferme'
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getEtatCheminAccess().getFermeEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EtatChemin__Alternatives"


    // $ANTLR start "rule__EtatActivite__Alternatives"
    // InternalGAME.g:584:1: rule__EtatActivite__Alternatives : ( ( ( 'actif' ) ) | ( ( 'inactif' ) ) );
    public final void rule__EtatActivite__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:588:1: ( ( ( 'actif' ) ) | ( ( 'inactif' ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            else if ( (LA5_0==18) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalGAME.g:589:2: ( ( 'actif' ) )
                    {
                    // InternalGAME.g:589:2: ( ( 'actif' ) )
                    // InternalGAME.g:590:3: ( 'actif' )
                    {
                     before(grammarAccess.getEtatActiviteAccess().getActifEnumLiteralDeclaration_0()); 
                    // InternalGAME.g:591:3: ( 'actif' )
                    // InternalGAME.g:591:4: 'actif'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getEtatActiviteAccess().getActifEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalGAME.g:595:2: ( ( 'inactif' ) )
                    {
                    // InternalGAME.g:595:2: ( ( 'inactif' ) )
                    // InternalGAME.g:596:3: ( 'inactif' )
                    {
                     before(grammarAccess.getEtatActiviteAccess().getInactifEnumLiteralDeclaration_1()); 
                    // InternalGAME.g:597:3: ( 'inactif' )
                    // InternalGAME.g:597:4: 'inactif'
                    {
                    match(input,18,FOLLOW_2); 

                    }

                     after(grammarAccess.getEtatActiviteAccess().getInactifEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EtatActivite__Alternatives"


    // $ANTLR start "rule__Game__Group__0"
    // InternalGAME.g:605:1: rule__Game__Group__0 : rule__Game__Group__0__Impl rule__Game__Group__1 ;
    public final void rule__Game__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:609:1: ( rule__Game__Group__0__Impl rule__Game__Group__1 )
            // InternalGAME.g:610:2: rule__Game__Group__0__Impl rule__Game__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Game__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__0"


    // $ANTLR start "rule__Game__Group__0__Impl"
    // InternalGAME.g:617:1: rule__Game__Group__0__Impl : ( 'game' ) ;
    public final void rule__Game__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:621:1: ( ( 'game' ) )
            // InternalGAME.g:622:1: ( 'game' )
            {
            // InternalGAME.g:622:1: ( 'game' )
            // InternalGAME.g:623:2: 'game'
            {
             before(grammarAccess.getGameAccess().getGameKeyword_0()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getGameKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__0__Impl"


    // $ANTLR start "rule__Game__Group__1"
    // InternalGAME.g:632:1: rule__Game__Group__1 : rule__Game__Group__1__Impl rule__Game__Group__2 ;
    public final void rule__Game__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:636:1: ( rule__Game__Group__1__Impl rule__Game__Group__2 )
            // InternalGAME.g:637:2: rule__Game__Group__1__Impl rule__Game__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Game__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__1"


    // $ANTLR start "rule__Game__Group__1__Impl"
    // InternalGAME.g:644:1: rule__Game__Group__1__Impl : ( ( rule__Game__NameAssignment_1 ) ) ;
    public final void rule__Game__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:648:1: ( ( ( rule__Game__NameAssignment_1 ) ) )
            // InternalGAME.g:649:1: ( ( rule__Game__NameAssignment_1 ) )
            {
            // InternalGAME.g:649:1: ( ( rule__Game__NameAssignment_1 ) )
            // InternalGAME.g:650:2: ( rule__Game__NameAssignment_1 )
            {
             before(grammarAccess.getGameAccess().getNameAssignment_1()); 
            // InternalGAME.g:651:2: ( rule__Game__NameAssignment_1 )
            // InternalGAME.g:651:3: rule__Game__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Game__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getGameAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__1__Impl"


    // $ANTLR start "rule__Game__Group__2"
    // InternalGAME.g:659:1: rule__Game__Group__2 : rule__Game__Group__2__Impl rule__Game__Group__3 ;
    public final void rule__Game__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:663:1: ( rule__Game__Group__2__Impl rule__Game__Group__3 )
            // InternalGAME.g:664:2: rule__Game__Group__2__Impl rule__Game__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__Game__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__2"


    // $ANTLR start "rule__Game__Group__2__Impl"
    // InternalGAME.g:671:1: rule__Game__Group__2__Impl : ( '{' ) ;
    public final void rule__Game__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:675:1: ( ( '{' ) )
            // InternalGAME.g:676:1: ( '{' )
            {
            // InternalGAME.g:676:1: ( '{' )
            // InternalGAME.g:677:2: '{'
            {
             before(grammarAccess.getGameAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__2__Impl"


    // $ANTLR start "rule__Game__Group__3"
    // InternalGAME.g:686:1: rule__Game__Group__3 : rule__Game__Group__3__Impl rule__Game__Group__4 ;
    public final void rule__Game__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:690:1: ( rule__Game__Group__3__Impl rule__Game__Group__4 )
            // InternalGAME.g:691:2: rule__Game__Group__3__Impl rule__Game__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__Game__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__3"


    // $ANTLR start "rule__Game__Group__3__Impl"
    // InternalGAME.g:698:1: rule__Game__Group__3__Impl : ( ( rule__Game__ExplorateurAssignment_3 ) ) ;
    public final void rule__Game__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:702:1: ( ( ( rule__Game__ExplorateurAssignment_3 ) ) )
            // InternalGAME.g:703:1: ( ( rule__Game__ExplorateurAssignment_3 ) )
            {
            // InternalGAME.g:703:1: ( ( rule__Game__ExplorateurAssignment_3 ) )
            // InternalGAME.g:704:2: ( rule__Game__ExplorateurAssignment_3 )
            {
             before(grammarAccess.getGameAccess().getExplorateurAssignment_3()); 
            // InternalGAME.g:705:2: ( rule__Game__ExplorateurAssignment_3 )
            // InternalGAME.g:705:3: rule__Game__ExplorateurAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Game__ExplorateurAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getGameAccess().getExplorateurAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__3__Impl"


    // $ANTLR start "rule__Game__Group__4"
    // InternalGAME.g:713:1: rule__Game__Group__4 : rule__Game__Group__4__Impl rule__Game__Group__5 ;
    public final void rule__Game__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:717:1: ( rule__Game__Group__4__Impl rule__Game__Group__5 )
            // InternalGAME.g:718:2: rule__Game__Group__4__Impl rule__Game__Group__5
            {
            pushFollow(FOLLOW_7);
            rule__Game__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__4"


    // $ANTLR start "rule__Game__Group__4__Impl"
    // InternalGAME.g:725:1: rule__Game__Group__4__Impl : ( ( rule__Game__TerritoireAssignment_4 ) ) ;
    public final void rule__Game__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:729:1: ( ( ( rule__Game__TerritoireAssignment_4 ) ) )
            // InternalGAME.g:730:1: ( ( rule__Game__TerritoireAssignment_4 ) )
            {
            // InternalGAME.g:730:1: ( ( rule__Game__TerritoireAssignment_4 ) )
            // InternalGAME.g:731:2: ( rule__Game__TerritoireAssignment_4 )
            {
             before(grammarAccess.getGameAccess().getTerritoireAssignment_4()); 
            // InternalGAME.g:732:2: ( rule__Game__TerritoireAssignment_4 )
            // InternalGAME.g:732:3: rule__Game__TerritoireAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Game__TerritoireAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getGameAccess().getTerritoireAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__4__Impl"


    // $ANTLR start "rule__Game__Group__5"
    // InternalGAME.g:740:1: rule__Game__Group__5 : rule__Game__Group__5__Impl ;
    public final void rule__Game__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:744:1: ( rule__Game__Group__5__Impl )
            // InternalGAME.g:745:2: rule__Game__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Game__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__5"


    // $ANTLR start "rule__Game__Group__5__Impl"
    // InternalGAME.g:751:1: rule__Game__Group__5__Impl : ( '}' ) ;
    public final void rule__Game__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:755:1: ( ( '}' ) )
            // InternalGAME.g:756:1: ( '}' )
            {
            // InternalGAME.g:756:1: ( '}' )
            // InternalGAME.g:757:2: '}'
            {
             before(grammarAccess.getGameAccess().getRightCurlyBracketKeyword_5()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__5__Impl"


    // $ANTLR start "rule__Explorateur__Group__0"
    // InternalGAME.g:767:1: rule__Explorateur__Group__0 : rule__Explorateur__Group__0__Impl rule__Explorateur__Group__1 ;
    public final void rule__Explorateur__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:771:1: ( rule__Explorateur__Group__0__Impl rule__Explorateur__Group__1 )
            // InternalGAME.g:772:2: rule__Explorateur__Group__0__Impl rule__Explorateur__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Explorateur__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Explorateur__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Explorateur__Group__0"


    // $ANTLR start "rule__Explorateur__Group__0__Impl"
    // InternalGAME.g:779:1: rule__Explorateur__Group__0__Impl : ( 'explorateur' ) ;
    public final void rule__Explorateur__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:783:1: ( ( 'explorateur' ) )
            // InternalGAME.g:784:1: ( 'explorateur' )
            {
            // InternalGAME.g:784:1: ( 'explorateur' )
            // InternalGAME.g:785:2: 'explorateur'
            {
             before(grammarAccess.getExplorateurAccess().getExplorateurKeyword_0()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getExplorateurAccess().getExplorateurKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Explorateur__Group__0__Impl"


    // $ANTLR start "rule__Explorateur__Group__1"
    // InternalGAME.g:794:1: rule__Explorateur__Group__1 : rule__Explorateur__Group__1__Impl rule__Explorateur__Group__2 ;
    public final void rule__Explorateur__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:798:1: ( rule__Explorateur__Group__1__Impl rule__Explorateur__Group__2 )
            // InternalGAME.g:799:2: rule__Explorateur__Group__1__Impl rule__Explorateur__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Explorateur__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Explorateur__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Explorateur__Group__1"


    // $ANTLR start "rule__Explorateur__Group__1__Impl"
    // InternalGAME.g:806:1: rule__Explorateur__Group__1__Impl : ( ( rule__Explorateur__NameAssignment_1 ) ) ;
    public final void rule__Explorateur__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:810:1: ( ( ( rule__Explorateur__NameAssignment_1 ) ) )
            // InternalGAME.g:811:1: ( ( rule__Explorateur__NameAssignment_1 ) )
            {
            // InternalGAME.g:811:1: ( ( rule__Explorateur__NameAssignment_1 ) )
            // InternalGAME.g:812:2: ( rule__Explorateur__NameAssignment_1 )
            {
             before(grammarAccess.getExplorateurAccess().getNameAssignment_1()); 
            // InternalGAME.g:813:2: ( rule__Explorateur__NameAssignment_1 )
            // InternalGAME.g:813:3: rule__Explorateur__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Explorateur__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getExplorateurAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Explorateur__Group__1__Impl"


    // $ANTLR start "rule__Explorateur__Group__2"
    // InternalGAME.g:821:1: rule__Explorateur__Group__2 : rule__Explorateur__Group__2__Impl rule__Explorateur__Group__3 ;
    public final void rule__Explorateur__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:825:1: ( rule__Explorateur__Group__2__Impl rule__Explorateur__Group__3 )
            // InternalGAME.g:826:2: rule__Explorateur__Group__2__Impl rule__Explorateur__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__Explorateur__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Explorateur__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Explorateur__Group__2"


    // $ANTLR start "rule__Explorateur__Group__2__Impl"
    // InternalGAME.g:833:1: rule__Explorateur__Group__2__Impl : ( '{' ) ;
    public final void rule__Explorateur__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:837:1: ( ( '{' ) )
            // InternalGAME.g:838:1: ( '{' )
            {
            // InternalGAME.g:838:1: ( '{' )
            // InternalGAME.g:839:2: '{'
            {
             before(grammarAccess.getExplorateurAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getExplorateurAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Explorateur__Group__2__Impl"


    // $ANTLR start "rule__Explorateur__Group__3"
    // InternalGAME.g:848:1: rule__Explorateur__Group__3 : rule__Explorateur__Group__3__Impl rule__Explorateur__Group__4 ;
    public final void rule__Explorateur__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:852:1: ( rule__Explorateur__Group__3__Impl rule__Explorateur__Group__4 )
            // InternalGAME.g:853:2: rule__Explorateur__Group__3__Impl rule__Explorateur__Group__4
            {
            pushFollow(FOLLOW_9);
            rule__Explorateur__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Explorateur__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Explorateur__Group__3"


    // $ANTLR start "rule__Explorateur__Group__3__Impl"
    // InternalGAME.g:860:1: rule__Explorateur__Group__3__Impl : ( 'objets' ) ;
    public final void rule__Explorateur__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:864:1: ( ( 'objets' ) )
            // InternalGAME.g:865:1: ( 'objets' )
            {
            // InternalGAME.g:865:1: ( 'objets' )
            // InternalGAME.g:866:2: 'objets'
            {
             before(grammarAccess.getExplorateurAccess().getObjetsKeyword_3()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getExplorateurAccess().getObjetsKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Explorateur__Group__3__Impl"


    // $ANTLR start "rule__Explorateur__Group__4"
    // InternalGAME.g:875:1: rule__Explorateur__Group__4 : rule__Explorateur__Group__4__Impl rule__Explorateur__Group__5 ;
    public final void rule__Explorateur__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:879:1: ( rule__Explorateur__Group__4__Impl rule__Explorateur__Group__5 )
            // InternalGAME.g:880:2: rule__Explorateur__Group__4__Impl rule__Explorateur__Group__5
            {
            pushFollow(FOLLOW_9);
            rule__Explorateur__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Explorateur__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Explorateur__Group__4"


    // $ANTLR start "rule__Explorateur__Group__4__Impl"
    // InternalGAME.g:887:1: rule__Explorateur__Group__4__Impl : ( ( rule__Explorateur__ObjetsAssignment_4 )* ) ;
    public final void rule__Explorateur__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:891:1: ( ( ( rule__Explorateur__ObjetsAssignment_4 )* ) )
            // InternalGAME.g:892:1: ( ( rule__Explorateur__ObjetsAssignment_4 )* )
            {
            // InternalGAME.g:892:1: ( ( rule__Explorateur__ObjetsAssignment_4 )* )
            // InternalGAME.g:893:2: ( rule__Explorateur__ObjetsAssignment_4 )*
            {
             before(grammarAccess.getExplorateurAccess().getObjetsAssignment_4()); 
            // InternalGAME.g:894:2: ( rule__Explorateur__ObjetsAssignment_4 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==28) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalGAME.g:894:3: rule__Explorateur__ObjetsAssignment_4
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Explorateur__ObjetsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getExplorateurAccess().getObjetsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Explorateur__Group__4__Impl"


    // $ANTLR start "rule__Explorateur__Group__5"
    // InternalGAME.g:902:1: rule__Explorateur__Group__5 : rule__Explorateur__Group__5__Impl rule__Explorateur__Group__6 ;
    public final void rule__Explorateur__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:906:1: ( rule__Explorateur__Group__5__Impl rule__Explorateur__Group__6 )
            // InternalGAME.g:907:2: rule__Explorateur__Group__5__Impl rule__Explorateur__Group__6
            {
            pushFollow(FOLLOW_11);
            rule__Explorateur__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Explorateur__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Explorateur__Group__5"


    // $ANTLR start "rule__Explorateur__Group__5__Impl"
    // InternalGAME.g:914:1: rule__Explorateur__Group__5__Impl : ( 'connaisances' ) ;
    public final void rule__Explorateur__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:918:1: ( ( 'connaisances' ) )
            // InternalGAME.g:919:1: ( 'connaisances' )
            {
            // InternalGAME.g:919:1: ( 'connaisances' )
            // InternalGAME.g:920:2: 'connaisances'
            {
             before(grammarAccess.getExplorateurAccess().getConnaisancesKeyword_5()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getExplorateurAccess().getConnaisancesKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Explorateur__Group__5__Impl"


    // $ANTLR start "rule__Explorateur__Group__6"
    // InternalGAME.g:929:1: rule__Explorateur__Group__6 : rule__Explorateur__Group__6__Impl rule__Explorateur__Group__7 ;
    public final void rule__Explorateur__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:933:1: ( rule__Explorateur__Group__6__Impl rule__Explorateur__Group__7 )
            // InternalGAME.g:934:2: rule__Explorateur__Group__6__Impl rule__Explorateur__Group__7
            {
            pushFollow(FOLLOW_11);
            rule__Explorateur__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Explorateur__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Explorateur__Group__6"


    // $ANTLR start "rule__Explorateur__Group__6__Impl"
    // InternalGAME.g:941:1: rule__Explorateur__Group__6__Impl : ( ( rule__Explorateur__ConnaissancesAssignment_6 )* ) ;
    public final void rule__Explorateur__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:945:1: ( ( ( rule__Explorateur__ConnaissancesAssignment_6 )* ) )
            // InternalGAME.g:946:1: ( ( rule__Explorateur__ConnaissancesAssignment_6 )* )
            {
            // InternalGAME.g:946:1: ( ( rule__Explorateur__ConnaissancesAssignment_6 )* )
            // InternalGAME.g:947:2: ( rule__Explorateur__ConnaissancesAssignment_6 )*
            {
             before(grammarAccess.getExplorateurAccess().getConnaissancesAssignment_6()); 
            // InternalGAME.g:948:2: ( rule__Explorateur__ConnaissancesAssignment_6 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==33) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalGAME.g:948:3: rule__Explorateur__ConnaissancesAssignment_6
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__Explorateur__ConnaissancesAssignment_6();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getExplorateurAccess().getConnaissancesAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Explorateur__Group__6__Impl"


    // $ANTLR start "rule__Explorateur__Group__7"
    // InternalGAME.g:956:1: rule__Explorateur__Group__7 : rule__Explorateur__Group__7__Impl rule__Explorateur__Group__8 ;
    public final void rule__Explorateur__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:960:1: ( rule__Explorateur__Group__7__Impl rule__Explorateur__Group__8 )
            // InternalGAME.g:961:2: rule__Explorateur__Group__7__Impl rule__Explorateur__Group__8
            {
            pushFollow(FOLLOW_3);
            rule__Explorateur__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Explorateur__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Explorateur__Group__7"


    // $ANTLR start "rule__Explorateur__Group__7__Impl"
    // InternalGAME.g:968:1: rule__Explorateur__Group__7__Impl : ( 'lieuCourant' ) ;
    public final void rule__Explorateur__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:972:1: ( ( 'lieuCourant' ) )
            // InternalGAME.g:973:1: ( 'lieuCourant' )
            {
            // InternalGAME.g:973:1: ( 'lieuCourant' )
            // InternalGAME.g:974:2: 'lieuCourant'
            {
             before(grammarAccess.getExplorateurAccess().getLieuCourantKeyword_7()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getExplorateurAccess().getLieuCourantKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Explorateur__Group__7__Impl"


    // $ANTLR start "rule__Explorateur__Group__8"
    // InternalGAME.g:983:1: rule__Explorateur__Group__8 : rule__Explorateur__Group__8__Impl rule__Explorateur__Group__9 ;
    public final void rule__Explorateur__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:987:1: ( rule__Explorateur__Group__8__Impl rule__Explorateur__Group__9 )
            // InternalGAME.g:988:2: rule__Explorateur__Group__8__Impl rule__Explorateur__Group__9
            {
            pushFollow(FOLLOW_13);
            rule__Explorateur__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Explorateur__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Explorateur__Group__8"


    // $ANTLR start "rule__Explorateur__Group__8__Impl"
    // InternalGAME.g:995:1: rule__Explorateur__Group__8__Impl : ( ( rule__Explorateur__LieuCourantAssignment_8 ) ) ;
    public final void rule__Explorateur__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:999:1: ( ( ( rule__Explorateur__LieuCourantAssignment_8 ) ) )
            // InternalGAME.g:1000:1: ( ( rule__Explorateur__LieuCourantAssignment_8 ) )
            {
            // InternalGAME.g:1000:1: ( ( rule__Explorateur__LieuCourantAssignment_8 ) )
            // InternalGAME.g:1001:2: ( rule__Explorateur__LieuCourantAssignment_8 )
            {
             before(grammarAccess.getExplorateurAccess().getLieuCourantAssignment_8()); 
            // InternalGAME.g:1002:2: ( rule__Explorateur__LieuCourantAssignment_8 )
            // InternalGAME.g:1002:3: rule__Explorateur__LieuCourantAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__Explorateur__LieuCourantAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getExplorateurAccess().getLieuCourantAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Explorateur__Group__8__Impl"


    // $ANTLR start "rule__Explorateur__Group__9"
    // InternalGAME.g:1010:1: rule__Explorateur__Group__9 : rule__Explorateur__Group__9__Impl rule__Explorateur__Group__10 ;
    public final void rule__Explorateur__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1014:1: ( rule__Explorateur__Group__9__Impl rule__Explorateur__Group__10 )
            // InternalGAME.g:1015:2: rule__Explorateur__Group__9__Impl rule__Explorateur__Group__10
            {
            pushFollow(FOLLOW_14);
            rule__Explorateur__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Explorateur__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Explorateur__Group__9"


    // $ANTLR start "rule__Explorateur__Group__9__Impl"
    // InternalGAME.g:1022:1: rule__Explorateur__Group__9__Impl : ( 'lieuxExplores' ) ;
    public final void rule__Explorateur__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1026:1: ( ( 'lieuxExplores' ) )
            // InternalGAME.g:1027:1: ( 'lieuxExplores' )
            {
            // InternalGAME.g:1027:1: ( 'lieuxExplores' )
            // InternalGAME.g:1028:2: 'lieuxExplores'
            {
             before(grammarAccess.getExplorateurAccess().getLieuxExploresKeyword_9()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getExplorateurAccess().getLieuxExploresKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Explorateur__Group__9__Impl"


    // $ANTLR start "rule__Explorateur__Group__10"
    // InternalGAME.g:1037:1: rule__Explorateur__Group__10 : rule__Explorateur__Group__10__Impl rule__Explorateur__Group__11 ;
    public final void rule__Explorateur__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1041:1: ( rule__Explorateur__Group__10__Impl rule__Explorateur__Group__11 )
            // InternalGAME.g:1042:2: rule__Explorateur__Group__10__Impl rule__Explorateur__Group__11
            {
            pushFollow(FOLLOW_14);
            rule__Explorateur__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Explorateur__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Explorateur__Group__10"


    // $ANTLR start "rule__Explorateur__Group__10__Impl"
    // InternalGAME.g:1049:1: rule__Explorateur__Group__10__Impl : ( ( rule__Explorateur__LieuExploresAssignment_10 )* ) ;
    public final void rule__Explorateur__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1053:1: ( ( ( rule__Explorateur__LieuExploresAssignment_10 )* ) )
            // InternalGAME.g:1054:1: ( ( rule__Explorateur__LieuExploresAssignment_10 )* )
            {
            // InternalGAME.g:1054:1: ( ( rule__Explorateur__LieuExploresAssignment_10 )* )
            // InternalGAME.g:1055:2: ( rule__Explorateur__LieuExploresAssignment_10 )*
            {
             before(grammarAccess.getExplorateurAccess().getLieuExploresAssignment_10()); 
            // InternalGAME.g:1056:2: ( rule__Explorateur__LieuExploresAssignment_10 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalGAME.g:1056:3: rule__Explorateur__LieuExploresAssignment_10
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__Explorateur__LieuExploresAssignment_10();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getExplorateurAccess().getLieuExploresAssignment_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Explorateur__Group__10__Impl"


    // $ANTLR start "rule__Explorateur__Group__11"
    // InternalGAME.g:1064:1: rule__Explorateur__Group__11 : rule__Explorateur__Group__11__Impl rule__Explorateur__Group__12 ;
    public final void rule__Explorateur__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1068:1: ( rule__Explorateur__Group__11__Impl rule__Explorateur__Group__12 )
            // InternalGAME.g:1069:2: rule__Explorateur__Group__11__Impl rule__Explorateur__Group__12
            {
            pushFollow(FOLLOW_16);
            rule__Explorateur__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Explorateur__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Explorateur__Group__11"


    // $ANTLR start "rule__Explorateur__Group__11__Impl"
    // InternalGAME.g:1076:1: rule__Explorateur__Group__11__Impl : ( 'limiteTaille' ) ;
    public final void rule__Explorateur__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1080:1: ( ( 'limiteTaille' ) )
            // InternalGAME.g:1081:1: ( 'limiteTaille' )
            {
            // InternalGAME.g:1081:1: ( 'limiteTaille' )
            // InternalGAME.g:1082:2: 'limiteTaille'
            {
             before(grammarAccess.getExplorateurAccess().getLimiteTailleKeyword_11()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getExplorateurAccess().getLimiteTailleKeyword_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Explorateur__Group__11__Impl"


    // $ANTLR start "rule__Explorateur__Group__12"
    // InternalGAME.g:1091:1: rule__Explorateur__Group__12 : rule__Explorateur__Group__12__Impl rule__Explorateur__Group__13 ;
    public final void rule__Explorateur__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1095:1: ( rule__Explorateur__Group__12__Impl rule__Explorateur__Group__13 )
            // InternalGAME.g:1096:2: rule__Explorateur__Group__12__Impl rule__Explorateur__Group__13
            {
            pushFollow(FOLLOW_7);
            rule__Explorateur__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Explorateur__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Explorateur__Group__12"


    // $ANTLR start "rule__Explorateur__Group__12__Impl"
    // InternalGAME.g:1103:1: rule__Explorateur__Group__12__Impl : ( ( rule__Explorateur__LimiteAssignment_12 ) ) ;
    public final void rule__Explorateur__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1107:1: ( ( ( rule__Explorateur__LimiteAssignment_12 ) ) )
            // InternalGAME.g:1108:1: ( ( rule__Explorateur__LimiteAssignment_12 ) )
            {
            // InternalGAME.g:1108:1: ( ( rule__Explorateur__LimiteAssignment_12 ) )
            // InternalGAME.g:1109:2: ( rule__Explorateur__LimiteAssignment_12 )
            {
             before(grammarAccess.getExplorateurAccess().getLimiteAssignment_12()); 
            // InternalGAME.g:1110:2: ( rule__Explorateur__LimiteAssignment_12 )
            // InternalGAME.g:1110:3: rule__Explorateur__LimiteAssignment_12
            {
            pushFollow(FOLLOW_2);
            rule__Explorateur__LimiteAssignment_12();

            state._fsp--;


            }

             after(grammarAccess.getExplorateurAccess().getLimiteAssignment_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Explorateur__Group__12__Impl"


    // $ANTLR start "rule__Explorateur__Group__13"
    // InternalGAME.g:1118:1: rule__Explorateur__Group__13 : rule__Explorateur__Group__13__Impl ;
    public final void rule__Explorateur__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1122:1: ( rule__Explorateur__Group__13__Impl )
            // InternalGAME.g:1123:2: rule__Explorateur__Group__13__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Explorateur__Group__13__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Explorateur__Group__13"


    // $ANTLR start "rule__Explorateur__Group__13__Impl"
    // InternalGAME.g:1129:1: rule__Explorateur__Group__13__Impl : ( '}' ) ;
    public final void rule__Explorateur__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1133:1: ( ( '}' ) )
            // InternalGAME.g:1134:1: ( '}' )
            {
            // InternalGAME.g:1134:1: ( '}' )
            // InternalGAME.g:1135:2: '}'
            {
             before(grammarAccess.getExplorateurAccess().getRightCurlyBracketKeyword_13()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getExplorateurAccess().getRightCurlyBracketKeyword_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Explorateur__Group__13__Impl"


    // $ANTLR start "rule__Objet__Group__0"
    // InternalGAME.g:1145:1: rule__Objet__Group__0 : rule__Objet__Group__0__Impl rule__Objet__Group__1 ;
    public final void rule__Objet__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1149:1: ( rule__Objet__Group__0__Impl rule__Objet__Group__1 )
            // InternalGAME.g:1150:2: rule__Objet__Group__0__Impl rule__Objet__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Objet__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Objet__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Objet__Group__0"


    // $ANTLR start "rule__Objet__Group__0__Impl"
    // InternalGAME.g:1157:1: rule__Objet__Group__0__Impl : ( 'objet' ) ;
    public final void rule__Objet__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1161:1: ( ( 'objet' ) )
            // InternalGAME.g:1162:1: ( 'objet' )
            {
            // InternalGAME.g:1162:1: ( 'objet' )
            // InternalGAME.g:1163:2: 'objet'
            {
             before(grammarAccess.getObjetAccess().getObjetKeyword_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getObjetAccess().getObjetKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Objet__Group__0__Impl"


    // $ANTLR start "rule__Objet__Group__1"
    // InternalGAME.g:1172:1: rule__Objet__Group__1 : rule__Objet__Group__1__Impl rule__Objet__Group__2 ;
    public final void rule__Objet__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1176:1: ( rule__Objet__Group__1__Impl rule__Objet__Group__2 )
            // InternalGAME.g:1177:2: rule__Objet__Group__1__Impl rule__Objet__Group__2
            {
            pushFollow(FOLLOW_17);
            rule__Objet__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Objet__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Objet__Group__1"


    // $ANTLR start "rule__Objet__Group__1__Impl"
    // InternalGAME.g:1184:1: rule__Objet__Group__1__Impl : ( ( rule__Objet__NameAssignment_1 ) ) ;
    public final void rule__Objet__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1188:1: ( ( ( rule__Objet__NameAssignment_1 ) ) )
            // InternalGAME.g:1189:1: ( ( rule__Objet__NameAssignment_1 ) )
            {
            // InternalGAME.g:1189:1: ( ( rule__Objet__NameAssignment_1 ) )
            // InternalGAME.g:1190:2: ( rule__Objet__NameAssignment_1 )
            {
             before(grammarAccess.getObjetAccess().getNameAssignment_1()); 
            // InternalGAME.g:1191:2: ( rule__Objet__NameAssignment_1 )
            // InternalGAME.g:1191:3: rule__Objet__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Objet__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getObjetAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Objet__Group__1__Impl"


    // $ANTLR start "rule__Objet__Group__2"
    // InternalGAME.g:1199:1: rule__Objet__Group__2 : rule__Objet__Group__2__Impl rule__Objet__Group__3 ;
    public final void rule__Objet__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1203:1: ( rule__Objet__Group__2__Impl rule__Objet__Group__3 )
            // InternalGAME.g:1204:2: rule__Objet__Group__2__Impl rule__Objet__Group__3
            {
            pushFollow(FOLLOW_16);
            rule__Objet__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Objet__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Objet__Group__2"


    // $ANTLR start "rule__Objet__Group__2__Impl"
    // InternalGAME.g:1211:1: rule__Objet__Group__2__Impl : ( 'initVal' ) ;
    public final void rule__Objet__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1215:1: ( ( 'initVal' ) )
            // InternalGAME.g:1216:1: ( 'initVal' )
            {
            // InternalGAME.g:1216:1: ( 'initVal' )
            // InternalGAME.g:1217:2: 'initVal'
            {
             before(grammarAccess.getObjetAccess().getInitValKeyword_2()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getObjetAccess().getInitValKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Objet__Group__2__Impl"


    // $ANTLR start "rule__Objet__Group__3"
    // InternalGAME.g:1226:1: rule__Objet__Group__3 : rule__Objet__Group__3__Impl rule__Objet__Group__4 ;
    public final void rule__Objet__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1230:1: ( rule__Objet__Group__3__Impl rule__Objet__Group__4 )
            // InternalGAME.g:1231:2: rule__Objet__Group__3__Impl rule__Objet__Group__4
            {
            pushFollow(FOLLOW_18);
            rule__Objet__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Objet__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Objet__Group__3"


    // $ANTLR start "rule__Objet__Group__3__Impl"
    // InternalGAME.g:1238:1: rule__Objet__Group__3__Impl : ( ( rule__Objet__InitValAssignment_3 ) ) ;
    public final void rule__Objet__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1242:1: ( ( ( rule__Objet__InitValAssignment_3 ) ) )
            // InternalGAME.g:1243:1: ( ( rule__Objet__InitValAssignment_3 ) )
            {
            // InternalGAME.g:1243:1: ( ( rule__Objet__InitValAssignment_3 ) )
            // InternalGAME.g:1244:2: ( rule__Objet__InitValAssignment_3 )
            {
             before(grammarAccess.getObjetAccess().getInitValAssignment_3()); 
            // InternalGAME.g:1245:2: ( rule__Objet__InitValAssignment_3 )
            // InternalGAME.g:1245:3: rule__Objet__InitValAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Objet__InitValAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getObjetAccess().getInitValAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Objet__Group__3__Impl"


    // $ANTLR start "rule__Objet__Group__4"
    // InternalGAME.g:1253:1: rule__Objet__Group__4 : rule__Objet__Group__4__Impl rule__Objet__Group__5 ;
    public final void rule__Objet__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1257:1: ( rule__Objet__Group__4__Impl rule__Objet__Group__5 )
            // InternalGAME.g:1258:2: rule__Objet__Group__4__Impl rule__Objet__Group__5
            {
            pushFollow(FOLLOW_16);
            rule__Objet__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Objet__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Objet__Group__4"


    // $ANTLR start "rule__Objet__Group__4__Impl"
    // InternalGAME.g:1265:1: rule__Objet__Group__4__Impl : ( 'taille' ) ;
    public final void rule__Objet__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1269:1: ( ( 'taille' ) )
            // InternalGAME.g:1270:1: ( 'taille' )
            {
            // InternalGAME.g:1270:1: ( 'taille' )
            // InternalGAME.g:1271:2: 'taille'
            {
             before(grammarAccess.getObjetAccess().getTailleKeyword_4()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getObjetAccess().getTailleKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Objet__Group__4__Impl"


    // $ANTLR start "rule__Objet__Group__5"
    // InternalGAME.g:1280:1: rule__Objet__Group__5 : rule__Objet__Group__5__Impl rule__Objet__Group__6 ;
    public final void rule__Objet__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1284:1: ( rule__Objet__Group__5__Impl rule__Objet__Group__6 )
            // InternalGAME.g:1285:2: rule__Objet__Group__5__Impl rule__Objet__Group__6
            {
            pushFollow(FOLLOW_19);
            rule__Objet__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Objet__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Objet__Group__5"


    // $ANTLR start "rule__Objet__Group__5__Impl"
    // InternalGAME.g:1292:1: rule__Objet__Group__5__Impl : ( ( rule__Objet__TailleAssignment_5 ) ) ;
    public final void rule__Objet__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1296:1: ( ( ( rule__Objet__TailleAssignment_5 ) ) )
            // InternalGAME.g:1297:1: ( ( rule__Objet__TailleAssignment_5 ) )
            {
            // InternalGAME.g:1297:1: ( ( rule__Objet__TailleAssignment_5 ) )
            // InternalGAME.g:1298:2: ( rule__Objet__TailleAssignment_5 )
            {
             before(grammarAccess.getObjetAccess().getTailleAssignment_5()); 
            // InternalGAME.g:1299:2: ( rule__Objet__TailleAssignment_5 )
            // InternalGAME.g:1299:3: rule__Objet__TailleAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Objet__TailleAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getObjetAccess().getTailleAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Objet__Group__5__Impl"


    // $ANTLR start "rule__Objet__Group__6"
    // InternalGAME.g:1307:1: rule__Objet__Group__6 : rule__Objet__Group__6__Impl rule__Objet__Group__7 ;
    public final void rule__Objet__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1311:1: ( rule__Objet__Group__6__Impl rule__Objet__Group__7 )
            // InternalGAME.g:1312:2: rule__Objet__Group__6__Impl rule__Objet__Group__7
            {
            pushFollow(FOLLOW_20);
            rule__Objet__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Objet__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Objet__Group__6"


    // $ANTLR start "rule__Objet__Group__6__Impl"
    // InternalGAME.g:1319:1: rule__Objet__Group__6__Impl : ( 'etat' ) ;
    public final void rule__Objet__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1323:1: ( ( 'etat' ) )
            // InternalGAME.g:1324:1: ( 'etat' )
            {
            // InternalGAME.g:1324:1: ( 'etat' )
            // InternalGAME.g:1325:2: 'etat'
            {
             before(grammarAccess.getObjetAccess().getEtatKeyword_6()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getObjetAccess().getEtatKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Objet__Group__6__Impl"


    // $ANTLR start "rule__Objet__Group__7"
    // InternalGAME.g:1334:1: rule__Objet__Group__7 : rule__Objet__Group__7__Impl rule__Objet__Group__8 ;
    public final void rule__Objet__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1338:1: ( rule__Objet__Group__7__Impl rule__Objet__Group__8 )
            // InternalGAME.g:1339:2: rule__Objet__Group__7__Impl rule__Objet__Group__8
            {
            pushFollow(FOLLOW_21);
            rule__Objet__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Objet__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Objet__Group__7"


    // $ANTLR start "rule__Objet__Group__7__Impl"
    // InternalGAME.g:1346:1: rule__Objet__Group__7__Impl : ( ( rule__Objet__EtatAssignment_7 ) ) ;
    public final void rule__Objet__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1350:1: ( ( ( rule__Objet__EtatAssignment_7 ) ) )
            // InternalGAME.g:1351:1: ( ( rule__Objet__EtatAssignment_7 ) )
            {
            // InternalGAME.g:1351:1: ( ( rule__Objet__EtatAssignment_7 ) )
            // InternalGAME.g:1352:2: ( rule__Objet__EtatAssignment_7 )
            {
             before(grammarAccess.getObjetAccess().getEtatAssignment_7()); 
            // InternalGAME.g:1353:2: ( rule__Objet__EtatAssignment_7 )
            // InternalGAME.g:1353:3: rule__Objet__EtatAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__Objet__EtatAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getObjetAccess().getEtatAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Objet__Group__7__Impl"


    // $ANTLR start "rule__Objet__Group__8"
    // InternalGAME.g:1361:1: rule__Objet__Group__8 : rule__Objet__Group__8__Impl rule__Objet__Group__9 ;
    public final void rule__Objet__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1365:1: ( rule__Objet__Group__8__Impl rule__Objet__Group__9 )
            // InternalGAME.g:1366:2: rule__Objet__Group__8__Impl rule__Objet__Group__9
            {
            pushFollow(FOLLOW_21);
            rule__Objet__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Objet__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Objet__Group__8"


    // $ANTLR start "rule__Objet__Group__8__Impl"
    // InternalGAME.g:1373:1: rule__Objet__Group__8__Impl : ( ( rule__Objet__Group_8__0 )? ) ;
    public final void rule__Objet__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1377:1: ( ( ( rule__Objet__Group_8__0 )? ) )
            // InternalGAME.g:1378:1: ( ( rule__Objet__Group_8__0 )? )
            {
            // InternalGAME.g:1378:1: ( ( rule__Objet__Group_8__0 )? )
            // InternalGAME.g:1379:2: ( rule__Objet__Group_8__0 )?
            {
             before(grammarAccess.getObjetAccess().getGroup_8()); 
            // InternalGAME.g:1380:2: ( rule__Objet__Group_8__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==32) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalGAME.g:1380:3: rule__Objet__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Objet__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getObjetAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Objet__Group__8__Impl"


    // $ANTLR start "rule__Objet__Group__9"
    // InternalGAME.g:1388:1: rule__Objet__Group__9 : rule__Objet__Group__9__Impl ;
    public final void rule__Objet__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1392:1: ( rule__Objet__Group__9__Impl )
            // InternalGAME.g:1393:2: rule__Objet__Group__9__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Objet__Group__9__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Objet__Group__9"


    // $ANTLR start "rule__Objet__Group__9__Impl"
    // InternalGAME.g:1399:1: rule__Objet__Group__9__Impl : ( ( rule__Objet__QualificationAssignment_9 )* ) ;
    public final void rule__Objet__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1403:1: ( ( ( rule__Objet__QualificationAssignment_9 )* ) )
            // InternalGAME.g:1404:1: ( ( rule__Objet__QualificationAssignment_9 )* )
            {
            // InternalGAME.g:1404:1: ( ( rule__Objet__QualificationAssignment_9 )* )
            // InternalGAME.g:1405:2: ( rule__Objet__QualificationAssignment_9 )*
            {
             before(grammarAccess.getObjetAccess().getQualificationAssignment_9()); 
            // InternalGAME.g:1406:2: ( rule__Objet__QualificationAssignment_9 )*
            loop10:
            do {
                int alt10=2;
                alt10 = dfa10.predict(input);
                switch (alt10) {
            	case 1 :
            	    // InternalGAME.g:1406:3: rule__Objet__QualificationAssignment_9
            	    {
            	    pushFollow(FOLLOW_22);
            	    rule__Objet__QualificationAssignment_9();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getObjetAccess().getQualificationAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Objet__Group__9__Impl"


    // $ANTLR start "rule__Objet__Group_8__0"
    // InternalGAME.g:1415:1: rule__Objet__Group_8__0 : rule__Objet__Group_8__0__Impl rule__Objet__Group_8__1 ;
    public final void rule__Objet__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1419:1: ( rule__Objet__Group_8__0__Impl rule__Objet__Group_8__1 )
            // InternalGAME.g:1420:2: rule__Objet__Group_8__0__Impl rule__Objet__Group_8__1
            {
            pushFollow(FOLLOW_23);
            rule__Objet__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Objet__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Objet__Group_8__0"


    // $ANTLR start "rule__Objet__Group_8__0__Impl"
    // InternalGAME.g:1427:1: rule__Objet__Group_8__0__Impl : ( 'obtention' ) ;
    public final void rule__Objet__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1431:1: ( ( 'obtention' ) )
            // InternalGAME.g:1432:1: ( 'obtention' )
            {
            // InternalGAME.g:1432:1: ( 'obtention' )
            // InternalGAME.g:1433:2: 'obtention'
            {
             before(grammarAccess.getObjetAccess().getObtentionKeyword_8_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getObjetAccess().getObtentionKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Objet__Group_8__0__Impl"


    // $ANTLR start "rule__Objet__Group_8__1"
    // InternalGAME.g:1442:1: rule__Objet__Group_8__1 : rule__Objet__Group_8__1__Impl ;
    public final void rule__Objet__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1446:1: ( rule__Objet__Group_8__1__Impl )
            // InternalGAME.g:1447:2: rule__Objet__Group_8__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Objet__Group_8__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Objet__Group_8__1"


    // $ANTLR start "rule__Objet__Group_8__1__Impl"
    // InternalGAME.g:1453:1: rule__Objet__Group_8__1__Impl : ( ( rule__Objet__ConditionAssignment_8_1 ) ) ;
    public final void rule__Objet__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1457:1: ( ( ( rule__Objet__ConditionAssignment_8_1 ) ) )
            // InternalGAME.g:1458:1: ( ( rule__Objet__ConditionAssignment_8_1 ) )
            {
            // InternalGAME.g:1458:1: ( ( rule__Objet__ConditionAssignment_8_1 ) )
            // InternalGAME.g:1459:2: ( rule__Objet__ConditionAssignment_8_1 )
            {
             before(grammarAccess.getObjetAccess().getConditionAssignment_8_1()); 
            // InternalGAME.g:1460:2: ( rule__Objet__ConditionAssignment_8_1 )
            // InternalGAME.g:1460:3: rule__Objet__ConditionAssignment_8_1
            {
            pushFollow(FOLLOW_2);
            rule__Objet__ConditionAssignment_8_1();

            state._fsp--;


            }

             after(grammarAccess.getObjetAccess().getConditionAssignment_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Objet__Group_8__1__Impl"


    // $ANTLR start "rule__Connaissance__Group__0"
    // InternalGAME.g:1469:1: rule__Connaissance__Group__0 : rule__Connaissance__Group__0__Impl rule__Connaissance__Group__1 ;
    public final void rule__Connaissance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1473:1: ( rule__Connaissance__Group__0__Impl rule__Connaissance__Group__1 )
            // InternalGAME.g:1474:2: rule__Connaissance__Group__0__Impl rule__Connaissance__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Connaissance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Connaissance__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Connaissance__Group__0"


    // $ANTLR start "rule__Connaissance__Group__0__Impl"
    // InternalGAME.g:1481:1: rule__Connaissance__Group__0__Impl : ( 'connaissance' ) ;
    public final void rule__Connaissance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1485:1: ( ( 'connaissance' ) )
            // InternalGAME.g:1486:1: ( 'connaissance' )
            {
            // InternalGAME.g:1486:1: ( 'connaissance' )
            // InternalGAME.g:1487:2: 'connaissance'
            {
             before(grammarAccess.getConnaissanceAccess().getConnaissanceKeyword_0()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getConnaissanceAccess().getConnaissanceKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Connaissance__Group__0__Impl"


    // $ANTLR start "rule__Connaissance__Group__1"
    // InternalGAME.g:1496:1: rule__Connaissance__Group__1 : rule__Connaissance__Group__1__Impl rule__Connaissance__Group__2 ;
    public final void rule__Connaissance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1500:1: ( rule__Connaissance__Group__1__Impl rule__Connaissance__Group__2 )
            // InternalGAME.g:1501:2: rule__Connaissance__Group__1__Impl rule__Connaissance__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Connaissance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Connaissance__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Connaissance__Group__1"


    // $ANTLR start "rule__Connaissance__Group__1__Impl"
    // InternalGAME.g:1508:1: rule__Connaissance__Group__1__Impl : ( ( rule__Connaissance__NameAssignment_1 ) ) ;
    public final void rule__Connaissance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1512:1: ( ( ( rule__Connaissance__NameAssignment_1 ) ) )
            // InternalGAME.g:1513:1: ( ( rule__Connaissance__NameAssignment_1 ) )
            {
            // InternalGAME.g:1513:1: ( ( rule__Connaissance__NameAssignment_1 ) )
            // InternalGAME.g:1514:2: ( rule__Connaissance__NameAssignment_1 )
            {
             before(grammarAccess.getConnaissanceAccess().getNameAssignment_1()); 
            // InternalGAME.g:1515:2: ( rule__Connaissance__NameAssignment_1 )
            // InternalGAME.g:1515:3: rule__Connaissance__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Connaissance__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getConnaissanceAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Connaissance__Group__1__Impl"


    // $ANTLR start "rule__Connaissance__Group__2"
    // InternalGAME.g:1523:1: rule__Connaissance__Group__2 : rule__Connaissance__Group__2__Impl rule__Connaissance__Group__3 ;
    public final void rule__Connaissance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1527:1: ( rule__Connaissance__Group__2__Impl rule__Connaissance__Group__3 )
            // InternalGAME.g:1528:2: rule__Connaissance__Group__2__Impl rule__Connaissance__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__Connaissance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Connaissance__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Connaissance__Group__2"


    // $ANTLR start "rule__Connaissance__Group__2__Impl"
    // InternalGAME.g:1535:1: rule__Connaissance__Group__2__Impl : ( '{' ) ;
    public final void rule__Connaissance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1539:1: ( ( '{' ) )
            // InternalGAME.g:1540:1: ( '{' )
            {
            // InternalGAME.g:1540:1: ( '{' )
            // InternalGAME.g:1541:2: '{'
            {
             before(grammarAccess.getConnaissanceAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getConnaissanceAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Connaissance__Group__2__Impl"


    // $ANTLR start "rule__Connaissance__Group__3"
    // InternalGAME.g:1550:1: rule__Connaissance__Group__3 : rule__Connaissance__Group__3__Impl rule__Connaissance__Group__4 ;
    public final void rule__Connaissance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1554:1: ( rule__Connaissance__Group__3__Impl rule__Connaissance__Group__4 )
            // InternalGAME.g:1555:2: rule__Connaissance__Group__3__Impl rule__Connaissance__Group__4
            {
            pushFollow(FOLLOW_24);
            rule__Connaissance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Connaissance__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Connaissance__Group__3"


    // $ANTLR start "rule__Connaissance__Group__3__Impl"
    // InternalGAME.g:1562:1: rule__Connaissance__Group__3__Impl : ( ( rule__Connaissance__QualificationAssignment_3 )* ) ;
    public final void rule__Connaissance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1566:1: ( ( ( rule__Connaissance__QualificationAssignment_3 )* ) )
            // InternalGAME.g:1567:1: ( ( rule__Connaissance__QualificationAssignment_3 )* )
            {
            // InternalGAME.g:1567:1: ( ( rule__Connaissance__QualificationAssignment_3 )* )
            // InternalGAME.g:1568:2: ( rule__Connaissance__QualificationAssignment_3 )*
            {
             before(grammarAccess.getConnaissanceAccess().getQualificationAssignment_3()); 
            // InternalGAME.g:1569:2: ( rule__Connaissance__QualificationAssignment_3 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==69) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalGAME.g:1569:3: rule__Connaissance__QualificationAssignment_3
            	    {
            	    pushFollow(FOLLOW_22);
            	    rule__Connaissance__QualificationAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getConnaissanceAccess().getQualificationAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Connaissance__Group__3__Impl"


    // $ANTLR start "rule__Connaissance__Group__4"
    // InternalGAME.g:1577:1: rule__Connaissance__Group__4 : rule__Connaissance__Group__4__Impl rule__Connaissance__Group__5 ;
    public final void rule__Connaissance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1581:1: ( rule__Connaissance__Group__4__Impl rule__Connaissance__Group__5 )
            // InternalGAME.g:1582:2: rule__Connaissance__Group__4__Impl rule__Connaissance__Group__5
            {
            pushFollow(FOLLOW_24);
            rule__Connaissance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Connaissance__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Connaissance__Group__4"


    // $ANTLR start "rule__Connaissance__Group__4__Impl"
    // InternalGAME.g:1589:1: rule__Connaissance__Group__4__Impl : ( ( rule__Connaissance__Group_4__0 )? ) ;
    public final void rule__Connaissance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1593:1: ( ( ( rule__Connaissance__Group_4__0 )? ) )
            // InternalGAME.g:1594:1: ( ( rule__Connaissance__Group_4__0 )? )
            {
            // InternalGAME.g:1594:1: ( ( rule__Connaissance__Group_4__0 )? )
            // InternalGAME.g:1595:2: ( rule__Connaissance__Group_4__0 )?
            {
             before(grammarAccess.getConnaissanceAccess().getGroup_4()); 
            // InternalGAME.g:1596:2: ( rule__Connaissance__Group_4__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==32) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalGAME.g:1596:3: rule__Connaissance__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Connaissance__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getConnaissanceAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Connaissance__Group__4__Impl"


    // $ANTLR start "rule__Connaissance__Group__5"
    // InternalGAME.g:1604:1: rule__Connaissance__Group__5 : rule__Connaissance__Group__5__Impl rule__Connaissance__Group__6 ;
    public final void rule__Connaissance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1608:1: ( rule__Connaissance__Group__5__Impl rule__Connaissance__Group__6 )
            // InternalGAME.g:1609:2: rule__Connaissance__Group__5__Impl rule__Connaissance__Group__6
            {
            pushFollow(FOLLOW_20);
            rule__Connaissance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Connaissance__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Connaissance__Group__5"


    // $ANTLR start "rule__Connaissance__Group__5__Impl"
    // InternalGAME.g:1616:1: rule__Connaissance__Group__5__Impl : ( 'etat' ) ;
    public final void rule__Connaissance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1620:1: ( ( 'etat' ) )
            // InternalGAME.g:1621:1: ( 'etat' )
            {
            // InternalGAME.g:1621:1: ( 'etat' )
            // InternalGAME.g:1622:2: 'etat'
            {
             before(grammarAccess.getConnaissanceAccess().getEtatKeyword_5()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getConnaissanceAccess().getEtatKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Connaissance__Group__5__Impl"


    // $ANTLR start "rule__Connaissance__Group__6"
    // InternalGAME.g:1631:1: rule__Connaissance__Group__6 : rule__Connaissance__Group__6__Impl rule__Connaissance__Group__7 ;
    public final void rule__Connaissance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1635:1: ( rule__Connaissance__Group__6__Impl rule__Connaissance__Group__7 )
            // InternalGAME.g:1636:2: rule__Connaissance__Group__6__Impl rule__Connaissance__Group__7
            {
            pushFollow(FOLLOW_7);
            rule__Connaissance__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Connaissance__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Connaissance__Group__6"


    // $ANTLR start "rule__Connaissance__Group__6__Impl"
    // InternalGAME.g:1643:1: rule__Connaissance__Group__6__Impl : ( ( rule__Connaissance__EtatAssignment_6 ) ) ;
    public final void rule__Connaissance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1647:1: ( ( ( rule__Connaissance__EtatAssignment_6 ) ) )
            // InternalGAME.g:1648:1: ( ( rule__Connaissance__EtatAssignment_6 ) )
            {
            // InternalGAME.g:1648:1: ( ( rule__Connaissance__EtatAssignment_6 ) )
            // InternalGAME.g:1649:2: ( rule__Connaissance__EtatAssignment_6 )
            {
             before(grammarAccess.getConnaissanceAccess().getEtatAssignment_6()); 
            // InternalGAME.g:1650:2: ( rule__Connaissance__EtatAssignment_6 )
            // InternalGAME.g:1650:3: rule__Connaissance__EtatAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__Connaissance__EtatAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getConnaissanceAccess().getEtatAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Connaissance__Group__6__Impl"


    // $ANTLR start "rule__Connaissance__Group__7"
    // InternalGAME.g:1658:1: rule__Connaissance__Group__7 : rule__Connaissance__Group__7__Impl ;
    public final void rule__Connaissance__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1662:1: ( rule__Connaissance__Group__7__Impl )
            // InternalGAME.g:1663:2: rule__Connaissance__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Connaissance__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Connaissance__Group__7"


    // $ANTLR start "rule__Connaissance__Group__7__Impl"
    // InternalGAME.g:1669:1: rule__Connaissance__Group__7__Impl : ( '}' ) ;
    public final void rule__Connaissance__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1673:1: ( ( '}' ) )
            // InternalGAME.g:1674:1: ( '}' )
            {
            // InternalGAME.g:1674:1: ( '}' )
            // InternalGAME.g:1675:2: '}'
            {
             before(grammarAccess.getConnaissanceAccess().getRightCurlyBracketKeyword_7()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getConnaissanceAccess().getRightCurlyBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Connaissance__Group__7__Impl"


    // $ANTLR start "rule__Connaissance__Group_4__0"
    // InternalGAME.g:1685:1: rule__Connaissance__Group_4__0 : rule__Connaissance__Group_4__0__Impl rule__Connaissance__Group_4__1 ;
    public final void rule__Connaissance__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1689:1: ( rule__Connaissance__Group_4__0__Impl rule__Connaissance__Group_4__1 )
            // InternalGAME.g:1690:2: rule__Connaissance__Group_4__0__Impl rule__Connaissance__Group_4__1
            {
            pushFollow(FOLLOW_23);
            rule__Connaissance__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Connaissance__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Connaissance__Group_4__0"


    // $ANTLR start "rule__Connaissance__Group_4__0__Impl"
    // InternalGAME.g:1697:1: rule__Connaissance__Group_4__0__Impl : ( 'obtention' ) ;
    public final void rule__Connaissance__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1701:1: ( ( 'obtention' ) )
            // InternalGAME.g:1702:1: ( 'obtention' )
            {
            // InternalGAME.g:1702:1: ( 'obtention' )
            // InternalGAME.g:1703:2: 'obtention'
            {
             before(grammarAccess.getConnaissanceAccess().getObtentionKeyword_4_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getConnaissanceAccess().getObtentionKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Connaissance__Group_4__0__Impl"


    // $ANTLR start "rule__Connaissance__Group_4__1"
    // InternalGAME.g:1712:1: rule__Connaissance__Group_4__1 : rule__Connaissance__Group_4__1__Impl ;
    public final void rule__Connaissance__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1716:1: ( rule__Connaissance__Group_4__1__Impl )
            // InternalGAME.g:1717:2: rule__Connaissance__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Connaissance__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Connaissance__Group_4__1"


    // $ANTLR start "rule__Connaissance__Group_4__1__Impl"
    // InternalGAME.g:1723:1: rule__Connaissance__Group_4__1__Impl : ( ( rule__Connaissance__ConditionAssignment_4_1 ) ) ;
    public final void rule__Connaissance__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1727:1: ( ( ( rule__Connaissance__ConditionAssignment_4_1 ) ) )
            // InternalGAME.g:1728:1: ( ( rule__Connaissance__ConditionAssignment_4_1 ) )
            {
            // InternalGAME.g:1728:1: ( ( rule__Connaissance__ConditionAssignment_4_1 ) )
            // InternalGAME.g:1729:2: ( rule__Connaissance__ConditionAssignment_4_1 )
            {
             before(grammarAccess.getConnaissanceAccess().getConditionAssignment_4_1()); 
            // InternalGAME.g:1730:2: ( rule__Connaissance__ConditionAssignment_4_1 )
            // InternalGAME.g:1730:3: rule__Connaissance__ConditionAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Connaissance__ConditionAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getConnaissanceAccess().getConditionAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Connaissance__Group_4__1__Impl"


    // $ANTLR start "rule__Lieu__Group__0"
    // InternalGAME.g:1739:1: rule__Lieu__Group__0 : rule__Lieu__Group__0__Impl rule__Lieu__Group__1 ;
    public final void rule__Lieu__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1743:1: ( rule__Lieu__Group__0__Impl rule__Lieu__Group__1 )
            // InternalGAME.g:1744:2: rule__Lieu__Group__0__Impl rule__Lieu__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Lieu__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lieu__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lieu__Group__0"


    // $ANTLR start "rule__Lieu__Group__0__Impl"
    // InternalGAME.g:1751:1: rule__Lieu__Group__0__Impl : ( 'lieu' ) ;
    public final void rule__Lieu__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1755:1: ( ( 'lieu' ) )
            // InternalGAME.g:1756:1: ( 'lieu' )
            {
            // InternalGAME.g:1756:1: ( 'lieu' )
            // InternalGAME.g:1757:2: 'lieu'
            {
             before(grammarAccess.getLieuAccess().getLieuKeyword_0()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getLieuAccess().getLieuKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lieu__Group__0__Impl"


    // $ANTLR start "rule__Lieu__Group__1"
    // InternalGAME.g:1766:1: rule__Lieu__Group__1 : rule__Lieu__Group__1__Impl rule__Lieu__Group__2 ;
    public final void rule__Lieu__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1770:1: ( rule__Lieu__Group__1__Impl rule__Lieu__Group__2 )
            // InternalGAME.g:1771:2: rule__Lieu__Group__1__Impl rule__Lieu__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Lieu__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lieu__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lieu__Group__1"


    // $ANTLR start "rule__Lieu__Group__1__Impl"
    // InternalGAME.g:1778:1: rule__Lieu__Group__1__Impl : ( ( rule__Lieu__NameAssignment_1 ) ) ;
    public final void rule__Lieu__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1782:1: ( ( ( rule__Lieu__NameAssignment_1 ) ) )
            // InternalGAME.g:1783:1: ( ( rule__Lieu__NameAssignment_1 ) )
            {
            // InternalGAME.g:1783:1: ( ( rule__Lieu__NameAssignment_1 ) )
            // InternalGAME.g:1784:2: ( rule__Lieu__NameAssignment_1 )
            {
             before(grammarAccess.getLieuAccess().getNameAssignment_1()); 
            // InternalGAME.g:1785:2: ( rule__Lieu__NameAssignment_1 )
            // InternalGAME.g:1785:3: rule__Lieu__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Lieu__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getLieuAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lieu__Group__1__Impl"


    // $ANTLR start "rule__Lieu__Group__2"
    // InternalGAME.g:1793:1: rule__Lieu__Group__2 : rule__Lieu__Group__2__Impl rule__Lieu__Group__3 ;
    public final void rule__Lieu__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1797:1: ( rule__Lieu__Group__2__Impl rule__Lieu__Group__3 )
            // InternalGAME.g:1798:2: rule__Lieu__Group__2__Impl rule__Lieu__Group__3
            {
            pushFollow(FOLLOW_25);
            rule__Lieu__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lieu__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lieu__Group__2"


    // $ANTLR start "rule__Lieu__Group__2__Impl"
    // InternalGAME.g:1805:1: rule__Lieu__Group__2__Impl : ( '{' ) ;
    public final void rule__Lieu__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1809:1: ( ( '{' ) )
            // InternalGAME.g:1810:1: ( '{' )
            {
            // InternalGAME.g:1810:1: ( '{' )
            // InternalGAME.g:1811:2: '{'
            {
             before(grammarAccess.getLieuAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getLieuAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lieu__Group__2__Impl"


    // $ANTLR start "rule__Lieu__Group__3"
    // InternalGAME.g:1820:1: rule__Lieu__Group__3 : rule__Lieu__Group__3__Impl rule__Lieu__Group__4 ;
    public final void rule__Lieu__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1824:1: ( rule__Lieu__Group__3__Impl rule__Lieu__Group__4 )
            // InternalGAME.g:1825:2: rule__Lieu__Group__3__Impl rule__Lieu__Group__4
            {
            pushFollow(FOLLOW_26);
            rule__Lieu__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lieu__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lieu__Group__3"


    // $ANTLR start "rule__Lieu__Group__3__Impl"
    // InternalGAME.g:1832:1: rule__Lieu__Group__3__Impl : ( 'personnes' ) ;
    public final void rule__Lieu__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1836:1: ( ( 'personnes' ) )
            // InternalGAME.g:1837:1: ( 'personnes' )
            {
            // InternalGAME.g:1837:1: ( 'personnes' )
            // InternalGAME.g:1838:2: 'personnes'
            {
             before(grammarAccess.getLieuAccess().getPersonnesKeyword_3()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getLieuAccess().getPersonnesKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lieu__Group__3__Impl"


    // $ANTLR start "rule__Lieu__Group__4"
    // InternalGAME.g:1847:1: rule__Lieu__Group__4 : rule__Lieu__Group__4__Impl rule__Lieu__Group__5 ;
    public final void rule__Lieu__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1851:1: ( rule__Lieu__Group__4__Impl rule__Lieu__Group__5 )
            // InternalGAME.g:1852:2: rule__Lieu__Group__4__Impl rule__Lieu__Group__5
            {
            pushFollow(FOLLOW_26);
            rule__Lieu__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lieu__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lieu__Group__4"


    // $ANTLR start "rule__Lieu__Group__4__Impl"
    // InternalGAME.g:1859:1: rule__Lieu__Group__4__Impl : ( ( rule__Lieu__PersonnesAssignment_4 )* ) ;
    public final void rule__Lieu__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1863:1: ( ( ( rule__Lieu__PersonnesAssignment_4 )* ) )
            // InternalGAME.g:1864:1: ( ( rule__Lieu__PersonnesAssignment_4 )* )
            {
            // InternalGAME.g:1864:1: ( ( rule__Lieu__PersonnesAssignment_4 )* )
            // InternalGAME.g:1865:2: ( rule__Lieu__PersonnesAssignment_4 )*
            {
             before(grammarAccess.getLieuAccess().getPersonnesAssignment_4()); 
            // InternalGAME.g:1866:2: ( rule__Lieu__PersonnesAssignment_4 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==55) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalGAME.g:1866:3: rule__Lieu__PersonnesAssignment_4
            	    {
            	    pushFollow(FOLLOW_27);
            	    rule__Lieu__PersonnesAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getLieuAccess().getPersonnesAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lieu__Group__4__Impl"


    // $ANTLR start "rule__Lieu__Group__5"
    // InternalGAME.g:1874:1: rule__Lieu__Group__5 : rule__Lieu__Group__5__Impl rule__Lieu__Group__6 ;
    public final void rule__Lieu__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1878:1: ( rule__Lieu__Group__5__Impl rule__Lieu__Group__6 )
            // InternalGAME.g:1879:2: rule__Lieu__Group__5__Impl rule__Lieu__Group__6
            {
            pushFollow(FOLLOW_28);
            rule__Lieu__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lieu__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lieu__Group__5"


    // $ANTLR start "rule__Lieu__Group__5__Impl"
    // InternalGAME.g:1886:1: rule__Lieu__Group__5__Impl : ( 'objets' ) ;
    public final void rule__Lieu__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1890:1: ( ( 'objets' ) )
            // InternalGAME.g:1891:1: ( 'objets' )
            {
            // InternalGAME.g:1891:1: ( 'objets' )
            // InternalGAME.g:1892:2: 'objets'
            {
             before(grammarAccess.getLieuAccess().getObjetsKeyword_5()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getLieuAccess().getObjetsKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lieu__Group__5__Impl"


    // $ANTLR start "rule__Lieu__Group__6"
    // InternalGAME.g:1901:1: rule__Lieu__Group__6 : rule__Lieu__Group__6__Impl rule__Lieu__Group__7 ;
    public final void rule__Lieu__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1905:1: ( rule__Lieu__Group__6__Impl rule__Lieu__Group__7 )
            // InternalGAME.g:1906:2: rule__Lieu__Group__6__Impl rule__Lieu__Group__7
            {
            pushFollow(FOLLOW_28);
            rule__Lieu__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lieu__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lieu__Group__6"


    // $ANTLR start "rule__Lieu__Group__6__Impl"
    // InternalGAME.g:1913:1: rule__Lieu__Group__6__Impl : ( ( rule__Lieu__ObjetsAssignment_6 )* ) ;
    public final void rule__Lieu__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1917:1: ( ( ( rule__Lieu__ObjetsAssignment_6 )* ) )
            // InternalGAME.g:1918:1: ( ( rule__Lieu__ObjetsAssignment_6 )* )
            {
            // InternalGAME.g:1918:1: ( ( rule__Lieu__ObjetsAssignment_6 )* )
            // InternalGAME.g:1919:2: ( rule__Lieu__ObjetsAssignment_6 )*
            {
             before(grammarAccess.getLieuAccess().getObjetsAssignment_6()); 
            // InternalGAME.g:1920:2: ( rule__Lieu__ObjetsAssignment_6 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==28) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalGAME.g:1920:3: rule__Lieu__ObjetsAssignment_6
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Lieu__ObjetsAssignment_6();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getLieuAccess().getObjetsAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lieu__Group__6__Impl"


    // $ANTLR start "rule__Lieu__Group__7"
    // InternalGAME.g:1928:1: rule__Lieu__Group__7 : rule__Lieu__Group__7__Impl rule__Lieu__Group__8 ;
    public final void rule__Lieu__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1932:1: ( rule__Lieu__Group__7__Impl rule__Lieu__Group__8 )
            // InternalGAME.g:1933:2: rule__Lieu__Group__7__Impl rule__Lieu__Group__8
            {
            pushFollow(FOLLOW_29);
            rule__Lieu__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lieu__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lieu__Group__7"


    // $ANTLR start "rule__Lieu__Group__7__Impl"
    // InternalGAME.g:1940:1: rule__Lieu__Group__7__Impl : ( 'connaissances' ) ;
    public final void rule__Lieu__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1944:1: ( ( 'connaissances' ) )
            // InternalGAME.g:1945:1: ( 'connaissances' )
            {
            // InternalGAME.g:1945:1: ( 'connaissances' )
            // InternalGAME.g:1946:2: 'connaissances'
            {
             before(grammarAccess.getLieuAccess().getConnaissancesKeyword_7()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getLieuAccess().getConnaissancesKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lieu__Group__7__Impl"


    // $ANTLR start "rule__Lieu__Group__8"
    // InternalGAME.g:1955:1: rule__Lieu__Group__8 : rule__Lieu__Group__8__Impl rule__Lieu__Group__9 ;
    public final void rule__Lieu__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1959:1: ( rule__Lieu__Group__8__Impl rule__Lieu__Group__9 )
            // InternalGAME.g:1960:2: rule__Lieu__Group__8__Impl rule__Lieu__Group__9
            {
            pushFollow(FOLLOW_29);
            rule__Lieu__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lieu__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lieu__Group__8"


    // $ANTLR start "rule__Lieu__Group__8__Impl"
    // InternalGAME.g:1967:1: rule__Lieu__Group__8__Impl : ( ( rule__Lieu__ConnaisancesAssignment_8 )* ) ;
    public final void rule__Lieu__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1971:1: ( ( ( rule__Lieu__ConnaisancesAssignment_8 )* ) )
            // InternalGAME.g:1972:1: ( ( rule__Lieu__ConnaisancesAssignment_8 )* )
            {
            // InternalGAME.g:1972:1: ( ( rule__Lieu__ConnaisancesAssignment_8 )* )
            // InternalGAME.g:1973:2: ( rule__Lieu__ConnaisancesAssignment_8 )*
            {
             before(grammarAccess.getLieuAccess().getConnaisancesAssignment_8()); 
            // InternalGAME.g:1974:2: ( rule__Lieu__ConnaisancesAssignment_8 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==33) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalGAME.g:1974:3: rule__Lieu__ConnaisancesAssignment_8
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__Lieu__ConnaisancesAssignment_8();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getLieuAccess().getConnaisancesAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lieu__Group__8__Impl"


    // $ANTLR start "rule__Lieu__Group__9"
    // InternalGAME.g:1982:1: rule__Lieu__Group__9 : rule__Lieu__Group__9__Impl rule__Lieu__Group__10 ;
    public final void rule__Lieu__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1986:1: ( rule__Lieu__Group__9__Impl rule__Lieu__Group__10 )
            // InternalGAME.g:1987:2: rule__Lieu__Group__9__Impl rule__Lieu__Group__10
            {
            pushFollow(FOLLOW_30);
            rule__Lieu__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lieu__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lieu__Group__9"


    // $ANTLR start "rule__Lieu__Group__9__Impl"
    // InternalGAME.g:1994:1: rule__Lieu__Group__9__Impl : ( 'chemins' ) ;
    public final void rule__Lieu__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:1998:1: ( ( 'chemins' ) )
            // InternalGAME.g:1999:1: ( 'chemins' )
            {
            // InternalGAME.g:1999:1: ( 'chemins' )
            // InternalGAME.g:2000:2: 'chemins'
            {
             before(grammarAccess.getLieuAccess().getCheminsKeyword_9()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getLieuAccess().getCheminsKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lieu__Group__9__Impl"


    // $ANTLR start "rule__Lieu__Group__10"
    // InternalGAME.g:2009:1: rule__Lieu__Group__10 : rule__Lieu__Group__10__Impl rule__Lieu__Group__11 ;
    public final void rule__Lieu__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2013:1: ( rule__Lieu__Group__10__Impl rule__Lieu__Group__11 )
            // InternalGAME.g:2014:2: rule__Lieu__Group__10__Impl rule__Lieu__Group__11
            {
            pushFollow(FOLLOW_30);
            rule__Lieu__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lieu__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lieu__Group__10"


    // $ANTLR start "rule__Lieu__Group__10__Impl"
    // InternalGAME.g:2021:1: rule__Lieu__Group__10__Impl : ( ( rule__Lieu__CheminAssignment_10 )* ) ;
    public final void rule__Lieu__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2025:1: ( ( ( rule__Lieu__CheminAssignment_10 )* ) )
            // InternalGAME.g:2026:1: ( ( rule__Lieu__CheminAssignment_10 )* )
            {
            // InternalGAME.g:2026:1: ( ( rule__Lieu__CheminAssignment_10 )* )
            // InternalGAME.g:2027:2: ( rule__Lieu__CheminAssignment_10 )*
            {
             before(grammarAccess.getLieuAccess().getCheminAssignment_10()); 
            // InternalGAME.g:2028:2: ( rule__Lieu__CheminAssignment_10 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==48) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalGAME.g:2028:3: rule__Lieu__CheminAssignment_10
            	    {
            	    pushFollow(FOLLOW_31);
            	    rule__Lieu__CheminAssignment_10();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getLieuAccess().getCheminAssignment_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lieu__Group__10__Impl"


    // $ANTLR start "rule__Lieu__Group__11"
    // InternalGAME.g:2036:1: rule__Lieu__Group__11 : rule__Lieu__Group__11__Impl rule__Lieu__Group__12 ;
    public final void rule__Lieu__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2040:1: ( rule__Lieu__Group__11__Impl rule__Lieu__Group__12 )
            // InternalGAME.g:2041:2: rule__Lieu__Group__11__Impl rule__Lieu__Group__12
            {
            pushFollow(FOLLOW_30);
            rule__Lieu__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lieu__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lieu__Group__11"


    // $ANTLR start "rule__Lieu__Group__11__Impl"
    // InternalGAME.g:2048:1: rule__Lieu__Group__11__Impl : ( ( rule__Lieu__QualificationAssignment_11 )* ) ;
    public final void rule__Lieu__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2052:1: ( ( ( rule__Lieu__QualificationAssignment_11 )* ) )
            // InternalGAME.g:2053:1: ( ( rule__Lieu__QualificationAssignment_11 )* )
            {
            // InternalGAME.g:2053:1: ( ( rule__Lieu__QualificationAssignment_11 )* )
            // InternalGAME.g:2054:2: ( rule__Lieu__QualificationAssignment_11 )*
            {
             before(grammarAccess.getLieuAccess().getQualificationAssignment_11()); 
            // InternalGAME.g:2055:2: ( rule__Lieu__QualificationAssignment_11 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==69) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalGAME.g:2055:3: rule__Lieu__QualificationAssignment_11
            	    {
            	    pushFollow(FOLLOW_22);
            	    rule__Lieu__QualificationAssignment_11();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getLieuAccess().getQualificationAssignment_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lieu__Group__11__Impl"


    // $ANTLR start "rule__Lieu__Group__12"
    // InternalGAME.g:2063:1: rule__Lieu__Group__12 : rule__Lieu__Group__12__Impl ;
    public final void rule__Lieu__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2067:1: ( rule__Lieu__Group__12__Impl )
            // InternalGAME.g:2068:2: rule__Lieu__Group__12__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Lieu__Group__12__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lieu__Group__12"


    // $ANTLR start "rule__Lieu__Group__12__Impl"
    // InternalGAME.g:2074:1: rule__Lieu__Group__12__Impl : ( '}' ) ;
    public final void rule__Lieu__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2078:1: ( ( '}' ) )
            // InternalGAME.g:2079:1: ( '}' )
            {
            // InternalGAME.g:2079:1: ( '}' )
            // InternalGAME.g:2080:2: '}'
            {
             before(grammarAccess.getLieuAccess().getRightCurlyBracketKeyword_12()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getLieuAccess().getRightCurlyBracketKeyword_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lieu__Group__12__Impl"


    // $ANTLR start "rule__Territoire__Group__0"
    // InternalGAME.g:2090:1: rule__Territoire__Group__0 : rule__Territoire__Group__0__Impl rule__Territoire__Group__1 ;
    public final void rule__Territoire__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2094:1: ( rule__Territoire__Group__0__Impl rule__Territoire__Group__1 )
            // InternalGAME.g:2095:2: rule__Territoire__Group__0__Impl rule__Territoire__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Territoire__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Territoire__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Territoire__Group__0"


    // $ANTLR start "rule__Territoire__Group__0__Impl"
    // InternalGAME.g:2102:1: rule__Territoire__Group__0__Impl : ( 'territoire' ) ;
    public final void rule__Territoire__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2106:1: ( ( 'territoire' ) )
            // InternalGAME.g:2107:1: ( 'territoire' )
            {
            // InternalGAME.g:2107:1: ( 'territoire' )
            // InternalGAME.g:2108:2: 'territoire'
            {
             before(grammarAccess.getTerritoireAccess().getTerritoireKeyword_0()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getTerritoireAccess().getTerritoireKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Territoire__Group__0__Impl"


    // $ANTLR start "rule__Territoire__Group__1"
    // InternalGAME.g:2117:1: rule__Territoire__Group__1 : rule__Territoire__Group__1__Impl rule__Territoire__Group__2 ;
    public final void rule__Territoire__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2121:1: ( rule__Territoire__Group__1__Impl rule__Territoire__Group__2 )
            // InternalGAME.g:2122:2: rule__Territoire__Group__1__Impl rule__Territoire__Group__2
            {
            pushFollow(FOLLOW_32);
            rule__Territoire__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Territoire__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Territoire__Group__1"


    // $ANTLR start "rule__Territoire__Group__1__Impl"
    // InternalGAME.g:2129:1: rule__Territoire__Group__1__Impl : ( '{' ) ;
    public final void rule__Territoire__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2133:1: ( ( '{' ) )
            // InternalGAME.g:2134:1: ( '{' )
            {
            // InternalGAME.g:2134:1: ( '{' )
            // InternalGAME.g:2135:2: '{'
            {
             before(grammarAccess.getTerritoireAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getTerritoireAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Territoire__Group__1__Impl"


    // $ANTLR start "rule__Territoire__Group__2"
    // InternalGAME.g:2144:1: rule__Territoire__Group__2 : rule__Territoire__Group__2__Impl rule__Territoire__Group__3 ;
    public final void rule__Territoire__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2148:1: ( rule__Territoire__Group__2__Impl rule__Territoire__Group__3 )
            // InternalGAME.g:2149:2: rule__Territoire__Group__2__Impl rule__Territoire__Group__3
            {
            pushFollow(FOLLOW_33);
            rule__Territoire__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Territoire__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Territoire__Group__2"


    // $ANTLR start "rule__Territoire__Group__2__Impl"
    // InternalGAME.g:2156:1: rule__Territoire__Group__2__Impl : ( 'depart' ) ;
    public final void rule__Territoire__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2160:1: ( ( 'depart' ) )
            // InternalGAME.g:2161:1: ( 'depart' )
            {
            // InternalGAME.g:2161:1: ( 'depart' )
            // InternalGAME.g:2162:2: 'depart'
            {
             before(grammarAccess.getTerritoireAccess().getDepartKeyword_2()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getTerritoireAccess().getDepartKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Territoire__Group__2__Impl"


    // $ANTLR start "rule__Territoire__Group__3"
    // InternalGAME.g:2171:1: rule__Territoire__Group__3 : rule__Territoire__Group__3__Impl rule__Territoire__Group__4 ;
    public final void rule__Territoire__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2175:1: ( rule__Territoire__Group__3__Impl rule__Territoire__Group__4 )
            // InternalGAME.g:2176:2: rule__Territoire__Group__3__Impl rule__Territoire__Group__4
            {
            pushFollow(FOLLOW_34);
            rule__Territoire__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Territoire__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Territoire__Group__3"


    // $ANTLR start "rule__Territoire__Group__3__Impl"
    // InternalGAME.g:2183:1: rule__Territoire__Group__3__Impl : ( ( rule__Territoire__LieuDepartAssignment_3 ) ) ;
    public final void rule__Territoire__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2187:1: ( ( ( rule__Territoire__LieuDepartAssignment_3 ) ) )
            // InternalGAME.g:2188:1: ( ( rule__Territoire__LieuDepartAssignment_3 ) )
            {
            // InternalGAME.g:2188:1: ( ( rule__Territoire__LieuDepartAssignment_3 ) )
            // InternalGAME.g:2189:2: ( rule__Territoire__LieuDepartAssignment_3 )
            {
             before(grammarAccess.getTerritoireAccess().getLieuDepartAssignment_3()); 
            // InternalGAME.g:2190:2: ( rule__Territoire__LieuDepartAssignment_3 )
            // InternalGAME.g:2190:3: rule__Territoire__LieuDepartAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Territoire__LieuDepartAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getTerritoireAccess().getLieuDepartAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Territoire__Group__3__Impl"


    // $ANTLR start "rule__Territoire__Group__4"
    // InternalGAME.g:2198:1: rule__Territoire__Group__4 : rule__Territoire__Group__4__Impl rule__Territoire__Group__5 ;
    public final void rule__Territoire__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2202:1: ( rule__Territoire__Group__4__Impl rule__Territoire__Group__5 )
            // InternalGAME.g:2203:2: rule__Territoire__Group__4__Impl rule__Territoire__Group__5
            {
            pushFollow(FOLLOW_35);
            rule__Territoire__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Territoire__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Territoire__Group__4"


    // $ANTLR start "rule__Territoire__Group__4__Impl"
    // InternalGAME.g:2210:1: rule__Territoire__Group__4__Impl : ( 'inter' ) ;
    public final void rule__Territoire__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2214:1: ( ( 'inter' ) )
            // InternalGAME.g:2215:1: ( 'inter' )
            {
            // InternalGAME.g:2215:1: ( 'inter' )
            // InternalGAME.g:2216:2: 'inter'
            {
             before(grammarAccess.getTerritoireAccess().getInterKeyword_4()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getTerritoireAccess().getInterKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Territoire__Group__4__Impl"


    // $ANTLR start "rule__Territoire__Group__5"
    // InternalGAME.g:2225:1: rule__Territoire__Group__5 : rule__Territoire__Group__5__Impl rule__Territoire__Group__6 ;
    public final void rule__Territoire__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2229:1: ( rule__Territoire__Group__5__Impl rule__Territoire__Group__6 )
            // InternalGAME.g:2230:2: rule__Territoire__Group__5__Impl rule__Territoire__Group__6
            {
            pushFollow(FOLLOW_35);
            rule__Territoire__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Territoire__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Territoire__Group__5"


    // $ANTLR start "rule__Territoire__Group__5__Impl"
    // InternalGAME.g:2237:1: rule__Territoire__Group__5__Impl : ( ( rule__Territoire__LieuxAssignment_5 )* ) ;
    public final void rule__Territoire__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2241:1: ( ( ( rule__Territoire__LieuxAssignment_5 )* ) )
            // InternalGAME.g:2242:1: ( ( rule__Territoire__LieuxAssignment_5 )* )
            {
            // InternalGAME.g:2242:1: ( ( rule__Territoire__LieuxAssignment_5 )* )
            // InternalGAME.g:2243:2: ( rule__Territoire__LieuxAssignment_5 )*
            {
             before(grammarAccess.getTerritoireAccess().getLieuxAssignment_5()); 
            // InternalGAME.g:2244:2: ( rule__Territoire__LieuxAssignment_5 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==34) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalGAME.g:2244:3: rule__Territoire__LieuxAssignment_5
            	    {
            	    pushFollow(FOLLOW_36);
            	    rule__Territoire__LieuxAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getTerritoireAccess().getLieuxAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Territoire__Group__5__Impl"


    // $ANTLR start "rule__Territoire__Group__6"
    // InternalGAME.g:2252:1: rule__Territoire__Group__6 : rule__Territoire__Group__6__Impl rule__Territoire__Group__7 ;
    public final void rule__Territoire__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2256:1: ( rule__Territoire__Group__6__Impl rule__Territoire__Group__7 )
            // InternalGAME.g:2257:2: rule__Territoire__Group__6__Impl rule__Territoire__Group__7
            {
            pushFollow(FOLLOW_37);
            rule__Territoire__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Territoire__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Territoire__Group__6"


    // $ANTLR start "rule__Territoire__Group__6__Impl"
    // InternalGAME.g:2264:1: rule__Territoire__Group__6__Impl : ( 'fins' ) ;
    public final void rule__Territoire__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2268:1: ( ( 'fins' ) )
            // InternalGAME.g:2269:1: ( 'fins' )
            {
            // InternalGAME.g:2269:1: ( 'fins' )
            // InternalGAME.g:2270:2: 'fins'
            {
             before(grammarAccess.getTerritoireAccess().getFinsKeyword_6()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getTerritoireAccess().getFinsKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Territoire__Group__6__Impl"


    // $ANTLR start "rule__Territoire__Group__7"
    // InternalGAME.g:2279:1: rule__Territoire__Group__7 : rule__Territoire__Group__7__Impl rule__Territoire__Group__8 ;
    public final void rule__Territoire__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2283:1: ( rule__Territoire__Group__7__Impl rule__Territoire__Group__8 )
            // InternalGAME.g:2284:2: rule__Territoire__Group__7__Impl rule__Territoire__Group__8
            {
            pushFollow(FOLLOW_37);
            rule__Territoire__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Territoire__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Territoire__Group__7"


    // $ANTLR start "rule__Territoire__Group__7__Impl"
    // InternalGAME.g:2291:1: rule__Territoire__Group__7__Impl : ( ( rule__Territoire__LieuxFinAssignment_7 )* ) ;
    public final void rule__Territoire__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2295:1: ( ( ( rule__Territoire__LieuxFinAssignment_7 )* ) )
            // InternalGAME.g:2296:1: ( ( rule__Territoire__LieuxFinAssignment_7 )* )
            {
            // InternalGAME.g:2296:1: ( ( rule__Territoire__LieuxFinAssignment_7 )* )
            // InternalGAME.g:2297:2: ( rule__Territoire__LieuxFinAssignment_7 )*
            {
             before(grammarAccess.getTerritoireAccess().getLieuxFinAssignment_7()); 
            // InternalGAME.g:2298:2: ( rule__Territoire__LieuxFinAssignment_7 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==34) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalGAME.g:2298:3: rule__Territoire__LieuxFinAssignment_7
            	    {
            	    pushFollow(FOLLOW_36);
            	    rule__Territoire__LieuxFinAssignment_7();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getTerritoireAccess().getLieuxFinAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Territoire__Group__7__Impl"


    // $ANTLR start "rule__Territoire__Group__8"
    // InternalGAME.g:2306:1: rule__Territoire__Group__8 : rule__Territoire__Group__8__Impl rule__Territoire__Group__9 ;
    public final void rule__Territoire__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2310:1: ( rule__Territoire__Group__8__Impl rule__Territoire__Group__9 )
            // InternalGAME.g:2311:2: rule__Territoire__Group__8__Impl rule__Territoire__Group__9
            {
            pushFollow(FOLLOW_38);
            rule__Territoire__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Territoire__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Territoire__Group__8"


    // $ANTLR start "rule__Territoire__Group__8__Impl"
    // InternalGAME.g:2318:1: rule__Territoire__Group__8__Impl : ( 'chemins' ) ;
    public final void rule__Territoire__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2322:1: ( ( 'chemins' ) )
            // InternalGAME.g:2323:1: ( 'chemins' )
            {
            // InternalGAME.g:2323:1: ( 'chemins' )
            // InternalGAME.g:2324:2: 'chemins'
            {
             before(grammarAccess.getTerritoireAccess().getCheminsKeyword_8()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getTerritoireAccess().getCheminsKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Territoire__Group__8__Impl"


    // $ANTLR start "rule__Territoire__Group__9"
    // InternalGAME.g:2333:1: rule__Territoire__Group__9 : rule__Territoire__Group__9__Impl rule__Territoire__Group__10 ;
    public final void rule__Territoire__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2337:1: ( rule__Territoire__Group__9__Impl rule__Territoire__Group__10 )
            // InternalGAME.g:2338:2: rule__Territoire__Group__9__Impl rule__Territoire__Group__10
            {
            pushFollow(FOLLOW_38);
            rule__Territoire__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Territoire__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Territoire__Group__9"


    // $ANTLR start "rule__Territoire__Group__9__Impl"
    // InternalGAME.g:2345:1: rule__Territoire__Group__9__Impl : ( ( rule__Territoire__CheminsAssignment_9 )* ) ;
    public final void rule__Territoire__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2349:1: ( ( ( rule__Territoire__CheminsAssignment_9 )* ) )
            // InternalGAME.g:2350:1: ( ( rule__Territoire__CheminsAssignment_9 )* )
            {
            // InternalGAME.g:2350:1: ( ( rule__Territoire__CheminsAssignment_9 )* )
            // InternalGAME.g:2351:2: ( rule__Territoire__CheminsAssignment_9 )*
            {
             before(grammarAccess.getTerritoireAccess().getCheminsAssignment_9()); 
            // InternalGAME.g:2352:2: ( rule__Territoire__CheminsAssignment_9 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==48) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalGAME.g:2352:3: rule__Territoire__CheminsAssignment_9
            	    {
            	    pushFollow(FOLLOW_31);
            	    rule__Territoire__CheminsAssignment_9();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getTerritoireAccess().getCheminsAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Territoire__Group__9__Impl"


    // $ANTLR start "rule__Territoire__Group__10"
    // InternalGAME.g:2360:1: rule__Territoire__Group__10 : rule__Territoire__Group__10__Impl ;
    public final void rule__Territoire__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2364:1: ( rule__Territoire__Group__10__Impl )
            // InternalGAME.g:2365:2: rule__Territoire__Group__10__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Territoire__Group__10__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Territoire__Group__10"


    // $ANTLR start "rule__Territoire__Group__10__Impl"
    // InternalGAME.g:2371:1: rule__Territoire__Group__10__Impl : ( '}' ) ;
    public final void rule__Territoire__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2375:1: ( ( '}' ) )
            // InternalGAME.g:2376:1: ( '}' )
            {
            // InternalGAME.g:2376:1: ( '}' )
            // InternalGAME.g:2377:2: '}'
            {
             before(grammarAccess.getTerritoireAccess().getRightCurlyBracketKeyword_10()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getTerritoireAccess().getRightCurlyBracketKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Territoire__Group__10__Impl"


    // $ANTLR start "rule__Condition__Group__0"
    // InternalGAME.g:2387:1: rule__Condition__Group__0 : rule__Condition__Group__0__Impl rule__Condition__Group__1 ;
    public final void rule__Condition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2391:1: ( rule__Condition__Group__0__Impl rule__Condition__Group__1 )
            // InternalGAME.g:2392:2: rule__Condition__Group__0__Impl rule__Condition__Group__1
            {
            pushFollow(FOLLOW_39);
            rule__Condition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Condition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__0"


    // $ANTLR start "rule__Condition__Group__0__Impl"
    // InternalGAME.g:2399:1: rule__Condition__Group__0__Impl : ( 'condition' ) ;
    public final void rule__Condition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2403:1: ( ( 'condition' ) )
            // InternalGAME.g:2404:1: ( 'condition' )
            {
            // InternalGAME.g:2404:1: ( 'condition' )
            // InternalGAME.g:2405:2: 'condition'
            {
             before(grammarAccess.getConditionAccess().getConditionKeyword_0()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getConditionAccess().getConditionKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__0__Impl"


    // $ANTLR start "rule__Condition__Group__1"
    // InternalGAME.g:2414:1: rule__Condition__Group__1 : rule__Condition__Group__1__Impl rule__Condition__Group__2 ;
    public final void rule__Condition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2418:1: ( rule__Condition__Group__1__Impl rule__Condition__Group__2 )
            // InternalGAME.g:2419:2: rule__Condition__Group__1__Impl rule__Condition__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Condition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Condition__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__1"


    // $ANTLR start "rule__Condition__Group__1__Impl"
    // InternalGAME.g:2426:1: rule__Condition__Group__1__Impl : ( ( rule__Condition__ValAssignment_1 ) ) ;
    public final void rule__Condition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2430:1: ( ( ( rule__Condition__ValAssignment_1 ) ) )
            // InternalGAME.g:2431:1: ( ( rule__Condition__ValAssignment_1 ) )
            {
            // InternalGAME.g:2431:1: ( ( rule__Condition__ValAssignment_1 ) )
            // InternalGAME.g:2432:2: ( rule__Condition__ValAssignment_1 )
            {
             before(grammarAccess.getConditionAccess().getValAssignment_1()); 
            // InternalGAME.g:2433:2: ( rule__Condition__ValAssignment_1 )
            // InternalGAME.g:2433:3: rule__Condition__ValAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Condition__ValAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getConditionAccess().getValAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__1__Impl"


    // $ANTLR start "rule__Condition__Group__2"
    // InternalGAME.g:2441:1: rule__Condition__Group__2 : rule__Condition__Group__2__Impl rule__Condition__Group__3 ;
    public final void rule__Condition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2445:1: ( rule__Condition__Group__2__Impl rule__Condition__Group__3 )
            // InternalGAME.g:2446:2: rule__Condition__Group__2__Impl rule__Condition__Group__3
            {
            pushFollow(FOLLOW_40);
            rule__Condition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Condition__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__2"


    // $ANTLR start "rule__Condition__Group__2__Impl"
    // InternalGAME.g:2453:1: rule__Condition__Group__2__Impl : ( '{' ) ;
    public final void rule__Condition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2457:1: ( ( '{' ) )
            // InternalGAME.g:2458:1: ( '{' )
            {
            // InternalGAME.g:2458:1: ( '{' )
            // InternalGAME.g:2459:2: '{'
            {
             before(grammarAccess.getConditionAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getConditionAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__2__Impl"


    // $ANTLR start "rule__Condition__Group__3"
    // InternalGAME.g:2468:1: rule__Condition__Group__3 : rule__Condition__Group__3__Impl rule__Condition__Group__4 ;
    public final void rule__Condition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2472:1: ( rule__Condition__Group__3__Impl rule__Condition__Group__4 )
            // InternalGAME.g:2473:2: rule__Condition__Group__3__Impl rule__Condition__Group__4
            {
            pushFollow(FOLLOW_41);
            rule__Condition__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Condition__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__3"


    // $ANTLR start "rule__Condition__Group__3__Impl"
    // InternalGAME.g:2480:1: rule__Condition__Group__3__Impl : ( 'objetsTrue' ) ;
    public final void rule__Condition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2484:1: ( ( 'objetsTrue' ) )
            // InternalGAME.g:2485:1: ( 'objetsTrue' )
            {
            // InternalGAME.g:2485:1: ( 'objetsTrue' )
            // InternalGAME.g:2486:2: 'objetsTrue'
            {
             before(grammarAccess.getConditionAccess().getObjetsTrueKeyword_3()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getConditionAccess().getObjetsTrueKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__3__Impl"


    // $ANTLR start "rule__Condition__Group__4"
    // InternalGAME.g:2495:1: rule__Condition__Group__4 : rule__Condition__Group__4__Impl rule__Condition__Group__5 ;
    public final void rule__Condition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2499:1: ( rule__Condition__Group__4__Impl rule__Condition__Group__5 )
            // InternalGAME.g:2500:2: rule__Condition__Group__4__Impl rule__Condition__Group__5
            {
            pushFollow(FOLLOW_41);
            rule__Condition__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Condition__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__4"


    // $ANTLR start "rule__Condition__Group__4__Impl"
    // InternalGAME.g:2507:1: rule__Condition__Group__4__Impl : ( ( rule__Condition__ObjetsTrueAssignment_4 )* ) ;
    public final void rule__Condition__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2511:1: ( ( ( rule__Condition__ObjetsTrueAssignment_4 )* ) )
            // InternalGAME.g:2512:1: ( ( rule__Condition__ObjetsTrueAssignment_4 )* )
            {
            // InternalGAME.g:2512:1: ( ( rule__Condition__ObjetsTrueAssignment_4 )* )
            // InternalGAME.g:2513:2: ( rule__Condition__ObjetsTrueAssignment_4 )*
            {
             before(grammarAccess.getConditionAccess().getObjetsTrueAssignment_4()); 
            // InternalGAME.g:2514:2: ( rule__Condition__ObjetsTrueAssignment_4 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_ID) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalGAME.g:2514:3: rule__Condition__ObjetsTrueAssignment_4
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__Condition__ObjetsTrueAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getConditionAccess().getObjetsTrueAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__4__Impl"


    // $ANTLR start "rule__Condition__Group__5"
    // InternalGAME.g:2522:1: rule__Condition__Group__5 : rule__Condition__Group__5__Impl rule__Condition__Group__6 ;
    public final void rule__Condition__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2526:1: ( rule__Condition__Group__5__Impl rule__Condition__Group__6 )
            // InternalGAME.g:2527:2: rule__Condition__Group__5__Impl rule__Condition__Group__6
            {
            pushFollow(FOLLOW_42);
            rule__Condition__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Condition__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__5"


    // $ANTLR start "rule__Condition__Group__5__Impl"
    // InternalGAME.g:2534:1: rule__Condition__Group__5__Impl : ( 'objetsFalse' ) ;
    public final void rule__Condition__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2538:1: ( ( 'objetsFalse' ) )
            // InternalGAME.g:2539:1: ( 'objetsFalse' )
            {
            // InternalGAME.g:2539:1: ( 'objetsFalse' )
            // InternalGAME.g:2540:2: 'objetsFalse'
            {
             before(grammarAccess.getConditionAccess().getObjetsFalseKeyword_5()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getConditionAccess().getObjetsFalseKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__5__Impl"


    // $ANTLR start "rule__Condition__Group__6"
    // InternalGAME.g:2549:1: rule__Condition__Group__6 : rule__Condition__Group__6__Impl rule__Condition__Group__7 ;
    public final void rule__Condition__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2553:1: ( rule__Condition__Group__6__Impl rule__Condition__Group__7 )
            // InternalGAME.g:2554:2: rule__Condition__Group__6__Impl rule__Condition__Group__7
            {
            pushFollow(FOLLOW_42);
            rule__Condition__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Condition__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__6"


    // $ANTLR start "rule__Condition__Group__6__Impl"
    // InternalGAME.g:2561:1: rule__Condition__Group__6__Impl : ( ( rule__Condition__ObjetsFalseAssignment_6 )* ) ;
    public final void rule__Condition__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2565:1: ( ( ( rule__Condition__ObjetsFalseAssignment_6 )* ) )
            // InternalGAME.g:2566:1: ( ( rule__Condition__ObjetsFalseAssignment_6 )* )
            {
            // InternalGAME.g:2566:1: ( ( rule__Condition__ObjetsFalseAssignment_6 )* )
            // InternalGAME.g:2567:2: ( rule__Condition__ObjetsFalseAssignment_6 )*
            {
             before(grammarAccess.getConditionAccess().getObjetsFalseAssignment_6()); 
            // InternalGAME.g:2568:2: ( rule__Condition__ObjetsFalseAssignment_6 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_ID) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalGAME.g:2568:3: rule__Condition__ObjetsFalseAssignment_6
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__Condition__ObjetsFalseAssignment_6();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getConditionAccess().getObjetsFalseAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__6__Impl"


    // $ANTLR start "rule__Condition__Group__7"
    // InternalGAME.g:2576:1: rule__Condition__Group__7 : rule__Condition__Group__7__Impl rule__Condition__Group__8 ;
    public final void rule__Condition__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2580:1: ( rule__Condition__Group__7__Impl rule__Condition__Group__8 )
            // InternalGAME.g:2581:2: rule__Condition__Group__7__Impl rule__Condition__Group__8
            {
            pushFollow(FOLLOW_43);
            rule__Condition__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Condition__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__7"


    // $ANTLR start "rule__Condition__Group__7__Impl"
    // InternalGAME.g:2588:1: rule__Condition__Group__7__Impl : ( 'connaissanceTrue' ) ;
    public final void rule__Condition__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2592:1: ( ( 'connaissanceTrue' ) )
            // InternalGAME.g:2593:1: ( 'connaissanceTrue' )
            {
            // InternalGAME.g:2593:1: ( 'connaissanceTrue' )
            // InternalGAME.g:2594:2: 'connaissanceTrue'
            {
             before(grammarAccess.getConditionAccess().getConnaissanceTrueKeyword_7()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getConditionAccess().getConnaissanceTrueKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__7__Impl"


    // $ANTLR start "rule__Condition__Group__8"
    // InternalGAME.g:2603:1: rule__Condition__Group__8 : rule__Condition__Group__8__Impl rule__Condition__Group__9 ;
    public final void rule__Condition__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2607:1: ( rule__Condition__Group__8__Impl rule__Condition__Group__9 )
            // InternalGAME.g:2608:2: rule__Condition__Group__8__Impl rule__Condition__Group__9
            {
            pushFollow(FOLLOW_43);
            rule__Condition__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Condition__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__8"


    // $ANTLR start "rule__Condition__Group__8__Impl"
    // InternalGAME.g:2615:1: rule__Condition__Group__8__Impl : ( ( rule__Condition__ConnaissanceTrueAssignment_8 )* ) ;
    public final void rule__Condition__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2619:1: ( ( ( rule__Condition__ConnaissanceTrueAssignment_8 )* ) )
            // InternalGAME.g:2620:1: ( ( rule__Condition__ConnaissanceTrueAssignment_8 )* )
            {
            // InternalGAME.g:2620:1: ( ( rule__Condition__ConnaissanceTrueAssignment_8 )* )
            // InternalGAME.g:2621:2: ( rule__Condition__ConnaissanceTrueAssignment_8 )*
            {
             before(grammarAccess.getConditionAccess().getConnaissanceTrueAssignment_8()); 
            // InternalGAME.g:2622:2: ( rule__Condition__ConnaissanceTrueAssignment_8 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_ID) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalGAME.g:2622:3: rule__Condition__ConnaissanceTrueAssignment_8
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__Condition__ConnaissanceTrueAssignment_8();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getConditionAccess().getConnaissanceTrueAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__8__Impl"


    // $ANTLR start "rule__Condition__Group__9"
    // InternalGAME.g:2630:1: rule__Condition__Group__9 : rule__Condition__Group__9__Impl rule__Condition__Group__10 ;
    public final void rule__Condition__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2634:1: ( rule__Condition__Group__9__Impl rule__Condition__Group__10 )
            // InternalGAME.g:2635:2: rule__Condition__Group__9__Impl rule__Condition__Group__10
            {
            pushFollow(FOLLOW_44);
            rule__Condition__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Condition__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__9"


    // $ANTLR start "rule__Condition__Group__9__Impl"
    // InternalGAME.g:2642:1: rule__Condition__Group__9__Impl : ( 'connaissanceFalse' ) ;
    public final void rule__Condition__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2646:1: ( ( 'connaissanceFalse' ) )
            // InternalGAME.g:2647:1: ( 'connaissanceFalse' )
            {
            // InternalGAME.g:2647:1: ( 'connaissanceFalse' )
            // InternalGAME.g:2648:2: 'connaissanceFalse'
            {
             before(grammarAccess.getConditionAccess().getConnaissanceFalseKeyword_9()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getConditionAccess().getConnaissanceFalseKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__9__Impl"


    // $ANTLR start "rule__Condition__Group__10"
    // InternalGAME.g:2657:1: rule__Condition__Group__10 : rule__Condition__Group__10__Impl rule__Condition__Group__11 ;
    public final void rule__Condition__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2661:1: ( rule__Condition__Group__10__Impl rule__Condition__Group__11 )
            // InternalGAME.g:2662:2: rule__Condition__Group__10__Impl rule__Condition__Group__11
            {
            pushFollow(FOLLOW_44);
            rule__Condition__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Condition__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__10"


    // $ANTLR start "rule__Condition__Group__10__Impl"
    // InternalGAME.g:2669:1: rule__Condition__Group__10__Impl : ( ( rule__Condition__ConnaissanceFalseAssignment_10 )* ) ;
    public final void rule__Condition__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2673:1: ( ( ( rule__Condition__ConnaissanceFalseAssignment_10 )* ) )
            // InternalGAME.g:2674:1: ( ( rule__Condition__ConnaissanceFalseAssignment_10 )* )
            {
            // InternalGAME.g:2674:1: ( ( rule__Condition__ConnaissanceFalseAssignment_10 )* )
            // InternalGAME.g:2675:2: ( rule__Condition__ConnaissanceFalseAssignment_10 )*
            {
             before(grammarAccess.getConditionAccess().getConnaissanceFalseAssignment_10()); 
            // InternalGAME.g:2676:2: ( rule__Condition__ConnaissanceFalseAssignment_10 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_ID) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalGAME.g:2676:3: rule__Condition__ConnaissanceFalseAssignment_10
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__Condition__ConnaissanceFalseAssignment_10();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

             after(grammarAccess.getConditionAccess().getConnaissanceFalseAssignment_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__10__Impl"


    // $ANTLR start "rule__Condition__Group__11"
    // InternalGAME.g:2684:1: rule__Condition__Group__11 : rule__Condition__Group__11__Impl rule__Condition__Group__12 ;
    public final void rule__Condition__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2688:1: ( rule__Condition__Group__11__Impl rule__Condition__Group__12 )
            // InternalGAME.g:2689:2: rule__Condition__Group__11__Impl rule__Condition__Group__12
            {
            pushFollow(FOLLOW_45);
            rule__Condition__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Condition__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__11"


    // $ANTLR start "rule__Condition__Group__11__Impl"
    // InternalGAME.g:2696:1: rule__Condition__Group__11__Impl : ( 'lieuExplores' ) ;
    public final void rule__Condition__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2700:1: ( ( 'lieuExplores' ) )
            // InternalGAME.g:2701:1: ( 'lieuExplores' )
            {
            // InternalGAME.g:2701:1: ( 'lieuExplores' )
            // InternalGAME.g:2702:2: 'lieuExplores'
            {
             before(grammarAccess.getConditionAccess().getLieuExploresKeyword_11()); 
            match(input,47,FOLLOW_2); 
             after(grammarAccess.getConditionAccess().getLieuExploresKeyword_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__11__Impl"


    // $ANTLR start "rule__Condition__Group__12"
    // InternalGAME.g:2711:1: rule__Condition__Group__12 : rule__Condition__Group__12__Impl rule__Condition__Group__13 ;
    public final void rule__Condition__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2715:1: ( rule__Condition__Group__12__Impl rule__Condition__Group__13 )
            // InternalGAME.g:2716:2: rule__Condition__Group__12__Impl rule__Condition__Group__13
            {
            pushFollow(FOLLOW_45);
            rule__Condition__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Condition__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__12"


    // $ANTLR start "rule__Condition__Group__12__Impl"
    // InternalGAME.g:2723:1: rule__Condition__Group__12__Impl : ( ( rule__Condition__LieuxExploresAssignment_12 )* ) ;
    public final void rule__Condition__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2727:1: ( ( ( rule__Condition__LieuxExploresAssignment_12 )* ) )
            // InternalGAME.g:2728:1: ( ( rule__Condition__LieuxExploresAssignment_12 )* )
            {
            // InternalGAME.g:2728:1: ( ( rule__Condition__LieuxExploresAssignment_12 )* )
            // InternalGAME.g:2729:2: ( rule__Condition__LieuxExploresAssignment_12 )*
            {
             before(grammarAccess.getConditionAccess().getLieuxExploresAssignment_12()); 
            // InternalGAME.g:2730:2: ( rule__Condition__LieuxExploresAssignment_12 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_ID) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalGAME.g:2730:3: rule__Condition__LieuxExploresAssignment_12
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__Condition__LieuxExploresAssignment_12();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getConditionAccess().getLieuxExploresAssignment_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__12__Impl"


    // $ANTLR start "rule__Condition__Group__13"
    // InternalGAME.g:2738:1: rule__Condition__Group__13 : rule__Condition__Group__13__Impl ;
    public final void rule__Condition__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2742:1: ( rule__Condition__Group__13__Impl )
            // InternalGAME.g:2743:2: rule__Condition__Group__13__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Condition__Group__13__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__13"


    // $ANTLR start "rule__Condition__Group__13__Impl"
    // InternalGAME.g:2749:1: rule__Condition__Group__13__Impl : ( '}' ) ;
    public final void rule__Condition__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2753:1: ( ( '}' ) )
            // InternalGAME.g:2754:1: ( '}' )
            {
            // InternalGAME.g:2754:1: ( '}' )
            // InternalGAME.g:2755:2: '}'
            {
             before(grammarAccess.getConditionAccess().getRightCurlyBracketKeyword_13()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getConditionAccess().getRightCurlyBracketKeyword_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__13__Impl"


    // $ANTLR start "rule__Chemin__Group__0"
    // InternalGAME.g:2765:1: rule__Chemin__Group__0 : rule__Chemin__Group__0__Impl rule__Chemin__Group__1 ;
    public final void rule__Chemin__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2769:1: ( rule__Chemin__Group__0__Impl rule__Chemin__Group__1 )
            // InternalGAME.g:2770:2: rule__Chemin__Group__0__Impl rule__Chemin__Group__1
            {
            pushFollow(FOLLOW_46);
            rule__Chemin__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Chemin__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__0"


    // $ANTLR start "rule__Chemin__Group__0__Impl"
    // InternalGAME.g:2777:1: rule__Chemin__Group__0__Impl : ( 'etatChemin' ) ;
    public final void rule__Chemin__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2781:1: ( ( 'etatChemin' ) )
            // InternalGAME.g:2782:1: ( 'etatChemin' )
            {
            // InternalGAME.g:2782:1: ( 'etatChemin' )
            // InternalGAME.g:2783:2: 'etatChemin'
            {
             before(grammarAccess.getCheminAccess().getEtatCheminKeyword_0()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getCheminAccess().getEtatCheminKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__0__Impl"


    // $ANTLR start "rule__Chemin__Group__1"
    // InternalGAME.g:2792:1: rule__Chemin__Group__1 : rule__Chemin__Group__1__Impl rule__Chemin__Group__2 ;
    public final void rule__Chemin__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2796:1: ( rule__Chemin__Group__1__Impl rule__Chemin__Group__2 )
            // InternalGAME.g:2797:2: rule__Chemin__Group__1__Impl rule__Chemin__Group__2
            {
            pushFollow(FOLLOW_47);
            rule__Chemin__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Chemin__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__1"


    // $ANTLR start "rule__Chemin__Group__1__Impl"
    // InternalGAME.g:2804:1: rule__Chemin__Group__1__Impl : ( ( rule__Chemin__EtatAssignment_1 ) ) ;
    public final void rule__Chemin__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2808:1: ( ( ( rule__Chemin__EtatAssignment_1 ) ) )
            // InternalGAME.g:2809:1: ( ( rule__Chemin__EtatAssignment_1 ) )
            {
            // InternalGAME.g:2809:1: ( ( rule__Chemin__EtatAssignment_1 ) )
            // InternalGAME.g:2810:2: ( rule__Chemin__EtatAssignment_1 )
            {
             before(grammarAccess.getCheminAccess().getEtatAssignment_1()); 
            // InternalGAME.g:2811:2: ( rule__Chemin__EtatAssignment_1 )
            // InternalGAME.g:2811:3: rule__Chemin__EtatAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Chemin__EtatAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getCheminAccess().getEtatAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__1__Impl"


    // $ANTLR start "rule__Chemin__Group__2"
    // InternalGAME.g:2819:1: rule__Chemin__Group__2 : rule__Chemin__Group__2__Impl rule__Chemin__Group__3 ;
    public final void rule__Chemin__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2823:1: ( rule__Chemin__Group__2__Impl rule__Chemin__Group__3 )
            // InternalGAME.g:2824:2: rule__Chemin__Group__2__Impl rule__Chemin__Group__3
            {
            pushFollow(FOLLOW_3);
            rule__Chemin__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Chemin__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__2"


    // $ANTLR start "rule__Chemin__Group__2__Impl"
    // InternalGAME.g:2831:1: rule__Chemin__Group__2__Impl : ( 'de' ) ;
    public final void rule__Chemin__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2835:1: ( ( 'de' ) )
            // InternalGAME.g:2836:1: ( 'de' )
            {
            // InternalGAME.g:2836:1: ( 'de' )
            // InternalGAME.g:2837:2: 'de'
            {
             before(grammarAccess.getCheminAccess().getDeKeyword_2()); 
            match(input,49,FOLLOW_2); 
             after(grammarAccess.getCheminAccess().getDeKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__2__Impl"


    // $ANTLR start "rule__Chemin__Group__3"
    // InternalGAME.g:2846:1: rule__Chemin__Group__3 : rule__Chemin__Group__3__Impl rule__Chemin__Group__4 ;
    public final void rule__Chemin__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2850:1: ( rule__Chemin__Group__3__Impl rule__Chemin__Group__4 )
            // InternalGAME.g:2851:2: rule__Chemin__Group__3__Impl rule__Chemin__Group__4
            {
            pushFollow(FOLLOW_48);
            rule__Chemin__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Chemin__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__3"


    // $ANTLR start "rule__Chemin__Group__3__Impl"
    // InternalGAME.g:2858:1: rule__Chemin__Group__3__Impl : ( ( rule__Chemin__PredecessorAssignment_3 ) ) ;
    public final void rule__Chemin__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2862:1: ( ( ( rule__Chemin__PredecessorAssignment_3 ) ) )
            // InternalGAME.g:2863:1: ( ( rule__Chemin__PredecessorAssignment_3 ) )
            {
            // InternalGAME.g:2863:1: ( ( rule__Chemin__PredecessorAssignment_3 ) )
            // InternalGAME.g:2864:2: ( rule__Chemin__PredecessorAssignment_3 )
            {
             before(grammarAccess.getCheminAccess().getPredecessorAssignment_3()); 
            // InternalGAME.g:2865:2: ( rule__Chemin__PredecessorAssignment_3 )
            // InternalGAME.g:2865:3: rule__Chemin__PredecessorAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Chemin__PredecessorAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getCheminAccess().getPredecessorAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__3__Impl"


    // $ANTLR start "rule__Chemin__Group__4"
    // InternalGAME.g:2873:1: rule__Chemin__Group__4 : rule__Chemin__Group__4__Impl rule__Chemin__Group__5 ;
    public final void rule__Chemin__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2877:1: ( rule__Chemin__Group__4__Impl rule__Chemin__Group__5 )
            // InternalGAME.g:2878:2: rule__Chemin__Group__4__Impl rule__Chemin__Group__5
            {
            pushFollow(FOLLOW_3);
            rule__Chemin__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Chemin__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__4"


    // $ANTLR start "rule__Chemin__Group__4__Impl"
    // InternalGAME.g:2885:1: rule__Chemin__Group__4__Impl : ( 'a' ) ;
    public final void rule__Chemin__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2889:1: ( ( 'a' ) )
            // InternalGAME.g:2890:1: ( 'a' )
            {
            // InternalGAME.g:2890:1: ( 'a' )
            // InternalGAME.g:2891:2: 'a'
            {
             before(grammarAccess.getCheminAccess().getAKeyword_4()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getCheminAccess().getAKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__4__Impl"


    // $ANTLR start "rule__Chemin__Group__5"
    // InternalGAME.g:2900:1: rule__Chemin__Group__5 : rule__Chemin__Group__5__Impl rule__Chemin__Group__6 ;
    public final void rule__Chemin__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2904:1: ( rule__Chemin__Group__5__Impl rule__Chemin__Group__6 )
            // InternalGAME.g:2905:2: rule__Chemin__Group__5__Impl rule__Chemin__Group__6
            {
            pushFollow(FOLLOW_4);
            rule__Chemin__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Chemin__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__5"


    // $ANTLR start "rule__Chemin__Group__5__Impl"
    // InternalGAME.g:2912:1: rule__Chemin__Group__5__Impl : ( ( rule__Chemin__SuccessorAssignment_5 ) ) ;
    public final void rule__Chemin__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2916:1: ( ( ( rule__Chemin__SuccessorAssignment_5 ) ) )
            // InternalGAME.g:2917:1: ( ( rule__Chemin__SuccessorAssignment_5 ) )
            {
            // InternalGAME.g:2917:1: ( ( rule__Chemin__SuccessorAssignment_5 ) )
            // InternalGAME.g:2918:2: ( rule__Chemin__SuccessorAssignment_5 )
            {
             before(grammarAccess.getCheminAccess().getSuccessorAssignment_5()); 
            // InternalGAME.g:2919:2: ( rule__Chemin__SuccessorAssignment_5 )
            // InternalGAME.g:2919:3: rule__Chemin__SuccessorAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Chemin__SuccessorAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getCheminAccess().getSuccessorAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__5__Impl"


    // $ANTLR start "rule__Chemin__Group__6"
    // InternalGAME.g:2927:1: rule__Chemin__Group__6 : rule__Chemin__Group__6__Impl rule__Chemin__Group__7 ;
    public final void rule__Chemin__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2931:1: ( rule__Chemin__Group__6__Impl rule__Chemin__Group__7 )
            // InternalGAME.g:2932:2: rule__Chemin__Group__6__Impl rule__Chemin__Group__7
            {
            pushFollow(FOLLOW_49);
            rule__Chemin__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Chemin__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__6"


    // $ANTLR start "rule__Chemin__Group__6__Impl"
    // InternalGAME.g:2939:1: rule__Chemin__Group__6__Impl : ( '{' ) ;
    public final void rule__Chemin__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2943:1: ( ( '{' ) )
            // InternalGAME.g:2944:1: ( '{' )
            {
            // InternalGAME.g:2944:1: ( '{' )
            // InternalGAME.g:2945:2: '{'
            {
             before(grammarAccess.getCheminAccess().getLeftCurlyBracketKeyword_6()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getCheminAccess().getLeftCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__6__Impl"


    // $ANTLR start "rule__Chemin__Group__7"
    // InternalGAME.g:2954:1: rule__Chemin__Group__7 : rule__Chemin__Group__7__Impl rule__Chemin__Group__8 ;
    public final void rule__Chemin__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2958:1: ( rule__Chemin__Group__7__Impl rule__Chemin__Group__8 )
            // InternalGAME.g:2959:2: rule__Chemin__Group__7__Impl rule__Chemin__Group__8
            {
            pushFollow(FOLLOW_23);
            rule__Chemin__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Chemin__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__7"


    // $ANTLR start "rule__Chemin__Group__7__Impl"
    // InternalGAME.g:2966:1: rule__Chemin__Group__7__Impl : ( 'visible' ) ;
    public final void rule__Chemin__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2970:1: ( ( 'visible' ) )
            // InternalGAME.g:2971:1: ( 'visible' )
            {
            // InternalGAME.g:2971:1: ( 'visible' )
            // InternalGAME.g:2972:2: 'visible'
            {
             before(grammarAccess.getCheminAccess().getVisibleKeyword_7()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getCheminAccess().getVisibleKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__7__Impl"


    // $ANTLR start "rule__Chemin__Group__8"
    // InternalGAME.g:2981:1: rule__Chemin__Group__8 : rule__Chemin__Group__8__Impl rule__Chemin__Group__9 ;
    public final void rule__Chemin__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2985:1: ( rule__Chemin__Group__8__Impl rule__Chemin__Group__9 )
            // InternalGAME.g:2986:2: rule__Chemin__Group__8__Impl rule__Chemin__Group__9
            {
            pushFollow(FOLLOW_50);
            rule__Chemin__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Chemin__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__8"


    // $ANTLR start "rule__Chemin__Group__8__Impl"
    // InternalGAME.g:2993:1: rule__Chemin__Group__8__Impl : ( ( rule__Chemin__ConditionsVisibleAssignment_8 ) ) ;
    public final void rule__Chemin__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:2997:1: ( ( ( rule__Chemin__ConditionsVisibleAssignment_8 ) ) )
            // InternalGAME.g:2998:1: ( ( rule__Chemin__ConditionsVisibleAssignment_8 ) )
            {
            // InternalGAME.g:2998:1: ( ( rule__Chemin__ConditionsVisibleAssignment_8 ) )
            // InternalGAME.g:2999:2: ( rule__Chemin__ConditionsVisibleAssignment_8 )
            {
             before(grammarAccess.getCheminAccess().getConditionsVisibleAssignment_8()); 
            // InternalGAME.g:3000:2: ( rule__Chemin__ConditionsVisibleAssignment_8 )
            // InternalGAME.g:3000:3: rule__Chemin__ConditionsVisibleAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__Chemin__ConditionsVisibleAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getCheminAccess().getConditionsVisibleAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__8__Impl"


    // $ANTLR start "rule__Chemin__Group__9"
    // InternalGAME.g:3008:1: rule__Chemin__Group__9 : rule__Chemin__Group__9__Impl rule__Chemin__Group__10 ;
    public final void rule__Chemin__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3012:1: ( rule__Chemin__Group__9__Impl rule__Chemin__Group__10 )
            // InternalGAME.g:3013:2: rule__Chemin__Group__9__Impl rule__Chemin__Group__10
            {
            pushFollow(FOLLOW_23);
            rule__Chemin__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Chemin__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__9"


    // $ANTLR start "rule__Chemin__Group__9__Impl"
    // InternalGAME.g:3020:1: rule__Chemin__Group__9__Impl : ( 'ouverture' ) ;
    public final void rule__Chemin__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3024:1: ( ( 'ouverture' ) )
            // InternalGAME.g:3025:1: ( 'ouverture' )
            {
            // InternalGAME.g:3025:1: ( 'ouverture' )
            // InternalGAME.g:3026:2: 'ouverture'
            {
             before(grammarAccess.getCheminAccess().getOuvertureKeyword_9()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getCheminAccess().getOuvertureKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__9__Impl"


    // $ANTLR start "rule__Chemin__Group__10"
    // InternalGAME.g:3035:1: rule__Chemin__Group__10 : rule__Chemin__Group__10__Impl rule__Chemin__Group__11 ;
    public final void rule__Chemin__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3039:1: ( rule__Chemin__Group__10__Impl rule__Chemin__Group__11 )
            // InternalGAME.g:3040:2: rule__Chemin__Group__10__Impl rule__Chemin__Group__11
            {
            pushFollow(FOLLOW_51);
            rule__Chemin__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Chemin__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__10"


    // $ANTLR start "rule__Chemin__Group__10__Impl"
    // InternalGAME.g:3047:1: rule__Chemin__Group__10__Impl : ( ( rule__Chemin__ConditionsOuvertureAssignment_10 ) ) ;
    public final void rule__Chemin__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3051:1: ( ( ( rule__Chemin__ConditionsOuvertureAssignment_10 ) ) )
            // InternalGAME.g:3052:1: ( ( rule__Chemin__ConditionsOuvertureAssignment_10 ) )
            {
            // InternalGAME.g:3052:1: ( ( rule__Chemin__ConditionsOuvertureAssignment_10 ) )
            // InternalGAME.g:3053:2: ( rule__Chemin__ConditionsOuvertureAssignment_10 )
            {
             before(grammarAccess.getCheminAccess().getConditionsOuvertureAssignment_10()); 
            // InternalGAME.g:3054:2: ( rule__Chemin__ConditionsOuvertureAssignment_10 )
            // InternalGAME.g:3054:3: rule__Chemin__ConditionsOuvertureAssignment_10
            {
            pushFollow(FOLLOW_2);
            rule__Chemin__ConditionsOuvertureAssignment_10();

            state._fsp--;


            }

             after(grammarAccess.getCheminAccess().getConditionsOuvertureAssignment_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__10__Impl"


    // $ANTLR start "rule__Chemin__Group__11"
    // InternalGAME.g:3062:1: rule__Chemin__Group__11 : rule__Chemin__Group__11__Impl rule__Chemin__Group__12 ;
    public final void rule__Chemin__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3066:1: ( rule__Chemin__Group__11__Impl rule__Chemin__Group__12 )
            // InternalGAME.g:3067:2: rule__Chemin__Group__11__Impl rule__Chemin__Group__12
            {
            pushFollow(FOLLOW_23);
            rule__Chemin__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Chemin__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__11"


    // $ANTLR start "rule__Chemin__Group__11__Impl"
    // InternalGAME.g:3074:1: rule__Chemin__Group__11__Impl : ( 'obligation' ) ;
    public final void rule__Chemin__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3078:1: ( ( 'obligation' ) )
            // InternalGAME.g:3079:1: ( 'obligation' )
            {
            // InternalGAME.g:3079:1: ( 'obligation' )
            // InternalGAME.g:3080:2: 'obligation'
            {
             before(grammarAccess.getCheminAccess().getObligationKeyword_11()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getCheminAccess().getObligationKeyword_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__11__Impl"


    // $ANTLR start "rule__Chemin__Group__12"
    // InternalGAME.g:3089:1: rule__Chemin__Group__12 : rule__Chemin__Group__12__Impl rule__Chemin__Group__13 ;
    public final void rule__Chemin__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3093:1: ( rule__Chemin__Group__12__Impl rule__Chemin__Group__13 )
            // InternalGAME.g:3094:2: rule__Chemin__Group__12__Impl rule__Chemin__Group__13
            {
            pushFollow(FOLLOW_52);
            rule__Chemin__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Chemin__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__12"


    // $ANTLR start "rule__Chemin__Group__12__Impl"
    // InternalGAME.g:3101:1: rule__Chemin__Group__12__Impl : ( ( rule__Chemin__ConditionsObligationAssignment_12 ) ) ;
    public final void rule__Chemin__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3105:1: ( ( ( rule__Chemin__ConditionsObligationAssignment_12 ) ) )
            // InternalGAME.g:3106:1: ( ( rule__Chemin__ConditionsObligationAssignment_12 ) )
            {
            // InternalGAME.g:3106:1: ( ( rule__Chemin__ConditionsObligationAssignment_12 ) )
            // InternalGAME.g:3107:2: ( rule__Chemin__ConditionsObligationAssignment_12 )
            {
             before(grammarAccess.getCheminAccess().getConditionsObligationAssignment_12()); 
            // InternalGAME.g:3108:2: ( rule__Chemin__ConditionsObligationAssignment_12 )
            // InternalGAME.g:3108:3: rule__Chemin__ConditionsObligationAssignment_12
            {
            pushFollow(FOLLOW_2);
            rule__Chemin__ConditionsObligationAssignment_12();

            state._fsp--;


            }

             after(grammarAccess.getCheminAccess().getConditionsObligationAssignment_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__12__Impl"


    // $ANTLR start "rule__Chemin__Group__13"
    // InternalGAME.g:3116:1: rule__Chemin__Group__13 : rule__Chemin__Group__13__Impl rule__Chemin__Group__14 ;
    public final void rule__Chemin__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3120:1: ( rule__Chemin__Group__13__Impl rule__Chemin__Group__14 )
            // InternalGAME.g:3121:2: rule__Chemin__Group__13__Impl rule__Chemin__Group__14
            {
            pushFollow(FOLLOW_53);
            rule__Chemin__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Chemin__Group__14();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__13"


    // $ANTLR start "rule__Chemin__Group__13__Impl"
    // InternalGAME.g:3128:1: rule__Chemin__Group__13__Impl : ( 'objetsTransmis' ) ;
    public final void rule__Chemin__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3132:1: ( ( 'objetsTransmis' ) )
            // InternalGAME.g:3133:1: ( 'objetsTransmis' )
            {
            // InternalGAME.g:3133:1: ( 'objetsTransmis' )
            // InternalGAME.g:3134:2: 'objetsTransmis'
            {
             before(grammarAccess.getCheminAccess().getObjetsTransmisKeyword_13()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getCheminAccess().getObjetsTransmisKeyword_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__13__Impl"


    // $ANTLR start "rule__Chemin__Group__14"
    // InternalGAME.g:3143:1: rule__Chemin__Group__14 : rule__Chemin__Group__14__Impl rule__Chemin__Group__15 ;
    public final void rule__Chemin__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3147:1: ( rule__Chemin__Group__14__Impl rule__Chemin__Group__15 )
            // InternalGAME.g:3148:2: rule__Chemin__Group__14__Impl rule__Chemin__Group__15
            {
            pushFollow(FOLLOW_53);
            rule__Chemin__Group__14__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Chemin__Group__15();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__14"


    // $ANTLR start "rule__Chemin__Group__14__Impl"
    // InternalGAME.g:3155:1: rule__Chemin__Group__14__Impl : ( ( rule__Chemin__ObjetsTransmisAssignment_14 )* ) ;
    public final void rule__Chemin__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3159:1: ( ( ( rule__Chemin__ObjetsTransmisAssignment_14 )* ) )
            // InternalGAME.g:3160:1: ( ( rule__Chemin__ObjetsTransmisAssignment_14 )* )
            {
            // InternalGAME.g:3160:1: ( ( rule__Chemin__ObjetsTransmisAssignment_14 )* )
            // InternalGAME.g:3161:2: ( rule__Chemin__ObjetsTransmisAssignment_14 )*
            {
             before(grammarAccess.getCheminAccess().getObjetsTransmisAssignment_14()); 
            // InternalGAME.g:3162:2: ( rule__Chemin__ObjetsTransmisAssignment_14 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==28) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalGAME.g:3162:3: rule__Chemin__ObjetsTransmisAssignment_14
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Chemin__ObjetsTransmisAssignment_14();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

             after(grammarAccess.getCheminAccess().getObjetsTransmisAssignment_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__14__Impl"


    // $ANTLR start "rule__Chemin__Group__15"
    // InternalGAME.g:3170:1: rule__Chemin__Group__15 : rule__Chemin__Group__15__Impl rule__Chemin__Group__16 ;
    public final void rule__Chemin__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3174:1: ( rule__Chemin__Group__15__Impl rule__Chemin__Group__16 )
            // InternalGAME.g:3175:2: rule__Chemin__Group__15__Impl rule__Chemin__Group__16
            {
            pushFollow(FOLLOW_54);
            rule__Chemin__Group__15__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Chemin__Group__16();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__15"


    // $ANTLR start "rule__Chemin__Group__15__Impl"
    // InternalGAME.g:3182:1: rule__Chemin__Group__15__Impl : ( 'prixObjets' ) ;
    public final void rule__Chemin__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3186:1: ( ( 'prixObjets' ) )
            // InternalGAME.g:3187:1: ( 'prixObjets' )
            {
            // InternalGAME.g:3187:1: ( 'prixObjets' )
            // InternalGAME.g:3188:2: 'prixObjets'
            {
             before(grammarAccess.getCheminAccess().getPrixObjetsKeyword_15()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getCheminAccess().getPrixObjetsKeyword_15()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__15__Impl"


    // $ANTLR start "rule__Chemin__Group__16"
    // InternalGAME.g:3197:1: rule__Chemin__Group__16 : rule__Chemin__Group__16__Impl rule__Chemin__Group__17 ;
    public final void rule__Chemin__Group__16() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3201:1: ( rule__Chemin__Group__16__Impl rule__Chemin__Group__17 )
            // InternalGAME.g:3202:2: rule__Chemin__Group__16__Impl rule__Chemin__Group__17
            {
            pushFollow(FOLLOW_54);
            rule__Chemin__Group__16__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Chemin__Group__17();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__16"


    // $ANTLR start "rule__Chemin__Group__16__Impl"
    // InternalGAME.g:3209:1: rule__Chemin__Group__16__Impl : ( ( rule__Chemin__PrixObjetsAssignment_16 )* ) ;
    public final void rule__Chemin__Group__16__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3213:1: ( ( ( rule__Chemin__PrixObjetsAssignment_16 )* ) )
            // InternalGAME.g:3214:1: ( ( rule__Chemin__PrixObjetsAssignment_16 )* )
            {
            // InternalGAME.g:3214:1: ( ( rule__Chemin__PrixObjetsAssignment_16 )* )
            // InternalGAME.g:3215:2: ( rule__Chemin__PrixObjetsAssignment_16 )*
            {
             before(grammarAccess.getCheminAccess().getPrixObjetsAssignment_16()); 
            // InternalGAME.g:3216:2: ( rule__Chemin__PrixObjetsAssignment_16 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==28) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalGAME.g:3216:3: rule__Chemin__PrixObjetsAssignment_16
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Chemin__PrixObjetsAssignment_16();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

             after(grammarAccess.getCheminAccess().getPrixObjetsAssignment_16()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__16__Impl"


    // $ANTLR start "rule__Chemin__Group__17"
    // InternalGAME.g:3224:1: rule__Chemin__Group__17 : rule__Chemin__Group__17__Impl rule__Chemin__Group__18 ;
    public final void rule__Chemin__Group__17() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3228:1: ( rule__Chemin__Group__17__Impl rule__Chemin__Group__18 )
            // InternalGAME.g:3229:2: rule__Chemin__Group__17__Impl rule__Chemin__Group__18
            {
            pushFollow(FOLLOW_54);
            rule__Chemin__Group__17__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Chemin__Group__18();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__17"


    // $ANTLR start "rule__Chemin__Group__17__Impl"
    // InternalGAME.g:3236:1: rule__Chemin__Group__17__Impl : ( ( rule__Chemin__QualificationAssignment_17 )* ) ;
    public final void rule__Chemin__Group__17__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3240:1: ( ( ( rule__Chemin__QualificationAssignment_17 )* ) )
            // InternalGAME.g:3241:1: ( ( rule__Chemin__QualificationAssignment_17 )* )
            {
            // InternalGAME.g:3241:1: ( ( rule__Chemin__QualificationAssignment_17 )* )
            // InternalGAME.g:3242:2: ( rule__Chemin__QualificationAssignment_17 )*
            {
             before(grammarAccess.getCheminAccess().getQualificationAssignment_17()); 
            // InternalGAME.g:3243:2: ( rule__Chemin__QualificationAssignment_17 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==69) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalGAME.g:3243:3: rule__Chemin__QualificationAssignment_17
            	    {
            	    pushFollow(FOLLOW_22);
            	    rule__Chemin__QualificationAssignment_17();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

             after(grammarAccess.getCheminAccess().getQualificationAssignment_17()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__17__Impl"


    // $ANTLR start "rule__Chemin__Group__18"
    // InternalGAME.g:3251:1: rule__Chemin__Group__18 : rule__Chemin__Group__18__Impl ;
    public final void rule__Chemin__Group__18() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3255:1: ( rule__Chemin__Group__18__Impl )
            // InternalGAME.g:3256:2: rule__Chemin__Group__18__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Chemin__Group__18__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__18"


    // $ANTLR start "rule__Chemin__Group__18__Impl"
    // InternalGAME.g:3262:1: rule__Chemin__Group__18__Impl : ( '}' ) ;
    public final void rule__Chemin__Group__18__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3266:1: ( ( '}' ) )
            // InternalGAME.g:3267:1: ( '}' )
            {
            // InternalGAME.g:3267:1: ( '}' )
            // InternalGAME.g:3268:2: '}'
            {
             before(grammarAccess.getCheminAccess().getRightCurlyBracketKeyword_18()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getCheminAccess().getRightCurlyBracketKeyword_18()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__Group__18__Impl"


    // $ANTLR start "rule__Personne__Group__0"
    // InternalGAME.g:3278:1: rule__Personne__Group__0 : rule__Personne__Group__0__Impl rule__Personne__Group__1 ;
    public final void rule__Personne__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3282:1: ( rule__Personne__Group__0__Impl rule__Personne__Group__1 )
            // InternalGAME.g:3283:2: rule__Personne__Group__0__Impl rule__Personne__Group__1
            {
            pushFollow(FOLLOW_55);
            rule__Personne__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Personne__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Personne__Group__0"


    // $ANTLR start "rule__Personne__Group__0__Impl"
    // InternalGAME.g:3290:1: rule__Personne__Group__0__Impl : ( 'personne' ) ;
    public final void rule__Personne__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3294:1: ( ( 'personne' ) )
            // InternalGAME.g:3295:1: ( 'personne' )
            {
            // InternalGAME.g:3295:1: ( 'personne' )
            // InternalGAME.g:3296:2: 'personne'
            {
             before(grammarAccess.getPersonneAccess().getPersonneKeyword_0()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getPersonneAccess().getPersonneKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Personne__Group__0__Impl"


    // $ANTLR start "rule__Personne__Group__1"
    // InternalGAME.g:3305:1: rule__Personne__Group__1 : rule__Personne__Group__1__Impl rule__Personne__Group__2 ;
    public final void rule__Personne__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3309:1: ( rule__Personne__Group__1__Impl rule__Personne__Group__2 )
            // InternalGAME.g:3310:2: rule__Personne__Group__1__Impl rule__Personne__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Personne__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Personne__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Personne__Group__1"


    // $ANTLR start "rule__Personne__Group__1__Impl"
    // InternalGAME.g:3317:1: rule__Personne__Group__1__Impl : ( ( rule__Personne__NameAssignment_1 ) ) ;
    public final void rule__Personne__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3321:1: ( ( ( rule__Personne__NameAssignment_1 ) ) )
            // InternalGAME.g:3322:1: ( ( rule__Personne__NameAssignment_1 ) )
            {
            // InternalGAME.g:3322:1: ( ( rule__Personne__NameAssignment_1 ) )
            // InternalGAME.g:3323:2: ( rule__Personne__NameAssignment_1 )
            {
             before(grammarAccess.getPersonneAccess().getNameAssignment_1()); 
            // InternalGAME.g:3324:2: ( rule__Personne__NameAssignment_1 )
            // InternalGAME.g:3324:3: rule__Personne__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Personne__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPersonneAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Personne__Group__1__Impl"


    // $ANTLR start "rule__Personne__Group__2"
    // InternalGAME.g:3332:1: rule__Personne__Group__2 : rule__Personne__Group__2__Impl rule__Personne__Group__3 ;
    public final void rule__Personne__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3336:1: ( rule__Personne__Group__2__Impl rule__Personne__Group__3 )
            // InternalGAME.g:3337:2: rule__Personne__Group__2__Impl rule__Personne__Group__3
            {
            pushFollow(FOLLOW_56);
            rule__Personne__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Personne__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Personne__Group__2"


    // $ANTLR start "rule__Personne__Group__2__Impl"
    // InternalGAME.g:3344:1: rule__Personne__Group__2__Impl : ( '{' ) ;
    public final void rule__Personne__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3348:1: ( ( '{' ) )
            // InternalGAME.g:3349:1: ( '{' )
            {
            // InternalGAME.g:3349:1: ( '{' )
            // InternalGAME.g:3350:2: '{'
            {
             before(grammarAccess.getPersonneAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getPersonneAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Personne__Group__2__Impl"


    // $ANTLR start "rule__Personne__Group__3"
    // InternalGAME.g:3359:1: rule__Personne__Group__3 : rule__Personne__Group__3__Impl rule__Personne__Group__4 ;
    public final void rule__Personne__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3363:1: ( rule__Personne__Group__3__Impl rule__Personne__Group__4 )
            // InternalGAME.g:3364:2: rule__Personne__Group__3__Impl rule__Personne__Group__4
            {
            pushFollow(FOLLOW_57);
            rule__Personne__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Personne__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Personne__Group__3"


    // $ANTLR start "rule__Personne__Group__3__Impl"
    // InternalGAME.g:3371:1: rule__Personne__Group__3__Impl : ( 'activite' ) ;
    public final void rule__Personne__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3375:1: ( ( 'activite' ) )
            // InternalGAME.g:3376:1: ( 'activite' )
            {
            // InternalGAME.g:3376:1: ( 'activite' )
            // InternalGAME.g:3377:2: 'activite'
            {
             before(grammarAccess.getPersonneAccess().getActiviteKeyword_3()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getPersonneAccess().getActiviteKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Personne__Group__3__Impl"


    // $ANTLR start "rule__Personne__Group__4"
    // InternalGAME.g:3386:1: rule__Personne__Group__4 : rule__Personne__Group__4__Impl rule__Personne__Group__5 ;
    public final void rule__Personne__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3390:1: ( rule__Personne__Group__4__Impl rule__Personne__Group__5 )
            // InternalGAME.g:3391:2: rule__Personne__Group__4__Impl rule__Personne__Group__5
            {
            pushFollow(FOLLOW_58);
            rule__Personne__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Personne__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Personne__Group__4"


    // $ANTLR start "rule__Personne__Group__4__Impl"
    // InternalGAME.g:3398:1: rule__Personne__Group__4__Impl : ( ( rule__Personne__ActiviteAssignment_4 ) ) ;
    public final void rule__Personne__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3402:1: ( ( ( rule__Personne__ActiviteAssignment_4 ) ) )
            // InternalGAME.g:3403:1: ( ( rule__Personne__ActiviteAssignment_4 ) )
            {
            // InternalGAME.g:3403:1: ( ( rule__Personne__ActiviteAssignment_4 ) )
            // InternalGAME.g:3404:2: ( rule__Personne__ActiviteAssignment_4 )
            {
             before(grammarAccess.getPersonneAccess().getActiviteAssignment_4()); 
            // InternalGAME.g:3405:2: ( rule__Personne__ActiviteAssignment_4 )
            // InternalGAME.g:3405:3: rule__Personne__ActiviteAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Personne__ActiviteAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getPersonneAccess().getActiviteAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Personne__Group__4__Impl"


    // $ANTLR start "rule__Personne__Group__5"
    // InternalGAME.g:3413:1: rule__Personne__Group__5 : rule__Personne__Group__5__Impl rule__Personne__Group__6 ;
    public final void rule__Personne__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3417:1: ( rule__Personne__Group__5__Impl rule__Personne__Group__6 )
            // InternalGAME.g:3418:2: rule__Personne__Group__5__Impl rule__Personne__Group__6
            {
            pushFollow(FOLLOW_23);
            rule__Personne__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Personne__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Personne__Group__5"


    // $ANTLR start "rule__Personne__Group__5__Impl"
    // InternalGAME.g:3425:1: rule__Personne__Group__5__Impl : ( 'visibilite' ) ;
    public final void rule__Personne__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3429:1: ( ( 'visibilite' ) )
            // InternalGAME.g:3430:1: ( 'visibilite' )
            {
            // InternalGAME.g:3430:1: ( 'visibilite' )
            // InternalGAME.g:3431:2: 'visibilite'
            {
             before(grammarAccess.getPersonneAccess().getVisibiliteKeyword_5()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getPersonneAccess().getVisibiliteKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Personne__Group__5__Impl"


    // $ANTLR start "rule__Personne__Group__6"
    // InternalGAME.g:3440:1: rule__Personne__Group__6 : rule__Personne__Group__6__Impl rule__Personne__Group__7 ;
    public final void rule__Personne__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3444:1: ( rule__Personne__Group__6__Impl rule__Personne__Group__7 )
            // InternalGAME.g:3445:2: rule__Personne__Group__6__Impl rule__Personne__Group__7
            {
            pushFollow(FOLLOW_51);
            rule__Personne__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Personne__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Personne__Group__6"


    // $ANTLR start "rule__Personne__Group__6__Impl"
    // InternalGAME.g:3452:1: rule__Personne__Group__6__Impl : ( ( rule__Personne__ConditionsVisibleAssignment_6 ) ) ;
    public final void rule__Personne__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3456:1: ( ( ( rule__Personne__ConditionsVisibleAssignment_6 ) ) )
            // InternalGAME.g:3457:1: ( ( rule__Personne__ConditionsVisibleAssignment_6 ) )
            {
            // InternalGAME.g:3457:1: ( ( rule__Personne__ConditionsVisibleAssignment_6 ) )
            // InternalGAME.g:3458:2: ( rule__Personne__ConditionsVisibleAssignment_6 )
            {
             before(grammarAccess.getPersonneAccess().getConditionsVisibleAssignment_6()); 
            // InternalGAME.g:3459:2: ( rule__Personne__ConditionsVisibleAssignment_6 )
            // InternalGAME.g:3459:3: rule__Personne__ConditionsVisibleAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__Personne__ConditionsVisibleAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getPersonneAccess().getConditionsVisibleAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Personne__Group__6__Impl"


    // $ANTLR start "rule__Personne__Group__7"
    // InternalGAME.g:3467:1: rule__Personne__Group__7 : rule__Personne__Group__7__Impl rule__Personne__Group__8 ;
    public final void rule__Personne__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3471:1: ( rule__Personne__Group__7__Impl rule__Personne__Group__8 )
            // InternalGAME.g:3472:2: rule__Personne__Group__7__Impl rule__Personne__Group__8
            {
            pushFollow(FOLLOW_23);
            rule__Personne__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Personne__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Personne__Group__7"


    // $ANTLR start "rule__Personne__Group__7__Impl"
    // InternalGAME.g:3479:1: rule__Personne__Group__7__Impl : ( 'obligation' ) ;
    public final void rule__Personne__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3483:1: ( ( 'obligation' ) )
            // InternalGAME.g:3484:1: ( 'obligation' )
            {
            // InternalGAME.g:3484:1: ( 'obligation' )
            // InternalGAME.g:3485:2: 'obligation'
            {
             before(grammarAccess.getPersonneAccess().getObligationKeyword_7()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getPersonneAccess().getObligationKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Personne__Group__7__Impl"


    // $ANTLR start "rule__Personne__Group__8"
    // InternalGAME.g:3494:1: rule__Personne__Group__8 : rule__Personne__Group__8__Impl rule__Personne__Group__9 ;
    public final void rule__Personne__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3498:1: ( rule__Personne__Group__8__Impl rule__Personne__Group__9 )
            // InternalGAME.g:3499:2: rule__Personne__Group__8__Impl rule__Personne__Group__9
            {
            pushFollow(FOLLOW_59);
            rule__Personne__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Personne__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Personne__Group__8"


    // $ANTLR start "rule__Personne__Group__8__Impl"
    // InternalGAME.g:3506:1: rule__Personne__Group__8__Impl : ( ( rule__Personne__ConditionsObligationAssignment_8 ) ) ;
    public final void rule__Personne__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3510:1: ( ( ( rule__Personne__ConditionsObligationAssignment_8 ) ) )
            // InternalGAME.g:3511:1: ( ( rule__Personne__ConditionsObligationAssignment_8 ) )
            {
            // InternalGAME.g:3511:1: ( ( rule__Personne__ConditionsObligationAssignment_8 ) )
            // InternalGAME.g:3512:2: ( rule__Personne__ConditionsObligationAssignment_8 )
            {
             before(grammarAccess.getPersonneAccess().getConditionsObligationAssignment_8()); 
            // InternalGAME.g:3513:2: ( rule__Personne__ConditionsObligationAssignment_8 )
            // InternalGAME.g:3513:3: rule__Personne__ConditionsObligationAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__Personne__ConditionsObligationAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getPersonneAccess().getConditionsObligationAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Personne__Group__8__Impl"


    // $ANTLR start "rule__Personne__Group__9"
    // InternalGAME.g:3521:1: rule__Personne__Group__9 : rule__Personne__Group__9__Impl rule__Personne__Group__10 ;
    public final void rule__Personne__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3525:1: ( rule__Personne__Group__9__Impl rule__Personne__Group__10 )
            // InternalGAME.g:3526:2: rule__Personne__Group__9__Impl rule__Personne__Group__10
            {
            pushFollow(FOLLOW_59);
            rule__Personne__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Personne__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Personne__Group__9"


    // $ANTLR start "rule__Personne__Group__9__Impl"
    // InternalGAME.g:3533:1: rule__Personne__Group__9__Impl : ( 'interaction' ) ;
    public final void rule__Personne__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3537:1: ( ( 'interaction' ) )
            // InternalGAME.g:3538:1: ( 'interaction' )
            {
            // InternalGAME.g:3538:1: ( 'interaction' )
            // InternalGAME.g:3539:2: 'interaction'
            {
             before(grammarAccess.getPersonneAccess().getInteractionKeyword_9()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getPersonneAccess().getInteractionKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Personne__Group__9__Impl"


    // $ANTLR start "rule__Personne__Group__10"
    // InternalGAME.g:3548:1: rule__Personne__Group__10 : rule__Personne__Group__10__Impl rule__Personne__Group__11 ;
    public final void rule__Personne__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3552:1: ( rule__Personne__Group__10__Impl rule__Personne__Group__11 )
            // InternalGAME.g:3553:2: rule__Personne__Group__10__Impl rule__Personne__Group__11
            {
            pushFollow(FOLLOW_60);
            rule__Personne__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Personne__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Personne__Group__10"


    // $ANTLR start "rule__Personne__Group__10__Impl"
    // InternalGAME.g:3560:1: rule__Personne__Group__10__Impl : ( ( rule__Personne__InteractionAssignment_10 ) ) ;
    public final void rule__Personne__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3564:1: ( ( ( rule__Personne__InteractionAssignment_10 ) ) )
            // InternalGAME.g:3565:1: ( ( rule__Personne__InteractionAssignment_10 ) )
            {
            // InternalGAME.g:3565:1: ( ( rule__Personne__InteractionAssignment_10 ) )
            // InternalGAME.g:3566:2: ( rule__Personne__InteractionAssignment_10 )
            {
             before(grammarAccess.getPersonneAccess().getInteractionAssignment_10()); 
            // InternalGAME.g:3567:2: ( rule__Personne__InteractionAssignment_10 )
            // InternalGAME.g:3567:3: rule__Personne__InteractionAssignment_10
            {
            pushFollow(FOLLOW_2);
            rule__Personne__InteractionAssignment_10();

            state._fsp--;


            }

             after(grammarAccess.getPersonneAccess().getInteractionAssignment_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Personne__Group__10__Impl"


    // $ANTLR start "rule__Personne__Group__11"
    // InternalGAME.g:3575:1: rule__Personne__Group__11 : rule__Personne__Group__11__Impl rule__Personne__Group__12 ;
    public final void rule__Personne__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3579:1: ( rule__Personne__Group__11__Impl rule__Personne__Group__12 )
            // InternalGAME.g:3580:2: rule__Personne__Group__11__Impl rule__Personne__Group__12
            {
            pushFollow(FOLLOW_60);
            rule__Personne__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Personne__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Personne__Group__11"


    // $ANTLR start "rule__Personne__Group__11__Impl"
    // InternalGAME.g:3587:1: rule__Personne__Group__11__Impl : ( ( rule__Personne__QualificationAssignment_11 )* ) ;
    public final void rule__Personne__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3591:1: ( ( ( rule__Personne__QualificationAssignment_11 )* ) )
            // InternalGAME.g:3592:1: ( ( rule__Personne__QualificationAssignment_11 )* )
            {
            // InternalGAME.g:3592:1: ( ( rule__Personne__QualificationAssignment_11 )* )
            // InternalGAME.g:3593:2: ( rule__Personne__QualificationAssignment_11 )*
            {
             before(grammarAccess.getPersonneAccess().getQualificationAssignment_11()); 
            // InternalGAME.g:3594:2: ( rule__Personne__QualificationAssignment_11 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==69) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalGAME.g:3594:3: rule__Personne__QualificationAssignment_11
            	    {
            	    pushFollow(FOLLOW_22);
            	    rule__Personne__QualificationAssignment_11();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

             after(grammarAccess.getPersonneAccess().getQualificationAssignment_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Personne__Group__11__Impl"


    // $ANTLR start "rule__Personne__Group__12"
    // InternalGAME.g:3602:1: rule__Personne__Group__12 : rule__Personne__Group__12__Impl ;
    public final void rule__Personne__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3606:1: ( rule__Personne__Group__12__Impl )
            // InternalGAME.g:3607:2: rule__Personne__Group__12__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Personne__Group__12__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Personne__Group__12"


    // $ANTLR start "rule__Personne__Group__12__Impl"
    // InternalGAME.g:3613:1: rule__Personne__Group__12__Impl : ( '}' ) ;
    public final void rule__Personne__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3617:1: ( ( '}' ) )
            // InternalGAME.g:3618:1: ( '}' )
            {
            // InternalGAME.g:3618:1: ( '}' )
            // InternalGAME.g:3619:2: '}'
            {
             before(grammarAccess.getPersonneAccess().getRightCurlyBracketKeyword_12()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getPersonneAccess().getRightCurlyBracketKeyword_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Personne__Group__12__Impl"


    // $ANTLR start "rule__Interaction__Group__0"
    // InternalGAME.g:3629:1: rule__Interaction__Group__0 : rule__Interaction__Group__0__Impl rule__Interaction__Group__1 ;
    public final void rule__Interaction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3633:1: ( rule__Interaction__Group__0__Impl rule__Interaction__Group__1 )
            // InternalGAME.g:3634:2: rule__Interaction__Group__0__Impl rule__Interaction__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Interaction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Interaction__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__0"


    // $ANTLR start "rule__Interaction__Group__0__Impl"
    // InternalGAME.g:3641:1: rule__Interaction__Group__0__Impl : ( 'interaction' ) ;
    public final void rule__Interaction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3645:1: ( ( 'interaction' ) )
            // InternalGAME.g:3646:1: ( 'interaction' )
            {
            // InternalGAME.g:3646:1: ( 'interaction' )
            // InternalGAME.g:3647:2: 'interaction'
            {
             before(grammarAccess.getInteractionAccess().getInteractionKeyword_0()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getInteractionAccess().getInteractionKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__0__Impl"


    // $ANTLR start "rule__Interaction__Group__1"
    // InternalGAME.g:3656:1: rule__Interaction__Group__1 : rule__Interaction__Group__1__Impl rule__Interaction__Group__2 ;
    public final void rule__Interaction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3660:1: ( rule__Interaction__Group__1__Impl rule__Interaction__Group__2 )
            // InternalGAME.g:3661:2: rule__Interaction__Group__1__Impl rule__Interaction__Group__2
            {
            pushFollow(FOLLOW_61);
            rule__Interaction__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Interaction__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__1"


    // $ANTLR start "rule__Interaction__Group__1__Impl"
    // InternalGAME.g:3668:1: rule__Interaction__Group__1__Impl : ( '{' ) ;
    public final void rule__Interaction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3672:1: ( ( '{' ) )
            // InternalGAME.g:3673:1: ( '{' )
            {
            // InternalGAME.g:3673:1: ( '{' )
            // InternalGAME.g:3674:2: '{'
            {
             before(grammarAccess.getInteractionAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getInteractionAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__1__Impl"


    // $ANTLR start "rule__Interaction__Group__2"
    // InternalGAME.g:3683:1: rule__Interaction__Group__2 : rule__Interaction__Group__2__Impl rule__Interaction__Group__3 ;
    public final void rule__Interaction__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3687:1: ( rule__Interaction__Group__2__Impl rule__Interaction__Group__3 )
            // InternalGAME.g:3688:2: rule__Interaction__Group__2__Impl rule__Interaction__Group__3
            {
            pushFollow(FOLLOW_62);
            rule__Interaction__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Interaction__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__2"


    // $ANTLR start "rule__Interaction__Group__2__Impl"
    // InternalGAME.g:3695:1: rule__Interaction__Group__2__Impl : ( 'choixDebut' ) ;
    public final void rule__Interaction__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3699:1: ( ( 'choixDebut' ) )
            // InternalGAME.g:3700:1: ( 'choixDebut' )
            {
            // InternalGAME.g:3700:1: ( 'choixDebut' )
            // InternalGAME.g:3701:2: 'choixDebut'
            {
             before(grammarAccess.getInteractionAccess().getChoixDebutKeyword_2()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getInteractionAccess().getChoixDebutKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__2__Impl"


    // $ANTLR start "rule__Interaction__Group__3"
    // InternalGAME.g:3710:1: rule__Interaction__Group__3 : rule__Interaction__Group__3__Impl rule__Interaction__Group__4 ;
    public final void rule__Interaction__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3714:1: ( rule__Interaction__Group__3__Impl rule__Interaction__Group__4 )
            // InternalGAME.g:3715:2: rule__Interaction__Group__3__Impl rule__Interaction__Group__4
            {
            pushFollow(FOLLOW_63);
            rule__Interaction__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Interaction__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__3"


    // $ANTLR start "rule__Interaction__Group__3__Impl"
    // InternalGAME.g:3722:1: rule__Interaction__Group__3__Impl : ( ( rule__Interaction__ChoixDebutAssignment_3 ) ) ;
    public final void rule__Interaction__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3726:1: ( ( ( rule__Interaction__ChoixDebutAssignment_3 ) ) )
            // InternalGAME.g:3727:1: ( ( rule__Interaction__ChoixDebutAssignment_3 ) )
            {
            // InternalGAME.g:3727:1: ( ( rule__Interaction__ChoixDebutAssignment_3 ) )
            // InternalGAME.g:3728:2: ( rule__Interaction__ChoixDebutAssignment_3 )
            {
             before(grammarAccess.getInteractionAccess().getChoixDebutAssignment_3()); 
            // InternalGAME.g:3729:2: ( rule__Interaction__ChoixDebutAssignment_3 )
            // InternalGAME.g:3729:3: rule__Interaction__ChoixDebutAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Interaction__ChoixDebutAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getInteractionAccess().getChoixDebutAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__3__Impl"


    // $ANTLR start "rule__Interaction__Group__4"
    // InternalGAME.g:3737:1: rule__Interaction__Group__4 : rule__Interaction__Group__4__Impl rule__Interaction__Group__5 ;
    public final void rule__Interaction__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3741:1: ( rule__Interaction__Group__4__Impl rule__Interaction__Group__5 )
            // InternalGAME.g:3742:2: rule__Interaction__Group__4__Impl rule__Interaction__Group__5
            {
            pushFollow(FOLLOW_64);
            rule__Interaction__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Interaction__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__4"


    // $ANTLR start "rule__Interaction__Group__4__Impl"
    // InternalGAME.g:3749:1: rule__Interaction__Group__4__Impl : ( 'choixInter' ) ;
    public final void rule__Interaction__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3753:1: ( ( 'choixInter' ) )
            // InternalGAME.g:3754:1: ( 'choixInter' )
            {
            // InternalGAME.g:3754:1: ( 'choixInter' )
            // InternalGAME.g:3755:2: 'choixInter'
            {
             before(grammarAccess.getInteractionAccess().getChoixInterKeyword_4()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getInteractionAccess().getChoixInterKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__4__Impl"


    // $ANTLR start "rule__Interaction__Group__5"
    // InternalGAME.g:3764:1: rule__Interaction__Group__5 : rule__Interaction__Group__5__Impl rule__Interaction__Group__6 ;
    public final void rule__Interaction__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3768:1: ( rule__Interaction__Group__5__Impl rule__Interaction__Group__6 )
            // InternalGAME.g:3769:2: rule__Interaction__Group__5__Impl rule__Interaction__Group__6
            {
            pushFollow(FOLLOW_64);
            rule__Interaction__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Interaction__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__5"


    // $ANTLR start "rule__Interaction__Group__5__Impl"
    // InternalGAME.g:3776:1: rule__Interaction__Group__5__Impl : ( ( rule__Interaction__ChoixInterAssignment_5 )* ) ;
    public final void rule__Interaction__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3780:1: ( ( ( rule__Interaction__ChoixInterAssignment_5 )* ) )
            // InternalGAME.g:3781:1: ( ( rule__Interaction__ChoixInterAssignment_5 )* )
            {
            // InternalGAME.g:3781:1: ( ( rule__Interaction__ChoixInterAssignment_5 )* )
            // InternalGAME.g:3782:2: ( rule__Interaction__ChoixInterAssignment_5 )*
            {
             before(grammarAccess.getInteractionAccess().getChoixInterAssignment_5()); 
            // InternalGAME.g:3783:2: ( rule__Interaction__ChoixInterAssignment_5 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==63) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalGAME.g:3783:3: rule__Interaction__ChoixInterAssignment_5
            	    {
            	    pushFollow(FOLLOW_65);
            	    rule__Interaction__ChoixInterAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

             after(grammarAccess.getInteractionAccess().getChoixInterAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__5__Impl"


    // $ANTLR start "rule__Interaction__Group__6"
    // InternalGAME.g:3791:1: rule__Interaction__Group__6 : rule__Interaction__Group__6__Impl rule__Interaction__Group__7 ;
    public final void rule__Interaction__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3795:1: ( rule__Interaction__Group__6__Impl rule__Interaction__Group__7 )
            // InternalGAME.g:3796:2: rule__Interaction__Group__6__Impl rule__Interaction__Group__7
            {
            pushFollow(FOLLOW_62);
            rule__Interaction__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Interaction__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__6"


    // $ANTLR start "rule__Interaction__Group__6__Impl"
    // InternalGAME.g:3803:1: rule__Interaction__Group__6__Impl : ( 'choixFin' ) ;
    public final void rule__Interaction__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3807:1: ( ( 'choixFin' ) )
            // InternalGAME.g:3808:1: ( 'choixFin' )
            {
            // InternalGAME.g:3808:1: ( 'choixFin' )
            // InternalGAME.g:3809:2: 'choixFin'
            {
             before(grammarAccess.getInteractionAccess().getChoixFinKeyword_6()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getInteractionAccess().getChoixFinKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__6__Impl"


    // $ANTLR start "rule__Interaction__Group__7"
    // InternalGAME.g:3818:1: rule__Interaction__Group__7 : rule__Interaction__Group__7__Impl rule__Interaction__Group__8 ;
    public final void rule__Interaction__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3822:1: ( rule__Interaction__Group__7__Impl rule__Interaction__Group__8 )
            // InternalGAME.g:3823:2: rule__Interaction__Group__7__Impl rule__Interaction__Group__8
            {
            pushFollow(FOLLOW_66);
            rule__Interaction__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Interaction__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__7"


    // $ANTLR start "rule__Interaction__Group__7__Impl"
    // InternalGAME.g:3830:1: rule__Interaction__Group__7__Impl : ( ( rule__Interaction__ChoixFinAssignment_7 ) ) ;
    public final void rule__Interaction__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3834:1: ( ( ( rule__Interaction__ChoixFinAssignment_7 ) ) )
            // InternalGAME.g:3835:1: ( ( rule__Interaction__ChoixFinAssignment_7 ) )
            {
            // InternalGAME.g:3835:1: ( ( rule__Interaction__ChoixFinAssignment_7 ) )
            // InternalGAME.g:3836:2: ( rule__Interaction__ChoixFinAssignment_7 )
            {
             before(grammarAccess.getInteractionAccess().getChoixFinAssignment_7()); 
            // InternalGAME.g:3837:2: ( rule__Interaction__ChoixFinAssignment_7 )
            // InternalGAME.g:3837:3: rule__Interaction__ChoixFinAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__Interaction__ChoixFinAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getInteractionAccess().getChoixFinAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__7__Impl"


    // $ANTLR start "rule__Interaction__Group__8"
    // InternalGAME.g:3845:1: rule__Interaction__Group__8 : rule__Interaction__Group__8__Impl rule__Interaction__Group__9 ;
    public final void rule__Interaction__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3849:1: ( rule__Interaction__Group__8__Impl rule__Interaction__Group__9 )
            // InternalGAME.g:3850:2: rule__Interaction__Group__8__Impl rule__Interaction__Group__9
            {
            pushFollow(FOLLOW_23);
            rule__Interaction__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Interaction__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__8"


    // $ANTLR start "rule__Interaction__Group__8__Impl"
    // InternalGAME.g:3857:1: rule__Interaction__Group__8__Impl : ( 'Fin' ) ;
    public final void rule__Interaction__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3861:1: ( ( 'Fin' ) )
            // InternalGAME.g:3862:1: ( 'Fin' )
            {
            // InternalGAME.g:3862:1: ( 'Fin' )
            // InternalGAME.g:3863:2: 'Fin'
            {
             before(grammarAccess.getInteractionAccess().getFinKeyword_8()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getInteractionAccess().getFinKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__8__Impl"


    // $ANTLR start "rule__Interaction__Group__9"
    // InternalGAME.g:3872:1: rule__Interaction__Group__9 : rule__Interaction__Group__9__Impl rule__Interaction__Group__10 ;
    public final void rule__Interaction__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3876:1: ( rule__Interaction__Group__9__Impl rule__Interaction__Group__10 )
            // InternalGAME.g:3877:2: rule__Interaction__Group__9__Impl rule__Interaction__Group__10
            {
            pushFollow(FOLLOW_7);
            rule__Interaction__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Interaction__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__9"


    // $ANTLR start "rule__Interaction__Group__9__Impl"
    // InternalGAME.g:3884:1: rule__Interaction__Group__9__Impl : ( ( rule__Interaction__ConditionAssignment_9 ) ) ;
    public final void rule__Interaction__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3888:1: ( ( ( rule__Interaction__ConditionAssignment_9 ) ) )
            // InternalGAME.g:3889:1: ( ( rule__Interaction__ConditionAssignment_9 ) )
            {
            // InternalGAME.g:3889:1: ( ( rule__Interaction__ConditionAssignment_9 ) )
            // InternalGAME.g:3890:2: ( rule__Interaction__ConditionAssignment_9 )
            {
             before(grammarAccess.getInteractionAccess().getConditionAssignment_9()); 
            // InternalGAME.g:3891:2: ( rule__Interaction__ConditionAssignment_9 )
            // InternalGAME.g:3891:3: rule__Interaction__ConditionAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__Interaction__ConditionAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getInteractionAccess().getConditionAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__9__Impl"


    // $ANTLR start "rule__Interaction__Group__10"
    // InternalGAME.g:3899:1: rule__Interaction__Group__10 : rule__Interaction__Group__10__Impl ;
    public final void rule__Interaction__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3903:1: ( rule__Interaction__Group__10__Impl )
            // InternalGAME.g:3904:2: rule__Interaction__Group__10__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Interaction__Group__10__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__10"


    // $ANTLR start "rule__Interaction__Group__10__Impl"
    // InternalGAME.g:3910:1: rule__Interaction__Group__10__Impl : ( '}' ) ;
    public final void rule__Interaction__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3914:1: ( ( '}' ) )
            // InternalGAME.g:3915:1: ( '}' )
            {
            // InternalGAME.g:3915:1: ( '}' )
            // InternalGAME.g:3916:2: '}'
            {
             before(grammarAccess.getInteractionAccess().getRightCurlyBracketKeyword_10()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getInteractionAccess().getRightCurlyBracketKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__10__Impl"


    // $ANTLR start "rule__Choix__Group__0"
    // InternalGAME.g:3926:1: rule__Choix__Group__0 : rule__Choix__Group__0__Impl rule__Choix__Group__1 ;
    public final void rule__Choix__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3930:1: ( rule__Choix__Group__0__Impl rule__Choix__Group__1 )
            // InternalGAME.g:3931:2: rule__Choix__Group__0__Impl rule__Choix__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Choix__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Choix__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Choix__Group__0"


    // $ANTLR start "rule__Choix__Group__0__Impl"
    // InternalGAME.g:3938:1: rule__Choix__Group__0__Impl : ( 'choix' ) ;
    public final void rule__Choix__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3942:1: ( ( 'choix' ) )
            // InternalGAME.g:3943:1: ( 'choix' )
            {
            // InternalGAME.g:3943:1: ( 'choix' )
            // InternalGAME.g:3944:2: 'choix'
            {
             before(grammarAccess.getChoixAccess().getChoixKeyword_0()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getChoixAccess().getChoixKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Choix__Group__0__Impl"


    // $ANTLR start "rule__Choix__Group__1"
    // InternalGAME.g:3953:1: rule__Choix__Group__1 : rule__Choix__Group__1__Impl rule__Choix__Group__2 ;
    public final void rule__Choix__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3957:1: ( rule__Choix__Group__1__Impl rule__Choix__Group__2 )
            // InternalGAME.g:3958:2: rule__Choix__Group__1__Impl rule__Choix__Group__2
            {
            pushFollow(FOLLOW_67);
            rule__Choix__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Choix__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Choix__Group__1"


    // $ANTLR start "rule__Choix__Group__1__Impl"
    // InternalGAME.g:3965:1: rule__Choix__Group__1__Impl : ( '{' ) ;
    public final void rule__Choix__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3969:1: ( ( '{' ) )
            // InternalGAME.g:3970:1: ( '{' )
            {
            // InternalGAME.g:3970:1: ( '{' )
            // InternalGAME.g:3971:2: '{'
            {
             before(grammarAccess.getChoixAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getChoixAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Choix__Group__1__Impl"


    // $ANTLR start "rule__Choix__Group__2"
    // InternalGAME.g:3980:1: rule__Choix__Group__2 : rule__Choix__Group__2__Impl rule__Choix__Group__3 ;
    public final void rule__Choix__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3984:1: ( rule__Choix__Group__2__Impl rule__Choix__Group__3 )
            // InternalGAME.g:3985:2: rule__Choix__Group__2__Impl rule__Choix__Group__3
            {
            pushFollow(FOLLOW_68);
            rule__Choix__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Choix__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Choix__Group__2"


    // $ANTLR start "rule__Choix__Group__2__Impl"
    // InternalGAME.g:3992:1: rule__Choix__Group__2__Impl : ( 'actions' ) ;
    public final void rule__Choix__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:3996:1: ( ( 'actions' ) )
            // InternalGAME.g:3997:1: ( 'actions' )
            {
            // InternalGAME.g:3997:1: ( 'actions' )
            // InternalGAME.g:3998:2: 'actions'
            {
             before(grammarAccess.getChoixAccess().getActionsKeyword_2()); 
            match(input,64,FOLLOW_2); 
             after(grammarAccess.getChoixAccess().getActionsKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Choix__Group__2__Impl"


    // $ANTLR start "rule__Choix__Group__3"
    // InternalGAME.g:4007:1: rule__Choix__Group__3 : rule__Choix__Group__3__Impl rule__Choix__Group__4 ;
    public final void rule__Choix__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4011:1: ( rule__Choix__Group__3__Impl rule__Choix__Group__4 )
            // InternalGAME.g:4012:2: rule__Choix__Group__3__Impl rule__Choix__Group__4
            {
            pushFollow(FOLLOW_68);
            rule__Choix__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Choix__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Choix__Group__3"


    // $ANTLR start "rule__Choix__Group__3__Impl"
    // InternalGAME.g:4019:1: rule__Choix__Group__3__Impl : ( ( rule__Choix__ActionsAssignment_3 )* ) ;
    public final void rule__Choix__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4023:1: ( ( ( rule__Choix__ActionsAssignment_3 )* ) )
            // InternalGAME.g:4024:1: ( ( rule__Choix__ActionsAssignment_3 )* )
            {
            // InternalGAME.g:4024:1: ( ( rule__Choix__ActionsAssignment_3 )* )
            // InternalGAME.g:4025:2: ( rule__Choix__ActionsAssignment_3 )*
            {
             before(grammarAccess.getChoixAccess().getActionsAssignment_3()); 
            // InternalGAME.g:4026:2: ( rule__Choix__ActionsAssignment_3 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==65) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalGAME.g:4026:3: rule__Choix__ActionsAssignment_3
            	    {
            	    pushFollow(FOLLOW_69);
            	    rule__Choix__ActionsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

             after(grammarAccess.getChoixAccess().getActionsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Choix__Group__3__Impl"


    // $ANTLR start "rule__Choix__Group__4"
    // InternalGAME.g:4034:1: rule__Choix__Group__4 : rule__Choix__Group__4__Impl ;
    public final void rule__Choix__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4038:1: ( rule__Choix__Group__4__Impl )
            // InternalGAME.g:4039:2: rule__Choix__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Choix__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Choix__Group__4"


    // $ANTLR start "rule__Choix__Group__4__Impl"
    // InternalGAME.g:4045:1: rule__Choix__Group__4__Impl : ( '}' ) ;
    public final void rule__Choix__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4049:1: ( ( '}' ) )
            // InternalGAME.g:4050:1: ( '}' )
            {
            // InternalGAME.g:4050:1: ( '}' )
            // InternalGAME.g:4051:2: '}'
            {
             before(grammarAccess.getChoixAccess().getRightCurlyBracketKeyword_4()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getChoixAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Choix__Group__4__Impl"


    // $ANTLR start "rule__Action__Group__0"
    // InternalGAME.g:4061:1: rule__Action__Group__0 : rule__Action__Group__0__Impl rule__Action__Group__1 ;
    public final void rule__Action__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4065:1: ( rule__Action__Group__0__Impl rule__Action__Group__1 )
            // InternalGAME.g:4066:2: rule__Action__Group__0__Impl rule__Action__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Action__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Action__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__0"


    // $ANTLR start "rule__Action__Group__0__Impl"
    // InternalGAME.g:4073:1: rule__Action__Group__0__Impl : ( 'action' ) ;
    public final void rule__Action__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4077:1: ( ( 'action' ) )
            // InternalGAME.g:4078:1: ( 'action' )
            {
            // InternalGAME.g:4078:1: ( 'action' )
            // InternalGAME.g:4079:2: 'action'
            {
             before(grammarAccess.getActionAccess().getActionKeyword_0()); 
            match(input,65,FOLLOW_2); 
             after(grammarAccess.getActionAccess().getActionKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__0__Impl"


    // $ANTLR start "rule__Action__Group__1"
    // InternalGAME.g:4088:1: rule__Action__Group__1 : rule__Action__Group__1__Impl rule__Action__Group__2 ;
    public final void rule__Action__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4092:1: ( rule__Action__Group__1__Impl rule__Action__Group__2 )
            // InternalGAME.g:4093:2: rule__Action__Group__1__Impl rule__Action__Group__2
            {
            pushFollow(FOLLOW_70);
            rule__Action__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Action__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__1"


    // $ANTLR start "rule__Action__Group__1__Impl"
    // InternalGAME.g:4100:1: rule__Action__Group__1__Impl : ( '{' ) ;
    public final void rule__Action__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4104:1: ( ( '{' ) )
            // InternalGAME.g:4105:1: ( '{' )
            {
            // InternalGAME.g:4105:1: ( '{' )
            // InternalGAME.g:4106:2: '{'
            {
             before(grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__1__Impl"


    // $ANTLR start "rule__Action__Group__2"
    // InternalGAME.g:4115:1: rule__Action__Group__2 : rule__Action__Group__2__Impl rule__Action__Group__3 ;
    public final void rule__Action__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4119:1: ( rule__Action__Group__2__Impl rule__Action__Group__3 )
            // InternalGAME.g:4120:2: rule__Action__Group__2__Impl rule__Action__Group__3
            {
            pushFollow(FOLLOW_70);
            rule__Action__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Action__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__2"


    // $ANTLR start "rule__Action__Group__2__Impl"
    // InternalGAME.g:4127:1: rule__Action__Group__2__Impl : ( ( rule__Action__Group_2__0 )? ) ;
    public final void rule__Action__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4131:1: ( ( ( rule__Action__Group_2__0 )? ) )
            // InternalGAME.g:4132:1: ( ( rule__Action__Group_2__0 )? )
            {
            // InternalGAME.g:4132:1: ( ( rule__Action__Group_2__0 )? )
            // InternalGAME.g:4133:2: ( rule__Action__Group_2__0 )?
            {
             before(grammarAccess.getActionAccess().getGroup_2()); 
            // InternalGAME.g:4134:2: ( rule__Action__Group_2__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==66) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalGAME.g:4134:3: rule__Action__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Action__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getActionAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__2__Impl"


    // $ANTLR start "rule__Action__Group__3"
    // InternalGAME.g:4142:1: rule__Action__Group__3 : rule__Action__Group__3__Impl rule__Action__Group__4 ;
    public final void rule__Action__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4146:1: ( rule__Action__Group__3__Impl rule__Action__Group__4 )
            // InternalGAME.g:4147:2: rule__Action__Group__3__Impl rule__Action__Group__4
            {
            pushFollow(FOLLOW_70);
            rule__Action__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Action__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__3"


    // $ANTLR start "rule__Action__Group__3__Impl"
    // InternalGAME.g:4154:1: rule__Action__Group__3__Impl : ( ( rule__Action__Group_3__0 )? ) ;
    public final void rule__Action__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4158:1: ( ( ( rule__Action__Group_3__0 )? ) )
            // InternalGAME.g:4159:1: ( ( rule__Action__Group_3__0 )? )
            {
            // InternalGAME.g:4159:1: ( ( rule__Action__Group_3__0 )? )
            // InternalGAME.g:4160:2: ( rule__Action__Group_3__0 )?
            {
             before(grammarAccess.getActionAccess().getGroup_3()); 
            // InternalGAME.g:4161:2: ( rule__Action__Group_3__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==67) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalGAME.g:4161:3: rule__Action__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Action__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getActionAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__3__Impl"


    // $ANTLR start "rule__Action__Group__4"
    // InternalGAME.g:4169:1: rule__Action__Group__4 : rule__Action__Group__4__Impl rule__Action__Group__5 ;
    public final void rule__Action__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4173:1: ( rule__Action__Group__4__Impl rule__Action__Group__5 )
            // InternalGAME.g:4174:2: rule__Action__Group__4__Impl rule__Action__Group__5
            {
            pushFollow(FOLLOW_70);
            rule__Action__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Action__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__4"


    // $ANTLR start "rule__Action__Group__4__Impl"
    // InternalGAME.g:4181:1: rule__Action__Group__4__Impl : ( ( rule__Action__Group_4__0 )? ) ;
    public final void rule__Action__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4185:1: ( ( ( rule__Action__Group_4__0 )? ) )
            // InternalGAME.g:4186:1: ( ( rule__Action__Group_4__0 )? )
            {
            // InternalGAME.g:4186:1: ( ( rule__Action__Group_4__0 )? )
            // InternalGAME.g:4187:2: ( rule__Action__Group_4__0 )?
            {
             before(grammarAccess.getActionAccess().getGroup_4()); 
            // InternalGAME.g:4188:2: ( rule__Action__Group_4__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==68) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalGAME.g:4188:3: rule__Action__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Action__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getActionAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__4__Impl"


    // $ANTLR start "rule__Action__Group__5"
    // InternalGAME.g:4196:1: rule__Action__Group__5 : rule__Action__Group__5__Impl rule__Action__Group__6 ;
    public final void rule__Action__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4200:1: ( rule__Action__Group__5__Impl rule__Action__Group__6 )
            // InternalGAME.g:4201:2: rule__Action__Group__5__Impl rule__Action__Group__6
            {
            pushFollow(FOLLOW_70);
            rule__Action__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Action__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__5"


    // $ANTLR start "rule__Action__Group__5__Impl"
    // InternalGAME.g:4208:1: rule__Action__Group__5__Impl : ( ( rule__Action__QualificationAssignment_5 )* ) ;
    public final void rule__Action__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4212:1: ( ( ( rule__Action__QualificationAssignment_5 )* ) )
            // InternalGAME.g:4213:1: ( ( rule__Action__QualificationAssignment_5 )* )
            {
            // InternalGAME.g:4213:1: ( ( rule__Action__QualificationAssignment_5 )* )
            // InternalGAME.g:4214:2: ( rule__Action__QualificationAssignment_5 )*
            {
             before(grammarAccess.getActionAccess().getQualificationAssignment_5()); 
            // InternalGAME.g:4215:2: ( rule__Action__QualificationAssignment_5 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==69) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalGAME.g:4215:3: rule__Action__QualificationAssignment_5
            	    {
            	    pushFollow(FOLLOW_22);
            	    rule__Action__QualificationAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

             after(grammarAccess.getActionAccess().getQualificationAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__5__Impl"


    // $ANTLR start "rule__Action__Group__6"
    // InternalGAME.g:4223:1: rule__Action__Group__6 : rule__Action__Group__6__Impl ;
    public final void rule__Action__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4227:1: ( rule__Action__Group__6__Impl )
            // InternalGAME.g:4228:2: rule__Action__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Action__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__6"


    // $ANTLR start "rule__Action__Group__6__Impl"
    // InternalGAME.g:4234:1: rule__Action__Group__6__Impl : ( '}' ) ;
    public final void rule__Action__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4238:1: ( ( '}' ) )
            // InternalGAME.g:4239:1: ( '}' )
            {
            // InternalGAME.g:4239:1: ( '}' )
            // InternalGAME.g:4240:2: '}'
            {
             before(grammarAccess.getActionAccess().getRightCurlyBracketKeyword_6()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getActionAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__6__Impl"


    // $ANTLR start "rule__Action__Group_2__0"
    // InternalGAME.g:4250:1: rule__Action__Group_2__0 : rule__Action__Group_2__0__Impl rule__Action__Group_2__1 ;
    public final void rule__Action__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4254:1: ( rule__Action__Group_2__0__Impl rule__Action__Group_2__1 )
            // InternalGAME.g:4255:2: rule__Action__Group_2__0__Impl rule__Action__Group_2__1
            {
            pushFollow(FOLLOW_71);
            rule__Action__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Action__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_2__0"


    // $ANTLR start "rule__Action__Group_2__0__Impl"
    // InternalGAME.g:4262:1: rule__Action__Group_2__0__Impl : ( 'objetsConsommes' ) ;
    public final void rule__Action__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4266:1: ( ( 'objetsConsommes' ) )
            // InternalGAME.g:4267:1: ( 'objetsConsommes' )
            {
            // InternalGAME.g:4267:1: ( 'objetsConsommes' )
            // InternalGAME.g:4268:2: 'objetsConsommes'
            {
             before(grammarAccess.getActionAccess().getObjetsConsommesKeyword_2_0()); 
            match(input,66,FOLLOW_2); 
             after(grammarAccess.getActionAccess().getObjetsConsommesKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_2__0__Impl"


    // $ANTLR start "rule__Action__Group_2__1"
    // InternalGAME.g:4277:1: rule__Action__Group_2__1 : rule__Action__Group_2__1__Impl ;
    public final void rule__Action__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4281:1: ( rule__Action__Group_2__1__Impl )
            // InternalGAME.g:4282:2: rule__Action__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Action__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_2__1"


    // $ANTLR start "rule__Action__Group_2__1__Impl"
    // InternalGAME.g:4288:1: rule__Action__Group_2__1__Impl : ( ( rule__Action__ObjetsConsommesAssignment_2_1 )* ) ;
    public final void rule__Action__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4292:1: ( ( ( rule__Action__ObjetsConsommesAssignment_2_1 )* ) )
            // InternalGAME.g:4293:1: ( ( rule__Action__ObjetsConsommesAssignment_2_1 )* )
            {
            // InternalGAME.g:4293:1: ( ( rule__Action__ObjetsConsommesAssignment_2_1 )* )
            // InternalGAME.g:4294:2: ( rule__Action__ObjetsConsommesAssignment_2_1 )*
            {
             before(grammarAccess.getActionAccess().getObjetsConsommesAssignment_2_1()); 
            // InternalGAME.g:4295:2: ( rule__Action__ObjetsConsommesAssignment_2_1 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==28) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalGAME.g:4295:3: rule__Action__ObjetsConsommesAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Action__ObjetsConsommesAssignment_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

             after(grammarAccess.getActionAccess().getObjetsConsommesAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_2__1__Impl"


    // $ANTLR start "rule__Action__Group_3__0"
    // InternalGAME.g:4304:1: rule__Action__Group_3__0 : rule__Action__Group_3__0__Impl rule__Action__Group_3__1 ;
    public final void rule__Action__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4308:1: ( rule__Action__Group_3__0__Impl rule__Action__Group_3__1 )
            // InternalGAME.g:4309:2: rule__Action__Group_3__0__Impl rule__Action__Group_3__1
            {
            pushFollow(FOLLOW_71);
            rule__Action__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Action__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_3__0"


    // $ANTLR start "rule__Action__Group_3__0__Impl"
    // InternalGAME.g:4316:1: rule__Action__Group_3__0__Impl : ( 'objetsProduits' ) ;
    public final void rule__Action__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4320:1: ( ( 'objetsProduits' ) )
            // InternalGAME.g:4321:1: ( 'objetsProduits' )
            {
            // InternalGAME.g:4321:1: ( 'objetsProduits' )
            // InternalGAME.g:4322:2: 'objetsProduits'
            {
             before(grammarAccess.getActionAccess().getObjetsProduitsKeyword_3_0()); 
            match(input,67,FOLLOW_2); 
             after(grammarAccess.getActionAccess().getObjetsProduitsKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_3__0__Impl"


    // $ANTLR start "rule__Action__Group_3__1"
    // InternalGAME.g:4331:1: rule__Action__Group_3__1 : rule__Action__Group_3__1__Impl ;
    public final void rule__Action__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4335:1: ( rule__Action__Group_3__1__Impl )
            // InternalGAME.g:4336:2: rule__Action__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Action__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_3__1"


    // $ANTLR start "rule__Action__Group_3__1__Impl"
    // InternalGAME.g:4342:1: rule__Action__Group_3__1__Impl : ( ( rule__Action__ObjetsProduitsAssignment_3_1 )* ) ;
    public final void rule__Action__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4346:1: ( ( ( rule__Action__ObjetsProduitsAssignment_3_1 )* ) )
            // InternalGAME.g:4347:1: ( ( rule__Action__ObjetsProduitsAssignment_3_1 )* )
            {
            // InternalGAME.g:4347:1: ( ( rule__Action__ObjetsProduitsAssignment_3_1 )* )
            // InternalGAME.g:4348:2: ( rule__Action__ObjetsProduitsAssignment_3_1 )*
            {
             before(grammarAccess.getActionAccess().getObjetsProduitsAssignment_3_1()); 
            // InternalGAME.g:4349:2: ( rule__Action__ObjetsProduitsAssignment_3_1 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==28) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalGAME.g:4349:3: rule__Action__ObjetsProduitsAssignment_3_1
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Action__ObjetsProduitsAssignment_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

             after(grammarAccess.getActionAccess().getObjetsProduitsAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_3__1__Impl"


    // $ANTLR start "rule__Action__Group_4__0"
    // InternalGAME.g:4358:1: rule__Action__Group_4__0 : rule__Action__Group_4__0__Impl rule__Action__Group_4__1 ;
    public final void rule__Action__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4362:1: ( rule__Action__Group_4__0__Impl rule__Action__Group_4__1 )
            // InternalGAME.g:4363:2: rule__Action__Group_4__0__Impl rule__Action__Group_4__1
            {
            pushFollow(FOLLOW_72);
            rule__Action__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Action__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_4__0"


    // $ANTLR start "rule__Action__Group_4__0__Impl"
    // InternalGAME.g:4370:1: rule__Action__Group_4__0__Impl : ( 'connaissanceProduits' ) ;
    public final void rule__Action__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4374:1: ( ( 'connaissanceProduits' ) )
            // InternalGAME.g:4375:1: ( 'connaissanceProduits' )
            {
            // InternalGAME.g:4375:1: ( 'connaissanceProduits' )
            // InternalGAME.g:4376:2: 'connaissanceProduits'
            {
             before(grammarAccess.getActionAccess().getConnaissanceProduitsKeyword_4_0()); 
            match(input,68,FOLLOW_2); 
             after(grammarAccess.getActionAccess().getConnaissanceProduitsKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_4__0__Impl"


    // $ANTLR start "rule__Action__Group_4__1"
    // InternalGAME.g:4385:1: rule__Action__Group_4__1 : rule__Action__Group_4__1__Impl ;
    public final void rule__Action__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4389:1: ( rule__Action__Group_4__1__Impl )
            // InternalGAME.g:4390:2: rule__Action__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Action__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_4__1"


    // $ANTLR start "rule__Action__Group_4__1__Impl"
    // InternalGAME.g:4396:1: rule__Action__Group_4__1__Impl : ( ( rule__Action__ConnaissanceProduitsAssignment_4_1 )* ) ;
    public final void rule__Action__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4400:1: ( ( ( rule__Action__ConnaissanceProduitsAssignment_4_1 )* ) )
            // InternalGAME.g:4401:1: ( ( rule__Action__ConnaissanceProduitsAssignment_4_1 )* )
            {
            // InternalGAME.g:4401:1: ( ( rule__Action__ConnaissanceProduitsAssignment_4_1 )* )
            // InternalGAME.g:4402:2: ( rule__Action__ConnaissanceProduitsAssignment_4_1 )*
            {
             before(grammarAccess.getActionAccess().getConnaissanceProduitsAssignment_4_1()); 
            // InternalGAME.g:4403:2: ( rule__Action__ConnaissanceProduitsAssignment_4_1 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==33) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalGAME.g:4403:3: rule__Action__ConnaissanceProduitsAssignment_4_1
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__Action__ConnaissanceProduitsAssignment_4_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

             after(grammarAccess.getActionAccess().getConnaissanceProduitsAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_4__1__Impl"


    // $ANTLR start "rule__Qualification__Group__0"
    // InternalGAME.g:4412:1: rule__Qualification__Group__0 : rule__Qualification__Group__0__Impl rule__Qualification__Group__1 ;
    public final void rule__Qualification__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4416:1: ( rule__Qualification__Group__0__Impl rule__Qualification__Group__1 )
            // InternalGAME.g:4417:2: rule__Qualification__Group__0__Impl rule__Qualification__Group__1
            {
            pushFollow(FOLLOW_55);
            rule__Qualification__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Qualification__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Qualification__Group__0"


    // $ANTLR start "rule__Qualification__Group__0__Impl"
    // InternalGAME.g:4424:1: rule__Qualification__Group__0__Impl : ( 'qualif' ) ;
    public final void rule__Qualification__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4428:1: ( ( 'qualif' ) )
            // InternalGAME.g:4429:1: ( 'qualif' )
            {
            // InternalGAME.g:4429:1: ( 'qualif' )
            // InternalGAME.g:4430:2: 'qualif'
            {
             before(grammarAccess.getQualificationAccess().getQualifKeyword_0()); 
            match(input,69,FOLLOW_2); 
             after(grammarAccess.getQualificationAccess().getQualifKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Qualification__Group__0__Impl"


    // $ANTLR start "rule__Qualification__Group__1"
    // InternalGAME.g:4439:1: rule__Qualification__Group__1 : rule__Qualification__Group__1__Impl rule__Qualification__Group__2 ;
    public final void rule__Qualification__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4443:1: ( rule__Qualification__Group__1__Impl rule__Qualification__Group__2 )
            // InternalGAME.g:4444:2: rule__Qualification__Group__1__Impl rule__Qualification__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Qualification__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Qualification__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Qualification__Group__1"


    // $ANTLR start "rule__Qualification__Group__1__Impl"
    // InternalGAME.g:4451:1: rule__Qualification__Group__1__Impl : ( ( rule__Qualification__TexteAssignment_1 ) ) ;
    public final void rule__Qualification__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4455:1: ( ( ( rule__Qualification__TexteAssignment_1 ) ) )
            // InternalGAME.g:4456:1: ( ( rule__Qualification__TexteAssignment_1 ) )
            {
            // InternalGAME.g:4456:1: ( ( rule__Qualification__TexteAssignment_1 ) )
            // InternalGAME.g:4457:2: ( rule__Qualification__TexteAssignment_1 )
            {
             before(grammarAccess.getQualificationAccess().getTexteAssignment_1()); 
            // InternalGAME.g:4458:2: ( rule__Qualification__TexteAssignment_1 )
            // InternalGAME.g:4458:3: rule__Qualification__TexteAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Qualification__TexteAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getQualificationAccess().getTexteAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Qualification__Group__1__Impl"


    // $ANTLR start "rule__Qualification__Group__2"
    // InternalGAME.g:4466:1: rule__Qualification__Group__2 : rule__Qualification__Group__2__Impl rule__Qualification__Group__3 ;
    public final void rule__Qualification__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4470:1: ( rule__Qualification__Group__2__Impl rule__Qualification__Group__3 )
            // InternalGAME.g:4471:2: rule__Qualification__Group__2__Impl rule__Qualification__Group__3
            {
            pushFollow(FOLLOW_23);
            rule__Qualification__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Qualification__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Qualification__Group__2"


    // $ANTLR start "rule__Qualification__Group__2__Impl"
    // InternalGAME.g:4478:1: rule__Qualification__Group__2__Impl : ( '{' ) ;
    public final void rule__Qualification__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4482:1: ( ( '{' ) )
            // InternalGAME.g:4483:1: ( '{' )
            {
            // InternalGAME.g:4483:1: ( '{' )
            // InternalGAME.g:4484:2: '{'
            {
             before(grammarAccess.getQualificationAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getQualificationAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Qualification__Group__2__Impl"


    // $ANTLR start "rule__Qualification__Group__3"
    // InternalGAME.g:4493:1: rule__Qualification__Group__3 : rule__Qualification__Group__3__Impl rule__Qualification__Group__4 ;
    public final void rule__Qualification__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4497:1: ( rule__Qualification__Group__3__Impl rule__Qualification__Group__4 )
            // InternalGAME.g:4498:2: rule__Qualification__Group__3__Impl rule__Qualification__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__Qualification__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Qualification__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Qualification__Group__3"


    // $ANTLR start "rule__Qualification__Group__3__Impl"
    // InternalGAME.g:4505:1: rule__Qualification__Group__3__Impl : ( ( rule__Qualification__ConditionAssignment_3 ) ) ;
    public final void rule__Qualification__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4509:1: ( ( ( rule__Qualification__ConditionAssignment_3 ) ) )
            // InternalGAME.g:4510:1: ( ( rule__Qualification__ConditionAssignment_3 ) )
            {
            // InternalGAME.g:4510:1: ( ( rule__Qualification__ConditionAssignment_3 ) )
            // InternalGAME.g:4511:2: ( rule__Qualification__ConditionAssignment_3 )
            {
             before(grammarAccess.getQualificationAccess().getConditionAssignment_3()); 
            // InternalGAME.g:4512:2: ( rule__Qualification__ConditionAssignment_3 )
            // InternalGAME.g:4512:3: rule__Qualification__ConditionAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Qualification__ConditionAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getQualificationAccess().getConditionAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Qualification__Group__3__Impl"


    // $ANTLR start "rule__Qualification__Group__4"
    // InternalGAME.g:4520:1: rule__Qualification__Group__4 : rule__Qualification__Group__4__Impl ;
    public final void rule__Qualification__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4524:1: ( rule__Qualification__Group__4__Impl )
            // InternalGAME.g:4525:2: rule__Qualification__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Qualification__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Qualification__Group__4"


    // $ANTLR start "rule__Qualification__Group__4__Impl"
    // InternalGAME.g:4531:1: rule__Qualification__Group__4__Impl : ( '}' ) ;
    public final void rule__Qualification__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4535:1: ( ( '}' ) )
            // InternalGAME.g:4536:1: ( '}' )
            {
            // InternalGAME.g:4536:1: ( '}' )
            // InternalGAME.g:4537:2: '}'
            {
             before(grammarAccess.getQualificationAccess().getRightCurlyBracketKeyword_4()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getQualificationAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Qualification__Group__4__Impl"


    // $ANTLR start "rule__EInt__Group__0"
    // InternalGAME.g:4547:1: rule__EInt__Group__0 : rule__EInt__Group__0__Impl rule__EInt__Group__1 ;
    public final void rule__EInt__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4551:1: ( rule__EInt__Group__0__Impl rule__EInt__Group__1 )
            // InternalGAME.g:4552:2: rule__EInt__Group__0__Impl rule__EInt__Group__1
            {
            pushFollow(FOLLOW_16);
            rule__EInt__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EInt__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__0"


    // $ANTLR start "rule__EInt__Group__0__Impl"
    // InternalGAME.g:4559:1: rule__EInt__Group__0__Impl : ( ( '-' )? ) ;
    public final void rule__EInt__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4563:1: ( ( ( '-' )? ) )
            // InternalGAME.g:4564:1: ( ( '-' )? )
            {
            // InternalGAME.g:4564:1: ( ( '-' )? )
            // InternalGAME.g:4565:2: ( '-' )?
            {
             before(grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 
            // InternalGAME.g:4566:2: ( '-' )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==70) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalGAME.g:4566:3: '-'
                    {
                    match(input,70,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__0__Impl"


    // $ANTLR start "rule__EInt__Group__1"
    // InternalGAME.g:4574:1: rule__EInt__Group__1 : rule__EInt__Group__1__Impl ;
    public final void rule__EInt__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4578:1: ( rule__EInt__Group__1__Impl )
            // InternalGAME.g:4579:2: rule__EInt__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EInt__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__1"


    // $ANTLR start "rule__EInt__Group__1__Impl"
    // InternalGAME.g:4585:1: rule__EInt__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__EInt__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4589:1: ( ( RULE_INT ) )
            // InternalGAME.g:4590:1: ( RULE_INT )
            {
            // InternalGAME.g:4590:1: ( RULE_INT )
            // InternalGAME.g:4591:2: RULE_INT
            {
             before(grammarAccess.getEIntAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEIntAccess().getINTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__1__Impl"


    // $ANTLR start "rule__Game__NameAssignment_1"
    // InternalGAME.g:4601:1: rule__Game__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Game__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4605:1: ( ( RULE_ID ) )
            // InternalGAME.g:4606:2: ( RULE_ID )
            {
            // InternalGAME.g:4606:2: ( RULE_ID )
            // InternalGAME.g:4607:3: RULE_ID
            {
             before(grammarAccess.getGameAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__NameAssignment_1"


    // $ANTLR start "rule__Game__ExplorateurAssignment_3"
    // InternalGAME.g:4616:1: rule__Game__ExplorateurAssignment_3 : ( ruleExplorateur ) ;
    public final void rule__Game__ExplorateurAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4620:1: ( ( ruleExplorateur ) )
            // InternalGAME.g:4621:2: ( ruleExplorateur )
            {
            // InternalGAME.g:4621:2: ( ruleExplorateur )
            // InternalGAME.g:4622:3: ruleExplorateur
            {
             before(grammarAccess.getGameAccess().getExplorateurExplorateurParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleExplorateur();

            state._fsp--;

             after(grammarAccess.getGameAccess().getExplorateurExplorateurParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__ExplorateurAssignment_3"


    // $ANTLR start "rule__Game__TerritoireAssignment_4"
    // InternalGAME.g:4631:1: rule__Game__TerritoireAssignment_4 : ( ruleTerritoire ) ;
    public final void rule__Game__TerritoireAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4635:1: ( ( ruleTerritoire ) )
            // InternalGAME.g:4636:2: ( ruleTerritoire )
            {
            // InternalGAME.g:4636:2: ( ruleTerritoire )
            // InternalGAME.g:4637:3: ruleTerritoire
            {
             before(grammarAccess.getGameAccess().getTerritoireTerritoireParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleTerritoire();

            state._fsp--;

             after(grammarAccess.getGameAccess().getTerritoireTerritoireParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__TerritoireAssignment_4"


    // $ANTLR start "rule__Explorateur__NameAssignment_1"
    // InternalGAME.g:4646:1: rule__Explorateur__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Explorateur__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4650:1: ( ( RULE_ID ) )
            // InternalGAME.g:4651:2: ( RULE_ID )
            {
            // InternalGAME.g:4651:2: ( RULE_ID )
            // InternalGAME.g:4652:3: RULE_ID
            {
             before(grammarAccess.getExplorateurAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getExplorateurAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Explorateur__NameAssignment_1"


    // $ANTLR start "rule__Explorateur__ObjetsAssignment_4"
    // InternalGAME.g:4661:1: rule__Explorateur__ObjetsAssignment_4 : ( ruleObjet ) ;
    public final void rule__Explorateur__ObjetsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4665:1: ( ( ruleObjet ) )
            // InternalGAME.g:4666:2: ( ruleObjet )
            {
            // InternalGAME.g:4666:2: ( ruleObjet )
            // InternalGAME.g:4667:3: ruleObjet
            {
             before(grammarAccess.getExplorateurAccess().getObjetsObjetParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleObjet();

            state._fsp--;

             after(grammarAccess.getExplorateurAccess().getObjetsObjetParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Explorateur__ObjetsAssignment_4"


    // $ANTLR start "rule__Explorateur__ConnaissancesAssignment_6"
    // InternalGAME.g:4676:1: rule__Explorateur__ConnaissancesAssignment_6 : ( ruleConnaissance ) ;
    public final void rule__Explorateur__ConnaissancesAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4680:1: ( ( ruleConnaissance ) )
            // InternalGAME.g:4681:2: ( ruleConnaissance )
            {
            // InternalGAME.g:4681:2: ( ruleConnaissance )
            // InternalGAME.g:4682:3: ruleConnaissance
            {
             before(grammarAccess.getExplorateurAccess().getConnaissancesConnaissanceParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleConnaissance();

            state._fsp--;

             after(grammarAccess.getExplorateurAccess().getConnaissancesConnaissanceParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Explorateur__ConnaissancesAssignment_6"


    // $ANTLR start "rule__Explorateur__LieuCourantAssignment_8"
    // InternalGAME.g:4691:1: rule__Explorateur__LieuCourantAssignment_8 : ( ( RULE_ID ) ) ;
    public final void rule__Explorateur__LieuCourantAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4695:1: ( ( ( RULE_ID ) ) )
            // InternalGAME.g:4696:2: ( ( RULE_ID ) )
            {
            // InternalGAME.g:4696:2: ( ( RULE_ID ) )
            // InternalGAME.g:4697:3: ( RULE_ID )
            {
             before(grammarAccess.getExplorateurAccess().getLieuCourantLieuCrossReference_8_0()); 
            // InternalGAME.g:4698:3: ( RULE_ID )
            // InternalGAME.g:4699:4: RULE_ID
            {
             before(grammarAccess.getExplorateurAccess().getLieuCourantLieuIDTerminalRuleCall_8_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getExplorateurAccess().getLieuCourantLieuIDTerminalRuleCall_8_0_1()); 

            }

             after(grammarAccess.getExplorateurAccess().getLieuCourantLieuCrossReference_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Explorateur__LieuCourantAssignment_8"


    // $ANTLR start "rule__Explorateur__LieuExploresAssignment_10"
    // InternalGAME.g:4710:1: rule__Explorateur__LieuExploresAssignment_10 : ( ( RULE_ID ) ) ;
    public final void rule__Explorateur__LieuExploresAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4714:1: ( ( ( RULE_ID ) ) )
            // InternalGAME.g:4715:2: ( ( RULE_ID ) )
            {
            // InternalGAME.g:4715:2: ( ( RULE_ID ) )
            // InternalGAME.g:4716:3: ( RULE_ID )
            {
             before(grammarAccess.getExplorateurAccess().getLieuExploresLieuCrossReference_10_0()); 
            // InternalGAME.g:4717:3: ( RULE_ID )
            // InternalGAME.g:4718:4: RULE_ID
            {
             before(grammarAccess.getExplorateurAccess().getLieuExploresLieuIDTerminalRuleCall_10_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getExplorateurAccess().getLieuExploresLieuIDTerminalRuleCall_10_0_1()); 

            }

             after(grammarAccess.getExplorateurAccess().getLieuExploresLieuCrossReference_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Explorateur__LieuExploresAssignment_10"


    // $ANTLR start "rule__Explorateur__LimiteAssignment_12"
    // InternalGAME.g:4729:1: rule__Explorateur__LimiteAssignment_12 : ( ruleEInt ) ;
    public final void rule__Explorateur__LimiteAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4733:1: ( ( ruleEInt ) )
            // InternalGAME.g:4734:2: ( ruleEInt )
            {
            // InternalGAME.g:4734:2: ( ruleEInt )
            // InternalGAME.g:4735:3: ruleEInt
            {
             before(grammarAccess.getExplorateurAccess().getLimiteEIntParserRuleCall_12_0()); 
            pushFollow(FOLLOW_2);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getExplorateurAccess().getLimiteEIntParserRuleCall_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Explorateur__LimiteAssignment_12"


    // $ANTLR start "rule__Objet__NameAssignment_1"
    // InternalGAME.g:4744:1: rule__Objet__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Objet__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4748:1: ( ( RULE_ID ) )
            // InternalGAME.g:4749:2: ( RULE_ID )
            {
            // InternalGAME.g:4749:2: ( RULE_ID )
            // InternalGAME.g:4750:3: RULE_ID
            {
             before(grammarAccess.getObjetAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getObjetAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Objet__NameAssignment_1"


    // $ANTLR start "rule__Objet__InitValAssignment_3"
    // InternalGAME.g:4759:1: rule__Objet__InitValAssignment_3 : ( ruleEInt ) ;
    public final void rule__Objet__InitValAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4763:1: ( ( ruleEInt ) )
            // InternalGAME.g:4764:2: ( ruleEInt )
            {
            // InternalGAME.g:4764:2: ( ruleEInt )
            // InternalGAME.g:4765:3: ruleEInt
            {
             before(grammarAccess.getObjetAccess().getInitValEIntParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getObjetAccess().getInitValEIntParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Objet__InitValAssignment_3"


    // $ANTLR start "rule__Objet__TailleAssignment_5"
    // InternalGAME.g:4774:1: rule__Objet__TailleAssignment_5 : ( ruleEInt ) ;
    public final void rule__Objet__TailleAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4778:1: ( ( ruleEInt ) )
            // InternalGAME.g:4779:2: ( ruleEInt )
            {
            // InternalGAME.g:4779:2: ( ruleEInt )
            // InternalGAME.g:4780:3: ruleEInt
            {
             before(grammarAccess.getObjetAccess().getTailleEIntParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getObjetAccess().getTailleEIntParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Objet__TailleAssignment_5"


    // $ANTLR start "rule__Objet__EtatAssignment_7"
    // InternalGAME.g:4789:1: rule__Objet__EtatAssignment_7 : ( ruleEtatVisibilite ) ;
    public final void rule__Objet__EtatAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4793:1: ( ( ruleEtatVisibilite ) )
            // InternalGAME.g:4794:2: ( ruleEtatVisibilite )
            {
            // InternalGAME.g:4794:2: ( ruleEtatVisibilite )
            // InternalGAME.g:4795:3: ruleEtatVisibilite
            {
             before(grammarAccess.getObjetAccess().getEtatEtatVisibiliteEnumRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleEtatVisibilite();

            state._fsp--;

             after(grammarAccess.getObjetAccess().getEtatEtatVisibiliteEnumRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Objet__EtatAssignment_7"


    // $ANTLR start "rule__Objet__ConditionAssignment_8_1"
    // InternalGAME.g:4804:1: rule__Objet__ConditionAssignment_8_1 : ( ruleCondition ) ;
    public final void rule__Objet__ConditionAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4808:1: ( ( ruleCondition ) )
            // InternalGAME.g:4809:2: ( ruleCondition )
            {
            // InternalGAME.g:4809:2: ( ruleCondition )
            // InternalGAME.g:4810:3: ruleCondition
            {
             before(grammarAccess.getObjetAccess().getConditionConditionParserRuleCall_8_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getObjetAccess().getConditionConditionParserRuleCall_8_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Objet__ConditionAssignment_8_1"


    // $ANTLR start "rule__Objet__QualificationAssignment_9"
    // InternalGAME.g:4819:1: rule__Objet__QualificationAssignment_9 : ( ruleQualification ) ;
    public final void rule__Objet__QualificationAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4823:1: ( ( ruleQualification ) )
            // InternalGAME.g:4824:2: ( ruleQualification )
            {
            // InternalGAME.g:4824:2: ( ruleQualification )
            // InternalGAME.g:4825:3: ruleQualification
            {
             before(grammarAccess.getObjetAccess().getQualificationQualificationParserRuleCall_9_0()); 
            pushFollow(FOLLOW_2);
            ruleQualification();

            state._fsp--;

             after(grammarAccess.getObjetAccess().getQualificationQualificationParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Objet__QualificationAssignment_9"


    // $ANTLR start "rule__Connaissance__NameAssignment_1"
    // InternalGAME.g:4834:1: rule__Connaissance__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Connaissance__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4838:1: ( ( RULE_ID ) )
            // InternalGAME.g:4839:2: ( RULE_ID )
            {
            // InternalGAME.g:4839:2: ( RULE_ID )
            // InternalGAME.g:4840:3: RULE_ID
            {
             before(grammarAccess.getConnaissanceAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getConnaissanceAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Connaissance__NameAssignment_1"


    // $ANTLR start "rule__Connaissance__QualificationAssignment_3"
    // InternalGAME.g:4849:1: rule__Connaissance__QualificationAssignment_3 : ( ruleQualification ) ;
    public final void rule__Connaissance__QualificationAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4853:1: ( ( ruleQualification ) )
            // InternalGAME.g:4854:2: ( ruleQualification )
            {
            // InternalGAME.g:4854:2: ( ruleQualification )
            // InternalGAME.g:4855:3: ruleQualification
            {
             before(grammarAccess.getConnaissanceAccess().getQualificationQualificationParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleQualification();

            state._fsp--;

             after(grammarAccess.getConnaissanceAccess().getQualificationQualificationParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Connaissance__QualificationAssignment_3"


    // $ANTLR start "rule__Connaissance__ConditionAssignment_4_1"
    // InternalGAME.g:4864:1: rule__Connaissance__ConditionAssignment_4_1 : ( ruleCondition ) ;
    public final void rule__Connaissance__ConditionAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4868:1: ( ( ruleCondition ) )
            // InternalGAME.g:4869:2: ( ruleCondition )
            {
            // InternalGAME.g:4869:2: ( ruleCondition )
            // InternalGAME.g:4870:3: ruleCondition
            {
             before(grammarAccess.getConnaissanceAccess().getConditionConditionParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getConnaissanceAccess().getConditionConditionParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Connaissance__ConditionAssignment_4_1"


    // $ANTLR start "rule__Connaissance__EtatAssignment_6"
    // InternalGAME.g:4879:1: rule__Connaissance__EtatAssignment_6 : ( ruleEtatVisibilite ) ;
    public final void rule__Connaissance__EtatAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4883:1: ( ( ruleEtatVisibilite ) )
            // InternalGAME.g:4884:2: ( ruleEtatVisibilite )
            {
            // InternalGAME.g:4884:2: ( ruleEtatVisibilite )
            // InternalGAME.g:4885:3: ruleEtatVisibilite
            {
             before(grammarAccess.getConnaissanceAccess().getEtatEtatVisibiliteEnumRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleEtatVisibilite();

            state._fsp--;

             after(grammarAccess.getConnaissanceAccess().getEtatEtatVisibiliteEnumRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Connaissance__EtatAssignment_6"


    // $ANTLR start "rule__Lieu__NameAssignment_1"
    // InternalGAME.g:4894:1: rule__Lieu__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Lieu__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4898:1: ( ( RULE_ID ) )
            // InternalGAME.g:4899:2: ( RULE_ID )
            {
            // InternalGAME.g:4899:2: ( RULE_ID )
            // InternalGAME.g:4900:3: RULE_ID
            {
             before(grammarAccess.getLieuAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getLieuAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lieu__NameAssignment_1"


    // $ANTLR start "rule__Lieu__PersonnesAssignment_4"
    // InternalGAME.g:4909:1: rule__Lieu__PersonnesAssignment_4 : ( rulePersonne ) ;
    public final void rule__Lieu__PersonnesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4913:1: ( ( rulePersonne ) )
            // InternalGAME.g:4914:2: ( rulePersonne )
            {
            // InternalGAME.g:4914:2: ( rulePersonne )
            // InternalGAME.g:4915:3: rulePersonne
            {
             before(grammarAccess.getLieuAccess().getPersonnesPersonneParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            rulePersonne();

            state._fsp--;

             after(grammarAccess.getLieuAccess().getPersonnesPersonneParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lieu__PersonnesAssignment_4"


    // $ANTLR start "rule__Lieu__ObjetsAssignment_6"
    // InternalGAME.g:4924:1: rule__Lieu__ObjetsAssignment_6 : ( ruleObjet ) ;
    public final void rule__Lieu__ObjetsAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4928:1: ( ( ruleObjet ) )
            // InternalGAME.g:4929:2: ( ruleObjet )
            {
            // InternalGAME.g:4929:2: ( ruleObjet )
            // InternalGAME.g:4930:3: ruleObjet
            {
             before(grammarAccess.getLieuAccess().getObjetsObjetParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleObjet();

            state._fsp--;

             after(grammarAccess.getLieuAccess().getObjetsObjetParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lieu__ObjetsAssignment_6"


    // $ANTLR start "rule__Lieu__ConnaisancesAssignment_8"
    // InternalGAME.g:4939:1: rule__Lieu__ConnaisancesAssignment_8 : ( ruleConnaissance ) ;
    public final void rule__Lieu__ConnaisancesAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4943:1: ( ( ruleConnaissance ) )
            // InternalGAME.g:4944:2: ( ruleConnaissance )
            {
            // InternalGAME.g:4944:2: ( ruleConnaissance )
            // InternalGAME.g:4945:3: ruleConnaissance
            {
             before(grammarAccess.getLieuAccess().getConnaisancesConnaissanceParserRuleCall_8_0()); 
            pushFollow(FOLLOW_2);
            ruleConnaissance();

            state._fsp--;

             after(grammarAccess.getLieuAccess().getConnaisancesConnaissanceParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lieu__ConnaisancesAssignment_8"


    // $ANTLR start "rule__Lieu__CheminAssignment_10"
    // InternalGAME.g:4954:1: rule__Lieu__CheminAssignment_10 : ( ruleChemin ) ;
    public final void rule__Lieu__CheminAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4958:1: ( ( ruleChemin ) )
            // InternalGAME.g:4959:2: ( ruleChemin )
            {
            // InternalGAME.g:4959:2: ( ruleChemin )
            // InternalGAME.g:4960:3: ruleChemin
            {
             before(grammarAccess.getLieuAccess().getCheminCheminParserRuleCall_10_0()); 
            pushFollow(FOLLOW_2);
            ruleChemin();

            state._fsp--;

             after(grammarAccess.getLieuAccess().getCheminCheminParserRuleCall_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lieu__CheminAssignment_10"


    // $ANTLR start "rule__Lieu__QualificationAssignment_11"
    // InternalGAME.g:4969:1: rule__Lieu__QualificationAssignment_11 : ( ruleQualification ) ;
    public final void rule__Lieu__QualificationAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4973:1: ( ( ruleQualification ) )
            // InternalGAME.g:4974:2: ( ruleQualification )
            {
            // InternalGAME.g:4974:2: ( ruleQualification )
            // InternalGAME.g:4975:3: ruleQualification
            {
             before(grammarAccess.getLieuAccess().getQualificationQualificationParserRuleCall_11_0()); 
            pushFollow(FOLLOW_2);
            ruleQualification();

            state._fsp--;

             after(grammarAccess.getLieuAccess().getQualificationQualificationParserRuleCall_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lieu__QualificationAssignment_11"


    // $ANTLR start "rule__Territoire__LieuDepartAssignment_3"
    // InternalGAME.g:4984:1: rule__Territoire__LieuDepartAssignment_3 : ( ruleLieu ) ;
    public final void rule__Territoire__LieuDepartAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:4988:1: ( ( ruleLieu ) )
            // InternalGAME.g:4989:2: ( ruleLieu )
            {
            // InternalGAME.g:4989:2: ( ruleLieu )
            // InternalGAME.g:4990:3: ruleLieu
            {
             before(grammarAccess.getTerritoireAccess().getLieuDepartLieuParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleLieu();

            state._fsp--;

             after(grammarAccess.getTerritoireAccess().getLieuDepartLieuParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Territoire__LieuDepartAssignment_3"


    // $ANTLR start "rule__Territoire__LieuxAssignment_5"
    // InternalGAME.g:4999:1: rule__Territoire__LieuxAssignment_5 : ( ruleLieu ) ;
    public final void rule__Territoire__LieuxAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:5003:1: ( ( ruleLieu ) )
            // InternalGAME.g:5004:2: ( ruleLieu )
            {
            // InternalGAME.g:5004:2: ( ruleLieu )
            // InternalGAME.g:5005:3: ruleLieu
            {
             before(grammarAccess.getTerritoireAccess().getLieuxLieuParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleLieu();

            state._fsp--;

             after(grammarAccess.getTerritoireAccess().getLieuxLieuParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Territoire__LieuxAssignment_5"


    // $ANTLR start "rule__Territoire__LieuxFinAssignment_7"
    // InternalGAME.g:5014:1: rule__Territoire__LieuxFinAssignment_7 : ( ruleLieu ) ;
    public final void rule__Territoire__LieuxFinAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:5018:1: ( ( ruleLieu ) )
            // InternalGAME.g:5019:2: ( ruleLieu )
            {
            // InternalGAME.g:5019:2: ( ruleLieu )
            // InternalGAME.g:5020:3: ruleLieu
            {
             before(grammarAccess.getTerritoireAccess().getLieuxFinLieuParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleLieu();

            state._fsp--;

             after(grammarAccess.getTerritoireAccess().getLieuxFinLieuParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Territoire__LieuxFinAssignment_7"


    // $ANTLR start "rule__Territoire__CheminsAssignment_9"
    // InternalGAME.g:5029:1: rule__Territoire__CheminsAssignment_9 : ( ruleChemin ) ;
    public final void rule__Territoire__CheminsAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:5033:1: ( ( ruleChemin ) )
            // InternalGAME.g:5034:2: ( ruleChemin )
            {
            // InternalGAME.g:5034:2: ( ruleChemin )
            // InternalGAME.g:5035:3: ruleChemin
            {
             before(grammarAccess.getTerritoireAccess().getCheminsCheminParserRuleCall_9_0()); 
            pushFollow(FOLLOW_2);
            ruleChemin();

            state._fsp--;

             after(grammarAccess.getTerritoireAccess().getCheminsCheminParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Territoire__CheminsAssignment_9"


    // $ANTLR start "rule__Condition__ValAssignment_1"
    // InternalGAME.g:5044:1: rule__Condition__ValAssignment_1 : ( ruleEBoolean ) ;
    public final void rule__Condition__ValAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:5048:1: ( ( ruleEBoolean ) )
            // InternalGAME.g:5049:2: ( ruleEBoolean )
            {
            // InternalGAME.g:5049:2: ( ruleEBoolean )
            // InternalGAME.g:5050:3: ruleEBoolean
            {
             before(grammarAccess.getConditionAccess().getValEBooleanParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEBoolean();

            state._fsp--;

             after(grammarAccess.getConditionAccess().getValEBooleanParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__ValAssignment_1"


    // $ANTLR start "rule__Condition__ObjetsTrueAssignment_4"
    // InternalGAME.g:5059:1: rule__Condition__ObjetsTrueAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__Condition__ObjetsTrueAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:5063:1: ( ( ( RULE_ID ) ) )
            // InternalGAME.g:5064:2: ( ( RULE_ID ) )
            {
            // InternalGAME.g:5064:2: ( ( RULE_ID ) )
            // InternalGAME.g:5065:3: ( RULE_ID )
            {
             before(grammarAccess.getConditionAccess().getObjetsTrueObjetCrossReference_4_0()); 
            // InternalGAME.g:5066:3: ( RULE_ID )
            // InternalGAME.g:5067:4: RULE_ID
            {
             before(grammarAccess.getConditionAccess().getObjetsTrueObjetIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getConditionAccess().getObjetsTrueObjetIDTerminalRuleCall_4_0_1()); 

            }

             after(grammarAccess.getConditionAccess().getObjetsTrueObjetCrossReference_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__ObjetsTrueAssignment_4"


    // $ANTLR start "rule__Condition__ObjetsFalseAssignment_6"
    // InternalGAME.g:5078:1: rule__Condition__ObjetsFalseAssignment_6 : ( ( RULE_ID ) ) ;
    public final void rule__Condition__ObjetsFalseAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:5082:1: ( ( ( RULE_ID ) ) )
            // InternalGAME.g:5083:2: ( ( RULE_ID ) )
            {
            // InternalGAME.g:5083:2: ( ( RULE_ID ) )
            // InternalGAME.g:5084:3: ( RULE_ID )
            {
             before(grammarAccess.getConditionAccess().getObjetsFalseObjetCrossReference_6_0()); 
            // InternalGAME.g:5085:3: ( RULE_ID )
            // InternalGAME.g:5086:4: RULE_ID
            {
             before(grammarAccess.getConditionAccess().getObjetsFalseObjetIDTerminalRuleCall_6_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getConditionAccess().getObjetsFalseObjetIDTerminalRuleCall_6_0_1()); 

            }

             after(grammarAccess.getConditionAccess().getObjetsFalseObjetCrossReference_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__ObjetsFalseAssignment_6"


    // $ANTLR start "rule__Condition__ConnaissanceTrueAssignment_8"
    // InternalGAME.g:5097:1: rule__Condition__ConnaissanceTrueAssignment_8 : ( ( RULE_ID ) ) ;
    public final void rule__Condition__ConnaissanceTrueAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:5101:1: ( ( ( RULE_ID ) ) )
            // InternalGAME.g:5102:2: ( ( RULE_ID ) )
            {
            // InternalGAME.g:5102:2: ( ( RULE_ID ) )
            // InternalGAME.g:5103:3: ( RULE_ID )
            {
             before(grammarAccess.getConditionAccess().getConnaissanceTrueConnaissanceCrossReference_8_0()); 
            // InternalGAME.g:5104:3: ( RULE_ID )
            // InternalGAME.g:5105:4: RULE_ID
            {
             before(grammarAccess.getConditionAccess().getConnaissanceTrueConnaissanceIDTerminalRuleCall_8_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getConditionAccess().getConnaissanceTrueConnaissanceIDTerminalRuleCall_8_0_1()); 

            }

             after(grammarAccess.getConditionAccess().getConnaissanceTrueConnaissanceCrossReference_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__ConnaissanceTrueAssignment_8"


    // $ANTLR start "rule__Condition__ConnaissanceFalseAssignment_10"
    // InternalGAME.g:5116:1: rule__Condition__ConnaissanceFalseAssignment_10 : ( ( RULE_ID ) ) ;
    public final void rule__Condition__ConnaissanceFalseAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:5120:1: ( ( ( RULE_ID ) ) )
            // InternalGAME.g:5121:2: ( ( RULE_ID ) )
            {
            // InternalGAME.g:5121:2: ( ( RULE_ID ) )
            // InternalGAME.g:5122:3: ( RULE_ID )
            {
             before(grammarAccess.getConditionAccess().getConnaissanceFalseConnaissanceCrossReference_10_0()); 
            // InternalGAME.g:5123:3: ( RULE_ID )
            // InternalGAME.g:5124:4: RULE_ID
            {
             before(grammarAccess.getConditionAccess().getConnaissanceFalseConnaissanceIDTerminalRuleCall_10_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getConditionAccess().getConnaissanceFalseConnaissanceIDTerminalRuleCall_10_0_1()); 

            }

             after(grammarAccess.getConditionAccess().getConnaissanceFalseConnaissanceCrossReference_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__ConnaissanceFalseAssignment_10"


    // $ANTLR start "rule__Condition__LieuxExploresAssignment_12"
    // InternalGAME.g:5135:1: rule__Condition__LieuxExploresAssignment_12 : ( ( RULE_ID ) ) ;
    public final void rule__Condition__LieuxExploresAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:5139:1: ( ( ( RULE_ID ) ) )
            // InternalGAME.g:5140:2: ( ( RULE_ID ) )
            {
            // InternalGAME.g:5140:2: ( ( RULE_ID ) )
            // InternalGAME.g:5141:3: ( RULE_ID )
            {
             before(grammarAccess.getConditionAccess().getLieuxExploresLieuCrossReference_12_0()); 
            // InternalGAME.g:5142:3: ( RULE_ID )
            // InternalGAME.g:5143:4: RULE_ID
            {
             before(grammarAccess.getConditionAccess().getLieuxExploresLieuIDTerminalRuleCall_12_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getConditionAccess().getLieuxExploresLieuIDTerminalRuleCall_12_0_1()); 

            }

             after(grammarAccess.getConditionAccess().getLieuxExploresLieuCrossReference_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__LieuxExploresAssignment_12"


    // $ANTLR start "rule__Chemin__EtatAssignment_1"
    // InternalGAME.g:5154:1: rule__Chemin__EtatAssignment_1 : ( ruleEtatChemin ) ;
    public final void rule__Chemin__EtatAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:5158:1: ( ( ruleEtatChemin ) )
            // InternalGAME.g:5159:2: ( ruleEtatChemin )
            {
            // InternalGAME.g:5159:2: ( ruleEtatChemin )
            // InternalGAME.g:5160:3: ruleEtatChemin
            {
             before(grammarAccess.getCheminAccess().getEtatEtatCheminEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEtatChemin();

            state._fsp--;

             after(grammarAccess.getCheminAccess().getEtatEtatCheminEnumRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__EtatAssignment_1"


    // $ANTLR start "rule__Chemin__PredecessorAssignment_3"
    // InternalGAME.g:5169:1: rule__Chemin__PredecessorAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__Chemin__PredecessorAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:5173:1: ( ( ( RULE_ID ) ) )
            // InternalGAME.g:5174:2: ( ( RULE_ID ) )
            {
            // InternalGAME.g:5174:2: ( ( RULE_ID ) )
            // InternalGAME.g:5175:3: ( RULE_ID )
            {
             before(grammarAccess.getCheminAccess().getPredecessorLieuCrossReference_3_0()); 
            // InternalGAME.g:5176:3: ( RULE_ID )
            // InternalGAME.g:5177:4: RULE_ID
            {
             before(grammarAccess.getCheminAccess().getPredecessorLieuIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getCheminAccess().getPredecessorLieuIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getCheminAccess().getPredecessorLieuCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__PredecessorAssignment_3"


    // $ANTLR start "rule__Chemin__SuccessorAssignment_5"
    // InternalGAME.g:5188:1: rule__Chemin__SuccessorAssignment_5 : ( ( RULE_ID ) ) ;
    public final void rule__Chemin__SuccessorAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:5192:1: ( ( ( RULE_ID ) ) )
            // InternalGAME.g:5193:2: ( ( RULE_ID ) )
            {
            // InternalGAME.g:5193:2: ( ( RULE_ID ) )
            // InternalGAME.g:5194:3: ( RULE_ID )
            {
             before(grammarAccess.getCheminAccess().getSuccessorLieuCrossReference_5_0()); 
            // InternalGAME.g:5195:3: ( RULE_ID )
            // InternalGAME.g:5196:4: RULE_ID
            {
             before(grammarAccess.getCheminAccess().getSuccessorLieuIDTerminalRuleCall_5_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getCheminAccess().getSuccessorLieuIDTerminalRuleCall_5_0_1()); 

            }

             after(grammarAccess.getCheminAccess().getSuccessorLieuCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__SuccessorAssignment_5"


    // $ANTLR start "rule__Chemin__ConditionsVisibleAssignment_8"
    // InternalGAME.g:5207:1: rule__Chemin__ConditionsVisibleAssignment_8 : ( ruleCondition ) ;
    public final void rule__Chemin__ConditionsVisibleAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:5211:1: ( ( ruleCondition ) )
            // InternalGAME.g:5212:2: ( ruleCondition )
            {
            // InternalGAME.g:5212:2: ( ruleCondition )
            // InternalGAME.g:5213:3: ruleCondition
            {
             before(grammarAccess.getCheminAccess().getConditionsVisibleConditionParserRuleCall_8_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getCheminAccess().getConditionsVisibleConditionParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__ConditionsVisibleAssignment_8"


    // $ANTLR start "rule__Chemin__ConditionsOuvertureAssignment_10"
    // InternalGAME.g:5222:1: rule__Chemin__ConditionsOuvertureAssignment_10 : ( ruleCondition ) ;
    public final void rule__Chemin__ConditionsOuvertureAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:5226:1: ( ( ruleCondition ) )
            // InternalGAME.g:5227:2: ( ruleCondition )
            {
            // InternalGAME.g:5227:2: ( ruleCondition )
            // InternalGAME.g:5228:3: ruleCondition
            {
             before(grammarAccess.getCheminAccess().getConditionsOuvertureConditionParserRuleCall_10_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getCheminAccess().getConditionsOuvertureConditionParserRuleCall_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__ConditionsOuvertureAssignment_10"


    // $ANTLR start "rule__Chemin__ConditionsObligationAssignment_12"
    // InternalGAME.g:5237:1: rule__Chemin__ConditionsObligationAssignment_12 : ( ruleCondition ) ;
    public final void rule__Chemin__ConditionsObligationAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:5241:1: ( ( ruleCondition ) )
            // InternalGAME.g:5242:2: ( ruleCondition )
            {
            // InternalGAME.g:5242:2: ( ruleCondition )
            // InternalGAME.g:5243:3: ruleCondition
            {
             before(grammarAccess.getCheminAccess().getConditionsObligationConditionParserRuleCall_12_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getCheminAccess().getConditionsObligationConditionParserRuleCall_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__ConditionsObligationAssignment_12"


    // $ANTLR start "rule__Chemin__ObjetsTransmisAssignment_14"
    // InternalGAME.g:5252:1: rule__Chemin__ObjetsTransmisAssignment_14 : ( ruleObjet ) ;
    public final void rule__Chemin__ObjetsTransmisAssignment_14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:5256:1: ( ( ruleObjet ) )
            // InternalGAME.g:5257:2: ( ruleObjet )
            {
            // InternalGAME.g:5257:2: ( ruleObjet )
            // InternalGAME.g:5258:3: ruleObjet
            {
             before(grammarAccess.getCheminAccess().getObjetsTransmisObjetParserRuleCall_14_0()); 
            pushFollow(FOLLOW_2);
            ruleObjet();

            state._fsp--;

             after(grammarAccess.getCheminAccess().getObjetsTransmisObjetParserRuleCall_14_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__ObjetsTransmisAssignment_14"


    // $ANTLR start "rule__Chemin__PrixObjetsAssignment_16"
    // InternalGAME.g:5267:1: rule__Chemin__PrixObjetsAssignment_16 : ( ruleObjet ) ;
    public final void rule__Chemin__PrixObjetsAssignment_16() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:5271:1: ( ( ruleObjet ) )
            // InternalGAME.g:5272:2: ( ruleObjet )
            {
            // InternalGAME.g:5272:2: ( ruleObjet )
            // InternalGAME.g:5273:3: ruleObjet
            {
             before(grammarAccess.getCheminAccess().getPrixObjetsObjetParserRuleCall_16_0()); 
            pushFollow(FOLLOW_2);
            ruleObjet();

            state._fsp--;

             after(grammarAccess.getCheminAccess().getPrixObjetsObjetParserRuleCall_16_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__PrixObjetsAssignment_16"


    // $ANTLR start "rule__Chemin__QualificationAssignment_17"
    // InternalGAME.g:5282:1: rule__Chemin__QualificationAssignment_17 : ( ruleQualification ) ;
    public final void rule__Chemin__QualificationAssignment_17() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:5286:1: ( ( ruleQualification ) )
            // InternalGAME.g:5287:2: ( ruleQualification )
            {
            // InternalGAME.g:5287:2: ( ruleQualification )
            // InternalGAME.g:5288:3: ruleQualification
            {
             before(grammarAccess.getCheminAccess().getQualificationQualificationParserRuleCall_17_0()); 
            pushFollow(FOLLOW_2);
            ruleQualification();

            state._fsp--;

             after(grammarAccess.getCheminAccess().getQualificationQualificationParserRuleCall_17_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Chemin__QualificationAssignment_17"


    // $ANTLR start "rule__Personne__NameAssignment_1"
    // InternalGAME.g:5297:1: rule__Personne__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Personne__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:5301:1: ( ( ruleEString ) )
            // InternalGAME.g:5302:2: ( ruleEString )
            {
            // InternalGAME.g:5302:2: ( ruleEString )
            // InternalGAME.g:5303:3: ruleEString
            {
             before(grammarAccess.getPersonneAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getPersonneAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Personne__NameAssignment_1"


    // $ANTLR start "rule__Personne__ActiviteAssignment_4"
    // InternalGAME.g:5312:1: rule__Personne__ActiviteAssignment_4 : ( ruleEtatActivite ) ;
    public final void rule__Personne__ActiviteAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:5316:1: ( ( ruleEtatActivite ) )
            // InternalGAME.g:5317:2: ( ruleEtatActivite )
            {
            // InternalGAME.g:5317:2: ( ruleEtatActivite )
            // InternalGAME.g:5318:3: ruleEtatActivite
            {
             before(grammarAccess.getPersonneAccess().getActiviteEtatActiviteEnumRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleEtatActivite();

            state._fsp--;

             after(grammarAccess.getPersonneAccess().getActiviteEtatActiviteEnumRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Personne__ActiviteAssignment_4"


    // $ANTLR start "rule__Personne__ConditionsVisibleAssignment_6"
    // InternalGAME.g:5327:1: rule__Personne__ConditionsVisibleAssignment_6 : ( ruleCondition ) ;
    public final void rule__Personne__ConditionsVisibleAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:5331:1: ( ( ruleCondition ) )
            // InternalGAME.g:5332:2: ( ruleCondition )
            {
            // InternalGAME.g:5332:2: ( ruleCondition )
            // InternalGAME.g:5333:3: ruleCondition
            {
             before(grammarAccess.getPersonneAccess().getConditionsVisibleConditionParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getPersonneAccess().getConditionsVisibleConditionParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Personne__ConditionsVisibleAssignment_6"


    // $ANTLR start "rule__Personne__ConditionsObligationAssignment_8"
    // InternalGAME.g:5342:1: rule__Personne__ConditionsObligationAssignment_8 : ( ruleCondition ) ;
    public final void rule__Personne__ConditionsObligationAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:5346:1: ( ( ruleCondition ) )
            // InternalGAME.g:5347:2: ( ruleCondition )
            {
            // InternalGAME.g:5347:2: ( ruleCondition )
            // InternalGAME.g:5348:3: ruleCondition
            {
             before(grammarAccess.getPersonneAccess().getConditionsObligationConditionParserRuleCall_8_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getPersonneAccess().getConditionsObligationConditionParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Personne__ConditionsObligationAssignment_8"


    // $ANTLR start "rule__Personne__InteractionAssignment_10"
    // InternalGAME.g:5357:1: rule__Personne__InteractionAssignment_10 : ( ruleInteraction ) ;
    public final void rule__Personne__InteractionAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:5361:1: ( ( ruleInteraction ) )
            // InternalGAME.g:5362:2: ( ruleInteraction )
            {
            // InternalGAME.g:5362:2: ( ruleInteraction )
            // InternalGAME.g:5363:3: ruleInteraction
            {
             before(grammarAccess.getPersonneAccess().getInteractionInteractionParserRuleCall_10_0()); 
            pushFollow(FOLLOW_2);
            ruleInteraction();

            state._fsp--;

             after(grammarAccess.getPersonneAccess().getInteractionInteractionParserRuleCall_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Personne__InteractionAssignment_10"


    // $ANTLR start "rule__Personne__QualificationAssignment_11"
    // InternalGAME.g:5372:1: rule__Personne__QualificationAssignment_11 : ( ruleQualification ) ;
    public final void rule__Personne__QualificationAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:5376:1: ( ( ruleQualification ) )
            // InternalGAME.g:5377:2: ( ruleQualification )
            {
            // InternalGAME.g:5377:2: ( ruleQualification )
            // InternalGAME.g:5378:3: ruleQualification
            {
             before(grammarAccess.getPersonneAccess().getQualificationQualificationParserRuleCall_11_0()); 
            pushFollow(FOLLOW_2);
            ruleQualification();

            state._fsp--;

             after(grammarAccess.getPersonneAccess().getQualificationQualificationParserRuleCall_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Personne__QualificationAssignment_11"


    // $ANTLR start "rule__Interaction__ChoixDebutAssignment_3"
    // InternalGAME.g:5387:1: rule__Interaction__ChoixDebutAssignment_3 : ( ruleChoix ) ;
    public final void rule__Interaction__ChoixDebutAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:5391:1: ( ( ruleChoix ) )
            // InternalGAME.g:5392:2: ( ruleChoix )
            {
            // InternalGAME.g:5392:2: ( ruleChoix )
            // InternalGAME.g:5393:3: ruleChoix
            {
             before(grammarAccess.getInteractionAccess().getChoixDebutChoixParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleChoix();

            state._fsp--;

             after(grammarAccess.getInteractionAccess().getChoixDebutChoixParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__ChoixDebutAssignment_3"


    // $ANTLR start "rule__Interaction__ChoixInterAssignment_5"
    // InternalGAME.g:5402:1: rule__Interaction__ChoixInterAssignment_5 : ( ruleChoix ) ;
    public final void rule__Interaction__ChoixInterAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:5406:1: ( ( ruleChoix ) )
            // InternalGAME.g:5407:2: ( ruleChoix )
            {
            // InternalGAME.g:5407:2: ( ruleChoix )
            // InternalGAME.g:5408:3: ruleChoix
            {
             before(grammarAccess.getInteractionAccess().getChoixInterChoixParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleChoix();

            state._fsp--;

             after(grammarAccess.getInteractionAccess().getChoixInterChoixParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__ChoixInterAssignment_5"


    // $ANTLR start "rule__Interaction__ChoixFinAssignment_7"
    // InternalGAME.g:5417:1: rule__Interaction__ChoixFinAssignment_7 : ( ruleChoix ) ;
    public final void rule__Interaction__ChoixFinAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:5421:1: ( ( ruleChoix ) )
            // InternalGAME.g:5422:2: ( ruleChoix )
            {
            // InternalGAME.g:5422:2: ( ruleChoix )
            // InternalGAME.g:5423:3: ruleChoix
            {
             before(grammarAccess.getInteractionAccess().getChoixFinChoixParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleChoix();

            state._fsp--;

             after(grammarAccess.getInteractionAccess().getChoixFinChoixParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__ChoixFinAssignment_7"


    // $ANTLR start "rule__Interaction__ConditionAssignment_9"
    // InternalGAME.g:5432:1: rule__Interaction__ConditionAssignment_9 : ( ruleCondition ) ;
    public final void rule__Interaction__ConditionAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:5436:1: ( ( ruleCondition ) )
            // InternalGAME.g:5437:2: ( ruleCondition )
            {
            // InternalGAME.g:5437:2: ( ruleCondition )
            // InternalGAME.g:5438:3: ruleCondition
            {
             before(grammarAccess.getInteractionAccess().getConditionConditionParserRuleCall_9_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getInteractionAccess().getConditionConditionParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__ConditionAssignment_9"


    // $ANTLR start "rule__Choix__ActionsAssignment_3"
    // InternalGAME.g:5447:1: rule__Choix__ActionsAssignment_3 : ( ruleAction ) ;
    public final void rule__Choix__ActionsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:5451:1: ( ( ruleAction ) )
            // InternalGAME.g:5452:2: ( ruleAction )
            {
            // InternalGAME.g:5452:2: ( ruleAction )
            // InternalGAME.g:5453:3: ruleAction
            {
             before(grammarAccess.getChoixAccess().getActionsActionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleAction();

            state._fsp--;

             after(grammarAccess.getChoixAccess().getActionsActionParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Choix__ActionsAssignment_3"


    // $ANTLR start "rule__Action__ObjetsConsommesAssignment_2_1"
    // InternalGAME.g:5462:1: rule__Action__ObjetsConsommesAssignment_2_1 : ( ruleObjet ) ;
    public final void rule__Action__ObjetsConsommesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:5466:1: ( ( ruleObjet ) )
            // InternalGAME.g:5467:2: ( ruleObjet )
            {
            // InternalGAME.g:5467:2: ( ruleObjet )
            // InternalGAME.g:5468:3: ruleObjet
            {
             before(grammarAccess.getActionAccess().getObjetsConsommesObjetParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleObjet();

            state._fsp--;

             after(grammarAccess.getActionAccess().getObjetsConsommesObjetParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__ObjetsConsommesAssignment_2_1"


    // $ANTLR start "rule__Action__ObjetsProduitsAssignment_3_1"
    // InternalGAME.g:5477:1: rule__Action__ObjetsProduitsAssignment_3_1 : ( ruleObjet ) ;
    public final void rule__Action__ObjetsProduitsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:5481:1: ( ( ruleObjet ) )
            // InternalGAME.g:5482:2: ( ruleObjet )
            {
            // InternalGAME.g:5482:2: ( ruleObjet )
            // InternalGAME.g:5483:3: ruleObjet
            {
             before(grammarAccess.getActionAccess().getObjetsProduitsObjetParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleObjet();

            state._fsp--;

             after(grammarAccess.getActionAccess().getObjetsProduitsObjetParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__ObjetsProduitsAssignment_3_1"


    // $ANTLR start "rule__Action__ConnaissanceProduitsAssignment_4_1"
    // InternalGAME.g:5492:1: rule__Action__ConnaissanceProduitsAssignment_4_1 : ( ruleConnaissance ) ;
    public final void rule__Action__ConnaissanceProduitsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:5496:1: ( ( ruleConnaissance ) )
            // InternalGAME.g:5497:2: ( ruleConnaissance )
            {
            // InternalGAME.g:5497:2: ( ruleConnaissance )
            // InternalGAME.g:5498:3: ruleConnaissance
            {
             before(grammarAccess.getActionAccess().getConnaissanceProduitsConnaissanceParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleConnaissance();

            state._fsp--;

             after(grammarAccess.getActionAccess().getConnaissanceProduitsConnaissanceParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__ConnaissanceProduitsAssignment_4_1"


    // $ANTLR start "rule__Action__QualificationAssignment_5"
    // InternalGAME.g:5507:1: rule__Action__QualificationAssignment_5 : ( ruleQualification ) ;
    public final void rule__Action__QualificationAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:5511:1: ( ( ruleQualification ) )
            // InternalGAME.g:5512:2: ( ruleQualification )
            {
            // InternalGAME.g:5512:2: ( ruleQualification )
            // InternalGAME.g:5513:3: ruleQualification
            {
             before(grammarAccess.getActionAccess().getQualificationQualificationParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleQualification();

            state._fsp--;

             after(grammarAccess.getActionAccess().getQualificationQualificationParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__QualificationAssignment_5"


    // $ANTLR start "rule__Qualification__TexteAssignment_1"
    // InternalGAME.g:5522:1: rule__Qualification__TexteAssignment_1 : ( ruleEString ) ;
    public final void rule__Qualification__TexteAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:5526:1: ( ( ruleEString ) )
            // InternalGAME.g:5527:2: ( ruleEString )
            {
            // InternalGAME.g:5527:2: ( ruleEString )
            // InternalGAME.g:5528:3: ruleEString
            {
             before(grammarAccess.getQualificationAccess().getTexteEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getQualificationAccess().getTexteEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Qualification__TexteAssignment_1"


    // $ANTLR start "rule__Qualification__ConditionAssignment_3"
    // InternalGAME.g:5537:1: rule__Qualification__ConditionAssignment_3 : ( ruleCondition ) ;
    public final void rule__Qualification__ConditionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGAME.g:5541:1: ( ( ruleCondition ) )
            // InternalGAME.g:5542:2: ( ruleCondition )
            {
            // InternalGAME.g:5542:2: ( ruleCondition )
            // InternalGAME.g:5543:3: ruleCondition
            {
             before(grammarAccess.getQualificationAccess().getConditionConditionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getQualificationAccess().getConditionConditionParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Qualification__ConditionAssignment_3"

    // Delegated rules


    protected DFA10 dfa10 = new DFA10(this);
    static final String dfa_1s = "\26\uffff";
    static final String dfa_2s = "\1\1\25\uffff";
    static final String dfa_3s = "\1\25\1\uffff\1\4\2\24\1\52\1\13\2\24\1\53\12\5\1\25\1\uffff";
    static final String dfa_4s = "\1\105\1\uffff\1\5\2\24\1\52\1\14\2\24\1\53\2\54\2\55\2\56\2\57\3\25\1\uffff";
    static final String dfa_5s = "\1\uffff\1\2\23\uffff\1\1";
    static final String dfa_6s = "\26\uffff}>";
    static final String[] dfa_7s = {
            "\1\1\2\uffff\1\1\3\uffff\1\1\7\uffff\1\1\21\uffff\1\1\14\uffff\2\1\1\2",
            "",
            "\1\3\1\4",
            "\1\5",
            "\1\5",
            "\1\6",
            "\1\7\1\10",
            "\1\11",
            "\1\11",
            "\1\12",
            "\1\13\46\uffff\1\14",
            "\1\13\46\uffff\1\14",
            "\1\15\47\uffff\1\16",
            "\1\15\47\uffff\1\16",
            "\1\17\50\uffff\1\20",
            "\1\17\50\uffff\1\20",
            "\1\21\51\uffff\1\22",
            "\1\21\51\uffff\1\22",
            "\1\23\17\uffff\1\24",
            "\1\23\17\uffff\1\24",
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

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 1406:2: ( rule__Objet__QualificationAssignment_9 )*";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000202000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000008000020L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000040L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000100000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000180000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0080000000800000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000001010000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000002200000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0001000000200000L,0x0000000000000020L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000020400000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000002400000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0001000000200000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000100000000020L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000200000000020L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000400000000020L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000800000000020L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000200020L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0040000010000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000010200000L,0x0000000000000020L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000200000L,0x0000000000000020L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0xA000000000000000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000200000L,0x0000000000000002L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000200000L,0x000000000000003CL});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000200000000L});

}
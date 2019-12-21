package com.rima.quizz;

public class QuestionLibrary {
    private String mQuestion [] = {
            "En chimie, comment est noté le chrolure de sodium?",
            "Comment appelle-t-on un corps qui ne conduit pas le courant electrique?",
            "Un molecule est un ensembe ...",
            "De quel elemnt 'Au' est t-il le symbole?",
            "Les trois etats de la matière sont: le solide, le liquide et ...",
            "Quel est le symbole chimique du platine?",
            "De quel élément C est-il le symbole?",
            "Quel est le symbole chimique du mercure?",
            "Comment appelle-t-on un ion chargé negativement?",
            "De quel element S est-il le symbole?",
            "Lequel de ces corps ne conduit pas le courant electrique?",
            "Comment nomme-t-on le passage d'un corps de l'etat solide a l'etat gazeux?",
            "Quel est le symbole chimique du chrore?",
            "De quel élément 'O' est-il le symbole?",
            "Quel élément chimique est utilisé comme combustible dans les centrales nucléaires ?",
            "Une lentille qui fait grossir les objets est appelée lentille ...",
            "Une lentille est un milieu transparent limité par deux faces dont l'une au moins est ...",
            "La lune est une source de lumière ...",
            "La deviation que subit la lumière lorsqu'elle traverse d'un milieu à l'autre milieu est appelé ...",
            "La distance qui sépare le centre optique du foyer objet est appelée distance ...",
            "Comment appelle-t-on l'inverse de la distance focale ?",
            "Pour une lentille divergente, tout rayon émergeant voit son prolongement passer par le foyer ...",
            "Tout rayon passant par le foyer objet d'une lentille convergente emerge, par rapport à la lentille, de maniére ...",
            "Quel est le symbole chimique du magnésium ?",
            "Quel est le symbole chimique de l'eau ?",
            "Quel est le symbole chimique de l'hydrogéne ?"


    };
    private String mChoice [][] = {
            {"H2O", "CIS", "NaCl"},
            {"Isolant", "Isolateur", "Isoleur"},
            {"d'electrons", "de neutrons", "d'atomes"},
            {"Or", "Alluminieum", "Argent"},
            {"l'eau", "l'aire", "le gaz"},
            {"Pl", "Pt", "Pn"},
            {"Carbone", "Calcium", "Carbonate"},
            {"Me", "Mr", "Hg"},
            {"un cation", "un anion", "un electron"},
            {"Silicium", "Soufre", "Sodium"},
            {"l'eau", "le cuivre", "le plastique"},
            {"liquéfaction", "vaporisation", "sublimation"},
            {"Ch", "Cl", "Chl"},
            {"Or", "Onde", "Oxygéne"},
            {"Uranium", "Plutonium", "Nuclénium"},
            {"divergente", "convergente", "correcte"},
            {"carrée", "canonique", "sphérique"},
            {"primaire", "secondaire", "tertiaire"},
            {"réflexion", "réfraction", "lentille"},
            {"axiale", "faciale", "focale"},
            {"convergence", "vergence", "divergence"},
            {"objet", "image", "carré"},
            {"perpenduculaire", "parallèle", "oblique"},
            {"Ms", "Mg", "Mm"},
            {"H20", "H2O2", "H"},
            {"H", "H2O", "H4" }



    };
    private String mCorrectAnswer[] = {"NaCl", "Isolant", "d'atomes", "Or", "le gaz", "Pt", "Carbone", "Hg", "un anion",
            "Soufre", "le plastique", "sublimation", "Cl", "Oxygéne", "Uranium", "convergente", "sphérique", "secondaire",
    "réfraction", "focale", "vergence", "objet", "parallèle", "Mg", "H2O", "H"};

    public String getQuestion(int a)
    {
        String question = mQuestion[a];
        return question;
    }
    public String getmQuestion(int a)
    {
        String numQuestion = mQuestion[a];
        return numQuestion;
    }
    public String getChoice1(int a)
    {
        String choice0 = mChoice[a][0];
        return choice0;
    }
    public String getChoice2(int a)
    {
        String choice1 = mChoice[a][1];
        return choice1;
    }
    public String getChoice3(int a)
    {
        String choice2 = mChoice[a][2];
        return choice2;
    }
    public String getCorrectAnswer(int a)
    {
        String answer = mCorrectAnswer[a];
        return answer;
    }
}

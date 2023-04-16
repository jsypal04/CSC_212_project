import java.util.Random;
import java.util.HashMap;

public class Demo {

    private static HashMap<String, String[]> grammar = new HashMap<String, String[]>();

    // setup grammar production rules
    public static void setupGrammar() {
        String[] s = {"<noun><verb>"};
        grammar.put("<start>", s);

        // nouns
        String[] n1 = {"<person>", "<place>", "<thing>", "<idea>"};
        String[] n2 = {"<name>", "<article><occupation>", "<article><adjective><occupation>"}; // person
        String[] n3 = {"<general>", "<adjective><general>"}; // idea
        String[] n4 = {"<article><thing noun>", "<article><adjective><thing noun>"}; // thing
        String[] n5 = {"<article><place noun>", "<article><adjective><place noun>"}; // place
        String[] n6 = {"Joe ", "Hieu Bui ", "Luke Bubel ", "John Cardillo ", "Jeffery Koeferl "}; // name
        String[] n7 = {"religion ", "love ", "math ", "CSC 212 "}; // general
        String[] n9 = {"doctor ", "lawyer ", "teacher ", "developer ", "real estate agent ", "police officer ", "fireman ", "student ", "businessman ", "CEO ", "marketing assistant ", "freelancer ", "photographer ", "web developer ", "cashier "}; // occupation
        String[] n10 = {"desk ", "dog ", "chair ", "street ", "building ", "window ", "cat ", "turtle ", "wall ", "stone ", "door ", "floor ", "painting ", "frame ", "lamp ", "cushion ", "alarm ", "fire ", "ladder "}; // thing noun
        String[] n11 = {"Pryz ", "hospital ", "church ", "school ", "university ", "Garv ", "office ", "room ", "parking lot "}; // place noun
        String[] n12 = {"<noun>"}; // pred nom
        String[] n13 = {"<noun>"}; // direct object

        grammar.put("<noun>", n1);
        grammar.put("<person>", n2);
        grammar.put("<idea>", n3);
        grammar.put("<thing>", n4);
        grammar.put("<place>", n5);
        grammar.put("<name>", n6);
        grammar.put("<general>", n7);
        grammar.put("<occupation>", n9);
        grammar.put("<thing noun>", n10);
        grammar.put("<place noun>", n11);
        grammar.put("<pred nom>", n12);
        grammar.put("<direct object>", n13);

        // verbs
        String[] v1 = {"<act>", "<link>"};
        String[] v2 = {"<trans>", "<intrans>"};
        String[] v3 = {"<trans verb><direct object>", "<adverb><trans verb><direct object>"};
        String[] v4 = {"<intrans verb>", "<intrans verb><adverb>"};
        String[] v5 = {"<link being><pred nom>", "<link being><pred adj>", "<link other><pred nom>"};
        String[] v6 = {"is ", "was ", "became "}; // linking verbs
        String[] v9 = {"has ", "had "};
        String[] v7 = {"accepts ", "bothers ", "defines ", "destroyed ", "read ", "earns ", "earned ", "discovers ", "discovered ", "embarrasses ", "embarrassed ", "cleans ", "cleaned ", "gathers ", "gathered ", "messages ", "messaged ", "interrupts ", "interrupted "}; // transitive verbs
        String[] v8 = {"laughs ", "was laughing ", "smiles ", "was smiling ", "claps ", "was clapping ", "ate ", "collapses ", "collapsed ", "was collapsing ", "falls ", "fell ", "was falling ", "learns ", "learned ", "was learning ", "reclines ", "reclined ", "sleeps ", "slept ", "walks ", "walked "}; // intransitive verbs

        grammar.put("<verb>", v1);
        grammar.put("<act>", v2);
        grammar.put("<trans>", v3);
        grammar.put("<intrans>", v4);
        grammar.put("<link>", v5);
        grammar.put("<link being>", v6);
        grammar.put("<link other>", v9);
        grammar.put("<trans verb>", v7);
        grammar.put("<intrans verb>", v8);

        // articles
        String[] art = {"a ", "the "};

        grammar.put("<article>", art);

        // adjectives
        String[] adj1 = {"brown ", "bright ", "angry ", "clear ", "curious ", "dangerous ", "dull ", "fantastic ", "gifted ", "hungry ", "important ", "nasty ", "proud ", "selfish ", "shiny ", "stupid ", "talented ", "witty "};
        String[] adj2 = {"<adjective>"}; // pred adj

        grammar.put("<adjective>", adj1);
        grammar.put("<pred adj>", adj2);

        //adverbs
        String[] adv1 = {"briliantly ", "unfortunatly ", "well ", "diligently ", "doubtfully ", "far ", "fast ", "longingly ", "loosely ", "loudly ", "happily ", "rapidly ", "rarely ", "sternly ", "stricly ", "warmly ", "too ", "tremendously ", "greedily "};

        grammar.put("<adverb>", adv1);
    }

    public static String getRandElem(String[] arr) {
        Random rand = new Random();
        return arr[rand.nextInt(arr.length)];
    }

    public static String produce(String input) {
        String output = "";
        while (input.contains("<") && input.contains(">")) {
            int varStart = input.indexOf("<");
            int varFinish = input.indexOf(">");
            String var = input.substring(varStart, varFinish + 1);
            input = input.substring(varFinish + 1);

            String newVar = getRandElem(grammar.get(var));
            if (!newVar.contains("<") && !newVar.contains(">")) {
                output += newVar;
            }
            else {
                input = newVar + input;
            }
        }

        return output;
    }

    public static void main(String[] args) {
        // run setup functions
        setupGrammar();
        

        System.out.println();
        System.out.println(produce("<start>"));
        System.out.println();
    }
}
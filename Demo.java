public class Demo {
    
    public static String produce(String var) {
        String result = "not a variable, check string processing algoritm in production method";
        if (var.equals("<start>")) {
            result =  "<subject><predicate>";
        }
        else if (var.equals("<subject>")) {
            result = "<noun>";
        }
        else if (var.equals("<predicate>")) {
            result = "<verb><direct object>";
        }
        else if (var.equals("<direct object>")) {
            result = "<noun>";
        }
        else if (var.equals("<noun>")) {
            result = "dog ";
        }
        else if (var.equals("<verb>")) {
            result = "runs ";
        }
        return result;
    }


    public static String production(String input) {
        while (input.contains("<") && input.contains(">")) {
            int varStart = input.indexOf("<");
            int varFinish = input.indexOf(">");

            String var = input.substring(varStart, varFinish + 1);
            String newStr = produce(var);

            input = input.replaceFirst(var, newStr);
        }

        System.out.println(input.trim());
        
        return "done";
    }

    public static void main(String[] args) {
        production("<start>");
    }
}
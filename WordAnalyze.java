import java.util.ArrayList;
import java.util.HashMap;

public class WordAnalyze {
    private ArrayList<String> strArray;
    private StringBuilder word = new StringBuilder();

    private final HashMap< String, String> keywords = new HashMap< String, String>(){
        {
            put("if", "If");
            put("else", "Else");
            put("while", "While");
            put("break", "Break");
            put("continue", "Continue");
            put("return", "Return");
        }
    };

    private final HashMap<Character, String> charletters = new HashMap<Character, String>(){
        {
            put(';', "Semicolon");
            put('(', "LPar");
            put(')', "RPar");
            put('{', "LBrace");
            put('}', "RBrace");
            put('+', "Plus");
            put('*', "Mult");
            put('/', "Div");
            put('<', "Lt");
            put('>', "Gt");
        }
    };

    public WordAnalyze(ArrayList<String> arrayList){
        this.strArray = arrayList;
    }

    boolean isLetter(Character ch){
        return ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'));
    }

    boolean isNum(Character ch){
        return (ch >= '0' && ch <= '9');
    }

    void analyze(){
        int i, j, len;
        char[] var;
        for (i = 0; i < strArray.size(); i++){
            var = strArray.get(i).toCharArray();
            len = var.length;
            for (j = 0; j < len; j++){
                Character ch = var[j];
                if (isLetter(ch)){
                    while (isLetter(ch) || isNum(ch) || ch == '_'){
                        word.append(ch);
                        if (j + 1 < len){
                            ch = var[++j];
                        }
                        else{
                            break;
                        }
                    }
                    if (!isLetter(ch)){
                        j--;
                    }
                    if (keywords.containsKey(word.toString())){
                        System.out.println(keywords.get(word.toString()));
                    }
                    else{
                        System.out.println("Ident(" + word.toString() + ")");
                    }
                    word.setLength(0);
                }
                else if (isNum(ch)){
                    while (isNum(ch)){
                        word.append(ch);
                        if (j + 1 < len) {
                            ch = var[++j];
                        }
                        else{
                            break;
                        }
                    }
                    if (!isNum(ch)){
                        j--;
                    }
                    System.out.println("Number(" + word.toString() + ")");
                    word.setLength(0);
                }
                else if (charletters.containsKey(ch)){
                    System.out.println(charletters.get(ch));
                }
                else if (ch == '='){
                    word.append(ch);
                    if (j + 1 < len) {
                        ch = var[++j];
                        if (ch == '=') {
                            word.append(ch);
                            System.out.println("Eq");
                        }
                        else{
                            j--;
                            System.out.println("Assign");
                        }
                    }
                    else{
                        System.out.println("Assign");
                    }
                    word.setLength(0);
                }
                else if (ch == '\n' || ch == '\t' || ch == ' '){
                    continue;
                }
                else{
                    System.out.println("Err");
                    System.exit(0);
                }
            }
        }
    }
}

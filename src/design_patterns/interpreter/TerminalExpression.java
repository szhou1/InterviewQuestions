package design_patterns.interpreter;

import java.util.StringTokenizer;

/**
 * Created by szhou on 3/22/17.
 */
public class TerminalExpression implements Expression {

    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    public boolean interpret(String str) {
        StringTokenizer st = new StringTokenizer(str);
        while(st.hasMoreTokens()) {
            String test = st.nextToken();
            if(test.equals(data)) {
                return true;
            }
        }
        return false;
    }
}

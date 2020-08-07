import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class bracketMatching {
    static boolean isLeft(char c){
        if(c=='['||c=='{'||c=='(')return true;
        return false;
    }
    static char opposite(char c){
        if(c==']')return '[';
        if(c=='}')return '{';
        return '(';
    }
    public static void main(String[]args)throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in) );
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            String line=br.readLine();
            Stack<Character>s= new Stack<>();
            boolean flag=true;
            for(int i=0;i<line.length();i++){
                if(isLeft(line.charAt(i))){
                    s.push(line.charAt(i));
                }else{
                    if(!s.isEmpty()&&s.peek()==opposite(line.charAt(i))){
                        s.pop();
                    }else{
                        flag=false;
                        break;
                    }
                }
            }
            if(flag && s.isEmpty()){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }
    }
}

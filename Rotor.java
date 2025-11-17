public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());
            
    }
    
    public boolean rotate(){
        //TODO
        //true when current character matches it starting character
        
        char[] a = rotorValues.toCharArray();
        char temp = a[a.length - 1];

        for (int i = a.length-1; i >= 1; i--) {
            a[i] = a[i-1];
        }
        a[0] = temp;

        rotorValues = new String(a);

        if (a[0] == startChar) {
            return true;
        }
        
        return false;
    }
    

    public int indexOf(char c){
        //TODO

        int charIdx = rotorValues.indexOf(c);

        return charIdx;
    }

    public char charAt(int idx){
        //TODO
        char charIdx = rotorValues.charAt(idx);

        return charIdx;
        
    }
}
    

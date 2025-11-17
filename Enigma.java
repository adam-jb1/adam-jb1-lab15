public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }


    public String decrypt(String message){        
        //TODO
        //outer -> middle at the same postion
        //middle -> outer at the same letter
        //outer -> inner at the same positon

        if (message == null) {
            return null;
        }
        //System.out.println(message);
        char[] a = message.toCharArray();
        char[] result = new char[a.length];

        for (int i = 0; i < a.length; i++) {
            int idx1 = rotors[2].indexOf(a[i]); //postion of the outer
            char chr1 = rotors[1].charAt(idx1); //character at middle using positon 
            int idx2 = rotors[2].indexOf(chr1); //position of character in the outer
            char chr2 = rotors[0].charAt(idx2); //character at inner postion.
            result[i] = chr2;
            rotate();
        }


        String strResult = new String(result);
        //System.out.println(strResult);

        return strResult;
    }


    
    public String encrypt(String message){
        //TODO

        //Inner -> Outer at same Position
        //Outer -> Middle at the same letter
        //Middle -> outer at the same postion
        

        if (message == null) {
            return null;
        }
        //System.out.println(message);
        char[] a = message.toCharArray();
        char[] result = new char[a.length];

        for (int i = 0; i < a.length; i++) {
            int idx1 = rotors[0].indexOf(a[i]); //position of letter at inner rotor
            char chr1 = rotors[2].charAt(idx1); //character at outer using postion
            int idx2 = rotors[1].indexOf(chr1); //postion of character in the middle
            char chr2 = rotors[2].charAt(idx2); //character at the outer using postion
            result[i] = chr2;
            rotate();
        }


        String strResult = new String(result);
        //System.out.print(strResult);


        return strResult;
    }

    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}

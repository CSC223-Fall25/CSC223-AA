package csc223.aa;
public class DNA {

    public static void main(String[] args) {
        System.out.println(countNucleotides("AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC"));
        System.out.println(transcribe("GATGGAACTTGACTACGTAAATT"));
        System.out.println(reverseComplement("AAAACCCGGT"));
    }

    public static String countNucleotides(String dna){
        //variables are counters for each instance in the string
        int a = 0;
        int c = 0;
        int g = 0;
        int t = 0;

        //counts instances of each character
        for (int i = 0; i < dna.length(); i++){
            char[] len = dna.toCharArray();
            if (len[i] == 'A'){
                a += 1;
            }
            if (len[i] == 'C'){
                c += 1;
            }
            if (len[i] == 'G'){
                g += 1;
            }
            if (len[i] == 'T'){
                t += 1;
            }
        }
        return a + " " + c + " " + g + " " + t;
    }

    public static char[] transcribe(String dna){
        char[] len = dna.toCharArray();
        //replaces all T's wiht U's
        for (int i = 0; i < dna.length(); i++){
            if (len[i] == 'T'){
                len[i] = 'U';
            }
        }
        return len;
    }
    
    public static char[] reverseComplement(String dna){
        String reverse = "";
        char ch;

        //first reverses the string
        for (int i = 0; i < dna.length(); i++){
            ch = dna.charAt(i);
            reverse = ch + reverse; 
        }

        char[] complement = reverse.toCharArray();

        //then replaces A with T vice versa and C with G vice versa
        for (int i = 0; i < reverse.length(); i++) {
            complement[i] = switch (complement[i]) {
                case 'A' -> 'T';
                case 'T' -> 'A';
                case 'C' -> 'G';
                case 'G' -> 'C';
                default -> complement[i]; // In case of unexpected input
            };
        }
        return complement;
    }   
}

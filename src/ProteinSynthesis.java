/*
    Name: Kevin Chen
    PID:  A18063886
 */

/**
 * TODO
 *
 * @author Kevin Chen
 * @since 2/7/24
 */
class ProteinSynthesis {

    private static final int DIVISIBLE_BY_THREE = 3;

    public MyQueue<Character> transcribeDNA(String dna) {
        // TODO
        if (dna.length() % DIVISIBLE_BY_THREE != 0) {
            throw new IllegalArgumentException();
        }
        MyQueue mRNA = new MyQueue();
        String strRNA = dna.replace("T", "U");
        for (char nucleotide : strRNA.toCharArray()) {
            mRNA.enqueue(nucleotide);
        }

        return mRNA;

        //return null;
    }

    public MyQueue<Character> translateRNA(MyQueue<Character> rna) {
        // TODO
        MyQueue translated = new MyQueue();
        boolean start = false;
        while (rna.size() > 0) {
            //if (!start){
            char[] targets = {'A', 'U', 'G'};
            int ind = 0;
            while (ind < DIVISIBLE_BY_THREE) {
                if (targets[ind] == rna.peek()) {
                    ind++;
                    rna.dequeue();
                } else {
                    rna.dequeue();
                    ind = 0;
                }
            }
            //if (char1 == 'A' && char2 == 'U' && char3 == 'G'){
            char aminoAcid = CodonMap.getAminoAcid("AUG");
            translated.enqueue(aminoAcid);
            //start = true;
            //for (int i = 0; i < DIVISIBLE_BY_THREE; i++) {
            //rna.dequeue();

            //} else {
            //rna.dequeue();
            //}
            //}

            //if (start) {
            char char1 = rna.dequeue();
            char char2 = rna.dequeue();
            char char3 = rna.dequeue();
            String group = "" + char1 + char2 + char3;
            aminoAcid = CodonMap.getAminoAcid(group);
            translated.enqueue(aminoAcid);
            if (aminoAcid == '*') {
                break;
            }
        }
        return translated;
        //}
        //}
        //if (translated.size() > 0){
        //MyQueue newTranslated = new CharQueue();
        //while (!translated.isEmpty()){
        //newTranslated.enqueue(translated.dequeue());
        //}
        //return newTranslated;
        //} else {
        //CharQueue newTranslated = new CharQueue(1);
        //return newTranslated;
        //}

        //}
        //return null;
        //}

    }
}
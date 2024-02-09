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
    /**
     * The method transcribeDNA transcribes a string of DNA represented by characters A,T,G,C
     * into mRNA in the form of a charQueue object by replacing all the T's with U's.
     * @param dna is a string of characters A,T,G,C which represent a sequence of nucleotides.
     * @return a CharQueue object which represents the mRNA with each nucleotide as a char
     * in the queue.
     * @throws IllegalArgumentException if the length of the string dna is not divisible by 3
     */
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

    /**
     * The method translateRNA translates an RNA as a CharQueue object with characters A,U,G,C
     * into a protein sequence based on the RNA. It will start transcription when start codon is
     * present and ends when stop codon is reached. It maps the codons to an amino acid that's
     * added to the protein sequence.
     * @param rna is a CharQueue object of characters which represent a sequence of nucleotides.
     * @return a CharQueue object which has the protein sequence from the given mRNA with each
     * character as an amino acid abbreviation.
     */
    public MyQueue<Character> translateRNA(MyQueue<Character> rna) {
        // TODO
        MyQueue translated = new MyQueue();
        //boolean start = false;
        char[] targets = {'A', 'U', 'G'};
        int ind = 0;
        while ((ind < DIVISIBLE_BY_THREE) && (!rna.isEmpty())) {
            if (targets[ind] == rna.peek()) {
                ind++;
                rna.dequeue();
            } else {
                rna.dequeue();
                ind = 0;
            }
        }
        if ((ind == DIVISIBLE_BY_THREE)) {
            translated.enqueue(CodonMap.getAminoAcid("AUG"));
        }
        while (rna.size() > 0) {

            char char1 = rna.dequeue();
            char char2 = rna.dequeue();
            char char3 = rna.dequeue();
            String group = "" + char1 + char2 + char3;
            char aminoAcid = CodonMap.getAminoAcid(group);
            translated.enqueue(aminoAcid);
            if (aminoAcid == '*') {
                break;
            }
        }
        return translated;

    }
}

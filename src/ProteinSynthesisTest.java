import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProteinSynthesisTest {

    @Test
    public void transcribeDNA() {
        ProteinSynthesis translator = new ProteinSynthesis();
        MyQueue dna = translator.transcribeDNA("ATGATCTCGTAA");
        String dnaStr = "";
        while (!dna.isEmpty()){
            dnaStr = dnaStr + dna.dequeue();
        }

        assertEquals("AUGAUCUCGUAA", dnaStr);
        //assertEquals("AUGAUCUCGUAA", translator.transcribeDNA("ATGATCTCGTAA"));
        //assertEquals("CUUGCCCUAACUGACAAACUGUGAUCGACCACUAGCCAUGCCAUU", String.valueOf(translator.transcribeDNA("CTTGCCCTAACTGACAAACTGTGATCGACCACTAGCCATGCCATT").circularArray));
        //assertEquals("GCCUCUUAGACACCCCGAUACAGUGAUUAUGAAAGGUUUGCGGGGCAUGGCUACGACUUGUUCAGCUACGUCCGAGGGCAGAAACUUAUC", String.valueOf(translator.transcribeDNA("GCCTCTTAGACACCCCGATACAGTGATTATGAAAGGTTTGCGGGGCATGGCTACGACTTGTTCAGCTACGTCCGAGGGCAGAAACTTATC").circularArray));
    }

    @Test
    public void translateRNA() {
    }
}
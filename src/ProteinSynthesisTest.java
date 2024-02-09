import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProteinSynthesisTest {
    MyQueue dna;
    public String transformString(MyQueue<Character> dna) {
        String dnaStr = "";
        while (!dna.isEmpty()) {
            dnaStr = dnaStr + dna.dequeue();
        }
        return dnaStr;
    }
    @Test
    public void transcribeDNA() {
        ProteinSynthesis translator = new ProteinSynthesis();
        MyQueue rna1 = translator.transcribeDNA("ATGATCTCGTAA");
        String dnaStr = transformString(rna1);
        assertEquals("AUGAUCUCGUAA", dnaStr);
        MyQueue rna2 = translator.transcribeDNA("CTTGCCCTAACTGACAAACTGTGATCGACCACTAGCCATGCCATT");
        dnaStr = transformString(rna2);
        assertEquals("CUUGCCCUAACUGACAAACUGUGAUCGACCACUAGCCAUGCCAUU", dnaStr);
        MyQueue rna3 = translator.transcribeDNA("GCCTCTTAGACACCCCGATACAGTGATTATGAAAGGTTTGCGGGGCATGGCTACGACTTGTTCAGCTACGTCCGAGGGCAGAAACTTATC");
        dnaStr = transformString(rna3);
        assertEquals("GCCUCUUAGACACCCCGAUACAGUGAUUAUGAAAGGUUUGCGGGGCAUGGCUACGACUUGUUCAGCUACGUCCGAGGGCAGAAACUUAUC", dnaStr);
        Assertions.assertThrows(IllegalArgumentException.class,() -> {
            MyQueue rna4 = translator.transcribeDNA("TACAT");
            MyQueue proteins2 = translator.translateRNA(rna4);
        });

    }

    @Test
    public void translateRNA() {
        ProteinSynthesis translator = new ProteinSynthesis();

        MyQueue rna = translator.transcribeDNA("ATGATCTCGTAA");
        MyQueue protein = translator.translateRNA(rna);
        String proteinStr = transformString(protein);
        assertEquals("MIS*", proteinStr);

        MyQueue rna3 = translator.transcribeDNA("CCCCTGTCATAA");
        MyQueue proteins3 = translator.translateRNA(rna3);
        assertTrue(proteins3.isEmpty());
        MyQueue rna2 = translator.transcribeDNA("ATGCTATGT");
        MyQueue proteins2 = translator.translateRNA(rna2);
        String proteins2Str = transformString(proteins2);
        assertEquals("MLC", proteins2Str);
        MyQueue rna4 = translator.transcribeDNA("ATGATCTCGTAAATC");
        System.out.println(transformString(translator.translateRNA(rna4)));
        rna4 = translator.transcribeDNA("ATGATCTCGTAGATC");
        System.out.println(transformString(translator.translateRNA(rna4)));
        rna4 = translator.transcribeDNA("ATGATCTCGTGAATC");
        System.out.println(transformString(translator.translateRNA(rna4)));

    }
}
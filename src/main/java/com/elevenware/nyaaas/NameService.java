package com.elevenware.nyaaas;

public interface NameService {
    String getAdjectiveNounPair();
    String getAdjectiveNounPair(boolean suffixNumber);
    String alliterateOn(String s);
    String alliterateOn(String s, boolean suffixNumber);
}

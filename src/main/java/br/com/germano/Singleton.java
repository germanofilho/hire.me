package br.com.germano;

import java.util.Map;

import br.com.germano.model.Url;

public final class Singleton {
    private static final Singleton INSTANCE = new Singleton();
    private static Map<String, Url> shortenMap;

    private Singleton() {}

    public static Singleton getInstance() {
        return INSTANCE;
    }

	public static Map<String, Url> getShortenMap() {
		return shortenMap;
	}

	public static void setShortenMap(Map<String, Url> shortenMap) {
		Singleton.shortenMap = shortenMap;
	}
    
    
    
}
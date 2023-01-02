package net.myshampooisdrunk.hiddenisles.util;

public enum ArmorAbilities{
    PRIMORDIUM(200),
    PRISTINUM(1200),
    ARCONLON(1200),
    TROCELLATE(300),
    COORDIUM(900),
    DOMDECON(900),
    ASCONDELLUM(900);

    public final int cooldown;

    ArmorAbilities(int cooldown){
        this.cooldown = cooldown;
    }
}

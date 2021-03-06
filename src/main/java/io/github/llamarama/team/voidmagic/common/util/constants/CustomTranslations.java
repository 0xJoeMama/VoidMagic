package io.github.llamarama.team.voidmagic.common.util.constants;

public enum CustomTranslations {

    GUIDE_BOOK_SCREEN("book." + ModConstants.MOD_ID + ".initial");

    private final String value;

    CustomTranslations(String value) {
        this.value = value;
    }

    public String get() {
        return this.value;
    }
}

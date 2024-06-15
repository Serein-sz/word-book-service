package com.serein.wordbook.entity.enums;

import lombok.Getter;

/**
 *
 * @author 王强
 * @since 2024/6/15 20:55
 */
@Getter
public enum Language {

    AUTO("auto"),
    EN("en"),
    ZH("zh");

    private final String value;

    Language(String value) {
        this.value = value;
    }

}

package com.serein.wordbook.service;

import com.serein.wordbook.entity.enums.Language;
import com.serein.wordbook.entity.vo.TransResultVo;

import java.util.List;

/**
 *
 * @author 王强
 * @since 2024/6/15 20:49
 */
public interface TranslateService {
    List<TransResultVo> translate(String text, Language from, Language to);
}

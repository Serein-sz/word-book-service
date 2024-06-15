package com.serein.wordbook.controller;

import com.serein.wordbook.common.Response;
import com.serein.wordbook.entity.enums.Language;
import com.serein.wordbook.entity.vo.TransResultVo;
import com.serein.wordbook.service.TranslateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author 王强
 * @since 2024/6/15 20:48
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/translate")
public class TranslateController {

    private final TranslateService translateService;

    @GetMapping
    public Response<List<TransResultVo>> translate(@RequestParam String text) {
        return Response.ok(translateService.translate(text, Language.AUTO, Language.ZH));
    }
}

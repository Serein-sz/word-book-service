package com.serein.wordbook.controller;

import com.serein.wordbook.common.Response;
import com.serein.wordbook.entity.Words;
import com.serein.wordbook.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * AI chat controller
 *
 * @author 王强
 * @since 2024/6/8 08:51
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;

    @GetMapping("/split-word")
    public Response<Words> splitWord(@RequestParam String sentence) {
        return Response.ok(chatService.splitWord(sentence));
    }

}

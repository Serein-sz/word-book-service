package com.serein.wordbook.service.impl;

import com.serein.wordbook.entity.Words;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * AI chat service
 *
 * @author 王强
 * @since 2024/6/9 18:45
 */
@Service
public class ChatService {

    private final ChatClient chatClient;

    public ChatService(ChatClient.Builder builder) {
        chatClient = builder.build();
    }

    public Words splitWord(String sentence) {
        BeanOutputConverter<Words> wordsBeanOutputConverter = new BeanOutputConverter<>(Words.class);
        String format = wordsBeanOutputConverter.getFormat();
        String message = """
                请将{sentence}按照单词或词组进行分割，并获取每个单词的所有词性(Word Class like n. adv.)；
                并获取该单词这个词性对应的所有中文语义(oneWordChineseMeans content only chinese means no Word Class like n. adv.)；
                并按照顺序只返回结果，不反回任何无用的描述，如果返回其他无用描述会受到惩罚；
                {format}
                """;
        PromptTemplate promptTemplate = new PromptTemplate(message, Map.of("sentence", sentence, "format", format));
        Prompt prompt = new Prompt(promptTemplate.createMessage());
        Generation generation = chatClient.prompt(prompt).call().chatResponse().getResult();
        return wordsBeanOutputConverter.convert(generation.getOutput().getContent());
    }

}

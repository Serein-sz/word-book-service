package com.serein.wordbook.service.impl;

import cn.hutool.captcha.generator.RandomGenerator;
import cn.hutool.crypto.digest.DigestUtil;
import com.serein.wordbook.entity.enums.Language;
import com.serein.wordbook.entity.vo.BaiduTranslateResultVo;
import com.serein.wordbook.entity.vo.TransResultVo;
import com.serein.wordbook.service.TranslateService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author 王强
 * @since 2024/6/15 20:49
 */
@Service
public class BaiduTranslateServiceImpl implements TranslateService {

    @Value("${translate.baidu.appid}")
    private String appid;

    @Value("${translate.baidu.secret}")
    private String secret;

    private final WebClient client = WebClient.create("https://fanyi-api.baidu.com");

    @Override
    public List<TransResultVo> translate(String text, Language from, Language to) {
        RandomGenerator randomGenerator = new RandomGenerator("0123456789", 8);
        String salt = randomGenerator.generate();
        String sign = DigestUtil.md5Hex(appid + text + salt + secret);
        //只获取body
        Mono<BaiduTranslateResultVo> result = client.get()
                .uri(
                        "/api/trans/vip/translate?q={text}&from={from}&to={to}&appid={appid}&salt={salt}&sign={sign}",
                        text, from.getValue(), to.getValue(), appid, salt, sign
                ).accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(BaiduTranslateResultVo.class);
        return Objects.requireNonNull(result.block()).getTransResult();
    }

}

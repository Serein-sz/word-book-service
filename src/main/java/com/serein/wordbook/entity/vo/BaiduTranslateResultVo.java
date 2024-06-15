package com.serein.wordbook.entity.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 *
 * @author 王强
 * @since 2024/6/15 21:07
 */
@Data
public class BaiduTranslateResultVo {
    private String from;
    private String to;
    @JsonProperty("trans_result")
    private List<TransResultVo> transResult;
}


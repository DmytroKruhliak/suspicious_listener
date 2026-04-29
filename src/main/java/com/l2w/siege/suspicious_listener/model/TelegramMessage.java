package com.l2w.siege.suspicious_listener.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TelegramMessage {
    private Long id;
    private String type;
    private String date;

    @JsonProperty("date_unixtime")
    private String dateUnixtime;

    private String from;

    @JsonProperty("from_id")
    private String fromId;

    private String text;

    @JsonProperty("text_entities")
    private List<TextEntity> textEntities;
}

package com.l2w.siege.suspicious_listener;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.l2w.siege.suspicious_listener.model.TelegramMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ParsingTests {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testParseMessageList() throws IOException {
        String jsonContent = "[{\n" +
                "  \"id\": 1486810,\n" +
                "  \"type\": \"message\",\n" +
                "  \"date\": \"2026-04-12T09:20:00\",\n" +
                "  \"date_unixtime\": \"1775978400\",\n" +
                "  \"from\": \"Suspicious Merchant\",\n" +
                "  \"from_id\": \"user8386267802\",\n" +
                "  \"text\": \"Осада крепости Крепость Гигантов начнется через 60 минут!\",\n" +
                "  \"text_entities\": [\n" +
                "    {\n" +
                "      \"type\": \"plain\",\n" +
                "      \"text\": \"Осада крепости Крепость Гигантов начнется через 60 минут!\"\n" +
                "    }\n" +
                "  ]\n" +
                "}]";

        List<TelegramMessage> messages = objectMapper.readValue(jsonContent, new TypeReference<List<TelegramMessage>>() {});

        assertNotNull(messages);
        assertEquals(1, messages.size());
        TelegramMessage message = messages.get(0);
        assertEquals(1486810L, message.getId());
        assertEquals("message", message.getType());
        assertEquals("2026-04-12T09:20:00", message.getDate());
        assertEquals("1775978400", message.getDateUnixtime());
        assertEquals("Suspicious Merchant", message.getFrom());
        assertEquals("user8386267802", message.getFromId());
        assertEquals("Осада крепости Крепость Гигантов начнется через 60 минут!", message.getText());
        assertEquals(1, message.getTextEntities().size());
        assertEquals("plain", message.getTextEntities().get(0).getType());
    }
}

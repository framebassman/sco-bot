package tech.romashov.ash.application.bot.model.messages;

import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;

public class FakeMessage extends Message {
    public FakeMessage(String text) {
        Chat chat = new Chat();
        chat.setId(123L);
        this.setChat(chat);
        this.setText(text);
    }
}

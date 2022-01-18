package tech.romashov.model;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import tech.romashov.Bot;

import java.io.Serializable;
import java.util.ArrayDeque;

public class FakeBot extends Bot {
    private ArrayDeque<SendMessage> messages;

    public FakeBot() {
        super();
        messages = new ArrayDeque<>();
    }

    @Override
    public <T extends Serializable, Method extends BotApiMethod<T>> T execute(Method method) throws TelegramApiException {
        messages.push((SendMessage) method);
        return null;
    }

    public SendMessage getMessage() {
        return messages.pop();
    }
}

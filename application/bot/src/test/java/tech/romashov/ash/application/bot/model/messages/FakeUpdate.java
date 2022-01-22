package tech.romashov.ash.application.bot.model.messages;

import org.telegram.telegrambots.meta.api.objects.Update;

public class FakeUpdate extends Update {
    public FakeUpdate(FakeMessage message) {
        this.setMessage(message);
    }
}

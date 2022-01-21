package tech.romashov.tests;

import org.junit.Test;
import org.telegram.telegrambots.meta.api.objects.Update;
import tech.romashov.model.FakeBot;
import tech.romashov.model.messages.FakeMessage;
import tech.romashov.model.messages.FakeUpdate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ItShouldResponse {
    FakeBot bot = new FakeBot();

    @Test
    public void sendMessage_getHiRequest() throws Exception {
        Update request = new FakeUpdate(new FakeMessage("Hi"));

        bot.onUpdateReceived(request);

        assertThat(bot.getMessage().getText(), equalTo("Hi!"));
    }
}

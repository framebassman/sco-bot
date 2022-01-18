package tech.romashov.tests;

import org.junit.Test;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import tech.romashov.model.FakeBot;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ItShouldResponse {
    FakeBot bot = new FakeBot();

    @Test
    public void itWorks() throws Exception {
        Message message = new Message();
        message.setText("Hi, it's me!");
        Update request = new Update();
        request.setMessage(message);

        bot.onUpdateReceived(request);

        assertThat(bot.getMessage().getText(), equalTo("Hi!"));
    }
}

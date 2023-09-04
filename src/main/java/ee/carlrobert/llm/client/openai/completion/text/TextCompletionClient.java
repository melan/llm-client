package ee.carlrobert.llm.client.openai.completion.text;

import ee.carlrobert.llm.client.openai.OpenAIClient;
import ee.carlrobert.llm.client.openai.completion.OpenAICompletionClient;
import ee.carlrobert.llm.completion.CompletionEventListener;
import java.util.function.Consumer;

public class TextCompletionClient extends OpenAICompletionClient {

  public TextCompletionClient(OpenAIClient client) {
    super(client, "/v1/completions");
  }

  @Override
  protected TextCompletionEventSourceListener getEventListener(
      CompletionEventListener listeners,
      boolean retryOnReadTimeout,
      Consumer<String> onRetry) {
    return new TextCompletionEventSourceListener(listeners, retryOnReadTimeout, onRetry);
  }
}

package concurrency.t02_thread_sync_basic.r05_condition_lock;

public class FileMock {
  private String[] content;
  private int index;

  public FileMock(int size, int length) {
    content = new String[size];
    for (int i = 0; i < size; i++) {
      StringBuffer buffer = new StringBuffer(length);
      for (int j = 0; j < length; j++) {
        int randomCharacter = (int) Math.random()*255;
        buffer.append(randomCharacter);
      }
      content[i] = buffer.toString();
    }
    index = 0;
  }

  public boolean hasMoreLines() {
    return index < content.length;
  }

  public String getLine() {
    if (hasMoreLines()) {
      System.out.printf("Mock: %d\n", content.length - index);
      return content[index++];
    }
    return null;
  }
}

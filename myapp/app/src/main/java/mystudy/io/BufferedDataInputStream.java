package mystudy.io;

import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedDataInputStream extends DataInputStream {

  int size;
  int cursor;
  private byte[] buffer = new byte[8192];

  public BufferedDataInputStream(String name) throws FileNotFoundException {
    super(name);
  }

  // 읽고 난 다음에 몇바이트 읽었는지 size에 잘 저장해야한다.
  @Override
  public int read() throws IOException {
    if (cursor == size) {
      cursor = 0;
      size = super.read(buffer);  //오버라이딩 전에 read를 호출한다.
      if (size == -1) {
        return -1;      //더이상 읽은것이 없다.
      }
    }
    // 0xff 적어주는 이유는 8바이트로 변환될때 앞자리가 1이 되면 음수로 되어버린다!!
    return buffer[cursor++] & 0xff;  //커서랑 사이즈랑 같을때까지 반복!  코드 적을때 주의하자!!
  }

  @Override
  public int read(byte[] arr) throws IOException {
    return read(arr, 0, arr.length);
  }

  @Override
  public int read(byte[] arr, int off, int len) throws IOException {
    for (int i = off, count = 0; count < len; i++, count++) {
      int b = read();
      if (b == -1) {
        return count > 0 ? count : -1;     // 현재까지 읽은것을 리턴한다.
      }
      arr[i] = (byte) b;
    }
    return len;
  }
}

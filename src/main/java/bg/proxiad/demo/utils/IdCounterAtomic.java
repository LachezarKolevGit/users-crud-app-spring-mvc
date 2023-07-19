package bg.proxiad.demo.utils;

import java.util.concurrent.atomic.AtomicLong;

public class IdCounterAtomic {

  private static AtomicLong counterAtomicLong = new AtomicLong(0);

  public static Long assignId() {
    return counterAtomicLong.incrementAndGet();
  }
}

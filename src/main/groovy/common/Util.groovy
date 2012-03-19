package common

class Util {
  
  static void log(msg) {
    println("[" + Thread.currentThread().name + "] " + msg)
  }

}

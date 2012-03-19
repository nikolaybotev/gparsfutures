package activeobjects

import static common.Util.log
import groovyx.gpars.activeobject.ActiveObject
import groovyx.gpars.activeobject.ActiveMethod

@ActiveObject("service")
class ServiceActor {

  private int process(int x) { return x*x }

  @ActiveMethod
  def act(int x) {
    try {
      log("Service enter")
      return process(x)
    } finally {
      log("Service leave")
    }
  }

}

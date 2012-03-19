package activeobjects

import static common.Util.log
import groovyx.gpars.activeobject.ActiveObject
import groovyx.gpars.activeobject.ActiveMethod
import groovyx.gpars.actor.DefaultActor
import groovyx.gpars.dataflow.Promise

@ActiveObject("client")
class ClientActor {

  @ActiveMethod
  def go(ServiceActor other) {
    log("Client enter")
    Promise future = other.act(10)
    future.then { x ->
      // This executes on a separate thread
      log("Client got future result " + x)
      this.msg(x)
      Thread.sleep(1000)
      log("Client future callback done.")
    }
    other.act(5)
    log("Client leave")
  }
  
  @ActiveMethod
  def msg(msg) {
    log("Client got message " + msg)
  }

}

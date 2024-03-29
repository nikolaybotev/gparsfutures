package promises

import static common.Util.log
import groovyx.gpars.actor.Actor
import groovyx.gpars.actor.DefaultActor
import groovyx.gpars.dataflow.Promise

class ClientActor extends DefaultActor {

  void act() {
    loop {
      react { msg ->
        if (msg instanceof Actor) {
          final Actor other = (Actor) msg
          log("Client enter")
          Promise future = other.sendAndPromise(10)
          future.then { x ->
            // This executes on a separate thread
            log("Client got future result " + x)
            this.send(x)
            Thread.sleep(1000)
            log("Client future callback done.")
          }
          other.send(5)
          log("Client leave")
        } else {
          log("Client got message " + msg)
        }
      }
    }
  }

}

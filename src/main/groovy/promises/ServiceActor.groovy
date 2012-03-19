package promises

import static common.Util.log
import groovyx.gpars.actor.DefaultActor

class ServiceActor extends DefaultActor {

  int process(int x) { return x*x }

  void act() {
    loop {
      react { int x ->
        log("Service enter")
        sender.send(process(x))
        log("Service leave")
      }
    }
  }

}

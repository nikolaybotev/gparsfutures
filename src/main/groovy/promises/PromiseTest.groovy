package promises

import groovyx.gpars.actor.Actor
import groovyx.gpars.group.DefaultPGroup

class PromiseTest {

  static main(args) {
    print "Hello "
    println "world"

    Actor service = new ServiceActor()
    service.setParallelGroup(new DefaultPGroup(1))
    service.start()

    Actor client = new ClientActor()
    client.setParallelGroup(new DefaultPGroup(1))
    client.start()

    client.send(service)

    client.join()
  }

}

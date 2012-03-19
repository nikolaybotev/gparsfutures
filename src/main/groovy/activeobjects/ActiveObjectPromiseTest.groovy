package activeobjects

import groovyx.gpars.activeobject.ActiveObjectRegistry
import groovyx.gpars.actor.Actor
import groovyx.gpars.group.DefaultPGroup

class ActiveObjectPromiseTest {

  static main(args) {
    ActiveObjectRegistry.instance.register("client", new DefaultPGroup(1))
    ActiveObjectRegistry.instance.register("service", new DefaultPGroup(1))
    
    ServiceActor service = new ServiceActor()

    ClientActor client = new ClientActor()

    client.go(service)

    Thread.sleep(10000)
  }

}
